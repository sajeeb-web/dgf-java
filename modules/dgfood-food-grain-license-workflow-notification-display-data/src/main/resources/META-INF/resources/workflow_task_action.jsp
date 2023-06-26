<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<style type="text/css">




.my-class{
display:flex;
}
.green-text {
	color: #5bb600;
}

.green-bg {
	background-color: #61c002 !important;
	color: #fff !important;
	margin:4px 1px 9px 1px;
}

.green-bg:hover {
	background-color: #428203 !important;
}

.main-body-list {
	padding: 0 30px;
	display: flex;
}

.text14 {
	font-size: 14px;
}

.h-icon-circle {
	width: 40px;
	height: 40px;
	background-color: #7cc533;
	margin-right: 10px;
	cursor: pointer;
}

.h-icon-circle i>span {
	font-size: 8px;
	top: 15px;
	margin-left: -10px;
}

.pending-card {
	background-color: #fffcd3 !important;
	color: #ffee00 !important;
}

.prog-circle {
	width: 20px;
	height: 20px;
	border-radius: 50%;
	z-index: 2;
}

.prog-hr {
	height: 3px;
	width: 30%;
	margin-left: -3px;
	background-color: #3b3535;
}

.main-div {
	padding: 0 2rem;
}

.user_avatar {
	background-color: #d6d4d4;
	width: 100%;
	height: 120px;
	margin-top: 25px;
	display: flex;
	justify-content: center;
	align-items: center;
	color: #fff;
}

.user_avatar i {
	font-size: 50px;
}

li {
	list-style: none;
}

ol, ul {
	padding-left: 0 !important;
}

.alignMe span::after {
	content: " : ";
}

.up-files {
	width: 150px;
	height: 45px;
	background-color: gray;
	object-fit: cover;
	display: block;
}

.captcha {
	width: 150px;
	height: 45px;
	color: #fff;
	padding: 10px;
}

.pending-card {
    background-color: #fffcd3 !important;
    color: #ffee00 !important;
}
.rejected-card {
    background-color: #FFC9C9 !important;
    color: #ffee00 !important;
}
.reviewed-card {
    background-color: #98FB98 !important;
    color: #ffee00 !important;
}
.mark{
background-color: #bcf4bc !important;
    border-radius: 5px;
    font-size: 14px;
    padding: 6px 15px 6px 15px;
}
.mark:hover{
background-color: #c8f8c8 !important;;
   border-radius: 5px;
    font-size: 14px;
    padding: 6px 15px 6px 15px;
}

@media screen and (max-width: 600px) {
	.move-content {
		display: flex;
		justify-content: space-between;
	}
	* {
		font-size: 11px;
	}
}

@media screen and (max-width: 600px) {
	.main-div {
		padding: 1rem;
	}
	* {
		font-size: 12px;
	}
	.card_body {
		padding: 5px 10px !important;
	}
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<%
	String randomId = workflowTaskDisplayContext.getWorkflowTaskRandomId();

	String closeRedirect = ParamUtil.getString(request, "closeRedirect");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();

	PortletURL redirectURL = PortletURLBuilder.createRenderURL(renderResponse).setMVCPath("/view.jsp")
			.buildPortletURL();
%>

<liferay-ui:icon-menu
	cssClass=" text-center list-unstyled my-class center-block text-dark"
	message="<%=StringPool.BLANK%>" showExpanded="<%=row == null%>">

	<span
		cssClass=" text-center list-unstyled my-class center-block bg-trans notify-btn"
		direction="center-block" icon="<%=StringPool.BLANK%>"
		markupView="lexicon" message="<%=StringPool.BLANK%>"
		showExpanded="<%=row == null%>"> <c:if
			test="<%=!workflowTask.isCompleted()%>">
			<c:choose>
				<c:when
					test="<%=workflowTaskDisplayContext.isAssignedToUser(workflowTask)%>">

					<%
						for (WorkflowTransition workflowTransition : workflowTaskDisplayContext
												.getWorkflowTaskWorkflowTransitions(workflowTask)) {
					%>

					<liferay-portlet:actionURL
						copyCurrentRenderParameters="<%=false%>"
						name="/portal_workflow_task/complete_task"
						portletName="<%=PortletKeys.MY_WORKFLOW_TASK%>" var="editURL">
						<portlet:param name="mvcPath" value="/edit_workflow_task.jsp" />
						<portlet:param name="redirect"
							value="<%=redirectURL.toString()%>" />
						<portlet:param name="closeRedirect" value="<%=closeRedirect%>" />
						<portlet:param name="workflowTaskId"
							value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
						<portlet:param name="assigneeUserId"
							value="<%=String.valueOf(workflowTask.getAssigneeUserId())%>" />

						<c:if
							test="<%=Validator.isNotNull(workflowTransition.getName())%>">
							<portlet:param name="transitionName"
								value="<%=workflowTransition.getName()%>" />
						</c:if>

					</liferay-portlet:actionURL>

					<liferay-ui:icon
						cssClass='<%="workflow-task-" + randomId + " task-change-status-link  notify-btn "%>'
						data="<%=workflowTaskDisplayContext.getWorkflowTaskActionLinkData()%>"
						id='<%=randomId + HtmlUtil.escapeAttribute(workflowTransition.getName())
										+ "taskChangeStatusLink"%>'
						message="<%=workflowTransition.getLabel(workflowTaskDisplayContext.getTaskContentLocale())%>"
						method="get" url="<%=editURL%>" />


					<%
						}
					%>

				</c:when>
				<c:otherwise>
					<liferay-portlet:renderURL
						copyCurrentRenderParameters="<%=false%>" var="assignToMeURL"
						windowState="<%=LiferayWindowState.POP_UP.toString()%>">
						<portlet:param name="mvcPath" value="/workflow_task_assign.jsp" />
						<portlet:param name="redirect"
							value='<%=Validator.isNull(request.getParameter("workflowTaskId"))
										? redirectURL.toString()
										: currentURL%>' />
						<portlet:param name="workflowTaskId"
							value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
						<portlet:param name="assigneeUserId"
							value="<%=String.valueOf(user.getUserId())%>" />
						<portlet:param name="assignMode" value="assignToMe" />
					</liferay-portlet:renderURL>
					
					
					<liferay-ui:icon
				cssClass=" notify-btn"
					message="assign-to-me"
					onClick='<%= "javascript:" + liferayPortletResponse.getNamespace() + "taskAssignToMe('" + assignToMeURL + "');" %>'
					url="javascript:void(0);"
				/>

					<liferay-portlet:renderURL copyCurrentRenderParameters="<%=false%>"
				var="assignURL"
				windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/workflow_task_assign.jsp" />
				<portlet:param name="redirect" value="<%=redirectURL.toString()%>" />
				<portlet:param name="workflowTaskId"
					value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
				<portlet:param name="workflowTaskURL" value="<%=currentURL%>" />
			</liferay-portlet:renderURL>

			<liferay-ui:icon cssClass="notify-btn"
				message="assign-to-..."
				onClick='<%="javascript:" + liferayPortletResponse.getNamespace() + "taskAssign('" + assignURL + "');"%>'
				url="javascript:void(0);" />
				</c:otherwise>
			</c:choose>

		</c:if>
</liferay-ui:icon-menu>

<aui:form name='<%=randomId + "form"%>'>
	<div class="hide" id="<%=randomId%>updateComments">
		<aui:input cols="55" cssClass="task-content-comment" name="comment"
			placeholder="comment" rows="1" type="textarea" />
	</div>
</aui:form>

<script type="text/javascript">

    
    function applyCustomStylesToButtons() {
        var mybtns = document.querySelectorAll('.btns');

        mybtns.forEach(function (btn) {
            var aTag = btn.querySelector('.dropdown-item'); 

            if (aTag) {
            	aTag.style.backgroundColor = '#2A935A';
                aTag.style.borderRadius = '3px';
                aTag.style.borderWidth = '1px';
                aTag.style.clear = 'both';
                aTag.style.color = '#fffff';
                aTag.style.cursor = 'pointer';
                aTag.style.display = 'flex';
                aTag.style.fontWeight = '400';
                aTag.style.overflow = 'hidden';
                aTag.style.padding = '8px 13px';
                aTag.style.position = 'relative';
                aTag.style.textAlign = 'inherit';
                aTag.style.transition = 'none';
                aTag.style.overflowWrap = 'break-word';
                aTag.style.wordWrap = 'break-word';
                aTag.style.fontSize = 'inherit';
            }
        });
    }
    
    
    function applyCustomStylesToNotifyButtons() {
        var notifyBtns = document.querySelectorAll('.notify-btn');

        notifyBtns.forEach(function (btn, index) {
            btn.style.backgroundColor = '#2A935A';
            btn.style.borderRadius = '7px';
            btn.style.color = '#ffffff';
            btn.style.fontWeight = '800';
            btn.style.marginRight='10px'
            btn.style.display = 'inline-block';       
            
            // Apply custom styles to the second notify-btn element
            if (index === 1) { 
                btn.style.backgroundColor = '#FF0000';
            }
        });
    }
    
    
    function applyCustomDropdownStyles() {
    	 var btns1 = document.querySelectorAll('.notify-btn');

    	    btns1.forEach(function (btn1,index) {
    	        var aTag = btn1.querySelector('a'); 

    	        if (aTag) {
    	            aTag.style.color = '#ffffff'; 
    	            aTag.style.backgroundColor = '#2A935A';
    	            aTag.style.borderRadius = '4px';
    	        }
    	        if (index === 1) { 
    	        	aTag.style.backgroundColor = '#FF0000';
    	        	aTag.style.marginRight = '5px';
                }
    	    });
    }

    function applyCustomStylesToBackButtons() {
        var backBtns = document.querySelectorAll('.back-btn');

        backBtns.forEach(function (btn3) {
            btn3.style.backgroundColor = '#C4C4C4';
            btn3.style.color = '#000000';
            btn3.style.display = 'inline-block'; 
            btn3.style.borderRadius = '4px';
            btn3.style.borderWidth = '0px';
            btn3.style.clear = 'both';
            btn3.style.cursor = 'pointer';
            btn3.style.display = 'flex';
            btn3.style.fontWeight = '400';
            btn3.style.overflow = 'hidden';
            btn3.style.padding = '4px 10px';
            btn3.style.position = 'relative';
            btn3.style.textAlign = 'inherit';
            btn3.style.transition = 'none';
            btn3.style.overflowWrap = 'break-word';
            btn3.style.wordWrap = 'break-word';
            btn3.style.fontSize = 'inherit';
            btn3.style.alignContent = 'space-between';
            btn3.style.justifyContent = 'flex-end';
            btn3.style.alignItems = 'center';
            
  
        });
    }
    
    function applyCustomPaddingLeftStyles() {
        var paddingLeftElements = document.querySelectorAll('.paddingleft');

        paddingLeftElements.forEach(function (element) {
            element.style.marginRight = '8px';
            element.style.display = 'inline';
        });
    }



    function applyCustomPaddingRightStyles() {
        var paddingLeftElements = document.querySelectorAll('.paddingRight');

        paddingLeftElements.forEach(function (element) {
            element.style.marginLeft = '8px';
           
        });
    }

    // Run the function when the page is loaded
    document.addEventListener('DOMContentLoaded', applyCustomPaddingRightStyles);
    document.addEventListener('DOMContentLoaded', applyCustomPaddingLeftStyles);
    document.addEventListener('DOMContentLoaded', applyCustomStylesToBackButtons);
    document.addEventListener('DOMContentLoaded', applyCustomDropdownStyles);
    document.addEventListener('DOMContentLoaded', applyCustomStylesToNotifyButtons);
    document.addEventListener('DOMContentLoaded', applyCustomStylesToButtons);

    
</script>


<aui:script use="liferay-workflow-tasks">
	var onTaskClickFn = A.rbind(
		'onTaskClick',
		Liferay.WorkflowTasks,
		'<%=randomId%>'
	);

	<c:if
		test="<%=!workflowTask.isCompleted() && workflowTaskDisplayContext.isAssignedToUser(workflowTask)%>">

		<%
			for (String transitionName : workflowTaskDisplayContext.getTransitionNames(workflowTask)) {
		%>

			Liferay.delegateClick(
				'<portlet:namespace /><%=randomId + HtmlUtil.escapeJS(transitionName)%>taskChangeStatusLink',
				onTaskClickFn
			);

		<%
			}
		%>

	</c:if>
</aui:script>

<aui:script>
	function <portlet:namespace />taskAssign(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 430,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />assignToDialog',
			title: '<liferay-ui:message key="assign-to-..." />',
			uri: uri,
		});
	}

	function <portlet:namespace />taskAssignToMe(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 340,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />assignToDialog',
			title: '<liferay-ui:message key="assign-to-me" />',
			uri: uri,
		});
	}

	function <portlet:namespace />taskUpdate(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 430,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />updateDialog',
			title: '<liferay-ui:message key="update-due-date" />',
			uri: uri,
		});
	}

	function <portlet:namespace />refreshPortlet(uri) {
		location.href = uri;
	}
</aui:script>