 <%@ include file="/init.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ page import="java.text.SimpleDateFormat" %>

 
 <%

	DgfFglLicDtls licDtlsObj = (DgfFglLicDtls) request.getAttribute("dgfFglLicDtlsObj");
	licnsUserRegs userRegsObj = (licnsUserRegs) request.getAttribute("userRegsObj");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
	User currentUser = (User) request.getAttribute("currentUser");
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
 <title>Document</title>
</head>
<body>
 <div class="px-md-5 px-sm-3 px-1">
 <hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0"><liferay-ui:message key="food-grain-license"/></span>
        <span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>

                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
  
   <div>
     <p>
       <liferay-ui:message key="food-grain-license-no"/><span class="ps-5 ms-4 fw-bold">:</span>
       <span class="fw-bold">
        <%
							 	if (licDtlsObj != null) {
							 %> <%=licDtlsObj.getFoodgrainLicenseNo() %> <%
							 	} else {
							 %> <liferay-ui:message key='no-data-found'/> <%
							 	}
							 %>
       
       </span>
     </p>
     <p>
       <liferay-ui:message key="food-grain-license-date-of-issue"/>
       <span class="ps-1 fw-bold">:</span>
       <span class="fw-bold">
       
         <%
							 	if (licDtlsObj != null) {
							 %> <%=newFormat.format(licDtlsObj.getFoodgrainLicenseIssueDate())%> <%
							 	} else {
							 %> <liferay-ui:message key='no-data-found'/> <%
							 	}
							 %>
       </span>
     </p>
     <p>
       <liferay-ui:message key="food-grain-license-expiry-date"/><span class="ps-3 fw-bold">:</span>
       <span class="fw-bold">
         <%
							 	if (licDtlsObj != null) {
							 %> <%=newFormat.format(licDtlsObj.getFoodgrainLicenseExpiryDate())%> <%
							 	} else {
							 %><liferay-ui:message key='no-data-found'/><%
							 	}
							 %>
       
       </span>
     </p>
        <a   href="food-grain-license-registration-forms"
       class="green-bg border-0 me-3 btn text-uppercase my-2 py-2 "
     >
      <liferay-ui:message key="new-license"/>
     </a>
     <a href="/renew-license"
       class="green-bg border-0 me-3 btn text-uppercase my-2"
     >
       <liferay-ui:message key="license-renewal"/>
     </a>

     <a href="/duplicate-license-form"

       class="green-bg border-0 btn me-3 text-uppercase my-2"
     >
       <liferay-ui:message key="duplicate-license"/>
     </a>
     <p class="text-danger fw-bold">
       <liferay-ui:message key="please-collect-your-license-from-dg-food-office"/>
     </p>
   </div>
 </div>
</body>
</html>