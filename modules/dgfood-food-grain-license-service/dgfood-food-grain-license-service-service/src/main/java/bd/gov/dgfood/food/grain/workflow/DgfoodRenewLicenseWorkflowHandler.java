package bd.gov.dgfood.food.grain.workflow;

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

import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalService;

@Component(immediate = true, service = WorkflowHandler.class)
public class DgfoodRenewLicenseWorkflowHandler extends BaseWorkflowHandler<DgfRenewLicense> {
	
	private ResourceActions _resourceActions;
	
	@Reference(unbind = "-")
    protected void setResourceActions(ResourceActions resourceActions) {

        _resourceActions = resourceActions;
    }
	
	private DgfRenewLicenseLocalService _dgfRenewLicenseLocalService;
	
	@Reference(unbind = "-")
    protected void setWorkflowRndLocalService(
    		DgfRenewLicenseLocalService dgfRenewLicenseLocalService) {

		_dgfRenewLicenseLocalService = dgfRenewLicenseLocalService;
    }
	

	@Override
	public String getClassName() {
		return DgfRenewLicense.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public DgfRenewLicense updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong(
	            (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	        long resourcePrimKey = GetterUtil.getLong(
	            (String)workflowContext.get(
	                WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

	        ServiceContext serviceContext = (ServiceContext)workflowContext.get(
	            "serviceContext");

	        return _dgfRenewLicenseLocalService.updateStatus(
	            userId, resourcePrimKey, status, serviceContext);
	}

}