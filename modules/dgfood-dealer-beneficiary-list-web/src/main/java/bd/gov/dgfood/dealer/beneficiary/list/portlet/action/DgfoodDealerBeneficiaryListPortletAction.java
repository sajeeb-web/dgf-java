package bd.gov.dgfood.dealer.beneficiary.list.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.beneficiary.list.constants.DgfoodDealerBeneficiaryListPortletKeys;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;
import bd.gov.dgfood.food.grain.license.service.VerifiedBeneficiariesLocalService;

/**
 * @author Hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-dealer-beneficiary",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodDealerBeneficiaryList", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dealer-beneficiary-list.jsp",
		"javax.portlet.name=" + DgfoodDealerBeneficiaryListPortletKeys.DGFOODDEALERBENEFICIARYLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DgfoodDealerBeneficiaryListPortletAction extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	VerifiedBeneficiariesLocalService _verifiedBeneficiariesLocalService;

	List<VerifiedBeneficiaries> dealerLinkedBeneficiaryList = new ArrayList<VerifiedBeneficiaries>();

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		String nid = ParamUtil.getString(renderRequest, "nid", "");
		long ffpCardNo = ParamUtil.getLong(renderRequest, "ffpCardNo", -2);
		dealerLinkedBeneficiaryList = _verifiedBeneficiariesLocalService
				.getSearchedDealerLinkedVerifiedBeneficiaries(nid, ffpCardNo);
		renderRequest.setAttribute("dealerLinkedBeneficiaryList", dealerLinkedBeneficiaryList);
		renderRequest.setAttribute("languageId", languageId);
		super.render(renderRequest, renderResponse);

	}
}