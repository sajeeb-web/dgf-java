package com.dgf.food.custom.login.portlet;

import com.dgf.food.custom.login.constants.CustomLoginPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {
		     "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
		     "mvc.command.name=/login/login",
		     "service.ranking:Integer=100"
		  },
		  service = MVCActionCommand.class
		)

public class CustomLoginActionPortlet extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		themeDisplay.setStateMaximized(true);
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		String login = ParamUtil.getString(actionRequest, "login");
		String password = ParamUtil.getString(actionRequest, "password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authTypeEmail = CompanyConstants.AUTH_TYPE_EA;
		String authTypeScreen = CompanyConstants.AUTH_TYPE_SN;

		String authType = login != null && login.contains("@") ? authTypeEmail : authTypeScreen;
		boolean isLogin = true;
		try {
			AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		} catch (Exception e) {
			isLogin = false;
		}
		
		if (isLogin) {
			User user = null;
			if(authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				 user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), login);
			} else {
				 user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), login);
			}

			List<Role> roles = new ArrayList<Role>();
	        roles.addAll(user.getRoles());
	        roles.addAll(getUserExplicitRoles(user));
			boolean hasRole = false;
			for (Role role : roles) {
				String roleName = role.getName();
				if(CustomLoginPortletKeys.ROLE_UCF.equals(roleName)) {
					hasRole = true;
					actionResponse.sendRedirect("/dashboard-ucf");
					break;
				} else if(CustomLoginPortletKeys.ROLE_ACF.equals(roleName)) {
					hasRole = true;
					actionResponse.sendRedirect("/dashboard-acf");
					break;
				}else if(CustomLoginPortletKeys.ROLE_DCF.equals(roleName)) {
					hasRole = true;
					actionResponse.sendRedirect("/dashboard-dcf");
					break;
				}else if(CustomLoginPortletKeys.ROLE_CCDR.equals(roleName)) {
					hasRole = true;
					actionResponse.sendRedirect("/dashboard-ccdr");
					break;
				}else if(CustomLoginPortletKeys.ROLE_RCF.equals(roleName)) {
					hasRole = true;
					actionResponse.sendRedirect("/dashboard-rcf");
					break;
				}
			}
			
			if(!hasRole && !login.contains("admin@") && !login.contains("test@")) {
				actionResponse.sendRedirect("/fgl-user-dashboard");
			}else if(!hasRole) {
				actionResponse.sendRedirect(themeDisplay.getPathMain());
			}
			
		} else {
			if(authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
				actionResponse.sendRedirect(request.getRequestURL()+"?userType=NormalUser");
				SessionErrors.add(actionRequest, "loginError");
			}else if(authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				actionResponse.sendRedirect(request.getRequestURL()+"?userType=GovernmentUser");
				SessionErrors.add(actionRequest, "loginError");
			} else {
				actionResponse.setWindowState(WindowState.MAXIMIZED);
				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		}
	}
	
	private static List<Role> getUserExplicitRoles(User user) throws SystemException, PortalException {
        List<Role> roles = new ArrayList<Role>();
        List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
        for (UserGroupRole userGroupRole : userGroupRoles) {
            roles.add(userGroupRole.getRole());
        }
        return roles;
    }
	
}