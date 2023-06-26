package bd.gov.dgfood.food.grain.license.governmentuserportal.portlet;

import bd.gov.dgfood.food.grain.license.governmentuserportal.constants.DgfoodFoodGrainLicenseGovernmentuserportalPortletKeys;

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
		"javax.portlet.display-name=DgfoodFoodGrainLicenseGovernmentuserportal",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicenseGovernmentuserportalPortletKeys.DGFOODFOODGRAINLICENSEGOVERNMENTUSERPORTAL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodFoodGrainLicenseGovernmentuserportalPortlet extends MVCPortlet {
}