package bd.gov.dgfood.dealer.registration.application.list.portlet.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTransition;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.application.list.constants.DgfoodDealerRegistrationApplicationListPortletKeys;
import bd.gov.dgfood.dealer.registration.application.list.portlet.service.DgfoodDealerRegistrationApplicationListPortletService;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalService;

/**
 * @author Hp
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=dgfood-dealer-registration",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodDealerRegistrationApplicationList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dealer-registration-application-list.jsp",
		"javax.portlet.name="
				+ DgfoodDealerRegistrationApplicationListPortletKeys.DGFOODDEALERREGISTRATIONAPPLICATIONLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DgfoodDealerRegistrationApplicationListPortletAction extends MVCPortlet {
	@Reference
	DgfoodDealerRegistrationApplicationListPortletService dgfoodDealerRegistrationApplicationListPortletService;
	@Reference
	DgfUsersLocalService dgfUsersLocalService;
	@Reference
	DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService;
	@Reference
	dgfLocUnionLocalService _dgfLocUnionLocalService;
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		DgfUsersAddrDtls userAddrs = null ; 
		List<dgfLocUnion> unionList = new ArrayList<dgfLocUnion>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		
		try {
			User currentUser = themeDisplay.getUser();
			long currentUserId = currentUser.getUserId();
			DgfUsers dgfUser = dgfUsersLocalService.getDgfUsers(currentUserId);
			userAddrs = dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(dgfUser.getPresentAddrId());
		} catch (PortalException e) {
			log.error("Dgf User Not Logged In===" + e.getMessage());
		}
		if (userAddrs != null) {
			unionList = _dgfLocUnionLocalService.getsubDisWiseUn(userAddrs.getUpzilla());
		}
		
		List<Map<String, Object>> dlrApplcList = dgfoodDealerRegistrationApplicationListPortletService
				.getActionRequestData(renderRequest);
		renderRequest.setAttribute("dlrApplcList", dlrApplcList);
		renderRequest.setAttribute("unionList", unionList);
		renderRequest.setAttribute("languageId", languageId);
		super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name="detailView")
	public void detailView(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String dgfDlrRegDltsNid = ParamUtil.getString(actionRequest, "dgfDlrRegDltsNid");
		Map<String, Object> dealerData = dgfoodDealerRegistrationApplicationListPortletService.getDealerDetailView(dgfDlrRegDltsNid);
		actionRequest.setAttribute("dealerData", dealerData);
		String languageId = themeDisplay.getLanguageId();
		actionRequest.setAttribute("languageId", languageId);
		
		String dgfDlrRegDltsPrimaryId = ParamUtil.getString(actionRequest, "dgfDlrRegDltsPrimaryId");
		actionRequest.setAttribute("dgfDlrRegDltsPrimaryId", dgfDlrRegDltsPrimaryId);
		
		getWorkFlowTransition(actionRequest, Long.valueOf(dgfDlrRegDltsPrimaryId), DgfDlrRegDtls.class.getName(), dealerData);
		actionRequest.setAttribute(getMVCPathAttributeName(actionResponse.getNamespace()), "/dealer-registration-application-details.jsp");

	}
	
	@ProcessAction(name = "approvedDealerLicense")
	public void approvedLicense(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException, PortletException {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			completeWorkFlow(actionRequest, themeDisplay);
	}
	
	private void completeWorkFlow(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		long companyId = ParamUtil.getLong(actionRequest, "companyId", 0);
		long workflowInstanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId", 0);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId", 0);
		String transitionName = ParamUtil.getString(actionRequest, "transitionName", "");
		String comments = ParamUtil.getString(actionRequest, "comments", "");
		try {
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceId);
			WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, themeDisplay.getUserId(), workflowTaskId,
					themeDisplay.getUserId(), comments, null, instance.getWorkflowContext());
			WorkflowTaskManagerUtil.completeWorkflowTask(companyId,
					themeDisplay.getUserId(), workflowTaskId, transitionName, comments, instance.getWorkflowContext());
		} catch (PortalException e) {
			log.error("completeTask error================" + e.getMessage());
		}
	}

	private void getWorkFlowTransition(ActionRequest actionRequest, long id, String resourceName,
			Map<String, Object> detailedDataList) {
		WorkflowInstanceLink instanceLink;
		try {
			long companyId = (long) detailedDataList.get("companyId");
			actionRequest.setAttribute("companyId", companyId);
			long groupId = (long) detailedDataList.get("groupId");
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, groupId,
					resourceName, id);
			actionRequest.setAttribute("workflowInstanceId", instanceLink.getWorkflowInstanceId());
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
					instanceLink.getWorkflowInstanceId());
			List<Integer> assignLogTypes = new ArrayList<>();
			assignLogTypes.add(WorkflowLog.TASK_ASSIGN);

			List<WorkflowLog> wfAssignLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId,
					instance.getWorkflowInstanceId(), assignLogTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

			if (wfAssignLogs != null && wfAssignLogs.size() > 0) {
				long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
				actionRequest.setAttribute("workflowTaskId", wfTaskId);
				List<WorkflowTransition> tasks = WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(wfTaskId);
				actionRequest.setAttribute("tasks", tasks);
			}
		} catch (PortalException e) {
			log.error("get task error================" + e.getMessage());
		}
	}
}