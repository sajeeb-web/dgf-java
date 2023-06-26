package bd.gov.dgfood.food.grain.license.guideline.portlet;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Dictionary;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.guideline.constants.DgfoodFoodGrainLicenseGuidescreenPortletKeys;

/**
 * @author hp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfoodLMSportlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodFoodGrainLicenseGuidescreen",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicenseGuidescreenPortletKeys.DGFOODFOODGRAINLICENSEGUIDESCREEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodFoodGrainLicenseGuidescreenPortlet extends MVCPortlet {
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Dictionary<String, Object> dictionary = getDynamicConfigurationValue();
		renderRequest.setAttribute("guideLineText", dictionary.get("guideLineText"));
		renderRequest.setAttribute("guideLineTextDescription", dictionary.get("guideLineTextDescription"));
//		renderRequest.setAttribute("essentialProduct", dictionary.get("lmsEssentialProduct"));
		String essentialProduct = (String) dictionary.get("lmsEssentialProduct");
		
		super.render(renderRequest, renderResponse);
	}
	
	private Dictionary<String, Object> getDynamicConfigurationValue() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration("bd.gov.dgfood.food.grain.license.guideline.portlet.DynamicFieldConfiguration");
			return configuration.getProperties();
		} catch (IOException e) {
			 e.getMessage();
		}
		return null;
	}

}