package bd.gov.dgfood.food.grain.license.fortnightly.report.formc.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.fortnightly.report.formc.constants.FortnightReportFormCKeys;
import bd.gov.dgfood.food.grain.license.fortnightly.report.formc.constants.FortnightReportFormCPortletKeys;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportCFormLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportCFormLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

/**
 * @author Sajeeb Ahmed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfoodLMSportlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FortnightReportFormC", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/main.jsp",
		"javax.portlet.name=" + FortnightReportFormCPortletKeys.FORTNIGHTREPORTFORMC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class FortnightReportFormCPortlet extends MVCPortlet {
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	licnsUserRegsLocalService _licnsUserRegsLocalService;

	@Reference
	public dgfLocDistrictLocalService _dgfLocDistrictLocalService;

	@Reference
	public dgfLocSubdistrictLocalService _dgfLocSubdistrictLocalService;

	@Reference
	public dgfLocUnionLocalService _dgfLocUnionLocalService;

	@Reference
	public DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;

	@Reference
	public DgfUsersLocalService _dgfUsersLocalService;

	@Reference
	public DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;

	@Reference
	RoleLocalService roleLocalService;
	
	@Reference
	ResourcePermissionLocalService resourcePermissionLocalService;
	
	@Reference
	DgfUsersFortnightReportCFormLocalService dgfUsersFortnightReportCFormLocalService;
	
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void submitFormURL(ActionRequest request, ActionResponse response) throws PortalException, IOException {

		CacheRegistryUtil.clear();
		// Retrieve form data
		Date startDate = ParamUtil.getDate(request, "startDate", new SimpleDateFormat("yyyy-MM-dd"));
		Date endDate = ParamUtil.getDate(request, "endDate", new SimpleDateFormat("yyyy-MM-dd"));
		String UnsoldProductName = ParamUtil.getString(request, "UnsoldProduct");
		Date daterecipt = ParamUtil.getDate(request, "Date-Receipt", new SimpleDateFormat("yyyy-MM-dd"));
		int reciptQuantity = ParamUtil.getInteger(request, "receiveQuantity");
		String receivedunit = GetterUtil.getString(request.getParameter("receivedUnit"));
		Date lastDateApprove = ParamUtil.getDate(request, "lastDateApprove", new SimpleDateFormat("yyyy-MM-dd"));
		int unsoldQuantity = ParamUtil.getInteger(request, "unsoldQuantity");
		String unsolddunit = GetterUtil.getString(request.getParameter("unsoldUnit"));
		String reasonForBeingUnsold = ParamUtil.getString(request, "reasonForBeingUnsold");

		SessionMessages.add(request, "successMessage");

		double reciptQuantityKg = receivedunit.equalsIgnoreCase("MT") ? reciptQuantity * 1000
				: reciptQuantity;
		
		double unsoldQuantityKg = unsolddunit.equalsIgnoreCase("MT") ? unsoldQuantity * 1000
				: unsoldQuantity;
		
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		long userId = permissionChecker.getUserId();

		User currentUser = UserLocalServiceUtil.getUser(userId);
		String screenName = currentUser.getScreenName();
		String fullName = currentUser.getFullName();

		DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
		String nationalId = dgfUsersObj.getNationalId();
		long nid = Long.parseLong(nationalId);
		licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
		String bussinessType = userRegsObj.getBusinessType();
		
		DgfFglLicDtls dgfFglUserLicDtls = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(nationalId);
		String licenseNo = dgfFglUserLicDtls.getFoodgrainLicenseNo();

		// Save data to the database
		try {
			DgfUsersFortnightReportCForm report = DgfUsersFortnightReportCFormLocalServiceUtil
					.createDgfUsersFortnightReportCForm(CounterLocalServiceUtil.increment());

			report.setUserId(userId);
			report.setUsernationalId(nationalId);
			report.setFullName(fullName);
			report.setLicenseNo(licenseNo);
			report.setScreenName(screenName);
			report.setStartDate(startDate);
			report.setEndDate(endDate);
			report.setBussinessType(bussinessType);
			report.setProduct(UnsoldProductName);
			report.setDaterecipt(daterecipt);		
			report.setLastDateApprove(lastDateApprove);			
			report.setReasonForBeingUnsold(reasonForBeingUnsold);
			
			
			if(reciptQuantityKg >= unsoldQuantityKg) {
				
				report.setReceivedQuantity(reciptQuantity);
				report.setReceivedQuantityUnit(receivedunit);
				report.setUnsoldQuantity(unsoldQuantity);
				report.setUnsolddunit(unsolddunit);
				DgfUsersFortnightReportCFormLocalServiceUtil.addDgfUsersFortnightReportCForm(report);

				// Add a success message
				SessionMessages.add(request, "formSubmittedSuccessfully");
				
				//added permission to approver
				addFortnightReportFormCPermission(report, nationalId);
				
				// Redirect to main.jsp
				response.getRenderParameters().setValue("mvcRenderCommandName", "redirectToMain");
			}else {
				request.setAttribute("showAlert", "0");
			}

			
			
		} catch (SystemException e) {
			log.error("DgfUsersFortnightReportCForm Save data to the database Failed: " + e.getMessage());
			SessionErrors.add(request, "errorMessage");
		}
	}
	

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String cmd = ParamUtil.getString(renderRequest, "cmd", "");
		

		// Retrieve the current user
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			User currentUser = themeDisplay.getUser();;
			Date lastLoginDate = currentUser.getLastLoginDate();
			DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(currentUser.getUserId());
			String nationalId = dgfUsersObj.getNationalId();	
			long nid = Long.parseLong(nationalId);
					
			if(cmd.equals("add")) {
				DgfFglPreDtls dgfFglPreDtlsObj = _dgfFglPreDtlsLocalService.getdgfFglPreDtls(nid);
				String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();

				DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService
						.getDgfFglLicDtlsByFglApplicationNo(applicationNo);

				DgfFglLicDtls dgfFglUserLicDtls = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(nationalId);
				
				
				licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(nationalId);

				dgfLocDistrict districtObj = _dgfLocDistrictLocalService
						.getdgfLocDistrict(userRegsObj.getBusinessDistrict());

				dgfLocSubdistrict subDistrictObj = _dgfLocSubdistrictLocalService
						.getdgfLocSubdistrict(userRegsObj.getBusinessUpzilla());		

				dgfLocUnion unionObj = _dgfLocUnionLocalService.getdgfLocUnion(userRegsObj.getBusinessUnionName());
				String districtName = districtObj.getBnName();
				String subDistrictName = subDistrictObj.getBnName();
				String unionName = unionObj.getBnName();
				String licenseNo = dgfFglUserLicDtls.getFoodgrainLicenseNo();
				
				// Set the attributes to the render request
				
				renderRequest.setAttribute("userRegsObj", userRegsObj);
				renderRequest.setAttribute("dgfFglLicDtlsObj", dgfFglLicDtlsObj);
				renderRequest.setAttribute("licenseNo", licenseNo);
				renderRequest.setAttribute("districtName", districtName);
				renderRequest.setAttribute("subDistrictName", subDistrictName);
				renderRequest.setAttribute("unionName", unionName);
				renderRequest.setAttribute("currentUser", currentUser);
				renderRequest.setAttribute("lastLoginDate", lastLoginDate);
				renderRequest.setAttribute(getMVCPathAttributeName(renderResponse.getNamespace()), "/view.jsp");

			} else {
				List<Role> roles = new ArrayList<Role>();
		        roles.addAll(themeDisplay.getUser().getRoles());
		        roles.addAll(getUserExplicitRoles(currentUser));
		        
				Role roleUpazilaUcf = roles.stream().filter(rl -> FortnightReportFormCKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				Role roleDistrictDcf = roles.stream().filter(rl -> FortnightReportFormCKeys.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				
				if(roleUpazilaUcf != null || roleDistrictDcf != null) {

					String licenseType=ParamUtil.getString(renderRequest, "licenseType");
					String dateTo=ParamUtil.getString(renderRequest, "dateTo");
					long union=ParamUtil.getInteger(renderRequest, "union");
					long subdistrict=ParamUtil.getInteger(renderRequest, "subdistrict");

					
					DgfUsersAddrDtls addrDtls = dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(dgfUsersObj.getPresentAddrId());


					if(roleDistrictDcf != null) {
						List<dgfLocSubdistrict> subdistricts =_dgfLocSubdistrictLocalService.getdisWiseSubDis(addrDtls.getDistrict());
						renderRequest.setAttribute("subdistrictList", subdistricts);
						
					}
					
					if(subdistrict > 0 || roleUpazilaUcf != null) {
						List<dgfLocUnion> unionList =_dgfLocUnionLocalService.getsubDisWiseUn(subdistrict > 0 ? subdistrict :addrDtls.getUpzilla());
						renderRequest.setAttribute("unionList", unionList);
					}
					renderRequest.setAttribute("isUcf", roleUpazilaUcf != null);
					renderRequest.setAttribute("isDcf",roleDistrictDcf != null);

					List<Map<String, Object>> reportsList=dgfUsersFortnightReportCFormLocalService.findBySearchCriteria(licenseType, dateTo, subdistrict, union);
							renderRequest.setAttribute("reportsList", reportsList);

					renderRequest.setAttribute("unionId", union);
					renderRequest.setAttribute("subdistrictId", subdistrict);
					renderRequest.setAttribute("licenseType", licenseType);
					renderRequest.setAttribute(getMVCPathAttributeName(renderResponse.getNamespace()), "/fortnight_c_report.jsp");
				}
				else {
					List<DgfUsersFortnightReportCForm> matchingReports = DgfUsersFortnightReportCFormLocalServiceUtil
							.getMatchingReportsByUserNationalId(nationalId);
					renderRequest.setAttribute("matchingReports", matchingReports);
				}
			}

		} catch (Exception e) {
			log.error("DgfUsersFortnightReportCForm- userRegsObj [render method empty ]:  " + e.getMessage());
		}

		super.render(renderRequest, renderResponse);
	}
	
	   @Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
				throws IOException, PortletException, java.io.IOException {
			
			long reportId = ParamUtil.getLong(resourceRequest, "reportId", 0);
			String reportID = Long.toString(reportId);
			byte[] pdfBytes = null;
			pdfBytes = dgfUsersFortnightReportCFormLocalService.getLicenseReport(reportID);
			resourceResponse.setContentType("application/pdf");
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=fortnightReportGa.pdf");
		    OutputStream out = resourceResponse.getPortletOutputStream();
		    out.write(pdfBytes);
		    out.flush();

		}

	private void addFortnightReportFormCPermission(DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm, String nationalId) {
		
		try {
			DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
			DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			long companyId = dgfFglPreDtls.getCompanyId();
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			String roleName = "";
			String primKey = "";
			String businessType = dgfUsersFortnightReportCForm.getBussinessType();
			if(businessType != null) {
				if(FortnightReportFormCKeys.ATTACHAKKI.equals(businessType.toUpperCase()) || FortnightReportFormCKeys.RETAILERS.equals(businessType.toUpperCase())) {
					roleName = FortnightReportFormCKeys.ROLE_UCF;
					primKey = generatePrimKey(dgfUsersFortnightReportCForm.getReportId(), FortnightReportFormCKeys.UPAZILLA_FIRST_LETTER, dgfBussAddrDtls.getBusinessUpzilla());
				} else {
					roleName = FortnightReportFormCKeys.ROLE_DCF;
					primKey = generatePrimKey(dgfUsersFortnightReportCForm.getReportId(), FortnightReportFormCKeys.DISTRICT_FIRST_LETTER, dgfBussAddrDtls.getBusinessDistrict());
				}
	
				Role role = roleLocalService.getRole(companyId, roleName);
				if(role != null) {
					resourcePermissionLocalService.setResourcePermissions(companyId, DgfUsersFortnightReportCForm.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId(), actionsRW);
					ResourcePermission resourcePermission = resourcePermissionLocalService.getResourcePermission(companyId, DgfUsersFortnightReportCForm.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId());
					resourcePermission.setPrimKeyId(dgfUsersFortnightReportCForm.getReportId());
					resourcePermissionLocalService.updateResourcePermission(resourcePermission);
				}
			}
			
		} catch (PortalException e) {
			log.error("added fortnightReportFormCPermission permission error===" + e.getMessage());
		}
		
	}
	
	private String generatePrimKey(long id, String prefix, long location) {
		return 	id+ StringPool.UNDERLINE + prefix+ location;
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
