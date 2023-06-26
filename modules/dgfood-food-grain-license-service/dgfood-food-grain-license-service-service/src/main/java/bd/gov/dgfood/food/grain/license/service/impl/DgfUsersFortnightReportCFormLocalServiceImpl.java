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

import com.liferay.petra.sql.dsl.spi.query.JoinType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.dao.orm.hibernate.RestrictionsFactoryImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormImpl;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfBussAddrDtlsException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersFortnightReportCFormException;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportCFormLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfUsersFortnightReportCFormLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.util.FortnightReportCUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm", service = AopService.class)
public class DgfUsersFortnightReportCFormLocalServiceImpl extends DgfUsersFortnightReportCFormLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public List<DgfUsersFortnightReportCForm> getMatchingReportsByUserNationalId(String nationalId) {
		List<DgfUsersFortnightReportCForm> results = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsersFortnightReportCForm.class,
					getClass().getClassLoader());

			results = DgfUsersFortnightReportCFormLocalServiceUtil.dynamicQuery(dynamicQuery);

		} catch (Exception e) {
			log.error("Fortnight Report Form D  National Id not found: " + e.getMessage());
		}

		return results;
	}

	public DgfUsersFortnightReportCForm getDgfUsersFortnightReportCFormByNationalId(String nationalId) {
		try {
			return (DgfUsersFortnightReportCForm) dgfUsersFortnightReportCFormPersistence
					.findByFortnightReportCFormByUsernationalId(nationalId);
		} catch (Exception e) {
			log.error("No DgfUsersFortnightReportCForm Found By the Nid " + e.getMessage());
		}
		return null;
	}

	public DgfUsersFortnightReportCForm getDgfUsersFortnightReportCFormByNidAndLicenseNo(String nationalId,
			String licenseNo) {
		DgfUsersFortnightReportCForm result = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(DgfUsersFortnightReportCForm.class, getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("usernationalId").eq(nationalId))
					.add(PropertyFactoryUtil.forName("licenseNo").eq(licenseNo));

			List<DgfUsersFortnightReportCForm> results = DgfUsersFortnightReportCFormLocalServiceUtil
					.dynamicQuery(dynamicQuery);

			if (results != null && !results.isEmpty()) {
				result = results.get(0);
			}

		} catch (Exception e) {
			log.error("DgfUsersFortnightReportCForm NationalId and licenseNo not found: " + e.getMessage());
		}

		return result;
	}

	
//	for getting union
	public List<dgfLocUnion> getUnionNameByUpzillaId(long subdistrictId) {
		List<dgfLocUnion> results = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(dgfLocUnion.class, getClass().getClassLoader())
					.add(PropertyFactoryUtil.forName("subdistrictId").eq(subdistrictId));
			results = dgfLocUnionLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			log.error("Error retrieving Union names: " + e.getMessage());
		}

		return results;
	}
	
	
//	for report download
	public byte[] getLicenseReport(String queryParams) {
		return FortnightReportCUtil.getLicenseReport(queryParams);
	}


	
//	for getting all info 
	
	
	public List<DgfUsersFortnightReportCForm> getAllDataUnderUCF(long userId,String usernationalId) {
		List<DgfUsersFortnightReportCForm> results = null;

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsersFortnightReportCForm.class, getClass().getClassLoader())
	 
			.add(PropertyFactoryUtil.forName("userId").eq(userId))
			.add(PropertyFactoryUtil.forName("usernationalId").eq(usernationalId));

			results = DgfUsersFortnightReportCFormLocalServiceUtil.dynamicQuery(dynamicQuery);
					
					
		} catch (Exception e) {
			log.error("Error retrieving getAllDataUnderUCF: " + e.getMessage());
		}

		return results;
	}




	public List<Map<String, Object>> findBySearchCriteria(String bussinessType,String endDate, long upazilla, long businessUnionName) {
		return dgfUsersFortnightReportCFormFinder.findBySearchCriteria(bussinessType, endDate,upazilla, businessUnionName);
	}
	

	public Date dateMaker(String dateStr) {
		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateobj = null;
				dateobj = dateformater.parse(dateStr);
				return dateobj;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}




	
	

	
	

	
	

	
	
	

}