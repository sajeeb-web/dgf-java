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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocDistrictException;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf loc district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrictUtil
 * @generated
 */
@ProviderType
public interface dgfLocDistrictPersistence
	extends BasePersistence<dgfLocDistrict> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link dgfLocDistrictUtil} to access the dgf loc district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the matching dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId);

	/**
	 * Returns a range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of matching dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	public dgfLocDistrict findBydivWiseDisFinder_First(
			long divisionId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
				orderByComparator)
		throws NoSuchdgfLocDistrictException;

	/**
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	public dgfLocDistrict fetchBydivWiseDisFinder_First(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator);

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	public dgfLocDistrict findBydivWiseDisFinder_Last(
			long divisionId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
				orderByComparator)
		throws NoSuchdgfLocDistrictException;

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	public dgfLocDistrict fetchBydivWiseDisFinder_Last(
		long divisionId,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator);

	/**
	 * Returns the dgf loc districts before and after the current dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc district
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public dgfLocDistrict[] findBydivWiseDisFinder_PrevAndNext(
			long id, long divisionId,
			com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
				orderByComparator)
		throws NoSuchdgfLocDistrictException;

	/**
	 * Removes all the dgf loc districts where divisionId = &#63; from the database.
	 *
	 * @param divisionId the division ID
	 */
	public void removeBydivWiseDisFinder(long divisionId);

	/**
	 * Returns the number of dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the number of matching dgf loc districts
	 */
	public int countBydivWiseDisFinder(long divisionId);

	/**
	 * Caches the dgf loc district in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistrict the dgf loc district
	 */
	public void cacheResult(dgfLocDistrict dgfLocDistrict);

	/**
	 * Caches the dgf loc districts in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistricts the dgf loc districts
	 */
	public void cacheResult(java.util.List<dgfLocDistrict> dgfLocDistricts);

	/**
	 * Creates a new dgf loc district with the primary key. Does not add the dgf loc district to the database.
	 *
	 * @param id the primary key for the new dgf loc district
	 * @return the new dgf loc district
	 */
	public dgfLocDistrict create(long id);

	/**
	 * Removes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public dgfLocDistrict remove(long id) throws NoSuchdgfLocDistrictException;

	public dgfLocDistrict updateImpl(dgfLocDistrict dgfLocDistrict);

	/**
	 * Returns the dgf loc district with the primary key or throws a <code>NoSuchdgfLocDistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	public dgfLocDistrict findByPrimaryKey(long id)
		throws NoSuchdgfLocDistrictException;

	/**
	 * Returns the dgf loc district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district, or <code>null</code> if a dgf loc district with the primary key could not be found
	 */
	public dgfLocDistrict fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf loc districts.
	 *
	 * @return the dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findAll();

	/**
	 * Returns a range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc districts
	 */
	public java.util.List<dgfLocDistrict> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDistrict>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf loc districts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf loc districts.
	 *
	 * @return the number of dgf loc districts
	 */
	public int countAll();

}