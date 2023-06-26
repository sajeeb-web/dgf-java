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

import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf loc subdistrict service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.dgfLocSubdistrictPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocSubdistrictPersistence
 * @generated
 */
public class dgfLocSubdistrictUtil {

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
	public static void clearCache(dgfLocSubdistrict dgfLocSubdistrict) {
		getPersistence().clearCache(dgfLocSubdistrict);
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
	public static Map<Serializable, dgfLocSubdistrict> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<dgfLocSubdistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<dgfLocSubdistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<dgfLocSubdistrict> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static dgfLocSubdistrict update(
		dgfLocSubdistrict dgfLocSubdistrict) {

		return getPersistence().update(dgfLocSubdistrict);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static dgfLocSubdistrict update(
		dgfLocSubdistrict dgfLocSubdistrict, ServiceContext serviceContext) {

		return getPersistence().update(dgfLocSubdistrict, serviceContext);
	}

	/**
	 * Returns all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId) {

		return getPersistence().findBydisWiseSubDisFinder(districtId);
	}

	/**
	 * Returns a range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of matching dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end) {

		return getPersistence().findBydisWiseSubDisFinder(
			districtId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return getPersistence().findBydisWiseSubDisFinder(
			districtId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydisWiseSubDisFinder(
			districtId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	public static dgfLocSubdistrict findBydisWiseSubDisFinder_First(
			long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocSubdistrictException {

		return getPersistence().findBydisWiseSubDisFinder_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	public static dgfLocSubdistrict fetchBydisWiseSubDisFinder_First(
		long districtId,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return getPersistence().fetchBydisWiseSubDisFinder_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	public static dgfLocSubdistrict findBydisWiseSubDisFinder_Last(
			long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocSubdistrictException {

		return getPersistence().findBydisWiseSubDisFinder_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	public static dgfLocSubdistrict fetchBydisWiseSubDisFinder_Last(
		long districtId,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return getPersistence().fetchBydisWiseSubDisFinder_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the dgf loc subdistricts before and after the current dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc subdistrict
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public static dgfLocSubdistrict[] findBydisWiseSubDisFinder_PrevAndNext(
			long id, long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocSubdistrictException {

		return getPersistence().findBydisWiseSubDisFinder_PrevAndNext(
			id, districtId, orderByComparator);
	}

	/**
	 * Removes all the dgf loc subdistricts where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public static void removeBydisWiseSubDisFinder(long districtId) {
		getPersistence().removeBydisWiseSubDisFinder(districtId);
	}

	/**
	 * Returns the number of dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching dgf loc subdistricts
	 */
	public static int countBydisWiseSubDisFinder(long districtId) {
		return getPersistence().countBydisWiseSubDisFinder(districtId);
	}

	/**
	 * Caches the dgf loc subdistrict in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 */
	public static void cacheResult(dgfLocSubdistrict dgfLocSubdistrict) {
		getPersistence().cacheResult(dgfLocSubdistrict);
	}

	/**
	 * Caches the dgf loc subdistricts in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistricts the dgf loc subdistricts
	 */
	public static void cacheResult(List<dgfLocSubdistrict> dgfLocSubdistricts) {
		getPersistence().cacheResult(dgfLocSubdistricts);
	}

	/**
	 * Creates a new dgf loc subdistrict with the primary key. Does not add the dgf loc subdistrict to the database.
	 *
	 * @param id the primary key for the new dgf loc subdistrict
	 * @return the new dgf loc subdistrict
	 */
	public static dgfLocSubdistrict create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf loc subdistrict with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public static dgfLocSubdistrict remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocSubdistrictException {

		return getPersistence().remove(id);
	}

	public static dgfLocSubdistrict updateImpl(
		dgfLocSubdistrict dgfLocSubdistrict) {

		return getPersistence().updateImpl(dgfLocSubdistrict);
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key or throws a <code>NoSuchdgfLocSubdistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public static dgfLocSubdistrict findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocSubdistrictException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict, or <code>null</code> if a dgf loc subdistrict with the primary key could not be found
	 */
	public static dgfLocSubdistrict fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf loc subdistricts.
	 *
	 * @return the dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc subdistricts
	 */
	public static List<dgfLocSubdistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf loc subdistricts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf loc subdistricts.
	 *
	 * @return the number of dgf loc subdistricts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static dgfLocSubdistrictPersistence getPersistence() {
		return _persistence;
	}

	private static volatile dgfLocSubdistrictPersistence _persistence;

}