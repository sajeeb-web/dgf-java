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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocUnionException;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf loc union service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnionUtil
 * @generated
 */
@ProviderType
public interface dgfLocUnionPersistence extends BasePersistence<dgfLocUnion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link dgfLocUnionUtil} to access the dgf loc union persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the matching dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId);

	/**
	 * Returns a range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of matching dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	public dgfLocUnion findBysubDisWiseUnFinder_First(
			long subdistrictId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
				orderByComparator)
		throws NoSuchdgfLocUnionException;

	/**
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	public dgfLocUnion fetchBysubDisWiseUnFinder_First(
		long subdistrictId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator);

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	public dgfLocUnion findBysubDisWiseUnFinder_Last(
			long subdistrictId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
				orderByComparator)
		throws NoSuchdgfLocUnionException;

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	public dgfLocUnion fetchBysubDisWiseUnFinder_Last(
		long subdistrictId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator);

	/**
	 * Returns the dgf loc unions before and after the current dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc union
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public dgfLocUnion[] findBysubDisWiseUnFinder_PrevAndNext(
			long id, long subdistrictId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
				orderByComparator)
		throws NoSuchdgfLocUnionException;

	/**
	 * Removes all the dgf loc unions where subdistrictId = &#63; from the database.
	 *
	 * @param subdistrictId the subdistrict ID
	 */
	public void removeBysubDisWiseUnFinder(long subdistrictId);

	/**
	 * Returns the number of dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the number of matching dgf loc unions
	 */
	public int countBysubDisWiseUnFinder(long subdistrictId);

	/**
	 * Caches the dgf loc union in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnion the dgf loc union
	 */
	public void cacheResult(dgfLocUnion dgfLocUnion);

	/**
	 * Caches the dgf loc unions in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnions the dgf loc unions
	 */
	public void cacheResult(java.util.List<dgfLocUnion> dgfLocUnions);

	/**
	 * Creates a new dgf loc union with the primary key. Does not add the dgf loc union to the database.
	 *
	 * @param id the primary key for the new dgf loc union
	 * @return the new dgf loc union
	 */
	public dgfLocUnion create(long id);

	/**
	 * Removes the dgf loc union with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union that was removed
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public dgfLocUnion remove(long id) throws NoSuchdgfLocUnionException;

	public dgfLocUnion updateImpl(dgfLocUnion dgfLocUnion);

	/**
	 * Returns the dgf loc union with the primary key or throws a <code>NoSuchdgfLocUnionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	public dgfLocUnion findByPrimaryKey(long id)
		throws NoSuchdgfLocUnionException;

	/**
	 * Returns the dgf loc union with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union, or <code>null</code> if a dgf loc union with the primary key could not be found
	 */
	public dgfLocUnion fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf loc unions.
	 *
	 * @return the dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findAll();

	/**
	 * Returns a range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc unions
	 */
	public java.util.List<dgfLocUnion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocUnion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf loc unions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf loc unions.
	 *
	 * @return the number of dgf loc unions
	 */
	public int countAll();

}