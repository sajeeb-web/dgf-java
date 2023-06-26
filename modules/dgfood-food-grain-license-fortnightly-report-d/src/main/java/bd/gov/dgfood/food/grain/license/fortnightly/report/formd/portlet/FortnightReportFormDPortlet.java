package bd.gov.dgfood.food.grain.license.fortnightly.report.formd.portlet;

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
import com.liferay.portal.kernel.transaction.Transactional;
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

import bd.gov.dgfood.food.grain.license.fortnightly.report.formd.constants.FortnightReportFormDKeys;
import bd.gov.dgfood.food.grain.license.fortnightly.report.formd.constants.FortnightReportFormDPortletKeys;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportDFormLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportDFormLocalServiceUtil;
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
		"javax.portlet.display-name=FortnightReportFormD", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/main.jsp",
		"javax.portlet.name=" + FortnightReportFormDPortletKeys.FORTNIGHTREPORTFORMD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FortnightReportFormDPortlet extends MVCPortlet {

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
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	
	@Reference
	DgfUsersFortnightReportDFormLocalService dgfUsersFortnightReportDFormLocalService;
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void submitFormURL(ActionRequest request, ActionResponse response) throws PortalException {

		CacheRegistryUtil.clear();

		// Retrieve form data
		Date startDate = ParamUtil.getDate(request, "startDate", new SimpleDateFormat("yyyy-MM-dd"));
		Date endDate = ParamUtil.getDate(request, "endDate", new SimpleDateFormat("yyyy-MM-dd"));
		String product = ParamUtil.getString(request, "product");
		int initalStockOn = ParamUtil.getInteger(request, "initalStockOn");
		String initalStockOnUnit = GetterUtil.getString(request.getParameter("initalStockOnUnit"));
		int recivedQuantity = ParamUtil.getInteger(request, "recivedQuantity");
		String recivedQuantityUnit = GetterUtil.getString(request.getParameter("recivedQuantityUnit"));
		int sellingQuantity = ParamUtil.getInteger(request, "sellingQuantity");
		String sellingQuantityUnit = GetterUtil.getString(request.getParameter("sellingQuantityUnit"));
		int quantityOfFinishingStock = ParamUtil.getInteger(request, "quantityOfFinishingStock");
		String quantityOfFinishingStockUnit = GetterUtil
				.getString(request.getParameter("quantityOfFinishingStockUnit"));
		String comment = ParamUtil.getString(request, "comment");

		SessionMessages.add(request, "successMessage");

		// Retrieve the current user
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
		

		// Calculate the quantity of the finishing stock
		double initialStockOnKg = initalStockOnUnit.equalsIgnoreCase("MT") ? initalStockOn * 1000 : initalStockOn;
		double receivedQuantityKg = recivedQuantityUnit.equalsIgnoreCase("MT") ? recivedQuantity * 1000
				: recivedQuantity;
		double sellingQuantityKg = sellingQuantityUnit.equalsIgnoreCase("MT") ? sellingQuantity * 1000
				: sellingQuantity;

		double totalStock = initialStockOnKg + receivedQuantityKg;
		
		
		// Save data to the database
		try {

			DgfUsersFortnightReportDForm report = dgfUsersFortnightReportDFormLocalService
					.createDgfUsersFortnightReportDForm(CounterLocalServiceUtil.increment());

			report.setUserId(userId);
			report.setUsernationalId(nationalId);
			report.setFullName(fullName);
			report.setLicenseNo(licenseNo);
			report.setScreenName(screenName);
			report.setStartDate(startDate);
			report.setEndDate(endDate);
			report.setProduct(product);
			report.setBussinessType(bussinessType);
			report.setInitalStockOn(initalStockOn);
			report.setInitalStockOnUnit(initalStockOnUnit);
			report.setRecivedQuantity(recivedQuantity);
			report.setRecivedQuantityUnit(recivedQuantityUnit);
			report.setSellingQuantity(sellingQuantity);
			report.setSellingQuantityUnit(sellingQuantityUnit);
			report.setQuantityOfFinishingStockUnit("KG");
			report.setComment(comment);
			
			if (totalStock >= sellingQuantityKg) {

				double finishingStockKg = initialStockOnKg + receivedQuantityKg - sellingQuantityKg;

				// Save the calculated finishing stock
				report.setQuantityOfFinishingStock((int) finishingStockKg);

				// update database
				dgfUsersFortnightReportDFormLocalService.addDgfUsersFortnightReportDForm(report);

				// Add a success message
				SessionMessages.add(request, "formSubmittedSuccessfully");

				// added permission to approver
				addFortnightReportFormDPermission(report, nationalId);

				// Redirect to main.jsp
				response.getRenderParameters().setValue("mvcRenderCommandName", "redirectToMain");

			} else {

				request.setAttribute("showAlert", "0");
			}
		
		} catch (SystemException e) {
			log.error("DgfUsersFortnightReportDForm Save data to the database Failed: " + e.getMessage());
			SessionErrors.add(request, "errorMessage");
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException, java.io.IOException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		
		long reportId = ParamUtil.getLong(resourceRequest, "reportId", 0);
		String reportID = Long.toString(reportId);
		System.out.println("String report id is "+reportID);
		byte[] pdfBytes = null;
	    // call API and get pdf as bytes
		//TODO Base url and get param properly
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        String queryParams = "100";
        try {

        }catch (Exception e) {
			// TODO: handle exception
        	log.error(e.getMessage());
		}
		pdfBytes = dgfUsersFortnightReportDFormLocalService.getLicenseReport(reportID);
	    // send the report as a byte stream in the response
		resourceResponse.setContentType("application/pdf");
		resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=fortnightReportGa.pdf");
	    OutputStream out = resourceResponse.getPortletOutputStream();
	    out.write(pdfBytes);
	    out.flush();

	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// Retrieve the current user
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(renderRequest, "cmd", "");
		try {
			User currentUser = themeDisplay.getUser();
			Date lastLoginDate = currentUser.getLastLoginDate();
			DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(currentUser.getUserId());
			String usernationalId = dgfUsersObj.getNationalId();
			String nationalId = currentUser.getScreenName();
			
			if(cmd.equals("add")) {
				DgfFglPreDtls dgfFglPreDtlsObj = _dgfFglPreDtlsLocalService.getdgfFglPreDtls(Long.parseLong(nationalId));
				String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();

				DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService
						.getDgfFglLicDtlsByFglApplicationNo(applicationNo);

				licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(usernationalId);

				DgfFglLicDtls dgfFglUserLicDtls = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(nationalId);
				
				dgfLocDistrict districtObj = _dgfLocDistrictLocalService
						.getdgfLocDistrict(userRegsObj.getBusinessDistrict());

				dgfLocSubdistrict subDistrictObj = _dgfLocSubdistrictLocalService
						.getdgfLocSubdistrict(userRegsObj.getBusinessUpzilla());

				dgfLocUnion unionObj = _dgfLocUnionLocalService.getdgfLocUnion(userRegsObj.getBusinessUnionName());
				String licenseNo = dgfFglUserLicDtls.getFoodgrainLicenseNo();
				String districtName = districtObj.getBnName();
				String subDistrictName = subDistrictObj.getBnName();
				String unionName = unionObj.getBnName();

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
		        
				Role roleUpazilaUcf = roles.stream().filter(rl -> FortnightReportFormDKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				Role roleDistrictDcf = roles.stream().filter(rl -> FortnightReportFormDKeys.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny().orElse(null);
				
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

					List<Map<String, Object>> reportsList=dgfUsersFortnightReportDFormLocalService.findBySearchCriteria(licenseType, dateTo, subdistrict, union);
					renderRequest.setAttribute("reportsList", reportsList);

					renderRequest.setAttribute("unionId", union);
					renderRequest.setAttribute("subdistrictId", subdistrict);
					renderRequest.setAttribute("licenseType", licenseType);
					renderRequest.setAttribute(getMVCPathAttributeName(renderResponse.getNamespace()), "/fortnight_d_report.jsp");
				}
				else {
					List<DgfUsersFortnightReportDForm> matchingReports = DgfUsersFortnightReportDFormLocalServiceUtil
							.getMatchingReportFormDByUserNationalId(nationalId);
					renderRequest.setAttribute("matchingReports", matchingReports);
				}
			}
				
		} catch (PortalException e1) {
			log.error("DgfUsersFortnightReportDForm- userRegsObj [render method empty ]:  " + e1.getMessage());
			
		}

		super.render(renderRequest, renderResponse);
	}
	
	private void addFortnightReportFormDPermission(DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm, String nationalId) {
		try {
			DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
			DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			long companyId = dgfFglPreDtls.getCompanyId();
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			String roleName = "";
			String primKey = "";
			String businessType = dgfUsersFortnightReportDForm.getBussinessType();
			if(businessType != null) {
				if(FortnightReportFormDKeys.ATTACHAKKI.equals(businessType.toUpperCase()) || FortnightReportFormDKeys.RETAILERS.equals(businessType.toUpperCase())) {
					roleName = FortnightReportFormDKeys.ROLE_UCF;
					primKey = generatePrimKey(dgfUsersFortnightReportDForm.getReportId(), FortnightReportFormDKeys.UPAZILLA_FIRST_LETTER, dgfBussAddrDtls.getBusinessUpzilla());
				} else {
					roleName = FortnightReportFormDKeys.ROLE_DCF;
					primKey = generatePrimKey(dgfUsersFortnightReportDForm.getReportId(), FortnightReportFormDKeys.DISTRICT_FIRST_LETTER, dgfBussAddrDtls.getBusinessDistrict());
				}
	
				Role role = roleLocalService.getRole(companyId, roleName);
				if(role != null) {
					resourcePermissionLocalService.setResourcePermissions(companyId, DgfUsersFortnightReportDForm.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId(), actionsRW);
					ResourcePermission resourcePermission = resourcePermissionLocalService.getResourcePermission(companyId, DgfUsersFortnightReportDForm.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId());
					resourcePermission.setPrimKeyId(dgfUsersFortnightReportDForm.getReportId());
					resourcePermissionLocalService.updateResourcePermission(resourcePermission);
				}
			}
			
		} catch (PortalException e) {
			log.error("added fortnightReportFormDPermission permission error===" + e.getMessage());
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