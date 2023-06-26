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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersUtil
 * @generated
 */
@ProviderType
public interface DgfUsersPersistence extends BasePersistence<DgfUsers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersUtil} to access the dgf users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf userses
	 */
	public java.util.List<DgfUsers> findBymobileNumberFinder(String mobileNo);

	/**
	 * Returns a range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findBymobileNumberFinder_First(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchBymobileNumberFinder_First(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findBymobileNumberFinder_Last(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchBymobileNumberFinder_Last(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public DgfUsers[] findBymobileNumberFinder_PrevAndNext(
			long userId, String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Removes all the dgf userses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public void removeBymobileNumberFinder(String mobileNo);

	/**
	 * Returns the number of dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf userses
	 */
	public int countBymobileNumberFinder(String mobileNo);

	/**
	 * Returns all the dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf userses
	 */
	public java.util.List<DgfUsers> findBynationalIdfinder(String nationalId);

	/**
	 * Returns a range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	public java.util.List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findBynationalIdfinder_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchBynationalIdfinder_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findBynationalIdfinder_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchBynationalIdfinder_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public DgfUsers[] findBynationalIdfinder_PrevAndNext(
			long userId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
				orderByComparator)
		throws NoSuchDgfUsersException;

	/**
	 * Removes all the dgf userses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeBynationalIdfinder(String nationalId);

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public int countBynationalIdfinder(String nationalId);

	/**
	 * Returns the dgf users where userId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findByuserIdFinder(long userId)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchByuserIdFinder(long userId);

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchByuserIdFinder(long userId, boolean useFinderCache);

	/**
	 * Removes the dgf users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf users that was removed
	 */
	public DgfUsers removeByuserIdFinder(long userId)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the number of dgf userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf userses
	 */
	public int countByuserIdFinder(long userId);

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public DgfUsers findByDgfUsersByNationalId(String nationalId)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchByDgfUsersByNationalId(String nationalId);

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public DgfUsers fetchByDgfUsersByNationalId(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	public DgfUsers removeByDgfUsersByNationalId(String nationalId)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public int countByDgfUsersByNationalId(String nationalId);

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	public void cacheResult(DgfUsers dgfUsers);

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	public void cacheResult(java.util.List<DgfUsers> dgfUserses);

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param userId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	public DgfUsers create(long userId);

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public DgfUsers remove(long userId) throws NoSuchDgfUsersException;

	public DgfUsers updateImpl(DgfUsers dgfUsers);

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public DgfUsers findByPrimaryKey(long userId)
		throws NoSuchDgfUsersException;

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	public DgfUsers fetchByPrimaryKey(long userId);

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	public java.util.List<DgfUsers> findAll();

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	public java.util.List<DgfUsers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	public java.util.List<DgfUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	public java.util.List<DgfUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf userses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	public int countAll();

}