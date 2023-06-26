package bd.gov.dgfood.dealer.registration.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalService;


@Component(immediate = true, service = WorkflowHandler.class)
public class DgfoodDealerWithdrawalWorkflowHandler extends BaseWorkflowHandler<DgfDlrWithdrawal>{
	
private ResourceActions _resourceActions;
	
	@Reference(unbind = "-")
    protected void setResourceActions(ResourceActions resourceActions) {

        _resourceActions = resourceActions;
    }
	
	private DgfDlrWithdrawalLocalService _dgfDlrWithdrawalLocalService;
	
	@Reference(unbind = "-")
    protected void setWorkflowRndLocalService(
    		DgfDlrWithdrawalLocalService dgfDlrWithdrawalLocalService) {

		_dgfDlrWithdrawalLocalService = dgfDlrWithdrawalLocalService;
    }
	
	@Override
	public String getClassName() {
	    return DgfDlrWithdrawal.class.getName();
	}
	
	@Override
	public String getType(Locale locale) {
	    return _resourceActions.getModelResource(locale, getClassName());
	}
	
	@Override
	public DgfDlrWithdrawal updateStatus(
	        int status, Map<String, Serializable> workflowContext)
	    throws PortalException {

	    long userId = GetterUtil.getLong(
	        (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	    long classPK = GetterUtil.getLong(
	        (String)workflowContext.get(
	            WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

	    ServiceContext serviceContext = (ServiceContext)workflowContext.get(
	        WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

	    return _dgfDlrWithdrawalLocalService.updateStatus(
	        userId, classPK, status, serviceContext);
	}
	
}
