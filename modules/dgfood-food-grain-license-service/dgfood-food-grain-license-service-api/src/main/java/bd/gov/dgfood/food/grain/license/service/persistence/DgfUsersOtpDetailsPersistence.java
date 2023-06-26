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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersOtpDetailsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users otp details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsUtil
 * @generated
 */
@ProviderType
public interface DgfUsersOtpDetailsPersistence
	extends BasePersistence<DgfUsersOtpDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersOtpDetailsUtil} to access the dgf users otp details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo);

	/**
	 * Returns a range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findBymobileNumberFinder_First(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchBymobileNumberFinder_First(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findBymobileNumberFinder_Last(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchBymobileNumberFinder_Last(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails[] findBymobileNumberFinder_PrevAndNext(
			long otpId, String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Removes all the dgf users otp detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public void removeBymobileNumberFinder(String mobileNo);

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf users otp detailses
	 */
	public int countBymobileNumberFinder(String mobileNo);

	/**
	 * Returns all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId);

	/**
	 * Returns a range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findBynationalIdfinder_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchBynationalIdfinder_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findBynationalIdfinder_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchBynationalIdfinder_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails[] findBynationalIdfinder_PrevAndNext(
			long otpId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Removes all the dgf users otp detailses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeBynationalIdfinder(String nationalId);

	/**
	 * Returns the number of dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users otp detailses
	 */
	public int countBynationalIdfinder(String nationalId);

	/**
	 * Returns all the dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByuserIdFinder(long userId);

	/**
	 * Returns a range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findByuserIdFinder_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByuserIdFinder_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findByuserIdFinder_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByuserIdFinder_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails[] findByuserIdFinder_PrevAndNext(
			long otpId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Removes all the dgf users otp detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserIdFinder(long userId);

	/**
	 * Returns the number of dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf users otp detailses
	 */
	public int countByuserIdFinder(long userId);

	/**
	 * Returns all the dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByisSent(boolean isSent);

	/**
	 * Returns a range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findByisSent_First(
			boolean isSent,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByisSent_First(
		boolean isSent,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findByisSent_Last(
			boolean isSent,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByisSent_Last(
		boolean isSent,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails[] findByisSent_PrevAndNext(
			long otpId, boolean isSent,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
				orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Removes all the dgf users otp detailses where isSent = &#63; from the database.
	 *
	 * @param isSent the is sent
	 */
	public void removeByisSent(boolean isSent);

	/**
	 * Returns the number of dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	public int countByisSent(boolean isSent);

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails findByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent);

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent, boolean useFinderCache);

	/**
	 * Removes the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the dgf users otp details that was removed
	 */
	public DgfUsersOtpDetails removeByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63; and otp = &#63; and isSent = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	public int countByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent);

	/**
	 * Caches the dgf users otp details in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 */
	public void cacheResult(DgfUsersOtpDetails dgfUsersOtpDetails);

	/**
	 * Caches the dgf users otp detailses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetailses the dgf users otp detailses
	 */
	public void cacheResult(
		java.util.List<DgfUsersOtpDetails> dgfUsersOtpDetailses);

	/**
	 * Creates a new dgf users otp details with the primary key. Does not add the dgf users otp details to the database.
	 *
	 * @param otpId the primary key for the new dgf users otp details
	 * @return the new dgf users otp details
	 */
	public DgfUsersOtpDetails create(long otpId);

	/**
	 * Removes the dgf users otp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details that was removed
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails remove(long otpId)
		throws NoSuchDgfUsersOtpDetailsException;

	public DgfUsersOtpDetails updateImpl(DgfUsersOtpDetails dgfUsersOtpDetails);

	/**
	 * Returns the dgf users otp details with the primary key or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails findByPrimaryKey(long otpId)
		throws NoSuchDgfUsersOtpDetailsException;

	/**
	 * Returns the dgf users otp details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details, or <code>null</code> if a dgf users otp details with the primary key could not be found
	 */
	public DgfUsersOtpDetails fetchByPrimaryKey(long otpId);

	/**
	 * Returns all the dgf users otp detailses.
	 *
	 * @return the dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findAll();

	/**
	 * Returns a range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users otp detailses
	 */
	public java.util.List<DgfUsersOtpDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersOtpDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf users otp detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf users otp detailses.
	 *
	 * @return the number of dgf users otp detailses
	 */
	public int countAll();

}