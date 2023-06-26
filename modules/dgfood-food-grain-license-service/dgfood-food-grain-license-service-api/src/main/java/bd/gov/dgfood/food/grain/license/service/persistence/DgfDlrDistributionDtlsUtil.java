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

import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr distribution dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfDlrDistributionDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtlsPersistence
 * @generated
 */
public class DgfDlrDistributionDtlsUtil {

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
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		getPersistence().clearCache(dgfDlrDistributionDtls);
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
	public static Map<Serializable, DgfDlrDistributionDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrDistributionDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrDistributionDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrDistributionDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrDistributionDtls update(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		return getPersistence().update(dgfDlrDistributionDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrDistributionDtls update(
		DgfDlrDistributionDtls dgfDlrDistributionDtls,
		ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrDistributionDtls, serviceContext);
	}

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(long dealerId) {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId(
			dealerId);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end) {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId(
			dealerId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId(
			dealerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId(
			dealerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerId_First(
				long dealerId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId_First(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerId_First(
			long dealerId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().fetchBydgfDlrDistributionDtlsByDealerId_First(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerId_Last(
				long dealerId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().findBydgfDlrDistributionDtlsByDealerId_Last(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerId_Last(
			long dealerId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().fetchBydgfDlrDistributionDtlsByDealerId_Last(
			dealerId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				long id, long dealerId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				id, dealerId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	public static void removeBydgfDlrDistributionDtlsByDealerId(long dealerId) {
		getPersistence().removeBydgfDlrDistributionDtlsByDealerId(dealerId);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public static int countBydgfDlrDistributionDtlsByDealerId(long dealerId) {
		return getPersistence().countBydgfDlrDistributionDtlsByDealerId(
			dealerId);
	}

	/**
	 * Returns all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(long beneficiariesId) {

		return getPersistence().findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end) {

		return getPersistence().findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_First(
				long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByBeneficiariesId_First(
				beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_First(
			long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByBeneficiariesId_First(
				beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_Last(
			long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				long id, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				id, beneficiariesId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where beneficiariesId = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 */
	public static void removeBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId) {

		getPersistence().removeBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public static int countBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId) {

		return getPersistence().countBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId);
	}

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId) {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end) {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId, start, end, orderByComparator,
				useFinderCache);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				dealerId, beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
			long dealerId, long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				dealerId, beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				dealerId, beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
			long dealerId, long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				dealerId, beneficiariesId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
				long id, long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
				id, dealerId, beneficiariesId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 */
	public static void
		removeBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId) {

		getPersistence().
			removeBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public static int countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
		long dealerId, long beneficiariesId) {

		return getPersistence().
			countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId);
	}

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);
	}

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);
	}

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public static DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year, boolean useFinderCache) {

		return getPersistence().
			fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year, useFinderCache);
	}

	/**
	 * Removes the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the dgf dlr distribution dtls that was removed
	 */
	public static DgfDlrDistributionDtls
			removeBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().
			removeBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public static int
		countBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year) {

		return getPersistence().
			countBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);
	}

	/**
	 * Caches the dgf dlr distribution dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 */
	public static void cacheResult(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		getPersistence().cacheResult(dgfDlrDistributionDtls);
	}

	/**
	 * Caches the dgf dlr distribution dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtlses the dgf dlr distribution dtlses
	 */
	public static void cacheResult(
		List<DgfDlrDistributionDtls> dgfDlrDistributionDtlses) {

		getPersistence().cacheResult(dgfDlrDistributionDtlses);
	}

	/**
	 * Creates a new dgf dlr distribution dtls with the primary key. Does not add the dgf dlr distribution dtls to the database.
	 *
	 * @param id the primary key for the new dgf dlr distribution dtls
	 * @return the new dgf dlr distribution dtls
	 */
	public static DgfDlrDistributionDtls create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf dlr distribution dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().remove(id);
	}

	public static DgfDlrDistributionDtls updateImpl(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		return getPersistence().updateImpl(dgfDlrDistributionDtls);
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls, or <code>null</code> if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public static DgfDlrDistributionDtls fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf dlr distribution dtlses.
	 *
	 * @return the dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr distribution dtlses
	 */
	public static List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr distribution dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses.
	 *
	 * @return the number of dgf dlr distribution dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrDistributionDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrDistributionDtlsPersistence _persistence;

}