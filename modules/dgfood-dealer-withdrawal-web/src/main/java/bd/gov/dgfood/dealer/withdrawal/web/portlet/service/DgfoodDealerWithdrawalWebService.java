package bd.gov.dgfood.dealer.withdrawal.web.portlet.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalService;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;

@Component(service = DgfoodDealerWithdrawalWebService.class)
public class DgfoodDealerWithdrawalWebService {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private DgfDlrWithdrawalLocalService dgfDlrWithdrawalLocalService;
	
	@Reference
	AssetEntryLocalService assetEntryLocalService;
	
	public void addWorkflow(ActionRequest actionRequest,DgfDlrWithdrawal dgfDlrWithdrawal, ThemeDisplay themeDisplay) throws PortalException {
		log.info("DgfoodDealerWithdrawalWebService.addWorkflow  START");
		DgfUsers dgfUsers = null;
		try {
			// get userID 
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		if (Validator.isNotNull(dgfUsers)){
			String className = DgfDlrWithdrawal.class.getName();
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			int status = WorkflowConstants.STATUS_PENDING;
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(className, actionRequest);
	        serviceContext.setScopeGroupId(groupId);
			serviceContext.setCompanyId(companyId);
			serviceContext.setUserId(userId);

			dgfDlrWithdrawal.setUserId(userId);
			dgfDlrWithdrawal.setGroupId(groupId);
			dgfDlrWithdrawal.setCompanyId(companyId);
			dgfDlrWithdrawalLocalService.updateDgfDlrWithdrawal(dgfDlrWithdrawal);
	    	// update status
			dgfDlrWithdrawalLocalService.updateStatus(userId, dgfDlrWithdrawal.getPrimaryKey(), status, serviceContext);
	    	// start workflow for dgfDlrRegDtls
	    	AssetEntry assetEntry = assetEntryLocalService.updateEntry( userId, groupId, new Date(),
	                new Date(), className, dgfDlrWithdrawal.getPrimaryKey(), null, 0, null, null, true, false, new Date(), null,
	                new Date(), null, ContentTypes.TEXT_HTML, dgfDlrWithdrawal.getLicenseNo(), dgfDlrWithdrawal.getLicenseNo(), null, null, null, 0, 0, null);
	    	//workflow starting
	        WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, className,
	        		dgfDlrWithdrawal.getPrimaryKey(), dgfDlrWithdrawal, serviceContext);
		}
        log.info("DgfoodDealerWithdrawalWebService.addWorkflow END");
	}
	
	/**
	 * This method retrieves the detailed view of a specific withdrawal application.
	 *
	 * @param dgfDlrWithdrawalNid: the national ID of the withdrawal application to
	 *                             be viewed
	 * @return a Map containing details of the specific withdrawal application
	 * @getdgfDlrWithdrawalDltsData :(Local service impl)  details of the specific withdrawal application by national ID (getdgfDlrWithdrawalDltsData )
	 */
	
	public Map<String, Object> getWithdrawalDetailView( long dlrWithdrawalId) {
	
		/** @getdgfDlrWithdrawalDltsData */
		Map<String, Object> dealerWithdrawalData = dgfDlrWithdrawalLocalService
				.getDgfDlrWithdrawalDltsData(dlrWithdrawalId);
		// Return the details of the withdrawal application
		return dealerWithdrawalData;
	}
	
}
