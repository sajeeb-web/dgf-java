package bd.gov.dgfood.food.grain.license.payment.portlet;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.payment.constants.DgfoodFoodGrainLicensePaymentWebPortletKeys;
import bd.gov.dgfood.food.grain.license.payment.web.service.DgfoodFoodGrainLicensePaymentWebService;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfStoreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;

import com.liferay.portal.kernel.util.PortalUtil;
import bd.gov.dgfood.food.grain.license.payment.constants.DgfoodFoodGrainLicensePaymentWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=dgfood-food-grain-license",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodFoodGrainLicensePaymentWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/trackview.jsp",
		"javax.portlet.name=" + DgfoodFoodGrainLicensePaymentWebPortletKeys.DGFOODFOODGRAINLICENSEPAYMENTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodFoodGrainLicensePaymentWebPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	licnsUserRegsLocalService licnsUserRegsLocalService;

	@Reference
	DgfAttachmentsLocalService dgfAttachmentsLocalService;

	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;

	@Reference
	DgfoodFoodGrainLicensePaymentWebService dgfoodFoodGrainLicensePaymentWebService;

	@Reference
	public dgfLocDivisionLocalService _dgfLocDivisionLocalService;

	// this module Tracks Food Grain License application status
	// validates NID and DOB or Application number and DOB
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		CacheRegistryUtil.clear();
		PrintWriter writer = resourceResponse.getWriter();
		String cmd = ParamUtil.getString(resourceRequest, "cmd", "");
		String trackingNum = ParamUtil.getString(resourceRequest, "trackingNum");
		String trackBirthDate = ParamUtil.getString(resourceRequest, "trackBirthDate");
		if (cmd.equalsIgnoreCase("checkUserByNid")) {
			DgfFglPreDtls dgfFglPreDtls = getUserByNationalId(trackingNum);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isUser", dgfFglPreDtls != null ? true : false);
			if (dgfFglPreDtls != null && trackBirthDate != null) {
				Date date = dgfFglPreDtls.getBirthDate();
				DateFormat DateOfBirthFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = DateOfBirthFormat.format(date);
				jsonObject.put("isDateCorrect", dateStr.equals(trackBirthDate));
			}
			writer.write(jsonObject.toString());
		} else if (cmd.equalsIgnoreCase("checkUserByApplicationNo")) {
			DgfFglPreDtls dgfFglPreDtls = getUserByFglApplicationNo(trackingNum);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("isUser", dgfFglPreDtls != null ? true : false);
			if (dgfFglPreDtls != null && trackBirthDate != null) {
				Date date = dgfFglPreDtls.getBirthDate();
				DateFormat DateOfBirthFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = DateOfBirthFormat.format(date);
				jsonObject.put("isDateCorrect", dateStr.equals(trackBirthDate));
			}
			writer.write(jsonObject.toString());
		}
	}

	// Form valid Method for NID
	private DgfFglPreDtls getUserByNationalId(String nationalId) {
		try {
			DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
			return dgfFglPreDtls;
		} catch (PortalException e) {
			log.error("not found dgfFglPreDtls by nid " + nationalId);
		}
		return null;
	}

	// Form valid Method for Application No
	private DgfFglPreDtls getUserByFglApplicationNo(String applicationNum) {
		try {

			DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(applicationNum);
			return dgfFglPreDtls;
		} catch (PortalException e) {
			log.error("not found dgfFglPreDtls by applicationNum " + applicationNum);
		}
		return null;
	}

	// action for submit button

	public void addUploadTrackData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws java.text.ParseException {
		String radioButton = ParamUtil.getString(actionRequest, "radioButton");
		String nidId = ParamUtil.getString(actionRequest, "trackingNum");
		String trackBirthDateStr = ParamUtil.getString(actionRequest, "trackBirthDate");
		Date trackDateOfBirth = null;
		if (Validator.isNotNull(trackBirthDateStr)) {
			SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
			trackDateOfBirth = formatter6.parse(trackBirthDateStr);
		}
		DateFormat trackDateOfBirthFormat = new SimpleDateFormat("dd-MM-yyyy");
		String trackDateOfBirthFormatStr = trackDateOfBirthFormat.format(trackDateOfBirth);

		DgfFglPreDtls dgfFglPreDtlsObj;
		try {
			if (radioButton.equals("nid")) {
				long nid = 0L;
				String nidStr = nidId;
				if (nidStr != null && !nidStr.isEmpty()) {
					nid = Long.parseLong(nidStr);
				}
				
				dgfFglPreDtlsObj = dgfFglPreDtlsLocalService.getdgfFglPreDtls(nid);
				long nidIdLong = dgfFglPreDtlsObj.getNationalId();
				String nidString = String.valueOf(nidIdLong);
				Date DateOfBirth = dgfFglPreDtlsObj.getBirthDate();
				// Date formate change Fri Mar 03 00:00:00 GMT 2023 to dd-MM-yyyy
				DateFormat DateOfBirthFormat = new SimpleDateFormat("dd-MM-yyyy");
				String DateOfBirthFormatStr = DateOfBirthFormat.format(DateOfBirth);

				if (nidString.equals(nidId) && DateOfBirthFormatStr.equals(trackDateOfBirthFormatStr)) {
					// License Application Status and Preview page
					getApplicationStatusPage(actionRequest, actionResponse);
					// License Application Status
					getStatus(actionRequest, dgfFglPreDtlsObj);
					// License Application Preview page
					previewPage(actionRequest, nidId, trackBirthDateStr);

				}

			} else if (radioButton.equals("applicationno")) {
				String fglApplicationNo = nidId;
				dgfFglPreDtlsObj = dgfFglPreDtlsLocalService.getdgfFglPreDtls(fglApplicationNo);
				String applicationNo = dgfFglPreDtlsObj.getFglApplicationNo();
				long nidIdLong = dgfFglPreDtlsObj.getNationalId();
				String nid = String.valueOf(nidIdLong);
				Date DateOfBirth = dgfFglPreDtlsObj.getBirthDate();
				// Date formate change Fri Mar 03 00:00:00 GMT 2023 to dd-MM-yyyy
				DateFormat DateOfBirthFormat = new SimpleDateFormat("dd-MM-yyyy");
				String DateOfBirthFormatStr = DateOfBirthFormat.format(DateOfBirth);

				if (applicationNo.equals(nidId) && DateOfBirthFormatStr.equals(trackDateOfBirthFormatStr)) {
					// License Application Status and Preview page
					getApplicationStatusPage(actionRequest, actionResponse);
					// License Application Status
					getStatus(actionRequest, dgfFglPreDtlsObj);
					// License Application Preview page
					previewPage(actionRequest, nid, trackBirthDateStr);
				}

			}

		} catch (NoSuchDgfFglPreDtlsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// routing page
	public void getApplicationStatusPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
		if (pageId == 1) {
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		}
		else if (pageId == 2) {
			actionResponse.setRenderParameter("mvcPath", "/submission.jsp");
		}

	}

	// Application Status
	public void getStatus(ActionRequest actionRequest, DgfFglPreDtls dgfFglPreDtlsObj) {

		int status = dgfFglPreDtlsObj.getStatus();
		Date statusDate = dgfFglPreDtlsObj.getStatusDate();
		Date statusUpdatedDate = statusDate;
		// Date formate change Fri Mar 03 00:00:00 GMT 2023 to dd-MM-yyyy
		DateFormat statusDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String statusUpdatedDateStr = statusDateFormat.format(statusUpdatedDate);
		actionRequest.setAttribute("statusUpdatedDateStr", statusUpdatedDateStr);
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
		
		String businessType=dgfFglPreDtlsObj.getBusinessType();		
		String type="";
		if (businessType.equals("Importer")) {
			type="Importer";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("WholesalersAndStockists")) {
			type="WholesalersAndStockists";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("Retailers")) {
			type="Retailers";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("MajorAndCompactFlourMill")) {
			type="MajorAndCompactFlourMill";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("RollerFlourMill")) {
			type="RollerFlourMill";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("AttaChakki")) {
			type="AttaChakki";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("AutomaticRiceMill")) {
			type="AutomaticRiceMill";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("MajorRiceMill")) {
			type="MajorRiceMill";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("HuskingRiceMill")) {
			type="HuskingRiceMill";
			actionRequest.setAttribute("businessType", type);			
		}else if (businessType.equals("Dealer")) {
			type="Dealer";
			actionRequest.setAttribute("businessType", type);			
		}
		

	}

	// Preview page
	// Basic info , Trade license info , Address , Registered Address and uploaded
	// document show data
	public void previewPage(ActionRequest actionRequest, String nidId, String trackBirthDateStr) {
		try {
			licnsUserRegs licnsUserRegsObj = licnsUserRegsLocalService.getlicnsUserByNid(nidId);

			String nidString = licnsUserRegsObj.getNationalId();
			Date DOB = licnsUserRegsObj.getBirthDate();
			DateFormat DOBDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String DOBDateStr = DOBDateFormat.format(DOB);
			// actionRequest.setAttribute("nidID", nidString);
			actionRequest.setAttribute("dob", DOBDateStr);
			
			
			// preview page Store dtls 
			List<DgfStoreDtls> dgfStoreDtls = null ;
			dgfStoreDtls= DgfStoreDtlsLocalServiceUtil.getDgfStoreDtlsListByNid(nidString);	
					 
			 try {
				 Map<Long, Object> storeAddresses = DgfStoreDtlsLocalServiceUtil.getUserStoreAddrs(nidString);
				 actionRequest.setAttribute("storeAddresses", storeAddresses);
				 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				 String languageId = themeDisplay.getLanguageId();
				 actionRequest.setAttribute("languageId", languageId);
		
		        } catch (PortalException e) {
		            log.error("cannot get store address");
		        }
			 actionRequest.setAttribute("dgfStoreDtls", dgfStoreDtls);
			
			// preview page Address start
			List<dgfLocDivision> division = new ArrayList<>();
			try {
				division = _dgfLocDivisionLocalService.getdgfLocDivisions(0,
						_dgfLocDivisionLocalService.getdgfLocDivisionsCount());

				if (!nidId.isEmpty() && !trackBirthDateStr.isEmpty()) {
					licnsUserRegs userPriData = licnsUserRegsLocalService.getlicnsUserByNid(nidId);
					Map<String, String> userRegAddrs = licnsUserRegsLocalService.getlicnsUserAddrs(nidId);
					actionRequest.setAttribute("userRegAddrs", userRegAddrs);
					actionRequest.setAttribute("userPriData", userPriData);
				}
			} catch (Exception e) {
				log.error("found error====");
			}
			actionRequest.setAttribute("division", division);
			// preview page Address end

			// DOB convet formet start
			Date tradeLicenseExpiry = licnsUserRegsObj.getTradeLicenseExpiryDate();
			Date tradeLicenseExpiryDate = tradeLicenseExpiry;
			DateFormat tradeLicenseDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String tradeLicenseExpiryDateString = tradeLicenseDateFormat.format(tradeLicenseExpiryDate);
			actionRequest.setAttribute("tradeLicenseExpiryDateString", tradeLicenseExpiryDateString);
			// DOB convet formet end

			// Photograph Fill
			String photographFileString = licnsUserRegsObj.getPhotographFile();
			if (photographFileString != (null) && !photographFileString.trim().equals("")) {
				photographFileString = "true";
				actionRequest.setAttribute("photographFile", photographFileString);
			} else {
				photographFileString = "false";
				actionRequest.setAttribute("photographFile", photographFileString);
			}
			// Trade Lic Doc
			String tradeLicDocString = licnsUserRegsObj.getTradeLicDoc();
			if (tradeLicDocString != (null) && !tradeLicDocString.trim().equals("")) {
				tradeLicDocString = "true";
				actionRequest.setAttribute("tradeLicDoc", tradeLicDocString);
			} else {
				tradeLicDocString = "false";
				actionRequest.setAttribute("tradeLicDoc", tradeLicDocString);
			}
			// bin Doc file
			String binDocString = licnsUserRegsObj.getBinDoc();
			if (binDocString != (null) && !binDocString.trim().equals("")) {
				binDocString = "true";
				actionRequest.setAttribute("binDoc", binDocString);
			} else {
				binDocString = "false";
				actionRequest.setAttribute("binDoc", binDocString);
			}
			// Tin Doc file
			String tinDocString = licnsUserRegsObj.getTinDoc();
			if (tinDocString != (null) && !tinDocString.trim().equals("")) {
				tinDocString = "true";
				actionRequest.setAttribute("tinDoc", tinDocString);
			} else {
				tinDocString = "false";
				actionRequest.setAttribute("tinDoc", tinDocString);
			}
			// bank Stat file
			String bankStatString = licnsUserRegsObj.getBankStat();
			if (bankStatString != (null) && !bankStatString.trim().equals("")) {
				bankStatString = "true";
				actionRequest.setAttribute("bankStat", bankStatString);
			} else {
				bankStatString = "false";
				actionRequest.setAttribute("bankStat", bankStatString);
			}
			//bsti
			String bstiClrString = licnsUserRegsObj.getBstiClrMemo();
			if (bstiClrString != (null) && !bstiClrString.trim().equals("")) {
				bstiClrString = "true";
				actionRequest.setAttribute("bstiClrDoc", bstiClrString);
			} else {
				bstiClrString = "false";
				actionRequest.setAttribute("bstiClrDoc", bstiClrString);
			}
			//electric
			String electricExemptionString = licnsUserRegsObj.getElectricExemptionMemo();
			if (electricExemptionString != (null) && !electricExemptionString.trim().equals("")) {
				electricExemptionString = "true";
				actionRequest.setAttribute("electricExemptionDoc", electricExemptionString);
			} else {
				electricExemptionString = "false";
				actionRequest.setAttribute("electricExemptionDoc", electricExemptionString);
			}
			//envirClr
			String envClrMemoString = licnsUserRegsObj.getEnvClrMemo();
			if (envClrMemoString != (null) && !envClrMemoString.trim().equals("")) {
				envClrMemoString = "true";
				actionRequest.setAttribute("envClrMemoDoc", envClrMemoString);
			} else {
				envClrMemoString = "false";
				actionRequest.setAttribute("envClrMemoDoc", envClrMemoString);
			}
			//fire
			String fireLicNumDocString = licnsUserRegsObj.getFireLicNumDoc();
			if (fireLicNumDocString != (null) && !fireLicNumDocString.trim().equals("")) {
				fireLicNumDocString = "true";
				actionRequest.setAttribute("fireLicNumDoc", fireLicNumDocString);
			} else {
				fireLicNumDocString = "false";
				actionRequest.setAttribute("fireLicNumDoc", fireLicNumDocString);
			}
			// other Relevent Doc file
			String otherReleventDocString = licnsUserRegsObj.getOtherReleventDoc();
			if (otherReleventDocString != (null) && !otherReleventDocString.trim().equals("")) {
				otherReleventDocString = "true";
				actionRequest.setAttribute("otherReleventDoc", otherReleventDocString);
			} else {
				otherReleventDocString = "false";
				actionRequest.setAttribute("otherReleventDoc", otherReleventDocString);
			}
			// preview page set end

		} catch (NoSuchlicnsUserRegsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	// License Application Status Payment upload
	@ProcessAction(name = "addUploadData")
	public void addUploadData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws java.text.ParseException, ParseException {
		dgfoodFoodGrainLicensePaymentWebService.getActionRequestData(actionRequest,actionResponse);

	}
}