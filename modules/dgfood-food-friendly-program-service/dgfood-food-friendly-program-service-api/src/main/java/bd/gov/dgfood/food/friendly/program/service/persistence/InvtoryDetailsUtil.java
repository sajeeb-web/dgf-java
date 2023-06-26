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

package bd.gov.dgfood.food.friendly.program.service.persistence;

import bd.gov.dgfood.food.friendly.program.model.InvtoryDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the invtory details service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.InvtoryDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvtoryDetailsPersistence
 * @generated
 */
public class InvtoryDetailsUtil {

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
	public static void clearCache(InvtoryDetails invtoryDetails) {
		getPersistence().clearCache(invtoryDetails);
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
	public static Map<Serializable, InvtoryDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InvtoryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InvtoryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InvtoryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InvtoryDetails update(InvtoryDetails invtoryDetails) {
		return getPersistence().update(invtoryDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InvtoryDetails update(
		InvtoryDetails invtoryDetails, ServiceContext serviceContext) {

		return getPersistence().update(invtoryDetails, serviceContext);
	}

	/**
	 * Returns the invtory details where inventoryId = &#63; or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public static InvtoryDetails findByinventoryidFinder(long inventoryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findByinventoryidFinder(inventoryId);
	}

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchByinventoryidFinder(long inventoryId) {
		return getPersistence().fetchByinventoryidFinder(inventoryId);
	}

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchByinventoryidFinder(
		long inventoryId, boolean useFinderCache) {

		return getPersistence().fetchByinventoryidFinder(
			inventoryId, useFinderCache);
	}

	/**
	 * Removes the invtory details where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 * @return the invtory details that was removed
	 */
	public static InvtoryDetails removeByinventoryidFinder(long inventoryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().removeByinventoryidFinder(inventoryId);
	}

	/**
	 * Returns the number of invtory detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching invtory detailses
	 */
	public static int countByinventoryidFinder(long inventoryId) {
		return getPersistence().countByinventoryidFinder(inventoryId);
	}

	/**
	 * Returns all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching invtory detailses
	 */
	public static List<InvtoryDetails> findBydlrregnoFinder(long dlrRegNo) {
		return getPersistence().findBydlrregnoFinder(dlrRegNo);
	}

	/**
	 * Returns a range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end) {

		return getPersistence().findBydlrregnoFinder(dlrRegNo, start, end);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public static InvtoryDetails findBydlrregnoFinder_First(
			long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findBydlrregnoFinder_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchBydlrregnoFinder_First(
		long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().fetchBydlrregnoFinder_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public static InvtoryDetails findBydlrregnoFinder_Last(
			long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findBydlrregnoFinder_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().fetchBydlrregnoFinder_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public static InvtoryDetails[] findBydlrregnoFinder_PrevAndNext(
			long inventoryId, long dlrRegNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findBydlrregnoFinder_PrevAndNext(
			inventoryId, dlrRegNo, orderByComparator);
	}

	/**
	 * Removes all the invtory detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public static void removeBydlrregnoFinder(long dlrRegNo) {
		getPersistence().removeBydlrregnoFinder(dlrRegNo);
	}

	/**
	 * Returns the number of invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching invtory detailses
	 */
	public static int countBydlrregnoFinder(long dlrRegNo) {
		return getPersistence().countBydlrregnoFinder(dlrRegNo);
	}

	/**
	 * Returns all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the matching invtory detailses
	 */
	public static List<InvtoryDetails> findByallcntfynoFinder(long allcNtfyNo) {
		return getPersistence().findByallcntfynoFinder(allcNtfyNo);
	}

	/**
	 * Returns a range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end) {

		return getPersistence().findByallcntfynoFinder(allcNtfyNo, start, end);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().findByallcntfynoFinder(
			allcNtfyNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	public static List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByallcntfynoFinder(
			allcNtfyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public static InvtoryDetails findByallcntfynoFinder_First(
			long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findByallcntfynoFinder_First(
			allcNtfyNo, orderByComparator);
	}

	/**
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchByallcntfynoFinder_First(
		long allcNtfyNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().fetchByallcntfynoFinder_First(
			allcNtfyNo, orderByComparator);
	}

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public static InvtoryDetails findByallcntfynoFinder_Last(
			long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findByallcntfynoFinder_Last(
			allcNtfyNo, orderByComparator);
	}

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public static InvtoryDetails fetchByallcntfynoFinder_Last(
		long allcNtfyNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().fetchByallcntfynoFinder_Last(
			allcNtfyNo, orderByComparator);
	}

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public static InvtoryDetails[] findByallcntfynoFinder_PrevAndNext(
			long inventoryId, long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findByallcntfynoFinder_PrevAndNext(
			inventoryId, allcNtfyNo, orderByComparator);
	}

	/**
	 * Removes all the invtory detailses where allcNtfyNo = &#63; from the database.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 */
	public static void removeByallcntfynoFinder(long allcNtfyNo) {
		getPersistence().removeByallcntfynoFinder(allcNtfyNo);
	}

	/**
	 * Returns the number of invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the number of matching invtory detailses
	 */
	public static int countByallcntfynoFinder(long allcNtfyNo) {
		return getPersistence().countByallcntfynoFinder(allcNtfyNo);
	}

	/**
	 * Caches the invtory details in the entity cache if it is enabled.
	 *
	 * @param invtoryDetails the invtory details
	 */
	public static void cacheResult(InvtoryDetails invtoryDetails) {
		getPersistence().cacheResult(invtoryDetails);
	}

	/**
	 * Caches the invtory detailses in the entity cache if it is enabled.
	 *
	 * @param invtoryDetailses the invtory detailses
	 */
	public static void cacheResult(List<InvtoryDetails> invtoryDetailses) {
		getPersistence().cacheResult(invtoryDetailses);
	}

	/**
	 * Creates a new invtory details with the primary key. Does not add the invtory details to the database.
	 *
	 * @param inventoryId the primary key for the new invtory details
	 * @return the new invtory details
	 */
	public static InvtoryDetails create(long inventoryId) {
		return getPersistence().create(inventoryId);
	}

	/**
	 * Removes the invtory details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details that was removed
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public static InvtoryDetails remove(long inventoryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().remove(inventoryId);
	}

	public static InvtoryDetails updateImpl(InvtoryDetails invtoryDetails) {
		return getPersistence().updateImpl(invtoryDetails);
	}

	/**
	 * Returns the invtory details with the primary key or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public static InvtoryDetails findByPrimaryKey(long inventoryId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchInvtoryDetailsException {

		return getPersistence().findByPrimaryKey(inventoryId);
	}

	/**
	 * Returns the invtory details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details, or <code>null</code> if a invtory details with the primary key could not be found
	 */
	public static InvtoryDetails fetchByPrimaryKey(long inventoryId) {
		return getPersistence().fetchByPrimaryKey(inventoryId);
	}

	/**
	 * Returns all the invtory detailses.
	 *
	 * @return the invtory detailses
	 */
	public static List<InvtoryDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of invtory detailses
	 */
	public static List<InvtoryDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invtory detailses
	 */
	public static List<InvtoryDetails> findAll(
		int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of invtory detailses
	 */
	public static List<InvtoryDetails> findAll(
		int start, int end, OrderByComparator<InvtoryDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the invtory detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of invtory detailses.
	 *
	 * @return the number of invtory detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InvtoryDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile InvtoryDetailsPersistence _persistence;

}