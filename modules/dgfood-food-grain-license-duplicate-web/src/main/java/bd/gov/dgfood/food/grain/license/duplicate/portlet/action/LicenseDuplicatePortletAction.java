package bd.gov.dgfood.food.grain.license.duplicate.portlet.action;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.duplicate.constants.LicenseDuplicatePortletKeys;
import bd.gov.dgfood.food.grain.license.duplicate.portlet.service.LicenseDuplicatePortletService;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;

/**
 * @author Hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-food-grain-license",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LicenseDuplicate", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/food-grain-license-duplicate.jsp",
		"javax.portlet.name=" + LicenseDuplicatePortletKeys.LICENSEDUPLICATE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"}, service = Portlet.class)
public class LicenseDuplicatePortletAction extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	LicenseDuplicatePortletService licenseDuplicatePortletService;
	@Reference
	DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;

	@ProcessAction(name = "addDuplicateLicenseApplication")
	public void addDuplicateLicenseApplication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {
		
		
		try {
			DgfDuplctLicnsReason dgfDuplctLicnsReasonObj = licenseDuplicatePortletService
					.getActionRequestData(actionRequest);
			
			
			if (dgfDuplctLicnsReasonObj != null) {
				actionRequest.setAttribute("applicationNo", dgfDuplctLicnsReasonObj.getApplicationNo());
				MutableRenderParameters mutableRenderParams = actionResponse.getRenderParameters();
				mutableRenderParams.setValue("jspPage", "/food-grain-license-duplicate-submission.jsp");
			} else {			   
				  System.out.println("Error: dgfDuplctLicnsReasonObj is null .Unable to retrieve DgfDuplctLicnsReason data.");
				 log.error("Currently an Application under Review for this License. Wait Till a decission is made .");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		CacheRegistryUtil.clear();

		String cmd = ParamUtil.getString(resourceRequest, "cmd", "");
		String licenseNo = ParamUtil.getString(resourceRequest, "LicenseNo");
		PrintWriter writer = resourceResponse.getWriter();
		DgfFglLicDtls licObj = null;
		String nid = null;
		try {
			long lfrUserId = PortalUtil.getUser(resourceRequest).getUserId();
			DgfUsers dgfUser = dgfUsersLocalService.getDgfUsers(lfrUserId);
			nid = dgfUser.getNationalId();
		} catch (PortalException e) {
			log.error("Dgf User Not Found " + e.getMessage());
		}
		if (cmd.equalsIgnoreCase("checkLicenseNo")) {
			if (licenseNo != null && !licenseNo.isEmpty()) {
				licObj = dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglLicNo(licenseNo);
			}
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isLicenseNo", (licObj.getNationalId().equals(nid)) ? true : false);

			if (licObj != null) {
				Date fglDtlsLicenseExpdate = (licObj.getFoodgrainLicenseExpiryDate() != null)
						? licObj.getFoodgrainLicenseExpiryDate()
						: null;
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String fglDtlsLicenseExpdateStr = (fglDtlsLicenseExpdate!=null)? dateFormat.format(fglDtlsLicenseExpdate):null;
				jsonObject.put("licExpDate", fglDtlsLicenseExpdateStr);
			
				String tradeLic = licObj.getTradeLicenseNo();
				Date tradeLicExpDate = licObj.getTradeLicenseExpiryDate();
				String tradeLicExpDateStr = dateFormat.format(tradeLicExpDate);
				
				jsonObject.put("tradeLic", tradeLic);
				jsonObject.put("tradeLicExpDate", tradeLicExpDateStr);
			}
			writer.write(jsonObject.toString());
		}

		writer.flush();
		super.serveResource(resourceRequest, resourceResponse);

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			DgfUsers dgfUsers = dgfUsersLocalService.getDgfUsers(userId);
			String nid = dgfUsers.getNationalId();
			List<DgfFglLicDtls> dgfFglLicDtlsList = dgfFglLicDtlsLocalService.getDgfFglLicDtlsListByNid(nid);
			renderRequest.setAttribute("dgfFglLicDtlsList", dgfFglLicDtlsList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("User not exist");
		}

		super.render(renderRequest, renderResponse);
	}
}