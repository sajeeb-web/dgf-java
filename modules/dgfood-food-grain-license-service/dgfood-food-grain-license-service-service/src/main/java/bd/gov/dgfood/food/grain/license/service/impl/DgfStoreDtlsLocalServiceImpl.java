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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfStoreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfStoreDtlsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfStoreDtls",
	service = AopService.class
)
public class DgfStoreDtlsLocalServiceImpl
	extends DgfStoreDtlsLocalServiceBaseImpl {
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public DgfStoreDtls getDgfStoreDtlsFindByType(String type) {
		try {
			return dgfStoreDtlsPersistence.findByDgfStoreDtlsFindByType(type);
		} catch (NoSuchDgfStoreDtlsException e) {
			log.error("Dgf  Store Dtls   not found by type Id : " + e.getMessage());
		}
		return null;
	}
	
	public List<DgfStoreDtls> getDgfStoreDtlsListFindByType(String type) {
		try {
			return dgfStoreDtlsPersistence.findByDgfStoreDtlsListFindByType(type);
		} catch (Exception e) {
			log.error("Dgf  Store Dtls List not found by type Id : " + e.getMessage());
		}
		return null;
	}
	
	public DgfStoreDtls getDgfStoreDtlsByNid (String nationalId) {
		try {
			return dgfStoreDtlsPersistence.findByDgfStoreDtlsFindByNid(nationalId);
					
		} catch (NoSuchDgfStoreDtlsException e) {
			log.error("Dgf  Store Dtls  found by type NId : " + e.getMessage());
		}
		return null;
	}
	
	public List<DgfStoreDtls> getDgfStoreDtlsListByNid (String nationalId) {
		return dgfStoreDtlsPersistence.findByDgfStoreDtlsListFindByNid(nationalId);
	}
	
	public Map<Long, Object> getUserStoreAddrs(String nationalId) throws PortalException {
		
		List<DgfStoreDtls> dgfStoreDtls = null ;
		dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
	
		Map<Long, Object> storeAddresses = new HashMap<Long, Object>();
		
		if (dgfStoreDtls != null) {
		    for (DgfStoreDtls dgfStoreDtl : dgfStoreDtls) {
		       
		        long division = dgfStoreDtl.getDivision();
		        long district = dgfStoreDtl.getDistrict();
		        long upozila = dgfStoreDtl.getUpzilla();
		        long union = dgfStoreDtl.getUnionName();
		        
		        dgfLocDivision div = dgfLocDivisionLocalServiceUtil.getdgfLocDivision(division);
		        dgfLocDistrict dis = dgfLocDistrictLocalServiceUtil.getdgfLocDistrict(district);
		        dgfLocSubdistrict upo =dgfLocSubdistrictLocalServiceUtil.getdgfLocSubdistrict(upozila);
		        //dgfLocUnion uni = dgfLocUnionLocalServiceUtil.getdgfLocUnion(union);
		        
	            Map<String, String> storeAddress = new HashMap<>();
		        
	            storeAddress.put("division", div.getName());
	            storeAddress.put("divisionBn", div.getBnName());
	            storeAddress.put("district", dis.getName());
	            storeAddress.put("districtBn", dis.getBnName());
	            storeAddress.put("subdistrict", upo.getName());
	            storeAddress.put("subdistrictBn", upo.getBnName());
				
				
			        
			    storeAddresses.put(dgfStoreDtl.getId(), storeAddress);
			   
		      
		    }
		} 
		return storeAddresses;
	}	

	
}