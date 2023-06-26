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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegAddlDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr reg addl dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfDlrRegAddlDtlsPersistence
	extends BasePersistence<DgfDlrRegAddlDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrRegAddlDtlsUtil} to access the dgf dlr reg addl dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache);

	/**
	 * Removes the dgf dlr reg addl dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg addl dtls that was removed
	 */
	public DgfDlrRegAddlDtls removeByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Returns the number of dgf dlr reg addl dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	public int countByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId);

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of matching dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
				orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator);

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
				orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator);

	/**
	 * Returns the dgf dlr reg addl dtlses before and after the current dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the current dgf dlr reg addl dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public DgfDlrRegAddlDtls[] findByDgfDlrRegAddlDtlsByNid_PrevAndNext(
			long dlrRegAddlDtlsId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
				orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Removes all the dgf dlr reg addl dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByDgfDlrRegAddlDtlsByNid(String nationalId);

	/**
	 * Returns the number of dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	public int countByDgfDlrRegAddlDtlsByNid(String nationalId);

	/**
	 * Caches the dgf dlr reg addl dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 */
	public void cacheResult(DgfDlrRegAddlDtls dgfDlrRegAddlDtls);

	/**
	 * Caches the dgf dlr reg addl dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtlses the dgf dlr reg addl dtlses
	 */
	public void cacheResult(
		java.util.List<DgfDlrRegAddlDtls> dgfDlrRegAddlDtlses);

	/**
	 * Creates a new dgf dlr reg addl dtls with the primary key. Does not add the dgf dlr reg addl dtls to the database.
	 *
	 * @param dlrRegAddlDtlsId the primary key for the new dgf dlr reg addl dtls
	 * @return the new dgf dlr reg addl dtls
	 */
	public DgfDlrRegAddlDtls create(long dlrRegAddlDtlsId);

	/**
	 * Removes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public DgfDlrRegAddlDtls remove(long dlrRegAddlDtlsId)
		throws NoSuchDgfDlrRegAddlDtlsException;

	public DgfDlrRegAddlDtls updateImpl(DgfDlrRegAddlDtls dgfDlrRegAddlDtls);

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public DgfDlrRegAddlDtls findByPrimaryKey(long dlrRegAddlDtlsId)
		throws NoSuchDgfDlrRegAddlDtlsException;

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls, or <code>null</code> if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public DgfDlrRegAddlDtls fetchByPrimaryKey(long dlrRegAddlDtlsId);

	/**
	 * Returns all the dgf dlr reg addl dtlses.
	 *
	 * @return the dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findAll();

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	public java.util.List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrRegAddlDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr reg addl dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr reg addl dtlses.
	 *
	 * @return the number of dgf dlr reg addl dtlses
	 */
	public int countAll();

}