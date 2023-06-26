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
 * Provides a wrapper for {@link DgfDlrPerfDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsLocalService
 * @generated
 */
public class DgfDlrPerfDtlsLocalServiceWrapper
	implements DgfDlrPerfDtlsLocalService,
			   ServiceWrapper<DgfDlrPerfDtlsLocalService> {

	public DgfDlrPerfDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrPerfDtlsLocalServiceWrapper(
		DgfDlrPerfDtlsLocalService dgfDlrPerfDtlsLocalService) {

		_dgfDlrPerfDtlsLocalService = dgfDlrPerfDtlsLocalService;
	}

	/**
	 * Adds the dgf dlr perf dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was added
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		addDgfDlrPerfDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
				dgfDlrPerfDtls) {

		return _dgfDlrPerfDtlsLocalService.addDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	/**
	 * Creates a new dgf dlr perf dtls with the primary key. Does not add the dgf dlr perf dtls to the database.
	 *
	 * @param dgfDlrPerfId the primary key for the new dgf dlr perf dtls
	 * @return the new dgf dlr perf dtls
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		createDgfDlrPerfDtls(long dgfDlrPerfId) {

		return _dgfDlrPerfDtlsLocalService.createDgfDlrPerfDtls(dgfDlrPerfId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrPerfDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf dlr perf dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		deleteDgfDlrPerfDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
				dgfDlrPerfDtls) {

		return _dgfDlrPerfDtlsLocalService.deleteDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	/**
	 * Deletes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws PortalException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
			deleteDgfDlrPerfDtls(long dgfDlrPerfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrPerfDtlsLocalService.deleteDgfDlrPerfDtls(dgfDlrPerfId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrPerfDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrPerfDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrPerfDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrPerfDtlsLocalService.dynamicQuery();
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

		return _dgfDlrPerfDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
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

		return _dgfDlrPerfDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
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

		return _dgfDlrPerfDtlsLocalService.dynamicQuery(
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

		return _dgfDlrPerfDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfDlrPerfDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		fetchDgfDlrPerfDtls(long dgfDlrPerfId) {

		return _dgfDlrPerfDtlsLocalService.fetchDgfDlrPerfDtls(dgfDlrPerfId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrPerfDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws PortalException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
			getDgfDlrPerfDtls(long dgfDlrPerfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtls(dgfDlrPerfId);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		getDgfDlrPerfDtlsByDlrRegNo(long dlrRegNo) {

		return _dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsByDlrRegNo(
			dlrRegNo);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls>
			getDgfDlrPerfDtlsByNid(String nid) {

		return _dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsByNid(nid);
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of dgf dlr perf dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls>
			getDgfDlrPerfDtlses(int start, int end) {

		return _dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr perf dtlses.
	 *
	 * @return the number of dgf dlr perf dtlses
	 */
	@Override
	public int getDgfDlrPerfDtlsesCount() {
		return _dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrPerfDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrPerfDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrPerfDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		saveDgfDlrPerfDtls(
			String nid, long dlrPerfYr1SN, long dlrPerfYr1AllocQty,
			long dlrPerfYr1ComdtyQty, String dlrPerfYr1DlrCtgry,
			String dlrPerfYr1Rmrk, long dlrPerfYr2SN, long dlrPerfYr2AllocQty,
			long dlrPerfYr2ComdtyQty, String dlrPerfYr2DlrCtgry,
			String dlrPerfYr2Rmrk, long dlrPerfYr3SN, long dlrPerfYr3AllocQty,
			long dlrPerfYr3ComdtyQty, String dlrPerfYr3DlrCtgry,
			String dlrPerfYr3Rmrk) {

		return _dgfDlrPerfDtlsLocalService.saveDgfDlrPerfDtls(
			nid, dlrPerfYr1SN, dlrPerfYr1AllocQty, dlrPerfYr1ComdtyQty,
			dlrPerfYr1DlrCtgry, dlrPerfYr1Rmrk, dlrPerfYr2SN,
			dlrPerfYr2AllocQty, dlrPerfYr2ComdtyQty, dlrPerfYr2DlrCtgry,
			dlrPerfYr2Rmrk, dlrPerfYr3SN, dlrPerfYr3AllocQty,
			dlrPerfYr3ComdtyQty, dlrPerfYr3DlrCtgry, dlrPerfYr3Rmrk);
	}

	/**
	 * Updates the dgf dlr perf dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
		updateDgfDlrPerfDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls
				dgfDlrPerfDtls) {

		return _dgfDlrPerfDtlsLocalService.updateDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	@Override
	public DgfDlrPerfDtlsLocalService getWrappedService() {
		return _dgfDlrPerfDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrPerfDtlsLocalService dgfDlrPerfDtlsLocalService) {

		_dgfDlrPerfDtlsLocalService = dgfDlrPerfDtlsLocalService;
	}

	private DgfDlrPerfDtlsLocalService _dgfDlrPerfDtlsLocalService;

}