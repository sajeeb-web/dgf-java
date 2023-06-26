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

import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the licns user regs service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.licnsUserRegsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegsPersistence
 * @generated
 */
public class licnsUserRegsUtil {

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
	public static void clearCache(licnsUserRegs licnsUserRegs) {
		getPersistence().clearCache(licnsUserRegs);
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
	public static Map<Serializable, licnsUserRegs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<licnsUserRegs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<licnsUserRegs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<licnsUserRegs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<licnsUserRegs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static licnsUserRegs update(licnsUserRegs licnsUserRegs) {
		return getPersistence().update(licnsUserRegs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static licnsUserRegs update(
		licnsUserRegs licnsUserRegs, ServiceContext serviceContext) {

		return getPersistence().update(licnsUserRegs, serviceContext);
	}

	/**
	 * Returns the licns user regs where nationalId = &#63; or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs
	 * @throws NoSuchlicnsUserRegsException if a matching licns user regs could not be found
	 */
	public static licnsUserRegs findBylicnsUserRegsNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchlicnsUserRegsException {

		return getPersistence().findBylicnsUserRegsNid(nationalId);
	}

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	public static licnsUserRegs fetchBylicnsUserRegsNid(String nationalId) {
		return getPersistence().fetchBylicnsUserRegsNid(nationalId);
	}

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	public static licnsUserRegs fetchBylicnsUserRegsNid(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchBylicnsUserRegsNid(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the licns user regs where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the licns user regs that was removed
	 */
	public static licnsUserRegs removeBylicnsUserRegsNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchlicnsUserRegsException {

		return getPersistence().removeBylicnsUserRegsNid(nationalId);
	}

	/**
	 * Returns the number of licns user regses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching licns user regses
	 */
	public static int countBylicnsUserRegsNid(String nationalId) {
		return getPersistence().countBylicnsUserRegsNid(nationalId);
	}

	/**
	 * Caches the licns user regs in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegs the licns user regs
	 */
	public static void cacheResult(licnsUserRegs licnsUserRegs) {
		getPersistence().cacheResult(licnsUserRegs);
	}

	/**
	 * Caches the licns user regses in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegses the licns user regses
	 */
	public static void cacheResult(List<licnsUserRegs> licnsUserRegses) {
		getPersistence().cacheResult(licnsUserRegses);
	}

	/**
	 * Creates a new licns user regs with the primary key. Does not add the licns user regs to the database.
	 *
	 * @param licUserId the primary key for the new licns user regs
	 * @return the new licns user regs
	 */
	public static licnsUserRegs create(long licUserId) {
		return getPersistence().create(licUserId);
	}

	/**
	 * Removes the licns user regs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs that was removed
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	public static licnsUserRegs remove(long licUserId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchlicnsUserRegsException {

		return getPersistence().remove(licUserId);
	}

	public static licnsUserRegs updateImpl(licnsUserRegs licnsUserRegs) {
		return getPersistence().updateImpl(licnsUserRegs);
	}

	/**
	 * Returns the licns user regs with the primary key or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	public static licnsUserRegs findByPrimaryKey(long licUserId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchlicnsUserRegsException {

		return getPersistence().findByPrimaryKey(licUserId);
	}

	/**
	 * Returns the licns user regs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs, or <code>null</code> if a licns user regs with the primary key could not be found
	 */
	public static licnsUserRegs fetchByPrimaryKey(long licUserId) {
		return getPersistence().fetchByPrimaryKey(licUserId);
	}

	/**
	 * Returns all the licns user regses.
	 *
	 * @return the licns user regses
	 */
	public static List<licnsUserRegs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @return the range of licns user regses
	 */
	public static List<licnsUserRegs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licns user regses
	 */
	public static List<licnsUserRegs> findAll(
		int start, int end,
		OrderByComparator<licnsUserRegs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licns user regses
	 */
	public static List<licnsUserRegs> findAll(
		int start, int end, OrderByComparator<licnsUserRegs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the licns user regses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of licns user regses.
	 *
	 * @return the number of licns user regses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static licnsUserRegsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile licnsUserRegsPersistence _persistence;

}