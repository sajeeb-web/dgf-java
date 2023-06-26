package bd.gov.dgfood.dealer.registration.util;

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

import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;

public class PrincipalRoleAndLocationUtil {
	private static Log _log = LogFactoryUtil.getLog(PrincipalRoleAndLocationUtil.class);
	public static long principalRole() {
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
			List<Role> roles = new ArrayList<Role>();
	        roles.addAll(user.getRoles());
	        roles.addAll(getUserExplicitRoles(user));
			
			Role roleUpazila = roles.stream().filter(rl -> DealerCommonConstant.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			long roleId = 0;
			if(roleUpazila != null) {
				roleId = roleUpazila.getRoleId();
			} else {
				Role roleDistrictAcf = roles.stream().filter(rl -> DealerCommonConstant.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				if(roleDistrictAcf != null) {
					roleId = roleDistrictAcf.getRoleId();
				} else {
					Role roleDistrictDcf = roles.stream().filter(rl -> DealerCommonConstant.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
					if(roleDistrictDcf != null) {
						roleId = roleDistrictDcf.getRoleId();
					}
				}
			}
			return roleId;
		} catch (PortalException e) {
			_log.error("not found users ==="+e.getMessage());
		}
		return 0;
	}
	
	public static String principalUserLocation() {
		
		try {
			User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
		DgfUsers dgfUsers = DgfUsersLocalServiceUtil.getDgfUsers(user.getUserId());
		DgfUsersAddrDtls addrDtls = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(user.getRoles());
        roles.addAll(getUserExplicitRoles(user));
		
		Role roleUpazila = roles.stream().filter(rl -> DealerCommonConstant.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		String upazillaOrDistrict = "";
		
		if(roleUpazila != null) {
			upazillaOrDistrict = DealerCommonConstant.UPAZILLA_FIRST_LETTER+addrDtls.getUpzilla();
		} else {
			Role roleDistrictAcf = roles.stream().filter(rl -> DealerCommonConstant.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			if(roleDistrictAcf != null) {
				upazillaOrDistrict = DealerCommonConstant.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
			} else {
				Role roleDistrictDcf = roles.stream().filter(rl -> DealerCommonConstant.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				if(roleDistrictDcf != null) {
					upazillaOrDistrict = DealerCommonConstant.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
				}
			}
		}
		return upazillaOrDistrict;
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
	
	public static List<Role> getUserExplicitRoles(User user) throws SystemException, PortalException {
        List<Role> roles = new ArrayList<Role>();
        List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
        for (UserGroupRole userGroupRole : userGroupRoles) {
            roles.add(userGroupRole.getRole());
        }
        return roles;
    }


}
