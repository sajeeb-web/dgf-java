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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglProductDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf fgl product dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfFglProductDtlsPersistence
	extends BasePersistence<DgfFglProductDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfFglProductDtlsUtil} to access the dgf fgl product dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(long fglLicPrimaryId);

	/**
	 * Returns a range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls findBydgfFglProductDtlsByFglLicPrimaryId_First(
			long fglLicPrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls fetchBydgfFglProductDtlsByFglLicPrimaryId_First(
		long fglLicPrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls findBydgfFglProductDtlsByFglLicPrimaryId_Last(
			long fglLicPrimaryId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls fetchBydgfFglProductDtlsByFglLicPrimaryId_Last(
		long fglLicPrimaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public DgfFglProductDtls[]
			findBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				long fglProductPrimaryId, long fglLicPrimaryId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Removes all the dgf fgl product dtlses where fglLicPrimaryId = &#63; from the database.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 */
	public void removeBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId);

	/**
	 * Returns the number of dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	public int countBydgfFglProductDtlsByFglLicPrimaryId(long fglLicPrimaryId);

	/**
	 * Returns all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByNationalId(String nationalId);

	/**
	 * Returns a range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByNationalId(
			String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByNationalId(
			String nationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls>
		findBydgfFglProductDtlsByNationalId(
			String nationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls findBydgfFglProductDtlsByNationalId_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator);

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls findBydgfFglProductDtlsByNationalId_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator);

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public DgfFglProductDtls[] findBydgfFglProductDtlsByNationalId_PrevAndNext(
			long fglProductPrimaryId, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
				orderByComparator)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Removes all the dgf fgl product dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeBydgfFglProductDtlsByNationalId(String nationalId);

	/**
	 * Returns the number of dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	public int countBydgfFglProductDtlsByNationalId(String nationalId);

	/**
	 * Caches the dgf fgl product dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 */
	public void cacheResult(DgfFglProductDtls dgfFglProductDtls);

	/**
	 * Caches the dgf fgl product dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtlses the dgf fgl product dtlses
	 */
	public void cacheResult(
		java.util.List<DgfFglProductDtls> dgfFglProductDtlses);

	/**
	 * Creates a new dgf fgl product dtls with the primary key. Does not add the dgf fgl product dtls to the database.
	 *
	 * @param fglProductPrimaryId the primary key for the new dgf fgl product dtls
	 * @return the new dgf fgl product dtls
	 */
	public DgfFglProductDtls create(long fglProductPrimaryId);

	/**
	 * Removes the dgf fgl product dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public DgfFglProductDtls remove(long fglProductPrimaryId)
		throws NoSuchDgfFglProductDtlsException;

	public DgfFglProductDtls updateImpl(DgfFglProductDtls dgfFglProductDtls);

	/**
	 * Returns the dgf fgl product dtls with the primary key or throws a <code>NoSuchDgfFglProductDtlsException</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public DgfFglProductDtls findByPrimaryKey(long fglProductPrimaryId)
		throws NoSuchDgfFglProductDtlsException;

	/**
	 * Returns the dgf fgl product dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls, or <code>null</code> if a dgf fgl product dtls with the primary key could not be found
	 */
	public DgfFglProductDtls fetchByPrimaryKey(long fglProductPrimaryId);

	/**
	 * Returns all the dgf fgl product dtlses.
	 *
	 * @return the dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls> findAll();

	/**
	 * Returns a range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl product dtlses
	 */
	public java.util.List<DgfFglProductDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglProductDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf fgl product dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf fgl product dtlses.
	 *
	 * @return the number of dgf fgl product dtlses
	 */
	public int countAll();

}