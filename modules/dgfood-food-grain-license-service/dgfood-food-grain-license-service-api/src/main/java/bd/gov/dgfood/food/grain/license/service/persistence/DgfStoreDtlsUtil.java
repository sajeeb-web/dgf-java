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

import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf store dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfStoreDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtlsPersistence
 * @generated
 */
public class DgfStoreDtlsUtil {

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
	public static void clearCache(DgfStoreDtls dgfStoreDtls) {
		getPersistence().clearCache(dgfStoreDtls);
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
	public static Map<Serializable, DgfStoreDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfStoreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfStoreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfStoreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfStoreDtls update(DgfStoreDtls dgfStoreDtls) {
		return getPersistence().update(dgfStoreDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfStoreDtls update(
		DgfStoreDtls dgfStoreDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfStoreDtls, serviceContext);
	}

	/**
	 * Returns the dgf store dtls where type = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsFindByType(String type)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsFindByType(type);
	}

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsFindByType(String type) {
		return getPersistence().fetchByDgfStoreDtlsFindByType(type);
	}

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsFindByType(
		String type, boolean useFinderCache) {

		return getPersistence().fetchByDgfStoreDtlsFindByType(
			type, useFinderCache);
	}

	/**
	 * Removes the dgf store dtls where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the dgf store dtls that was removed
	 */
	public static DgfStoreDtls removeByDgfStoreDtlsFindByType(String type)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().removeByDgfStoreDtlsFindByType(type);
	}

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	public static int countByDgfStoreDtlsFindByType(String type) {
		return getPersistence().countByDgfStoreDtlsFindByType(type);
	}

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsFindByNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsFindByNid(nationalId);
	}

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsFindByNid(String nationalId) {
		return getPersistence().fetchByDgfStoreDtlsFindByNid(nationalId);
	}

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsFindByNid(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByDgfStoreDtlsFindByNid(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf store dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf store dtls that was removed
	 */
	public static DgfStoreDtls removeByDgfStoreDtlsFindByNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().removeByDgfStoreDtlsFindByNid(nationalId);
	}

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	public static int countByDgfStoreDtlsFindByNid(String nationalId) {
		return getPersistence().countByDgfStoreDtlsFindByNid(nationalId);
	}

	/**
	 * Returns all the dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type) {

		return getPersistence().findByDgfStoreDtlsListFindByType(type);
	}

	/**
	 * Returns a range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end) {

		return getPersistence().findByDgfStoreDtlsListFindByType(
			type, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().findByDgfStoreDtlsListFindByType(
			type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfStoreDtlsListFindByType(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsListFindByType_First(
			String type, OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByType_First(
			type, orderByComparator);
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsListFindByType_First(
		String type, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().fetchByDgfStoreDtlsListFindByType_First(
			type, orderByComparator);
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsListFindByType_Last(
			String type, OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByType_Last(
			type, orderByComparator);
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsListFindByType_Last(
		String type, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().fetchByDgfStoreDtlsListFindByType_Last(
			type, orderByComparator);
	}

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public static DgfStoreDtls[] findByDgfStoreDtlsListFindByType_PrevAndNext(
			long id, String type,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByType_PrevAndNext(
			id, type, orderByComparator);
	}

	/**
	 * Removes all the dgf store dtlses where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeByDgfStoreDtlsListFindByType(String type) {
		getPersistence().removeByDgfStoreDtlsListFindByType(type);
	}

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	public static int countByDgfStoreDtlsListFindByType(String type) {
		return getPersistence().countByDgfStoreDtlsListFindByType(type);
	}

	/**
	 * Returns all the dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId) {

		return getPersistence().findByDgfStoreDtlsListFindByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end) {

		return getPersistence().findByDgfStoreDtlsListFindByNid(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().findByDgfStoreDtlsListFindByNid(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	public static List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfStoreDtlsListFindByNid(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsListFindByNid_First(
			String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_First(
		String nationalId, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().fetchByDgfStoreDtlsListFindByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls findByDgfStoreDtlsListFindByNid_Last(
			String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public static DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_Last(
		String nationalId, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().fetchByDgfStoreDtlsListFindByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public static DgfStoreDtls[] findByDgfStoreDtlsListFindByNid_PrevAndNext(
			long id, String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByDgfStoreDtlsListFindByNid_PrevAndNext(
			id, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf store dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByDgfStoreDtlsListFindByNid(String nationalId) {
		getPersistence().removeByDgfStoreDtlsListFindByNid(nationalId);
	}

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	public static int countByDgfStoreDtlsListFindByNid(String nationalId) {
		return getPersistence().countByDgfStoreDtlsListFindByNid(nationalId);
	}

	/**
	 * Caches the dgf store dtls in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 */
	public static void cacheResult(DgfStoreDtls dgfStoreDtls) {
		getPersistence().cacheResult(dgfStoreDtls);
	}

	/**
	 * Caches the dgf store dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtlses the dgf store dtlses
	 */
	public static void cacheResult(List<DgfStoreDtls> dgfStoreDtlses) {
		getPersistence().cacheResult(dgfStoreDtlses);
	}

	/**
	 * Creates a new dgf store dtls with the primary key. Does not add the dgf store dtls to the database.
	 *
	 * @param id the primary key for the new dgf store dtls
	 * @return the new dgf store dtls
	 */
	public static DgfStoreDtls create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf store dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls that was removed
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public static DgfStoreDtls remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().remove(id);
	}

	public static DgfStoreDtls updateImpl(DgfStoreDtls dgfStoreDtls) {
		return getPersistence().updateImpl(dgfStoreDtls);
	}

	/**
	 * Returns the dgf store dtls with the primary key or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public static DgfStoreDtls findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfStoreDtlsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf store dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls, or <code>null</code> if a dgf store dtls with the primary key could not be found
	 */
	public static DgfStoreDtls fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf store dtlses.
	 *
	 * @return the dgf store dtlses
	 */
	public static List<DgfStoreDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of dgf store dtlses
	 */
	public static List<DgfStoreDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf store dtlses
	 */
	public static List<DgfStoreDtls> findAll(
		int start, int end, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf store dtlses
	 */
	public static List<DgfStoreDtls> findAll(
		int start, int end, OrderByComparator<DgfStoreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf store dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf store dtlses.
	 *
	 * @return the number of dgf store dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfStoreDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfStoreDtlsPersistence _persistence;

}