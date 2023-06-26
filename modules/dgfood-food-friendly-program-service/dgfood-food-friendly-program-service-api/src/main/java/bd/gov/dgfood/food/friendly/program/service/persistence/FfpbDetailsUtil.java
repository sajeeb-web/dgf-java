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

import bd.gov.dgfood.food.friendly.program.model.FfpbDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ffpb details service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.FfpbDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetailsPersistence
 * @generated
 */
public class FfpbDetailsUtil {

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
	public static void clearCache(FfpbDetails ffpbDetails) {
		getPersistence().clearCache(ffpbDetails);
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
	public static Map<Serializable, FfpbDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FfpbDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FfpbDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FfpbDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FfpbDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FfpbDetails update(FfpbDetails ffpbDetails) {
		return getPersistence().update(ffpbDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FfpbDetails update(
		FfpbDetails ffpbDetails, ServiceContext serviceContext) {

		return getPersistence().update(ffpbDetails, serviceContext);
	}

	/**
	 * Returns the ffpb details where nationalId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public static FfpbDetails findByffpbNidFinder(long nationalId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByffpbNidFinder(nationalId);
	}

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpbNidFinder(long nationalId) {
		return getPersistence().fetchByffpbNidFinder(nationalId);
	}

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpbNidFinder(
		long nationalId, boolean useFinderCache) {

		return getPersistence().fetchByffpbNidFinder(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the ffpb details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffpb details that was removed
	 */
	public static FfpbDetails removeByffpbNidFinder(long nationalId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().removeByffpbNidFinder(nationalId);
	}

	/**
	 * Returns the number of ffpb detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffpb detailses
	 */
	public static int countByffpbNidFinder(long nationalId) {
		return getPersistence().countByffpbNidFinder(nationalId);
	}

	/**
	 * Returns all the ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching ffpb detailses
	 */
	public static List<FfpbDetails> findByffpbMobileFinder(String mobileNo) {
		return getPersistence().findByffpbMobileFinder(mobileNo);
	}

	/**
	 * Returns a range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of matching ffpb detailses
	 */
	public static List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end) {

		return getPersistence().findByffpbMobileFinder(mobileNo, start, end);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffpb detailses
	 */
	public static List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		OrderByComparator<FfpbDetails> orderByComparator) {

		return getPersistence().findByffpbMobileFinder(
			mobileNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffpb detailses
	 */
	public static List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		OrderByComparator<FfpbDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByffpbMobileFinder(
			mobileNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public static FfpbDetails findByffpbMobileFinder_First(
			String mobileNo, OrderByComparator<FfpbDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByffpbMobileFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpbMobileFinder_First(
		String mobileNo, OrderByComparator<FfpbDetails> orderByComparator) {

		return getPersistence().fetchByffpbMobileFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public static FfpbDetails findByffpbMobileFinder_Last(
			String mobileNo, OrderByComparator<FfpbDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByffpbMobileFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpbMobileFinder_Last(
		String mobileNo, OrderByComparator<FfpbDetails> orderByComparator) {

		return getPersistence().fetchByffpbMobileFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the ffpb detailses before and after the current ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param ffpRegstrId the primary key of the current ffpb details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public static FfpbDetails[] findByffpbMobileFinder_PrevAndNext(
			long ffpRegstrId, String mobileNo,
			OrderByComparator<FfpbDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByffpbMobileFinder_PrevAndNext(
			ffpRegstrId, mobileNo, orderByComparator);
	}

	/**
	 * Removes all the ffpb detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public static void removeByffpbMobileFinder(String mobileNo) {
		getPersistence().removeByffpbMobileFinder(mobileNo);
	}

	/**
	 * Returns the number of ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching ffpb detailses
	 */
	public static int countByffpbMobileFinder(String mobileNo) {
		return getPersistence().countByffpbMobileFinder(mobileNo);
	}

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public static FfpbDetails findByffpregstridFinder(long ffpRegstrId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpregstridFinder(long ffpRegstrId) {
		return getPersistence().fetchByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public static FfpbDetails fetchByffpregstridFinder(
		long ffpRegstrId, boolean useFinderCache) {

		return getPersistence().fetchByffpregstridFinder(
			ffpRegstrId, useFinderCache);
	}

	/**
	 * Removes the ffpb details where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the ffpb details that was removed
	 */
	public static FfpbDetails removeByffpregstridFinder(long ffpRegstrId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().removeByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Returns the number of ffpb detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching ffpb detailses
	 */
	public static int countByffpregstridFinder(long ffpRegstrId) {
		return getPersistence().countByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Caches the ffpb details in the entity cache if it is enabled.
	 *
	 * @param ffpbDetails the ffpb details
	 */
	public static void cacheResult(FfpbDetails ffpbDetails) {
		getPersistence().cacheResult(ffpbDetails);
	}

	/**
	 * Caches the ffpb detailses in the entity cache if it is enabled.
	 *
	 * @param ffpbDetailses the ffpb detailses
	 */
	public static void cacheResult(List<FfpbDetails> ffpbDetailses) {
		getPersistence().cacheResult(ffpbDetailses);
	}

	/**
	 * Creates a new ffpb details with the primary key. Does not add the ffpb details to the database.
	 *
	 * @param ffpRegstrId the primary key for the new ffpb details
	 * @return the new ffpb details
	 */
	public static FfpbDetails create(long ffpRegstrId) {
		return getPersistence().create(ffpRegstrId);
	}

	/**
	 * Removes the ffpb details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details that was removed
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public static FfpbDetails remove(long ffpRegstrId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().remove(ffpRegstrId);
	}

	public static FfpbDetails updateImpl(FfpbDetails ffpbDetails) {
		return getPersistence().updateImpl(ffpbDetails);
	}

	/**
	 * Returns the ffpb details with the primary key or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public static FfpbDetails findByPrimaryKey(long ffpRegstrId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchFfpbDetailsException {

		return getPersistence().findByPrimaryKey(ffpRegstrId);
	}

	/**
	 * Returns the ffpb details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details, or <code>null</code> if a ffpb details with the primary key could not be found
	 */
	public static FfpbDetails fetchByPrimaryKey(long ffpRegstrId) {
		return getPersistence().fetchByPrimaryKey(ffpRegstrId);
	}

	/**
	 * Returns all the ffpb detailses.
	 *
	 * @return the ffpb detailses
	 */
	public static List<FfpbDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of ffpb detailses
	 */
	public static List<FfpbDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffpb detailses
	 */
	public static List<FfpbDetails> findAll(
		int start, int end, OrderByComparator<FfpbDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffpb detailses
	 */
	public static List<FfpbDetails> findAll(
		int start, int end, OrderByComparator<FfpbDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ffpb detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ffpb detailses.
	 *
	 * @return the number of ffpb detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FfpbDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FfpbDetailsPersistence _persistence;

}