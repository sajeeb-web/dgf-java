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

import bd.gov.dgfood.food.grain.license.model.DgfAttachments;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf attachments service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfAttachmentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachmentsPersistence
 * @generated
 */
public class DgfAttachmentsUtil {

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
	public static void clearCache(DgfAttachments dgfAttachments) {
		getPersistence().clearCache(dgfAttachments);
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
	public static Map<Serializable, DgfAttachments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfAttachments> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfAttachments update(DgfAttachments dgfAttachments) {
		return getPersistence().update(dgfAttachments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfAttachments update(
		DgfAttachments dgfAttachments, ServiceContext serviceContext) {

		return getPersistence().update(dgfAttachments, serviceContext);
	}

	/**
	 * Caches the dgf attachments in the entity cache if it is enabled.
	 *
	 * @param dgfAttachments the dgf attachments
	 */
	public static void cacheResult(DgfAttachments dgfAttachments) {
		getPersistence().cacheResult(dgfAttachments);
	}

	/**
	 * Caches the dgf attachmentses in the entity cache if it is enabled.
	 *
	 * @param dgfAttachmentses the dgf attachmentses
	 */
	public static void cacheResult(List<DgfAttachments> dgfAttachmentses) {
		getPersistence().cacheResult(dgfAttachmentses);
	}

	/**
	 * Creates a new dgf attachments with the primary key. Does not add the dgf attachments to the database.
	 *
	 * @param attchmId the primary key for the new dgf attachments
	 * @return the new dgf attachments
	 */
	public static DgfAttachments create(long attchmId) {
		return getPersistence().create(attchmId);
	}

	/**
	 * Removes the dgf attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments that was removed
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	public static DgfAttachments remove(long attchmId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfAttachmentsException {

		return getPersistence().remove(attchmId);
	}

	public static DgfAttachments updateImpl(DgfAttachments dgfAttachments) {
		return getPersistence().updateImpl(dgfAttachments);
	}

	/**
	 * Returns the dgf attachments with the primary key or throws a <code>NoSuchDgfAttachmentsException</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	public static DgfAttachments findByPrimaryKey(long attchmId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfAttachmentsException {

		return getPersistence().findByPrimaryKey(attchmId);
	}

	/**
	 * Returns the dgf attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments, or <code>null</code> if a dgf attachments with the primary key could not be found
	 */
	public static DgfAttachments fetchByPrimaryKey(long attchmId) {
		return getPersistence().fetchByPrimaryKey(attchmId);
	}

	/**
	 * Returns all the dgf attachmentses.
	 *
	 * @return the dgf attachmentses
	 */
	public static List<DgfAttachments> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @return the range of dgf attachmentses
	 */
	public static List<DgfAttachments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf attachmentses
	 */
	public static List<DgfAttachments> findAll(
		int start, int end,
		OrderByComparator<DgfAttachments> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf attachmentses
	 */
	public static List<DgfAttachments> findAll(
		int start, int end, OrderByComparator<DgfAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf attachmentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf attachmentses.
	 *
	 * @return the number of dgf attachmentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfAttachmentsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfAttachmentsPersistence _persistence;

}