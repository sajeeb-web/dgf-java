package bd.gov.dgfood.food.grain.license.renew.portlet.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.renew.constants.LicenseRenewKeys;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

@Component(service = LicenseRenewPortletService.class)

public class LicenseRenewPortletService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	DgfRenewLicenseLocalService dgfRenewLicenseLocalService;
	@Reference
	licnsUserRegsLocalService licnsUserRegsLocalService;
	@Reference
	DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService;
	@Reference
	RoleLocalService roleLocalService;
	@Reference
	ResourcePermissionLocalService resourcePermissionLocalService;
	@Reference
	AssetEntryLocalService assetEntryLocalService;

	public DgfRenewLicense getActionRequestData(ActionRequest actionRequest) throws PortalException, ParseException {

		String licenseNo = ParamUtil.getString(actionRequest, "licenseNo");
		String licDateStr = ParamUtil.getString(actionRequest, "licenseExpiryDate");
		String tradeLicenseNo = ParamUtil.getString(actionRequest, "tradeLicenseNo");
		String tradeLicDateStr = ParamUtil.getString(actionRequest, "tradeLicenseExpiryDate");
		String comments = ParamUtil.getString(actionRequest, "comments");
		String tradeLicAttachDocType = ParamUtil.getString(actionRequest, "tradeLicAttchType");
		String paymentLicAttachDocType = ParamUtil.getString(actionRequest, "paymentAttchType");
		Date licenseExpiryDate = dateMaker(licDateStr);
		Date tradeLicenseExpiryDate = dateMaker(tradeLicDateStr);

		User currentUser = PortalUtil.getUser(actionRequest);
		long currentUserId = currentUser.getUserId();
		DgfUsers dgfUser = dgfUsersLocalService.getDgfUsers(currentUserId);
		long dgfUserId = dgfUser.getUserId();
		String nationalId = dgfUser.getNationalId();

		String tradeAttachmentInputName = "tradeLicAttchDoc";
		String paymentAttachmentInputName = "paymentAttchDoc";

		ResourceBundle bundle = ResourceBundle.getBundle("attachment_documents");
		String realPath = bundle.getString("image.file.root.dir");
		if (!nationalId.isEmpty()) {
			DgfFglLicDtls dgfFglLicDtlsObj = dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNidAndFglLicNo(nationalId,
					licenseNo);
			if (dgfFglLicDtlsObj != null) {
				
				List<DgfRenewLicense> dgfRenewLicnsStatusChk = dgfRenewLicenseLocalService.getDgfRenewLicByNationalIdAndLicense(nationalId, licenseNo);			
				
				boolean statusFlag = false;
				
				for (DgfRenewLicense renewLic : dgfRenewLicnsStatusChk) {
				    int status = renewLic.getStatus();

				    if (status == 1) {
				        statusFlag = true; 
				    }
				}
				
				if(!statusFlag) {
					DgfAttachments dgfTradeAttachmentObj = licnsUserRegsLocalService.uploadFile(actionRequest, nationalId,
							realPath, bundle, tradeLicAttachDocType, tradeAttachmentInputName);
					DgfAttachments dgfPaymentAttachmentObj = licnsUserRegsLocalService.uploadFile(actionRequest, nationalId,
							realPath, bundle, paymentLicAttachDocType, paymentAttachmentInputName);

					long tradeDocId = dgfTradeAttachmentObj.getAttchmId();
					long paymentDocId = dgfPaymentAttachmentObj.getAttchmId();


					DgfRenewLicense dgfRenewLicObj = renewLicense(dgfFglLicDtlsObj, dgfUserId, nationalId, licenseNo, licenseExpiryDate, tradeLicenseNo,

							tradeLicenseExpiryDate, tradeDocId, paymentDocId, comments);
					// call workflow
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					
					addWorkflow(actionRequest, dgfUserId, dgfRenewLicObj, themeDisplay);
					//send message to user
					String licenseMessage = DgfFglPreDtlsLocalServiceUtil.getRenewLicenseFormSubmitMessage();
					String message = licenseMessage+ " #"+dgfRenewLicObj.getApplicationNo();
					// send message to renew license user
					DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
							message, dgfUser.getNationalId(), dgfUser.getMobileNo(), dgfUser.getUserId(),
							Long.parseLong(dgfRenewLicObj.getApplicationNo()));
					
					return dgfRenewLicObj;
				}else {
					actionRequest.setAttribute("showAlert", "modalMessage");
				}

			} else {
				log.error("Fgl License not Found");
			}
		} else {
			log.error("Registered User not Found");
		}
		return null;
	}


	public DgfRenewLicense renewLicense(DgfFglLicDtls dgfFglLicDtlsObj, long dgfUserId, String nationalId, String licenseNo,

			Date licenseExpiryDate, String tradeLicenseNo, Date tradeLicenseExpiryDate, long tradeDocId,
			long paymentDocId, String comments) throws ParseException {

		long currentTimeMillis = System.currentTimeMillis();
		String applicationNo = dgfFglLicDtlsObj.getNationalId().substring(dgfFglLicDtlsObj.getNationalId().length() - 4)
				+ currentTimeMillis;

		List<DgfRenewLicense> dgfRenewLicnsStatusChk = dgfRenewLicenseLocalService.getDgfRenewLicByNationalIdAndLicense(nationalId, licenseNo);
			
		boolean statusFlag = false;
		
		for (DgfRenewLicense renewLic : dgfRenewLicnsStatusChk) {
		    int status = renewLic.getStatus();

		    if (status == 1) {
		        statusFlag = true; 
		    }
		}
		
		if(!statusFlag) {

			long renewLicenseId = counterLocalService.increment(DgfRenewLicense.class.getName());
			DgfRenewLicense dgfRenewLicObj = dgfRenewLicenseLocalService.createDgfRenewLicense(renewLicenseId);
			dgfRenewLicObj.setUserId(dgfUserId);
			dgfRenewLicObj.setNationalId(nationalId);
			if (licenseNo.equals(dgfFglLicDtlsObj.getFoodgrainLicenseNo())) {
				dgfRenewLicObj.setLicenseNo(licenseNo);
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dgfLicExpdate = dateFormat.parse(dateFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate()));
			Date dgfTradeLicExpdate = dateFormat.parse(dateFormat.format(dgfFglLicDtlsObj.getTradeLicenseExpiryDate()));

			if (licenseExpiryDate.equals(dgfLicExpdate)) {
				dgfRenewLicObj.setLicenseExpiryDate(licenseExpiryDate);
			}
			if (tradeLicenseNo.equals(dgfFglLicDtlsObj.getTradeLicenseNo())) {
				dgfRenewLicObj.setTradeLicenseNo(tradeLicenseNo);
			}
			if (tradeLicenseExpiryDate.equals(dgfTradeLicExpdate)) {
				dgfRenewLicObj.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
			}
			dgfRenewLicObj.setTradeLicAttchId(tradeDocId);
			dgfRenewLicObj.setPaymentAttchId(paymentDocId);
			dgfRenewLicObj.setApplicationNo(applicationNo);
			dgfRenewLicObj.setFglPrePrimaryId(dgfFglLicDtlsObj.getFglPrePrimaryId());
			dgfRenewLicObj.setLicenseApplicationType("Renew");
			dgfRenewLicObj.setStatus(1);
			dgfRenewLicObj.setComments(comments);
			dgfRenewLicenseLocalService.addDgfRenewLicense(dgfRenewLicObj);
			dgfRenewLicObj.setCreatedDate(dgfRenewLicObj.getModifiedDate());
			dgfRenewLicenseLocalService.updateDgfRenewLicense(dgfRenewLicObj);
			addRenewLicensePermission(dgfRenewLicObj, nationalId);
			return dgfRenewLicObj;
		}else {
			log.error(" Renew  application already exist for this Lic");
		}
		return null;

	}
	
	public void addWorkflow(ActionRequest actionRequest,long userId,DgfRenewLicense dgfRenewLicense, ThemeDisplay themeDisplay) throws PortalException {
		//workflow starting
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DgfRenewLicense.class.getName(), actionRequest);
        long groupId = themeDisplay.getScopeGroupId();
        long companyId = themeDisplay.getCompanyId();
        int status = WorkflowConstants.STATUS_PENDING;
    	serviceContext.setScopeGroupId(groupId);
    	serviceContext.setCompanyId(companyId);
    	serviceContext.setUserId(themeDisplay.getUserId());
    	String className = DgfRenewLicense.class.getName();
    	// update status
    	dgfRenewLicenseLocalService.updateStatus(userId, dgfRenewLicense.getRenewLicenseId(), status, serviceContext);
        
        AssetEntry assetEntry = assetEntryLocalService.updateEntry( themeDisplay.getUserId(), serviceContext.getScopeGroupId(), new Date(),
                new Date(), className,dgfRenewLicense.getPrimaryKey(), null, 0, null, null, true, false, new Date(), null,
                new Date(), null, ContentTypes.TEXT_HTML, dgfRenewLicense.getApplicationNo(), dgfRenewLicense.getApplicationNo(), null, null, null, 0, 0, null);

        WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, dgfRenewLicense.getUserId(), className,
        		   dgfRenewLicense.getPrimaryKey(), dgfRenewLicense, serviceContext);
	}


//		This Code Snippet Part Check if  a application already is entered or not, if yes then it just update the data else create new application
//		DgfRenewLicense dgfRenewLicExistObj = null;
//
//		if (!nationalId.isEmpty()) {
//			try {
//				dgfRenewLicExistObj = dgfRenewLicenseLocalService.getDgfRenewLicenseByNid(nationalId);
//			} catch (NoSuchDgfRenewLicenseException e) {
//				dgfRenewLicExistObj = null;
//			}
//
//			if (dgfRenewLicExistObj != null) {
//				if (Validator.isNotNull(nationalId)) {
//					dgfRenewLicExistObj.setNationalId(nationalId);
//				}
//				if (Validator.isNotNull(dgfUserId)) {
//					dgfRenewLicExistObj.setUserId(dgfUserId);
//				}
//
//				if (Validator.isNotNull(licenseNo)) {
//					dgfRenewLicExistObj.setLicenseNo(licenseNo);
//				}
//
//				if (Validator.isNotNull(licenseExpiryDate)) {
//					dgfRenewLicExistObj.setLicenseExpiryDate(licenseExpiryDate);
//				}
//
//				if (Validator.isNotNull(tradeLicenseNo)) {
//					dgfRenewLicExistObj.setTradeLicenseNo(tradeLicenseNo);
//				}
//
//				if (Validator.isNotNull(tradeLicenseExpiryDate)) {
//					dgfRenewLicExistObj.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
//				}
//				if (Validator.isNotNull(tradeDocId)) {
//					dgfRenewLicExistObj.setTradeLicAttchId(tradeDocId);
//				}
//				if (Validator.isNotNull(paymentDocId)) {
//					dgfRenewLicExistObj.setPaymentAttchId(paymentDocId);
//				}
//
//				if (Validator.isNotNull(comments)) {
//					dgfRenewLicExistObj.setComments(comments);
//				}
//				dgfRenewLicenseLocalService.updateDgfRenewLicense(dgfRenewLicExistObj);
//			} else {
//
//				long renewLicenseId = counterLocalService.increment(DgfRenewLicense.class.getName());
//				DgfRenewLicense dgfRenewLicObj = dgfRenewLicenseLocalService.createDgfRenewLicense(renewLicenseId);
//				dgfRenewLicObj.setUserId(dgfUserId);
//				dgfRenewLicObj.setNationalId(nationalId);
//				dgfRenewLicObj.setLicenseNo(licenseNo);
//				dgfRenewLicObj.setLicenseExpiryDate(licenseExpiryDate);
//				dgfRenewLicObj.setTradeLicenseNo(tradeLicenseNo);
//				dgfRenewLicObj.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
//				dgfRenewLicObj.setTradeLicAttchId(tradeDocId);
//				dgfRenewLicObj.setPaymentAttchId(paymentDocId);
//				dgfRenewLicObj.setComments(comments);
//				dgfRenewLicenseLocalService.addDgfRenewLicense(dgfRenewLicObj);
//			}
//		}


	private void addRenewLicensePermission(DgfRenewLicense dgfRenewLicense, String nationalId) {
	
	try {
		DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
		DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
		long companyId = dgfFglPreDtls.getCompanyId();
		String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
		String roleName = LicenseRenewKeys.ROLE_DCF;
		String primKey = dgfRenewLicense.getRenewLicenseId()+ StringPool.UNDERLINE +LicenseRenewKeys.DISTRICT_FIRST_LETTER+dgfBussAddrDtls.getBusinessDistrict();
		String businessType = dgfFglPreDtls.getBusinessType();
		if(businessType != null) {
			if(LicenseRenewKeys.ATTACHAKKI.equals(businessType.toUpperCase()) || LicenseRenewKeys.RETAILERS.equals(businessType.toUpperCase())) {
				roleName = LicenseRenewKeys.ROLE_UCF;
				primKey = dgfRenewLicense.getRenewLicenseId()+ StringPool.UNDERLINE +LicenseRenewKeys.UPAZILLA_FIRST_LETTER+dgfBussAddrDtls.getBusinessUpzilla();
			} else {
				List<DgfUsers> dgfAcfUsers = dgfUsersLocalService.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(), companyId);
				if(dgfAcfUsers != null && dgfAcfUsers.size()>0) {
					roleName = LicenseRenewKeys.ROLE_ACF;
				}
			}
			Role role = roleLocalService.getRole(companyId, roleName);
			if(role != null) {
				resourcePermissionLocalService.setResourcePermissions(companyId, DgfRenewLicense.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId(), actionsRW);
			}
		}
		
	} catch (PortalException e) {
		log.error("added duplicate permission error===" + e.getMessage());
	}
	
}

	public Date dateMaker(String dateStr) {
		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateobj = null;
				dateobj = dateformater.parse(dateStr);
				return dateobj;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
