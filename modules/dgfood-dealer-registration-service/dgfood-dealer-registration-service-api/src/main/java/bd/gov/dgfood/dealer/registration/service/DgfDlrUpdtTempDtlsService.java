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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DgfDlrUpdtTempDtls. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfDlrUpdtTempDtlsService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf dlr updt temp dtls remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfDlrUpdtTempDtlsServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public JSONObject saveDgfDlrUpdtTempDtls(
		String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
		int physclyChlngd, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion, String shopWard, String shopZipCode, String shopLoc,
		long shopHeight, long shopLength, long shopWidth, long shopStorageCap,
		int isCemented, int signBoard, int dlrRunShpHimself,
		String dealershipMemName, String dealershipMemType, int truckType,
		String truckRentFlag, String truckPlatNo, long truckCap,
		String truckMake, String truckModel, long truckManuYear,
		long dlrPerfYr1SN, long dlrPerfYr1AllocQty, long dlrPerfYr1ComdtyQty,
		String dlrPerfYr1DlrCtgry, String dlrPerfYr1Rmrk, long dlrPerfYr2SN,
		long dlrPerfYr2AllocQty, long dlrPerfYr2ComdtyQty,
		String dlrPerfYr2DlrCtgry, String dlrPerfYr2Rmrk, long dlrPerfYr3SN,
		long dlrPerfYr3AllocQty, long dlrPerfYr3ComdtyQty,
		String dlrPerfYr3DlrCtgry, String dlrPerfYr3Rmrk,
		int dlrOptFoodgrainLicense, int dlrOptTradeLicense,
		int dlrOptTcvDlrLicense, int dlrOptImportLicense,
		int dlrOptLicenseEssentialGoods, int dlrOptTradeLicenseAgriculture);

}