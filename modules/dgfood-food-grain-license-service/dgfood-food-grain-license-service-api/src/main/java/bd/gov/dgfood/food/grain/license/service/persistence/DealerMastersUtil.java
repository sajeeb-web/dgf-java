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

import bd.gov.dgfood.food.grain.license.model.DealerMasters;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dealer masters service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DealerMastersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DealerMastersPersistence
 * @generated
 */
public class DealerMastersUtil {

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
	public static void clearCache(DealerMasters dealerMasters) {
		getPersistence().clearCache(dealerMasters);
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
	public static Map<Serializable, DealerMasters> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DealerMasters> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DealerMasters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DealerMasters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DealerMasters> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DealerMasters update(DealerMasters dealerMasters) {
		return getPersistence().update(dealerMasters);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DealerMasters update(
		DealerMasters dealerMasters, ServiceContext serviceContext) {

		return getPersistence().update(dealerMasters, serviceContext);
	}

	/**
	 * Returns the dealer masters where id = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findByDealerMastersById(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findByDealerMastersById(id);
	}

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersById(long id) {
		return getPersistence().fetchByDealerMastersById(id);
	}

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersById(
		long id, boolean useFinderCache) {

		return getPersistence().fetchByDealerMastersById(id, useFinderCache);
	}

	/**
	 * Removes the dealer masters where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the dealer masters that was removed
	 */
	public static DealerMasters removeByDealerMastersById(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().removeByDealerMastersById(id);
	}

	/**
	 * Returns the number of dealer masterses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching dealer masterses
	 */
	public static int countByDealerMastersById(long id) {
		return getPersistence().countByDealerMastersById(id);
	}

	/**
	 * Returns all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the matching dealer masterses
	 */
	public static List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId) {

		return getPersistence().findBydealerMastersNidFinder(dealerNationalId);
	}

	/**
	 * Returns a range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of matching dealer masterses
	 */
	public static List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end) {

		return getPersistence().findBydealerMastersNidFinder(
			dealerNationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dealer masterses
	 */
	public static List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		OrderByComparator<DealerMasters> orderByComparator) {

		return getPersistence().findBydealerMastersNidFinder(
			dealerNationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dealer masterses
	 */
	public static List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		OrderByComparator<DealerMasters> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydealerMastersNidFinder(
			dealerNationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findBydealerMastersNidFinder_First(
			String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findBydealerMastersNidFinder_First(
			dealerNationalId, orderByComparator);
	}

	/**
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchBydealerMastersNidFinder_First(
		String dealerNationalId,
		OrderByComparator<DealerMasters> orderByComparator) {

		return getPersistence().fetchBydealerMastersNidFinder_First(
			dealerNationalId, orderByComparator);
	}

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findBydealerMastersNidFinder_Last(
			String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findBydealerMastersNidFinder_Last(
			dealerNationalId, orderByComparator);
	}

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchBydealerMastersNidFinder_Last(
		String dealerNationalId,
		OrderByComparator<DealerMasters> orderByComparator) {

		return getPersistence().fetchBydealerMastersNidFinder_Last(
			dealerNationalId, orderByComparator);
	}

	/**
	 * Returns the dealer masterses before and after the current dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param id the primary key of the current dealer masters
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public static DealerMasters[] findBydealerMastersNidFinder_PrevAndNext(
			long id, String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findBydealerMastersNidFinder_PrevAndNext(
			id, dealerNationalId, orderByComparator);
	}

	/**
	 * Removes all the dealer masterses where dealerNationalId = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 */
	public static void removeBydealerMastersNidFinder(String dealerNationalId) {
		getPersistence().removeBydealerMastersNidFinder(dealerNationalId);
	}

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the number of matching dealer masterses
	 */
	public static int countBydealerMastersNidFinder(String dealerNationalId) {
		return getPersistence().countBydealerMastersNidFinder(dealerNationalId);
	}

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo) {

		return getPersistence().fetchBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo,
		boolean useFinderCache) {

		return getPersistence().fetchBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo, useFinderCache);
	}

	/**
	 * Removes the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public static DealerMasters removeBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().removeBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);
	}

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public static int countBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo) {

		return getPersistence().countBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo) {

		return getPersistence().fetchByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo,
		boolean useFinderCache) {

		return getPersistence().fetchByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo, useFinderCache);
	}

	/**
	 * Removes the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public static DealerMasters removeByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().removeByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);
	}

	/**
	 * Returns the number of dealer masterses where secondNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public static int countByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo) {

		return getPersistence().countByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public static DealerMasters findByDealerMastersByMobileNo(
			String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findByDealerMastersByMobileNo(dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersByMobileNo(
		String dealerMobileNo) {

		return getPersistence().fetchByDealerMastersByMobileNo(dealerMobileNo);
	}

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public static DealerMasters fetchByDealerMastersByMobileNo(
		String dealerMobileNo, boolean useFinderCache) {

		return getPersistence().fetchByDealerMastersByMobileNo(
			dealerMobileNo, useFinderCache);
	}

	/**
	 * Removes the dealer masters where dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public static DealerMasters removeByDealerMastersByMobileNo(
			String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().removeByDealerMastersByMobileNo(dealerMobileNo);
	}

	/**
	 * Returns the number of dealer masterses where dealerMobileNo = &#63;.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public static int countByDealerMastersByMobileNo(String dealerMobileNo) {
		return getPersistence().countByDealerMastersByMobileNo(dealerMobileNo);
	}

	/**
	 * Caches the dealer masters in the entity cache if it is enabled.
	 *
	 * @param dealerMasters the dealer masters
	 */
	public static void cacheResult(DealerMasters dealerMasters) {
		getPersistence().cacheResult(dealerMasters);
	}

	/**
	 * Caches the dealer masterses in the entity cache if it is enabled.
	 *
	 * @param dealerMasterses the dealer masterses
	 */
	public static void cacheResult(List<DealerMasters> dealerMasterses) {
		getPersistence().cacheResult(dealerMasterses);
	}

	/**
	 * Creates a new dealer masters with the primary key. Does not add the dealer masters to the database.
	 *
	 * @param id the primary key for the new dealer masters
	 * @return the new dealer masters
	 */
	public static DealerMasters create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dealer masters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters that was removed
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public static DealerMasters remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().remove(id);
	}

	public static DealerMasters updateImpl(DealerMasters dealerMasters) {
		return getPersistence().updateImpl(dealerMasters);
	}

	/**
	 * Returns the dealer masters with the primary key or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public static DealerMasters findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dealer masters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters, or <code>null</code> if a dealer masters with the primary key could not be found
	 */
	public static DealerMasters fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dealer masterses.
	 *
	 * @return the dealer masterses
	 */
	public static List<DealerMasters> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of dealer masterses
	 */
	public static List<DealerMasters> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dealer masterses
	 */
	public static List<DealerMasters> findAll(
		int start, int end,
		OrderByComparator<DealerMasters> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dealer masterses
	 */
	public static List<DealerMasters> findAll(
		int start, int end, OrderByComparator<DealerMasters> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dealer masterses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dealer masterses.
	 *
	 * @return the number of dealer masterses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DealerMastersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DealerMastersPersistence _persistence;

}