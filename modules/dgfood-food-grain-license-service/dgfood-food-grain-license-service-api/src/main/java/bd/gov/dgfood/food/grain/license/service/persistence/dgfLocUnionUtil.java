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

import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf loc union service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.dgfLocUnionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnionPersistence
 * @generated
 */
public class dgfLocUnionUtil {

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
	public static void clearCache(dgfLocUnion dgfLocUnion) {
		getPersistence().clearCache(dgfLocUnion);
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
	public static Map<Serializable, dgfLocUnion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<dgfLocUnion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<dgfLocUnion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<dgfLocUnion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<dgfLocUnion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static dgfLocUnion update(dgfLocUnion dgfLocUnion) {
		return getPersistence().update(dgfLocUnion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static dgfLocUnion update(
		dgfLocUnion dgfLocUnion, ServiceContext serviceContext) {

		return getPersistence().update(dgfLocUnion, serviceContext);
	}

	/**
	 * Returns all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the matching dgf loc unions
	 */
	public static List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId) {

		return getPersistence().findBysubDisWiseUnFinder(subdistrictId);
	}

	/**
	 * Returns a range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of matching dgf loc unions
	 */
	public static List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end) {

		return getPersistence().findBysubDisWiseUnFinder(
			subdistrictId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc unions
	 */
	public static List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		OrderByComparator<dgfLocUnion> orderByComparator) {

		return getPersistence().findBysubDisWiseUnFinder(
			subdistrictId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc unions
	 */
	public static List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		OrderByComparator<dgfLocUnion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysubDisWiseUnFinder(
			subdistrictId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	public static dgfLocUnion findBysubDisWiseUnFinder_First(
			long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocUnionException {

		return getPersistence().findBysubDisWiseUnFinder_First(
			subdistrictId, orderByComparator);
	}

	/**
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	public static dgfLocUnion fetchBysubDisWiseUnFinder_First(
		long subdistrictId, OrderByComparator<dgfLocUnion> orderByComparator) {

		return getPersistence().fetchBysubDisWiseUnFinder_First(
			subdistrictId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	public static dgfLocUnion findBysubDisWiseUnFinder_Last(
			long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocUnionException {

		return getPersistence().findBysubDisWiseUnFinder_Last(
			subdistrictId, orderByComparator);
	}

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	public static dgfLocUnion fetchBysubDisWiseUnFinder_Last(
		long subdistrictId, OrderByComparator<dgfLocUnion> orderByComparator) {

		return getPersistence().fetchBysubDisWiseUnFinder_Last(
			subdistrictId, orderByComparator);
	}

	/**
	 * Returns the dgf loc unions before and after the current dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc union
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public static dgfLocUnion[] findBysubDisWiseUnFinder_PrevAndNext(
			long id, long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocUnionException {

		return getPersistence().findBysubDisWiseUnFinder_PrevAndNext(
			id, subdistrictId, orderByComparator);
	}

	/**
	 * Removes all the dgf loc unions where subdistrictId = &#63; from the database.
	 *
	 * @param subdistrictId the subdistrict ID
	 */
	public static void removeBysubDisWiseUnFinder(long subdistrictId) {
		getPersistence().removeBysubDisWiseUnFinder(subdistrictId);
	}

	/**
	 * Returns the number of dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the number of matching dgf loc unions
	 */
	public static int countBysubDisWiseUnFinder(long subdistrictId) {
		return getPersistence().countBysubDisWiseUnFinder(subdistrictId);
	}

	/**
	 * Caches the dgf loc union in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnion the dgf loc union
	 */
	public static void cacheResult(dgfLocUnion dgfLocUnion) {
		getPersistence().cacheResult(dgfLocUnion);
	}

	/**
	 * Caches the dgf loc unions in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnions the dgf loc unions
	 */
	public static void cacheResult(List<dgfLocUnion> dgfLocUnions) {
		getPersistence().cacheResult(dgfLocUnions);
	}

	/**
	 * Creates a new dgf loc union with the primary key. Does not add the dgf loc union to the database.
	 *
	 * @param id the primary key for the new dgf loc union
	 * @return the new dgf loc union
	 */
	public static dgfLocUnion create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf loc union with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union that was removed
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public static dgfLocUnion remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocUnionException {

		return getPersistence().remove(id);
	}

	public static dgfLocUnion updateImpl(dgfLocUnion dgfLocUnion) {
		return getPersistence().updateImpl(dgfLocUnion);
	}

	/**
	 * Returns the dgf loc union with the primary key or throws a <code>NoSuchdgfLocUnionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public static dgfLocUnion findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocUnionException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf loc union with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union, or <code>null</code> if a dgf loc union with the primary key could not be found
	 */
	public static dgfLocUnion fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf loc unions.
	 *
	 * @return the dgf loc unions
	 */
	public static List<dgfLocUnion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of dgf loc unions
	 */
	public static List<dgfLocUnion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc unions
	 */
	public static List<dgfLocUnion> findAll(
		int start, int end, OrderByComparator<dgfLocUnion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc unions
	 */
	public static List<dgfLocUnion> findAll(
		int start, int end, OrderByComparator<dgfLocUnion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf loc unions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf loc unions.
	 *
	 * @return the number of dgf loc unions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static dgfLocUnionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile dgfLocUnionPersistence _persistence;

}