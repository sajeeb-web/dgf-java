package bd.gov.dgfood.food.grain.license.payment.web.service;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.payment.constants.DgfoodFoodGrainLicensePaymentWebPortletKeys;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

@Component(service =DgfoodFoodGrainLicensePaymentWebService.class)

public class DgfoodFoodGrainLicensePaymentWebService {
	
private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	CounterLocalService counterLocalService;

	@Reference
	licnsUserRegsLocalService licnsUserRegsLocalService;

	@Reference
	DgfAttachmentsLocalService dgfAttachmentsLocalService;
	
	@Reference
	DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService;
	
//	//aui form data recieved start 
//	public void addUploadData(ActionRequest actionRequest, ActionResponse actionResponse)
//			throws java.text.ParseException, ParseException {
	
	public void getActionRequestData(ActionRequest actionRequest, ActionResponse actionResponse) throws java.text.ParseException {
		String nationalId = ParamUtil.getString(actionRequest, "nidNumber");
		String paymentAttachmentInputName = "PaymentAttchDoc";
		String paymentLicAttachDocType  = ParamUtil.getString(actionRequest, "PaymentAttchType");		
		ResourceBundle bundle = ResourceBundle.getBundle("challan");
		String realPath = bundle.getString("image.file.root.dir");
		DgfAttachments dgfPaymentAttachmentObj = licnsUserRegsLocalService.uploadFile(actionRequest, nationalId, realPath,
				bundle, paymentLicAttachDocType, paymentAttachmentInputName);		
		getApplicationStatusPage(actionRequest, actionResponse);
		// DgfFglPreDtls table set attachment id (start)
		long paymentDocId = dgfPaymentAttachmentObj.getAttchmId();
		long nidId=dgfPaymentAttachmentObj.getNationalId();
		DgfFglPreDtls dgfFglPreDtlsObj= null;
		try {
			dgfFglPreDtlsObj= dgfFglPreDtlsLocalService.getdgfFglPreDtls(nidId);
			dgfFglPreDtlsObj.setPaymentChallanId(paymentDocId);
			dgfFglPreDtlsLocalService.updateDgfFglPreDtls(dgfFglPreDtlsObj);		
			
		} catch (NoSuchDgfFglPreDtlsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DgfFglPreDtls table set attachment id (end)
		// send user notification by location and workflow node wise
		String nodeId = "";
		boolean isUcf = dgfFglPreDtlsObj.getBusinessType().toUpperCase().equals(DgfoodFoodGrainLicensePaymentWebPortletKeys.ATTACHAKKI)
				||  dgfFglPreDtlsObj.getBusinessType().toUpperCase().equals(DgfoodFoodGrainLicensePaymentWebPortletKeys.RETAILERS);
		if(isUcf) {
			nodeId = "3c5b7e1a-0e2f-485f-b8ff-3a9fdcc69a9a";
			DgfFglPreDtlsLocalServiceUtil.getUcfUserIdByLocationAndSendNotificationByNodeId(dgfFglPreDtlsObj.getFglPrePrimaryId(), nodeId);
		}else {
			// check ccdr in this location
			boolean isCcdr = DgfFglPreDtlsLocalServiceUtil.checkCcdrUsersExistByLocation(dgfFglPreDtlsObj.getFglPrePrimaryId());
			if(isCcdr) {
				nodeId = "faf57cdc-84f0-4554-963c-a05c89cba550";
				DgfFglPreDtlsLocalServiceUtil.getCcdrUserIdByLocationAndSendNotificationByNodeId(dgfFglPreDtlsObj.getFglPrePrimaryId(), nodeId);
			}else {
				nodeId = "8bdffedc-c499-4185-9638-521e82f2fc92";
				DgfFglPreDtlsLocalServiceUtil.getDcfUserIdByLocationAndSendNotificationByNodeId(dgfFglPreDtlsObj.getFglPrePrimaryId(), nodeId);
			}
			
		}
	}
	
	public void getApplicationStatusPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		int pageId = ParamUtil.getInteger(actionRequest, "pageId");
		if (pageId == 2) {
			actionResponse.setRenderParameter("mvcPath", "/submission.jsp");
		}

	}
	
	
}
