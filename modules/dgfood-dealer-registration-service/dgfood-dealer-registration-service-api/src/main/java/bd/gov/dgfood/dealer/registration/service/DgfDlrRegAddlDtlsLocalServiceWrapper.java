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

package bd.gov.dgfood.dealer.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfDlrRegAddlDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsLocalService
 * @generated
 */
public class DgfDlrRegAddlDtlsLocalServiceWrapper
	implements DgfDlrRegAddlDtlsLocalService,
			   ServiceWrapper<DgfDlrRegAddlDtlsLocalService> {

	public DgfDlrRegAddlDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrRegAddlDtlsLocalServiceWrapper(
		DgfDlrRegAddlDtlsLocalService dgfDlrRegAddlDtlsLocalService) {

		_dgfDlrRegAddlDtlsLocalService = dgfDlrRegAddlDtlsLocalService;
	}

	/**
	 * Adds the dgf dlr reg addl dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was added
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		addDgfDlrRegAddlDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
				dgfDlrRegAddlDtls) {

		return _dgfDlrRegAddlDtlsLocalService.addDgfDlrRegAddlDtls(
			dgfDlrRegAddlDtls);
	}

	/**
	 * Creates a new dgf dlr reg addl dtls with the primary key. Does not add the dgf dlr reg addl dtls to the database.
	 *
	 * @param dlrRegAddlDtlsId the primary key for the new dgf dlr reg addl dtls
	 * @return the new dgf dlr reg addl dtls
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		createDgfDlrRegAddlDtls(long dlrRegAddlDtlsId) {

		return _dgfDlrRegAddlDtlsLocalService.createDgfDlrRegAddlDtls(
			dlrRegAddlDtlsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegAddlDtlsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf dlr reg addl dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		deleteDgfDlrRegAddlDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
				dgfDlrRegAddlDtls) {

		return _dgfDlrRegAddlDtlsLocalService.deleteDgfDlrRegAddlDtls(
			dgfDlrRegAddlDtls);
	}

	/**
	 * Deletes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws PortalException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
			deleteDgfDlrRegAddlDtls(long dlrRegAddlDtlsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegAddlDtlsLocalService.deleteDgfDlrRegAddlDtls(
			dlrRegAddlDtlsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegAddlDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrRegAddlDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrRegAddlDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrRegAddlDtlsLocalService.dynamicQuery();
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

		return _dgfDlrRegAddlDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
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

		return _dgfDlrRegAddlDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
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

		return _dgfDlrRegAddlDtlsLocalService.dynamicQuery(
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

		return _dgfDlrRegAddlDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfDlrRegAddlDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		fetchDgfDlrRegAddlDtls(long dlrRegAddlDtlsId) {

		return _dgfDlrRegAddlDtlsLocalService.fetchDgfDlrRegAddlDtls(
			dlrRegAddlDtlsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrRegAddlDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws PortalException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
			getDgfDlrRegAddlDtls(long dlrRegAddlDtlsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtls(
			dlrRegAddlDtlsId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls>
			getDgfDlrRegAddlDtlsByNid(String nid) {

		return _dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByNid(nid);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		getDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {

		return _dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByRegNo(
			dlrRegNo);
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of dgf dlr reg addl dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls>
			getDgfDlrRegAddlDtlses(int start, int end) {

		return _dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlses(
			start, end);
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses.
	 *
	 * @return the number of dgf dlr reg addl dtlses
	 */
	@Override
	public int getDgfDlrRegAddlDtlsesCount() {
		return _dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrRegAddlDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrRegAddlDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegAddlDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		saveDgfDlrRegAddlDtls(
			String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
			int physclyChlngd, long shopHeight, long shopLength, long shopWidth,
			long shopStorageCap, int isCemented, int signBoard,
			int dlrRunShpHimself, String dealershipMemName,
			String dealershipMemType, int truckType, String truckRentFlag,
			String truckPlatNo, long truckCap, String truckMake,
			String truckModel, long truckManuYear) {

		return _dgfDlrRegAddlDtlsLocalService.saveDgfDlrRegAddlDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopHeight, shopLength, shopWidth, shopStorageCap, isCemented,
			signBoard, dlrRunShpHimself, dealershipMemName, dealershipMemType,
			truckType, truckRentFlag, truckPlatNo, truckCap, truckMake,
			truckModel, truckManuYear);
	}

	/**
	 * Updates the dgf dlr reg addl dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
		updateDgfDlrRegAddlDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls
				dgfDlrRegAddlDtls) {

		return _dgfDlrRegAddlDtlsLocalService.updateDgfDlrRegAddlDtls(
			dgfDlrRegAddlDtls);
	}

	@Override
	public DgfDlrRegAddlDtlsLocalService getWrappedService() {
		return _dgfDlrRegAddlDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrRegAddlDtlsLocalService dgfDlrRegAddlDtlsLocalService) {

		_dgfDlrRegAddlDtlsLocalService = dgfDlrRegAddlDtlsLocalService;
	}

	private DgfDlrRegAddlDtlsLocalService _dgfDlrRegAddlDtlsLocalService;

}