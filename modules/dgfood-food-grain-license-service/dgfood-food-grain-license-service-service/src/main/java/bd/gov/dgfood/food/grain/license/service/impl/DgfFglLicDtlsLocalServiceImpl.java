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

package bd.gov.dgfood.food.grain.license.service.impl;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.service.base.DgfFglLicDtlsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls", service = AopService.class)
public class DgfFglLicDtlsLocalServiceImpl extends DgfFglLicDtlsLocalServiceBaseImpl {

	public DgfFglLicDtls getDgfFglLicDtlsByNid(String nationalId) {
		try {
			return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByNationalId(nationalId);
		} catch (NoSuchDgfFglLicDtlsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DgfFglLicDtls> getDgfFglLicDtlsListByNid(String nid) {
		return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsListByNid(nid);
	}

	public DgfFglLicDtls getDgfFglLicDtlsByFglLicNo(String licenseNo) {
		try {
			return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByFoodgrainLicenseNo(licenseNo);
		} catch (NoSuchDgfFglLicDtlsException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DgfFglLicDtls getDgfFglLicDtlsByNidAndFglLicNo(String nationalId, String licenseNo) {
		try {
			return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(nationalId, licenseNo);
		} catch (NoSuchDgfFglLicDtlsException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DgfFglLicDtls getDgfFglLicDtlsByFglPrePrimaryId(long fglPrePrimaryId) {
		try {
			return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByFglLicPrePrimaryId(fglPrePrimaryId);
		} catch (NoSuchDgfFglLicDtlsException e) {

		}
		return null;
	}
	public DgfFglLicDtls getDgfFglLicDtlsByFglApplicationNo(String fglApplicationNo) {
		try {
			return dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByFglApplicationNo(fglApplicationNo);
		} catch (NoSuchDgfFglLicDtlsException e) {
			
		}
		return null;
	}
}