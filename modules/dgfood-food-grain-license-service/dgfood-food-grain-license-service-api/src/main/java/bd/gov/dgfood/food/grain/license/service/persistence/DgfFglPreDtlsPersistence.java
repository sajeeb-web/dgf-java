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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf fgl pre dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfFglPreDtlsPersistence
	extends BasePersistence<DgfFglPreDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfFglPreDtlsUtil} to access the dgf fgl pre dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo);

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache);

	/**
	 * Removes the dgf fgl pre dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl pre dtls that was removed
	 */
	public DgfFglPreDtls removeBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the number of dgf fgl pre dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByFglApplicationNo(String fglApplicationNo);

	/**
	 * Returns all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByNationalId_First(
			long nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_First(
		long nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByNationalId_Last(
			long nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_Last(
		long nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByNationalId_PrevAndNext(
			long fglPrePrimaryId, long nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeBydgfFglPreDtlsByNationalId(long nationalId);

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByNationalId(long nationalId);

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findByDgfFglPreDtlsByNID(long nationalId)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchByDgfFglPreDtlsByNID(long nationalId);

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchByDgfFglPreDtlsByNID(
		long nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf fgl pre dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl pre dtls that was removed
	 */
	public DgfFglPreDtls removeByDgfFglPreDtlsByNID(long nationalId)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countByDgfFglPreDtlsByNID(long nationalId);

	/**
	 * Returns all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_First(
			long presentAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_First(
		long presentAddrId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_Last(
			long presentAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_Last(
		long presentAddrId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
			long fglPrePrimaryId, long presentAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where presentAddrId = &#63; from the database.
	 *
	 * @param presentAddrId the present addr ID
	 */
	public void removeBydgfFglPreDtlsByPresentAddrId(long presentAddrId);

	/**
	 * Returns the number of dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByPresentAddrId(long presentAddrId);

	/**
	 * Returns all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_First(
			long bussinessAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_First(
		long bussinessAddrId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_Last(
			long bussinessAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_Last(
		long bussinessAddrId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
			long fglPrePrimaryId, long bussinessAddrId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where bussinessAddrId = &#63; from the database.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 */
	public void removeBydgfFglPreDtlsByBussinessAddrId(long bussinessAddrId);

	/**
	 * Returns the number of dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByBussinessAddrId(long bussinessAddrId);

	/**
	 * Returns all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_First(
			long tradeLicenseDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_First(
		long tradeLicenseDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_Last(
			long tradeLicenseDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_Last(
		long tradeLicenseDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
			long fglPrePrimaryId, long tradeLicenseDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where tradeLicenseDocId = &#63; from the database.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 */
	public void removeBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByTradeLicenseDocId(long tradeLicenseDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_First(
			long bussIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_First(
		long bussIdentfctDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_Last(
			long bussIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_Last(
		long bussIdentfctDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
			long fglPrePrimaryId, long bussIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where bussIdentfctDocId = &#63; from the database.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 */
	public void removeBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByBussIdentfctDocId(long bussIdentfctDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_First(
			long taxIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_First(
		long taxIdentfctDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_Last(
			long taxIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_Last(
		long taxIdentfctDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
			long fglPrePrimaryId, long taxIdentfctDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where taxIdentfctDocId = &#63; from the database.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 */
	public void removeBydgfFglPreDtlsByTaxIdentfctDocId(long taxIdentfctDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByTaxIdentfctDocId(long taxIdentfctDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_First(
			long bnkStatmtDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_First(
		long bnkStatmtDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_Last(
			long bnkStatmtDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_Last(
		long bnkStatmtDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
			long fglPrePrimaryId, long bnkStatmtDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where bnkStatmtDocId = &#63; from the database.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 */
	public void removeBydgfFglPreDtlsByBnkStatmtDocId(long bnkStatmtDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByBnkStatmtDocId(long bnkStatmtDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_First(
			long paymentChallanId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_First(
		long paymentChallanId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_Last(
			long paymentChallanId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_Last(
		long paymentChallanId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
			long fglPrePrimaryId, long paymentChallanId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where paymentChallanId = &#63; from the database.
	 *
	 * @param paymentChallanId the payment challan ID
	 */
	public void removeBydgfFglPreDtlsByPaymentChallanId(long paymentChallanId);

	/**
	 * Returns the number of dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByPaymentChallanId(long paymentChallanId);

	/**
	 * Returns all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
			long duplicateLicenseReasonId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
		long duplicateLicenseReasonId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
			long duplicateLicenseReasonId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
		long duplicateLicenseReasonId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[]
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				long fglPrePrimaryId, long duplicateLicenseReasonId,
				com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
					orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63; from the database.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 */
	public void removeBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId);

	/**
	 * Returns the number of dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId);

	/**
	 * Returns all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_First(
			long photographDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_First(
		long photographDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_Last(
			long photographDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_Last(
		long photographDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
			long fglPrePrimaryId, long photographDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where photographDocId = &#63; from the database.
	 *
	 * @param photographDocId the photograph doc ID
	 */
	public void removeBydgfFglPreDtlsByPhotographDocId(long photographDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByPhotographDocId(long photographDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByOtherReleventDocId(long otherReleventDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByOtherReleventDocId(
			long otherReleventDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByOtherReleventDocId(
			long otherReleventDocId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByOtherReleventDocId(
			long otherReleventDocId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_First(
			long otherReleventDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_First(
		long otherReleventDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_Last(
			long otherReleventDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_Last(
		long otherReleventDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
			long fglPrePrimaryId, long otherReleventDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where otherReleventDocId = &#63; from the database.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 */
	public void removeBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId);

	/**
	 * Returns all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByElectricExemptionMemoId_First(
			long electricExemptionMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByElectricExemptionMemoId_First(
		long electricExemptionMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByElectricExemptionMemoId_Last(
			long electricExemptionMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByElectricExemptionMemoId_Last(
		long electricExemptionMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[]
			findBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				long fglPrePrimaryId, long electricExemptionMemoId,
				com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
					orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where electricExemptionMemoId = &#63; from the database.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 */
	public void removeBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId);

	/**
	 * Returns the number of dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId);

	/**
	 * Returns all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_First(
			long envClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_First(
		long envClrMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_Last(
			long envClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_Last(
		long envClrMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
			long fglPrePrimaryId, long envClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where envClrMemoId = &#63; from the database.
	 *
	 * @param envClrMemoId the env clr memo ID
	 */
	public void removeBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId);

	/**
	 * Returns the number of dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId);

	/**
	 * Returns all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_First(
			long bstiClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_First(
		long bstiClrMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_Last(
			long bstiClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_Last(
		long bstiClrMemoId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
			long fglPrePrimaryId, long bstiClrMemoId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where bstiClrMemoId = &#63; from the database.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 */
	public void removeBydgfFglPreDtlsByBstiClrMemoId(long bstiClrMemoId);

	/**
	 * Returns the number of dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByBstiClrMemoId(long bstiClrMemoId);

	/**
	 * Returns all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId);

	/**
	 * Returns a range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_First(
			long fireLicNumDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_First(
		long fireLicNumDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_Last(
			long fireLicNumDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_Last(
		long fireLicNumDocId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls[] findBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
			long fglPrePrimaryId, long fireLicNumDocId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
				orderByComparator)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Removes all the dgf fgl pre dtlses where fireLicNumDocId = &#63; from the database.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 */
	public void removeBydgfFglPreDtlsByFireLicNumDocId(long fireLicNumDocId);

	/**
	 * Returns the number of dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public int countBydgfFglPreDtlsByFireLicNumDocId(long fireLicNumDocId);

	/**
	 * Caches the dgf fgl pre dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 */
	public void cacheResult(DgfFglPreDtls dgfFglPreDtls);

	/**
	 * Caches the dgf fgl pre dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtlses the dgf fgl pre dtlses
	 */
	public void cacheResult(java.util.List<DgfFglPreDtls> dgfFglPreDtlses);

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	public DgfFglPreDtls create(long fglPrePrimaryId);

	/**
	 * Removes the dgf fgl pre dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls remove(long fglPrePrimaryId)
		throws NoSuchDgfFglPreDtlsException;

	public DgfFglPreDtls updateImpl(DgfFglPreDtls dgfFglPreDtls);

	/**
	 * Returns the dgf fgl pre dtls with the primary key or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls findByPrimaryKey(long fglPrePrimaryId)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the dgf fgl pre dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls, or <code>null</code> if a dgf fgl pre dtls with the primary key could not be found
	 */
	public DgfFglPreDtls fetchByPrimaryKey(long fglPrePrimaryId);

	/**
	 * Returns all the dgf fgl pre dtlses.
	 *
	 * @return the dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findAll();

	/**
	 * Returns a range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	public java.util.List<DgfFglPreDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglPreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf fgl pre dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	public int countAll();

}