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

import bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dlr ffp oms allc ntfy details service. This utility wraps <code>bd.gov.dgfood.food.friendly.program.service.persistence.impl.DlrFfpOmsAllcNtfyDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DlrFfpOmsAllcNtfyDetailsPersistence
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsUtil {

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
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		getPersistence().clearCache(dlrFfpOmsAllcNtfyDetails);
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
	public static Map<Serializable, DlrFfpOmsAllcNtfyDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DlrFfpOmsAllcNtfyDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DlrFfpOmsAllcNtfyDetails update(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return getPersistence().update(dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DlrFfpOmsAllcNtfyDetails update(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dlrFfpOmsAllcNtfyDetails, serviceContext);
	}

	/**
	 * Caches the dlr ffp oms allc ntfy details in the entity cache if it is enabled.
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 */
	public static void cacheResult(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		getPersistence().cacheResult(dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Caches the dlr ffp oms allc ntfy detailses in the entity cache if it is enabled.
	 *
	 * @param dlrFfpOmsAllcNtfyDetailses the dlr ffp oms allc ntfy detailses
	 */
	public static void cacheResult(
		List<DlrFfpOmsAllcNtfyDetails> dlrFfpOmsAllcNtfyDetailses) {

		getPersistence().cacheResult(dlrFfpOmsAllcNtfyDetailses);
	}

	/**
	 * Creates a new dlr ffp oms allc ntfy details with the primary key. Does not add the dlr ffp oms allc ntfy details to the database.
	 *
	 * @param allocNtfyId the primary key for the new dlr ffp oms allc ntfy details
	 * @return the new dlr ffp oms allc ntfy details
	 */
	public static DlrFfpOmsAllcNtfyDetails create(String allocNtfyId) {
		return getPersistence().create(allocNtfyId);
	}

	/**
	 * Removes the dlr ffp oms allc ntfy details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	public static DlrFfpOmsAllcNtfyDetails remove(String allocNtfyId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrFfpOmsAllcNtfyDetailsException {

		return getPersistence().remove(allocNtfyId);
	}

	public static DlrFfpOmsAllcNtfyDetails updateImpl(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return getPersistence().updateImpl(dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key or throws a <code>NoSuchDlrFfpOmsAllcNtfyDetailsException</code> if it could not be found.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details
	 * @throws NoSuchDlrFfpOmsAllcNtfyDetailsException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	public static DlrFfpOmsAllcNtfyDetails findByPrimaryKey(String allocNtfyId)
		throws bd.gov.dgfood.food.friendly.program.exception.
			NoSuchDlrFfpOmsAllcNtfyDetailsException {

		return getPersistence().findByPrimaryKey(allocNtfyId);
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details, or <code>null</code> if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	public static DlrFfpOmsAllcNtfyDetails fetchByPrimaryKey(
		String allocNtfyId) {

		return getPersistence().fetchByPrimaryKey(allocNtfyId);
	}

	/**
	 * Returns all the dlr ffp oms allc ntfy detailses.
	 *
	 * @return the dlr ffp oms allc ntfy detailses
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @return the range of dlr ffp oms allc ntfy detailses
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dlr ffp oms allc ntfy detailses
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findAll(
		int start, int end,
		OrderByComparator<DlrFfpOmsAllcNtfyDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dlr ffp oms allc ntfy detailses
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> findAll(
		int start, int end,
		OrderByComparator<DlrFfpOmsAllcNtfyDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dlr ffp oms allc ntfy detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dlr ffp oms allc ntfy detailses.
	 *
	 * @return the number of dlr ffp oms allc ntfy detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DlrFfpOmsAllcNtfyDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DlrFfpOmsAllcNtfyDetailsPersistence _persistence;

}