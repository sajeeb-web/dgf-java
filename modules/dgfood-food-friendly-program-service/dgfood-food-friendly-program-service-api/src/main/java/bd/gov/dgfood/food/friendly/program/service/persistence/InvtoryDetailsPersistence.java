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

package bd.gov.dgfood.food.friendly.program.service.persistence;

import bd.gov.dgfood.food.friendly.program.exception.NoSuchInvtoryDetailsException;
import bd.gov.dgfood.food.friendly.program.model.InvtoryDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the invtory details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvtoryDetailsUtil
 * @generated
 */
@ProviderType
public interface InvtoryDetailsPersistence
	extends BasePersistence<InvtoryDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvtoryDetailsUtil} to access the invtory details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the invtory details where inventoryId = &#63; or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public InvtoryDetails findByinventoryidFinder(long inventoryId)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchByinventoryidFinder(long inventoryId);

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchByinventoryidFinder(
		long inventoryId, boolean useFinderCache);

	/**
	 * Removes the invtory details where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 * @return the invtory details that was removed
	 */
	public InvtoryDetails removeByinventoryidFinder(long inventoryId)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the number of invtory detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching invtory detailses
	 */
	public int countByinventoryidFinder(long inventoryId);

	/**
	 * Returns all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findBydlrregnoFinder(long dlrRegNo);

	/**
	 * Returns a range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end);

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public InvtoryDetails findBydlrregnoFinder_First(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchBydlrregnoFinder_First(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public InvtoryDetails findBydlrregnoFinder_Last(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public InvtoryDetails[] findBydlrregnoFinder_PrevAndNext(
			long inventoryId, long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Removes all the invtory detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public void removeBydlrregnoFinder(long dlrRegNo);

	/**
	 * Returns the number of invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching invtory detailses
	 */
	public int countBydlrregnoFinder(long dlrRegNo);

	/**
	 * Returns all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo);

	/**
	 * Returns a range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end);

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	public java.util.List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public InvtoryDetails findByallcntfynoFinder_First(
			long allcNtfyNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchByallcntfynoFinder_First(
		long allcNtfyNo,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	public InvtoryDetails findByallcntfynoFinder_Last(
			long allcNtfyNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	public InvtoryDetails fetchByallcntfynoFinder_Last(
		long allcNtfyNo,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public InvtoryDetails[] findByallcntfynoFinder_PrevAndNext(
			long inventoryId, long allcNtfyNo,
			com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
				orderByComparator)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Removes all the invtory detailses where allcNtfyNo = &#63; from the database.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 */
	public void removeByallcntfynoFinder(long allcNtfyNo);

	/**
	 * Returns the number of invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the number of matching invtory detailses
	 */
	public int countByallcntfynoFinder(long allcNtfyNo);

	/**
	 * Caches the invtory details in the entity cache if it is enabled.
	 *
	 * @param invtoryDetails the invtory details
	 */
	public void cacheResult(InvtoryDetails invtoryDetails);

	/**
	 * Caches the invtory detailses in the entity cache if it is enabled.
	 *
	 * @param invtoryDetailses the invtory detailses
	 */
	public void cacheResult(java.util.List<InvtoryDetails> invtoryDetailses);

	/**
	 * Creates a new invtory details with the primary key. Does not add the invtory details to the database.
	 *
	 * @param inventoryId the primary key for the new invtory details
	 * @return the new invtory details
	 */
	public InvtoryDetails create(long inventoryId);

	/**
	 * Removes the invtory details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details that was removed
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public InvtoryDetails remove(long inventoryId)
		throws NoSuchInvtoryDetailsException;

	public InvtoryDetails updateImpl(InvtoryDetails invtoryDetails);

	/**
	 * Returns the invtory details with the primary key or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	public InvtoryDetails findByPrimaryKey(long inventoryId)
		throws NoSuchInvtoryDetailsException;

	/**
	 * Returns the invtory details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details, or <code>null</code> if a invtory details with the primary key could not be found
	 */
	public InvtoryDetails fetchByPrimaryKey(long inventoryId);

	/**
	 * Returns all the invtory detailses.
	 *
	 * @return the invtory detailses
	 */
	public java.util.List<InvtoryDetails> findAll();

	/**
	 * Returns a range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of invtory detailses
	 */
	public java.util.List<InvtoryDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invtory detailses
	 */
	public java.util.List<InvtoryDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of invtory detailses
	 */
	public java.util.List<InvtoryDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvtoryDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the invtory detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of invtory detailses.
	 *
	 * @return the number of invtory detailses
	 */
	public int countAll();

}