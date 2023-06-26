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

package bd.gov.dgfood.dealer.registration.service.persistence;

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrWithdrawalException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr withdrawal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawalUtil
 * @generated
 */
@ProviderType
public interface DgfDlrWithdrawalPersistence
	extends BasePersistence<DgfDlrWithdrawal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrWithdrawalUtil} to access the dgf dlr withdrawal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId);

	/**
	 * Returns a range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalId_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalId_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public DgfDlrWithdrawal[] findByDlrWithdrawalByNationalId_PrevAndNext(
			long dlrWithdrawalId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Removes all the dgf dlr withdrawals where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByDlrWithdrawalByNationalId(String nationalId);

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr withdrawals
	 */
	public int countByDlrWithdrawalByNationalId(String nationalId);

	/**
	 * Returns all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo);

	/**
	 * Returns a range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_First(
			String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_First(
		String licenseNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_Last(
			String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_Last(
		String licenseNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public DgfDlrWithdrawal[] findByDlrWithdrawalByLicenseNo_PrevAndNext(
			long dlrWithdrawalId, String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
				orderByComparator)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Removes all the dgf dlr withdrawals where licenseNo = &#63; from the database.
	 *
	 * @param licenseNo the license no
	 */
	public void removeByDlrWithdrawalByLicenseNo(String licenseNo);

	/**
	 * Returns the number of dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the number of matching dgf dlr withdrawals
	 */
	public int countByDlrWithdrawalByLicenseNo(String licenseNo);

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long dlrRegNo)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo);

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo,
		boolean useFinderCache);

	/**
	 * Removes the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr withdrawal that was removed
	 */
	public DgfDlrWithdrawal removeByDlrWithdrawalByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long dlrRegNo)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr withdrawals
	 */
	public int countByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo);

	/**
	 * Caches the dgf dlr withdrawal in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 */
	public void cacheResult(DgfDlrWithdrawal dgfDlrWithdrawal);

	/**
	 * Caches the dgf dlr withdrawals in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawals the dgf dlr withdrawals
	 */
	public void cacheResult(java.util.List<DgfDlrWithdrawal> dgfDlrWithdrawals);

	/**
	 * Creates a new dgf dlr withdrawal with the primary key. Does not add the dgf dlr withdrawal to the database.
	 *
	 * @param dlrWithdrawalId the primary key for the new dgf dlr withdrawal
	 * @return the new dgf dlr withdrawal
	 */
	public DgfDlrWithdrawal create(long dlrWithdrawalId);

	/**
	 * Removes the dgf dlr withdrawal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public DgfDlrWithdrawal remove(long dlrWithdrawalId)
		throws NoSuchDgfDlrWithdrawalException;

	public DgfDlrWithdrawal updateImpl(DgfDlrWithdrawal dgfDlrWithdrawal);

	/**
	 * Returns the dgf dlr withdrawal with the primary key or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public DgfDlrWithdrawal findByPrimaryKey(long dlrWithdrawalId)
		throws NoSuchDgfDlrWithdrawalException;

	/**
	 * Returns the dgf dlr withdrawal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal, or <code>null</code> if a dgf dlr withdrawal with the primary key could not be found
	 */
	public DgfDlrWithdrawal fetchByPrimaryKey(long dlrWithdrawalId);

	/**
	 * Returns all the dgf dlr withdrawals.
	 *
	 * @return the dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findAll();

	/**
	 * Returns a range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr withdrawals
	 */
	public java.util.List<DgfDlrWithdrawal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrWithdrawal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr withdrawals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr withdrawals.
	 *
	 * @return the number of dgf dlr withdrawals
	 */
	public int countAll();

}