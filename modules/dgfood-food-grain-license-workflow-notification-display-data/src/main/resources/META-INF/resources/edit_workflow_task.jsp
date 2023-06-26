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

<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.util.Map"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>
<%@ include file="/init.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
    uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
    uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	String randomId = StringUtil.randomId();

	String redirect = ParamUtil.getString(request, "redirect");

	String backURL = ParamUtil.getString(request, "backURL", redirect);

	if (Validator.isNull(backURL)) {
		backURL = request.getHeader(WebKeys.REFERER);
	}

	String languageId = LanguageUtil.getLanguageId(request);

	WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();

	long classPK = workflowTaskDisplayContext.getWorkflowContextEntryClassPK(workflowTask);

	WorkflowHandler<?> workflowHandler = workflowTaskDisplayContext.getWorkflowHandler(workflowTask);

	AssetRenderer<?> assetRenderer = workflowHandler.getAssetRenderer(classPK);

	AssetRendererFactory<?> assetRendererFactory = null;

	AssetEntry assetEntry = null;

	if (assetRenderer != null) {
		assetRendererFactory = assetRenderer.getAssetRendererFactory();

		if (assetRendererFactory != null) {
			assetEntry = assetRendererFactory.getAssetEntry(workflowHandler.getClassName(),
					assetRenderer.getClassPK());
		}

		String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();

		if (ArrayUtil.isNotEmpty(availableLanguageIds)
				&& !ArrayUtil.contains(availableLanguageIds, languageId)) {
			languageId = assetRenderer.getDefaultLanguageId();
		}
	}

	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(backURL);

	renderResponse.setTitle(workflowTaskDisplayContext.getHeaderTitle(workflowTask));
%>

<clay:container-fluid>
	<clay:col cssClass="lfr-asset-column lfr-asset-column-details">
		<liferay-ui:success
			key='<%=workflowTaskDisplayContext.getPortletResource() + "requestProcessed"%>'
			message="your-request-completed-successfully" />

		<liferay-ui:error exception="<%=WorkflowTaskDueDateException.class%>"
			message="please-enter-a-valid-due-date" />

		<div class="sheet">
			<div class="row ">

				<%
					String workflowTaskIdStr = ParamUtil.getString(renderRequest, "workflowTaskId");
							long workflowTaskId = Long.parseLong(workflowTaskIdStr);
							DgfFglPreDtls dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil
									.getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(user.getUserId(), workflowTaskId);
						
							Map<String, Object> detailedDataList = DgfFglPreDtlsLocalServiceUtil
									.getDetailsData(dgfFglPreDtls.getFglPrePrimaryId());

							if (dgfFglPreDtls == null || detailedDataList == null || detailedDataList.isEmpty()) {
				%>
				
					<!-- ====================== -->
				
				<div class="container main-div text-capitalize">

	<hr class="mt-0 mb-1" />
	<div class="row">
	<div class="col-md-6 col-12">
	  <span class=" fw-bold p-0 m-0">Food grain License Details 
                
                </span> 
	</div>
	
	<div class="col-md-6 col-12">
	<span
                    class=" fw-bold p-0 m-0"> Last Login: <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
	</div>
	</div>
            
            <hr class="mt-1 mb-3" />
		<c:choose>
			<c:when test="${detailedDataList['status'] == 0}">
				<div class="card reviewed-card py-2 px-4 mb-4">
					<h6 class="text-success fw-bold fs-5">Reviewed</h6>
				</div>
			</c:when>
			<c:when test="${detailedDataList['status'] == 4}">
				<div class="card rejected-card py-2 px-4 mb-4">
					<h6 class="text-danger fw-bold fs-5">Rejected</h6>
				</div>
			</c:when>
			<c:when test="${detailedDataList['status'] == 1}">
				<div class="card pending-card py-2 px-4 mb-4">
					<h6 class="text-warning fw-bold fs-5">Pending</h6>
				</div>
			</c:when>
		</c:choose>

		<div class="container">
			<div class="card py-4 px-3">
				<div class="form_header text-center">
					<span class="m-0 p-0 fw-bold">
						<!--Food Grain License Form-B-->
						<liferay-ui:message key="food-grain-license-form-b" />
					</span>
					<h6 class="m-0 p-0 fw-bold">
						<!--Original Copy-->
						<liferay-ui:message key="original-copy" />
					</h6>
					<h5 class="m-0 p-0 fw-bold green-text">
						<!--Government of People's Republic of Bangladesh-->
						<liferay-ui:message
							key="government-of-peoples-republic-of-bangladesh" />
					</h5>
					<h6 class="m-0 p-0 fw-bold">
						<!--Ministry of Food And Disaster Management-->
						<liferay-ui:message key="ministry-of-food-and-disaster-management" />
					</h6>
					<span class="m-0 p-0 fw-bold"> <!--Food Division Department of Food, Dhaka-->
						<liferay-ui:message key="food-division-department-of-food-dhaka" />
					</span>
					<h6 class="text-uppercase fw-bold pb-3">
						<!--License for trading and warehousing of food grain/food items-->
						<liferay-ui:message
							key="license-for-trading-and-warehousing-of-food-grain-food-items" />
					</h6>
				</div>

				<form action="
        ">
        <div class="row p-2">


									<div class="col-md-4 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"> <!-- Application Number -->
													<liferay-ui:message key="application-no" /></span>---------</li>

										</ul>
									</div>
									<div class="col-md-4 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"> <!-- License Number -->
													<liferay-ui:message key="license-no" /></span>-----</li>

										</ul>
									</div>
									<div class="col-md-4 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon">
													<!-- License Application Type --> <liferay-ui:message
														key="license-application-type" />
											</span>-----</li>

										</ul>
									</div>
								</div>
					<div class="row p-2">
						<div class="col-md-12 col-sm-12">
							<h5 class="green-text mb-0">
								<!--Basic Info-->
								<liferay-ui:message key="basic-info" />
							</h5>
							<div class="green-bg">
								<hr class="mt-0 mb-0" />
							</div>

							<div class="row p-2">
								

								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon">
												<!--NID Number-->
												<liferay-ui:message key="nid-number" />
										</span>---------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Email Adress-->
												<liferay-ui:message key="email-address" /></span></li>

									</ul>
								</div>
							</div>


							<div class="row p-2">
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Mobile Number-->
												<liferay-ui:message key="mobile-number" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon">
												<!--Date of Birth-->
												<liferay-ui:message key="date-of-birth" />
										</span>---------------</li>

									</ul>
								</div>

							</div>
							<div class="row p-2">
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Name of the Applicant-->
												<liferay-ui:message key="name-of-the-applicant" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Father's Name-->
												<liferay-ui:message key="fathers-name" />
										</span>---------------</li>

									</ul>
								</div>

							</div>
							<div class="row p-2">
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Mather's Name-->
												<liferay-ui:message key="mothers-name" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Gender-->
												<liferay-ui:message key="gender" /></span>---------------</li>

									</ul>
								</div>

							</div>
							<div class="row p-2">
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon">
												<!--Marital Status-->
												<liferay-ui:message key="marital-status" />
										</span>---------------</li>

									</ul>
								</div>
							</div>


						</div>
						
					</div>

					<h5 class="green-text mb-0 mt-2 ">
						<!--Trade License Info-->
						<liferay-ui:message key="trade-license-info" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="row p-2">

						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License Number-->
										<liferay-ui:message key="trade-license-number" />
								</span>---------------</li>

							</ul>
						</div>
						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License Expiry Date-->
										<liferay-ui:message key="trade-license-expiry-date" /></span>---------------</li>

							</ul>
						</div>
					</div>
					<div class="row p-2">

						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Tax identification No (TIN)-->
										<liferay-ui:message key="tax-identification-no-tin" />
								</span>---------------</li>

							</ul>
						</div>
						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Business indentification No (BIN)-->
										<liferay-ui:message key="business-identification-no-bin" />
								</span>---------------</li>

							</ul>
						</div>
					</div>

					<div class="row p-2">

						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License issuer Code-->
										<liferay-ui:message key="trade-license-issuer-code" />
								</span>---------------</li>

							</ul>
						</div>
						<div class="col-md-6 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License issuer City-->
										<liferay-ui:message key="trade-license-issuer-city" /></span>---------------</li>

							</ul>
						</div>
					</div>


					<div class="row">
						<div class="col-md-6 col-sm-12">
							<h5 class="green-text mb-0 mt-2">
								<!--Address-->
								<liferay-ui:message key="present-address" />
							</h5>
							<div class="green-bg">
								<hr class="mt-0 mb-0" />
							</div>

							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Region/Division-->
												<liferay-ui:message key="region-division" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--District / Zilla-->
												<liferay-ui:message key="district-zilla" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Upzila-->
												<liferay-ui:message key="upazila" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Union-->
												<liferay-ui:message key="union" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Ward-->
												<liferay-ui:message key="ward" />
										</span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Zip Code-->
												<liferay-ui:message key="zip-code" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Post Office-->
												<liferay-ui:message key="post-office" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon">
												<!--House Address-->
												<liferay-ui:message key="house-address" />
										</span>---------------</li>

									</ul>
								</div>
							</div>


						</div>

						<div class="col-md-6 col-sm-12">
							<h5 class="green-text  mb-0 mt-2">
								<!--Registered Address-->
								<liferay-ui:message key="registered-address" />
							</h5>
							<div class="green-bg">
								<hr class="mt-0 mb-0" />
							</div>

							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Region/Division-->
												<liferay-ui:message key="region-division" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--District / Zilla-->
												<liferay-ui:message key="district-zilla" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Upzila-->
												<liferay-ui:message key="upazila" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Union-->
												<liferay-ui:message key="union" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Ward-->
												<liferay-ui:message key="ward" />
										</span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Zip Code-->
												<liferay-ui:message key="zip-code" /></span>---------------</li>

									</ul>
								</div>
							</div>
							<div class="row">


								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"> <!--Post Office-->
												<liferay-ui:message key="post-office" /></span>---------------</li>

									</ul>
								</div>
								<div class="col-md-6 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon">
												<!--House Address-->
												<liferay-ui:message key="house-address" />
										</span>---------------</li>

									</ul>
								</div>
							</div>


						</div>
					</div>

					<h5 class="green-text mb-0 mt-2">
						<!--Uploaded Documents-->
						<liferay-ui:message key="uploaded-documents" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="row p-2">
						<div
							class="col-md-6 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Photograph-->
							<liferay-ui:message key="photograph" />
							<span class="px-md-2">
								<div class="up-files bg-secondary mt-2"></div>
							</span>
						</div>
						<div
							class="col-md-6 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Trade License Document-->
							<liferay-ui:message key="trade-license-document" />
							<span class="px-md-2">
								<div class="up-files bg-secondary mt-2"></div>
							</span>
						</div>
					</div>
					<div class="row p-2">
						<div
							class="col-md-6 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Business identification No (BIN)-->
							<liferay-ui:message key="business-identification-no-bin" />
							<span class="px-md-2">
								<div class="up-files bg-secondary mt-2"></div>
							</span>
						</div>
						<div
							class="col-md-6 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Tax identification NO (TIN)-->
							<liferay-ui:message key="tax-identification-no-tin" />
							<span class="px-md-2">
								<div class="up-files bg-secondary mt-2"></div>
							</span>
						</div>
					</div>
					<div class="row p-2">
						<div
							class="col-md-6 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Bank Statement last 3 Month-->
							<liferay-ui:message key="bank-statement-last-3-month" />
							<span class="px-md-2">
								<div class="up-files bg-secondary mt-2"></div>
							</span>
						</div>

					</div>

				
			</div>
				
			<!-- ====================== -->
					
				<%
					} else {
				%>
				<!-- ====================== -->
				<div class="container row text-capitalize">
					<div class="container main-div">

						<hr class="mt-0 mb-1" />
						<div class="d-flex justify-content-between">
							<span class=" fw-bold p-0 m-0">Food grain License Details
							</span> <span
                    class=" fw-bold p-0 m-0"> Last Login: <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
						</div>
						<hr class="mt-1 mb-3" />
	<div>		
			
		<% if(detailedDataList.get("status").equals(0)) { %>
    <div class="card reviewed-card py-2 px-4 mb-4">
        <h6 class="text-success fw-bold fs-5">Reviewed</h6>
    </div>
<% } else if(detailedDataList.get("status").equals(4)) { %>
    <div class="card rejected-card py-2 px-4 mb-4">
        <h6 class="text-danger fw-bold fs-5">Rejected</h6>
    </div>
<% } else if(detailedDataList.get("status").equals(1)) { %>
    <div class="card pending-card py-2 px-4 mb-4">
        <h6 class="text-warning fw-bold fs-5">Pending</h6>
    </div>
<% } %>
		
</div>
						<div class="container-fluid">
							<div class="card py-4 px-3">
								<div class="form_header text-center">
									<span class="m-0 p-0 fw-bold"> <!--Food Grain License Form-B-->
										<liferay-ui:message key="food-grain-license-form-b" />
									</span>
									<h6 class="m-0 p-0 fw-bold">
										<!--Original Copy-->
										<liferay-ui:message key="original-copy" />
									</h6>
									<h5 class="m-0 p-0 fw-bold green-text">
										<!--Government of People's Republic of Bangladesh-->
										<liferay-ui:message
											key="government-of-peoples-republic-of-bangladesh" />
									</h5>
									<h6 class="m-0 p-0 fw-bold">
										<!--Ministry of Food And Disaster Management-->
										<liferay-ui:message
											key="ministry-of-food-and-disaster-management" />
									</h6>
									<span class="m-0 p-0 fw-bold"> <!--Food Division Department of Food, Dhaka-->
										<liferay-ui:message
											key="food-division-department-of-food-dhaka" />
									</span>
									<h6 class="text-uppercase fw-bold pb-3">
										<!--License for trading and warehousing of food grain/food items-->
										<liferay-ui:message
											key="license-for-trading-and-warehousing-of-food-grain-food-items" />
									</h6>
								</div>

								<form action="">
									<div class="row p-2 ">


										<div class="col-md-4 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Application Number -->
														<liferay-ui:message key="application-no" /></span> 
<% if (dgfFglPreDtls.getFglApplicationNo() != null) { %>
  <%=dgfFglPreDtls.getFglApplicationNo()%>
<% } else { %>
  -----------
<% } %>	

													</li>

											</ul>
										</div>

										<div class="col-md-4 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- License Number -->
														<liferay-ui:message key="license-Type" /></span> <%
 	if (detailedDataList.get("fglLicenseApplicationType").equals("New")) {
 %> New License Application <%
 	} else if (detailedDataList.get("fglLicenseApplicationType").equals("Duplicate")) {
 %> Duplicate License Application <%
 	} else if (detailedDataList.get("fglLicenseApplicationType").equals("Renew")) {
 %> Renewal License Application <%
 	} else {
 %> Unknown <%
 	}
 %></li>

											</ul>
										</div>

										<div class="col-md-4 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- License Application Type -->
														<liferay-ui:message key="license-application-type" />
												</span>
												
<% if (dgfFglPreDtls.getBusinessType() != null) { %>
  <%=dgfFglPreDtls.getBusinessType()%>
<% } else { %>
  -----------
<% } %>																						
												</li>

											</ul>
										</div>
									</div>
									<div class="row p-2">
										<div class="col-md-12 col-sm-12">
											<h5 class="green-text mb-0">
												<!--Basic Info-->
												<liferay-ui:message key="basic-info" />
											</h5>
											<div class="green-bg">
												<hr class="mt-0 mb-0" />
											</div>

											<div class="row p-2">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--NID Number-->
																<liferay-ui:message key="nid-number" />
														</span> 
<%=dgfFglPreDtls.getNationalId()%>													
													
													</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Email Adress-->
																<liferay-ui:message key="email-address" /></span> 
<% if (detailedDataList.get("Email") != null) { %>
  <%=detailedDataList.get("Email")%>
<% } else { %>
  -----------
<% } %>																	
														</li>

													</ul>
												</div>
											</div>


											<div class="row p-2">
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Mobile Number-->
																<liferay-ui:message key="mobile-number" /></span> 
<% if (detailedDataList.get("mobileNumber") != null) { %>
  <%=detailedDataList.get("mobileNumber")%>
<% } else { %>
  -----------
<% } %>																	
														</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Date of Birth-->
																<liferay-ui:message key="date-of-birth" />
														</span>

<% if (detailedDataList.get("dateOfBirth") != null) { %>
 <%= detailedDataList.get("dateOfBirth") %>	
<% } else { %>
  -----------
<% } %>																
														</li>
													</ul>
												</div>

											</div>
											<div class="row p-2">
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Name of the Applicant-->
																<liferay-ui:message key="name-of-the-applicant" /></span> 
<% if (dgfFglPreDtls.getApplicantName() != null) { %>
  <%= dgfFglPreDtls.getApplicantName() %>
<% } else { %>
  -----------
<% } %>																	
															
														</li>
													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Father's Name-->
																<liferay-ui:message key="fathers-name" />
														</span>
														
<% if (detailedDataList.get("fatherName") != null) { %>
  <%= detailedDataList.get("fatherName") %>
<% } else { %>
  -----------
<% } %>	
														</li>
													</ul>
												</div>

											</div>
											<div class="row p-2">
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Mather's Name-->
																<liferay-ui:message key="mothers-name" /></span>
<% if (detailedDataList.get("motherName") != null) { %>
  <%= detailedDataList.get("motherName") %>
<% } else { %>
  -----------
<% } %>																															
														</li>
													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Gender-->
																<liferay-ui:message key="gender" /></span> 
<% if (detailedDataList.get("Gender") != null) { %>
  <%= detailedDataList.get("Gender") %>
<% } else { %>
  -----------
<% } %>																	
															
														</li>
													</ul>
												</div>

											</div>
											<div class="row p-2">
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Marital Status-->
																<liferay-ui:message key="marital-status" />
														</span> 
<% if (detailedDataList.get("maritalStatus") != null) { %>
  <%= detailedDataList.get("maritalStatus") %>
<% } else { %>
  -----------
<% } %>																						
														
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<h5 class="green-text mb-0 mt-2 ">
										<!--Trade License Info-->
										<liferay-ui:message key="trade-license-info" />
									</h5>
									<div class="green-bg">
										<hr class="mt-0 mb-0" />
									</div>
									<div class="row p-2">

										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Trade License Number-->
														<liferay-ui:message key="trade-license-number" />
												</span>
<% if (dgfFglPreDtls.getTradeLicenseNo() != null) { %>
  <%= dgfFglPreDtls.getTradeLicenseNo() %>
<% } else { %>
  -----------
<% } %>																																				
												
												</li>
											</ul>
										</div>
										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Trade License Expiry Date-->
														<liferay-ui:message key="trade-license-expiry-date" /></span> 
												
													 <%= dgfFglPreDtls.getTradeLicenseExpiryDate() %>	
														
												</li>
											</ul>
										</div>
									</div>
									<div class="row p-2">

										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Tax identification No (TIN)-->
														<liferay-ui:message key="tax-identification-no-tin" />
												</span>
<% if (dgfFglPreDtls.getTaxIdentificationNo() != null) { %>
  <%= dgfFglPreDtls.getTaxIdentificationNo() %>
<% } else { %>
  -----------
<% } %>																								
											</li>
											</ul>
										</div>
										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Business indentification No (BIN)-->
														<liferay-ui:message key="business-identification-no-bin" />
												</span> 
<% if (detailedDataList.get("bin") != null) { %>
  <%=detailedDataList.get("bin") %>
<% } else { %>
 0
<% } %>												
												
									</li>
											</ul>
										</div>
									</div>

									<div class="row p-2">

										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Trade License issuer Code-->
														<liferay-ui:message key="trade-license-issuer-code" />
												</span>
<% if (dgfFglPreDtls.getTradeLicenseIssuerCode() != null) { %>
  <%= dgfFglPreDtls.getTradeLicenseIssuerCode() %>
<% } else { %>
  -----------
<% } %>												
																
											</ul>
										</div>
										<div class="col-md-6 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!--Trade License issuer City-->
														<liferay-ui:message key="trade-license-issuer-city" /></span> 
<% if (dgfFglPreDtls.getTradeLicenseIssuerCity() != null) { %>
  <%= dgfFglPreDtls.getTradeLicenseIssuerCity() %>
<% } else { %>
  -----------
<% } %>
																			
												</li>

											</ul>
										</div>
									</div>


									<div class="row">
										<div class="col-md-6 col-sm-12">
											<h5 class="green-text mb-0 mt-2">
												<!--Address-->
												<liferay-ui:message key="present-address" />
											</h5>
											<div class="green-bg">
												<hr class="mt-0 mb-0" />
											</div>

											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Region/Division-->
																<liferay-ui:message key="region-division" /></span>
<% if (detailedDataList.get("division") != null) { %>
  <%=detailedDataList.get("division") %>
<% } else { %>
 ----------
<% } %>																	
																</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--District / Zilla-->
																<liferay-ui:message key="district-zilla" /></span>
<% if (detailedDataList.get("district") != null) { %>
  <%=detailedDataList.get("district") %>
<% } else { %>
 ----------
<% } %>																	
																
																
																</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Upzila-->
																<liferay-ui:message key="upazila" /></span>
<% if (detailedDataList.get("upazila") != null) { %>
  <%=detailedDataList.get("upazila") %>
<% } else { %>
 ----------
<% } %>																	
																
																</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Union--> <liferay-ui:message key="union" /></span>
<% if (detailedDataList.get("union") != null) { %>
  <%=detailedDataList.get("union") %>
<% } else { %>
 ----------
<% } %>																		
																	
																	</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Ward--> <liferay-ui:message key="ward" />
														</span>
<% if (detailedDataList.get("ward") != null) { %>
  <%=detailedDataList.get("ward") %>
<% } else { %>
 ----------
<% } %>															
														
														</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Zip Code-->
																<liferay-ui:message key="zip-code" /></span>
<% if (detailedDataList.get("zipCode") != null) { %>
  <%=detailedDataList.get("zipCode") %>
<% } else { %>
 ----------
<% } %>																		
																
																</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Post Office-->
																<liferay-ui:message key="post-office" /></span>
<% if (detailedDataList.get("postOffice") != null) { %>
  <%=detailedDataList.get("postOffice")%>
<% } else { %>
 ----------
<% } %>																		
																
																</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--House Address-->
																<liferay-ui:message key="house-address" />
														</span>
														
<% if (detailedDataList.get("houseAddress") != null) { %>
  <%=detailedDataList.get("houseAddress")%>
<% } else { %>
 ----------
<% } %>		
														
														</li>

													</ul>
												</div>
											</div>


										</div>

										<div class="col-md-6 col-sm-12">
											<h5 class="green-text  mb-0 mt-2">
												<!--Registered Address-->
												<liferay-ui:message key="registered-address" />
											</h5>
											<div class="green-bg">
												<hr class="mt-0 mb-0" />
											</div>

											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Region/Division-->
																<liferay-ui:message key="region-division" /></span>
																
<% if (detailedDataList.get("busDivision") != null) { %>
  <%= detailedDataList.get("busDivision") %>
<% } else { %>
 ----------
<% } %>
																												
																</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--District / Zilla-->
																<liferay-ui:message key="district-zilla" /></span>
																												
<% if (detailedDataList.get("busDistrict") != null) { %>
  <%= detailedDataList.get("busDistrict") %>
<% } else { %>
 ----------
<% } %>																				
															</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Upzila-->
																<liferay-ui:message key="upazila" /></span>
																										
<% if (detailedDataList.get("busUpazila") != null) { %>
  <%=detailedDataList.get("busUpazila") %>
<% } else { %>
 ----------
<% } %>						
																
															</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Union--> <liferay-ui:message
																	key="union" /></span>
																	
<% if (detailedDataList.get("busUnion") != null) { %>
  <%=detailedDataList.get("busUnion") %>
<% } else { %>
 ----------
<% } %>																			
																	
																	</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Ward--> <liferay-ui:message
																	key="ward" />
														</span>
<% if (detailedDataList.get("busWard") != null) { %>
  <%=detailedDataList.get("busWard") %>
<% } else { %>
 ----------
<% } %>																
													
													</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Zip Code-->
																<liferay-ui:message key="zip-code" /></span>
																
<% if (detailedDataList.get("busZipCode") != null) { %>
  <%=detailedDataList.get("busZipCode") %>
<% } else { %>
 ----------
<% } %>																																		
																</li>

													</ul>
												</div>
											</div>
											<div class="row">


												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--Post Office-->
																<liferay-ui:message key="post-office" /></span>
<% if (detailedDataList.get("busPostOffice") != null) { %>
  <%=detailedDataList.get("busPostOffice") %>
<% } else { %>
 ----------
<% } %>																		
																																						
															</li>

													</ul>
												</div>
												<div class="col-md-6 col-sm-12">
													<ul class="alignMe">
														<li><span class="custom-colon"> <!--House Address-->
																<liferay-ui:message key="house-address" />
														</span>
<% if (detailedDataList.get("busHouseAddress") != null) { %>
  <%=detailedDataList.get("busHouseAddress") %>
<% } else { %>
 ----------
<% } %>															
																												
														</li>

													</ul>
												</div>
											</div>
										</div>
									</div>

									<h5 class="green-text mb-0 mt-2">
										<!--Uploaded Documents-->
										<liferay-ui:message key="uploaded-documents" />
									</h5>
									<div class="green-bg">
										<hr class="mt-0 mb-0" />
									</div>
							<div class="row py-2 div mt-2">
    <div class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
        <!--Photograph-->
        <liferay-ui:message key="photograph" />
        <span class="px-md-5 px-sm-1">
            <% if (detailedDataList != null && detailedDataList.get("photograph") != null) { %>
               
                <a class="text-decoration-none font-italic " href="<%=detailedDataList.get("photograph")%>" target="_blank">
                    <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark>    
                </a>
            <% } %>
        </span>
    </div>
    <div class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
        <!--Trade License Document-->
        <liferay-ui:message key="trade-license-document" />
        <span class="px-md-5 py-sm-2">
            <% if (detailedDataList != null && detailedDataList.get("tradeLicenseDocument") != null) { %>
              
                <a class="text-decoration-none font-italic " href="<%=detailedDataList.get("tradeLicenseDocument")%>" target="_blank">
                   <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
                </a>
            <% } %>
        </span>
    </div>
</div>
<div class="row py-2 my-2">
    <div class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
        <!--Business identification No (BIN)-->
        <liferay-ui:message key="business-identification-no (bin)" />
        <span class="px-md-5 px-sm-2">
            <% if (detailedDataList != null && detailedDataList.get("binDocument") != null) { %>
                
                <a class="text-decoration-none font-italic " href="<%=detailedDataList.get("binDocument")%>" target="_blank">
                    <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
                </a>
            <% } %>
        </span>
    </div>
    <div class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
        <!--Tax identification NO (TIN)-->
        <liferay-ui:message key="tax-identification-no (tin)" />
        <span class="px-md-5 px-sm-2">
            <% if (detailedDataList != null && detailedDataList.get("tinDocument") != null) { %>
               
                <a class="text-decoration-none font-italic " href="<%=detailedDataList.get("tinDocument")%>" target="_blank">
                   <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
                </a>
            <% } %>
        </span>
    </div>
</div>
<div class="row  py-2 my-2 ">
    <div class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
        <!--Bank Statement last 3 Month-->
        <liferay-ui:message key="bank-statement-last-3-month" />
        <span class="px-md-5 px-sm-2">
            <% if (detailedDataList != null && detailedDataList.get("bankStatementDocument") != null) { %>
                
                <a class="text-decoration-none font-italic " href="<%=detailedDataList.get("bankStatementDocument")%>" target="_blank">
                     <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
                </a>
            <% } %>
			</span>
		</div>
	</div>
	<div class="row  py-2 div my-2">
		<div
			class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
			<!--Insurance Document-->
			
			<span class="px-md-5 px-sm-1">
				<% if (detailedDataList != null && detailedDataList.get("insuranceDocument") != null) { %>
					<liferay-ui:message key="insurance-document" />
					<a class="text-decoration-none font-italic " href="<%=detailedDataList.get("insuranceDocument")%>" target="_blank">
						 <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
					</a>
				<% } %>
			</span>
		</div>
		<div
			class="col-md-6 col-12 col-sm-12 d-flex justify-content-between  align-items-center">
			<!--Other Document-->
			
			<span class="px-md-5 px-sm-2">
				<% if (detailedDataList != null && detailedDataList.get("otherDocument") != null) { %>
					<liferay-ui:message key="other-document" />
					<a class="text-decoration-none font-italic " href="<%=detailedDataList.get("otherDocument")%>" target="_blank">
						 <mark class="mark ">Click here <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i></i></mark> 
					</a>
				<% } %>
			</span>
		</div>
	</div>
			
								
				

									<hr />

									<div class="row mt-3 p-2">


										<div
											class=" text-center col-md-12 col-lg-12 col-12  order-xs-last order-sm-last order-md-last order-lg-last ">
											<div class="row">
											
												<div class="col-md-10 d-flex">
													
													<%
														request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
													%>

													<liferay-util:include page="/workflow_task_action.jsp"
														servletContext="<%=application%>">
														<liferay-util:param name="mvcPath"
															value="/edit_workflow_task.jsp" />

													</liferay-util:include>
													<div class=" paddingRight">
													<button type="button" class="back-btn" onclick="javascript:window.history.go(-1);" title="Go Back">
   														 <i class="fa-solid fa-circle-arrow-left paddingleft"></i>  Back
													</button>
													</div>
												
													
												</div>
													<div class="col-md-1 ">
													
													</div>


												</div>
												
											</div>

										</div>
									</div>
							</div>
						</div>
					</div>

				</div>
				
					<!-- ====================== -->
				<%
					}
				%>


			</div>

		</div>

	</clay:col>
</clay:container-fluid>

<aui:script use="liferay-workflow-tasks">
	var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '');

	Liferay.delegateClick(
		'<portlet:namespace /><%=randomId%>taskAssignLink',
		onTaskClickFn
	);
</aui:script>