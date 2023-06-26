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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf fgl lic dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfFglLicDtlsPersistence
	extends BasePersistence<DgfFglLicDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfFglLicDtlsUtil} to access the dgf fgl lic dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId);

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId, boolean useFinderCache);

	/**
	 * Removes the dgf fgl lic dtls where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	public DgfFglLicDtls removeBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the number of dgf fgl lic dtlses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsByFglLicPrePrimaryId(long fglPrePrimaryId);

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsByNationalId(String nationalId)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(String nationalId);

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	public DgfFglLicDtls removeBydgfFglLicDtlsByNationalId(String nationalId)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsByNationalId(String nationalId);

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo);

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache);

	/**
	 * Removes the dgf fgl lic dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public DgfFglLicDtls removeBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the number of dgf fgl lic dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsByFglApplicationNo(String fglApplicationNo);

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo);

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo, boolean useFinderCache);

	/**
	 * Removes the dgf fgl lic dtls where foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public DgfFglLicDtls removeBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the number of dgf fgl lic dtlses where foodgrainLicenseNo = &#63;.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo);

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo);

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo, boolean useFinderCache);

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public DgfFglLicDtls removeBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63; and foodgrainLicenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo);

	/**
	 * Returns all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId);

	/**
	 * Returns a range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of matching dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsListByNid_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
				orderByComparator)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls findBydgfFglLicDtlsListByNid_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
				orderByComparator)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl lic dtlses before and after the current dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglLicPrimaryId the primary key of the current dgf fgl lic dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public DgfFglLicDtls[] findBydgfFglLicDtlsListByNid_PrevAndNext(
			long fglLicPrimaryId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
				orderByComparator)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Removes all the dgf fgl lic dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeBydgfFglLicDtlsListByNid(String nationalId);

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public int countBydgfFglLicDtlsListByNid(String nationalId);

	/**
	 * Caches the dgf fgl lic dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 */
	public void cacheResult(DgfFglLicDtls dgfFglLicDtls);

	/**
	 * Caches the dgf fgl lic dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtlses the dgf fgl lic dtlses
	 */
	public void cacheResult(java.util.List<DgfFglLicDtls> dgfFglLicDtlses);

	/**
	 * Creates a new dgf fgl lic dtls with the primary key. Does not add the dgf fgl lic dtls to the database.
	 *
	 * @param fglLicPrimaryId the primary key for the new dgf fgl lic dtls
	 * @return the new dgf fgl lic dtls
	 */
	public DgfFglLicDtls create(long fglLicPrimaryId);

	/**
	 * Removes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public DgfFglLicDtls remove(long fglLicPrimaryId)
		throws NoSuchDgfFglLicDtlsException;

	public DgfFglLicDtls updateImpl(DgfFglLicDtls dgfFglLicDtls);

	/**
	 * Returns the dgf fgl lic dtls with the primary key or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public DgfFglLicDtls findByPrimaryKey(long fglLicPrimaryId)
		throws NoSuchDgfFglLicDtlsException;

	/**
	 * Returns the dgf fgl lic dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls, or <code>null</code> if a dgf fgl lic dtls with the primary key could not be found
	 */
	public DgfFglLicDtls fetchByPrimaryKey(long fglLicPrimaryId);

	/**
	 * Returns all the dgf fgl lic dtlses.
	 *
	 * @return the dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findAll();

	/**
	 * Returns a range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	public java.util.List<DgfFglLicDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf fgl lic dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf fgl lic dtlses.
	 *
	 * @return the number of dgf fgl lic dtlses
	 */
	public int countAll();

}