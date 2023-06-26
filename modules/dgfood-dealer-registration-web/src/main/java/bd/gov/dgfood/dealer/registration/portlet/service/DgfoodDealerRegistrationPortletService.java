package bd.gov.dgfood.dealer.registration.portlet.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrPerfDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegAddlDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsLocalService;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;


@Component(service = DgfoodDealerRegistrationPortletService.class)

public class DgfoodDealerRegistrationPortletService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;
	
	@Reference 
	DgfDlrPerfDtlsLocalService dgfDlrPerfDtlsLocalService;
	
	@Reference 
	DgfDlrRegAddlDtlsLocalService dgfDlrRegAddlDtlsLocalService;
	
	@Reference 
	DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService;
	
	@Reference 
	DgfDlrUpdtTempDtlsLocalService dgfDlrUpdtTempDtlsLocalService;
	
	@Reference
	AssetEntryLocalService assetEntryLocalService;

	public void getRegData(RenderRequest renderRequest) {
		String licenseNo = ParamUtil.getString(renderRequest, "licenseNo","");
		String licnsIssueDateStr = ParamUtil.getString(renderRequest, "licnsIssueDate","");
		String dealerShipType = ParamUtil.getString(renderRequest, "dealerShipType","");
		String omsSubType = ParamUtil.getString(renderRequest, "omsSubType", "");
		String nid = ParamUtil.getString(renderRequest, "nid","");
		String dobStr = ParamUtil.getString(renderRequest, "dob","");
		String maritalStatus = ParamUtil.getString(renderRequest, "maritalStatus","");
		String spouseName = ParamUtil.getString(renderRequest, "spouseName","");
		String spouseFatherName = ParamUtil.getString(renderRequest, "spouseFatherName","");
		String spouseNid = ParamUtil.getString(renderRequest, "spouseNid","");
		String spouseDobStr = ParamUtil.getString(renderRequest, "spouseDob","");

		Date licnsIssueDate = null;
		Date dob = null;
		Date spouseDob = null;
		if (Validator.isNotNull(licnsIssueDateStr)) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				licnsIssueDate = formater.parse(licnsIssueDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (Validator.isNotNull(dobStr)) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dob = formater.parse(dobStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (Validator.isNotNull(spouseDobStr)) {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				spouseDob = formater.parse(spouseDobStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		if(user.getScreenName().equals(nid)) {
			dgfDlrRegDtlsLocalService.saveRegData(licenseNo,licnsIssueDate,dealerShipType,omsSubType,nid,dob,maritalStatus,spouseName,spouseFatherName,spouseNid,spouseDob);
		}else {
			log.error("User not match with national Id");
		}
	}
	public void addWorkflow(ActionRequest actionRequest,DgfDlrRegDtls dgfDlrRegDtls, ThemeDisplay themeDisplay) throws PortalException {
		log.info("DgfoodDealerRegistrationPortletService.addWorkflow  START");
		DgfUsers dgfUsers = null;
		try {
			// get userID 
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		if (Validator.isNotNull(dgfUsers)){
			String className = DgfDlrRegDtls.class.getName();
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			int status = WorkflowConstants.STATUS_PENDING;
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(className, actionRequest);
	        serviceContext.setScopeGroupId(groupId);
			serviceContext.setCompanyId(companyId);
			serviceContext.setUserId(userId);

			dgfDlrRegDtls.setUserId(userId);
			dgfDlrRegDtls.setGroupId(groupId);
			dgfDlrRegDtls.setCompanyId(companyId);
			dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dgfDlrRegDtls);
	    	// update status
	    	dgfDlrRegDtlsLocalService.updateStatus(userId, dgfDlrRegDtls.getDlrRegNo(), status, serviceContext);
	    	// start workflow for dgfDlrRegDtls
	    	AssetEntry assetEntry = assetEntryLocalService.updateEntry( userId, groupId, new Date(),
	                new Date(), className, dgfDlrRegDtls.getPrimaryKey(), null, 0, null, null, true, false, new Date(), null,
	                new Date(), null, ContentTypes.TEXT_HTML, dgfDlrRegDtls.getFglLicnsNo(), dgfDlrRegDtls.getFglLicnsNo(), null, null, null, 0, 0, null);
	    	//workflow starting
	        WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, className,
	        		dgfDlrRegDtls.getPrimaryKey(), dgfDlrRegDtls, serviceContext);
		}
        log.info("DgfoodDealerRegistrationPortletService.addWorkflow END");
	}
	
	public void getDlrRegShopDtls(ActionRequest actionRequest) {
		String nid =  ParamUtil.getString(actionRequest, "nationalId","");
		int workInGovt = ParamUtil.getInteger(actionRequest, "workInGovt");
		int publcRep = ParamUtil.getInteger(actionRequest, "publcRep");
		int physclyChlngd = ParamUtil.getInteger(actionRequest, "physclyChlngd");
		long shopDiv = ParamUtil.getLong(actionRequest, "shopDiv");
		long shopDis = ParamUtil.getLong(actionRequest, "shopDis");
		long shopUpazila = ParamUtil.getLong(actionRequest, "shopUpazila");
		long shopUnion = ParamUtil.getLong(actionRequest, "shopUnion");
		String shopWard = ParamUtil.getString(actionRequest, "shopWard","");
		String shopZipCode = ParamUtil.getString(actionRequest, "shopZipCode","");
		String shopLoc = ParamUtil.getString(actionRequest, "shopLoc","");
		long shopHeight = ParamUtil.getLong(actionRequest, "shopHeight");
		long shopLength = ParamUtil.getLong(actionRequest, "shopLength");
		long shopWidth = ParamUtil.getLong(actionRequest, "shopWidth");
		long shopStorageCap = ParamUtil.getLong(actionRequest, "shopStorageCap");
		int isCemented = ParamUtil.getInteger(actionRequest, "isCemented");
		int signBoard = ParamUtil.getInteger(actionRequest, "signBoard");
		
		int dlrRunShpHimself = ParamUtil.getInteger(actionRequest, "dlrRunShpHimself");
		String dealershipMemName = ParamUtil.getString(actionRequest, "dealershipMemName","");
		String dealershipMemType = ParamUtil.getString(actionRequest, "dealershipMemType","");
		
		int truckType = ParamUtil.getInteger(actionRequest, "truckType");
		String truckRentFlag = ParamUtil.getString(actionRequest, "truckRentFlag","");
		String truckPlatNo = ParamUtil.getString(actionRequest, "truckPlatNo","");
		long truckCap = ParamUtil.getLong(actionRequest, "truckCap");
		String truckMake = ParamUtil.getString(actionRequest, "truckMake","");
		String truckModel = ParamUtil.getString(actionRequest, "truckModel","");
		long truckManuYear = ParamUtil.getLong(actionRequest, "truckManuYear");
		long dlrPerfYr1SN = ParamUtil.getLong(actionRequest, "dlrPerfYr1SN");
		long dlrPerfYr1AllocQty = ParamUtil.getLong(actionRequest, "dlrPerfYr1AllocQty");
		long dlrPerfYr1ComdtyQty = ParamUtil.getLong(actionRequest, "dlrPerfYr1ComdtyQty");
		String dlrPerfYr1DlrCtgry = ParamUtil.getString(actionRequest, "dlrPerfYr1DlrCtgry","");
		String dlrPerfYr1Rmrk = ParamUtil.getString(actionRequest, "dlrPerfYr1Rmrk","");
		long dlrPerfYr2SN = ParamUtil.getLong(actionRequest, "dlrPerfYr2SN");
		long dlrPerfYr2AllocQty = ParamUtil.getLong(actionRequest, "dlrPerfYr2AllocQty");
		long dlrPerfYr2ComdtyQty = ParamUtil.getLong(actionRequest, "dlrPerfYr2ComdtyQty");
		String dlrPerfYr2DlrCtgry = ParamUtil.getString(actionRequest, "dlrPerfYr2DlrCtgry","");
		String dlrPerfYr2Rmrk = ParamUtil.getString(actionRequest, "dlrPerfYr2Rmrk","");
		long dlrPerfYr3SN = ParamUtil.getLong(actionRequest, "dlrPerfYr3SN");
		long dlrPerfYr3AllocQty = ParamUtil.getLong(actionRequest, "dlrPerfYr3AllocQty");
		long dlrPerfYr3ComdtyQty = ParamUtil.getLong(actionRequest, "dlrPerfYr3ComdtyQty");
		String dlrPerfYr3DlrCtgry = ParamUtil.getString(actionRequest, "dlrPerfYr3DlrCtgry","");
		String dlrPerfYr3Rmrk = ParamUtil.getString(actionRequest, "dlrPerfYr3Rmrk","");
		int dlrOptFoodgrainLicense = ParamUtil.getInteger(actionRequest, "foodgrainLicense");
		int dlrOptTradeLicense = ParamUtil.getInteger(actionRequest, "tradeLicense");
		int dlrOptTcvDlrLicense = ParamUtil.getInteger(actionRequest, "tcvDlrLicense");
		int dlrOptImportLicense = ParamUtil.getInteger(actionRequest, "importLicense");
		int dlrOptLicenseEssentialGoods = ParamUtil.getInteger(actionRequest, "licenseEssentialGoods");
		int dlrOptTradeLicenseAgriculture = ParamUtil.getInteger(actionRequest, "tradeLicenseAgriculture");
		String physclyChlngdDocInputName = "physclyChlngdDoc";
		String physclyChlngdDocType = ParamUtil.getString(actionRequest, "physclyChlngdDocType");
		ResourceBundle bundle = ResourceBundle.getBundle("attachment_documents");
		String realPath = bundle.getString("image.file.root.dir");
		long phsclyChlnGdAttchId = 0;
		if(physclyChlngd == 1) {
			DgfAttachments physclyChlngdDocAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid,
					realPath, bundle, physclyChlngdDocType, physclyChlngdDocInputName);
			if(physclyChlngdDocAttchObj != null) {
				phsclyChlnGdAttchId = physclyChlngdDocAttchObj.getAttchmId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
			
		if(user.getScreenName().equals(nid)) {
			dgfDlrPerfDtlsLocalService.saveDgfDlrPerfDtls(nid,dlrPerfYr1SN,dlrPerfYr1AllocQty,dlrPerfYr1ComdtyQty,dlrPerfYr1DlrCtgry,dlrPerfYr1Rmrk,dlrPerfYr2SN,dlrPerfYr2AllocQty,dlrPerfYr2ComdtyQty,dlrPerfYr2DlrCtgry,dlrPerfYr2Rmrk,dlrPerfYr3SN,dlrPerfYr3AllocQty,dlrPerfYr3ComdtyQty,dlrPerfYr3DlrCtgry,dlrPerfYr3Rmrk);
			dgfDlrRegAddlDtlsLocalService.saveDgfDlrRegAddlDtls(nid,phsclyChlnGdAttchId,workInGovt,publcRep,physclyChlngd,shopHeight,shopLength,shopWidth,shopStorageCap,isCemented,signBoard,dlrRunShpHimself,dealershipMemName,dealershipMemType,truckType,truckRentFlag,truckPlatNo,truckCap,truckMake,truckModel,truckManuYear);
			dgfDlrUpdtTempDtlsLocalService.saveDgfDlrUpdtTempDtls(nid,phsclyChlnGdAttchId,workInGovt,publcRep,physclyChlngd,shopDiv,shopDis,shopUpazila,shopUnion,shopWard,shopZipCode,shopLoc,shopHeight,shopLength,shopWidth,shopStorageCap,isCemented,signBoard,dlrRunShpHimself,dealershipMemName,dealershipMemType,truckType,truckRentFlag,truckPlatNo,truckCap,truckMake,truckModel,truckManuYear,dlrPerfYr1SN,dlrPerfYr1AllocQty,dlrPerfYr1ComdtyQty,dlrPerfYr1DlrCtgry,dlrPerfYr1Rmrk,dlrPerfYr2SN,dlrPerfYr2AllocQty,dlrPerfYr2ComdtyQty,dlrPerfYr2DlrCtgry,dlrPerfYr2Rmrk,dlrPerfYr3SN,dlrPerfYr3AllocQty,dlrPerfYr3ComdtyQty,dlrPerfYr3DlrCtgry,dlrPerfYr3Rmrk,dlrOptFoodgrainLicense,dlrOptTradeLicense,dlrOptTcvDlrLicense,dlrOptImportLicense,dlrOptLicenseEssentialGoods,dlrOptTradeLicenseAgriculture);
			dgfDlrRegDtlsLocalService.saveRegLocData(nid,shopDiv,shopDis,shopUpazila,shopUnion);
		}else {
			log.error("User not match with national Id");
		}
	}

	public void getDlrRegAttachmentData(ActionRequest actionRequest) {
		String nid = ParamUtil.getString(actionRequest, "nationalId")  ;
		String bankSolvCertInputName = "bankSolvCert";
		String bankSolvCertType = ParamUtil.getString(actionRequest, "bankSolvCertType");
		String taxRtrnCertInputName = "taxRtrnCert";
		String taxRtrnCertType = ParamUtil.getString(actionRequest, "taxRtrnCertType");
		String shopOwnrshpDocInputName = "shopOwnrshpDoc";
		String shopOwnrshpDocType = ParamUtil.getString(actionRequest, "shopOwnrshpDocType");
		String shopRentalDocInputName = "shopRentalDoc";
		String shopRentalDocType = ParamUtil.getString(actionRequest, "shopRentalDocType");
		String signOrThumbPicInputName = "signOrThumbPic";
		String signOrThumbPicType = ParamUtil.getString(actionRequest, "signOrThumbPicType");

		ResourceBundle bundle = ResourceBundle.getBundle("attachment_documents");
		String realPath = bundle.getString("image.file.root.dir");

		if (!nid.isEmpty()) {
			DgfDlrRegDtls dlrRegObjForAttchment = null;
			
			dlrRegObjForAttchment = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nid);
			
			if (dlrRegObjForAttchment != null) {
				DgfAttachments bankSolvCertAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid, realPath,
						bundle, bankSolvCertType, bankSolvCertInputName);
				DgfAttachments taxRtrnCertAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid, realPath,
						bundle, taxRtrnCertType, taxRtrnCertInputName);
				DgfAttachments shopOwnrshpDocAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid,
						realPath, bundle, shopOwnrshpDocType, shopOwnrshpDocInputName);
				DgfAttachments shopRentalDocAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid,
						realPath, bundle, shopRentalDocType, shopRentalDocInputName);
				DgfAttachments signOrThumbPicAttchObj = dgfDlrRegDtlsLocalService.uploadFile(actionRequest, nid,
						realPath, bundle, signOrThumbPicType, signOrThumbPicInputName);

				long bankSolvCertAttchId = bankSolvCertAttchObj.getAttchmId();
				long taxRtrnCertAttchId = taxRtrnCertAttchObj.getAttchmId();
				long shopOwnrshpDocAttchId = shopOwnrshpDocAttchObj.getAttchmId();
				long shopRentalDocAttchId = shopRentalDocAttchObj.getAttchmId();
				long signOrThumbPicAttchId = signOrThumbPicAttchObj.getAttchmId();
				
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
					
				if(user.getScreenName().equals(nid)) {
					dgfDlrRegDtlsLocalService.saveRegDocData(nid,bankSolvCertAttchId,taxRtrnCertAttchId,shopOwnrshpDocAttchId,shopRentalDocAttchId,signOrThumbPicAttchId);
				}else {
					log.error("User not match with national Id");
				}
			}
		} else {
			log.error("Nid field is Empty in Form");
		}
	}
	
	public void getDlrFinalSubmitData(ActionRequest actionRequest) {
		String nid = ParamUtil.getString(actionRequest, "nationalId", "");
		dgfDlrRegDtlsLocalService.saveFinalSubmitData(nid);
	}
}