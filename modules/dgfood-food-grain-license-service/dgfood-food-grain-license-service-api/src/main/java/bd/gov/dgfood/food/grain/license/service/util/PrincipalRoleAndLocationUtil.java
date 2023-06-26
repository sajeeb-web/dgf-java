package bd.gov.dgfood.food.grain.license.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;

public class PrincipalRoleAndLocationUtil {
	private static Log _log = LogFactoryUtil.getLog(PrincipalRoleAndLocationUtil.class);
	public static Role principalRole() {
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			List<Role> roles = new ArrayList<Role>();
	        roles.addAll(user.getRoles());
	        roles.addAll(getUserExplicitRoles(user));
			
			Role roleUpazila = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDistrictAcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDistrictCcdr = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_CCDR.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDistrictRcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_RCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			
			if(roleUpazila != null) {
				return roleUpazila;
			} else if(roleDistrictAcf != null) {
				return roleDistrictAcf;
			}else if(roleDistrictDcf != null) {
				return roleDistrictDcf;
			}else if(roleDistrictCcdr != null) {
				return roleDistrictCcdr;
			}else if(roleDistrictRcf != null) {
				return roleDistrictRcf;
			} 
		} catch (PortalException e) {
			_log.error("not found users ==="+e.getMessage());
		}
		return null;
	}
	
	public static String principalUserLocation() {
		
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
		DgfUsers dgfUsers = DgfUsersLocalServiceUtil.getDgfUsers(user.getUserId());
		DgfUsersAddrDtls addrDtls = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(user.getRoles());
        roles.addAll(getUserExplicitRoles(user));
		
		Role roleUpazila = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		Role roleDistrictAcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		Role roleDistrictCcdr = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_CCDR.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		Role roleDistrictRcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_RCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);

		String roleName = "";
		
		if(roleUpazila != null) {
			roleName = LicenseCommonConstant.ROLE_UCF;
		} else if(roleDistrictAcf != null) {
			roleName = LicenseCommonConstant.ROLE_ACF;
		}else if(roleDistrictDcf != null) {
			roleName = LicenseCommonConstant.ROLE_DCF;
		}else if(roleDistrictCcdr != null) {
			roleName = LicenseCommonConstant.ROLE_ACF;
		}else if(roleDistrictRcf != null) {
			roleName = LicenseCommonConstant.ROLE_ACF;
		} 
		return getLocationWithPrefixByRole(addrDtls, roleName);
		} catch (PortalException e) {
			_log.error("not found users ==="+e.getMessage());
		}
		return null;
	}
	
	public static String principalUserLocationWithPrefixByRole(String roleName) {
		
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			DgfUsers dgfUsers = DgfUsersLocalServiceUtil.getDgfUsers(user.getUserId());
			DgfUsersAddrDtls addrDtls = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());

			return getLocationWithPrefixByRole(addrDtls, roleName);
		} catch (PortalException e) {
			_log.error("not found users ==="+e.getMessage());
		}
		return null;
	}
	
	public static User principalUser() {
		try {
			return UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
		} catch (PortalException e) {
			_log.error("not found user by =====");
		}
		return null;
	}
	
	public static boolean isMatchUserWithNationalId(String nationalId) {
		try {
			User user =  UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			return user.getScreenName().equals(nationalId);
		} catch (PortalException e) {
			_log.error("not found user by =====");
		}
		return false;
	}
	
	public static long principalUserId() {
			return PrincipalThreadLocal.getUserId();
	}
	
	public static boolean isUcf() throws SystemException, PortalException {
		User currentUser = principalUser();
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(principalUser().getRoles());
        roles.addAll(getUserExplicitRoles(currentUser));
        
		Role roleUpazilaUcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		return roleUpazilaUcf != null;
    }
	
	public static boolean isAcf() throws SystemException, PortalException {
		User currentUser = principalUser();
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(principalUser().getRoles());
        roles.addAll(getUserExplicitRoles(currentUser));
        
		Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		return roleDistrictDcf != null;
    }
	
	public static boolean isDcf() throws SystemException, PortalException {
		User currentUser = principalUser();
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(principalUser().getRoles());
        roles.addAll(getUserExplicitRoles(currentUser));
        
		Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		return roleDistrictDcf != null;
    }
	
	public static boolean isRcf() throws SystemException, PortalException {
		User currentUser = principalUser();
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(principalUser().getRoles());
        roles.addAll(getUserExplicitRoles(currentUser));
        
		Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_RCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		return roleDistrictDcf != null;
    }
	
	public static boolean isCcdr() throws SystemException, PortalException {
		User currentUser = principalUser();
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(principalUser().getRoles());
        roles.addAll(getUserExplicitRoles(currentUser));
        
		Role roleDistrictDcf = roles.stream().filter(rl -> LicenseCommonConstant.ROLE_CCDR.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		return roleDistrictDcf != null;
    }
	
	public static List<Role> getUserExplicitRoles(User user) throws SystemException, PortalException {
        List<Role> roles = new ArrayList<Role>();
        List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
        for (UserGroupRole userGroupRole : userGroupRoles) {
            roles.add(userGroupRole.getRole());
        }
        return roles;
    }

	public static String getPrincipalLocationPrefixByRole(String role) {
		String locationPrefix = "";
		switch (role) {
		case LicenseCommonConstant.ROLE_UCF:
			locationPrefix = LicenseCommonConstant.UPAZILLA_FIRST_LETTER;
			break;
		case LicenseCommonConstant.ROLE_CCDR:
			locationPrefix = LicenseCommonConstant.DHAKA_METRO_TWO_LETTER;
			break;
		case LicenseCommonConstant.ROLE_RCF:
			locationPrefix = LicenseCommonConstant.OTHER_METRO_TWO_LETTER;
			break;
		default:
			locationPrefix = LicenseCommonConstant.DISTRICT_FIRST_LETTER;
		}
		return locationPrefix;
	}
	
	public static String getLocationWithPrefixByRole(DgfUsersAddrDtls addrDtls, String role) {
		String locationPrefix = "";
		switch (role.toUpperCase()) {
		case LicenseCommonConstant.ROLE_UCF:
			locationPrefix = LicenseCommonConstant.UPAZILLA_FIRST_LETTER+addrDtls.getUpzilla();
			break;
		case LicenseCommonConstant.ROLE_CCDR:
			locationPrefix = LicenseCommonConstant.DHAKA_METRO_TWO_LETTER+addrDtls.getUpzilla();
			break;
		case LicenseCommonConstant.ROLE_RCF:
			locationPrefix = LicenseCommonConstant.OTHER_METRO_TWO_LETTER+addrDtls.getUpzilla();
			break;
		default:
			locationPrefix = LicenseCommonConstant.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
		}
		return locationPrefix;
	}
	
	public static String getLocationWithPrefixByRole(DgfBussAddrDtls addrDtls, String role) {
		String locationPrefix = "";
		switch (role.toUpperCase()) {
		case LicenseCommonConstant.ROLE_UCF:
			locationPrefix = LicenseCommonConstant.UPAZILLA_FIRST_LETTER+addrDtls.getBusinessUpzilla();
			break;
		case LicenseCommonConstant.ROLE_CCDR:
			locationPrefix = LicenseCommonConstant.DHAKA_METRO_TWO_LETTER+addrDtls.getBusinessUpzilla();
			break;
		case LicenseCommonConstant.ROLE_RCF:
			locationPrefix = LicenseCommonConstant.OTHER_METRO_TWO_LETTER+addrDtls.getBusinessUpzilla();
			break;
		default:
			locationPrefix = LicenseCommonConstant.DISTRICT_FIRST_LETTER+addrDtls.getBusinessDistrict();
		}
		return locationPrefix;
	}
	
	public static String getRoleByType(String type) {
		String roleName = "";
		switch (type) {
		case LicenseCommonConstant.ATTACHAKKI:
			roleName = LicenseCommonConstant.ROLE_UCF;
			break;
		case LicenseCommonConstant.RETAILERS:
			roleName = LicenseCommonConstant.ROLE_UCF;
			break;
		case LicenseCommonConstant.FFP:
			roleName = LicenseCommonConstant.ROLE_UCF;
			break;
		case LicenseCommonConstant.OMS_UPAZILA:
			roleName = LicenseCommonConstant.ROLE_UCF;
			break;
		case LicenseCommonConstant.OMS_DHAKA_METRO:
			roleName = LicenseCommonConstant.ROLE_CCDR;
			break;
		case LicenseCommonConstant.OMS_OTHER_METRO:
			roleName = LicenseCommonConstant.ROLE_RCF;
			break;
		default:
			roleName = LicenseCommonConstant.ROLE_DCF;
		}
		return roleName;
	}
}
