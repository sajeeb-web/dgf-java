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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfUsersDtlsPersistence extends BasePersistence<DgfUsersDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersDtlsUtil} to access the dgf users dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a matching dgf users dtls could not be found
	 */
	public DgfUsersDtls findBydgfUsersDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersDtlsException;

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	public DgfUsersDtls fetchBydgfUsersDtlsByNationalId(long nationalId);

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	public DgfUsersDtls fetchBydgfUsersDtlsByNationalId(
		long nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf users dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users dtls that was removed
	 */
	public DgfUsersDtls removeBydgfUsersDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersDtlsException;

	/**
	 * Returns the number of dgf users dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users dtlses
	 */
	public int countBydgfUsersDtlsByNationalId(long nationalId);

	/**
	 * Caches the dgf users dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 */
	public void cacheResult(DgfUsersDtls dgfUsersDtls);

	/**
	 * Caches the dgf users dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtlses the dgf users dtlses
	 */
	public void cacheResult(java.util.List<DgfUsersDtls> dgfUsersDtlses);

	/**
	 * Creates a new dgf users dtls with the primary key. Does not add the dgf users dtls to the database.
	 *
	 * @param userDetailsId the primary key for the new dgf users dtls
	 * @return the new dgf users dtls
	 */
	public DgfUsersDtls create(long userDetailsId);

	/**
	 * Removes the dgf users dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls that was removed
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	public DgfUsersDtls remove(long userDetailsId)
		throws NoSuchDgfUsersDtlsException;

	public DgfUsersDtls updateImpl(DgfUsersDtls dgfUsersDtls);

	/**
	 * Returns the dgf users dtls with the primary key or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	public DgfUsersDtls findByPrimaryKey(long userDetailsId)
		throws NoSuchDgfUsersDtlsException;

	/**
	 * Returns the dgf users dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls, or <code>null</code> if a dgf users dtls with the primary key could not be found
	 */
	public DgfUsersDtls fetchByPrimaryKey(long userDetailsId);

	/**
	 * Returns all the dgf users dtlses.
	 *
	 * @return the dgf users dtlses
	 */
	public java.util.List<DgfUsersDtls> findAll();

	/**
	 * Returns a range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @return the range of dgf users dtlses
	 */
	public java.util.List<DgfUsersDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users dtlses
	 */
	public java.util.List<DgfUsersDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users dtlses
	 */
	public java.util.List<DgfUsersDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfUsersDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf users dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf users dtlses.
	 *
	 * @return the number of dgf users dtlses
	 */
	public int countAll();

}