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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDlrDistributionDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf dlr distribution dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtlsUtil
 * @generated
 */
@ProviderType
public interface DgfDlrDistributionDtlsPersistence
	extends BasePersistence<DgfDlrDistributionDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDlrDistributionDtlsUtil} to access the dgf dlr distribution dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(long dealerId);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerId(
			long dealerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls findBydgfDlrDistributionDtlsByDealerId_First(
			long dealerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls fetchBydgfDlrDistributionDtlsByDealerId_First(
		long dealerId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrDistributionDtls>
			orderByComparator);

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls findBydgfDlrDistributionDtlsByDealerId_Last(
			long dealerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls fetchBydgfDlrDistributionDtlsByDealerId_Last(
		long dealerId,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrDistributionDtls>
			orderByComparator);

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				long id, long dealerId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	public void removeBydgfDlrDistributionDtlsByDealerId(long dealerId);

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public int countBydgfDlrDistributionDtlsByDealerId(long dealerId);

	/**
	 * Returns all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(long beneficiariesId);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_First(
				long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_First(
			long beneficiariesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_Last(
			long beneficiariesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				long id, long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Removes all the dgf dlr distribution dtlses where beneficiariesId = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 */
	public void removeBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId);

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public int countBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId);

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

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
	public java.util.List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				long dealerId, long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
			long dealerId, long beneficiariesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				long dealerId, long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
			long dealerId, long beneficiariesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDlrDistributionDtls> orderByComparator);

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
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
				long id, long dealerId, long beneficiariesId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 */
	public void removeBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
		long dealerId, long beneficiariesId);

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public int countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
		long dealerId, long beneficiariesId);

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year);

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year, boolean useFinderCache);

	/**
	 * Removes the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the dgf dlr distribution dtls that was removed
	 */
	public DgfDlrDistributionDtls
			removeBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	public int countBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
		long beneficiariesId, int month, int year);

	/**
	 * Caches the dgf dlr distribution dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 */
	public void cacheResult(DgfDlrDistributionDtls dgfDlrDistributionDtls);

	/**
	 * Caches the dgf dlr distribution dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtlses the dgf dlr distribution dtlses
	 */
	public void cacheResult(
		java.util.List<DgfDlrDistributionDtls> dgfDlrDistributionDtlses);

	/**
	 * Creates a new dgf dlr distribution dtls with the primary key. Does not add the dgf dlr distribution dtls to the database.
	 *
	 * @param id the primary key for the new dgf dlr distribution dtls
	 * @return the new dgf dlr distribution dtls
	 */
	public DgfDlrDistributionDtls create(long id);

	/**
	 * Removes the dgf dlr distribution dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public DgfDlrDistributionDtls remove(long id)
		throws NoSuchDgfDlrDistributionDtlsException;

	public DgfDlrDistributionDtls updateImpl(
		DgfDlrDistributionDtls dgfDlrDistributionDtls);

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public DgfDlrDistributionDtls findByPrimaryKey(long id)
		throws NoSuchDgfDlrDistributionDtlsException;

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls, or <code>null</code> if a dgf dlr distribution dtls with the primary key could not be found
	 */
	public DgfDlrDistributionDtls fetchByPrimaryKey(long id);

	/**
	 * Returns all the dgf dlr distribution dtlses.
	 *
	 * @return the dgf dlr distribution dtlses
	 */
	public java.util.List<DgfDlrDistributionDtls> findAll();

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
	public java.util.List<DgfDlrDistributionDtls> findAll(int start, int end);

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
	public java.util.List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrDistributionDtls>
			orderByComparator);

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
	public java.util.List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfDlrDistributionDtls>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf dlr distribution dtlses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf dlr distribution dtlses.
	 *
	 * @return the number of dgf dlr distribution dtlses
	 */
	public int countAll();

}