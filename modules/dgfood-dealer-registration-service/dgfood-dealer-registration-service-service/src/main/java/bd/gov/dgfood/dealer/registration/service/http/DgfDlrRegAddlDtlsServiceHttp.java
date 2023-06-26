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

import bd.gov.dgfood.dealer.registration.service.DgfDlrRegAddlDtlsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>DgfDlrRegAddlDtlsServiceUtil</code> service
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
public class DgfDlrRegAddlDtlsServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject
		saveDgfDlrRegAddlDtls(
			HttpPrincipal httpPrincipal, String nid, long phsclyChlnGdAttchId,
			int workInGovt, int publcRep, int physclyChlngd, long shopHeight,
			long shopLength, long shopWidth, long shopStorageCap,
			int isCemented, int signBoard, int dlrRunShpHimself,
			String dealershipMemName, String dealershipMemType, int truckType,
			String truckRentFlag, String truckPlatNo, long truckCap,
			String truckMake, String truckModel, long truckManuYear) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrRegAddlDtlsServiceUtil.class, "saveDgfDlrRegAddlDtls",
				_saveDgfDlrRegAddlDtlsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, nid, phsclyChlnGdAttchId, workInGovt, publcRep,
				physclyChlngd, shopHeight, shopLength, shopWidth,
				shopStorageCap, isCemented, signBoard, dlrRunShpHimself,
				dealershipMemName, dealershipMemType, truckType, truckRentFlag,
				truckPlatNo, truckCap, truckMake, truckModel, truckManuYear);

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
		DgfDlrRegAddlDtlsServiceHttp.class);

	private static final Class<?>[] _saveDgfDlrRegAddlDtlsParameterTypes0 =
		new Class[] {
			String.class, long.class, int.class, int.class, int.class,
			long.class, long.class, long.class, long.class, int.class,
			int.class, int.class, String.class, String.class, int.class,
			String.class, String.class, long.class, String.class, String.class,
			long.class
		};

}