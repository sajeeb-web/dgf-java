package bd.gov.dgfood.food.grain.license.user.creation.portlet;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.user.creation.constants.UserCreationPortletKeys;
import bd.gov.dgfood.food.grain.license.user.creation.service.UserCreationService;

/**
 * @author hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-food-grain-user-creation",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UserCreation", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/user-creation-form.jsp",
		"javax.portlet.name=" + UserCreationPortletKeys.USERCREATION, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class UserCreationPortlet extends MVCPortlet {

	@Reference
	dgfLocDivisionLocalService _dgfLocDivisionLocalService;

	@Reference
	dgfLocDistrictLocalService _dgfLocDistrictLocalService;

	@Reference
	UserCreationService userCreationService;

	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;

	@Reference
	DgfUsersLocalService dgfUsersLocalService;

	@Reference
	UserLocalService userLocalService;

	@Reference
	RoleLocalService roleLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@ProcessAction(name = "addNewUserAction")
	public void addNewUserAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long currentUserId = themeDisplay.getUserId();

		List<Role> userRoleList = roleLocalService.getUserRoles(currentUserId);

		if (userRoleList.size() != 0) {
			for (Role role : userRoleList) {
				if (role.getName().equals(RoleConstants.ADMINISTRATOR)) {
					userCreationService.getGovtUserCreation(actionRequest);
					break;
				} else {
					continue;
				}
			}
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long currentUserId = themeDisplay.getUserId();
		// TODO Auto-generated method stub
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		CacheRegistryUtil.clear();
		String cmd = ParamUtil.getString(resourceRequest, "cmd", "");
		
		String disId = "";
		String districtName = "";
		String subDisId = "";
		String subDistrictName = "";
		String unId = "";
		String unionName = "";
		

		String divIdStr = ParamUtil.getString(resourceRequest, "web_divId");
		long web_divId = Long.parseLong(divIdStr != null && !divIdStr.isEmpty()  ? divIdStr : "0");

		String disIdStr = ParamUtil.getString(resourceRequest, "web_disId");
		long web_disId = Long.parseLong(disIdStr != null && !disIdStr.isEmpty()  ? disIdStr : "0");
		
		String subDisIdStr = ParamUtil.getString(resourceRequest, "web_subDisId");
		long web_subDisId = Long.parseLong(subDisIdStr != null && !subDisIdStr.isEmpty()  ? subDisIdStr : "0");
		
		
		
		String divSelected = ParamUtil.getString(resourceRequest, "divSelected");
		String disSelected = ParamUtil.getString(resourceRequest, "disSelected");
		String subDisSelected = ParamUtil.getString(resourceRequest, "subDisSelected");
		
		String nationalId = ParamUtil.getString(resourceRequest, "nationalId", "");
		String email = ParamUtil.getString(resourceRequest, "email", "");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		
		 if (cmd.equalsIgnoreCase("captchaGenerate")) {
			try {
	            CaptchaUtil.getCaptcha().serveImage(resourceRequest, resourceResponse);
	        }catch(Exception exception) {
	            log.error(exception.getMessage());
	        }
		 } else {
			PrintWriter writer = resourceResponse.getWriter();
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	
			if (divSelected.equalsIgnoreCase("divSelected")) {
				List <dgfLocDistrict> districtList = dgfLocDistrictLocalServiceUtil.getdivWiseDis(web_divId);
				for (dgfLocDistrict item : districtList) {
					if(languageId.equals("en_US") || languageId.equals("en_GB")) {
						districtName = item.getName();
					}
					else if(languageId.equals("bn_BD")) {
						districtName = item.getBnName();
					}
					disId = Long.toString(item.getId());
	
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("disId", disId);
					jsonObject.put("districtName", districtName);
					jsonArray.put(jsonObject);
				}
				writer.write(jsonArray.toString());
			} else if (disSelected.equalsIgnoreCase("disSelected")) {
				List<dgfLocSubdistrict> subDistrictList = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(web_disId);
				for (dgfLocSubdistrict item : subDistrictList) {
					if(languageId.equals("en_US") || languageId.equals("en_GB")) {
						subDistrictName = item.getName();
					}
					else if(languageId.equals("bn_BD")) {
						subDistrictName = item.getBnName();
					}
					subDisId = Long.toString(item.getId());
	
					JSONObject jsonObject2 = JSONFactoryUtil.createJSONObject();
					jsonObject2.put("subDisId", subDisId);
					jsonObject2.put("subDistrictName", subDistrictName);
					jsonArray.put(jsonObject2);
				}
				writer.write(jsonArray.toString());
			} else if (subDisSelected.equalsIgnoreCase("subDisSelected")) {
				List<dgfLocUnion> unionList = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(web_subDisId);
				for (dgfLocUnion item : unionList) {
					if(languageId.equals("en_US") || languageId.equals("en_GB")) {
						unionName = item.getName();
					}
					else if(languageId.equals("bn_BD")) {
						unionName = item.getBnName();
					}
					unId = Long.toString(item.getId());
	
					JSONObject jsonObject3 = JSONFactoryUtil.createJSONObject();
					jsonObject3.put("unId", unId);
					jsonObject3.put("unionName", unionName);
					jsonArray.put(jsonObject3);
				}
				writer.write(jsonArray.toString());
			} else if (cmd.equalsIgnoreCase("checkUserByNid")) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isUser", getUserByNationalId(nationalId) != null ? true : false);
			writer.write(jsonObject.toString());
		} else if (cmd.equalsIgnoreCase("checkUserByEmail")) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isUser", getUserByEmail(email) != null ? true : false);
			writer.write(jsonObject.toString());
		}
	}
	}
	private User getUserByEmail(String email) {
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);
			return user;
		} catch (PortalException e) {
			log.error("not found user by email " + email);
		}
		return null;

	}

	private User getUserByNationalId(String nationalId) {
		try {
			User user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), nationalId);
			return user;
		} catch (PortalException e) {
			log.error("not found user by nid " + nationalId);
		}
		return null;
	}

}