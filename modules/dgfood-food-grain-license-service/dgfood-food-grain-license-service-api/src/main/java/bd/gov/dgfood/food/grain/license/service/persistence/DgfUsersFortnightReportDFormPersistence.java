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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersFortnightReportDFormException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users fortnight report d form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportDFormUtil
 * @generated
 */
@ProviderType
public interface DgfUsersFortnightReportDFormPersistence
	extends BasePersistence<DgfUsersFortnightReportDForm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersFortnightReportDFormUtil} to access the dgf users fortnight report d form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(String usernationalId);

	/**
	 * Returns a range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
			findByFortnightReportDFormByUsernationalId_First(
				String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByUsernationalId_First(
			String usernationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
			findByFortnightReportDFormByUsernationalId_Last(
				String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByUsernationalId_Last(
			String usernationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm[]
			findByFortnightReportDFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns all the dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(String usernationalId);

	/**
	 * Returns a range of all the dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms that the user has permissions to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set of dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm[]
			filterFindByFortnightReportDFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Removes all the dgf users fortnight report d forms where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	public void removeByFortnightReportDFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns the number of dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public int countByFortnightReportDFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns the number of dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public int filterCountByFortnightReportDFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(String screenName);

	/**
	 * Returns a range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
			findByFortnightReportDFormByScreenName_First(
				String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByScreenName_First(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
			findByFortnightReportDFormByScreenName_Last(
				String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByScreenName_Last(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm[]
			findByFortnightReportDFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns all the dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(String screenName);

	/**
	 * Returns a range of all the dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(
			String screenName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms that the user has permissions to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set of dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm[]
			filterFindByFortnightReportDFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportDForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Removes all the dgf users fortnight report d forms where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public void removeByFortnightReportDFormByScreenName(String screenName);

	/**
	 * Returns the number of dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public int countByFortnightReportDFormByScreenName(String screenName);

	/**
	 * Returns the number of dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public int filterCountByFortnightReportDFormByScreenName(String screenName);

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or throws a <code>NoSuchDgfUsersFortnightReportDFormException</code> if it could not be found.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
			findByFortnightReportDFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByNIDandLicenseNo(
			String usernationalId, String licenseNo);

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByNIDandLicenseNo(
			String usernationalId, String licenseNo, boolean useFinderCache);

	/**
	 * Removes the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the dgf users fortnight report d form that was removed
	 */
	public DgfUsersFortnightReportDForm
			removeByFortnightReportDFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the number of dgf users fortnight report d forms where usernationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public int countByFortnightReportDFormByNIDandLicenseNo(
		String usernationalId, String licenseNo);

	/**
	 * Caches the dgf users fortnight report d form in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 */
	public void cacheResult(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm);

	/**
	 * Caches the dgf users fortnight report d forms in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportDForms the dgf users fortnight report d forms
	 */
	public void cacheResult(
		java.util.List<DgfUsersFortnightReportDForm>
			dgfUsersFortnightReportDForms);

	/**
	 * Creates a new dgf users fortnight report d form with the primary key. Does not add the dgf users fortnight report d form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report d form
	 * @return the new dgf users fortnight report d form
	 */
	public DgfUsersFortnightReportDForm create(long reportId);

	/**
	 * Removes the dgf users fortnight report d form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm remove(long reportId)
		throws NoSuchDgfUsersFortnightReportDFormException;

	public DgfUsersFortnightReportDForm updateImpl(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm);

	/**
	 * Returns the dgf users fortnight report d form with the primary key or throws a <code>NoSuchDgfUsersFortnightReportDFormException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm findByPrimaryKey(long reportId)
		throws NoSuchDgfUsersFortnightReportDFormException;

	/**
	 * Returns the dgf users fortnight report d form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form, or <code>null</code> if a dgf users fortnight report d form with the primary key could not be found
	 */
	public DgfUsersFortnightReportDForm fetchByPrimaryKey(long reportId);

	/**
	 * Returns all the dgf users fortnight report d forms.
	 *
	 * @return the dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm> findAll();

	/**
	 * Returns a range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfUsersFortnightReportDForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users fortnight report d forms
	 */
	public java.util.List<DgfUsersFortnightReportDForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfUsersFortnightReportDForm> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf users fortnight report d forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf users fortnight report d forms.
	 *
	 * @return the number of dgf users fortnight report d forms
	 */
	public int countAll();

}