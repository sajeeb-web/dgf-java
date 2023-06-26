package bd.gov.dgfood.dealer.registration.portlet.action;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;
import bd.gov.dgfood.dealer.registration.portlet.service.DgfoodDealerRegistrationPortletService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrPerfDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegAddlDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.web.constants.DgfoodDealerRegistrationWebPortletKeys;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalService;

/**
 * @author hp
 */

@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-dealer-registration",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodDealerRegistrationWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dealer-registration.jsp",
		"javax.portlet.name=" + DgfoodDealerRegistrationWebPortletKeys.DGFOODDEALERREGISTRATIONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)

public class DgfoodDealerRegistrationPortletAction extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	DgfoodDealerRegistrationPortletService dgfoodDealerRegistrationPortletService;

	@Reference
	dgfLocDivisionLocalService _dgfLocDivisionLocalService;

	@Reference

	dgfLocDistrictLocalService _dgfLocDistrictLocalService;

	@Reference
	DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService;

	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;

	@Reference
	DgfDlrPerfDtlsLocalService dgfDlrPerfDtlsLocalService;
	
	@Reference
	DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService;

	@Reference
	DgfDlrUpdtTempDtlsLocalService dgfDlrUpdtTempDtlsLocalService;

	@Reference
	DgfDlrRegAddlDtlsLocalService dgfDlrRegAddlDtlsLocalService;

	@Reference
	DgfAttachmentsLocalService dgfAttachmentsLocalService;
	
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		CacheRegistryUtil.clear();
		int pageId = ParamUtil.getInteger(renderRequest, "pageId");
		String nationalId = ParamUtil.getString(renderRequest, "nid", "");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long userId = user.getUserId();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DgfUsers dgfUsersObj = dgfUsersLocalService.getDgfUsers(userId);
			String userNid = dgfUsersObj.getNationalId();
			String userDob = format.format(dgfUsersObj.getBirthDate());
			DgfFglLicDtls dgfFglLicDtlsObj = dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(userNid);
			String foodgrainLicense = dgfFglLicDtlsObj.getFoodgrainLicenseNo();
			Date foodgrainIssueDate = dgfFglLicDtlsObj.getFoodgrainLicenseIssueDate();
			String foodgrainIssueDateStr = format.format(foodgrainIssueDate);
			
			if(dgfFglLicDtlsObj.getFoodgrainLicenseType().equals("Dealer")) {
				renderRequest.setAttribute("foodgrainLicense", foodgrainLicense);
				renderRequest.setAttribute("foodgrainIssueDateStr", foodgrainIssueDateStr);
				renderRequest.setAttribute("userNid", userNid);
				renderRequest.setAttribute("userDob", userDob);
				if (pageId == 1) {
					if(user.getScreenName().equals(nationalId)) {
						processRegistration(renderRequest, renderResponse);
					}else {
						log.error("User not match with national Id");
					}
				}
				String languageId = themeDisplay.getLanguageId();
				renderRequest.setAttribute("languageId", languageId);

				renderRequest.setAttribute("pageId", pageId);
			}else {
				renderRequest.setAttribute("showAlert", "You don't have dealer license");
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("User not match with national Id");
		}
		
		super.render(renderRequest, renderResponse);
	}

	private void processRegistration(RenderRequest renderRequest, RenderResponse renderResponse) {
		String nationalId = ParamUtil.getString(renderRequest, "nid", "");
		renderRequest.setAttribute("nationalId", nationalId);
		
		dgfoodDealerRegistrationPortletService.getRegData(renderRequest);

		DgfDlrRegDtls dlrRegPriData = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
		DgfDlrRegAddlDtls dlrRegAddlPriData = dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByRegNo(dlrRegPriData.getDlrRegNo());
		DgfDlrPerfDtls dlrRegPerfPriData = dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsByDlrRegNo(dlrRegPriData.getDlrRegNo());
		DgfDlrUpdtTempDtls dlrUpdTmpPriData = null;
		List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nationalId);
	    if (!entities.isEmpty() && entities.size() > 0) {
	    	dlrUpdTmpPriData = entities.get(0);
	      }
	    renderRequest.setAttribute("dlrRegPriData", dlrRegPriData);
	    renderRequest.setAttribute("dlrRegAddlPriData", dlrRegAddlPriData);
	    renderRequest.setAttribute("dlrRegPerfPriData", dlrRegPerfPriData);
	    renderRequest.setAttribute("dlrUpdTmpPriData", dlrUpdTmpPriData);
	}

	private void processDlrRegShopDtls(ActionRequest actionRequest, ActionResponse actionResponse) {
		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		actionRequest.setAttribute("nationalId", nationalId);
		dgfoodDealerRegistrationPortletService.getDlrRegShopDtls(actionRequest);
		DgfDlrRegDtls dlrRegPriData = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
		DgfDlrRegAddlDtls dlrRegAddlPriData = dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByRegNo(dlrRegPriData.getDlrRegNo());
		DgfDlrPerfDtls dlrRegPerfPriData = dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsByDlrRegNo(dlrRegPriData.getDlrRegNo());
		DgfDlrUpdtTempDtls dlrUpdTmpPriData = null;
		List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nationalId);
	    if (!entities.isEmpty() && entities.size() > 0) {
	    	dlrUpdTmpPriData = entities.get(0);
	      }
		actionRequest.setAttribute("dlrRegPriData", dlrRegPriData);
		actionRequest.setAttribute("dlrRegAddlPriData", dlrRegAddlPriData);
		actionRequest.setAttribute("dlrRegPerfPriData", dlrRegPerfPriData);
		actionRequest.setAttribute("dlrUpdTmpPriData", dlrUpdTmpPriData);
	}

	private void processRegAttachmentInfo(ActionRequest actionRequest, ActionResponse actionResponse) {

		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		DgfDlrRegDtls dgfDlrRegDtlsObj = null;
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtlsObj = null;
		DgfDlrRegAddlDtls dgfDlrRegAddlDtlsObj = null;
		DgfAttachments bankSolvencyCertAttachment = null, incomeTaxAttachment = null, shopOwnershipDocAttachment = null,
				signatureAttachment = null, shopRentedDocAttachment = null;

		DgfAttachments psyclyChallengeAttachment = null;
		DgfAttachments userPhotoAttachment = null;

		dgfoodDealerRegistrationPortletService.getDlrRegAttachmentData(actionRequest);

		try {

			if (dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId) != null) {
				dgfDlrRegDtlsObj = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
			}

			if (dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtlsByNid(nationalId) != null) {
				List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nationalId);
			    if (!entities.isEmpty() && entities.size() > 0) {
			    	dgfDlrUpdtTempDtlsObj = entities.get(0);
			      }
			}

			if (dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByNid(nationalId) != null) {
				dgfDlrRegAddlDtlsObj = dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByRegNo(dgfDlrRegDtlsObj.getDlrRegNo());
			}

			if (dgfDlrRegDtlsObj.getBnkSolvncyCertId() > 0) {
				bankSolvencyCertAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfDlrRegDtlsObj.getBnkSolvncyCertId());
			}

			if (dgfDlrRegDtlsObj.getIncmTaxAttchID() > 0) {
				incomeTaxAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfDlrRegDtlsObj.getIncmTaxAttchID());
			}

			if (dgfDlrRegDtlsObj.getShpOwnshipDocuId() > 0) {
				shopOwnershipDocAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfDlrRegDtlsObj.getShpOwnshipDocuId());
			}
			if (dgfDlrRegDtlsObj.getSignatureId() > 0) {
				signatureAttachment = dgfAttachmentsLocalService.getDgfAttachments(dgfDlrRegDtlsObj.getSignatureId());
			}

			if (dgfDlrRegDtlsObj.getShpRentedDocuId() > 0) {
				shopRentedDocAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfDlrRegDtlsObj.getShpRentedDocuId());
			}

			if (dgfDlrRegAddlDtlsObj.getPhsclyChlnGdAttchId() > 0) {
				psyclyChallengeAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfDlrRegAddlDtlsObj.getPhsclyChlnGdAttchId());
			}

			DgfFglPreDtls dgfFglPreDtlsObj = dgfFglPreDtlsLocalService
					.getDgfFglPreDtlsByNID(Long.parseLong(nationalId));

			if (dgfFglPreDtlsObj != null && dgfFglPreDtlsObj.getPhotographDocId() > 0) {
				userPhotoAttachment = dgfAttachmentsLocalService
						.getDgfAttachments(dgfFglPreDtlsObj.getPhotographDocId());
			}

		} catch (Exception e) {

			log.error("DgfDlrRegDtls Object not found by the Nid " + e.getMessage());
			e.printStackTrace();

		}

		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("dgfDlrRegDtlsObj", dgfDlrRegDtlsObj);
		actionRequest.setAttribute("dgfDlrUpdtTempDtlsObj", dgfDlrUpdtTempDtlsObj);
		actionRequest.setAttribute("dgfDlrRegAddlDtlsObj", dgfDlrRegAddlDtlsObj);
		actionRequest.setAttribute("bankSolvencyCertAttachment", bankSolvencyCertAttachment);
		actionRequest.setAttribute("incomeTaxAttachment", incomeTaxAttachment);
		actionRequest.setAttribute("shopOwnershipDocAttachment", shopOwnershipDocAttachment);
		actionRequest.setAttribute("signatureAttachment", signatureAttachment);
		actionRequest.setAttribute("shopRentedDocAttachment", shopRentedDocAttachment);
		actionRequest.setAttribute("psyclyChallengeAttachment", psyclyChallengeAttachment);
		actionRequest.setAttribute("userPhotoAttachment", userPhotoAttachment);
	}

	private void processRegPreview(ActionRequest actionRequest, ActionResponse actionResponse) {
		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		DgfDlrRegDtls dgfDlrRegDtls = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
		long dlrRegAppLNo = dgfDlrRegDtls.getDlrRegApplNo();
		dgfoodDealerRegistrationPortletService.getDlrFinalSubmitData(actionRequest);
		actionRequest.setAttribute("dlrRegPriData", dgfDlrRegDtls);
		actionRequest.setAttribute("dlrRegAppLNo", dlrRegAppLNo);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (dgfDlrRegDtls.getDlrTypeId() != null) {
				dgfDlrRegDtlsLocalService.addDlrRegsDtlsPermission(dgfDlrRegDtls);
			}
			dgfoodDealerRegistrationPortletService.addWorkflow(actionRequest, dgfDlrRegDtls, themeDisplay);
			DgfUsers dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			String dealerMessage = DgfDlrRegDtlsLocalServiceUtil.getDealerFormSubmitMessage();
			String message = dealerMessage+ " #"+dgfDlrRegDtls.getDlrRegApplNo();
			// send message to dealer user
			DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
					message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
					dgfDlrRegDtls.getDlrRegApplNo());
		} catch (PortalException e) {
			log.error("Dealer Adding Error ion Workflow or Permission Providing== " + e.getMessage());
		}
	}

	@ProcessAction(name = "actionForm")
	public void actionForm(ActionRequest actionRequest, ActionResponse actionResponse) {

		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
		String nationalId = ParamUtil.getString(actionRequest, "nationalId", "");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		if (pageId == 2) {
			if(user.getScreenName().equals(nationalId)) {
				processDlrRegShopDtls(actionRequest, actionResponse);
			}else {
				log.error("User not match with national Id");
			}
		} else if (pageId == 3) {
			if(user.getScreenName().equals(nationalId)) {
				processRegAttachmentInfo(actionRequest, actionResponse);
			}else {
				log.error("User not match with national Id");
			}
		} else if (pageId == 4) {
			if(user.getScreenName().equals(nationalId)) {
				processRegPreview(actionRequest, actionResponse);
			}else {
				log.error("User not match with national Id");
			}
		}
	}
	
	@ProcessAction(name = "back")
	public void back(ActionRequest actionRequest, ActionResponse actionResponse) {
			
		String nationalId = ParamUtil.getString(actionRequest, "nationalId","");
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
		boolean isBack = ParamUtil.getBoolean(actionRequest, "isBack", false);
		
		if (isBack) {
			DgfDlrRegDtls dlrRegPriData = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nationalId);
			DgfDlrRegAddlDtls dlrRegAddlPriData = dgfDlrRegAddlDtlsLocalService.getDgfDlrRegAddlDtlsByRegNo(dlrRegPriData.getDlrRegNo());
			DgfDlrPerfDtls dlrRegPerfPriData = dgfDlrPerfDtlsLocalService.getDgfDlrPerfDtlsByDlrRegNo(dlrRegPriData.getDlrRegNo());
			DgfDlrUpdtTempDtls dlrUpdTmpPriData = null;
			List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nationalId);
		    if (!entities.isEmpty() && entities.size() > 0) {
		    	dlrUpdTmpPriData = entities.get(0);
		      }
			actionRequest.setAttribute("dlrRegPriData", dlrRegPriData);
			actionRequest.setAttribute("dlrRegAddlPriData", dlrRegAddlPriData);
			actionRequest.setAttribute("dlrRegPerfPriData", dlrRegPerfPriData);
			actionRequest.setAttribute("dlrUpdTmpPriData", dlrUpdTmpPriData);
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
		
		actionRequest.setAttribute("nationalId", nationalId);
		actionRequest.setAttribute("pageId", pageId);
	}
}