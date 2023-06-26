package bd.gov.dgfood.food.grain.license.fgl.user.license.view.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.food.grain.license.fgl.user.license.view.constants.DgfoodFoodGrainLicenseFGLUserLicenseViewPortletKeys;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalService;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

/**
 * @author hp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfoodLMSportlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodFoodGrainLicenseFGLUserLicenseView",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/license_status.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicenseFGLUserLicenseViewPortletKeys.DGFOODFOODGRAINLICENSEFGLUSERLICENSEVIEW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class DgfoodFoodGrainLicenseFGLUserLicenseViewPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	licnsUserRegsLocalService _licnsUserRegsLocalService;
	
	@Reference
	public dgfLocDistrictLocalService _dgfLocDistrictLocalService;
	
	@Reference
	public dgfLocSubdistrictLocalService _dgfLocSubdistrictLocalService;
	
	@Reference
	public dgfLocUnionLocalService _dgfLocUnionLocalService;
	
	@Reference
	public DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;

	@Reference
	public DgfUsersLocalService _dgfUsersLocalService;
	
	@Reference
	public DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;
	//rajib
	@Reference
	public DgfRenewLicenseLocalService _dgfRenewLicenseLocalService;
	
	@Reference
	public DgfDuplctLicnsReasonLocalService _dgfDuplctLicnsReasonLocalService;
	
	@Reference
	public DgfDlrRegDtlsLocalService _dgfDlrRegDtlsLocalService;
	
	@Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();        
        try {
        DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);        
        String nationalId = dgfUsersObj.getNationalId();        
      //rajib start        
       
        long nid = Long.parseLong(nationalId);
        DgfFglPreDtls dgfFglPreDtlsObj=_dgfFglPreDtlsLocalService.getdgfFglPreDtls(nid);
        String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();  
        if(applicationNo!=null && !applicationNo.equals("")) {
        	long newApplicationStatus=dgfFglPreDtlsObj.getStatus();        	
        	String statusText = "";        	
    		if (newApplicationStatus == 0) {
    			statusText = "Approved"; // submited
    			renderRequest.setAttribute("newApplicationStatus", statusText);
    			renderRequest.setAttribute("newApplicationNo", applicationNo);
    		}         		
        }else {
        	System.out.println("Null====Emty");
        }   
        if(_dgfRenewLicenseLocalService.getDgfRenewLicenseByNid(nationalId)!=null) {
        DgfRenewLicense RenewLicenseObj= _dgfRenewLicenseLocalService.getDgfRenewLicenseByNid(nationalId);

        String applicationNumber=RenewLicenseObj.getApplicationNo();        
        if(applicationNumber!=null && !applicationNumber.equals("")) {
        	long status=RenewLicenseObj.getStatus();
        	String statusText = "";        	
    		if (status == 0) {
    			statusText = "Approved"; // submited
    			renderRequest.setAttribute("status", statusText);
    			renderRequest.setAttribute("applicationNo", applicationNumber);
    		} else if (status == 1) {
    			statusText = "Pending";    			
    			renderRequest.setAttribute("status", statusText);
    			renderRequest.setAttribute("applicationNo", applicationNumber);
    		}  else if (status == 4) {
    			statusText = "Rejected";
    			renderRequest.setAttribute("status", statusText);
    			renderRequest.setAttribute("applicationNo", applicationNumber);    	
    		}        		
        }else {
        	System.out.println("Null====Emty");
        }   
        }
        if(_dgfDuplctLicnsReasonLocalService.getDgfDuplctLicnsReasonByNid(nationalId)!=null) {
        	
        
        DgfDuplctLicnsReason DuplctLicnsReasonObj= _dgfDuplctLicnsReasonLocalService.getDgfDuplctLicnsReasonByNid(nationalId);
        String applicationDuplictNumber=DuplctLicnsReasonObj.getApplicationNo();        
        if(applicationDuplictNumber!=null && !applicationDuplictNumber.equals("")) {
        	long status=DuplctLicnsReasonObj.getStatus();
        	String statusText = "";        	
    		if (status == 0) {
    			statusText = "Approved"; // submited
    			renderRequest.setAttribute("statusDuplicat", statusText);
    			renderRequest.setAttribute("applicationDuplicatNo", applicationDuplictNumber);
    		} else if (status == 1) {
    			statusText = "Pending";    			
    			renderRequest.setAttribute("statusDuplicat", statusText);
    			renderRequest.setAttribute("applicationDuplicatNo", applicationDuplictNumber);    			
    		}  else if (status == 4) {
    			statusText = "Rejected";
    			renderRequest.setAttribute("statusDuplicat", statusText);
    			renderRequest.setAttribute("applicationDuplicatNo", applicationDuplictNumber);    	
    		}        		
        }else {
        	System.out.println("Null====Emty");
        }
        }
        if(_dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId)!=null) {
        	DgfDlrRegDtls DgfDlrRegDtlsObj= _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
            long dealerRegApplicationNo = DgfDlrRegDtlsObj.getDlrRegApplNo();
            String dealerRegApplicationNoStr = Long.toString(dealerRegApplicationNo);
            if(dealerRegApplicationNoStr!=null && !dealerRegApplicationNoStr.equals("")) {
            	long dealerStatus=DgfDlrRegDtlsObj.getStatus();
            	String statusText = "";        	
        		if (dealerStatus == 0) {
        			statusText = "Approved"; // submited
        			renderRequest.setAttribute("statusDealer", statusText);
        			renderRequest.setAttribute("applicationDealerNo", dealerRegApplicationNoStr);
        		} else if (dealerStatus == 1) {
        			statusText = "Pending";    			
        			renderRequest.setAttribute("statusDealer", statusText);
        			renderRequest.setAttribute("applicationDealerNo", dealerRegApplicationNoStr);    			
        		}  else if (dealerStatus == 4) {
        			statusText = "Rejected";
        			renderRequest.setAttribute("statusDealer", statusText);
        			renderRequest.setAttribute("applicationDealerNo", dealerRegApplicationNoStr);    	
        		}        		
            }else {
            	System.out.println("Null====Emty");
            }        	
        }
        
        
        
        //rajib end
        //long nid = Long.parseLong(nationalId); 
        
        
        
        
        DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglApplicationNo(applicationNo);
        licnsUserRegs userRegsObj = _licnsUserRegsLocalService.getlicnsUserByNid(nationalId);
        dgfLocDistrict districtObj = _dgfLocDistrictLocalService.getdgfLocDistrict(userRegsObj.getBusinessDistrict());
        dgfLocSubdistrict subDistrictObj = _dgfLocSubdistrictLocalService.getdgfLocSubdistrict(userRegsObj.getBusinessUpzilla());
        dgfLocUnion unionObj = _dgfLocUnionLocalService.getdgfLocUnion(userRegsObj.getBusinessUnionName());
        String districtName = districtObj.getBnName();
        String subDistrictName = subDistrictObj.getBnName();
        String unionName = unionObj.getBnName();
        renderRequest.setAttribute("userRegsObj", userRegsObj);
        renderRequest.setAttribute("dgfFglLicDtlsObj", dgfFglLicDtlsObj);
        renderRequest.setAttribute("districtName", districtName);
        renderRequest.setAttribute("subDistrictName", subDistrictName);
        renderRequest.setAttribute("unionName", unionName);
        } catch (Exception e) {
            
        }
        super.render(renderRequest, renderResponse);
    }
    
    @ProcessAction(name = "viewLicense")
    public void viewLicense(ActionRequest actionRequest, ActionResponse actionResponse,DgfFglPreDtls dgfFglPreDtlsObj)
            throws IOException, PortalException, PortletException {
    	getStatus(actionRequest, dgfFglPreDtlsObj);
        
    }
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		byte[] pdfBytes = null;
	    // call API and get pdf as bytes
		//TODO Base url and get param properly
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        String queryParams = "100";
        try {
        	DgfUsers dgfUsersObj = _dgfUsersLocalService.getDgfUsers(userId);
        	DgfFglPreDtls dgfFglPreDtlsObj = _dgfFglPreDtlsLocalService.getDgfFglPreDtlsByNID(Long.parseLong(dgfUsersObj.getNationalId()));
        	DgfFglLicDtls dgfFglLicDtlsObj = _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglPrePrimaryId(dgfFglPreDtlsObj.getFglPrePrimaryId());
        	queryParams = dgfFglLicDtlsObj.getFoodgrainLicenseNo();
        }catch (Exception e) {
			// TODO: handle exception
        	log.error(e.getMessage());
		}
		pdfBytes = _dgfFglPreDtlsLocalService.getLicenseReport(queryParams);
	    // send the report as a byte stream in the response
		resourceResponse.setContentType("application/pdf");
		resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=license-report.pdf");
	    OutputStream out = resourceResponse.getPortletOutputStream();
	    out.write(pdfBytes);
	    out.flush();

	}
	public void getStatus(ActionRequest actionRequest, DgfFglPreDtls dgfFglPreDtlsObj) {

		int status = dgfFglPreDtlsObj.getStatus();
		
		
		// 0 (Approved), 1 ( Pending), 6 (payment pending), 4 (Rejected),

		String statusText = "";
		if (status == 0) {
			statusText = "Approved"; // submited
			actionRequest.setAttribute("status", statusText);
		} else if (status == 1) {
			statusText = "Pending";
			actionRequest.setAttribute("status", statusText);
		} else if (status == 6) {
			statusText = "Payment Pending";
			actionRequest.setAttribute("status", statusText);
		} else if (status == 4) {
			statusText = "Rejected";
			actionRequest.setAttribute("status", statusText);
		}

	}
}