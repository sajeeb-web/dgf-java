package bd.gov.dgfood.food.grain.license.application.list.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTransition;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.application.list.constants.LicenseApplicationKeys;
import bd.gov.dgfood.food.grain.license.application.list.constants.LicenseApplicationListPortletKeys;
import bd.gov.dgfood.food.grain.license.application.list.portlet.service.LicenseApplicationListPortletService;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglProductDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;

/**
 * @author Hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-food-grain-license",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LicenseApplicationList", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/food-grain-license-application-list.jsp",
		"javax.portlet.name=" + LicenseApplicationListPortletKeys.LICENSEAPPLICATIONLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class LicenseApplicationListPortletAction extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;
	@Reference
	LicenseApplicationListPortletService licenseApplicationListPortletService;
	@Reference
	RoleLocalService roleLocalService;
	@Reference
	ResourcePermissionLocalService resourcePermissionLocalService;
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	@Reference
	DgfBussAddrDtlsLocalService dgfBussAddrDtlsLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	UserNotificationEventLocalService notificationEventLocalService;
	@Reference
	DgfRenewLicenseLocalService dgfRenewLicenseLocalService;
	@Reference
	DgfDuplctLicnsReasonLocalService dgfDuplctLicnsReasonLocalService;
	@Reference
	DgfFglLicDtlsLocalService dgfFglLicDtlsLocalServic;
	@Reference
	DgfFglProductDtlsLocalService dgfFglProductDtlsLocalService;
	@Reference
	public DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;
	@Reference
	public DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest httpOrigReq = PortalUtil.getOriginalServletRequest(httpReq);

		String pageIdStr = httpOrigReq.getParameter("pageId");
		long pageId = 0;
		if (Validator.isNotNull(pageIdStr)) {
			pageId = Long.valueOf(pageIdStr);
		} else {
			pageId = ParamUtil.getLong(renderRequest, "pageId", 0);
		}

		if (Validator.isNotNull(pageId)) {
			try {
				detailView(renderRequest, renderResponse);
				String notificationEventIdStr = httpOrigReq.getParameter("notificationEventId");
				if (Validator.isNotNull(notificationEventIdStr)) {
					readNotification(notificationEventIdStr);
				}
			} catch (PortalException e) {
				log.error("detailview error=====" + e.getMessage());
			}
		} else {
			List<Map<String, Object>> dgfFglList = licenseApplicationListPortletService
					.getActionRequestData(renderRequest);
			/*
			  if (dgfFglList != null && !dgfFglList.isEmpty()) { 
			  for (Map<String, Object> data : dgfFglList) {
			  
			   System.out.println("150 no line : "+ data);
			   } 
		       }
			 */
			renderRequest.setAttribute("fglApplList", dgfFglList);
		}

		super.render(renderRequest, renderResponse);
	}

	private void readNotification(String notificationEventIdStr) {
		long notificationEventId = Long.valueOf(notificationEventIdStr);
		try {
			UserNotificationEvent userNotificationEvent = notificationEventLocalService
					.getUserNotificationEvent(notificationEventId);
			userNotificationEvent.setArchived(true);
			notificationEventLocalService.updateUserNotificationEvent(userNotificationEvent);
		} catch (Exception e) {
			log.error("userNotificationEvent read error===" + e.getMessage());
		}

	}

	public void detailView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortalException, PortletException {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest httpOrigReq = PortalUtil.getOriginalServletRequest(httpReq);

		String pageIdStr = httpOrigReq.getParameter("pageId");
		long pageId = 0;
		if (Validator.isNotNull(pageIdStr)) {
			pageId = Long.valueOf(pageIdStr);
		} else {
			pageId = ParamUtil.getLong(renderRequest, "pageId", 0);
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		DgfUsers dgfUsers = dgfUsersLocalService.getDgfUsers(user.getUserId());
		DgfUsersAddrDtls addrDtls = dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(themeDisplay.getUser().getRoles());
		roles.addAll(getUserExplicitRoles(user));

		String resourceName = "";
		long id = 0;
		long dgfFglPreDtlsId = 0;
		long renewLicenseId = 0;
		long duplicateLicenseReasonId = 0;
		if (pageId == 1) {
			String dgfFglPreDtlsIdStr = httpOrigReq.getParameter("dgfFglPreDtlsId");

			if (Validator.isNotNull(dgfFglPreDtlsIdStr)) {
				dgfFglPreDtlsId = Long.valueOf(dgfFglPreDtlsIdStr);
			} else {
				dgfFglPreDtlsId = ParamUtil.getLong(renderRequest, "dgfFglPreDtlsId", 0);
			}
			id = dgfFglPreDtlsId;
			resourceName = DgfFglPreDtls.class.getName();
		} else if (pageId == 2) {
			String renewLicenseIdStr = httpOrigReq.getParameter("renewLicenseId");

			if (Validator.isNotNull(renewLicenseIdStr)) {
				renewLicenseId = Long.valueOf(renewLicenseIdStr);
				DgfRenewLicense dgfRenewLicense = dgfRenewLicenseLocalService.getDgfRenewLicense(renewLicenseId);
				dgfFglPreDtlsId = dgfRenewLicense.getFglPrePrimaryId();
			} else {
				dgfFglPreDtlsId = ParamUtil.getLong(renderRequest, "dgfFglPreDtlsId", 0);
				renewLicenseId = ParamUtil.getLong(renderRequest, "renewLicenseId", 0);
			}
			id = renewLicenseId;
			resourceName = DgfRenewLicense.class.getName();
			renderRequest.setAttribute("renewLicenseId", renewLicenseId);
		} else if (pageId == 3) {
			String duplicateLicenseReasonIdStr = httpOrigReq.getParameter("duplicateLicenseReasonId");

			if (Validator.isNotNull(duplicateLicenseReasonIdStr)) {
				duplicateLicenseReasonId = Long.valueOf(duplicateLicenseReasonIdStr);
				DgfDuplctLicnsReason dgfDuplctLicnsReason = dgfDuplctLicnsReasonLocalService
						.getDgfDuplctLicnsReason(duplicateLicenseReasonId);
				dgfFglPreDtlsId = dgfDuplctLicnsReason.getFglPrePrimaryId();
			} else {
				dgfFglPreDtlsId = ParamUtil.getLong(renderRequest, "dgfFglPreDtlsId", 0);
				duplicateLicenseReasonId = ParamUtil.getLong(renderRequest, "duplicateLicenseReasonId", 0);
			}
			id = duplicateLicenseReasonId;
			resourceName = DgfDuplctLicnsReason.class.getName();
			renderRequest.setAttribute("duplicateLicenseReasonId", duplicateLicenseReasonId);
		}

		Map<String, Object> detailedDataList = dgfFglPreDtlsLocalService.getDetailsData(dgfFglPreDtlsId, renewLicenseId,
				duplicateLicenseReasonId);
		
		//		store details preview
					DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfFglPreDtlsId);
					String nationalId = Long.toString(dgfFglPreDtls.getNationalId());
					List<DgfStoreDtls> dgfStoreDtls = null ;
					dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nationalId);	
							 
					 try {
						 Map<Long, Object> storeAddresses = DgfStoreDtlsLocalServiceUtil.getUserStoreAddrs(nationalId);
						 renderRequest.setAttribute("storeAddresses", storeAddresses);
				
				        } catch (PortalException e) {
				            log.error("cannot get store address");
				        }
					 renderRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
		
//		product type value pass
		String productTypeStr = (String) detailedDataList.get("productType");
		String[] productTypeStrArr = productTypeStr.split(",");
		List<String> productValList = new ArrayList<>();
		for (String product : productTypeStrArr) {
            	productValList.add(product);
        }

		getWorkFlowTransition(renderRequest, id, resourceName, detailedDataList);

		boolean hasPermissionUpdate = false;
		boolean hasPermissionView = false;
		String primKey = "";
		Role roleUpazilaUcf = roles.stream()
				.filter(rl -> LicenseApplicationKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny()
				.orElse(null);
		boolean isAcf = false;
		if (roleUpazilaUcf != null) {
			primKey = generatePrimKey(id, LicenseApplicationKeys.UPAZILLA_FIRST_LETTER, addrDtls.getUpzilla());
			hasPermissionUpdate = resourcePermissionLocalService.hasResourcePermission(
					PortalUtil.getCompanyId(renderRequest), resourceName, ResourceConstants.SCOPE_INDIVIDUAL, primKey,
					roleUpazilaUcf.getRoleId(), ActionKeys.UPDATE);
			hasPermissionView = resourcePermissionLocalService.hasResourcePermission(PortalUtil.getDefaultCompanyId(),
					resourceName, ResourceConstants.SCOPE_INDIVIDUAL, primKey, roleUpazilaUcf.getRoleId(),
					ActionKeys.VIEW);
		} else {
			Role roleDistrictAcf = roles.stream()
					.filter(rl -> LicenseApplicationKeys.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny()
					.orElse(null);
			if (roleDistrictAcf != null) {
				primKey = generatePrimKey(id, LicenseApplicationKeys.DISTRICT_FIRST_LETTER, addrDtls.getDistrict());
				hasPermissionUpdate = resourcePermissionLocalService.hasResourcePermission(
						PortalUtil.getCompanyId(renderRequest), resourceName, ResourceConstants.SCOPE_INDIVIDUAL,
						primKey, roleDistrictAcf.getRoleId(), ActionKeys.UPDATE);
				hasPermissionView = resourcePermissionLocalService.hasResourcePermission(
						PortalUtil.getDefaultCompanyId(), resourceName, ResourceConstants.SCOPE_INDIVIDUAL, primKey,
						roleDistrictAcf.getRoleId(), ActionKeys.VIEW);
				isAcf = true;
			} else {
				Role roleDistrictDcf = roles.stream()
						.filter(rl -> LicenseApplicationKeys.ROLE_DCF.equals(rl.getName().toUpperCase())).findAny()
						.orElse(null);
				if (roleDistrictDcf != null) {
					primKey = generatePrimKey(id, LicenseApplicationKeys.DISTRICT_FIRST_LETTER, addrDtls.getDistrict());
					hasPermissionUpdate = resourcePermissionLocalService.hasResourcePermission(
							PortalUtil.getCompanyId(renderRequest), resourceName, ResourceConstants.SCOPE_INDIVIDUAL,
							primKey, roleDistrictDcf.getRoleId(), ActionKeys.UPDATE);
					hasPermissionView = resourcePermissionLocalService.hasResourcePermission(
							PortalUtil.getDefaultCompanyId(), resourceName, ResourceConstants.SCOPE_INDIVIDUAL, primKey,
							roleDistrictDcf.getRoleId(), ActionKeys.VIEW);
				}
			}
		}

		renderRequest.setAttribute("isAcf", isAcf);
		renderRequest.setAttribute("dgfFglPreDtlsId", dgfFglPreDtlsId);
		renderRequest.setAttribute("id", id);
		renderRequest.setAttribute("resourceName", resourceName);
		renderRequest.setAttribute("hasPermissionUpdate", hasPermissionUpdate);
		renderRequest.setAttribute("hasPermissionView", hasPermissionView);
		renderRequest.setAttribute("detailedDataList", detailedDataList);
		renderRequest.setAttribute("pageId", pageId);
		renderRequest.setAttribute("productValList", productValList);

		String languageId = themeDisplay.getLanguageId();
		renderRequest.setAttribute("languageId", languageId);

		String path = "";
		if (pageId == 1) {
			path = "/food-grain-license-new-application-details.jsp";
		} else if (pageId == 2) {
			path = "/food-grain-license-renew-application-details.jsp";
		} else if (pageId == 3) {
			path = "/food-grain-license-duplicate-application-details.jsp";
		}

		renderRequest.setAttribute(getMVCPathAttributeName(renderResponse.getNamespace()), path);

	}

	private String generatePrimKey(long id, String prefix, long upzilla) {
		return id + StringPool.UNDERLINE + prefix + upzilla;
	}

	@ProcessAction(name = "approvedLicense")
	public void approvedLicense(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long dgfFglPreDtlsId = ParamUtil.getLong(actionRequest, "dgfFglPreDtlsId", 0);
		long id = ParamUtil.getLong(actionRequest, "id", 0);
		String resourceName = ParamUtil.getString(actionRequest, "resourceName", "");
		DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfFglPreDtlsId);
		String businessType = dgfFglPreDtls.getBusinessType();
		if (businessType != null) {
			User user = themeDisplay.getUser();
			List<Role> roles = new ArrayList<Role>();
			roles.addAll(themeDisplay.getUser().getRoles());
			roles.addAll(LicenseApplicationListPortletService.getUserExplicitRoles(user));
			
			boolean isAcf = false;
			Role roleUpazilaUcf = roles.stream()
					.filter(rl -> LicenseApplicationKeys.ROLE_UCF.equals(rl.getName().toUpperCase())).findAny()
					.orElse(null);
			if (roleUpazilaUcf == null) {
				Role roleAcf = roles.stream()
						.filter(rl -> LicenseApplicationKeys.ROLE_ACF.equals(rl.getName().toUpperCase())).findAny()
						.orElse(null);
				if (roleAcf != null) {
					isAcf = true;
					String transitionLabel = ParamUtil.getString(actionRequest, "transitionLabel", "");
					if (!transitionLabel.toUpperCase().contains("REJECT")) {
						updateAcfPermssion(dgfFglPreDtls, id, resourceName);
						addNewLicensePermission(dgfFglPreDtls, id, resourceName);
					}
				}
			}
			completeWorkFlow(actionRequest, themeDisplay);
			if(!isAcf) {
				updateLicenseDetails(actionRequest, dgfFglPreDtlsId);
			}
		}
	}

	private void updateLicenseDetails(ActionRequest actionRequest, long dgfFglPreDtlsId) {
		
		DgfFglLicDtls dgfFglLicDtls = dgfFglLicDtlsLocalServic.getDgfFglLicDtlsByFglPrePrimaryId(dgfFglPreDtlsId);
//		product type value pass
		String productTypeStr = dgfFglLicDtls.getProductType();
		String[] productTypeStrArr = productTypeStr.split(",");
		List<String> productValList = new ArrayList<>();
		for (String product : productTypeStrArr) {
        	productValList.add(product);
        	String productName = LicenseApplicationKeys.PRODUCT_TYPE + product;
        	String stockDurationName = LicenseApplicationKeys.STOCK_DURATION + product;
        	String StockAmountName = LicenseApplicationKeys.STOCK_AMOUNT + product;
        	String productType = ParamUtil.getString(actionRequest, productName);
        	long stockDuration = ParamUtil.getLong(actionRequest, stockDurationName);
    		long stockAmount = ParamUtil.getLong(actionRequest, StockAmountName);
    		List<DgfFglProductDtls> dgfFglProductDtls = dgfFglProductDtlsLocalService.getDgfFglProductDtlsByFglLicPrimaryId(dgfFglLicDtls.getFglLicPrimaryId());
    		for(DgfFglProductDtls dgfFglObject: dgfFglProductDtls) {
        		if (Validator.isNotNull(dgfFglObject)) {
        			if(dgfFglObject.getProductType().equals(product)) {
        				if (Validator.isNotNull(stockDuration)) {
        					dgfFglObject.setStockDuration(stockDuration);
        				}
        				if (Validator.isNotNull(stockAmount)) {
        					dgfFglObject.setStockAmount(stockAmount);
        				}
        				dgfFglProductDtlsLocalService.updateDgfFglProductDtls(dgfFglObject);
        			}
        		}
    		}
		}
		
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
	
		String cmd = ParamUtil.getString(request, "cmd", "");
		
		if(cmd.equals("fglLicpdf")) {
			
			long dgfFglPreDtlsId = ParamUtil.getLong(request, "dgfFglPreDtlsId", 0);
			byte[] pdfBytes = null;
		    // call API and get pdf as bytes
	        String queryParams = "100";
	        try {	
	        	
	        	DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglPrePrimaryId(dgfFglPreDtlsId);
	        	queryParams = dgfFglLicDtlsObj.getFoodgrainLicenseNo();
	        	
	        }catch (Exception e) {
				// TODO: handle exception
	        	log.error(e.getMessage());
			}
			pdfBytes = _dgfFglPreDtlsLocalService.getLicenseReport(queryParams);
		    // send the report as a byte stream in the response
			response.setContentType("application/pdf");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=license-report.pdf");
		    OutputStream out = response.getPortletOutputStream();
		    out.write(pdfBytes);
		    out.flush();
		}
		else {
			// Get the list of data
			List<Map<String, Object>> fglApplList = (List<Map<String, Object>>) request.getPortletSession()
					.getAttribute("fglApplList", PortletSession.APPLICATION_SCOPE);

			List<Map<String, Object>> excelList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> item : fglApplList) {
				
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("Application Number", (item.get("fglApplicationNo") != null) ? item.get("fglApplicationNo") : "");
				map.put("Name of the Applicant", (item.get("applicantName") != null) ? item.get("applicantName") : "");
				map.put("Food Grain License No.", (item.get("fglLicenseNo") != null) ? item.get("fglLicenseNo") : "");
				map.put("Applicatint Nation Id : ", (item.get("nationalId") != null) ? item.get("nationalId") : "");
				map.put("License App. Type",
						(item.get("fglLicneseApplicationType") != null) ? item.get("fglLicneseApplicationType") : "");
				map.put("Food Grain License Expiry Date",
						(item.get("fglLicenseExpiryDate") != null) ? item.get("fglLicenseExpiryDate") : "");
				map.put("Business Type", (item.get("businessType") != null) ? item.get("businessType") : "");
				int status = (Integer) item.get("status");
				if (status == 0) {
					map.put("Status", "Reviewed");
				} else if (status == 1) {
					map.put("Status", "Pending");

				} else if (status == 4) {
					map.put("Status", "Rejected");

				} else if (status == 6) {
					map.put("Status", "Incomplete");

				} else {
					map.put("Status", "");

				}
				excelList.add(map);
				
			}

			// Create a new workbook
			Workbook workbook = new XSSFWorkbook();

			// Create a new sheet
			Sheet sheet = workbook.createSheet("Food Grain License Application List");

			// Create header row
			Row headerRow = sheet.createRow(0);
			int columnCount = 0;
			for (String key : excelList.get(0).keySet()) {
				Cell cell = headerRow.createCell(columnCount++);
				cell.setCellValue(key);
			}

			// Populate data rows
			int rowCount = 1;
			for (Map<String, Object> row : excelList) {
				Row dataRow = sheet.createRow(rowCount++);
				columnCount = 0;
				for (Object value : row.values()) {
					Cell cell = dataRow.createCell(columnCount++);
					if (value != null) {
						cell.setCellValue(value.toString());
					} else {
						cell.setCellValue("");
					}
				}
			}

			// Set the response headers
			response.setContentType("application/vnd.ms-excel");
			response.setProperty("Content-Disposition", "attachment; filename=Food Grain License Application List.xlsx");

			// Write the workbook to the response stream
			OutputStream outputStream = response.getPortletOutputStream();
			workbook.write(outputStream);

			outputStream.flush();
			outputStream.close();
		}

		
	}


	private void addNewLicensePermission(DgfFglPreDtls dgfFglPreDtls, long id, String resourceName) {
		try {
			DgfBussAddrDtls dgfBussAddrDtls = dgfBussAddrDtlsLocalService
					.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };

			Role roleDcf = roleLocalService.getRole(dgfFglPreDtls.getCompanyId(), LicenseApplicationKeys.ROLE_DCF);
			if (roleDcf != null) {
				resourcePermissionLocalService
						.setResourcePermissions(dgfFglPreDtls.getCompanyId(), resourceName,
								ResourceConstants.SCOPE_INDIVIDUAL,
								Long.toString(id) + StringPool.UNDERLINE + LicenseApplicationKeys.DISTRICT_FIRST_LETTER
										+ Long.toString(dgfBussAddrDtls.getBusinessDistrict()),
								roleDcf.getRoleId(), actionsRW);
			}
		} catch (PortalException e) {
			log.error("added permission to dcf===" + e.getMessage());
		}
	}

	private void updateAcfPermssion(DgfFglPreDtls dgfFglPreDtls, long id, String resourceName) {
		try {
			Role roleDistrictAcf = roleLocalService.getRole(dgfFglPreDtls.getCompanyId(),
					LicenseApplicationKeys.ROLE_ACF);
			if (roleDistrictAcf != null) {
				DgfBussAddrDtls dgfBussAddrDtls = dgfBussAddrDtlsLocalService
						.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
				String primKey = id + StringPool.UNDERLINE + LicenseApplicationKeys.DISTRICT_FIRST_LETTER
						+ dgfBussAddrDtls.getBusinessDistrict();
				resourcePermissionLocalService.removeResourcePermission(dgfFglPreDtls.getCompanyId(), resourceName,
						ResourceConstants.SCOPE_INDIVIDUAL, primKey, roleDistrictAcf.getRoleId(), ActionKeys.UPDATE);
			}
		} catch (PortalException e) {
			log.error("remove approved permission from acf===" + e.getMessage());
		}

	}

	private void completeWorkFlow(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		long companyId = ParamUtil.getLong(actionRequest, "companyId", 0);
		long workflowInstanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId", 0);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId", 0);
		String transitionName = ParamUtil.getString(actionRequest, "transitionName", "");
		String comments = ParamUtil.getString(actionRequest, "comments", "");
		try {
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceId);
			WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, themeDisplay.getUserId(), workflowTaskId,
					themeDisplay.getUserId(), comments, null, instance.getWorkflowContext());
			WorkflowTask workflowTask = WorkflowTaskManagerUtil.completeWorkflowTask(companyId,
					themeDisplay.getUserId(), workflowTaskId, transitionName, comments, instance.getWorkflowContext());
			log.info("workflowTask=============" + workflowTask);
		} catch (PortalException e) {
			log.error("completeTask error================" + e.getMessage());
		}
	}

	private void getWorkFlowTransition(RenderRequest renderRequest, long id, String resourceName,
			Map<String, Object> detailedDataList) {
		WorkflowInstanceLink instanceLink;
		try {
			long companyId = (long) detailedDataList.get("companyId");
			renderRequest.setAttribute("companyId", companyId);
			long groupId = (long) detailedDataList.get("groupId");
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, groupId,
					resourceName, id);
			renderRequest.setAttribute("workflowInstanceId", instanceLink.getWorkflowInstanceId());
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
					instanceLink.getWorkflowInstanceId());
			List<Integer> assignLogTypes = new ArrayList<>();
			assignLogTypes.add(WorkflowLog.TASK_ASSIGN);

			List<WorkflowLog> wfAssignLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId,
					instance.getWorkflowInstanceId(), assignLogTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

			if (wfAssignLogs != null && wfAssignLogs.size() > 0) {
				long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
				renderRequest.setAttribute("workflowTaskId", wfTaskId);
				List<WorkflowTransition> tasks = WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(wfTaskId);
				renderRequest.setAttribute("tasks", tasks);
			}
		} catch (PortalException e) {
			log.error("completeTask error================" + e.getMessage());
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