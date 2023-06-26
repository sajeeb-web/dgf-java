  <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@ include file="init.jsp"%>
<%@ page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>
<%@page import="java.util.List"%>
<%@ page import="javax.portlet.PortletSession"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@page import="bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil"%>
<%@ include file="js/application_list.js"%>

<%
List<Map<String, Object>> fglApplList = (List<Map<String, Object>>) renderRequest
.getAttribute("fglApplList");
PortletSession session1 = renderRequest.getPortletSession();
session1.setAttribute("fglApplList", fglApplList, PortletSession.APPLICATION_SCOPE);
%>


<portlet:renderURL var="searchFglApplicationURL">
</portlet:renderURL>
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<%
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
</head>

<body>

	<div class="p-3 main-body-list">
		<div class="container">

			<hr class="mt-0 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="food-grain-license-list"/></span> <span
					class=" fw-bold p-0m-0"> <liferay-ui:message key="last-login"/><span><fmt:formatDate
							pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> |
				</span> <span><fmt:formatDate type="time" timeStyle="short"
							value="<%=user.getLastLoginDate()%>" /></span></span>
			</div>
			<hr class="mt-1 mb-3" />





			<h6 class="green-text fw-bold mb-2"><liferay-ui:message key="search-filter"/></h6>
			<aui:form action="<%=searchFglApplicationURL%>" name="searchForm"
				method="POST">
				<div class="row p-1">


					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="date-from"/></label>
						<aui:input class="py-1 px-2 w-100" placeholder="Select"
							type="date" id="dateFrom" name="dateFrom" label="" />

					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="date-to"/></label>
						<aui:input class="py-1 px-2 w-100" placeholder="Select"
							type="date" id="dateTo" name="dateTo" label="" />
					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="date-type"/></label>
						<aui:select id="dateType" class="form-select w-100"
							aria-label="Default select example" name="dateType" label="">
							<aui:option selected="true" disabled="true"><liferay-ui:message key="select"/></aui:option>
							<aui:option value="applSubmissionDate"><liferay-ui:message key="application-submission-date"/></aui:option>
							<aui:option value="applStatusUpdateDate"><liferay-ui:message key="application-status-update-date"/></aui:option>
							<%-- <aui:option disabled="true" value="licnsExpDate"><liferay-ui:message key="license-expiry-date"/></aui:option> --%>
						</aui:select>
					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="status"/></label>
						
						<aui:select id="status" class="form-select w-100"
							aria-label="Default select example" name="status" label="">
							
							<aui:option value="1" selected="true">
								<liferay-ui:message key="pending" />
							</aui:option>
							<aui:option value="0">
								<liferay-ui:message key="reviewed" />
							</aui:option>
							<aui:option value="4">
								<liferay-ui:message key="rejected" />
							</aui:option>
							<aui:option value="6">
								<liferay-ui:message key="incomplete" />
							</aui:option>
							<aui:option value="-2">
								<liferay-ui:message key="all" />
							</aui:option>
						</aui:select>
					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="application-no"/></label>
						<aui:input class="py-1 px-2 w-100" placeholder="type-here"
							type="text" id="applicationNo" name="applicationNo" label="" />
					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="type-of-business"/></label>
						<aui:select id="businessType" class="form-select w-100"
							aria-label="Default select example" name="businessType" label="">
							<aui:option value="" label="select-a-business"selected="true" disabled="true"></aui:option>
								<c:choose>
								<c:when test="<%= PrincipalRoleAndLocationUtil.isAcf() || PrincipalRoleAndLocationUtil.isDcf()%>">
								<aui:option value="Importer"><liferay-ui:message key="importer" /></aui:option>
								<aui:option value="WholesalersAndStockists"><liferay-ui:message key="wholesalers-and-Stockists" /></aui:option>
								<aui:option value="MajorFlourMill"><liferay-ui:message key="major-flour-mill" /></aui:option>
								<aui:option value="CompactFlourMill"><liferay-ui:message key="compact-flour-mill" /></aui:option>
								<aui:option value="RollerFlourMill"><liferay-ui:message key="roller-flour-mill" /></aui:option>
								<aui:option value="AutomaticRiceMill"><liferay-ui:message key="automatic-rice-mill" /></aui:option>
								<aui:option value="MajorRiceMill"><liferay-ui:message key="major-rice-mill" /></aui:option>
								<aui:option value="HuskingRiceMill"><liferay-ui:message key="husking-rice-mill" /></aui:option>
								<aui:option value="Dealer"><liferay-ui:message key="dealer" /></aui:option>
								<aui:option value="SemiAutomatic"><liferay-ui:message key="semi-automatic" /></aui:option>
								</c:when>
								<c:when test="<%= PrincipalRoleAndLocationUtil.isUcf()%>">
								<aui:option value="Retailers" show="<%= PrincipalRoleAndLocationUtil.isUcf()%>"><liferay-ui:message key="retailers" /></aui:option>
								<aui:option value="AttaChakki" show="<%= PrincipalRoleAndLocationUtil.isUcf()%>"><liferay-ui:message key="atta-chakki" /></aui:option>
								</c:when>
								<c:otherwise></c:otherwise>
								</c:choose>									
						</aui:select>
					</div>
					<div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1"><liferay-ui:message key="license-application-type"/></label>
						<aui:select id="appLicType" class="form-select w-100"
							aria-label="Default select example" name="appLicType" label="">
							<aui:option selected="true" disabled="true"><liferay-ui:message key="select"/></aui:option>
							<aui:option value="New"><liferay-ui:message key="new"/></aui:option>
							<aui:option value="Renew"><liferay-ui:message key="renewal"/></aui:option>
							<aui:option value="Duplicate"><liferay-ui:message key="duplicate"/></aui:option>
						</aui:select>
					</div>
					<div class="text-danger" id="errorContainer"></div>
					<div class="col-md-2 col-sm-12">
						<div
							class="flex-grow-1 d-flex align-items-center move-content mt-4 pe-2 ">
							<button class="btn green-bg text-light me-2"><liferay-ui:message key="search"/></button>

							<button class="btn btn-reset" id="resetButton"
								name="resetButton"><liferay-ui:message key="reset"/>
								</button>
						</div>
					</div>
				</div>
			</aui:form>

			<div class="mt-3 d-flex justify-content-between align-items-center">

				<h6 class="green-text fw-bold"><liferay-ui:message key="food-grain-license-list"/></h6>
				<a href="<%=resourceURL%>"> <button name="downloadExcel" id="downloadExcel"
					class="btn btn-light">
					<i class="icon-download-alt"></i> <liferay-ui:message key="excel"/>
				</button> </a>

			</div>

<div class="search-container-wrapper">
			<liferay-ui:search-container  delta="10" deltaConfigurable="<%=true%>"
				
				emptyResultsMessage="no-results-found"
				total="<%=fglApplList.size()%>" iteratorURL="<%=currentURLObj %>">


				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(fglApplList, searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
				
				<%-- <liferay-ui:search-container-row
					className="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"
					keyProperty="fglPrePrimaryId" modelVar="item"> --%>
				<liferay-ui:search-container-row className="java.util.Map"
					keyProperty="fglApplicationNo" modelVar="item">

					<liferay-ui:search-container-column-text name="application-no"
						value="<%=item.get("fglApplicationNo").toString()%>"/>

					<liferay-ui:search-container-column-text
						name="name-of-the-applicant"
						value="<%=item.get("applicantName").toString()%>" />

					<c:choose>
						<c:when test="${empty item.fglLicenseNo}">
							<liferay-ui:search-container-column-text
								name="food-grain-license-no" value="-" />
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								name="food-grain-license-no"
								value="<%=item.get("fglLicenseNo").toString()%>" />
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${empty item.fglLicneseApplicationType}">
							<liferay-ui:search-container-column-text name="license-application-type"
								value="-"/>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text name="license-application-type"
								value="<%=item.get("fglLicneseApplicationType").toString()%>"/>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${empty item.fglLicenseExpiryDate}">
							<liferay-ui:search-container-column-text
								name="food-grain-license-expiry-date" value="-" />
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								name="food-grain-license-expiry-date"
								value="<%=item.get("fglLicenseExpiryDate").toString()%>" />
						</c:otherwise>
					</c:choose>

					<%-- <liferay-ui:search-container-column-text name="Payment Status"
						value='<%=(((Long)item.get("paymentStatus")).longValue() == 0) ? "Paid" : "Pending" %>' /> --%>


					<liferay-ui:search-container-column-text name="business-type"
						value="<%=item.get("businessType").toString()%>" />
						<%
						int statusitem =(Integer) item.get("status");
						String statusStr = "";
						if(statusitem == 0){
							statusStr = "Reviewed";
						}else if(statusitem ==1){
							statusStr = "Pending";
						}else if(statusitem ==4){
							statusStr = "Rejected";
						}else if(statusitem ==6){
							statusStr = "Incomplete";
						}
						%>
					<liferay-ui:search-container-column-text name="status"
						value="<%= statusStr %>"
						cssClass="<%=(((Integer) item.get("status")).intValue() == 0)
							? "fw-bold text14 text-success"
							: (((Integer) item.get("status")).intValue() == 1)
									? "fw-bold text14 text-warning"
									: "fw-bold text14 text-danger"%>" />

					<liferay-ui:search-container-column-text name="view-details">

						<c:choose>
							<c:when test="${item.fglLicneseApplicationType == 'Duplicate'}">
								<c:set var="pageId" value="3" />

								<portlet:renderURL var="fglApplicationDetailsURL">
									<portlet:param name="dgfFglPreDtlsId"
										value="<%=item.get("fglPrePrimaryId").toString()%>" />
										<portlet:param name="licenseType"
										value="<%=item.get("fglLicneseApplicationType").toString()%>" />
										<portlet:param name="duplicateLicenseReasonId"
										value="<%=item.get("duplicateLicenseReasonId").toString()%>" />
									<portlet:param name="pageId" value="${pageId}" />
								</portlet:renderURL>

								<a href="${fglApplicationDetailsURL }"><i
									class="icon-eye-open" /></a>
							</c:when>
							
							<c:when test="${item.fglLicneseApplicationType == 'Renew'}">
								<c:set var="pageId" value="2" />
								<portlet:renderURL var="fglApplicationDetailsURL">
									<portlet:param name="dgfFglPreDtlsId"
										value="<%=item.get("fglPrePrimaryId").toString()%>" />
										<portlet:param name="licenseType"
										value="<%=item.get("fglLicneseApplicationType").toString()%>" />
										<portlet:param name="renewLicenseId"
										value="<%=item.get("renewLicenseId").toString()%>" />
										<portlet:param name="pageId" value="${pageId}" />
								</portlet:renderURL>

								<a href="${fglApplicationDetailsURL }"><i
									class="icon-eye-open" /></a>
							</c:when>

							<c:otherwise>
								<c:set var="pageId" value="1" />
								<portlet:renderURL var="fglApplicationDetailsURL">
									<portlet:param name="dgfFglPreDtlsId"
										value="<%=item.get("fglPrePrimaryId").toString()%>" />
										<portlet:param name="licenseType"
										value="<%=item.get("fglLicneseApplicationType").toString()%>" />
									<portlet:param name="pageId" value="${pageId}" />
								</portlet:renderURL>

								<a href="${fglApplicationDetailsURL}"><i
									class="icon-eye-open" /></a>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>



				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator/>
			</liferay-ui:search-container>
		</div>
		</div>
	</div>

	<!-- Bootstrap JavaScript CDN-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
		
	</script>
</body>

</html>
 