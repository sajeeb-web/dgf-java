<%@ include file="init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>
<portlet:defineObjects />
 <!DOCTYPE html>
 <html lang="en">
 <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

 </head>
 <body>
    <div class="px-5">      
        <hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">
				<liferay-ui:message key="food-grain-license-registration" />
				</span> 
				<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>

                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
        
        <div class="container">
                 <div
            class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-4"
          >
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="15"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
              <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="15"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="20"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="20"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="20"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
          </div>
          <div
            class="card w-75 m-auto mt-5 py-4 px-4 text-center d-flex justify-content-center align-items-center"
          >
            <div class="pro-circle">
              <i class="bi bi-person-check fs-1"></i>
            </div>
            <h5 class="green-text my-3">
            <liferay-ui:message key="dealer-registration-application-successfully-submitted" />
              <!-- Food Grain License Application Submitted Successfully  -->
            </h5>
            <h6 class="fw-normal">

            <liferay-ui:message key="your-application-no" />
              <!-- Your application no. is --> <span class="fw-bold"><%=renderRequest.getAttribute("dlrRegAppLNo") %></span>
            </h6>
             <a href="/fgl-user-dashboard" class="btn green-bg mt-3">
                <liferay-ui:message key="dashboard" /> <i class="icon-circle-arrow-right"></i>
             </a>
          </div>
        </div>
      </div>
    
 </body>
 </html>