package bd.gov.dgfood.dealer.withdrawal.web.portlet;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

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

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalServiceUtil;
import bd.gov.dgfood.dealer.withdrawal.web.constants.DgfoodDealerWithdrawalWebPortletKeys;
import bd.gov.dgfood.dealer.withdrawal.web.portlet.service.DgfoodDealerWithdrawalWebService;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;


/**
 * @author Sajeeb Ahmeed
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfood-dealer-withdrawal-web",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodDealerWithdrawalWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dealer-withdrawal-form-sub.jsp",
		"javax.portlet.name=" + DgfoodDealerWithdrawalWebPortletKeys.DGFOODDEALERWITHDRAWALWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodDealerWithdrawalWebPortlet extends MVCPortlet {

	@Reference
	private DgfDlrWithdrawalLocalService _dgfDlrWithdrawalLocalService;

	@Reference
	public DgfUsersLocalService _dgfUsersLocalService;

	@Reference
	public licnsUserRegsLocalService _licnsUserRegsLocalService;

	@Reference
	public DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;

	@Reference
	public DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;

	@Reference
	public DgfDlrRegDtlsLocalService _dgfDlrRegDtlsLocalService;

	@Reference
	public DgfoodDealerWithdrawalWebService dgfoodDealerWithdrawalWebService;
	
	

	/**
	 * Method to submit a dealer @withdrawal form
	 *
	 * @param actionRequest:  Contains all the form values
	 * @param actionResponse: Responsible for managing responses
	 * @throws IOException:    Handles any IO exceptions
	 * @throws PortalException
	 * @savewithdrawalData : call method on local serviceImpl to save data
	 * @userID use to get the user's details 
	 * @nationalId get from the user's details
	 */

	public void submitWithdrawalForm(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {
		// Get the form values
		String nationalId = ParamUtil.getString(actionRequest, "nationalId");
		String licenseNo = ParamUtil.getString(actionRequest, "licenseNo");
		String dealerName = ParamUtil.getString(actionRequest, "dealerName");
		String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
		String reason = ParamUtil.getString(actionRequest, "reason");
		String programType = ParamUtil.getString(actionRequest, "programType");

		try {

			// Retrieve the ThemeDisplay object from the ActionRequest
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			DgfUsers dgfUsersObj = null;
			 
			 try {
				    dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
				    
				    String loggedInUsernationalId = dgfUsersObj.getNationalId();

					/** Check if the @nationalId of the @logged-in user */
					if (loggedInUsernationalId.equals(nationalId)) {
						
						/** call @saveWithdrawalData */
						DgfDlrWithdrawal dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.saveWithdrawalData(nationalId, licenseNo, dealerName, mobileNo, reason,
								programType);
						// Add a success message
						SessionMessages.add(actionRequest, "formSubmittedSuccessfully");
						// Add workflow
						dgfoodDealerWithdrawalWebService.addWorkflow(actionRequest, dgfDlrWithdrawal, themeDisplay);
					}
				} catch (NoSuchDgfUsersException e) {
				    actionRequest.setAttribute("showAlert", true);
				    e.printStackTrace();
				}
			 

		} catch (SystemException e) {
			// Handle exceptions
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorMessage");
		}
	}

	/**
	 * Overridden serveResource method to process AJAX requests and serve as a data
	 * supplier for the portal.
	 *
	 * @param resourceRequest:  Represents the request sent for a resource
	 * @param resourceResponse: Responsible for managing responses
	 * @throws IOException, PortletException: Handles any IO exceptions and Portlet
	 *                      exceptions
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// Clear the cache
		CacheRegistryUtil.clear();

		// Get the current user's details
		long userId = PermissionThreadLocal.getPermissionChecker().getUserId();
		User currentUser = null;
		try {
			currentUser = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		// Get the last login date of the current user
		@SuppressWarnings("unused")
		Date lastLoginDate = currentUser.getLastLoginDate();

		// Get user details from DgfUsers
		DgfUsers dgfUsersObj = null;
		try {
			dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		// Get dealer registration details based on nationalId
		String nationalId = dgfUsersObj.getNationalId();
		DgfDlrRegDtls dgfDlrRegDtlsObj = _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
		long dlrRegNo = dgfDlrRegDtlsObj.getDlrRegNo();
		
		// Retrieve AJAX command and license number
		String cmd = ParamUtil.getString(resourceRequest, "cmd", "");
		String licenseNo = ParamUtil.getString(resourceRequest, "LicenseNo");

		// Prepare to write the response
		PrintWriter writer = resourceResponse.getWriter();

		if (cmd.equalsIgnoreCase("checkLicenseNo")) {
			// Verify the existence of the license
			DgfDlrRegDtls licObj = null;
			if (licenseNo != null && !licenseNo.isEmpty()) {
				licObj = _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNationalIdAndLicenseNo(nationalId, licenseNo, dlrRegNo);
			}

			// Prepare the JSON response
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isLicenseNo", licObj != null);

			if (licObj != null) {
				String programType = dgfDlrRegDtlsObj.getDlrTypeId();
				String tradeLic = licObj.getFglLicnsNo();

				jsonObject.put("tradeLic", tradeLic);
				jsonObject.put("programType", programType);
			}

			// Write and send the response
			writer.write(jsonObject.toString());
		}

		writer.flush();

		// Call the superclass's serveResource to ensure the correct delivery 
		super.serveResource(resourceRequest, resourceResponse);
	}

	/**
	 * Overridden render method to prepare the data for rendering in the view (JSP).
	 *
	 * @param renderRequest:  Contains all the attributes needed for rendering
	 * @param renderResponse: Responsible for managing responses
	 * @throws IOException, PortletException: Handles any IO exceptions and Portlet
	 *                      exceptions
	 *                      
	 * @alert message if the dealer license is not found                    
	 * @dlrWithdrawalApplcList  Fetch the dealer withdrawal application list                   
	 */
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// Get the current user's details
		long userId = PermissionThreadLocal.getPermissionChecker().getUserId();

		try {
			// Fetch user details
			User currentUser = UserLocalServiceUtil.getUser(userId);
			@SuppressWarnings("unused")
			Date lastLoginDate = currentUser.getLastLoginDate();

			// Fetch dealer's details
			DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
			String nationalId = dgfUsersObj.getNationalId();
			long nid = Long.parseLong(nationalId);

			// Fetch Dgf-pre details
			DgfFglPreDtls dgfFglPreDtlsObj = _dgfFglPreDtlsLocalService.getdgfFglPreDtls(nid);
			String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();
			long nidNo = dgfFglPreDtlsObj.getNationalId();
			String nidNoString = Long.toString(nidNo);

			// Fetch license details
			DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService
					.getDgfFglLicDtlsByFglApplicationNo(applicationNo);

			try {
				licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
				DgfFglLicDtls dgfFglLicDtlsObjNid = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(nidNoString);

				// Check if the dealer registration details exist
				if (_dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId) != null) {
					DgfDlrRegDtls dgfDlrRegDtlsObj = _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
					String dlrProgrameType = dgfDlrRegDtlsObj.getDlrTypeId();
					String dlrFglLicense = dgfDlrRegDtlsObj.getFglLicnsNo();
					String dlrNationId = dgfDlrRegDtlsObj.getNationalId();
					
					renderRequest.setAttribute("dlrProgrameType", dlrProgrameType);	
					renderRequest.setAttribute("dlrFglLicense", dlrFglLicense);
					renderRequest.setAttribute("dlrNationId", dlrNationId);
				} else {
					
					renderRequest.setAttribute("showAlert", "Dealer licence Not found.");
				}

				// Set data to be used in the view (JSP)
				renderRequest.setAttribute("dgfFglLicDtlsObjNid", dgfFglLicDtlsObjNid);
				renderRequest.setAttribute("userRegsObj", userRegsObj);

			} catch (NoSuchlicnsUserRegsException e) {
				// Display an alert message if the user registration details are not found
				renderRequest.setAttribute("showAlert", "Dealer licence Not found.");
			}

			// Set more data to be used in the view (JSP)
			renderRequest.setAttribute("currentUser", currentUser);
			renderRequest.setAttribute("dgfFglLicDtlsObj", dgfFglLicDtlsObj);

		} catch (PortalException e1) {
			// Auto-generated catch block
			e1.printStackTrace();
		}
		super.render(renderRequest, renderResponse);
	}
  
}
	
