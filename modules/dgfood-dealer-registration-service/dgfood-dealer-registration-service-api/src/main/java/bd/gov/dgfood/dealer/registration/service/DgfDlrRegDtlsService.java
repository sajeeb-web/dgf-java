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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DgfDlrRegDtls. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfDlrRegDtlsService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegDtlsServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf dlr reg dtls remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfDlrRegDtlsServiceUtil} if injection and service tracking are not available.
	 */
	public String addDealerRegisterWorkflowAndSendMessage(
		long dlrRegNo, String nationalId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getDlrAllAddress(String nid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getDlrDetailData(String nid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getDlrListSearchResult(
		String dateFrom, String dateTo, String dateType, String nid, long union,
		String dealerType, int status, long roleId, String upazillaOrDistrict,
		long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getDlrProfileData();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public JSONObject saveFinalSubmitData(String nid);

	public JSONObject saveRegData(
		String licenseNo, Date licnsIssueDate, String dealerShipType,
		String omsSubType, String nid, Date dob, String maritalStatus,
		String spouseName, String spouseFatherName, String spouseNid,
		Date spouseDob);

	public JSONObject saveRegDocData(
		String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
		long shopOwnrshpDocAttchId, long shopRentalDocAttchId,
		long signOrThumbPicAttchId);

	public JSONObject saveRegLocData(
		String nid, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion);

}