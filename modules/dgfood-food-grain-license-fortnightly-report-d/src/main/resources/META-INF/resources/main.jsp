<%@ include file="/init.jsp"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>
<%@ page
	import="bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
<title>DG Food</title>
<%
List<DgfUsersFortnightReportDForm> matchingReports = (List<DgfUsersFortnightReportDForm>) renderRequest
.getAttribute("matchingReports");
PortletSession session1 = renderRequest.getPortletSession();
session1.setAttribute("matchingReports", matchingReports, PortletSession.APPLICATION_SCOPE);
SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
%>

</head>

<body>

	<!-- Display success message -->
	<liferay-ui:success key="formSubmittedSuccessfully"
		message="Fortnight Report Form-D submitted successfully!" />

	<liferay-portlet:renderURL var="generateReportURL">
		<portlet:param name="cmd" value="add" />
	</liferay-portlet:renderURL>


	<div class="container px-md-5 px-sm-3 px-1 text-capitalize">
		<hr class="mt-3 mb-1" />
		<div class="d-flex justify-content-between">
			<span class="fw-bold p-0 m-0"><liferay-ui:message key="fortnightly-report-form-gha" /></span>
			<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>

                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
		</div>
		<hr class="mt-1 mb-3" />
		<div style="background-color: #61c002; color: #ffffff;"
			class="alert d-flex" role="alert">
			<div class="col-md-9 col-sm-12">
				<liferay-ui:message
					key="fortnightly-stock-report-has-to-be-sent-to-dg-food-on-1st-and-16th-of-every-month" />


			</div>
			<div class="col-md-3 col-sm-12">
				<button class="btn btn-light"
					onclick="location.href='${generateReportURL}';">
					<liferay-ui:message key="generate-fortnightly-report" />
				</button>
			</div>
		</div>
		
		
		<%
			String errorMessage = (String) request.getAttribute("showAlert");
			if (errorMessage != null) {
		%>
		<div class="modal fade" id="errorModal" tabindex="-1" role="dialog"
			aria-labelledby="errorModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-danger" id="errorModalLabel"><liferay-ui:message key="error" /></h5>
						<button type="button" class="close text-danger p-2"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true"> X </span>
						</button>
					</div>
					<%-- <div class="modal-body">
						<liferay-ui:message key='<%=errorMessage%>'/>
					</div> --%>
					<div class="modal-body">
						<c:if test="${showAlert == '0'}">
							<liferay-ui:message key="selling-quantity-can-not-be-higher-than-total-stock" />
						</c:if>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal"><liferay-ui:message key="close" /></button>
					</div>
				</div>
			</div>
		</div>

		<aui:script use="jquery">
        $(document).ready(function() {
            $('#errorModal').modal('show');
        });
    </aui:script>
		<%
			}
		%>

		<div class="container-fluid border text-capitalize">

		    <section class="table-responsive p-3">
		        <c:choose>
		            <c:when test="${empty matchingReports}">
		     
		        <div id="modal-placeholder"> <liferay-ui:message key="no-previously-submitted-data-to-show" /></div>
		            </c:when>
		            <c:otherwise>
		                <liferay-ui:search-container delta="10" deltaConfigurable="<%=true%>"
		                    emptyResultsMessage="No previously submitted data to show."
		                    total="<%= matchingReports.size()%>" iteratorURL="<%=currentURLObj %>">
		                    <liferay-ui:search-container-results
		                        results="<%=ListUtil.subList(matchingReports, searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
		                 
		                    <liferay-ui:search-container-row
		                        className="bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm"
		                        modelVar="report">
		                        <liferay-ui:search-container-column-text property="product"
		                            name="product" />
		                        <liferay-ui:search-container-column-text
		                            value="${report.initalStockOn} ${report.initalStockOnUnit}"
		                            name="inital-stock-on" />
		                        <liferay-ui:search-container-column-text
		                            value="${report.recivedQuantity} ${report.recivedQuantityUnit}"
		                            name="received-quantity" />
		                        <liferay-ui:search-container-column-text
		                            value="${report.sellingQuantity} ${report.sellingQuantityUnit}"
		                            name="selling-quantity" />
		                        <liferay-ui:search-container-column-text
		                            value="${report.quantityOfFinishingStock} ${report.quantityOfFinishingStockUnit}"
		                            name="finishing-quantity-stock" />
		
		                        <liferay-ui:search-container-column-text property="comment"
		                            name="comment" />
		                    </liferay-ui:search-container-row>
		                    <liferay-ui:search-iterator />
		                </liferay-ui:search-container>
		            </c:otherwise>
		        </c:choose>
		    </section>
		</div>

	</div>
	<script>
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {
							var dropdownToggle = document
									.querySelector('.lfr-search-container-wrapper .lfr-icon-menu > .dropdown-toggle');
							if (dropdownToggle) {
								dropdownToggle.style.color = '#fff';
							}
						});
	</script>


</body>
</html>
