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

import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the beneficiary other info service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.BeneficiaryOtherInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfoPersistence
 * @generated
 */
public class BeneficiaryOtherInfoUtil {

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
	public static void clearCache(BeneficiaryOtherInfo beneficiaryOtherInfo) {
		getPersistence().clearCache(beneficiaryOtherInfo);
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
	public static Map<Serializable, BeneficiaryOtherInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BeneficiaryOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BeneficiaryOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BeneficiaryOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BeneficiaryOtherInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BeneficiaryOtherInfo update(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		return getPersistence().update(beneficiaryOtherInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BeneficiaryOtherInfo update(
		BeneficiaryOtherInfo beneficiaryOtherInfo,
		ServiceContext serviceContext) {

		return getPersistence().update(beneficiaryOtherInfo, serviceContext);
	}

	/**
	 * Returns the beneficiary other info where id = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo findBybeneficiaryOtherInfoById(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().findBybeneficiaryOtherInfoById(id);
	}

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(
		long id) {

		return getPersistence().fetchBybeneficiaryOtherInfoById(id);
	}

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(
		long id, boolean useFinderCache) {

		return getPersistence().fetchBybeneficiaryOtherInfoById(
			id, useFinderCache);
	}

	/**
	 * Removes the beneficiary other info where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the beneficiary other info that was removed
	 */
	public static BeneficiaryOtherInfo removeBybeneficiaryOtherInfoById(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().removeBybeneficiaryOtherInfoById(id);
	}

	/**
	 * Returns the number of beneficiary other infos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching beneficiary other infos
	 */
	public static int countBybeneficiaryOtherInfoById(long id) {
		return getPersistence().countBybeneficiaryOtherInfoById(id);
	}

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo findBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().findBybeneficiaryOtherInfoByVerifiedId(
			verifiedId);
	}

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId) {

		return getPersistence().fetchBybeneficiaryOtherInfoByVerifiedId(
			verifiedId);
	}

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId, boolean useFinderCache) {

		return getPersistence().fetchBybeneficiaryOtherInfoByVerifiedId(
			verifiedId, useFinderCache);
	}

	/**
	 * Removes the beneficiary other info where verifiedId = &#63; from the database.
	 *
	 * @param verifiedId the verified ID
	 * @return the beneficiary other info that was removed
	 */
	public static BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().removeBybeneficiaryOtherInfoByVerifiedId(
			verifiedId);
	}

	/**
	 * Returns the number of beneficiary other infos where verifiedId = &#63;.
	 *
	 * @param verifiedId the verified ID
	 * @return the number of matching beneficiary other infos
	 */
	public static int countBybeneficiaryOtherInfoByVerifiedId(long verifiedId) {
		return getPersistence().countBybeneficiaryOtherInfoByVerifiedId(
			verifiedId);
	}

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo findBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().findBybeneficiaryOtherInfoByMobileNo(mobileNo);
	}

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo) {

		return getPersistence().fetchBybeneficiaryOtherInfoByMobileNo(mobileNo);
	}

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public static BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo, boolean useFinderCache) {

		return getPersistence().fetchBybeneficiaryOtherInfoByMobileNo(
			mobileNo, useFinderCache);
	}

	/**
	 * Removes the beneficiary other info where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @return the beneficiary other info that was removed
	 */
	public static BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().removeBybeneficiaryOtherInfoByMobileNo(
			mobileNo);
	}

	/**
	 * Returns the number of beneficiary other infos where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching beneficiary other infos
	 */
	public static int countBybeneficiaryOtherInfoByMobileNo(String mobileNo) {
		return getPersistence().countBybeneficiaryOtherInfoByMobileNo(mobileNo);
	}

	/**
	 * Caches the beneficiary other info in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 */
	public static void cacheResult(BeneficiaryOtherInfo beneficiaryOtherInfo) {
		getPersistence().cacheResult(beneficiaryOtherInfo);
	}

	/**
	 * Caches the beneficiary other infos in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfos the beneficiary other infos
	 */
	public static void cacheResult(
		List<BeneficiaryOtherInfo> beneficiaryOtherInfos) {

		getPersistence().cacheResult(beneficiaryOtherInfos);
	}

	/**
	 * Creates a new beneficiary other info with the primary key. Does not add the beneficiary other info to the database.
	 *
	 * @param id the primary key for the new beneficiary other info
	 * @return the new beneficiary other info
	 */
	public static BeneficiaryOtherInfo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the beneficiary other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info that was removed
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	public static BeneficiaryOtherInfo remove(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().remove(id);
	}

	public static BeneficiaryOtherInfo updateImpl(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		return getPersistence().updateImpl(beneficiaryOtherInfo);
	}

	/**
	 * Returns the beneficiary other info with the primary key or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	public static BeneficiaryOtherInfo findByPrimaryKey(long id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the beneficiary other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info, or <code>null</code> if a beneficiary other info with the primary key could not be found
	 */
	public static BeneficiaryOtherInfo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the beneficiary other infos.
	 *
	 * @return the beneficiary other infos
	 */
	public static List<BeneficiaryOtherInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @return the range of beneficiary other infos
	 */
	public static List<BeneficiaryOtherInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of beneficiary other infos
	 */
	public static List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryOtherInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of beneficiary other infos
	 */
	public static List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the beneficiary other infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of beneficiary other infos.
	 *
	 * @return the number of beneficiary other infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BeneficiaryOtherInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BeneficiaryOtherInfoPersistence _persistence;

}