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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocDivisionException;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf loc division service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDivisionUtil
 * @generated
 */
@ProviderType
public interface dgfLocDivisionPersistence
	extends BasePersistence<dgfLocDivision> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link dgfLocDivisionUtil} to access the dgf loc division persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the dgf loc division in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivision the dgf loc division
	 */
	public void cacheResult(dgfLocDivision dgfLocDivision);

	/**
	 * Caches the dgf loc divisions in the entity cache if it is enabled.
	 *
	 * @param dgfLocDivisions the dgf loc divisions
	 */
	public void cacheResult(java.util.List<dgfLocDivision> dgfLocDivisions);

	/**
	 * Creates a new dgf loc division with the primary key. Does not add the dgf loc division to the database.
	 *
	 * @param id the primary key for the new dgf loc division
	 * @return the new dgf loc division
	 */
	public dgfLocDivision create(long id);

	/**
	 * Removes the dgf loc division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division that was removed
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	public dgfLocDivision remove(long id) throws NoSuchdgfLocDivisionException;

	public dgfLocDivision updateImpl(dgfLocDivision dgfLocDivision);

	/**
	 * Returns the dgf loc division with the primary key or throws a <code>NoSuchdgfLocDivisionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division
	 * @throws NoSuchdgfLocDivisionException if a dgf loc division with the primary key could not be found
	 */
	public dgfLocDivision findByPrimaryKey(long id)
		throws NoSuchdgfLocDivisionException;

	/**
	 * Returns the dgf loc division with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division, or <code>null</code> if a dgf loc division with the primary key could not be found
	 */
	public dgfLocDivision fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf loc divisions.
	 *
	 * @return the dgf loc divisions
	 */
	public java.util.List<dgfLocDivision> findAll();

	/**
	 * Returns a range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @return the range of dgf loc divisions
	 */
	public java.util.List<dgfLocDivision> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc divisions
	 */
	public java.util.List<dgfLocDivision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDivision>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc divisions
	 */
	public java.util.List<dgfLocDivision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<dgfLocDivision>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf loc divisions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf loc divisions.
	 *
	 * @return the number of dgf loc divisions
	 */
	public int countAll();

}