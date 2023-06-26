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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDealerMastersException;
import bd.gov.dgfood.food.grain.license.model.DealerMasters;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dealer masters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DealerMastersUtil
 * @generated
 */
@ProviderType
public interface DealerMastersPersistence
	extends BasePersistence<DealerMasters> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DealerMastersUtil} to access the dealer masters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dealer masters where id = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findByDealerMastersById(long id)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersById(long id);

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersById(
		long id, boolean useFinderCache);

	/**
	 * Removes the dealer masters where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the dealer masters that was removed
	 */
	public DealerMasters removeByDealerMastersById(long id)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the number of dealer masterses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching dealer masterses
	 */
	public int countByDealerMastersById(long id);

	/**
	 * Returns all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the matching dealer masterses
	 */
	public java.util.List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId);

	/**
	 * Returns a range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of matching dealer masterses
	 */
	public java.util.List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dealer masterses
	 */
	public java.util.List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dealer masterses
	 */
	public java.util.List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findBydealerMastersNidFinder_First(
			String dealerNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
				orderByComparator)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchBydealerMastersNidFinder_First(
		String dealerNationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator);

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findBydealerMastersNidFinder_Last(
			String dealerNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
				orderByComparator)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchBydealerMastersNidFinder_Last(
		String dealerNationalId,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator);

	/**
	 * Returns the dealer masterses before and after the current dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param id the primary key of the current dealer masters
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public DealerMasters[] findBydealerMastersNidFinder_PrevAndNext(
			long id, String dealerNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
				orderByComparator)
		throws NoSuchDealerMastersException;

	/**
	 * Removes all the dealer masterses where dealerNationalId = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 */
	public void removeBydealerMastersNidFinder(String dealerNationalId);

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the number of matching dealer masterses
	 */
	public int countBydealerMastersNidFinder(String dealerNationalId);

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo);

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo, boolean useFinderCache);

	/**
	 * Removes the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public DealerMasters removeBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public int countBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo);

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo);

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo, boolean useFinderCache);

	/**
	 * Removes the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public DealerMasters removeByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the number of dealer masterses where secondNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public int countByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo);

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	public DealerMasters findByDealerMastersByMobileNo(String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersByMobileNo(String dealerMobileNo);

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	public DealerMasters fetchByDealerMastersByMobileNo(
		String dealerMobileNo, boolean useFinderCache);

	/**
	 * Removes the dealer masters where dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	public DealerMasters removeByDealerMastersByMobileNo(String dealerMobileNo)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the number of dealer masterses where dealerMobileNo = &#63;.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	public int countByDealerMastersByMobileNo(String dealerMobileNo);

	/**
	 * Caches the dealer masters in the entity cache if it is enabled.
	 *
	 * @param dealerMasters the dealer masters
	 */
	public void cacheResult(DealerMasters dealerMasters);

	/**
	 * Caches the dealer masterses in the entity cache if it is enabled.
	 *
	 * @param dealerMasterses the dealer masterses
	 */
	public void cacheResult(java.util.List<DealerMasters> dealerMasterses);

	/**
	 * Creates a new dealer masters with the primary key. Does not add the dealer masters to the database.
	 *
	 * @param id the primary key for the new dealer masters
	 * @return the new dealer masters
	 */
	public DealerMasters create(long id);

	/**
	 * Removes the dealer masters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters that was removed
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public DealerMasters remove(long id) throws NoSuchDealerMastersException;

	public DealerMasters updateImpl(DealerMasters dealerMasters);

	/**
	 * Returns the dealer masters with the primary key or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	public DealerMasters findByPrimaryKey(long id)
		throws NoSuchDealerMastersException;

	/**
	 * Returns the dealer masters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters, or <code>null</code> if a dealer masters with the primary key could not be found
	 */
	public DealerMasters fetchByPrimaryKey(long id);

	/**
	 * Returns all the dealer masterses.
	 *
	 * @return the dealer masterses
	 */
	public java.util.List<DealerMasters> findAll();

	/**
	 * Returns a range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of dealer masterses
	 */
	public java.util.List<DealerMasters> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dealer masterses
	 */
	public java.util.List<DealerMasters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dealer masterses
	 */
	public java.util.List<DealerMasters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DealerMasters>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dealer masterses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dealer masterses.
	 *
	 * @return the number of dealer masterses
	 */
	public int countAll();

}