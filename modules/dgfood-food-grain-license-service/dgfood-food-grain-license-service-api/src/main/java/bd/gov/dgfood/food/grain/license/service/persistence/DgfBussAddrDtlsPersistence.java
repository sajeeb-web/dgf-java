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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfBussAddrDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf buss addr dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfBussAddrDtlsPersistence
	extends BasePersistence<DgfBussAddrDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfBussAddrDtlsUtil} to access the dgf buss addr dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessDistrict(long businessDistrict);

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessDistrict(
			long businessDistrict, int start, int end);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessDistrict(
			long businessDistrict, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessDistrict(
			long businessDistrict, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_First(
			long businessDistrict,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessDistrict_First(
		long businessDistrict,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_Last(
			long businessDistrict,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessDistrict_Last(
		long businessDistrict,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				long businessAddressId, long businessDistrict,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Removes all the dgf buss addr dtlses where businessDistrict = &#63; from the database.
	 *
	 * @param businessDistrict the business district
	 */
	public void removeBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict);

	/**
	 * Returns the number of dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the number of matching dgf buss addr dtlses
	 */
	public int countBydgfBussAddrDtlsByBusinessDistrict(long businessDistrict);

	/**
	 * Returns all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUpzilla(long businessUpzilla);

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUpzilla(
			long businessUpzilla, int start, int end);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUpzilla(
			long businessUpzilla, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUpzilla(
			long businessUpzilla, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_First(
			long businessUpzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_First(
		long businessUpzilla,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_Last(
			long businessUpzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_Last(
		long businessUpzilla,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls[] findBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
			long businessAddressId, long businessUpzilla,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Removes all the dgf buss addr dtlses where businessUpzilla = &#63; from the database.
	 *
	 * @param businessUpzilla the business upzilla
	 */
	public void removeBydgfBussAddrDtlsByBusinessUpzilla(long businessUpzilla);

	/**
	 * Returns the number of dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the number of matching dgf buss addr dtlses
	 */
	public int countBydgfBussAddrDtlsByBusinessUpzilla(long businessUpzilla);

	/**
	 * Returns all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(long businessUnionName);

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls>
		findBydgfBussAddrDtlsByBusinessUnionName(
			long businessUnionName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUnionName_First(
			long businessUnionName,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUnionName_First(
		long businessUnionName,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUnionName_Last(
			long businessUnionName,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUnionName_Last(
		long businessUnionName,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				long businessAddressId, long businessUnionName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Removes all the dgf buss addr dtlses where businessUnionName = &#63; from the database.
	 *
	 * @param businessUnionName the business union name
	 */
	public void removeBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName);

	/**
	 * Returns the number of dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the number of matching dgf buss addr dtlses
	 */
	public int countBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName);

	/**
	 * Returns all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard);

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_First(
			String businessWard,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_First(
		String businessWard,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_Last(
			String businessWard,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_Last(
		String businessWard,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls[] findBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
			long businessAddressId, String businessWard,
			com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
				orderByComparator)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Removes all the dgf buss addr dtlses where businessWard = &#63; from the database.
	 *
	 * @param businessWard the business ward
	 */
	public void removeBydgfBussAddrDtlsByBusinessWard(String businessWard);

	/**
	 * Returns the number of dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the number of matching dgf buss addr dtlses
	 */
	public int countBydgfBussAddrDtlsByBusinessWard(String businessWard);

	/**
	 * Caches the dgf buss addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 */
	public void cacheResult(DgfBussAddrDtls dgfBussAddrDtls);

	/**
	 * Caches the dgf buss addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtlses the dgf buss addr dtlses
	 */
	public void cacheResult(java.util.List<DgfBussAddrDtls> dgfBussAddrDtlses);

	/**
	 * Creates a new dgf buss addr dtls with the primary key. Does not add the dgf buss addr dtls to the database.
	 *
	 * @param businessAddressId the primary key for the new dgf buss addr dtls
	 * @return the new dgf buss addr dtls
	 */
	public DgfBussAddrDtls create(long businessAddressId);

	/**
	 * Removes the dgf buss addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls remove(long businessAddressId)
		throws NoSuchDgfBussAddrDtlsException;

	public DgfBussAddrDtls updateImpl(DgfBussAddrDtls dgfBussAddrDtls);

	/**
	 * Returns the dgf buss addr dtls with the primary key or throws a <code>NoSuchDgfBussAddrDtlsException</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls findByPrimaryKey(long businessAddressId)
		throws NoSuchDgfBussAddrDtlsException;

	/**
	 * Returns the dgf buss addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls, or <code>null</code> if a dgf buss addr dtls with the primary key could not be found
	 */
	public DgfBussAddrDtls fetchByPrimaryKey(long businessAddressId);

	/**
	 * Returns all the dgf buss addr dtlses.
	 *
	 * @return the dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findAll();

	/**
	 * Returns a range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf buss addr dtlses
	 */
	public java.util.List<DgfBussAddrDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBussAddrDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf buss addr dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf buss addr dtlses.
	 *
	 * @return the number of dgf buss addr dtlses
	 */
	public int countAll();

}