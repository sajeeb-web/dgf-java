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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr reg dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfDlrRegDtlsPersistence
	extends BasePersistence<DgfDlrRegDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrRegDtlsUtil} to access the dgf dlr reg dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls findByDgfDlrRegDtlsByNid(String nationalId)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(String nationalId);

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByNid(String nationalId)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public int countByDgfDlrRegDtlsByNid(String nationalId);

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo);

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo,
		boolean useFinderCache);

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg dtls that was removed
	 */
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public int countByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo);

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls findByDgfDlrRegDtlsByUserId(long userId)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(long userId);

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(
		long userId, boolean useFinderCache);

	/**
	 * Removes the dgf dlr reg dtls where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByUserId(long userId)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the number of dgf dlr reg dtlses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public int countByDgfDlrRegDtlsByUserId(long userId);

	/**
	 * Caches the dgf dlr reg dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 */
	public void cacheResult(DgfDlrRegDtls dgfDlrRegDtls);

	/**
	 * Caches the dgf dlr reg dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtlses the dgf dlr reg dtlses
	 */
	public void cacheResult(java.util.List<DgfDlrRegDtls> dgfDlrRegDtlses);

	/**
	 * Creates a new dgf dlr reg dtls with the primary key. Does not add the dgf dlr reg dtls to the database.
	 *
	 * @param dlrRegNo the primary key for the new dgf dlr reg dtls
	 * @return the new dgf dlr reg dtls
	 */
	public DgfDlrRegDtls create(long dlrRegNo);

	/**
	 * Removes the dgf dlr reg dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public DgfDlrRegDtls remove(long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException;

	public DgfDlrRegDtls updateImpl(DgfDlrRegDtls dgfDlrRegDtls);

	/**
	 * Returns the dgf dlr reg dtls with the primary key or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public DgfDlrRegDtls findByPrimaryKey(long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException;

	/**
	 * Returns the dgf dlr reg dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls, or <code>null</code> if a dgf dlr reg dtls with the primary key could not be found
	 */
	public DgfDlrRegDtls fetchByPrimaryKey(long dlrRegNo);

	/**
	 * Returns all the dgf dlr reg dtlses.
	 *
	 * @return the dgf dlr reg dtlses
	 */
	public java.util.List<DgfDlrRegDtls> findAll();

	/**
	 * Returns a range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @return the range of dgf dlr reg dtlses
	 */
	public java.util.List<DgfDlrRegDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	public java.util.List<DgfDlrRegDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	public java.util.List<DgfDlrRegDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr reg dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr reg dtlses.
	 *
	 * @return the number of dgf dlr reg dtlses
	 */
	public int countAll();

}