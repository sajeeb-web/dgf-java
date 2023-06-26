package bd.gov.dgfood.food.grain.license.licensehistory.portlet;

import bd.gov.dgfood.food.grain.license.licensehistory.constants.DgfoodFoodGrainLicensehistoryPortletKeys;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author hp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfoodLMSportlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodFoodGrainLicensehistory",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicensehistoryPortletKeys.DGFOODFOODGRAINLICENSEHISTORY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class DgfoodFoodGrainLicensehistoryPortlet extends MVCPortlet {
	
	
	@Reference
	licnsUserRegsLocalService _licnsUserRegsLocalService;
	@Reference
	public DgfUsersLocalService _dgfUsersLocalService;
	@Reference
	public DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;
	@Reference
	public DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// Retrieve the current user
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		long userId = permissionChecker.getUserId();

		try {
			User currentUser = UserLocalServiceUtil.getUser(userId);
			DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
			String nationalId = dgfUsersObj.getNationalId();
			long nid = Long.parseLong(nationalId);

			
			DgfFglPreDtls dgfFglPreDtlsObj = _dgfFglPreDtlsLocalService.getdgfFglPreDtls(nid);
			String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();

			DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService
					.getDgfFglLicDtlsByNid(nationalId);
			licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(nationalId);

			renderRequest.setAttribute("userRegsObj", userRegsObj);
			renderRequest.setAttribute("dgfFglLicDtlsObj", dgfFglLicDtlsObj);
			renderRequest.setAttribute("currentUser", currentUser);

		} catch (PortalException e1) {
			// Auto-generated catch block
			e1.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}
	
	
	
}