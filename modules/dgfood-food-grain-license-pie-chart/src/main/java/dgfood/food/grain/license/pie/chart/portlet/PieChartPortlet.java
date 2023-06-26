package dgfood.food.grain.license.pie.chart.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import dgfood.food.grain.license.pie.chart.constants.PieChartPortletKeys;

/**
 * @author hp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfood-food-grain-license",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PieChart",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PieChartPortletKeys.PIECHART,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PieChartPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long userNotificationArchived = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(userId, true);
		long userNotificationNotArchived = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(userId, false);
		renderRequest.setAttribute("userNotificationArchived", userNotificationArchived);
		renderRequest.setAttribute("userNotificationNotArchived", userNotificationNotArchived);
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
}