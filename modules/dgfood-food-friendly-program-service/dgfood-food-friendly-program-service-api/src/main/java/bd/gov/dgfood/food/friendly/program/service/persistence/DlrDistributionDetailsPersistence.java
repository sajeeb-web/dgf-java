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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchDlrDistributionDetailsException;
import bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dlr distribution details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetailsUtil
 * @generated
 */
@ProviderType
public interface DlrDistributionDetailsPersistence
	extends BasePersistence<DlrDistributionDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DlrDistributionDetailsUtil} to access the dlr distribution details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findBydstrbnIdFinder(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchBydstrbnIdFinder(long dstrbnId);

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchBydstrbnIdFinder(
		long dstrbnId, boolean useFinderCache);

	/**
	 * Removes the dlr distribution details where dstrbnId = &#63; from the database.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the dlr distribution details that was removed
	 */
	public DlrDistributionDetails removeBydstrbnIdFinder(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the number of dlr distribution detailses where dstrbnId = &#63;.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the number of matching dlr distribution detailses
	 */
	public int countBydstrbnIdFinder(long dstrbnId);

	/**
	 * Returns all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo);

	/**
	 * Returns a range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findBydlrregnoFinder_First(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchBydlrregnoFinder_First(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findBydlrregnoFinder_Last(
			long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails[] findBydlrregnoFinder_PrevAndNext(
			long dstrbnId, long dlrRegNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Removes all the dlr distribution detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public void removeBydlrregnoFinder(long dlrRegNo);

	/**
	 * Returns the number of dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dlr distribution detailses
	 */
	public int countBydlrregnoFinder(long dlrRegNo);

	/**
	 * Returns all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId);

	/**
	 * Returns a range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findByffpregstridFinder_First(
			long ffpRegstrId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchByffpregstridFinder_First(
		long ffpRegstrId,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findByffpregstridFinder_Last(
			long ffpRegstrId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchByffpregstridFinder_Last(
		long ffpRegstrId,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails[] findByffpregstridFinder_PrevAndNext(
			long dstrbnId, long ffpRegstrId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Removes all the dlr distribution detailses where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 */
	public void removeByffpregstridFinder(long ffpRegstrId);

	/**
	 * Returns the number of dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching dlr distribution detailses
	 */
	public int countByffpregstridFinder(long ffpRegstrId);

	/**
	 * Returns all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId);

	/**
	 * Returns a range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findByinventoryidFinder_First(
			long inventoryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchByinventoryidFinder_First(
		long inventoryId,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails findByinventoryidFinder_Last(
			long inventoryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public DlrDistributionDetails fetchByinventoryidFinder_Last(
		long inventoryId,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails[] findByinventoryidFinder_PrevAndNext(
			long dstrbnId, long inventoryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Removes all the dlr distribution detailses where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 */
	public void removeByinventoryidFinder(long inventoryId);

	/**
	 * Returns the number of dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching dlr distribution detailses
	 */
	public int countByinventoryidFinder(long inventoryId);

	/**
	 * Caches the dlr distribution details in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 */
	public void cacheResult(DlrDistributionDetails dlrDistributionDetails);

	/**
	 * Caches the dlr distribution detailses in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetailses the dlr distribution detailses
	 */
	public void cacheResult(
		java.util.List<DlrDistributionDetails> dlrDistributionDetailses);

	/**
	 * Creates a new dlr distribution details with the primary key. Does not add the dlr distribution details to the database.
	 *
	 * @param dstrbnId the primary key for the new dlr distribution details
	 * @return the new dlr distribution details
	 */
	public DlrDistributionDetails create(long dstrbnId);

	/**
	 * Removes the dlr distribution details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details that was removed
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails remove(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException;

	public DlrDistributionDetails updateImpl(
		DlrDistributionDetails dlrDistributionDetails);

	/**
	 * Returns the dlr distribution details with the primary key or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails findByPrimaryKey(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException;

	/**
	 * Returns the dlr distribution details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details, or <code>null</code> if a dlr distribution details with the primary key could not be found
	 */
	public DlrDistributionDetails fetchByPrimaryKey(long dstrbnId);

	/**
	 * Returns all the dlr distribution detailses.
	 *
	 * @return the dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findAll();

	/**
	 * Returns a range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dlr distribution detailses
	 */
	public java.util.List<DlrDistributionDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DlrDistributionDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dlr distribution detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dlr distribution detailses.
	 *
	 * @return the number of dlr distribution detailses
	 */
	public int countAll();

}