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

package bd.gov.dgfood.dealer.registration.service.http;

import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>DgfDlrRegDtlsServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrRegDtlsServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject saveRegData(
		HttpPrincipal httpPrincipal, String licenseNo,
		java.util.Date licnsIssueDate, String dealerShipType, String omsSubType,
		String nid, java.util.Date dob, String maritalStatus, String spouseName,
		String spouseFatherName, String spouseNid, java.util.Date spouseDob) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "saveRegData",
				_saveRegDataParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, licenseNo, licnsIssueDate, dealerShipType,
				omsSubType, nid, dob, maritalStatus, spouseName,
				spouseFatherName, spouseNid, spouseDob);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRegLocData(
		HttpPrincipal httpPrincipal, String nid, long shopDiv, long shopDis,
		long shopUpazila, long shopUnion) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "saveRegLocData",
				_saveRegLocDataParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, nid, shopDiv, shopDis, shopUpazila, shopUnion);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRegDocData(
		HttpPrincipal httpPrincipal, String nid, long bankSolvCertAttchId,
		long taxRtrnCertAttchId, long shopOwnrshpDocAttchId,
		long shopRentalDocAttchId, long signOrThumbPicAttchId) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "saveRegDocData",
				_saveRegDocDataParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, nid, bankSolvCertAttchId, taxRtrnCertAttchId,
				shopOwnrshpDocAttchId, shopRentalDocAttchId,
				signOrThumbPicAttchId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject saveFinalSubmitData(
		HttpPrincipal httpPrincipal, String nid) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "saveFinalSubmitData",
				_saveFinalSubmitDataParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, nid);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getDlrListSearchResult(
			HttpPrincipal httpPrincipal, String dateFrom, String dateTo,
			String dateType, String nid, long union, String dealerType,
			int status, long roleId, String upazillaOrDistrict,
			long companyId) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "getDlrListSearchResult",
				_getDlrListSearchResultParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dateFrom, dateTo, dateType, nid, union, dealerType,
				status, roleId, upazillaOrDistrict, companyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getDlrDetailData(
		HttpPrincipal httpPrincipal, String nid) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "getDlrDetailData",
				_getDlrDetailDataParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, nid);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getDlrAllAddress(
		HttpPrincipal httpPrincipal, String nid) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "getDlrAllAddress",
				_getDlrAllAddressParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, nid);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String addDealerRegisterWorkflowAndSendMessage(
		HttpPrincipal httpPrincipal, long dlrRegNo, String nationalId) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class,
				"addDealerRegisterWorkflowAndSendMessage",
				_addDealerRegisterWorkflowAndSendMessageParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dlrRegNo, nationalId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getDlrProfileData(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegDtlsServiceUtil.class, "getDlrProfileData",
				_getDlrProfileDataParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DgfDlrRegDtlsServiceHttp.class);

	private static final Class<?>[] _saveRegDataParameterTypes0 = new Class[] {
		String.class, java.util.Date.class, String.class, String.class,
		String.class, java.util.Date.class, String.class, String.class,
		String.class, String.class, java.util.Date.class
	};
	private static final Class<?>[] _saveRegLocDataParameterTypes1 =
		new Class[] {
			String.class, long.class, long.class, long.class, long.class
		};
	private static final Class<?>[] _saveRegDocDataParameterTypes2 =
		new Class[] {
			String.class, long.class, long.class, long.class, long.class,
			long.class
		};
	private static final Class<?>[] _saveFinalSubmitDataParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getDlrListSearchResultParameterTypes4 =
		new Class[] {
			String.class, String.class, String.class, String.class, long.class,
			String.class, int.class, long.class, String.class, long.class
		};
	private static final Class<?>[] _getDlrDetailDataParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _getDlrAllAddressParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[]
		_addDealerRegisterWorkflowAndSendMessageParameterTypes7 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _getDlrProfileDataParameterTypes8 =
		new Class[] {};

}