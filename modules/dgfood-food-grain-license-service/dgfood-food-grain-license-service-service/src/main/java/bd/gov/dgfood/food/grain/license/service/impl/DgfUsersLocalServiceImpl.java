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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfUsersLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfUsers", service = AopService.class)
public class DgfUsersLocalServiceImpl extends DgfUsersLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public void addDgfUsersInfo(String name, String phoneNo, String nidNo) {

		DgfUsers dgfUsers = DgfUsersLocalServiceUtil.createDgfUsers(CounterLocalServiceUtil.increment());
		dgfUsers.setApplicantName(name);
		dgfUsers.setMobileNo(phoneNo);
		dgfUsers.setNationalId(nidNo);
		dgfUsers.setModifiedDate(new Date());
		dgfUsers.setCreateDate(new Date());
		DgfUsersLocalServiceUtil.addDgfUsers(dgfUsers);
	}
	
	@Override
	public DgfUsers getDgfUsersByNid(String nationalId) throws NoSuchDgfUsersException {
		return dgfUsersPersistence.findByDgfUsersByNationalId(nationalId);
	}
	
	public List<DgfUsers> getDgfAcfUsersByDistrict(long districtId, long companyId) throws NoSuchDgfUsersException {
		try {
			Role roleAcf = RoleLocalServiceUtil.getRole(companyId, LicenseCommonConstant.ROLE_ACF);

			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsers.class, classLoader);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select ugr.userId from UserGroupRole ugr where ugr.userId = this_.userId and  ugr.roleId = " +roleAcf.getRoleId()+")"));
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select duad.addressId from dgf_users_addr_dtls duad where duad.addressId = this_.presentAddrId and  duad.district = " +districtId+")"));
			return DgfUsersLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (PortalException e) {
			log.error("get dgfusers by distrct error ==="+e.getMessage());
		}
		return null;
	}
	
	public List<DgfUsers> getDgfDcfUsersByDistrict(long districtId, long companyId) throws NoSuchDgfUsersException {
		try {
			Role roleDcf = RoleLocalServiceUtil.getRole(companyId, LicenseCommonConstant.ROLE_DCF);

			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsers.class, classLoader);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select ugr.userId from UserGroupRole ugr where ugr.userId = this_.userId and  ugr.roleId = " +roleDcf.getRoleId()+")"));
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select duad.addressId from dgf_users_addr_dtls duad where duad.addressId = this_.presentAddrId and  duad.district = " +districtId+")"));
			return DgfUsersLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (PortalException e) {
			log.error("get dgfusers by distrct error ==="+e.getMessage());
		}
		return null;
	}
	
	public List<DgfUsers> getDgfUcfUsersByDistrict(long upazilaId, long companyId) throws NoSuchDgfUsersException {
		try {
			Role roleUcf = RoleLocalServiceUtil.getRole(companyId, LicenseCommonConstant.ROLE_UCF);

			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsers.class, classLoader);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select ugr.userId from UserGroupRole ugr where ugr.userId = this_.userId and  ugr.roleId = " +roleUcf.getRoleId()+")"));
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select duad.addressId from dgf_users_addr_dtls duad where duad.addressId = this_.presentAddrId and  duad.upzilla = " +upazilaId+")"));
			return DgfUsersLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (PortalException e) {
			log.error("get dgfusers by distrct error ==="+e.getMessage());
		}
		return null;
	}
	
	public List<DgfUsers> getDgfCcdrUsersByUpazila(long upazilaId, long companyId) throws NoSuchDgfUsersException {
		try {
			Role roleCcdr = RoleLocalServiceUtil.getRole(companyId, LicenseCommonConstant.ROLE_CCDR);

			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsers.class, classLoader);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select ugr.userId from UserGroupRole ugr where ugr.userId = this_.userId and  ugr.roleId = " +roleCcdr.getRoleId()+")"));
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select duad.addressId from dgf_users_addr_dtls duad where duad.addressId = this_.presentAddrId and  duad.upzilla = " +upazilaId+")"));
			return DgfUsersLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (PortalException e) {
			log.error("get dgfusers by distrct error ==="+e.getMessage());
		}
		return null;
	}
	
	public List<DgfUsers> getDgfRcfUsersByUpazila(long upazilaId, long companyId) throws NoSuchDgfUsersException {
		try {
			Role roleRcf = RoleLocalServiceUtil.getRole(companyId, LicenseCommonConstant.ROLE_RCF);

			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DgfUsers.class, classLoader);
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select ugr.userId from UserGroupRole ugr where ugr.userId = this_.userId and  ugr.roleId = " +roleRcf.getRoleId()+")"));
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("exists(select duad.addressId from dgf_users_addr_dtls duad where duad.addressId = this_.presentAddrId and  duad.upzilla = " +upazilaId+")"));
			return DgfUsersLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (PortalException e) {
			log.error("get dgfusers by distrct error ==="+e.getMessage());
		}
		return null;
	}

}