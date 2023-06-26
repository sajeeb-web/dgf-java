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

import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf loc division service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.dgfLocDivisionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDivisionPersistence
 * @generated
 */
public class dgfLocDivisionUtil {

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
	public static void clearCache(dgfLocDivision dgfLocDivision) {
		getPersistence().clearCache(dgfLocDivision);
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
	public static Map<Serializable, dgfLocDivision> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<dgfLocDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<dgfLocDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<dgfLocDivision> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<dgfLocDivision> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static dgfLocDivision update(dgfLocDivision dgfLocDivision) {
		return getPersistence().update(dgfLocDivision);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static dgfLocDivision update(
		dgfLocDivision dgfLocDivision, ServiceContext serviceContext) {

		return getPersistence().update(dgfLocDivision, serviceContext);
	}

	/**
	 * Caches the dgf loc division in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivision the dgf loc division
	 */
	public static void cacheResult(dgfLocDivision dgfLocDivision) {
		getPersistence().cacheResult(dgfLocDivision);
	}

	/**
	 * Caches the dgf loc divisions in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivisions the dgf loc divisions
	 */
	public static void cacheResult(List<dgfLocDivision> dgfLocDivisions) {
		getPersistence().cacheResult(dgfLocDivisions);
	}

	/**
	 * Creates a new dgf loc division with the primary key. Does not add the dgf loc division to the database.
	 *
	 * @param id the primary key for the new dgf loc division
	 * @return the new dgf loc division
	 */
	public static dgfLocDivision create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf loc division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division that was removed
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	public static dgfLocDivision remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDivisionException {

		return getPersistence().remove(id);
	}

	public static dgfLocDivision updateImpl(dgfLocDivision dgfLocDivision) {
		return getPersistence().updateImpl(dgfLocDivision);
	}

	/**
	 * Returns the dgf loc division with the primary key or throws a <code>NoSuchdgfLocDivisionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	public static dgfLocDivision findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchdgfLocDivisionException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf loc division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division, or <code>null</code> if a dgf loc division with the primary key could not be found
	 */
	public static dgfLocDivision fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf loc divisions.
	 *
	 * @return the dgf loc divisions
	 */
	public static List<dgfLocDivision> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @return the range of dgf loc divisions
	 */
	public static List<dgfLocDivision> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc divisions
	 */
	public static List<dgfLocDivision> findAll(
		int start, int end,
		OrderByComparator<dgfLocDivision> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc divisions
	 */
	public static List<dgfLocDivision> findAll(
		int start, int end, OrderByComparator<dgfLocDivision> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf loc divisions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf loc divisions.
	 *
	 * @return the number of dgf loc divisions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static dgfLocDivisionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile dgfLocDivisionPersistence _persistence;

}