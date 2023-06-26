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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfBnkChllnDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf bnk chlln dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfBnkChllnDtlsPersistence
	extends BasePersistence<DgfBnkChllnDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfBnkChllnDtlsUtil} to access the dgf bnk chlln dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the dgf bnk chlln dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 */
	public void cacheResult(DgfBnkChllnDtls dgfBnkChllnDtls);

	/**
	 * Caches the dgf bnk chlln dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBnkChllnDtlses the dgf bnk chlln dtlses
	 */
	public void cacheResult(java.util.List<DgfBnkChllnDtls> dgfBnkChllnDtlses);

	/**
	 * Creates a new dgf bnk chlln dtls with the primary key. Does not add the dgf bnk chlln dtls to the database.
	 *
	 * @param bnkChllnId the primary key for the new dgf bnk chlln dtls
	 * @return the new dgf bnk chlln dtls
	 */
	public DgfBnkChllnDtls create(long bnkChllnId);

	/**
	 * Removes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public DgfBnkChllnDtls remove(long bnkChllnId)
		throws NoSuchDgfBnkChllnDtlsException;

	public DgfBnkChllnDtls updateImpl(DgfBnkChllnDtls dgfBnkChllnDtls);

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or throws a <code>NoSuchDgfBnkChllnDtlsException</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws NoSuchDgfBnkChllnDtlsException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public DgfBnkChllnDtls findByPrimaryKey(long bnkChllnId)
		throws NoSuchDgfBnkChllnDtlsException;

	/**
	 * Returns the dgf bnk chlln dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls, or <code>null</code> if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public DgfBnkChllnDtls fetchByPrimaryKey(long bnkChllnId);

	/**
	 * Returns all the dgf bnk chlln dtlses.
	 *
	 * @return the dgf bnk chlln dtlses
	 */
	public java.util.List<DgfBnkChllnDtls> findAll();

	/**
	 * Returns a range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @return the range of dgf bnk chlln dtlses
	 */
	public java.util.List<DgfBnkChllnDtls> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	public java.util.List<DgfBnkChllnDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBnkChllnDtls>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf bnk chlln dtlses
	 */
	public java.util.List<DgfBnkChllnDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfBnkChllnDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf bnk chlln dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf bnk chlln dtlses.
	 *
	 * @return the number of dgf bnk chlln dtlses
	 */
	public int countAll();

}