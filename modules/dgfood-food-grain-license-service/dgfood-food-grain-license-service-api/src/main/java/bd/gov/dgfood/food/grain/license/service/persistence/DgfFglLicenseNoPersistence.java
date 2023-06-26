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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicenseNoException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf fgl license no service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNoUtil
 * @generated
 */
@ProviderType
public interface DgfFglLicenseNoPersistence
	extends BasePersistence<DgfFglLicenseNo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfFglLicenseNoUtil} to access the dgf fgl license no persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a matching dgf fgl license no could not be found
	 */
	public DgfFglLicenseNo findByDgfFglLicenseNoBySerialNo(long serialNo)
		throws NoSuchDgfFglLicenseNoException;

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	public DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(long serialNo);

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNo the serial no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	public DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(
		long serialNo, boolean useFinderCache);

	/**
	 * Removes the dgf fgl license no where serialNo = &#63; from the database.
	 *
	 * @param serialNo the serial no
	 * @return the dgf fgl license no that was removed
	 */
	public DgfFglLicenseNo removeByDgfFglLicenseNoBySerialNo(long serialNo)
		throws NoSuchDgfFglLicenseNoException;

	/**
	 * Returns the number of dgf fgl license nos where serialNo = &#63;.
	 *
	 * @param serialNo the serial no
	 * @return the number of matching dgf fgl license nos
	 */
	public int countByDgfFglLicenseNoBySerialNo(long serialNo);

	/**
	 * Caches the dgf fgl license no in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 */
	public void cacheResult(DgfFglLicenseNo dgfFglLicenseNo);

	/**
	 * Caches the dgf fgl license nos in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNos the dgf fgl license nos
	 */
	public void cacheResult(java.util.List<DgfFglLicenseNo> dgfFglLicenseNos);

	/**
	 * Creates a new dgf fgl license no with the primary key. Does not add the dgf fgl license no to the database.
	 *
	 * @param id the primary key for the new dgf fgl license no
	 * @return the new dgf fgl license no
	 */
	public DgfFglLicenseNo create(long id);

	/**
	 * Removes the dgf fgl license no with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	public DgfFglLicenseNo remove(long id)
		throws NoSuchDgfFglLicenseNoException;

	public DgfFglLicenseNo updateImpl(DgfFglLicenseNo dgfFglLicenseNo);

	/**
	 * Returns the dgf fgl license no with the primary key or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	public DgfFglLicenseNo findByPrimaryKey(long id)
		throws NoSuchDgfFglLicenseNoException;

	/**
	 * Returns the dgf fgl license no with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no, or <code>null</code> if a dgf fgl license no with the primary key could not be found
	 */
	public DgfFglLicenseNo fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf fgl license nos.
	 *
	 * @return the dgf fgl license nos
	 */
	public java.util.List<DgfFglLicenseNo> findAll();

	/**
	 * Returns a range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @return the range of dgf fgl license nos
	 */
	public java.util.List<DgfFglLicenseNo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl license nos
	 */
	public java.util.List<DgfFglLicenseNo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicenseNo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl license nos
	 */
	public java.util.List<DgfFglLicenseNo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfFglLicenseNo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf fgl license nos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf fgl license nos.
	 *
	 * @return the number of dgf fgl license nos
	 */
	public int countAll();

}