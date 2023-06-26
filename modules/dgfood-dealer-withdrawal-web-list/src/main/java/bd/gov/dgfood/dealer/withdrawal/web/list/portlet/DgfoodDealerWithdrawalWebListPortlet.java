package bd.gov.dgfood.dealer.withdrawal.web.list.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalService;
import bd.gov.dgfood.dealer.withdrawal.web.list.constants.DgfoodDealerWithdrawalWebListPortletKeys;
import bd.gov.dgfood.dealer.withdrawal.web.portlet.service.DgfoodDealerWithdrawalWebListPortletService;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

/**
 * @author Sajeeb Ahmeed
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfood-dealer",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodDealerWithdrawalWebList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/withdrawal-application-list.jsp",
		"javax.portlet.name=" + DgfoodDealerWithdrawalWebListPortletKeys.DGFOODDEALERWITHDRAWALWEBLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodDealerWithdrawalWebListPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

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
	public DgfoodDealerWithdrawalWebListPortletService dgfoodDealerWithdrawalWebListPortletService;

	@Reference
	dgfLocUnionLocalService dgfLocUnionLocalService;
	
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
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			boolean isUcf = false;
			if(PrincipalRoleAndLocationUtil.isUcf()) {
				DgfUsers dgfUsers = DgfUsersLocalServiceUtil.getDgfUsers(themeDisplay.getUserId());
				DgfUsersAddrDtls addrDtls = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtls(dgfUsers.getPresentAddrId());
				List<dgfLocUnion> dgfLocUnion =	dgfLocUnionLocalService.getsubDisWiseUn(addrDtls.getUpzilla());
				renderRequest.setAttribute("unionList", dgfLocUnion);
				isUcf = true;
			}
			renderRequest.setAttribute("isUcf", isUcf);
			renderRequest.setAttribute("dlrWithdrawalApplcList", dgfoodDealerWithdrawalWebListPortletService.getActionRequestData(renderRequest));
		} catch (Exception e) {
			log.error("dlrWithdrawalApplcList error=======");
		}
		super.render(renderRequest, renderResponse);
	}

	/**
	 * This method is responsible for processing the detail view action.
	 *
	 * @param actionRequest  :		 Contains all the request parameters and session
	                        			attributes
	 * @param actionResponse : 		 Responsible for managing action responses including
	                        			setting render parameters                                                                   
		 
     * @language id :			 	 from theme display to support localization
     
     * @dgfDlrWithdrawalid(withdrawalId) : Retrieve the withdrawalId parameter from the action request
     
     * @getWithdrawalDetailView :	 Fetch the details of dealer withdrawal application ( Local service Impl )
	 
	 * @mutableRender parameter:  	 from action response for setting
		 								parameters for the next render phase
	 
	 */
	
	@ProcessAction(name = "detailView")
	public void detailView(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		/** @dgfDlrWithdrawalid */		
        long dlrWithdrawalId =ParamUtil.getLong(actionRequest, "dlrWithdrawalId");
		
        /** @getWithdrawalDetailView */
		Map<String, Object> dealerWithdrawalData = dgfoodDealerWithdrawalWebListPortletService.getWithdrawalDetailView(dlrWithdrawalId);

		// Set the dealer withdrawal details in action request for further use
		actionRequest.setAttribute("dealerWithdrawalData", dealerWithdrawalData);
 
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);

		/** @mutableRender */
		MutableRenderParameters mutableRenderParams = actionResponse.getRenderParameters();

		// Set the jspPage parameter ('withdrawal-application-details.jsp')
		mutableRenderParams.setValue("jspPage", "/withdrawal-application-details.jsp");
	}
}
	
