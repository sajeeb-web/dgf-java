package bd.gov.dgfood.food.grain.license.user.creation.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalService;
//import static javax.swing.JOptionPane.showMessageDialog;

@Component(service = UserCreationService.class)
public class UserCreationService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference 
	CounterLocalService counterLocalService;
	
	@Reference 
	UserLocalService userLocalService;
	
	@Reference 
	UserGroupRoleLocalService userGroupRoleLocalService;
	
	@Reference
	RoleLocalService roleLocalService;
	
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	
	@Reference
	dgfLocDivisionLocalService _dgfLocDivisionLocalService;
	
	@Reference
	dgfLocDistrictLocalService _dgfLocDistrictLocalService;
	
	public void getGovtUserCreation(ActionRequest actionRequest) {
//		Get data from form 
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String nationalId = ParamUtil.getString(actionRequest, "nationalId");
		String email = ParamUtil.getString(actionRequest, "email");
		String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
		String password = ParamUtil.getString(actionRequest, "password");
		String userRole = ParamUtil.getString(actionRequest, "userRole");
		long division = ParamUtil.getLong(actionRequest, "division");
		long district = ParamUtil.getLong(actionRequest, "district");
		long upzilla = ParamUtil.getLong(actionRequest, "upzilla");
		long unionName = ParamUtil.getLong(actionRequest, "unionName");
		long userRoleId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String,Object> govtUserDetails = new HashMap<String, Object>();
		govtUserDetails.put("firstName", firstName);
		govtUserDetails.put("lastName", lastName);
		govtUserDetails.put("nationalId", nationalId);
		govtUserDetails.put("email", email);
		govtUserDetails.put("mobileNo", mobileNo);
		govtUserDetails.put("password", password);
		
		try {
			Role roleObj = roleLocalService.getRole(themeDisplay.getCompanyId(), userRole);
			userRoleId = roleObj.getRoleId();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		govtUserDetails.put("userRoleId", userRoleId);
		govtUserDetails.put("division", division);
		govtUserDetails.put("district", district);
		govtUserDetails.put("upzilla", upzilla);
		govtUserDetails.put("unionName", unionName);
		if(userRoleId > 0) {
			User user = createUser(actionRequest, govtUserDetails,themeDisplay);
			DgfUsersAddrDtls dgfUsersAddrDtls = saveDgfUsersAddrDtls(govtUserDetails);
			saveDgfUsers(user,govtUserDetails,dgfUsersAddrDtls);
		}
	}
	
private User createUser(ActionRequest actionRequest, Map<String, Object>  govtUserDetails, ThemeDisplay themeDisplay) {
		
		int dayOfMonth = 1;
		int monthOfYear = 0;
		int year = 1970;

		User user = null;
		try {
			user = userLocalService.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), false,
							(String)govtUserDetails.get("password"), (String)govtUserDetails.get("password"), 
					false, (String)govtUserDetails.get("nationalId"), (String)govtUserDetails.get("email"),
					themeDisplay.getLocale(), (String)govtUserDetails.get("firstName"), "", 
					(String)govtUserDetails.get("lastName"), 0L, 0L, false, monthOfYear, dayOfMonth, year, "", 1, new long[0], new long[0], new long[0], new long[0], false, new ServiceContext());
			user.setPasswordReset(false);
			user.setStatus(WorkflowConstants.STATUS_APPROVED);
			// assign user role
			assignRole(user, themeDisplay,govtUserDetails);
			// assign user group role
			assignUserGroupRole(user,themeDisplay,govtUserDetails);
			UserLocalServiceUtil.updateUser(user);
		} catch (PortalException e) {
			log.error("not created user by===="+e.getMessage());
		}
		
		return user;
	}
	private void assignRole(User user, ThemeDisplay themeDisplay, Map<String, Object> govtUserDetails) {
		try {
			roleLocalService.addUserRole(user.getUserId(), (long)govtUserDetails.get("userRoleId"));
		} catch (PortalException e) {
			log.error("assign roll error===");
			e.printStackTrace();
		}
	}
	private void assignUserGroupRole(User user, ThemeDisplay themeDisplay, Map<String, Object> govtUserDetails) {
		userGroupRoleLocalService.addUserGroupRole(user.getUserId(), themeDisplay.getScopeGroupId(), (long)govtUserDetails.get("userRoleId"));
	}
	public DgfUsersAddrDtls saveDgfUsersAddrDtls(Map<String, Object>  govtUserDetails) {
		DgfUsersAddrDtls dgfUsersAddrDtlsObj = dgfUsersAddrDtlsLocalService
                .createDgfUsersAddrDtls(CounterLocalServiceUtil.increment());

		long nid = 0L;
		String nidStr = (String) govtUserDetails.get("nationalId");
		if(nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfUsersAddrDtlsObj.setNationalId(nid);
		dgfUsersAddrDtlsObj.setDivision((long) govtUserDetails.get("division"));
		dgfUsersAddrDtlsObj.setDistrict((long) govtUserDetails.get("district"));
		dgfUsersAddrDtlsObj.setUpzilla((long) govtUserDetails.get("upzilla"));
		dgfUsersAddrDtlsObj.setUnionName((long) govtUserDetails.get("unionName"));
		
		dgfUsersAddrDtlsLocalService.addDgfUsersAddrDtls(dgfUsersAddrDtlsObj);
		return dgfUsersAddrDtlsObj;
	}
	public DgfUsers saveDgfUsers(User user, Map<String, Object>  govtUserDetails, DgfUsersAddrDtls dgfUsersAddrDtls) {
		
		DgfUsers dgfUsersObj = dgfUsersLocalService
                .createDgfUsers(CounterLocalServiceUtil.increment());
		
		dgfUsersObj.setUserId(user.getUserId());
		
		dgfUsersObj.setPresentAddrId(dgfUsersAddrDtls.getAddressId());
		
		dgfUsersObj.setNationalId((String) govtUserDetails.get("nationalId"));
		dgfUsersObj.setApplicantName((String) govtUserDetails.get("firstName"));
		dgfUsersObj.setPassword((String) govtUserDetails.get("password"));
		dgfUsersObj.setLastName((String) govtUserDetails.get("lastName"));		
		dgfUsersObj.setMobileNo((String) govtUserDetails.get("mobileNo"));			
		dgfUsersLocalService.addDgfUsers(dgfUsersObj);
		return dgfUsersObj;
	}
	
}
