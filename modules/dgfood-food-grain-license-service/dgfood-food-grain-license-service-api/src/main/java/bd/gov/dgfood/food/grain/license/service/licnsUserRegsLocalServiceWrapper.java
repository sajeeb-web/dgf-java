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
 * Provides a wrapper for {@link licnsUserRegsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegsLocalService
 * @generated
 */
public class licnsUserRegsLocalServiceWrapper
	implements licnsUserRegsLocalService,
			   ServiceWrapper<licnsUserRegsLocalService> {

	public licnsUserRegsLocalServiceWrapper() {
		this(null);
	}

	public licnsUserRegsLocalServiceWrapper(
		licnsUserRegsLocalService licnsUserRegsLocalService) {

		_licnsUserRegsLocalService = licnsUserRegsLocalService;
	}

	/**
	 * Adds the licns user regs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect licnsUserRegsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param licnsUserRegs the licns user regs
	 * @return the licns user regs that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
		addlicnsUserRegs(
			bd.gov.dgfood.food.grain.license.model.licnsUserRegs
				licnsUserRegs) {

		return _licnsUserRegsLocalService.addlicnsUserRegs(licnsUserRegs);
	}

	@Override
	public boolean checkNidStatus(String nid, String dob) {
		return _licnsUserRegsLocalService.checkNidStatus(nid, dob);
	}

	/**
	 * Creates a new licns user regs with the primary key. Does not add the licns user regs to the database.
	 *
	 * @param licUserId the primary key for the new licns user regs
	 * @return the new licns user regs
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
		createlicnsUserRegs(long licUserId) {

		return _licnsUserRegsLocalService.createlicnsUserRegs(licUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the licns user regs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect licnsUserRegsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param licnsUserRegs the licns user regs
	 * @return the licns user regs that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
		deletelicnsUserRegs(
			bd.gov.dgfood.food.grain.license.model.licnsUserRegs
				licnsUserRegs) {

		return _licnsUserRegsLocalService.deletelicnsUserRegs(licnsUserRegs);
	}

	/**
	 * Deletes the licns user regs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect licnsUserRegsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs that was removed
	 * @throws PortalException if a licns user regs with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
			deletelicnsUserRegs(long licUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.deletelicnsUserRegs(licUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _licnsUserRegsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _licnsUserRegsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _licnsUserRegsLocalService.dynamicQuery();
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

		return _licnsUserRegsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.licnsUserRegsModelImpl</code>.
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

		return _licnsUserRegsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.licnsUserRegsModelImpl</code>.
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

		return _licnsUserRegsLocalService.dynamicQuery(
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

		return _licnsUserRegsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _licnsUserRegsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
		fetchlicnsUserRegs(long licUserId) {

		return _licnsUserRegsLocalService.fetchlicnsUserRegs(licUserId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchNidData(
		String nid, String dob) {

		return _licnsUserRegsLocalService.fetchNidData(nid, dob);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _licnsUserRegsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _licnsUserRegsLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.Map<String, String> getlicnsUserAddrs(String nidId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.getlicnsUserAddrs(nidId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
			getlicnsUserByNid(String nidId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchlicnsUserRegsException {

		return _licnsUserRegsLocalService.getlicnsUserByNid(nidId);
	}

	/**
	 * Returns the licns user regs with the primary key.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs
	 * @throws PortalException if a licns user regs with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
			getlicnsUserRegs(long licUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.getlicnsUserRegs(licUserId);
	}

	/**
	 * Returns a range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @return the range of licns user regses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.licnsUserRegs>
		getlicnsUserRegses(int start, int end) {

		return _licnsUserRegsLocalService.getlicnsUserRegses(start, end);
	}

	/**
	 * Returns the number of licns user regses.
	 *
	 * @return the number of licns user regses
	 */
	@Override
	public int getlicnsUserRegsesCount() {
		return _licnsUserRegsLocalService.getlicnsUserRegsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _licnsUserRegsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _licnsUserRegsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the licns user regs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect licnsUserRegsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param licnsUserRegs the licns user regs
	 * @return the licns user regs that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.licnsUserRegs
		updatelicnsUserRegs(
			bd.gov.dgfood.food.grain.license.model.licnsUserRegs
				licnsUserRegs) {

		return _licnsUserRegsLocalService.updatelicnsUserRegs(licnsUserRegs);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments uploadFile(
		javax.portlet.ActionRequest actionRequest, String nationalId,
		String realPath, java.util.ResourceBundle bundle, String filecat,
		String attachmentInputName) {

		return _licnsUserRegsLocalService.uploadFile(
			actionRequest, nationalId, realPath, bundle, filecat,
			attachmentInputName);
	}

	@Override
	public licnsUserRegsLocalService getWrappedService() {
		return _licnsUserRegsLocalService;
	}

	@Override
	public void setWrappedService(
		licnsUserRegsLocalService licnsUserRegsLocalService) {

		_licnsUserRegsLocalService = licnsUserRegsLocalService;
	}

	private licnsUserRegsLocalService _licnsUserRegsLocalService;

}