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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfAttachmentsException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachmentsUtil
 * @generated
 */
@ProviderType
public interface DgfAttachmentsPersistence
	extends BasePersistence<DgfAttachments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfAttachmentsUtil} to access the dgf attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the dgf attachments in the entity cache if it is enabled.
	 *
	 * @param dgfAttachments the dgf attachments
	 */
	public void cacheResult(DgfAttachments dgfAttachments);

	/**
	 * Caches the dgf attachmentses in the entity cache if it is enabled.
	 *
	 * @param dgfAttachmentses the dgf attachmentses
	 */
	public void cacheResult(java.util.List<DgfAttachments> dgfAttachmentses);

	/**
	 * Creates a new dgf attachments with the primary key. Does not add the dgf attachments to the database.
	 *
	 * @param attchmId the primary key for the new dgf attachments
	 * @return the new dgf attachments
	 */
	public DgfAttachments create(long attchmId);

	/**
	 * Removes the dgf attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments that was removed
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	public DgfAttachments remove(long attchmId)
		throws NoSuchDgfAttachmentsException;

	public DgfAttachments updateImpl(DgfAttachments dgfAttachments);

	/**
	 * Returns the dgf attachments with the primary key or throws a <code>NoSuchDgfAttachmentsException</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments
	 * @throws NoSuchDgfAttachmentsException if a dgf attachments with the primary key could not be found
	 */
	public DgfAttachments findByPrimaryKey(long attchmId)
		throws NoSuchDgfAttachmentsException;

	/**
	 * Returns the dgf attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments, or <code>null</code> if a dgf attachments with the primary key could not be found
	 */
	public DgfAttachments fetchByPrimaryKey(long attchmId);

	/**
	 * Returns all the dgf attachmentses.
	 *
	 * @return the dgf attachmentses
	 */
	public java.util.List<DgfAttachments> findAll();

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
	public java.util.List<DgfAttachments> findAll(int start, int end);

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
	public java.util.List<DgfAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfAttachments>
			orderByComparator);

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
	public java.util.List<DgfAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DgfAttachments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf attachmentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf attachmentses.
	 *
	 * @return the number of dgf attachmentses
	 */
	public int countAll();

}