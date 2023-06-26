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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfStoreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf store dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfStoreDtlsPersistence extends BasePersistence<DgfStoreDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfStoreDtlsUtil} to access the dgf store dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf store dtls where type = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsFindByType(String type)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsFindByType(String type);

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsFindByType(
		String type, boolean useFinderCache);

	/**
	 * Removes the dgf store dtls where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the dgf store dtls that was removed
	 */
	public DgfStoreDtls removeByDgfStoreDtlsFindByType(String type)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	public int countByDgfStoreDtlsFindByType(String type);

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsFindByNid(String nationalId)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsFindByNid(String nationalId);

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsFindByNid(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the dgf store dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf store dtls that was removed
	 */
	public DgfStoreDtls removeByDgfStoreDtlsFindByNid(String nationalId)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	public int countByDgfStoreDtlsFindByNid(String nationalId);

	/**
	 * Returns all the dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type);

	/**
	 * Returns a range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsListFindByType_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByType_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsListFindByType_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByType_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public DgfStoreDtls[] findByDgfStoreDtlsListFindByType_PrevAndNext(
			long id, String type,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Removes all the dgf store dtlses where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByDgfStoreDtlsListFindByType(String type);

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	public int countByDgfStoreDtlsListFindByType(String type);

	/**
	 * Returns all the dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId);

	/**
	 * Returns a range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsListFindByNid_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls findByDgfStoreDtlsListFindByNid_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public DgfStoreDtls[] findByDgfStoreDtlsListFindByNid_PrevAndNext(
			long id, String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
				orderByComparator)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Removes all the dgf store dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByDgfStoreDtlsListFindByNid(String nationalId);

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	public int countByDgfStoreDtlsListFindByNid(String nationalId);

	/**
	 * Caches the dgf store dtls in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 */
	public void cacheResult(DgfStoreDtls dgfStoreDtls);

	/**
	 * Caches the dgf store dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtlses the dgf store dtlses
	 */
	public void cacheResult(java.util.List<DgfStoreDtls> dgfStoreDtlses);

	/**
	 * Creates a new dgf store dtls with the primary key. Does not add the dgf store dtls to the database.
	 *
	 * @param id the primary key for the new dgf store dtls
	 * @return the new dgf store dtls
	 */
	public DgfStoreDtls create(long id);

	/**
	 * Removes the dgf store dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls that was removed
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public DgfStoreDtls remove(long id) throws NoSuchDgfStoreDtlsException;

	public DgfStoreDtls updateImpl(DgfStoreDtls dgfStoreDtls);

	/**
	 * Returns the dgf store dtls with the primary key or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	public DgfStoreDtls findByPrimaryKey(long id)
		throws NoSuchDgfStoreDtlsException;

	/**
	 * Returns the dgf store dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls, or <code>null</code> if a dgf store dtls with the primary key could not be found
	 */
	public DgfStoreDtls fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf store dtlses.
	 *
	 * @return the dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findAll();

	/**
	 * Returns a range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf store dtlses
	 */
	public java.util.List<DgfStoreDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfStoreDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf store dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf store dtlses.
	 *
	 * @return the number of dgf store dtlses
	 */
	public int countAll();

}