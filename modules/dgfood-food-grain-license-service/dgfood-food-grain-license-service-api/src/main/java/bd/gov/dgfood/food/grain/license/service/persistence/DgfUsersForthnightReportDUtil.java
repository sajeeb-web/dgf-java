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

import bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users forthnight report d service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersForthnightReportDPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportDPersistence
 * @generated
 */
public class DgfUsersForthnightReportDUtil {

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
	public static void clearCache(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		getPersistence().clearCache(dgfUsersForthnightReportD);
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
	public static Map<Serializable, DgfUsersForthnightReportD>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersForthnightReportD> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersForthnightReportD> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersForthnightReportD> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersForthnightReportD update(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		return getPersistence().update(dgfUsersForthnightReportD);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersForthnightReportD update(
		DgfUsersForthnightReportD dgfUsersForthnightReportD,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgfUsersForthnightReportD, serviceContext);
	}

	/**
	 * Returns all the dgf users forthnight report ds where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByUsernationalId(String usernationalId) {

		return getPersistence().findByDgfUsersForthnightReportDByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns a range of all the dgf users forthnight report ds where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @return the range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByUsernationalId(
			String usernationalId, int start, int end) {

		return getPersistence().findByDgfUsersForthnightReportDByUsernationalId(
			usernationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().findByDgfUsersForthnightReportDByUsernationalId(
			usernationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByDgfUsersForthnightReportDByUsernationalId(
			usernationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users forthnight report d in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
			findByDgfUsersForthnightReportDByUsernationalId_First(
				String usernationalId,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf users forthnight report d in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users forthnight report d, or <code>null</code> if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
		fetchByDgfUsersForthnightReportDByUsernationalId_First(
			String usernationalId,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersForthnightReportDByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users forthnight report d in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
			findByDgfUsersForthnightReportDByUsernationalId_Last(
				String usernationalId,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByUsernationalId_Last(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users forthnight report d in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users forthnight report d, or <code>null</code> if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
		fetchByDgfUsersForthnightReportDByUsernationalId_Last(
			String usernationalId,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersForthnightReportDByUsernationalId_Last(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the dgf users forthnight report ds before and after the current dgf users forthnight report d in the ordered set where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users forthnight report d
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a dgf users forthnight report d with the primary key could not be found
	 */
	public static DgfUsersForthnightReportD[]
			findByDgfUsersForthnightReportDByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf users forthnight report ds where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	public static void removeByDgfUsersForthnightReportDByUsernationalId(
		String usernationalId) {

		getPersistence().removeByDgfUsersForthnightReportDByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns the number of dgf users forthnight report ds where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users forthnight report ds
	 */
	public static int countByDgfUsersForthnightReportDByUsernationalId(
		String usernationalId) {

		return getPersistence().
			countByDgfUsersForthnightReportDByUsernationalId(usernationalId);
	}

	/**
	 * Returns all the dgf users forthnight report ds where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByScreenName(String screenName) {

		return getPersistence().findByDgfUsersForthnightReportDByScreenName(
			screenName);
	}

	/**
	 * Returns a range of all the dgf users forthnight report ds where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @return the range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByScreenName(
			String screenName, int start, int end) {

		return getPersistence().findByDgfUsersForthnightReportDByScreenName(
			screenName, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().findByDgfUsersForthnightReportDByScreenName(
			screenName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD>
		findByDgfUsersForthnightReportDByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByDgfUsersForthnightReportDByScreenName(
			screenName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users forthnight report d in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
			findByDgfUsersForthnightReportDByScreenName_First(
				String screenName,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByScreenName_First(
				screenName, orderByComparator);
	}

	/**
	 * Returns the first dgf users forthnight report d in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users forthnight report d, or <code>null</code> if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
		fetchByDgfUsersForthnightReportDByScreenName_First(
			String screenName,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersForthnightReportDByScreenName_First(
				screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users forthnight report d in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
			findByDgfUsersForthnightReportDByScreenName_Last(
				String screenName,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByScreenName_Last(
				screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users forthnight report d in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users forthnight report d, or <code>null</code> if a matching dgf users forthnight report d could not be found
	 */
	public static DgfUsersForthnightReportD
		fetchByDgfUsersForthnightReportDByScreenName_Last(
			String screenName,
			OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersForthnightReportDByScreenName_Last(
				screenName, orderByComparator);
	}

	/**
	 * Returns the dgf users forthnight report ds before and after the current dgf users forthnight report d in the ordered set where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users forthnight report d
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a dgf users forthnight report d with the primary key could not be found
	 */
	public static DgfUsersForthnightReportD[]
			findByDgfUsersForthnightReportDByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersForthnightReportD> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().
			findByDgfUsersForthnightReportDByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
	}

	/**
	 * Removes all the dgf users forthnight report ds where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public static void removeByDgfUsersForthnightReportDByScreenName(
		String screenName) {

		getPersistence().removeByDgfUsersForthnightReportDByScreenName(
			screenName);
	}

	/**
	 * Returns the number of dgf users forthnight report ds where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users forthnight report ds
	 */
	public static int countByDgfUsersForthnightReportDByScreenName(
		String screenName) {

		return getPersistence().countByDgfUsersForthnightReportDByScreenName(
			screenName);
	}

	/**
	 * Caches the dgf users forthnight report d in the entity cache if it is enabled.
	 *
	 * @param dgfUsersForthnightReportD the dgf users forthnight report d
	 */
	public static void cacheResult(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		getPersistence().cacheResult(dgfUsersForthnightReportD);
	}

	/**
	 * Caches the dgf users forthnight report ds in the entity cache if it is enabled.
	 *
	 * @param dgfUsersForthnightReportDs the dgf users forthnight report ds
	 */
	public static void cacheResult(
		List<DgfUsersForthnightReportD> dgfUsersForthnightReportDs) {

		getPersistence().cacheResult(dgfUsersForthnightReportDs);
	}

	/**
	 * Creates a new dgf users forthnight report d with the primary key. Does not add the dgf users forthnight report d to the database.
	 *
	 * @param reportId the primary key for the new dgf users forthnight report d
	 * @return the new dgf users forthnight report d
	 */
	public static DgfUsersForthnightReportD create(long reportId) {
		return getPersistence().create(reportId);
	}

	/**
	 * Removes the dgf users forthnight report d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users forthnight report d
	 * @return the dgf users forthnight report d that was removed
	 * @throws NoSuchDgfUsersForthnightReportDException if a dgf users forthnight report d with the primary key could not be found
	 */
	public static DgfUsersForthnightReportD remove(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().remove(reportId);
	}

	public static DgfUsersForthnightReportD updateImpl(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		return getPersistence().updateImpl(dgfUsersForthnightReportD);
	}

	/**
	 * Returns the dgf users forthnight report d with the primary key or throws a <code>NoSuchDgfUsersForthnightReportDException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users forthnight report d
	 * @return the dgf users forthnight report d
	 * @throws NoSuchDgfUsersForthnightReportDException if a dgf users forthnight report d with the primary key could not be found
	 */
	public static DgfUsersForthnightReportD findByPrimaryKey(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersForthnightReportDException {

		return getPersistence().findByPrimaryKey(reportId);
	}

	/**
	 * Returns the dgf users forthnight report d with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users forthnight report d
	 * @return the dgf users forthnight report d, or <code>null</code> if a dgf users forthnight report d with the primary key could not be found
	 */
	public static DgfUsersForthnightReportD fetchByPrimaryKey(long reportId) {
		return getPersistence().fetchByPrimaryKey(reportId);
	}

	/**
	 * Returns all the dgf users forthnight report ds.
	 *
	 * @return the dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf users forthnight report ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @return the range of dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD> findAll(
		int start, int end,
		OrderByComparator<DgfUsersForthnightReportD> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users forthnight report ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users forthnight report ds
	 */
	public static List<DgfUsersForthnightReportD> findAll(
		int start, int end,
		OrderByComparator<DgfUsersForthnightReportD> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users forthnight report ds from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users forthnight report ds.
	 *
	 * @return the number of dgf users forthnight report ds
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersForthnightReportDPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersForthnightReportDPersistence _persistence;

}