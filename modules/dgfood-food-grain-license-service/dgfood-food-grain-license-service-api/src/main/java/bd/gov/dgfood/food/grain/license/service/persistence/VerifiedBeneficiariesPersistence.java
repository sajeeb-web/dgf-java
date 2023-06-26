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

import bd.gov.dgfood.food.grain.license.exception.NoSuchVerifiedBeneficiariesException;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the verified beneficiaries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerifiedBeneficiariesUtil
 * @generated
 */
@ProviderType
public interface VerifiedBeneficiariesPersistence
	extends BasePersistence<VerifiedBeneficiaries> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VerifiedBeneficiariesUtil} to access the verified beneficiaries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the verified beneficiaries where id = &#63; or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries findByVerifiedBeneficiariesById(long id)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(long id);

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(
		long id, boolean useFinderCache);

	/**
	 * Removes the verified beneficiaries where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the verified beneficiaries that was removed
	 */
	public VerifiedBeneficiaries removeByVerifiedBeneficiariesById(long id)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the number of verified beneficiarieses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching verified beneficiarieses
	 */
	public int countByVerifiedBeneficiariesById(long id);

	/**
	 * Returns all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(long dealerId);

	/**
	 * Returns a range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end);

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator);

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries
			findByverifiedBeneficiariesDealerIdFinder_First(
				long dealerId,
				com.liferay.portal.kernel.util.OrderByComparator
					<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_First(
			long dealerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator);

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries findByverifiedBeneficiariesDealerIdFinder_Last(
			long dealerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_Last(
			long dealerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator);

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public VerifiedBeneficiaries[]
			findByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				long id, long dealerId,
				com.liferay.portal.kernel.util.OrderByComparator
					<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Removes all the verified beneficiarieses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	public void removeByverifiedBeneficiariesDealerIdFinder(long dealerId);

	/**
	 * Returns the number of verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching verified beneficiarieses
	 */
	public int countByverifiedBeneficiariesDealerIdFinder(long dealerId);

	/**
	 * Returns all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(String nationalId);

	/**
	 * Returns a range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end);

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator);

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesNidFinder(
			String nationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries findByverifiedBeneficiariesNidFinder_First(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries fetchByverifiedBeneficiariesNidFinder_First(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<VerifiedBeneficiaries>
			orderByComparator);

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries findByverifiedBeneficiariesNidFinder_Last(
			String nationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	public VerifiedBeneficiaries fetchByverifiedBeneficiariesNidFinder_Last(
		String nationalId,
		com.liferay.portal.kernel.util.OrderByComparator<VerifiedBeneficiaries>
			orderByComparator);

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public VerifiedBeneficiaries[]
			findByverifiedBeneficiariesNidFinder_PrevAndNext(
				long id, String nationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Removes all the verified beneficiarieses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public void removeByverifiedBeneficiariesNidFinder(String nationalId);

	/**
	 * Returns the number of verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching verified beneficiarieses
	 */
	public int countByverifiedBeneficiariesNidFinder(String nationalId);

	/**
	 * Caches the verified beneficiaries in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 */
	public void cacheResult(VerifiedBeneficiaries verifiedBeneficiaries);

	/**
	 * Caches the verified beneficiarieses in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiarieses the verified beneficiarieses
	 */
	public void cacheResult(
		java.util.List<VerifiedBeneficiaries> verifiedBeneficiarieses);

	/**
	 * Creates a new verified beneficiaries with the primary key. Does not add the verified beneficiaries to the database.
	 *
	 * @param id the primary key for the new verified beneficiaries
	 * @return the new verified beneficiaries
	 */
	public VerifiedBeneficiaries create(long id);

	/**
	 * Removes the verified beneficiaries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public VerifiedBeneficiaries remove(long id)
		throws NoSuchVerifiedBeneficiariesException;

	public VerifiedBeneficiaries updateImpl(
		VerifiedBeneficiaries verifiedBeneficiaries);

	/**
	 * Returns the verified beneficiaries with the primary key or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	public VerifiedBeneficiaries findByPrimaryKey(long id)
		throws NoSuchVerifiedBeneficiariesException;

	/**
	 * Returns the verified beneficiaries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries, or <code>null</code> if a verified beneficiaries with the primary key could not be found
	 */
	public VerifiedBeneficiaries fetchByPrimaryKey(long id);

	/**
	 * Returns all the verified beneficiarieses.
	 *
	 * @return the verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries> findAll();

	/**
	 * Returns a range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerifiedBeneficiaries>
			orderByComparator);

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verified beneficiarieses
	 */
	public java.util.List<VerifiedBeneficiaries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VerifiedBeneficiaries>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the verified beneficiarieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of verified beneficiarieses.
	 *
	 * @return the number of verified beneficiarieses
	 */
	public int countAll();

}