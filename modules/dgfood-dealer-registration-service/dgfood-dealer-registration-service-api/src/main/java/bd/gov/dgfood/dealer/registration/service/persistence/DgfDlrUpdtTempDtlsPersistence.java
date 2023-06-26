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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrUpdtTempDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr updt temp dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfDlrUpdtTempDtlsPersistence
	extends BasePersistence<DgfDlrUpdtTempDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrUpdtTempDtlsUtil} to access the dgf dlr updt temp dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo);

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_First(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_First(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_Last(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_Last(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public DgfDlrUpdtTempDtls[] findByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
			long dgfDlrUpdateReqId, long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Removes all the dgf dlr updt temp dtlses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public void removeByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns the number of dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	public int countByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId);

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public DgfDlrUpdtTempDtls[] findByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
			long dgfDlrUpdateReqId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
				orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Removes all the dgf dlr updt temp dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByDgfDlrUpdtTempDtlsByNid(String nationalId);

	/**
	 * Returns the number of dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	public int countByDgfDlrUpdtTempDtlsByNid(String nationalId);

	/**
	 * Caches the dgf dlr updt temp dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 */
	public void cacheResult(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls);

	/**
	 * Caches the dgf dlr updt temp dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtlses the dgf dlr updt temp dtlses
	 */
	public void cacheResult(
		java.util.List<DgfDlrUpdtTempDtls> dgfDlrUpdtTempDtlses);

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	public DgfDlrUpdtTempDtls create(long dgfDlrUpdateReqId);

	/**
	 * Removes the dgf dlr updt temp dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public DgfDlrUpdtTempDtls remove(long dgfDlrUpdateReqId)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	public DgfDlrUpdtTempDtls updateImpl(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls);

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or throws a <code>NoSuchDgfDlrUpdtTempDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public DgfDlrUpdtTempDtls findByPrimaryKey(long dgfDlrUpdateReqId)
		throws NoSuchDgfDlrUpdtTempDtlsException;

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls, or <code>null</code> if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public DgfDlrUpdtTempDtls fetchByPrimaryKey(long dgfDlrUpdateReqId);

	/**
	 * Returns all the dgf dlr updt temp dtlses.
	 *
	 * @return the dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findAll();

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	public java.util.List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrUpdtTempDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr updt temp dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
	 */
	public int countAll();

}