package bd.gov.dgfood.food.grain.license.application.list.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.application.list.constants.LicenseApplicationKeys;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

@Component(service = LicenseApplicationListPortletService.class)
public class LicenseApplicationListPortletService {

	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;
	@Reference
	licnsUserRegsLocalService _licnsUserRegsLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	@Reference
	RoleLocalService roleLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public List<Map<String, Object>> getActionRequestData(RenderRequest renderRequest) {
		String dateFrom = ParamUtil.getString(renderRequest, "dateFrom", null);
		String dateTo = ParamUtil.getString(renderRequest, "dateTo", null);
		String dateType = ParamUtil.getString(renderRequest, "dateType", null);
		String applicationNo = ParamUtil.getString(renderRequest, "applicationNo", null);
		String businessType = ParamUtil.getString(renderRequest, "businessType", null);
		int status = ParamUtil.getInteger(renderRequest, "status", 1);
		String applicationType = ParamUtil.getString(renderRequest, "appLicType", null);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Map<String, Object>> dgfFglList = new ArrayList<Map<String, Object>>();

		try {
		User user = themeDisplay.getUser();
		DgfUsers dgfUsers = dgfUsersLocalService.getDgfUsers(user.getUserId());
		DgfUsersAddrDtls addrDtls = dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
		List<Role> roles = new ArrayList<Role>();
        roles.addAll(themeDisplay.getUser().getRoles());
        roles.addAll(getUserExplicitRoles(user));
		
		Role roleUpazila = roles.stream().filter(rl -> LicenseApplicationKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
		long roleId = 0;
		String upazillaOrDistrict = "";
		
		if(roleUpazila != null) {
			roleId = roleUpazila.getRoleId();
			upazillaOrDistrict = LicenseApplicationKeys.UPAZILLA_FIRST_LETTER+addrDtls.getUpzilla();
		} else {
			Role roleDistrictAcf = roles.stream().filter(rl -> LicenseApplicationKeys.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			if(roleDistrictAcf != null) {
				roleId = roleDistrictAcf.getRoleId();
				upazillaOrDistrict = LicenseApplicationKeys.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
			} else {
				Role roleDistrictDcf = roles.stream().filter(rl -> LicenseApplicationKeys.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				if(roleDistrictDcf != null) {
					roleId = roleDistrictDcf.getRoleId();
					upazillaOrDistrict = LicenseApplicationKeys.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
				}
			}
		}
		
		dgfFglList = dgfFglPreDtlsLocalService.getSearchResultByDateFrom(dateFrom, dateTo, dateType, 
				applicationNo, businessType, status, applicationType, roleId, upazillaOrDistrict,  user.getCompanyId());
		
		} catch (PortalException e) {
			log.error("not found users ==="+e.getMessage());
		}
		return dgfFglList;
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
