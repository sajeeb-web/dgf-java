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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersAddrDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users addr dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfUsersAddrDtlsPersistence
	extends BasePersistence<DgfUsersAddrDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersAddrDtlsUtil} to access the dgf users addr dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId);

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf users addr dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users addr dtls that was removed
	 */
	public DgfUsersAddrDtls removeBydgfUsersAddrDtlsByNationalId(
			long nationalId)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the number of dgf users addr dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countBydgfUsersAddrDtlsByNationalId(long nationalId);

	/**
	 * Returns all the dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district);

	/**
	 * Returns a range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_First(
			long district,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_First(
		long district,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_Last(
			long district,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_Last(
		long district,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByDistrict_PrevAndNext(
			long addressId, long district,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	public void removeBydgfUsersAddrDtlsByDistrict(long district);

	/**
	 * Returns the number of dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countBydgfUsersAddrDtlsByDistrict(long district);

	/**
	 * Returns all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla);

	/**
	 * Returns a range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_First(
			long upzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_First(
		long upzilla,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_Last(
			long upzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_Last(
		long upzilla,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
			long addressId, long upzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where upzilla = &#63; from the database.
	 *
	 * @param upzilla the upzilla
	 */
	public void removeBydgfUsersAddrDtlsByUpzilla(long upzilla);

	/**
	 * Returns the number of dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countBydgfUsersAddrDtlsByUpzilla(long upzilla);

	/**
	 * Returns all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName);

	/**
	 * Returns a range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_First(
			long unionName,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_First(
		long unionName,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_Last(
			long unionName,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_Last(
		long unionName,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByUnion_PrevAndNext(
			long addressId, long unionName,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where unionName = &#63; from the database.
	 *
	 * @param unionName the union name
	 */
	public void removeBydgfUsersAddrDtlsByUnion(long unionName);

	/**
	 * Returns the number of dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countBydgfUsersAddrDtlsByUnion(long unionName);

	/**
	 * Returns all the dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward);

	/**
	 * Returns a range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_First(
			String ward,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_First(
		String ward,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_Last(
			String ward,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_Last(
		String ward,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByWard_PrevAndNext(
			long addressId, String ward,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where ward = &#63; from the database.
	 *
	 * @param ward the ward
	 */
	public void removeBydgfUsersAddrDtlsByWard(String ward);

	/**
	 * Returns the number of dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countBydgfUsersAddrDtlsByWard(String ward);

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla);

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				long division, long district, long upzilla,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
			long division, long district, long upzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				long division, long district, long upzilla,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
			long division, long district, long upzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
				long addressId, long division, long district, long upzilla,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 */
	public void removeByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla);

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla);

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district);

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findByDgfUsersAddrDtlsByDivisionAndDistrict_First(
			long division, long district,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchByDgfUsersAddrDtlsByDivisionAndDistrict_First(
		long division, long district,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls findByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
			long division, long district,
			com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
				orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public DgfUsersAddrDtls fetchByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
		long division, long district,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				long addressId, long division, long district,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 */
	public void removeByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district);

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	public int countByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district);

	/**
	 * Caches the dgf users addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 */
	public void cacheResult(DgfUsersAddrDtls dgfUsersAddrDtls);

	/**
	 * Caches the dgf users addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtlses the dgf users addr dtlses
	 */
	public void cacheResult(
		java.util.List<DgfUsersAddrDtls> dgfUsersAddrDtlses);

	/**
	 * Creates a new dgf users addr dtls with the primary key. Does not add the dgf users addr dtls to the database.
	 *
	 * @param addressId the primary key for the new dgf users addr dtls
	 * @return the new dgf users addr dtls
	 */
	public DgfUsersAddrDtls create(long addressId);

	/**
	 * Removes the dgf users addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls remove(long addressId)
		throws NoSuchDgfUsersAddrDtlsException;

	public DgfUsersAddrDtls updateImpl(DgfUsersAddrDtls dgfUsersAddrDtls);

	/**
	 * Returns the dgf users addr dtls with the primary key or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls findByPrimaryKey(long addressId)
		throws NoSuchDgfUsersAddrDtlsException;

	/**
	 * Returns the dgf users addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls, or <code>null</code> if a dgf users addr dtls with the primary key could not be found
	 */
	public DgfUsersAddrDtls fetchByPrimaryKey(long addressId);

	/**
	 * Returns all the dgf users addr dtlses.
	 *
	 * @return the dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findAll();

	/**
	 * Returns a range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users addr dtlses
	 */
	public java.util.List<DgfUsersAddrDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf users addr dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf users addr dtlses.
	 *
	 * @return the number of dgf users addr dtlses
	 */
	public int countAll();

}