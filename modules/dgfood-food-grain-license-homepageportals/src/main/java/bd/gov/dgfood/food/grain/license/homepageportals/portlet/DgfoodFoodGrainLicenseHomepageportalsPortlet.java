package bd.gov.dgfood.food.grain.license.homepageportals.portlet;

import bd.gov.dgfood.food.grain.license.homepageportals.constants.DgfoodFoodGrainLicenseHomepageportalsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author hp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfoodLMSportlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodFoodGrainLicenseHomepageportals",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicenseHomepageportalsPortletKeys.DGFOODFOODGRAINLICENSEHOMEPAGEPORTALS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodFoodGrainLicenseHomepageportalsPortlet extends MVCPortlet {
}