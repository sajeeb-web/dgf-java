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

import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf loc district service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.dgfLocDistrictPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrictPersistence
 * @generated
 */
public class dgfLocDistrictUtil {

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
	public static void clearCache(dgfLocDistrict dgfLocDistrict) {
		getPersistence().clearCache(dgfLocDistrict);
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
	public static Map<Serializable, dgfLocDistrict> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<dgfLocDistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<dgfLocDistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<dgfLocDistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static dgfLocDistrict update(dgfLocDistrict dgfLocDistrict) {
		return getPersistence().update(dgfLocDistrict);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static dgfLocDistrict update(
		dgfLocDistrict dgfLocDistrict, ServiceContext serviceContext) {

		return getPersistence().update(dgfLocDistrict, serviceContext);
	}

	/**
	 * Returns all the dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the matching dgf loc districts
	 */
	public static List<dgfLocDistrict> findBydivWiseDisFinder(long divisionId) {
		return getPersistence().findBydivWiseDisFinder(divisionId);
	}

	/**
	 * Returns a range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of matching dgf loc districts
	 */
	public static List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end) {

		return getPersistence().findBydivWiseDisFinder(divisionId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc districts
	 */
	public static List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator) {

		return getPersistence().findBydivWiseDisFinder(
			divisionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc districts
	 */
	public static List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydivWiseDisFinder(
			divisionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	public static dgfLocDistrict findBydivWiseDisFinder_First(
			long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDistrictException {

		return getPersistence().findBydivWiseDisFinder_First(
			divisionId, orderByComparator);
	}

	/**
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	public static dgfLocDistrict fetchBydivWiseDisFinder_First(
		long divisionId, OrderByComparator<dgfLocDistrict> orderByComparator) {

		return getPersistence().fetchBydivWiseDisFinder_First(
			divisionId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	public static dgfLocDistrict findBydivWiseDisFinder_Last(
			long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDistrictException {

		return getPersistence().findBydivWiseDisFinder_Last(
			divisionId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	public static dgfLocDistrict fetchBydivWiseDisFinder_Last(
		long divisionId, OrderByComparator<dgfLocDistrict> orderByComparator) {

		return getPersistence().fetchBydivWiseDisFinder_Last(
			divisionId, orderByComparator);
	}

	/**
	 * Returns the dgf loc districts before and after the current dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc district
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public static dgfLocDistrict[] findBydivWiseDisFinder_PrevAndNext(
			long id, long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDistrictException {

		return getPersistence().findBydivWiseDisFinder_PrevAndNext(
			id, divisionId, orderByComparator);
	}

	/**
	 * Removes all the dgf loc districts where divisionId = &#63; from the database.
	 *
	 * @param divisionId the division ID
	 */
	public static void removeBydivWiseDisFinder(long divisionId) {
		getPersistence().removeBydivWiseDisFinder(divisionId);
	}

	/**
	 * Returns the number of dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the number of matching dgf loc districts
	 */
	public static int countBydivWiseDisFinder(long divisionId) {
		return getPersistence().countBydivWiseDisFinder(divisionId);
	}

	/**
	 * Caches the dgf loc district in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistrict the dgf loc district
	 */
	public static void cacheResult(dgfLocDistrict dgfLocDistrict) {
		getPersistence().cacheResult(dgfLocDistrict);
	}

	/**
	 * Caches the dgf loc districts in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistricts the dgf loc districts
	 */
	public static void cacheResult(List<dgfLocDistrict> dgfLocDistricts) {
		getPersistence().cacheResult(dgfLocDistricts);
	}

	/**
	 * Creates a new dgf loc district with the primary key. Does not add the dgf loc district to the database.
	 *
	 * @param id the primary key for the new dgf loc district
	 * @return the new dgf loc district
	 */
	public static dgfLocDistrict create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public static dgfLocDistrict remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDistrictException {

		return getPersistence().remove(id);
	}

	public static dgfLocDistrict updateImpl(dgfLocDistrict dgfLocDistrict) {
		return getPersistence().updateImpl(dgfLocDistrict);
	}

	/**
	 * Returns the dgf loc district with the primary key or throws a <code>NoSuchdgfLocDistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public static dgfLocDistrict findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDistrictException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf loc district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district, or <code>null</code> if a dgf loc district with the primary key could not be found
	 */
	public static dgfLocDistrict fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf loc districts.
	 *
	 * @return the dgf loc districts
	 */
	public static List<dgfLocDistrict> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of dgf loc districts
	 */
	public static List<dgfLocDistrict> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc districts
	 */
	public static List<dgfLocDistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc districts
	 */
	public static List<dgfLocDistrict> findAll(
		int start, int end, OrderByComparator<dgfLocDistrict> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf loc districts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf loc districts.
	 *
	 * @return the number of dgf loc districts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static dgfLocDistrictPersistence getPersistence() {
		return _persistence;
	}

	private static volatile dgfLocDistrictPersistence _persistence;

}