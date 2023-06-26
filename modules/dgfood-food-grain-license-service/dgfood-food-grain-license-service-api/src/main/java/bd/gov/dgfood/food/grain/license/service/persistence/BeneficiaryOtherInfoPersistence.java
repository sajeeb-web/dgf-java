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

import bd.gov.dgfood.food.grain.license.exception.NoSuchBeneficiaryOtherInfoException;
import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the beneficiary other info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfoUtil
 * @generated
 */
@ProviderType
public interface BeneficiaryOtherInfoPersistence
	extends BasePersistence<BeneficiaryOtherInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BeneficiaryOtherInfoUtil} to access the beneficiary other info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the beneficiary other info where id = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoById(long id)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(long id);

	/**
	 * Returns the beneficiary other info where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoById(
		long id, boolean useFinderCache);

	/**
	 * Removes the beneficiary other info where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the beneficiary other info that was removed
	 */
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoById(long id)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the number of beneficiary other infos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching beneficiary other infos
	 */
	public int countBybeneficiaryOtherInfoById(long id);

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId);

	/**
	 * Returns the beneficiary other info where verifiedId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param verifiedId the verified ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByVerifiedId(
		long verifiedId, boolean useFinderCache);

	/**
	 * Removes the beneficiary other info where verifiedId = &#63; from the database.
	 *
	 * @param verifiedId the verified ID
	 * @return the beneficiary other info that was removed
	 */
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByVerifiedId(
			long verifiedId)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the number of beneficiary other infos where verifiedId = &#63;.
	 *
	 * @param verifiedId the verified ID
	 * @return the number of matching beneficiary other infos
	 */
	public int countBybeneficiaryOtherInfoByVerifiedId(long verifiedId);

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo findBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo);

	/**
	 * Returns the beneficiary other info where mobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching beneficiary other info, or <code>null</code> if a matching beneficiary other info could not be found
	 */
	public BeneficiaryOtherInfo fetchBybeneficiaryOtherInfoByMobileNo(
		String mobileNo, boolean useFinderCache);

	/**
	 * Removes the beneficiary other info where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @return the beneficiary other info that was removed
	 */
	public BeneficiaryOtherInfo removeBybeneficiaryOtherInfoByMobileNo(
			String mobileNo)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the number of beneficiary other infos where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching beneficiary other infos
	 */
	public int countBybeneficiaryOtherInfoByMobileNo(String mobileNo);

	/**
	 * Caches the beneficiary other info in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 */
	public void cacheResult(BeneficiaryOtherInfo beneficiaryOtherInfo);

	/**
	 * Caches the beneficiary other infos in the entity cache if it is enabled.
	 *
	 * @param beneficiaryOtherInfos the beneficiary other infos
	 */
	public void cacheResult(
		java.util.List<BeneficiaryOtherInfo> beneficiaryOtherInfos);

	/**
	 * Creates a new beneficiary other info with the primary key. Does not add the beneficiary other info to the database.
	 *
	 * @param id the primary key for the new beneficiary other info
	 * @return the new beneficiary other info
	 */
	public BeneficiaryOtherInfo create(long id);

	/**
	 * Removes the beneficiary other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info that was removed
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	public BeneficiaryOtherInfo remove(long id)
		throws NoSuchBeneficiaryOtherInfoException;

	public BeneficiaryOtherInfo updateImpl(
		BeneficiaryOtherInfo beneficiaryOtherInfo);

	/**
	 * Returns the beneficiary other info with the primary key or throws a <code>NoSuchBeneficiaryOtherInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info
	 * @throws NoSuchBeneficiaryOtherInfoException if a beneficiary other info with the primary key could not be found
	 */
	public BeneficiaryOtherInfo findByPrimaryKey(long id)
		throws NoSuchBeneficiaryOtherInfoException;

	/**
	 * Returns the beneficiary other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info, or <code>null</code> if a beneficiary other info with the primary key could not be found
	 */
	public BeneficiaryOtherInfo fetchByPrimaryKey(long id);

	/**
	 * Returns all the beneficiary other infos.
	 *
	 * @return the beneficiary other infos
	 */
	public java.util.List<BeneficiaryOtherInfo> findAll();

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
	public java.util.List<BeneficiaryOtherInfo> findAll(int start, int end);

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
	public java.util.List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryOtherInfo>
			orderByComparator);

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
	public java.util.List<BeneficiaryOtherInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the beneficiary other infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of beneficiary other infos.
	 *
	 * @return the number of beneficiary other infos
	 */
	public int countAll();

}