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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFfpbDetailsException;
import bd.gov.dgfood.food.friendly.program.model.FfpbDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ffpb details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetailsUtil
 * @generated
 */
@ProviderType
public interface FfpbDetailsPersistence extends BasePersistence<FfpbDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FfpbDetailsUtil} to access the ffpb details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the ffpb details where nationalId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public FfpbDetails findByffpbNidFinder(long nationalId)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpbNidFinder(long nationalId);

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpbNidFinder(
		long nationalId, boolean useFinderCache);

	/**
	 * Removes the ffpb details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffpb details that was removed
	 */
	public FfpbDetails removeByffpbNidFinder(long nationalId)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the number of ffpb detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffpb detailses
	 */
	public int countByffpbNidFinder(long nationalId);

	/**
	 * Returns all the ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching ffpb detailses
	 */
	public java.util.List<FfpbDetails> findByffpbMobileFinder(String mobileNo);

	/**
	 * Returns a range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of matching ffpb detailses
	 */
	public java.util.List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end);

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffpb detailses
	 */
	public java.util.List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffpb detailses
	 */
	public java.util.List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public FfpbDetails findByffpbMobileFinder_First(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
				orderByComparator)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpbMobileFinder_First(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator);

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public FfpbDetails findByffpbMobileFinder_Last(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
				orderByComparator)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpbMobileFinder_Last(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator);

	/**
	 * Returns the ffpb detailses before and after the current ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param ffpRegstrId the primary key of the current ffpb details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public FfpbDetails[] findByffpbMobileFinder_PrevAndNext(
			long ffpRegstrId, String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
				orderByComparator)
		throws NoSuchFfpbDetailsException;

	/**
	 * Removes all the ffpb detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public void removeByffpbMobileFinder(String mobileNo);

	/**
	 * Returns the number of ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching ffpb detailses
	 */
	public int countByffpbMobileFinder(String mobileNo);

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	public FfpbDetails findByffpregstridFinder(long ffpRegstrId)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpregstridFinder(long ffpRegstrId);

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	public FfpbDetails fetchByffpregstridFinder(
		long ffpRegstrId, boolean useFinderCache);

	/**
	 * Removes the ffpb details where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the ffpb details that was removed
	 */
	public FfpbDetails removeByffpregstridFinder(long ffpRegstrId)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the number of ffpb detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching ffpb detailses
	 */
	public int countByffpregstridFinder(long ffpRegstrId);

	/**
	 * Caches the ffpb details in the entity cache if it is enabled.
	 *
	 * @param ffpbDetails the ffpb details
	 */
	public void cacheResult(FfpbDetails ffpbDetails);

	/**
	 * Caches the ffpb detailses in the entity cache if it is enabled.
	 *
	 * @param ffpbDetailses the ffpb detailses
	 */
	public void cacheResult(java.util.List<FfpbDetails> ffpbDetailses);

	/**
	 * Creates a new ffpb details with the primary key. Does not add the ffpb details to the database.
	 *
	 * @param ffpRegstrId the primary key for the new ffpb details
	 * @return the new ffpb details
	 */
	public FfpbDetails create(long ffpRegstrId);

	/**
	 * Removes the ffpb details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details that was removed
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public FfpbDetails remove(long ffpRegstrId)
		throws NoSuchFfpbDetailsException;

	public FfpbDetails updateImpl(FfpbDetails ffpbDetails);

	/**
	 * Returns the ffpb details with the primary key or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	public FfpbDetails findByPrimaryKey(long ffpRegstrId)
		throws NoSuchFfpbDetailsException;

	/**
	 * Returns the ffpb details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details, or <code>null</code> if a ffpb details with the primary key could not be found
	 */
	public FfpbDetails fetchByPrimaryKey(long ffpRegstrId);

	/**
	 * Returns all the ffpb detailses.
	 *
	 * @return the ffpb detailses
	 */
	public java.util.List<FfpbDetails> findAll();

	/**
	 * Returns a range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of ffpb detailses
	 */
	public java.util.List<FfpbDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffpb detailses
	 */
	public java.util.List<FfpbDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffpb detailses
	 */
	public java.util.List<FfpbDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FfpbDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ffpb detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ffpb detailses.
	 *
	 * @return the number of ffpb detailses
	 */
	public int countAll();

}