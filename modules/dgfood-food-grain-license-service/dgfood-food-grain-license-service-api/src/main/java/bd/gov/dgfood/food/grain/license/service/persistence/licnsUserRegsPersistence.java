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

import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the licns user regs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegsUtil
 * @generated
 */
@ProviderType
public interface licnsUserRegsPersistence
	extends BasePersistence<licnsUserRegs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link licnsUserRegsUtil} to access the licns user regs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the licns user regs where nationalId = &#63; or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs
	 * @throws NoSuchlicnsUserRegsException if a matching licns user regs could not be found
	 */
	public licnsUserRegs findBylicnsUserRegsNid(String nationalId)
		throws NoSuchlicnsUserRegsException;

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	public licnsUserRegs fetchBylicnsUserRegsNid(String nationalId);

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	public licnsUserRegs fetchBylicnsUserRegsNid(
		String nationalId, boolean useFinderCache);

	/**
	 * Removes the licns user regs where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the licns user regs that was removed
	 */
	public licnsUserRegs removeBylicnsUserRegsNid(String nationalId)
		throws NoSuchlicnsUserRegsException;

	/**
	 * Returns the number of licns user regses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching licns user regses
	 */
	public int countBylicnsUserRegsNid(String nationalId);

	/**
	 * Caches the licns user regs in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegs the licns user regs
	 */
	public void cacheResult(licnsUserRegs licnsUserRegs);

	/**
	 * Caches the licns user regses in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegses the licns user regses
	 */
	public void cacheResult(java.util.List<licnsUserRegs> licnsUserRegses);

	/**
	 * Creates a new licns user regs with the primary key. Does not add the licns user regs to the database.
	 *
	 * @param licUserId the primary key for the new licns user regs
	 * @return the new licns user regs
	 */
	public licnsUserRegs create(long licUserId);

	/**
	 * Removes the licns user regs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs that was removed
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	public licnsUserRegs remove(long licUserId)
		throws NoSuchlicnsUserRegsException;

	public licnsUserRegs updateImpl(licnsUserRegs licnsUserRegs);

	/**
	 * Returns the licns user regs with the primary key or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	public licnsUserRegs findByPrimaryKey(long licUserId)
		throws NoSuchlicnsUserRegsException;

	/**
	 * Returns the licns user regs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs, or <code>null</code> if a licns user regs with the primary key could not be found
	 */
	public licnsUserRegs fetchByPrimaryKey(long licUserId);

	/**
	 * Returns all the licns user regses.
	 *
	 * @return the licns user regses
	 */
	public java.util.List<licnsUserRegs> findAll();

	/**
	 * Returns a range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @return the range of licns user regses
	 */
	public java.util.List<licnsUserRegs> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licns user regses
	 */
	public java.util.List<licnsUserRegs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<licnsUserRegs>
			orderByComparator);

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licns user regses
	 */
	public java.util.List<licnsUserRegs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<licnsUserRegs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the licns user regses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of licns user regses.
	 *
	 * @return the number of licns user regses
	 */
	public int countAll();

}