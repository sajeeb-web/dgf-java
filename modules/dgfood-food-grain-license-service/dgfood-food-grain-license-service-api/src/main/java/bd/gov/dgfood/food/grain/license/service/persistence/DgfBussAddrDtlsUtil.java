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

import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf buss addr dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfBussAddrDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtlsPersistence
 * @generated
 */
public class DgfBussAddrDtlsUtil {

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
	public static void clearCache(DgfBussAddrDtls dgfBussAddrDtls) {
		getPersistence().clearCache(dgfBussAddrDtls);
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
	public static Map<Serializable, DgfBussAddrDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfBussAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfBussAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfBussAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfBussAddrDtls update(DgfBussAddrDtls dgfBussAddrDtls) {
		return getPersistence().update(dgfBussAddrDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfBussAddrDtls update(
		DgfBussAddrDtls dgfBussAddrDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfBussAddrDtls, serviceContext);
	}

	/**
	 * Returns all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_First(
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict_First(
			businessDistrict, orderByComparator);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls
		fetchBydgfBussAddrDtlsByBusinessDistrict_First(
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessDistrict_First(
			businessDistrict, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_Last(
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessDistrict_Last(
			businessDistrict, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessDistrict_Last(
		long businessDistrict,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessDistrict_Last(
			businessDistrict, orderByComparator);
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				long businessAddressId, long businessDistrict,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().
			findBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				businessAddressId, businessDistrict, orderByComparator);
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessDistrict = &#63; from the database.
	 *
	 * @param businessDistrict the business district
	 */
	public static void removeBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict) {

		getPersistence().removeBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict);
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the number of matching dgf buss addr dtlses
	 */
	public static int countBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict) {

		return getPersistence().countBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict);
	}

	/**
	 * Returns all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_First(
			long businessUpzilla,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla_First(
			businessUpzilla, orderByComparator);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_First(
		long businessUpzilla,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessUpzilla_First(
			businessUpzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_Last(
			long businessUpzilla,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUpzilla_Last(
			businessUpzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_Last(
		long businessUpzilla,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessUpzilla_Last(
			businessUpzilla, orderByComparator);
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
				long businessAddressId, long businessUpzilla,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().
			findBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
				businessAddressId, businessUpzilla, orderByComparator);
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessUpzilla = &#63; from the database.
	 *
	 * @param businessUpzilla the business upzilla
	 */
	public static void removeBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla) {

		getPersistence().removeBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla);
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the number of matching dgf buss addr dtlses
	 */
	public static int countBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla) {

		return getPersistence().countBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla);
	}

	/**
	 * Returns all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(long businessUnionName) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end,
			OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end,
			OrderByComparator<DgfBussAddrDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls
			findBydgfBussAddrDtlsByBusinessUnionName_First(
				long businessUnionName,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName_First(
			businessUnionName, orderByComparator);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls
		fetchBydgfBussAddrDtlsByBusinessUnionName_First(
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessUnionName_First(
			businessUnionName, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUnionName_Last(
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessUnionName_Last(
			businessUnionName, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls
		fetchBydgfBussAddrDtlsByBusinessUnionName_Last(
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessUnionName_Last(
			businessUnionName, orderByComparator);
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				long businessAddressId, long businessUnionName,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().
			findBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				businessAddressId, businessUnionName, orderByComparator);
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessUnionName = &#63; from the database.
	 *
	 * @param businessUnionName the business union name
	 */
	public static void removeBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName) {

		getPersistence().removeBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName);
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the number of matching dgf buss addr dtlses
	 */
	public static int countBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName) {

		return getPersistence().countBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName);
	}

	/**
	 * Returns all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard(
			businessWard);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard(
			businessWard, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard(
			businessWard, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard(
			businessWard, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_First(
			String businessWard,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard_First(
			businessWard, orderByComparator);
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_First(
		String businessWard,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessWard_First(
			businessWard, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_Last(
			String businessWard,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard_Last(
			businessWard, orderByComparator);
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public static DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_Last(
		String businessWard,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfBussAddrDtlsByBusinessWard_Last(
			businessWard, orderByComparator);
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
				long businessAddressId, String businessWard,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
			businessAddressId, businessWard, orderByComparator);
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessWard = &#63; from the database.
	 *
	 * @param businessWard the business ward
	 */
	public static void removeBydgfBussAddrDtlsByBusinessWard(
		String businessWard) {

		getPersistence().removeBydgfBussAddrDtlsByBusinessWard(businessWard);
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the number of matching dgf buss addr dtlses
	 */
	public static int countBydgfBussAddrDtlsByBusinessWard(
		String businessWard) {

		return getPersistence().countBydgfBussAddrDtlsByBusinessWard(
			businessWard);
	}

	/**
	 * Caches the dgf buss addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 */
	public static void cacheResult(DgfBussAddrDtls dgfBussAddrDtls) {
		getPersistence().cacheResult(dgfBussAddrDtls);
	}

	/**
	 * Caches the dgf buss addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtlses the dgf buss addr dtlses
	 */
	public static void cacheResult(List<DgfBussAddrDtls> dgfBussAddrDtlses) {
		getPersistence().cacheResult(dgfBussAddrDtlses);
	}

	/**
	 * Creates a new dgf buss addr dtls with the primary key. Does not add the dgf buss addr dtls to the database.
	 *
	 * @param businessAddressId the primary key for the new dgf buss addr dtls
	 * @return the new dgf buss addr dtls
	 */
	public static DgfBussAddrDtls create(long businessAddressId) {
		return getPersistence().create(businessAddressId);
	}

	/**
	 * Removes the dgf buss addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls remove(long businessAddressId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().remove(businessAddressId);
	}

	public static DgfBussAddrDtls updateImpl(DgfBussAddrDtls dgfBussAddrDtls) {
		return getPersistence().updateImpl(dgfBussAddrDtls);
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key or throws a <code>NoSuchDgfBussAddrDtlsException</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls findByPrimaryKey(long businessAddressId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBussAddrDtlsException {

		return getPersistence().findByPrimaryKey(businessAddressId);
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls, or <code>null</code> if a dgf buss addr dtls with the primary key could not be found
	 */
	public static DgfBussAddrDtls fetchByPrimaryKey(long businessAddressId) {
		return getPersistence().fetchByPrimaryKey(businessAddressId);
	}

	/**
	 * Returns all the dgf buss addr dtlses.
	 *
	 * @return the dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf buss addr dtlses
	 */
	public static List<DgfBussAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf buss addr dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf buss addr dtlses.
	 *
	 * @return the number of dgf buss addr dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfBussAddrDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfBussAddrDtlsPersistence _persistence;

}