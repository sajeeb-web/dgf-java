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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfRenewLicenseException;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf renew license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicenseUtil
 * @generated
 */
@ProviderType
public interface DgfRenewLicensePersistence
	extends BasePersistence<DgfRenewLicense> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfRenewLicenseUtil} to access the dgf renew license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf renew license where userId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicUserIdFinder(long userId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicUserIdFinder(long userId);

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicUserIdFinder(
		long userId, boolean useFinderCache);

	/**
	 * Removes the dgf renew license where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf renew license that was removed
	 */
	public DgfRenewLicense removeByrenewLicUserIdFinder(long userId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the number of dgf renew licenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicUserIdFinder(long userId);

	/**
	 * Returns the dgf renew license where nationalId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicNationalIdFinder(String nationalId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicNationalIdFinder(String nationalId);

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicNationalIdFinder(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf renew license where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf renew license that was removed
	 */
	public DgfRenewLicense removeByrenewLicNationalIdFinder(String nationalId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicNationalIdFinder(String nationalId);

	/**
	 * Returns all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo);

	/**
	 * Returns a range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicNationalIdAndLicenseFinder_First(
		String nationalId, String licenseNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicNationalIdAndLicenseFinder_Last(
		String nationalId, String licenseNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense[]
			findByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo);

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator);

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense[]
			filterFindByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Removes all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	public void removeByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	public int filterCountByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId);

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache);

	/**
	 * Removes the dgf renew license where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf renew license that was removed
	 */
	public DgfRenewLicense removeByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the number of dgf renew licenses where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicTradeLicAttchIdFinder(long tradeLicAttchId);

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId);

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache);

	/**
	 * Removes the dgf renew license where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf renew license that was removed
	 */
	public DgfRenewLicense removeByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the number of dgf renew licenses where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicPaymentAttchIdFinder(long paymentAttchId);

	/**
	 * Returns all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId);

	/**
	 * Returns a range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_First(
		long fglPrePrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_Last(
		long fglPrePrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense[] findByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
			long renewLicenseId, long fglPrePrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	public java.util.List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
				orderByComparator);

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense[]
			filterFindByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				long renewLicenseId, long fglPrePrimaryId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Removes all the dgf renew licenses where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	public void removeByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns the number of dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	public int filterCountByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense findByrenewLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo);

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache);

	/**
	 * Removes the dgf renew license where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf renew license that was removed
	 */
	public DgfRenewLicense removeByrenewLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the number of dgf renew licenses where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf renew licenses
	 */
	public int countByrenewLicApplicationNoFinder(String applicationNo);

	/**
	 * Caches the dgf renew license in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicense the dgf renew license
	 */
	public void cacheResult(DgfRenewLicense dgfRenewLicense);

	/**
	 * Caches the dgf renew licenses in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicenses the dgf renew licenses
	 */
	public void cacheResult(java.util.List<DgfRenewLicense> dgfRenewLicenses);

	/**
	 * Creates a new dgf renew license with the primary key. Does not add the dgf renew license to the database.
	 *
	 * @param renewLicenseId the primary key for the new dgf renew license
	 * @return the new dgf renew license
	 */
	public DgfRenewLicense create(long renewLicenseId);

	/**
	 * Removes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense remove(long renewLicenseId)
		throws NoSuchDgfRenewLicenseException;

	public DgfRenewLicense updateImpl(DgfRenewLicense dgfRenewLicense);

	/**
	 * Returns the dgf renew license with the primary key or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense findByPrimaryKey(long renewLicenseId)
		throws NoSuchDgfRenewLicenseException;

	/**
	 * Returns the dgf renew license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license, or <code>null</code> if a dgf renew license with the primary key could not be found
	 */
	public DgfRenewLicense fetchByPrimaryKey(long renewLicenseId);

	/**
	 * Returns all the dgf renew licenses.
	 *
	 * @return the dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findAll();

	/**
	 * Returns a range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf renew licenses
	 */
	public java.util.List<DgfRenewLicense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfRenewLicense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf renew licenses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf renew licenses.
	 *
	 * @return the number of dgf renew licenses
	 */
	public int countAll();

}