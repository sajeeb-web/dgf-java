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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDuplctLicnsReasonException;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf duplct licns reason service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReasonUtil
 * @generated
 */
@ProviderType
public interface DgfDuplctLicnsReasonPersistence
	extends BasePersistence<DgfDuplctLicnsReason> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDuplctLicnsReasonUtil} to access the dgf duplct licns reason persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicUserIdFinder(long userId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(long userId);

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(
		long userId, boolean useFinderCache);

	/**
	 * Removes the dgf duplct licns reason where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public DgfDuplctLicnsReason removeByduplicateLicUserIdFinder(long userId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the number of dgf duplct licns reasons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicUserIdFinder(long userId);

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicNationalIdFinder(
			String nationalId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId);

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf duplct licns reason where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public DgfDuplctLicnsReason removeByduplicateLicNationalIdFinder(
			String nationalId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicNationalIdFinder(String nationalId);

	/**
	 * Returns all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo);

	/**
	 * Returns a range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_First(
				String nationalId, String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_Last(
				String nationalId, String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason[]
			findByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo);

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason[]
			filterFindByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Removes all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	public void removeByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	public int filterCountByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo);

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId);

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache);

	/**
	 * Removes the dgf duplct licns reason where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public DgfDuplctLicnsReason removeByduplicateLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the number of dgf duplct licns reasons where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicTradeLicAttchIdFinder(long tradeLicAttchId);

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId);

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache);

	/**
	 * Removes the dgf duplct licns reason where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public DgfDuplctLicnsReason removeByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the number of dgf duplct licns reasons where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicPaymentAttchIdFinder(long paymentAttchId);

	/**
	 * Returns all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns a range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicFglPrePrimaryIdFinder_First(
		long fglPrePrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDuplctLicnsReason>
			orderByComparator);

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicFglPrePrimaryIdFinder_Last(
		long fglPrePrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDuplctLicnsReason>
			orderByComparator);

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason[]
			findByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public java.util.List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDuplctLicnsReason> orderByComparator);

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason[]
			filterFindByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Removes all the dgf duplct licns reasons where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	public void removeByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns the number of dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId);

	/**
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	public int filterCountByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId);

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason findByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo);

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache);

	/**
	 * Removes the dgf duplct licns reason where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf duplct licns reason that was removed
	 */
	public DgfDuplctLicnsReason removeByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the number of dgf duplct licns reasons where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf duplct licns reasons
	 */
	public int countByduplicateLicApplicationNoFinder(String applicationNo);

	/**
	 * Caches the dgf duplct licns reason in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 */
	public void cacheResult(DgfDuplctLicnsReason dgfDuplctLicnsReason);

	/**
	 * Caches the dgf duplct licns reasons in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReasons the dgf duplct licns reasons
	 */
	public void cacheResult(
		java.util.List<DgfDuplctLicnsReason> dgfDuplctLicnsReasons);

	/**
	 * Creates a new dgf duplct licns reason with the primary key. Does not add the dgf duplct licns reason to the database.
	 *
	 * @param duplicateLicenseReasonID the primary key for the new dgf duplct licns reason
	 * @return the new dgf duplct licns reason
	 */
	public DgfDuplctLicnsReason create(long duplicateLicenseReasonID);

	/**
	 * Removes the dgf duplct licns reason with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason remove(long duplicateLicenseReasonID)
		throws NoSuchDgfDuplctLicnsReasonException;

	public DgfDuplctLicnsReason updateImpl(
		DgfDuplctLicnsReason dgfDuplctLicnsReason);

	/**
	 * Returns the dgf duplct licns reason with the primary key or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason findByPrimaryKey(long duplicateLicenseReasonID)
		throws NoSuchDgfDuplctLicnsReasonException;

	/**
	 * Returns the dgf duplct licns reason with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason, or <code>null</code> if a dgf duplct licns reason with the primary key could not be found
	 */
	public DgfDuplctLicnsReason fetchByPrimaryKey(
		long duplicateLicenseReasonID);

	/**
	 * Returns all the dgf duplct licns reasons.
	 *
	 * @return the dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason> findAll();

	/**
	 * Returns a range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDuplctLicnsReason>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf duplct licns reasons
	 */
	public java.util.List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDuplctLicnsReason>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf duplct licns reasons from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf duplct licns reasons.
	 *
	 * @return the number of dgf duplct licns reasons
	 */
	public int countAll();

}