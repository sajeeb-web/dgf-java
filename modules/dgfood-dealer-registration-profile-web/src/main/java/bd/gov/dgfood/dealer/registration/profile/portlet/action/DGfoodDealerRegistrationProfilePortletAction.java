package bd.gov.dgfood.dealer.registration.profile.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.profile.constants.DGfoodDealerRegistrationProfilePortletKeys;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;

/**
 * @author Hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-dealer-registration",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DGfoodDealerRegistrationProfile", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dealer-profile.jsp",
		"javax.portlet.name=" + DGfoodDealerRegistrationProfilePortletKeys.DGFOODDEALERREGISTRATIONPROFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DGfoodDealerRegistrationProfilePortletAction extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService;

	public void render(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		Map<String, Object> dealerDetailData = dgfDlrRegDtlsLocalService.getDealerProfileData();
		
		if (dealerDetailData == null || dealerDetailData.isEmpty()) {
			renderRequest.setAttribute("showAlert", "modalMessage");	
		} else {
			renderRequest.setAttribute("dealerDetailData", dealerDetailData);
			renderRequest.setAttribute("languageId", languageId);	
		}
		try {
			super.render(renderRequest, renderResponse);
		} catch (IOException e) {

		} catch (PortletException e) {

		}
	}

	@ProcessAction(name = "profileEdit")
	public void profileEdit(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		Map<String, Object> dealerDetailData = dgfDlrRegDtlsLocalService.getDealerProfileData();
		actionRequest.setAttribute("dealerDetailData", dealerDetailData);
		actionRequest.setAttribute("languageId", languageId);
	}

}
