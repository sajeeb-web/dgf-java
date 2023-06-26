package bd.gov.dgfood.food.grain.license.duplicate.portlet.service;

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

import bd.gov.dgfood.food.grain.license.duplicate.constants.LicenseDuplicateKeys;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalService;

@Component(service = LicenseDuplicatePortletService.class)

public class LicenseDuplicatePortletService {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	DgfDuplctLicnsReasonLocalService dgfDuplctLicnsReasonLocalService;
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

	public DgfDuplctLicnsReason getActionRequestData(ActionRequest actionRequest)
			throws PortalException, ParseException {

		String licenseNo = ParamUtil.getString(actionRequest, "licenseNo");
		String licDateStr = ParamUtil.getString(actionRequest, "licenseExpiryDate");
		String tradeLicenseNo = ParamUtil.getString(actionRequest, "tradeLicenseNo");
		String tradeLicDateStr = ParamUtil.getString(actionRequest, "tradeLicenseExpiryDate");
		String duplicateLicenseReasonDisplay = ParamUtil.getString(actionRequest, "reasonOfDuplicateLicenseIssue");
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
				
				List<DgfDuplctLicnsReason> dgfDuplctLicnsStatusChk = dgfDuplctLicnsReasonLocalService.getDgfDupLicByNationalIdAndLicense(nationalId, licenseNo);
		
				boolean statusFlag = false;
				
				for (DgfDuplctLicnsReason dupLicenseReason : dgfDuplctLicnsStatusChk) {
				    int status = dupLicenseReason.getStatus();

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

					DgfDuplctLicnsReason dgfDuplctLicnsReasonObj = duplicateLicense(actionRequest, dgfFglLicDtlsObj,
							dgfUserId, nationalId, licenseNo, licenseExpiryDate, tradeLicenseNo, tradeLicenseExpiryDate,
							duplicateLicenseReasonDisplay, tradeDocId, paymentDocId, comments);
					// add workflow
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					addWorkflow(actionRequest, dgfUserId, dgfDuplctLicnsReasonObj, themeDisplay);
					//send message to user
					String licenseMessage = DgfFglPreDtlsLocalServiceUtil.getDuplicateLicenseFormSubmitMessage();
					String message = licenseMessage+ " #"+dgfDuplctLicnsReasonObj.getApplicationNo();
					// send message to renew license user
					DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
							message, dgfUser.getNationalId(), dgfUser.getMobileNo(), dgfUser.getUserId(),
							Long.parseLong(dgfDuplctLicnsReasonObj.getApplicationNo()));
					return dgfDuplctLicnsReasonObj;
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

	public DgfDuplctLicnsReason duplicateLicense(ActionRequest actionRequest, DgfFglLicDtls dgfFglLicDtlsObj,
			long dgfUserId, String nationalId, String licenseNo, Date licenseExpiryDate, String tradeLicenseNo,
			Date tradeLicenseExpiryDate, String duplicateLicenseReasonDisplay, long tradeDocId, long paymentDocId,
			String comments) throws ParseException {

		List<DgfDuplctLicnsReason> dgfDuplctLicnsStatusChk = dgfDuplctLicnsReasonLocalService.getDgfDupLicByNationalIdAndLicense(nationalId, licenseNo);
		long currentTimeMillis = System.currentTimeMillis();
		String applicationNo = dgfFglLicDtlsObj.getNationalId().substring(dgfFglLicDtlsObj.getNationalId().length() - 4)
				+ currentTimeMillis;
		long duplicateLicenseReasonId = counterLocalService.increment(DgfDuplctLicnsReason.class.getName());
		DgfDuplctLicnsReason dgfDuplicateLicObj = dgfDuplctLicnsReasonLocalService
				.createDgfDuplctLicnsReason(duplicateLicenseReasonId);
		boolean statusFlag = false;
		for (DgfDuplctLicnsReason dupLicenseReason : dgfDuplctLicnsStatusChk) {
		    int status = dupLicenseReason.getStatus();

		    if (status == 1) {
		        statusFlag = true; 
		    }
		}
		
		if(!statusFlag) {
			dgfDuplicateLicObj.setUserId(dgfUserId);
			dgfDuplicateLicObj.setNationalId(nationalId);
			if (licenseNo.equals(dgfFglLicDtlsObj.getFoodgrainLicenseNo())) {
				dgfDuplicateLicObj.setLicenseNo(licenseNo);
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dgfLicExpdate = dateFormat.parse(dateFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate()));
			Date dgfTradeLicExpdate = dateFormat.parse(dateFormat.format(dgfFglLicDtlsObj.getTradeLicenseExpiryDate()));

			if (licenseExpiryDate.equals(dgfLicExpdate)) {
				dgfDuplicateLicObj.setLicenseExpiryDate(licenseExpiryDate);

			}
			if (tradeLicenseNo.equals(dgfFglLicDtlsObj.getTradeLicenseNo())) {
				dgfDuplicateLicObj.setTradeLicenseNo(tradeLicenseNo);
			}
			if (tradeLicenseExpiryDate.equals(dgfTradeLicExpdate)) {
				dgfDuplicateLicObj.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
			}
			dgfDuplicateLicObj.setTradeLicAttchId(tradeDocId);
			dgfDuplicateLicObj.setPaymentAttchId(paymentDocId);
			dgfDuplicateLicObj.setApplicationNo(applicationNo);
			dgfDuplicateLicObj.setFglPrePrimaryId(dgfFglLicDtlsObj.getFglPrePrimaryId());
			dgfDuplicateLicObj.setLicenseApplicationType("Duplicate");
			dgfDuplicateLicObj.setStatus(1);
			dgfDuplicateLicObj.setDuplicateLicenseReasonDisplay(duplicateLicenseReasonDisplay);
			dgfDuplicateLicObj.setComments(comments);
			dgfDuplicateLicObj.setCreatedDate(dgfDuplicateLicObj.getModifiedDate());
			dgfDuplctLicnsReasonLocalService.addDgfDuplctLicnsReason(dgfDuplicateLicObj);
			dgfDuplicateLicObj.setCreatedDate(dgfDuplicateLicObj.getModifiedDate());
			dgfDuplctLicnsReasonLocalService.updateDgfDuplctLicnsReason(dgfDuplicateLicObj);

			addDuplicateLicensePermission(dgfDuplicateLicObj, nationalId);
			return dgfDuplicateLicObj;
		}else {
			log.error("dgfDuplicateLicObj is null");
		}
		return null;

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

	private void addDuplicateLicensePermission(DgfDuplctLicnsReason duplctLicnsReason, String nationalId) {
		try {
			DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(Long.valueOf(nationalId));
			DgfBussAddrDtls dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			long companyId = dgfFglPreDtls.getCompanyId();
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			String roleName = LicenseDuplicateKeys.ROLE_DCF;
			String primKey = duplctLicnsReason.getDuplicateLicenseReasonID()+ StringPool.UNDERLINE +LicenseDuplicateKeys.DISTRICT_FIRST_LETTER+dgfBussAddrDtls.getBusinessDistrict();
			String businessType = dgfFglPreDtls.getBusinessType();
			if(businessType != null) {
				if(LicenseDuplicateKeys.ATTACHAKKI.equals(businessType.toUpperCase()) || LicenseDuplicateKeys.RETAILERS.equals(businessType.toUpperCase())) {
					roleName = LicenseDuplicateKeys.ROLE_UCF;
					 primKey = duplctLicnsReason.getDuplicateLicenseReasonID()+ StringPool.UNDERLINE +LicenseDuplicateKeys.UPAZILLA_FIRST_LETTER+dgfBussAddrDtls.getBusinessUpzilla();
				} else {
					List<DgfUsers> dgfAcfUsers = dgfUsersLocalService.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(), companyId);
					if(dgfAcfUsers != null && dgfAcfUsers.size()>0) {
						roleName = LicenseDuplicateKeys.ROLE_ACF;
					}
				}
			}
			
			Role role = roleLocalService.getRole(companyId, roleName);
			if(role != null) {
				resourcePermissionLocalService.setResourcePermissions(companyId, DgfDuplctLicnsReason.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL,primKey, role.getRoleId(), actionsRW);
			}
		} catch (PortalException e) {
			log.error("added duplicate permission error===" + e.getMessage());
		}
		
	}
	
	public void addWorkflow(ActionRequest actionRequest,long userId,DgfDuplctLicnsReason dgfDuplctLicnsReason, ThemeDisplay themeDisplay) throws PortalException {
		//workflow starting
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DgfDuplctLicnsReason.class.getName(), actionRequest);
        long groupId = themeDisplay.getScopeGroupId();
        long companyId = themeDisplay.getCompanyId();
        int status = WorkflowConstants.STATUS_PENDING;
    	serviceContext.setScopeGroupId(groupId);
    	serviceContext.setCompanyId(companyId);
    	serviceContext.setUserId(themeDisplay.getUserId());
    	String className = DgfDuplctLicnsReason.class.getName();
    	// update status
    	dgfDuplctLicnsReasonLocalService.updateStatus(userId, dgfDuplctLicnsReason.getDuplicateLicenseReasonID(), status, serviceContext);
        
        AssetEntry assetEntry = assetEntryLocalService.updateEntry( themeDisplay.getUserId(), serviceContext.getScopeGroupId(), new Date(),
                new Date(), className,dgfDuplctLicnsReason.getPrimaryKey(), null, 0, null, null, true, false, new Date(), null,
                new Date(), null, ContentTypes.TEXT_HTML, dgfDuplctLicnsReason.getApplicationNo(), dgfDuplctLicnsReason.getApplicationNo(), null, null, null, 0, 0, null);

        WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, dgfDuplctLicnsReason.getUserId(), className,
        		dgfDuplctLicnsReason.getPrimaryKey(), dgfDuplctLicnsReason, serviceContext);
	}
}
