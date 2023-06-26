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

package bd.gov.dgfood.dealer.registration.service.persistence;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr withdrawal service. This utility wraps <code>bd.gov.dgfood.dealer.registration.service.persistence.impl.DgfDlrWithdrawalPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawalPersistence
 * @generated
 */
public class DgfDlrWithdrawalUtil {

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
	public static void clearCache(DgfDlrWithdrawal dgfDlrWithdrawal) {
		getPersistence().clearCache(dgfDlrWithdrawal);
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
	public static Map<Serializable, DgfDlrWithdrawal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrWithdrawal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrWithdrawal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrWithdrawal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrWithdrawal update(DgfDlrWithdrawal dgfDlrWithdrawal) {
		return getPersistence().update(dgfDlrWithdrawal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrWithdrawal update(
		DgfDlrWithdrawal dgfDlrWithdrawal, ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrWithdrawal, serviceContext);
	}

	/**
	 * Returns all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId) {

		return getPersistence().findByDlrWithdrawalByNationalId(nationalId);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end) {

		return getPersistence().findByDlrWithdrawalByNationalId(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().findByDlrWithdrawalByNationalId(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDlrWithdrawalByNationalId(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal findByDlrWithdrawalByNationalId_First(
			String nationalId,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_First(
		String nationalId,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().fetchByDlrWithdrawalByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal findByDlrWithdrawalByNationalId_Last(
			String nationalId,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_Last(
		String nationalId,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().fetchByDlrWithdrawalByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public static DgfDlrWithdrawal[]
			findByDlrWithdrawalByNationalId_PrevAndNext(
				long dlrWithdrawalId, String nationalId,
				OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByNationalId_PrevAndNext(
			dlrWithdrawalId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr withdrawals where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByDlrWithdrawalByNationalId(String nationalId) {
		getPersistence().removeByDlrWithdrawalByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr withdrawals
	 */
	public static int countByDlrWithdrawalByNationalId(String nationalId) {
		return getPersistence().countByDlrWithdrawalByNationalId(nationalId);
	}

	/**
	 * Returns all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo) {

		return getPersistence().findByDlrWithdrawalByLicenseNo(licenseNo);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end) {

		return getPersistence().findByDlrWithdrawalByLicenseNo(
			licenseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().findByDlrWithdrawalByLicenseNo(
			licenseNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDlrWithdrawalByLicenseNo(
			licenseNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_First(
			String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByLicenseNo_First(
			licenseNo, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_First(
		String licenseNo,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().fetchByDlrWithdrawalByLicenseNo_First(
			licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_Last(
			String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByLicenseNo_Last(
			licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_Last(
		String licenseNo,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().fetchByDlrWithdrawalByLicenseNo_Last(
			licenseNo, orderByComparator);
	}

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public static DgfDlrWithdrawal[] findByDlrWithdrawalByLicenseNo_PrevAndNext(
			long dlrWithdrawalId, String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByLicenseNo_PrevAndNext(
			dlrWithdrawalId, licenseNo, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr withdrawals where licenseNo = &#63; from the database.
	 *
	 * @param licenseNo the license no
	 */
	public static void removeByDlrWithdrawalByLicenseNo(String licenseNo) {
		getPersistence().removeByDlrWithdrawalByLicenseNo(licenseNo);
	}

	/**
	 * Returns the number of dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the number of matching dgf dlr withdrawals
	 */
	public static int countByDlrWithdrawalByLicenseNo(String licenseNo) {
		return getPersistence().countByDlrWithdrawalByLicenseNo(licenseNo);
	}

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal findByDlrWithdrawalByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo);
	}

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo) {

		return getPersistence().fetchByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo);
	}

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	public static DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo,
		boolean useFinderCache) {

		return getPersistence().fetchByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo, useFinderCache);
	}

	/**
	 * Removes the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr withdrawal that was removed
	 */
	public static DgfDlrWithdrawal
			removeByDlrWithdrawalByNationalIdAndLicenseNo(
				String nationalId, String licenseNo, long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().removeByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo);
	}

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr withdrawals
	 */
	public static int countByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo) {

		return getPersistence().countByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo);
	}

	/**
	 * Caches the dgf dlr withdrawal in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 */
	public static void cacheResult(DgfDlrWithdrawal dgfDlrWithdrawal) {
		getPersistence().cacheResult(dgfDlrWithdrawal);
	}

	/**
	 * Caches the dgf dlr withdrawals in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawals the dgf dlr withdrawals
	 */
	public static void cacheResult(List<DgfDlrWithdrawal> dgfDlrWithdrawals) {
		getPersistence().cacheResult(dgfDlrWithdrawals);
	}

	/**
	 * Creates a new dgf dlr withdrawal with the primary key. Does not add the dgf dlr withdrawal to the database.
	 *
	 * @param dlrWithdrawalId the primary key for the new dgf dlr withdrawal
	 * @return the new dgf dlr withdrawal
	 */
	public static DgfDlrWithdrawal create(long dlrWithdrawalId) {
		return getPersistence().create(dlrWithdrawalId);
	}

	/**
	 * Removes the dgf dlr withdrawal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public static DgfDlrWithdrawal remove(long dlrWithdrawalId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().remove(dlrWithdrawalId);
	}

	public static DgfDlrWithdrawal updateImpl(
		DgfDlrWithdrawal dgfDlrWithdrawal) {

		return getPersistence().updateImpl(dgfDlrWithdrawal);
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	public static DgfDlrWithdrawal findByPrimaryKey(long dlrWithdrawalId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrWithdrawalException {

		return getPersistence().findByPrimaryKey(dlrWithdrawalId);
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal, or <code>null</code> if a dgf dlr withdrawal with the primary key could not be found
	 */
	public static DgfDlrWithdrawal fetchByPrimaryKey(long dlrWithdrawalId) {
		return getPersistence().fetchByPrimaryKey(dlrWithdrawalId);
	}

	/**
	 * Returns all the dgf dlr withdrawals.
	 *
	 * @return the dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findAll(
		int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr withdrawals
	 */
	public static List<DgfDlrWithdrawal> findAll(
		int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr withdrawals from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr withdrawals.
	 *
	 * @return the number of dgf dlr withdrawals
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrWithdrawalPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrWithdrawalPersistence _persistence;

}