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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportDFormLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfUsersFortnightReportDFormLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.util.FortnightReportDUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm",
	service = AopService.class
)
public class DgfUsersFortnightReportDFormLocalServiceImpl
	extends DgfUsersFortnightReportDFormLocalServiceBaseImpl {
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public List<DgfUsersFortnightReportDForm> getMatchingReportFormDByUserNationalId(String nationalId) {
        List<DgfUsersFortnightReportDForm> results = null;
    
        try {
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
                    .forClass(DgfUsersFortnightReportDForm.class, getClass().getClassLoader())
                    .add(PropertyFactoryUtil.forName("usernationalId").eq(nationalId));

            results = DgfUsersFortnightReportDFormLocalServiceUtil
                    .dynamicQuery(dynamicQuery);

        } catch (Exception e) {
        	log.error("Fortnight Report Form C  National Id not found: " + e.getMessage());
        }

        return results;
    }
	
	public DgfUsersFortnightReportDForm getDgfUsersFortnightReportBYNidAndLicenseNo(String nationalId, String licenseNo) {
	    DgfUsersFortnightReportDForm result = null;

	    try {
	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
	                .forClass(DgfUsersFortnightReportDForm.class, getClass().getClassLoader())
	                .add(PropertyFactoryUtil.forName("usernationalId").eq(nationalId))
	                .add(PropertyFactoryUtil.forName("licenseNo").eq(licenseNo));

	        List<DgfUsersFortnightReportDForm> results = DgfUsersFortnightReportDFormLocalServiceUtil
	                .dynamicQuery(dynamicQuery);

	        if (results != null && !results.isEmpty()) {
	            result = results.get(0);
	        }

	    } catch (Exception e) {
	    	log.error("DgfUsersFortnightReportDForm NationalId and licenseNo not found: " + e.getMessage());
	    }

	    return result;
	}

	public List<Map<String, Object>> findBySearchCriteria(String bussinessType,String endDate, long upazilla, long businessUnionName) {
		return dgfUsersFortnightReportDFormFinder.findBySearchCriteria(bussinessType, endDate,upazilla, businessUnionName);
	}

	public byte[] getLicenseReport(String queryParams) {
		return FortnightReportDUtil.getLicenseReport(queryParams);
	}
}