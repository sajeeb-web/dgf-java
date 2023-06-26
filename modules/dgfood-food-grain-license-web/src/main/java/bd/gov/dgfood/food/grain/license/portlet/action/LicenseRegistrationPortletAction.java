package bd.gov.dgfood.food.grain.license.portlet.action;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.constants.LicenseRegistrationKeys;
import bd.gov.dgfood.food.grain.license.constants.LicenseRegistrationPortletKeys;
import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.portlet.service.LicenseRegistrationPortletService;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

/**
 * @author HP
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-food-grain-license",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LicenseRegistration", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/food-grain-license-reg.jsp",
		"javax.portlet.name=" + LicenseRegistrationPortletKeys.LICENSEREGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class LicenseRegistrationPortletAction extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	licnsUserRegsLocalService licnsUserRegsLocalService;
	
	@Reference
	LicenseRegistrationPortletService licenseRegistrationPortletService;
	
	@Reference
	public dgfLocDivisionLocalService _dgfLocDivisionLocalService;

	@Reference
	public dgfLocDistrictLocalService _dgfLocDistrictLocalService;
	
	@Reference
	public dgfLocSubdistrictLocalService _dgfLocSubdistrictLocalService;
	
	@Reference
	public dgfLocUnionLocalService _dgfLocUnionLocalService;
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	@Reference
	DgfStoreDtlsLocalService dgfStoreDtlsLocalService;
	
	private void processRegistration(ActionRequest actionRequest, ActionResponse actionResponse) {
		licnsUserRegs userPriData = licenseRegistrationPortletService.getLicenseRegData(actionRequest);
		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		String birthDate = ParamUtil.getString(actionRequest, "birthDate", "");
		try {
			if (!nationalId.isEmpty() && !birthDate.isEmpty()) {
				PortletSession portletSession = actionRequest.getPortletSession(true);
				JSONArray nidobj = (JSONArray) portletSession.getAttribute(LicenseRegistrationKeys.NID_OBJ, 
					                  PortletSession.APPLICATION_SCOPE);
				actionRequest.setAttribute("nidobj", nidobj);
				portletSession.removeAttribute(LicenseRegistrationKeys.NID_OBJ, PortletSession.APPLICATION_SCOPE);
			}
		} catch (Exception e) {
			log.error("processRegistration error ===="+e.getMessage());
		}
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("userPriData", userPriData);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
	}

	private void processRegBasicInfo(ActionRequest actionRequest, ActionResponse actionResponse) {
		licnsUserRegs licnsUserRegsObj = licenseRegistrationPortletService.getLicenseRegBasicData(actionRequest);
		actionRequest.setAttribute("userPriData", licnsUserRegsObj);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
	}
	
	private void processRegTradeLicenseInfo(ActionRequest actionRequest, ActionResponse actionResponse) {
		licenseRegistrationPortletService.getLicenseRegTradeLicData(actionRequest);
		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		licnsUserRegs userPriData;
		try {
			userPriData = licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
			actionRequest.setAttribute("userPriData", userPriData);
		
			Map<String, String> userRegAddrs = licnsUserRegsLocalService.getlicnsUserAddrs(nationalId);
			actionRequest.setAttribute("userRegAddrs", userRegAddrs);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String languageId = themeDisplay.getLanguageId();
			actionRequest.setAttribute("languageId", languageId);
		} catch (PortalException e) {
			log.error("process registration trade license info error==="+e.getMessage());
		}
	}
	
	
	private void processRegLicensePreview(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			licenseRegistrationPortletService.getLicenseRegPreviewData(actionRequest);
		} catch (PortalException e) {
			log.error("process registration license error==="+e.getMessage());
		}
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
		String birthDate = ParamUtil.getString(resourceRequest, "birthDate");
		String mobileNo = ParamUtil.getString(resourceRequest, "mobileNo", "");
		
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
			}else if (cmd.equalsIgnoreCase("checkNidStatus")) {
				PortletSession portletSession = resourceRequest.getPortletSession(true);
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				JSONArray nidobj = (JSONArray) portletSession.getAttribute(LicenseRegistrationKeys.NID_OBJ, 
		                  PortletSession.APPLICATION_SCOPE);
				if(nationalId.length() == 13) {
					nationalId = birthDate.split("-")[0] + nationalId;
				}
				if(nidobj !=null && nidobj.length()>0) {
					JSONObject sessionData = nidobj.getJSONObject(0);
					String nid17Digit = sessionData.getString("nid17Digit", "");
					String nid13Digit = sessionData.getString("nid13Digit", "");
					String nid10Digit = sessionData.getString("nid10Digit", "");
					String dateOfBirth = sessionData.getString("dateOfBirth", "");
					boolean isExistNid = nid17Digit.equals(nationalId) || nid13Digit.equals(nationalId) || nid10Digit.equals(nationalId);
					if(!isExistNid || !dateOfBirth.equals(birthDate)) {
							nidobj = licnsUserRegsLocalService.fetchNidData(nationalId, birthDate);
					}
					
				} else {
					nidobj = licnsUserRegsLocalService.fetchNidData(nationalId, birthDate);
				}
				
				portletSession.setAttribute(LicenseRegistrationKeys.NID_OBJ, nidobj,PortletSession.APPLICATION_SCOPE);
				jsonObject.put("isStatus", nidobj != null && nidobj.length()>0);
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("checkUserByNid")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("isUser", getUserByNationalId(nationalId) != null ? true :false);
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("checkUserByEmail")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("isUser", getUserByEmail(email) != null ? true :false);
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("generateOTP")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					DgfUsersOtpDetails usersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByNidAndMobileAndUser(nationalId, mobileNo, 0L);
					if(usersOtpDetails != null) {
						jsonObject.put("otpId", usersOtpDetails.getOtpId());
						jsonObject.put("isOtpGenerate", true);
					}else {
						jsonObject.put("isOtpGenerate", false);
					}
				
				jsonObject.put("isOtpGenerate", true);
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("matchOTP")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				long otpId = ParamUtil.getLong(resourceRequest, "otpId", 0L);
				long otp = ParamUtil.getLong(resourceRequest, "otp", 0);
				try {
					DgfUsersOtpDetails usersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(otpId, otp, mobileNo);
					if(usersOtpDetails != null) {
						jsonObject.put("isMatch", true);
					}else {
						jsonObject.put("isMatch", false);
					}
				} catch (PortalException e) {
					log.error("Not found OTP by otpId=="+otpId);
				}
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("resendOTP")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					DgfUsersOtpDetails usersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByNidAndMobileAndUser(nationalId, mobileNo, 0);
					if(usersOtpDetails != null) {
						jsonObject.put("otpId", usersOtpDetails.getOtpId());
						jsonObject.put("isOtpGenerate", true);
					}else {
						jsonObject.put("isOtpGenerate", false);
					}
				writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("matchCaptcha")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				String captchaText = ParamUtil.getString(resourceRequest, "captchaText", "");
				
				  PortletSession portletSession = resourceRequest.getPortletSession();
					String key = WebKeys.CAPTCHA_TEXT;
					
					String portletId = PortalUtil.getPortletId(resourceRequest);

					if (Validator.isNotNull(portletId)) {
						key = PortalUtil.getPortletNamespace(portletId) + key;
					}
					String captchaId = (String) portletSession.getAttribute(key);
					jsonObject.put("isMatchCaptcha", captchaText.equals(captchaId));				
					writer.write(jsonObject.toString());
			}else if (cmd.equalsIgnoreCase("deleteStore")) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				long storeId = ParamUtil.getLong(resourceRequest, "storeId", 0);
				System.out.println("storeId==============="+storeId);
				boolean isDeleted = false;
				if(storeId> 0) {
					try {
						dgfStoreDtlsLocalService.deleteDgfStoreDtls(storeId);
						isDeleted = true;
					} catch (PortalException e) {
						log.error("delete store error by====="+storeId+"  :message==="+e.getMessage());
					}
				}
				jsonObject.put("isDeleted", isDeleted);				
				writer.write(jsonObject.toString());
			}
			
			writer.flush();
			writer.close();
		}
		super.serveResource(resourceRequest, resourceResponse); //TODO check side effect later
	}
	
	@ProcessAction(name = "addRegistrationForm")
	public void addRegistrationForm(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
	
		if (pageId == 1) {
			processRegistration(actionRequest, actionResponse);
		} 
		
		CacheRegistryUtil.clear();
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
		
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
	}

	@ProcessAction(name = "addBasicInfoForm")
	public void addBasicInfoForm(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
	
		if (pageId == 2) {
			processRegBasicInfo(actionRequest, actionResponse);
		} 
		
		CacheRegistryUtil.clear();
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
		
		List<DgfStoreDtls> dgfStoreDtls = null ;
		dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
		actionRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
		
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
	}

	@ProcessAction(name = "addTradeLForm")
	public void addTradeLForm(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
	
		if (pageId == 3) {
			processRegTradeLicenseInfo(actionRequest, actionResponse);
		} 
		
		CacheRegistryUtil.clear();
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		List<DgfStoreDtls> dgfStoreDtls = null ;
		dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
				 
		 try {
			 Map<Long, Object> storeAddresses = DgfStoreDtlsLocalServiceUtil.getUserStoreAddrs(nationalId);
	         
	          
			 actionRequest.setAttribute("storeAddresses", storeAddresses);
	
	        } catch (PortalException e) {
	            log.error("cannot get store address");
	        }
		
		
		actionRequest.setAttribute("languageId", languageId);
		actionRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
	}
	
	@ProcessAction(name = "addPreviewInfoForm")
	public void addPreviewInfoForm(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
	
		if (pageId == 4) {
			processRegLicensePreview(actionRequest, actionResponse);
		} 
		
		CacheRegistryUtil.clear();
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		List<DgfStoreDtls> dgfStoreDtls = null ;
		dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
		actionRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
		
		actionRequest.setAttribute("languageId", languageId);
		
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
	}
	
	@ProcessAction(name = "back")
	public void back(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		CacheRegistryUtil.clear();
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
		boolean isBack = ParamUtil.getBoolean(actionRequest, "isBack", false);
		
		if (isBack) {
			try {
				licnsUserRegs userPriData = licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
				List<DgfStoreDtls> dgfStoreDtls = null ;
				dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
				actionRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
				actionRequest.setAttribute("userPriData", userPriData);
			} catch (NoSuchlicnsUserRegsException e) {
				log.error("not found licnsUserRegs====" + e.getMessage());
			}
		}
		//configurable product type
		try {
			Configuration configuration = configurationAdmin.getConfiguration("bd.gov.dgfood.food.grain.license.guideline.portlet.DynamicFieldConfiguration");
			Dictionary<String, Object> dictionary = configuration.getProperties();
			String essentialProductStr = (String) dictionary.get("lmsEssentialProduct");

	        // Split the string into an array
	        String[] essentialProductArr = essentialProductStr.split(",");
	        actionRequest.setAttribute("essentialProductArr", essentialProductArr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			log.error("Product type not found!");
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
		
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
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