<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:renderURL var="renderURL">
</portlet:renderURL>
<%
	long userNotificationArchived = (long) renderRequest.getAttribute("userNotificationArchived");
	long userNotificationNotArchived = (long) renderRequest.getAttribute("userNotificationNotArchived");	

	PieChartConfig _pieChartConfig = new PieChartConfig();
	
	_pieChartConfig.addColumns(
		new SingleValueColumn("Reviewed", userNotificationArchived),
		new SingleValueColumn("Pending", userNotificationNotArchived)
	);

%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->

<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
</head>
  <body>
  <div class="container pt-2">
  <hr class="mt-0 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">  <%=user.getFirstName() %> <liferay-ui:message key="dashboard"/> <!-- Dcf Dashboard -->
				
				<!--  <liferay-ui:message key="dcf-dashboard"/> -->
				</span> <span
                    class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/><span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
    <div class="row p-2">
        <div class="col-md-12">
         <chart:pie
  config="<%= _pieChartConfig %>"
/>
        </div>
      </div>
       </div>
  </body>
</html>
