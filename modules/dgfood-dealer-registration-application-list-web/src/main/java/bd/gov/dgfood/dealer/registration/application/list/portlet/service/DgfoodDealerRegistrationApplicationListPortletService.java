package bd.gov.dgfood.dealer.registration.application.list.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.application.list.constants.DGfoodDealerRegistrationApplicationListKeys;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;


@Component(service = DgfoodDealerRegistrationApplicationListPortletService.class)

public class DgfoodDealerRegistrationApplicationListPortletService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference 
	DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	
	public List<Map<String, Object>> getActionRequestData(RenderRequest renderRequest) {
		String dateFrom = ParamUtil.getString(renderRequest, "dateFrom", null);
		String dateTo = ParamUtil.getString(renderRequest, "dateTo", null);
		String dateType = ParamUtil.getString(renderRequest, "dateType", null);
		String nid = ParamUtil.getString(renderRequest, "nid", null);
		long union = ParamUtil.get(renderRequest, "union", -2);
		String dealerType = ParamUtil.getString(renderRequest, "dealerType", null);
		int status = ParamUtil.getInteger(renderRequest, "appStatus", 1);
		List<Map<String, Object>> dlrApplcList = new ArrayList<Map<String, Object>>();

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			DgfUsers dgfUsers = dgfUsersLocalService.getDgfUsers(user.getUserId());
			DgfUsersAddrDtls addrDtls = dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
			List<Role> roles = new ArrayList<Role>();
			roles.addAll(themeDisplay.getUser().getRoles());
			roles.addAll(getUserExplicitRoles(user));
			
			Role roleUpazila = roles.stream().filter(rl -> DGfoodDealerRegistrationApplicationListKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDistrict = roles.stream().filter(rl -> DGfoodDealerRegistrationApplicationListKeys.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleDM = roles.stream().filter(rl -> DGfoodDealerRegistrationApplicationListKeys.ROLE_CCDR.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			Role roleOM = roles.stream().filter(rl -> DGfoodDealerRegistrationApplicationListKeys.ROLE_RCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
			long roleId = 0;
			String upazillaOrDistrict = "";
			
			if(roleUpazila != null) {
				roleId = roleUpazila.getRoleId();
				upazillaOrDistrict = DGfoodDealerRegistrationApplicationListKeys.UPAZILLA_FIRST_LETTER+addrDtls.getUpzilla();
			}else if(roleDistrict !=null) {
				roleId = roleDistrict.getRoleId();
				upazillaOrDistrict = DGfoodDealerRegistrationApplicationListKeys.DISTRICT_FIRST_LETTER+addrDtls.getDistrict();
			}else if(roleDM !=null) {
				roleId = roleDM.getRoleId();
				upazillaOrDistrict = DGfoodDealerRegistrationApplicationListKeys.DHAKA_METRO_FIRST_TWO_LETTER;
			}else if(roleOM !=null) {
				roleId = roleOM.getRoleId();
				upazillaOrDistrict = DGfoodDealerRegistrationApplicationListKeys.OTHER_METRO_FIRST_TWO_LETTER+addrDtls.getUpzilla();
			}
			
	        dlrApplcList = dgfDlrRegDtlsLocalService.getDlrListSearchResult(dateFrom, dateTo, dateType, nid, union, dealerType, status, roleId, upazillaOrDistrict, user.getCompanyId());

		} catch (PortalException e) {
			log.error("not found users ==="+e.getMessage());
		}
		return dlrApplcList;
	}
	
	public Map<String, Object> getDealerDetailView (String dgfDlrRegDltsNid) {
		Map <String, Object> dealerData = new HashMap<String, Object>();
		return dealerData = dgfDlrRegDtlsLocalService.getDealerData(dgfDlrRegDltsNid);
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
