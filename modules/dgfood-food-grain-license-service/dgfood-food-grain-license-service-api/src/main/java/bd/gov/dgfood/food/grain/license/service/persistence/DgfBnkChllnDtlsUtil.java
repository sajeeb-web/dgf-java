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

import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf bnk chlln dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfBnkChllnDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtlsPersistence
 * @generated
 */
public class DgfBnkChllnDtlsUtil {

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
	public static void clearCache(DgfBnkChllnDtls dgfBnkChllnDtls) {
		getPersistence().clearCache(dgfBnkChllnDtls);
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
	public static Map<Serializable, DgfBnkChllnDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfBnkChllnDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfBnkChllnDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfBnkChllnDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfBnkChllnDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfBnkChllnDtls update(DgfBnkChllnDtls dgfBnkChllnDtls) {
		return getPersistence().update(dgfBnkChllnDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfBnkChllnDtls update(
		DgfBnkChllnDtls dgfBnkChllnDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfBnkChllnDtls, serviceContext);
	}

	/**
	 * Caches the dgf bnk chlln dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 */
	public static void cacheResult(DgfBnkChllnDtls dgfBnkChllnDtls) {
		getPersistence().cacheResult(dgfBnkChllnDtls);
	}

	/**
	 * Caches the dgf bnk chlln dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtlses the dgf bnk chlln dtlses
	 */
	public static void cacheResult(List<DgfBnkChllnDtls> dgfBnkChllnDtlses) {
		getPersistence().cacheResult(dgfBnkChllnDtlses);
	}

	/**
	 * Creates a new dgf bnk chlln dtls with the primary key. Does not add the dgf bnk chlln dtls to the database.
	 *
	 * @param bnkChllnId the primary key for the new dgf bnk chlln dtls
	 * @return the new dgf bnk chlln dtls
	 */
	public static DgfBnkChllnDtls create(long bnkChllnId) {
		return getPersistence().create(bnkChllnId);
	}

	/**
	 * Removes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public static DgfBnkChllnDtls remove(long bnkChllnId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBnkChllnDtlsException {

		return getPersistence().remove(bnkChllnId);
	}

	public static DgfBnkChllnDtls updateImpl(DgfBnkChllnDtls dgfBnkChllnDtls) {
		return getPersistence().updateImpl(dgfBnkChllnDtls);
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or throws a <code>NoSuchDgfBnkChllnDtlsException</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public static DgfBnkChllnDtls findByPrimaryKey(long bnkChllnId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfBnkChllnDtlsException {

		return getPersistence().findByPrimaryKey(bnkChllnId);
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls, or <code>null</code> if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public static DgfBnkChllnDtls fetchByPrimaryKey(long bnkChllnId) {
		return getPersistence().fetchByPrimaryKey(bnkChllnId);
	}

	/**
	 * Returns all the dgf bnk chlln dtlses.
	 *
	 * @return the dgf bnk chlln dtlses
	 */
	public static List<DgfBnkChllnDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @return the range of dgf bnk chlln dtlses
	 */
	public static List<DgfBnkChllnDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	public static List<DgfBnkChllnDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBnkChllnDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	public static List<DgfBnkChllnDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBnkChllnDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf bnk chlln dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf bnk chlln dtlses.
	 *
	 * @return the number of dgf bnk chlln dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfBnkChllnDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfBnkChllnDtlsPersistence _persistence;

}