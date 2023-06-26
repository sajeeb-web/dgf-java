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

import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the verified beneficiaries service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.VerifiedBeneficiariesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerifiedBeneficiariesPersistence
 * @generated
 */
public class VerifiedBeneficiariesUtil {

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
	public static void clearCache(VerifiedBeneficiaries verifiedBeneficiaries) {
		getPersistence().clearCache(verifiedBeneficiaries);
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
	public static Map<Serializable, VerifiedBeneficiaries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VerifiedBeneficiaries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VerifiedBeneficiaries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VerifiedBeneficiaries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VerifiedBeneficiaries update(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		return getPersistence().update(verifiedBeneficiaries);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VerifiedBeneficiaries update(
		VerifiedBeneficiaries verifiedBeneficiaries,
		ServiceContext serviceContext) {

		return getPersistence().update(verifiedBeneficiaries, serviceContext);
	}

	/**
	 * Returns the verified beneficiaries where id = &#63; or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries findByVerifiedBeneficiariesById(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByVerifiedBeneficiariesById(id);
	}

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(
		long id) {

		return getPersistence().fetchByVerifiedBeneficiariesById(id);
	}

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(
		long id, boolean useFinderCache) {

		return getPersistence().fetchByVerifiedBeneficiariesById(
			id, useFinderCache);
	}

	/**
	 * Removes the verified beneficiaries where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the verified beneficiaries that was removed
	 */
	public static VerifiedBeneficiaries removeByVerifiedBeneficiariesById(
			long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().removeByVerifiedBeneficiariesById(id);
	}

	/**
	 * Returns the number of verified beneficiarieses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching verified beneficiarieses
	 */
	public static int countByVerifiedBeneficiariesById(long id) {
		return getPersistence().countByVerifiedBeneficiariesById(id);
	}

	/**
	 * Returns all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(long dealerId) {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder(
			dealerId);
	}

	/**
	 * Returns a range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end) {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder(
			dealerId, start, end);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder(
			dealerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder(
			dealerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
			findByverifiedBeneficiariesDealerIdFinder_First(
				long dealerId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder_First(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_First(
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().
			fetchByverifiedBeneficiariesDealerIdFinder_First(
				dealerId, orderByComparator);
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
			findByverifiedBeneficiariesDealerIdFinder_Last(
				long dealerId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByverifiedBeneficiariesDealerIdFinder_Last(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_Last(
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().fetchByverifiedBeneficiariesDealerIdFinder_Last(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public static VerifiedBeneficiaries[]
			findByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				long id, long dealerId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().
			findByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				id, dealerId, orderByComparator);
	}

	/**
	 * Removes all the verified beneficiarieses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	public static void removeByverifiedBeneficiariesDealerIdFinder(
		long dealerId) {

		getPersistence().removeByverifiedBeneficiariesDealerIdFinder(dealerId);
	}

	/**
	 * Returns the number of verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching verified beneficiarieses
	 */
	public static int countByverifiedBeneficiariesDealerIdFinder(
		long dealerId) {

		return getPersistence().countByverifiedBeneficiariesDealerIdFinder(
			dealerId);
	}

	/**
	 * Returns all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(String nationalId) {

		return getPersistence().findByverifiedBeneficiariesNidFinder(
			nationalId);
	}

	/**
	 * Returns a range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end) {

		return getPersistence().findByverifiedBeneficiariesNidFinder(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().findByverifiedBeneficiariesNidFinder(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByverifiedBeneficiariesNidFinder(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
			findByverifiedBeneficiariesNidFinder_First(
				String nationalId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByverifiedBeneficiariesNidFinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
		fetchByverifiedBeneficiariesNidFinder_First(
			String nationalId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().fetchByverifiedBeneficiariesNidFinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
			findByverifiedBeneficiariesNidFinder_Last(
				String nationalId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByverifiedBeneficiariesNidFinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public static VerifiedBeneficiaries
		fetchByverifiedBeneficiariesNidFinder_Last(
			String nationalId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().fetchByverifiedBeneficiariesNidFinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public static VerifiedBeneficiaries[]
			findByverifiedBeneficiariesNidFinder_PrevAndNext(
				long id, String nationalId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().
			findByverifiedBeneficiariesNidFinder_PrevAndNext(
				id, nationalId, orderByComparator);
	}

	/**
	 * Removes all the verified beneficiarieses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByverifiedBeneficiariesNidFinder(
		String nationalId) {

		getPersistence().removeByverifiedBeneficiariesNidFinder(nationalId);
	}

	/**
	 * Returns the number of verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching verified beneficiarieses
	 */
	public static int countByverifiedBeneficiariesNidFinder(String nationalId) {
		return getPersistence().countByverifiedBeneficiariesNidFinder(
			nationalId);
	}

	/**
	 * Caches the verified beneficiaries in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 */
	public static void cacheResult(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		getPersistence().cacheResult(verifiedBeneficiaries);
	}

	/**
	 * Caches the verified beneficiarieses in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiarieses the verified beneficiarieses
	 */
	public static void cacheResult(
		List<VerifiedBeneficiaries> verifiedBeneficiarieses) {

		getPersistence().cacheResult(verifiedBeneficiarieses);
	}

	/**
	 * Creates a new verified beneficiaries with the primary key. Does not add the verified beneficiaries to the database.
	 *
	 * @param id the primary key for the new verified beneficiaries
	 * @return the new verified beneficiaries
	 */
	public static VerifiedBeneficiaries create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the verified beneficiaries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public static VerifiedBeneficiaries remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().remove(id);
	}

	public static VerifiedBeneficiaries updateImpl(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		return getPersistence().updateImpl(verifiedBeneficiaries);
	}

	/**
	 * Returns the verified beneficiaries with the primary key or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public static VerifiedBeneficiaries findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchVerifiedBeneficiariesException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the verified beneficiaries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries, or <code>null</code> if a verified beneficiaries with the primary key could not be found
	 */
	public static VerifiedBeneficiaries fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the verified beneficiarieses.
	 *
	 * @return the verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries> findAll(
		int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verified beneficiarieses
	 */
	public static List<VerifiedBeneficiaries> findAll(
		int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the verified beneficiarieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of verified beneficiarieses.
	 *
	 * @return the number of verified beneficiarieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VerifiedBeneficiariesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile VerifiedBeneficiariesPersistence _persistence;

}