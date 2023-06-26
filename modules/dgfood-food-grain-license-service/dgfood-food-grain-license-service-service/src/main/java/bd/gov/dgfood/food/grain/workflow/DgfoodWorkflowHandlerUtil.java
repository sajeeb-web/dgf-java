package bd.gov.dgfood.food.grain.workflow;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;

import java.util.List;

public class DgfoodWorkflowHandlerUtil {
	private static Log log = LogFactoryUtil.getLog(DgfoodWorkflowHandlerUtil.class);

	public static void preparedPayloadAndSendUserNotification(long userId, long companyId, long groupId, String entryType, long classPK, String className, long workflowInstanceId, long workflowTaskId, String notificationMessage) {
		log.info("DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification START");
		String type = "com_liferay_portal_workflow_task_web_portlet_MyWorkflowTaskPortlet"; // Replace with a unique identifier for your notification
		long timestamp = System.currentTimeMillis(); // Replace with the timestamp of the notification
		int deliveryType = UserNotificationDeliveryConstants.TYPE_WEBSITE; // Replace with the delivery type of your choice
		long deliverBy = 0; // Use the default delivery deadline
		// prepared payload
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("entryType", entryType);
		jsonObject.put("companyId", companyId);
		jsonObject.put("entryClassPK", classPK);
		jsonObject.put("entryClassName", className);
		jsonObject.put("groupId", groupId);
		jsonObject.put("workflowTaskId", workflowTaskId);
		jsonObject.put("notificationMessage", notificationMessage);
		jsonObject.put("ctCollectionId", "0");
		jsonObject.put("userId", userId);
		jsonObject.put("workflowInstanceId", workflowInstanceId);
		jsonObject.put("url", "");
		String payload = jsonObject.toString();
		try {
			ServiceContext serviceContext = new ServiceContext();
		    UserNotificationEvent userNotificationEvent =
		        UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, type, timestamp, deliveryType, deliverBy, payload, false, serviceContext);
		} catch (PortalException | SystemException e) {
		    log.error("ERROR: "+e.getMessage());
		}
		log.info("DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification END");
	}
	
	
	public static long getWorkflowInstanceIdByUserIdAndClassPK(long userId, long classPk) throws PortalException {
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK START");
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		DynamicQuery dynamicQuery = WorkflowInstanceLinkLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("classPK", classPk));
		long workflowInstanceId = 0;
		List<WorkflowInstanceLink> workflowInstanceLinkObjList = WorkflowInstanceLinkLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(workflowInstanceLinkObjList) && workflowInstanceLinkObjList.size() > 0) {
			for (WorkflowInstanceLink workflowInstanceLinkObj : workflowInstanceLinkObjList) {
				if (workflowInstanceLinkObj.getClassPK() == classPk) {
					workflowInstanceId = workflowInstanceLinkObj.getWorkflowInstanceId();
					break;
				}
			}
		}
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK END");
		return workflowInstanceId;
	}
	
	public static WorkflowTask getWorkflowTaskByCompanyIdAndWorkflowInstanceId(long companyId, long workflowInstanceId)
			throws PortalException {
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowTaskByCompanyIdAndWorkflowInstanceId START");
		// get the current workflow task for the workflow instance
		List<WorkflowTask> workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);

		WorkflowTask workflowTask = null;

		for (WorkflowTask workflowTaskObj : workflowTasks) {
			if (workflowTaskObj.getWorkflowInstanceId() == workflowInstanceId) {
				workflowTask = workflowTaskObj;
				break;
			}
		}
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowTaskByCompanyIdAndWorkflowInstanceId END");
		return workflowTask;
	}
	
	public static long getWorkflowTaskIdByNode(String nodeId, long companyId, long workflowInstanceId) {
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode START");
		long workflowTaskId = 0;
		DynamicQuery dynamicQuery = KaleoLogLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoInstanceId", workflowInstanceId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoNodeName", nodeId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("type", "TASK_ASSIGNMENT"));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));

		List<KaleoLog> kaleoLogList = KaleoLogLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(Validator.isNotNull(kaleoLogList) && kaleoLogList.size()>0) {
			for (KaleoLog kaleoLog : kaleoLogList) {
				workflowTaskId = kaleoLog.getKaleoTaskInstanceTokenId();
				if(workflowTaskId>0) {
					break;
				}
			}
		}
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode END");
		return workflowTaskId;
	}
	
	public static String getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(long workflowInstanceId, long companyId, String nodeId) {
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId START");
		String comments = "";
		// find workflow comments from KaleoLog
		DynamicQuery dynamicQuery = KaleoLogLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoInstanceId", workflowInstanceId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoNodeName", nodeId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("type", "TASK_COMPLETION"));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		List<KaleoLog> kaleoLogList = KaleoLogLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(Validator.isNotNull(kaleoLogList) && kaleoLogList.size()>0) {
			for (KaleoLog kaleoLog : kaleoLogList) {
				comments = kaleoLog.getComment();
			}
		}
		log.info("DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId END");
		return comments;
	}

}
