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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfUsersDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.licnsUserRegsLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.util.NidInstanceConfiguration;
import bd.gov.dgfood.food.grain.license.util.NidVerificationUtil;
import bd.gov.dgfood.food.grain.license.util.UploadFileUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.licnsUserRegs", service = AopService.class)
public class licnsUserRegsLocalServiceImpl extends licnsUserRegsLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil.getLog(licnsUserRegsLocalServiceImpl.class);

	@Reference
	private ConfigurationAdmin configurationAdmin;

	public licnsUserRegs getlicnsUserByNid(String nidId) throws NoSuchlicnsUserRegsException {
		return licnsUserRegsPersistence.findBylicnsUserRegsNid(nidId);
	}

	public Map<String, String> getlicnsUserAddrs(String nidId) throws PortalException {

		licnsUserRegs licnsUser = licnsUserRegsPersistence.findBylicnsUserRegsNid(nidId);
		dgfLocDivision div = dgfLocDivisionLocalServiceUtil.getdgfLocDivision(licnsUser.getDivision());
		dgfLocDistrict dis = dgfLocDistrictLocalServiceUtil.getdgfLocDistrict(licnsUser.getDistrict());
		dgfLocSubdistrict subDis = dgfLocSubdistrictLocalServiceUtil.getdgfLocSubdistrict(licnsUser.getUpzilla());
		dgfLocUnion un = dgfLocUnionLocalServiceUtil.getdgfLocUnion(licnsUser.getUnionName());
		String village = licnsUser.getVillage();
		String ward = licnsUser.getWard();
		String ps = licnsUser.getPostOffice();
		String zipCode = licnsUser.getZipCode();
		String house = licnsUser.getHouseAddress();

		dgfLocDivision busDiv = dgfLocDivisionLocalServiceUtil.getdgfLocDivision(licnsUser.getBusinessDivision());
		dgfLocDistrict busDis = dgfLocDistrictLocalServiceUtil.getdgfLocDistrict(licnsUser.getBusinessDistrict());
		dgfLocSubdistrict busSubDis = dgfLocSubdistrictLocalServiceUtil
				.getdgfLocSubdistrict(licnsUser.getBusinessUpzilla());
		dgfLocUnion busUn = dgfLocUnionLocalServiceUtil.getdgfLocUnion(licnsUser.getBusinessUnionName());
		String busVillage = licnsUser.getBusinessVillage();
		String busWard = licnsUser.getBusinessWard();
		String busPs = licnsUser.getBusinessPostOffice();
		String busZipCode = licnsUser.getBusinessZipCode();
		String busHouse = licnsUser.getBusinessHouseAddress();

		Map<String, String> address = new HashMap<>();
		address.put("division", div.getName());
		address.put("divisionBn", div.getBnName());
		address.put("district", dis.getName());
		address.put("districtBn", dis.getBnName());
		address.put("subdistrict", subDis.getName());
		address.put("subdistrictBn", subDis.getBnName());
		address.put("union", un.getName());
		address.put("unionBn", un.getBnName());
		address.put("village", village);
		address.put("ward", ward);
		address.put("zipcode", zipCode);
		address.put("postoffice", ps);
		address.put("house", house);
		address.put("busdivision", busDiv.getName());
		address.put("busdivisionBn", busDiv.getBnName());
		address.put("busdistrict", busDis.getName());
		address.put("busdistrictBn", busDis.getBnName());
		address.put("bussubdistrict", busSubDis.getName());
		address.put("bussubdistrictBn", busSubDis.getBnName());
		address.put("busunion", busUn.getName());
		address.put("busunionBn", busUn.getBnName());
		address.put("busVillage", busVillage);
		address.put("busward", busWard);
		address.put("buszipcode", busZipCode);
		address.put("buspostoffice", busPs);
		address.put("bushouse", busHouse);
		address.put("nidDivision", licnsUser.getNidDivision());
		address.put("nidDistrict", licnsUser.getNidDistrict());
		address.put("nidUpazila", licnsUser.getNidUpzilla());
		address.put("nidUnion", licnsUser.getNidUnion());
		address.put("nidVillage", licnsUser.getNidVillage());
		address.put("nidWard", licnsUser.getNidWard());
		address.put("nidZipCode", licnsUser.getNidZipCode());
		address.put("nidPostOffice", licnsUser.getNidPostOffice());
		address.put("nidHouseAddress", licnsUser.getNidHouseAddress());

		return address;
	}

	public JSONArray fetchNidData(String nid, String dob) {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		Dictionary<String, Object> nidInstanceConfiguration = getNidInstanceConfiguration();
		String baseUrl = (String) nidInstanceConfiguration.get("baseUrl");
		if(baseUrl != null && baseUrl != "") {
			List<String> requestedFor = new ArrayList<>();
			requestedFor.add("NID");
	
			Map<String, Object> map = new HashMap<>();
			map.put("rule", "NID");
			map.put("requestKey", nid);
			map.put("dateOfBirth", dob);
			map.put("requestedFor", requestedFor);
			map.put("username", nidInstanceConfiguration.get("userName")); // need user for authentication
			map.put("password", nidInstanceConfiguration.get("password")); // need password for authentication
			array = NidVerificationUtil.fetchData(map, (String) nidInstanceConfiguration.get("baseUrl"));
			return array;
		} else {
			_log.info("Please add Nid credential in System Settings");
		}
		return array;
	}

	public boolean checkNidStatus(String nid, String dob) {
		
		Dictionary<String, Object> nidInstanceConfiguration = getNidInstanceConfiguration();
		String baseUrl = (String) nidInstanceConfiguration.get("baseUrl");
		if(baseUrl != null && baseUrl != "") {
			List<String> requestedFor = new ArrayList<>();
			requestedFor.add("NID");
			getNidInstanceConfiguration();
			Map<String, Object> map = new HashMap<>();
			map.put("rule", "NID");
			map.put("requestKey", nid);
			map.put("dateOfBirth", dob);
			map.put("requestedFor", requestedFor);
			map.put("username", nidInstanceConfiguration.get("userName")); // need user for authentication
			map.put("password", nidInstanceConfiguration.get("password")); // need password for authentication
			return NidVerificationUtil.checkStatus(map, (String) nidInstanceConfiguration.get("baseUrl"));
			} else {
				_log.info("Please add Nid credential in System Settings");
			}
		return false;
		}

	private Dictionary<String, Object> getNidInstanceConfiguration() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration(NidInstanceConfiguration.class.getName());
			return configuration.getProperties();
		} catch (IOException e) {
			 e.getMessage();
		}
		return null;
	}
	
	public DgfAttachments uploadFile(ActionRequest actionRequest, String nationalId, String realPath, ResourceBundle bundle, String filecat, String attachmentInputName) {
		return UploadFileUtil.addUploadDoc(actionRequest,  nationalId, realPath, bundle, filecat, attachmentInputName);
	}

}