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

package bd.gov.dgfood.food.grain.license.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfAttachmentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachmentsLocalService
 * @generated
 */
public class DgfAttachmentsLocalServiceWrapper
	implements DgfAttachmentsLocalService,
			   ServiceWrapper<DgfAttachmentsLocalService> {

	public DgfAttachmentsLocalServiceWrapper() {
		this(null);
	}

	public DgfAttachmentsLocalServiceWrapper(
		DgfAttachmentsLocalService dgfAttachmentsLocalService) {

		_dgfAttachmentsLocalService = dgfAttachmentsLocalService;
	}

	/**
	 * Adds the dgf attachments to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfAttachments the dgf attachments
	 * @return the dgf attachments that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
		addDgfAttachments(
			bd.gov.dgfood.food.grain.license.model.DgfAttachments
				dgfAttachments) {

		return _dgfAttachmentsLocalService.addDgfAttachments(dgfAttachments);
	}

	/**
	 * Creates a new dgf attachments with the primary key. Does not add the dgf attachments to the database.
	 *
	 * @param attchmId the primary key for the new dgf attachments
	 * @return the new dgf attachments
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
		createDgfAttachments(long attchmId) {

		return _dgfAttachmentsLocalService.createDgfAttachments(attchmId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfAttachmentsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf attachments from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfAttachments the dgf attachments
	 * @return the dgf attachments that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
		deleteDgfAttachments(
			bd.gov.dgfood.food.grain.license.model.DgfAttachments
				dgfAttachments) {

		return _dgfAttachmentsLocalService.deleteDgfAttachments(dgfAttachments);
	}

	/**
	 * Deletes the dgf attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments that was removed
	 * @throws PortalException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
			deleteDgfAttachments(long attchmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfAttachmentsLocalService.deleteDgfAttachments(attchmId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfAttachmentsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfAttachmentsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfAttachmentsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfAttachmentsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgfAttachmentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgfAttachmentsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgfAttachmentsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgfAttachmentsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dgfAttachmentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
		fetchDgfAttachments(long attchmId) {

		return _dgfAttachmentsLocalService.fetchDgfAttachments(attchmId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfAttachmentsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf attachments with the primary key.
	 *
	 * @param attchmId the primary key of the dgf attachments
	 * @return the dgf attachments
	 * @throws PortalException if a dgf attachments with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
			getDgfAttachments(long attchmId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfAttachmentsLocalService.getDgfAttachments(attchmId);
	}

	/**
	 * Returns a range of all the dgf attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf attachmentses
	 * @param end the upper bound of the range of dgf attachmentses (not inclusive)
	 * @return the range of dgf attachmentses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfAttachments>
		getDgfAttachmentses(int start, int end) {

		return _dgfAttachmentsLocalService.getDgfAttachmentses(start, end);
	}

	/**
	 * Returns the number of dgf attachmentses.
	 *
	 * @return the number of dgf attachmentses
	 */
	@Override
	public int getDgfAttachmentsesCount() {
		return _dgfAttachmentsLocalService.getDgfAttachmentsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfAttachmentsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfAttachmentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfAttachmentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfAttachments the dgf attachments
	 * @return the dgf attachments that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments
		updateDgfAttachments(
			bd.gov.dgfood.food.grain.license.model.DgfAttachments
				dgfAttachments) {

		return _dgfAttachmentsLocalService.updateDgfAttachments(dgfAttachments);
	}

	@Override
	public DgfAttachmentsLocalService getWrappedService() {
		return _dgfAttachmentsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfAttachmentsLocalService dgfAttachmentsLocalService) {

		_dgfAttachmentsLocalService = dgfAttachmentsLocalService;
	}

	private DgfAttachmentsLocalService _dgfAttachmentsLocalService;

}