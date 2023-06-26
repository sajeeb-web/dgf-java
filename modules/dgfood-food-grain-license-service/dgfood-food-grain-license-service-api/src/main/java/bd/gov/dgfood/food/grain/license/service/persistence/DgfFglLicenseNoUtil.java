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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf fgl license no service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfFglLicenseNoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNoPersistence
 * @generated
 */
public class DgfFglLicenseNoUtil {

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
	public static void clearCache(DgfFglLicenseNo dgfFglLicenseNo) {
		getPersistence().clearCache(dgfFglLicenseNo);
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
	public static Map<Serializable, DgfFglLicenseNo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfFglLicenseNo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfFglLicenseNo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfFglLicenseNo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfFglLicenseNo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfFglLicenseNo update(DgfFglLicenseNo dgfFglLicenseNo) {
		return getPersistence().update(dgfFglLicenseNo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfFglLicenseNo update(
		DgfFglLicenseNo dgfFglLicenseNo, ServiceContext serviceContext) {

		return getPersistence().update(dgfFglLicenseNo, serviceContext);
	}

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a matching dgf fgl license no could not be found
	 */
	public static DgfFglLicenseNo findByDgfFglLicenseNoBySerialNo(long serialNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicenseNoException {

		return getPersistence().findByDgfFglLicenseNoBySerialNo(serialNo);
	}

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	public static DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(
		long serialNo) {

		return getPersistence().fetchByDgfFglLicenseNoBySerialNo(serialNo);
	}

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNo the serial no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	public static DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(
		long serialNo, boolean useFinderCache) {

		return getPersistence().fetchByDgfFglLicenseNoBySerialNo(
			serialNo, useFinderCache);
	}

	/**
	 * Removes the dgf fgl license no where serialNo = &#63; from the database.
	 *
	 * @param serialNo the serial no
	 * @return the dgf fgl license no that was removed
	 */
	public static DgfFglLicenseNo removeByDgfFglLicenseNoBySerialNo(
			long serialNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicenseNoException {

		return getPersistence().removeByDgfFglLicenseNoBySerialNo(serialNo);
	}

	/**
	 * Returns the number of dgf fgl license nos where serialNo = &#63;.
	 *
	 * @param serialNo the serial no
	 * @return the number of matching dgf fgl license nos
	 */
	public static int countByDgfFglLicenseNoBySerialNo(long serialNo) {
		return getPersistence().countByDgfFglLicenseNoBySerialNo(serialNo);
	}

	/**
	 * Caches the dgf fgl license no in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 */
	public static void cacheResult(DgfFglLicenseNo dgfFglLicenseNo) {
		getPersistence().cacheResult(dgfFglLicenseNo);
	}

	/**
	 * Caches the dgf fgl license nos in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNos the dgf fgl license nos
	 */
	public static void cacheResult(List<DgfFglLicenseNo> dgfFglLicenseNos) {
		getPersistence().cacheResult(dgfFglLicenseNos);
	}

	/**
	 * Creates a new dgf fgl license no with the primary key. Does not add the dgf fgl license no to the database.
	 *
	 * @param id the primary key for the new dgf fgl license no
	 * @return the new dgf fgl license no
	 */
	public static DgfFglLicenseNo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf fgl license no with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	public static DgfFglLicenseNo remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicenseNoException {

		return getPersistence().remove(id);
	}

	public static DgfFglLicenseNo updateImpl(DgfFglLicenseNo dgfFglLicenseNo) {
		return getPersistence().updateImpl(dgfFglLicenseNo);
	}

	/**
	 * Returns the dgf fgl license no with the primary key or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	public static DgfFglLicenseNo findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicenseNoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf fgl license no with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no, or <code>null</code> if a dgf fgl license no with the primary key could not be found
	 */
	public static DgfFglLicenseNo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf fgl license nos.
	 *
	 * @return the dgf fgl license nos
	 */
	public static List<DgfFglLicenseNo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @return the range of dgf fgl license nos
	 */
	public static List<DgfFglLicenseNo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl license nos
	 */
	public static List<DgfFglLicenseNo> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicenseNo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl license nos
	 */
	public static List<DgfFglLicenseNo> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicenseNo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf fgl license nos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf fgl license nos.
	 *
	 * @return the number of dgf fgl license nos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfFglLicenseNoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfFglLicenseNoPersistence _persistence;

}