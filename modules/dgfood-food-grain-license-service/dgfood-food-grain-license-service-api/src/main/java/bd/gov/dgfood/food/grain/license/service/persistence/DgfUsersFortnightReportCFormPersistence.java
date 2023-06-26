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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersFortnightReportCFormException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf users fortnight report c form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportCFormUtil
 * @generated
 */
@ProviderType
public interface DgfUsersFortnightReportCFormPersistence
	extends BasePersistence<DgfUsersFortnightReportCForm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfUsersFortnightReportCFormUtil} to access the dgf users fortnight report c form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(String usernationalId);

	/**
	 * Returns a range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_First(
				String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_First(
			String usernationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_Last(
				String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_Last(
			String usernationalId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm[]
			findByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(String usernationalId);

	/**
	 * Returns a range of all the dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms that the user has permissions to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set of dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm[]
			filterFindByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Removes all the dgf users fortnight report c forms where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	public void removeByFortnightReportCFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public int countByFortnightReportCFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public int filterCountByFortnightReportCFormByUsernationalId(
		String usernationalId);

	/**
	 * Returns all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(String screenName);

	/**
	 * Returns a range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_First(
				String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_First(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_Last(
				String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_Last(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm[]
			findByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(String screenName);

	/**
	 * Returns a range of all the dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms that the user has permissions to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public java.util.List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set of dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm[]
			filterFindByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				com.liferay.portal.kernel.util.OrderByComparator
					<DgfUsersFortnightReportCForm> orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Removes all the dgf users fortnight report c forms where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public void removeByForthnightReportCFormByScreenName(String screenName);

	/**
	 * Returns the number of dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public int countByForthnightReportCFormByScreenName(String screenName);

	/**
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public int filterCountByForthnightReportCFormByScreenName(
		String screenName);

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo);

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo, boolean useFinderCache);

	/**
	 * Removes the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the dgf users fortnight report c form that was removed
	 */
	public DgfUsersFortnightReportCForm
			removeByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public int countByFortnightReportCFormByNIDandLicenseNo(
		String usernationalId, String licenseNo);

	/**
	 * Caches the dgf users fortnight report c form in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 */
	public void cacheResult(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm);

	/**
	 * Caches the dgf users fortnight report c forms in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForms the dgf users fortnight report c forms
	 */
	public void cacheResult(
		java.util.List<DgfUsersFortnightReportCForm>
			dgfUsersFortnightReportCForms);

	/**
	 * Creates a new dgf users fortnight report c form with the primary key. Does not add the dgf users fortnight report c form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report c form
	 * @return the new dgf users fortnight report c form
	 */
	public DgfUsersFortnightReportCForm create(long reportId);

	/**
	 * Removes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm remove(long reportId)
		throws NoSuchDgfUsersFortnightReportCFormException;

	public DgfUsersFortnightReportCForm updateImpl(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm);

	/**
	 * Returns the dgf users fortnight report c form with the primary key or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm findByPrimaryKey(long reportId)
		throws NoSuchDgfUsersFortnightReportCFormException;

	/**
	 * Returns the dgf users fortnight report c form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form, or <code>null</code> if a dgf users fortnight report c form with the primary key could not be found
	 */
	public DgfUsersFortnightReportCForm fetchByPrimaryKey(long reportId);

	/**
	 * Returns all the dgf users fortnight report c forms.
	 *
	 * @return the dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm> findAll();

	/**
	 * Returns a range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfUsersFortnightReportCForm> orderByComparator);

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users fortnight report c forms
	 */
	public java.util.List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfUsersFortnightReportCForm> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf users fortnight report c forms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf users fortnight report c forms.
	 *
	 * @return the number of dgf users fortnight report c forms
	 */
	public int countAll();

}