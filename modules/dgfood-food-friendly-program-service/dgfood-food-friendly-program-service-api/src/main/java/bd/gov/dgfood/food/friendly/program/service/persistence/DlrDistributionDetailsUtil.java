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

import bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dlr distribution details service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.DlrDistributionDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetailsPersistence
 * @generated
 */
public class DlrDistributionDetailsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		DlrDistributionDetails dlrDistributionDetails) {

		getPersistence().clearCache(dlrDistributionDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DlrDistributionDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DlrDistributionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DlrDistributionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DlrDistributionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DlrDistributionDetails update(
		DlrDistributionDetails dlrDistributionDetails) {

		return getPersistence().update(dlrDistributionDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DlrDistributionDetails update(
		DlrDistributionDetails dlrDistributionDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(dlrDistributionDetails, serviceContext);
	}

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findBydstrbnIdFinder(long dstrbnId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findBydstrbnIdFinder(dstrbnId);
	}

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchBydstrbnIdFinder(long dstrbnId) {
		return getPersistence().fetchBydstrbnIdFinder(dstrbnId);
	}

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchBydstrbnIdFinder(
		long dstrbnId, boolean useFinderCache) {

		return getPersistence().fetchBydstrbnIdFinder(dstrbnId, useFinderCache);
	}

	/**
	 * Removes the dlr distribution details where dstrbnId = &#63; from the database.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the dlr distribution details that was removed
	 */
	public static DlrDistributionDetails removeBydstrbnIdFinder(long dstrbnId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().removeBydstrbnIdFinder(dstrbnId);
	}

	/**
	 * Returns the number of dlr distribution detailses where dstrbnId = &#63;.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the number of matching dlr distribution detailses
	 */
	public static int countBydstrbnIdFinder(long dstrbnId) {
		return getPersistence().countBydstrbnIdFinder(dstrbnId);
	}

	/**
	 * Returns all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dlr distribution detailses
	 */
	public static List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo) {

		return getPersistence().findBydlrregnoFinder(dlrRegNo);
	}

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
	public static List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end) {

		return getPersistence().findBydlrregnoFinder(dlrRegNo, start, end);
	}

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
	public static List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator);
	}

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
	public static List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findBydlrregnoFinder_First(
			long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findBydlrregnoFinder_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchBydlrregnoFinder_First(
		long dlrRegNo,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchBydlrregnoFinder_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findBydlrregnoFinder_Last(
			long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findBydlrregnoFinder_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchBydlrregnoFinder_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails[] findBydlrregnoFinder_PrevAndNext(
			long dstrbnId, long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findBydlrregnoFinder_PrevAndNext(
			dstrbnId, dlrRegNo, orderByComparator);
	}

	/**
	 * Removes all the dlr distribution detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public static void removeBydlrregnoFinder(long dlrRegNo) {
		getPersistence().removeBydlrregnoFinder(dlrRegNo);
	}

	/**
	 * Returns the number of dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dlr distribution detailses
	 */
	public static int countBydlrregnoFinder(long dlrRegNo) {
		return getPersistence().countBydlrregnoFinder(dlrRegNo);
	}

	/**
	 * Returns all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching dlr distribution detailses
	 */
	public static List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId) {

		return getPersistence().findByffpregstridFinder(ffpRegstrId);
	}

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
	public static List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end) {

		return getPersistence().findByffpregstridFinder(
			ffpRegstrId, start, end);
	}

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
	public static List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().findByffpregstridFinder(
			ffpRegstrId, start, end, orderByComparator);
	}

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
	public static List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByffpregstridFinder(
			ffpRegstrId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findByffpregstridFinder_First(
			long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByffpregstridFinder_First(
			ffpRegstrId, orderByComparator);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchByffpregstridFinder_First(
		long ffpRegstrId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchByffpregstridFinder_First(
			ffpRegstrId, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findByffpregstridFinder_Last(
			long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByffpregstridFinder_Last(
			ffpRegstrId, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchByffpregstridFinder_Last(
		long ffpRegstrId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchByffpregstridFinder_Last(
			ffpRegstrId, orderByComparator);
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails[] findByffpregstridFinder_PrevAndNext(
			long dstrbnId, long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByffpregstridFinder_PrevAndNext(
			dstrbnId, ffpRegstrId, orderByComparator);
	}

	/**
	 * Removes all the dlr distribution detailses where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 */
	public static void removeByffpregstridFinder(long ffpRegstrId) {
		getPersistence().removeByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Returns the number of dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching dlr distribution detailses
	 */
	public static int countByffpregstridFinder(long ffpRegstrId) {
		return getPersistence().countByffpregstridFinder(ffpRegstrId);
	}

	/**
	 * Returns all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching dlr distribution detailses
	 */
	public static List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId) {

		return getPersistence().findByinventoryidFinder(inventoryId);
	}

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
	public static List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end) {

		return getPersistence().findByinventoryidFinder(
			inventoryId, start, end);
	}

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
	public static List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().findByinventoryidFinder(
			inventoryId, start, end, orderByComparator);
	}

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
	public static List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinventoryidFinder(
			inventoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findByinventoryidFinder_First(
			long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByinventoryidFinder_First(
			inventoryId, orderByComparator);
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchByinventoryidFinder_First(
		long inventoryId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchByinventoryidFinder_First(
			inventoryId, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails findByinventoryidFinder_Last(
			long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByinventoryidFinder_Last(
			inventoryId, orderByComparator);
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	public static DlrDistributionDetails fetchByinventoryidFinder_Last(
		long inventoryId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().fetchByinventoryidFinder_Last(
			inventoryId, orderByComparator);
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails[] findByinventoryidFinder_PrevAndNext(
			long dstrbnId, long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByinventoryidFinder_PrevAndNext(
			dstrbnId, inventoryId, orderByComparator);
	}

	/**
	 * Removes all the dlr distribution detailses where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 */
	public static void removeByinventoryidFinder(long inventoryId) {
		getPersistence().removeByinventoryidFinder(inventoryId);
	}

	/**
	 * Returns the number of dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching dlr distribution detailses
	 */
	public static int countByinventoryidFinder(long inventoryId) {
		return getPersistence().countByinventoryidFinder(inventoryId);
	}

	/**
	 * Caches the dlr distribution details in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 */
	public static void cacheResult(
		DlrDistributionDetails dlrDistributionDetails) {

		getPersistence().cacheResult(dlrDistributionDetails);
	}

	/**
	 * Caches the dlr distribution detailses in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetailses the dlr distribution detailses
	 */
	public static void cacheResult(
		List<DlrDistributionDetails> dlrDistributionDetailses) {

		getPersistence().cacheResult(dlrDistributionDetailses);
	}

	/**
	 * Creates a new dlr distribution details with the primary key. Does not add the dlr distribution details to the database.
	 *
	 * @param dstrbnId the primary key for the new dlr distribution details
	 * @return the new dlr distribution details
	 */
	public static DlrDistributionDetails create(long dstrbnId) {
		return getPersistence().create(dstrbnId);
	}

	/**
	 * Removes the dlr distribution details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details that was removed
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails remove(long dstrbnId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().remove(dstrbnId);
	}

	public static DlrDistributionDetails updateImpl(
		DlrDistributionDetails dlrDistributionDetails) {

		return getPersistence().updateImpl(dlrDistributionDetails);
	}

	/**
	 * Returns the dlr distribution details with the primary key or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails findByPrimaryKey(long dstrbnId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrDistributionDetailsException {

		return getPersistence().findByPrimaryKey(dstrbnId);
	}

	/**
	 * Returns the dlr distribution details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details, or <code>null</code> if a dlr distribution details with the primary key could not be found
	 */
	public static DlrDistributionDetails fetchByPrimaryKey(long dstrbnId) {
		return getPersistence().fetchByPrimaryKey(dstrbnId);
	}

	/**
	 * Returns all the dlr distribution detailses.
	 *
	 * @return the dlr distribution detailses
	 */
	public static List<DlrDistributionDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DlrDistributionDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DlrDistributionDetails> findAll(
		int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DlrDistributionDetails> findAll(
		int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dlr distribution detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dlr distribution detailses.
	 *
	 * @return the number of dlr distribution detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DlrDistributionDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DlrDistributionDetailsPersistence _persistence;

}