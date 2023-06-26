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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocSubdistrictException;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf loc subdistrict service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocSubdistrictUtil
 * @generated
 */
@ProviderType
public interface dgfLocSubdistrictPersistence
	extends BasePersistence<dgfLocSubdistrict> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link dgfLocSubdistrictUtil} to access the dgf loc subdistrict persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId);

	/**
	 * Returns a range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of matching dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	public dgfLocSubdistrict findBydisWiseSubDisFinder_First(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
				orderByComparator)
		throws NoSuchdgfLocSubdistrictException;

	/**
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	public dgfLocSubdistrict fetchBydisWiseSubDisFinder_First(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator);

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	public dgfLocSubdistrict findBydisWiseSubDisFinder_Last(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
				orderByComparator)
		throws NoSuchdgfLocSubdistrictException;

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	public dgfLocSubdistrict fetchBydisWiseSubDisFinder_Last(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator);

	/**
	 * Returns the dgf loc subdistricts before and after the current dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc subdistrict
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public dgfLocSubdistrict[] findBydisWiseSubDisFinder_PrevAndNext(
			long id, long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
				orderByComparator)
		throws NoSuchdgfLocSubdistrictException;

	/**
	 * Removes all the dgf loc subdistricts where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public void removeBydisWiseSubDisFinder(long districtId);

	/**
	 * Returns the number of dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching dgf loc subdistricts
	 */
	public int countBydisWiseSubDisFinder(long districtId);

	/**
	 * Caches the dgf loc subdistrict in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 */
	public void cacheResult(dgfLocSubdistrict dgfLocSubdistrict);

	/**
	 * Caches the dgf loc subdistricts in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistricts the dgf loc subdistricts
	 */
	public void cacheResult(
		java.util.List<dgfLocSubdistrict> dgfLocSubdistricts);

	/**
	 * Creates a new dgf loc subdistrict with the primary key. Does not add the dgf loc subdistrict to the database.
	 *
	 * @param id the primary key for the new dgf loc subdistrict
	 * @return the new dgf loc subdistrict
	 */
	public dgfLocSubdistrict create(long id);

	/**
	 * Removes the dgf loc subdistrict with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public dgfLocSubdistrict remove(long id)
		throws NoSuchdgfLocSubdistrictException;

	public dgfLocSubdistrict updateImpl(dgfLocSubdistrict dgfLocSubdistrict);

	/**
	 * Returns the dgf loc subdistrict with the primary key or throws a <code>NoSuchdgfLocSubdistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	public dgfLocSubdistrict findByPrimaryKey(long id)
		throws NoSuchdgfLocSubdistrictException;

	/**
	 * Returns the dgf loc subdistrict with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict, or <code>null</code> if a dgf loc subdistrict with the primary key could not be found
	 */
	public dgfLocSubdistrict fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf loc subdistricts.
	 *
	 * @return the dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findAll();

	/**
	 * Returns a range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc subdistricts
	 */
	public java.util.List<dgfLocSubdistrict> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocSubdistrict>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf loc subdistricts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf loc subdistricts.
	 *
	 * @return the number of dgf loc subdistricts
	 */
	public int countAll();

}