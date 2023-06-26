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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrPerfDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr perf dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfDlrPerfDtlsPersistence
	extends BasePersistence<DgfDlrPerfDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrPerfDtlsUtil} to access the dgf dlr perf dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache);

	/**
	 * Removes the dgf dlr perf dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr perf dtls that was removed
	 */
	public DgfDlrPerfDtls removeByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Returns the number of dgf dlr perf dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr perf dtlses
	 */
	public int countByDgfDlrPerfDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId);

	/**
	 * Returns a range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of matching dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
				orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator);

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
				orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator);

	/**
	 * Returns the dgf dlr perf dtlses before and after the current dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrPerfId the primary key of the current dgf dlr perf dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public DgfDlrPerfDtls[] findByDgfDlrPerfDtlsByNid_PrevAndNext(
			long dgfDlrPerfId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
				orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Removes all the dgf dlr perf dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByDgfDlrPerfDtlsByNid(String nationalId);

	/**
	 * Returns the number of dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr perf dtlses
	 */
	public int countByDgfDlrPerfDtlsByNid(String nationalId);

	/**
	 * Caches the dgf dlr perf dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 */
	public void cacheResult(DgfDlrPerfDtls dgfDlrPerfDtls);

	/**
	 * Caches the dgf dlr perf dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtlses the dgf dlr perf dtlses
	 */
	public void cacheResult(java.util.List<DgfDlrPerfDtls> dgfDlrPerfDtlses);

	/**
	 * Creates a new dgf dlr perf dtls with the primary key. Does not add the dgf dlr perf dtls to the database.
	 *
	 * @param dgfDlrPerfId the primary key for the new dgf dlr perf dtls
	 * @return the new dgf dlr perf dtls
	 */
	public DgfDlrPerfDtls create(long dgfDlrPerfId);

	/**
	 * Removes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public DgfDlrPerfDtls remove(long dgfDlrPerfId)
		throws NoSuchDgfDlrPerfDtlsException;

	public DgfDlrPerfDtls updateImpl(DgfDlrPerfDtls dgfDlrPerfDtls);

	/**
	 * Returns the dgf dlr perf dtls with the primary key or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public DgfDlrPerfDtls findByPrimaryKey(long dgfDlrPerfId)
		throws NoSuchDgfDlrPerfDtlsException;

	/**
	 * Returns the dgf dlr perf dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls, or <code>null</code> if a dgf dlr perf dtls with the primary key could not be found
	 */
	public DgfDlrPerfDtls fetchByPrimaryKey(long dgfDlrPerfId);

	/**
	 * Returns all the dgf dlr perf dtlses.
	 *
	 * @return the dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findAll();

	/**
	 * Returns a range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	public java.util.List<DgfDlrPerfDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrPerfDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr perf dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr perf dtlses.
	 *
	 * @return the number of dgf dlr perf dtlses
	 */
	public int countAll();

}