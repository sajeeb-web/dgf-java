<%@ include file="init.jsp"%>

<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>

<%
	Map<String, Object> detailedDataList = (Map<String, Object>) request.getAttribute("detailedDataList");
%>


<portlet:actionURL name="approvedLicense"
	var="approvedDuplicateLicenseURL">
	<portlet:param name="dgfFglPreDtlsId"
		value="<%=renderRequest.getAttribute("dgfFglPreDtlsId").toString()%>" />
	<portlet:param name="id"
		value="<%=renderRequest.getAttribute("id").toString()%>" />
	<portlet:param name="resourceName"
		value="<%=renderRequest.getAttribute("resourceName").toString()%>" />
</portlet:actionURL>
<portlet:renderURL var="renderDuplicateURL"></portlet:renderURL>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Grain License Duplicate Application Details</title>

</head>
<body>

	<div class="container main-div">

		<hr class="mt-0 mb-1" />
		<div class="d-flex justify-content-between">

			<span class=" fw-bold p-0 m-0"> <!-- Food Grain License Duplicate Application details -->
				<liferay-ui:message
					key="food-grain-license-duplicate-application-details" />
			</span> <span class=" fw-bold p-0 m-0"> Last Login: <span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> | </span>
				<span><fmt:formatDate type="time" timeStyle="short"
						value="<%=user.getLastLoginDate()%>" /></span>
			</span>
		</div>
		<hr class="mt-1 mb-3" />
		<c:choose>
			<c:when test="${detailedDataList['status'] == 0}">
				<div class="card reviewed-card py-2 px-4 mb-4">
					<h6 class="text-success fw-bold fs-5"><liferay-ui:message key="reviewed" /></h6>
				</div>
			</c:when>
			<c:when test="${detailedDataList['status'] == 4}">
				<div class="card rejected-card py-2 px-4 mb-4">
					<h6 class="text-danger fw-bold fs-5"><liferay-ui:message key="rejected" /></h6>
				</div>
			</c:when>
			<c:when test="${detailedDataList['status'] == 1}">
				<div class="card pending-card py-2 px-4 mb-4">
					<h6 class="text-warning fw-bold fs-5"><liferay-ui:message key="pending" /></h6>
				</div>
			</c:when>
			
		</c:choose>
	
		<div class="container">
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
					<span class="m-0 p-0 fw-bold"> <!--Food Division Department of Food, Dhaka-->
						<liferay-ui:message key="food-division-department-of-food-dhaka" />
					</span>
					<h6 class="text-uppercase fw-bold pb-3">
						<!--License for trading and warehousing of food grain/food items-->
						<liferay-ui:message
							key="license-for-trading-and-warehousing-of-food-grain-food-items" />
					</h6>
				</div>

				<div class="row px-2  justify-content-between">
					<div class="row px-2  justify-content-between">
						<div class="col-md-4 col-sm-12">

							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Application Number -->
										<liferay-ui:message key="application-no" /></span> <c:if
										test="${not empty detailedDataList}"><%=detailedDataList.get("fglApplicationNo")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-4 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- License Number -->
										<liferay-ui:message key="license-no" /></span> <c:if
										test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseNo")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-4 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- License Application Type -->
										<liferay-ui:message key="license-application-type" />
								</span> <c:if test="${not empty detailedDataList}">
										<liferay-ui:message
											key="<%=detailedDataList.get("fglLicneseApplicationType").toString().toLowerCase()%>" />
									</c:if></li>

							</ul>
						</div>
					</div>
					<h5 class="green-text fw-bold mb-0">
						<!-- Basic Info -->
						<liferay-ui:message key="basic-info" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="col-md-5 col-sm-12 mt-2">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- NID Number --> <liferay-ui:message
										key="nid-number" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("nidNumber")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12 mt-2">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Email Address -->

									<liferay-ui:message key="email-address" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("Email")%></c:if></li>

						</ul>
					</div>
				</div>


				<div class="row px-2  justify-content-between">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Mobile Number -->
									<liferay-ui:message key="mobile-number" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("mobileNumber")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Date of Birth -->
									<liferay-ui:message key="date-of-birth" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("dateOfBirth")%></c:if></li>

						</ul>
					</div>

				</div>
				<div class="row px-2  justify-content-between">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Name of the Applicant -->
									<liferay-ui:message key="name-of-the-applicant" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("nameOfTheApllicant")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Father's Name -->
									<liferay-ui:message key="fathers-name" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("fatherName")%></c:if></li>

						</ul>
					</div>

				</div>
				<div class="row px-2  justify-content-between">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Mother's Name -->
									<liferay-ui:message key="mothers-name" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("motherName")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Gender --> <liferay-ui:message
										key="gender" /></span> <c:if test="${not empty detailedDataList}">
									<liferay-ui:message
										key="<%=detailedDataList.get("Gender").toString().toLowerCase()%>" />
								</c:if></li>
						</ul>
					</div>

				</div>
				<div class="row px-2  justify-content-between">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Marital Status -->
									<liferay-ui:message key="marital-status" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("maritalStatus")%></c:if></li>

						</ul>
					</div>
				</div>


				<h5 class="green-text fw-bold mb-0 mt-2 ">
					<!-- Food Grain License Info -->
					<liferay-ui:message key="food-grain-license-info" />
				</h5>
				<div class="green-bg">
					<hr class="mt-0 mb-0" />
				</div>
				<div class="row px-2 pt-2 justify-content-between">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Food Grain License Issued By -->
									<liferay-ui:message key="food-grain-license-issued-by" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseIssuedBy")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Food Grain License Expiry Date -->
									<liferay-ui:message key="food-grain-license-expiry-date" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseExpiryDate")%></c:if></li>

						</ul>
					</div>
				</div>
				<div class="row px-2  justify-content-between">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Food Grain License Issued Date -->
									<liferay-ui:message key="food-grain-license-issued-date" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseIssuedDate")%></c:if></li>

						</ul>
					</div>

				</div>




				<h5 class="green-text fw-bold mb-0 mt-2 ">
					<!-- Trade License Info -->
					<liferay-ui:message key="trade-license-info" />
				</h5>
				<div class="green-bg">
					<hr class="mt-0 mb-0" />
				</div>
				<div class="row px-2 pt-2  justify-content-between">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Trade License Number -->
									<liferay-ui:message key="trade-license-number" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("tradeLicenseNumber")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Trade License Expiry Date -->
									<liferay-ui:message key="trade-license-expiry-date" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("tradeLicenseExpiryDate")%></c:if></li>

						</ul>
					</div>
				</div>
				<div class="row px-2  justify-content-between">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Tax identification No (TIN) -->
									<liferay-ui:message key="tax-identification-no-tin" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("tin")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Business indentification No (BIN) -->
									<liferay-ui:message key="business-identification-no-bin" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("bin")%></c:if></li>

						</ul>
					</div>
				</div>

				<div class="row px-2  justify-content-between">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Trade License issuer Code -->
									<liferay-ui:message key="trade-license-issuer-code" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("tradeLicenseIssuerCode")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Trade License issuer City -->
									<liferay-ui:message key="trade-license-issuer-city" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("tradeLicenseIssuerCity")%></c:if></li>

						</ul>
					</div>
				</div>

				<h5 class="green-text fw-bold mb-0 mt-2">
					<!-- Duplicate License Info -->
					<liferay-ui:message key="duplicate-license-info" />
				</h5>
				<div class="green-bg">
					<hr class="mt-0 mb-0" />
				</div>
				<div class="row pt-2 justify-content-between px-2">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Reason of Duplicate License -->
									<liferay-ui:message key="reason-of-duplicate-license" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseDuplicateReason")%></c:if></li>

						</ul>
					</div>

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Comments --> <liferay-ui:message
										key="duplicate-license-comments" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("fglLicenseDuplicateComment")%></c:if></li>

						</ul>
					</div>


				</div>


				<h5 class="green-text fw-bold mb-0 mt-2">
					<!-- Uploaded Documents -->
					<liferay-ui:message key="uploaded-documents" />
				</h5>
				<div class="green-bg">
					<hr class="mt-0 mb-0" />
				</div>

				<div class="row pt-2 justify-content-between px-2 div">
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!-- Payment Details -->
						<liferay-ui:message key="payment-details" />

						<span class="px-md-5 px-sm-1"><c:if
								test="${not empty detailedDataList}">
								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("duplicatePaymentAttchDocument")%>"
									target="_blank"><mark class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>
							</c:if> </span>

					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!-- Trade License Document -->
						<liferay-ui:message key="trade-license-document" />

						<span class="px-md-5 px-sm-1"><c:if
								test="${not empty detailedDataList}">
								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("duplicateTradeAttchDocument")%>"
									target="_blank"><mark class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>
							</c:if> </span>
					</div>
				</div>



				<hr />

				<div class="mt-3 px-2">
					<c:if test="${hasPermissionUpdate == true }">
						<%
							boolean acf = (Boolean) renderRequest.getAttribute("isAcf");
								long pageId = (Long) renderRequest.getAttribute("pageId");
								List<WorkflowTransition> list = (List<WorkflowTransition>) renderRequest.getAttribute("tasks");
								for (WorkflowTransition transition : list) {
									String transitionLabel = transition.getLabel(Locale.ENGLISH).trim();
									boolean isReject = transitionLabel.toUpperCase().contains("REJECT");
									String transitionName = transition.getName();
						%>

						<a
							class="btn <%=isReject ? "btn-danger" : "btn-success"%> border-0"
							href="javascript:;"
							onclick="showCommentsModal('<%=transitionName%>', '<%=transitionLabel%>', <%=acf%>, <%=pageId%>)">
							<liferay-ui:message key="<%=transitionLabel.toLowerCase()%>" />
							<i class="fa-solid fa-circle-arrow-right"></i>
						</a>

						<%
							}
						%>
					</c:if>
					<a href="<%=renderDuplicateURL%>" class="btn btn-reset me-2"> <i
						class="fa-solid fa-circle-arrow-left me-1"></i> <!-- Back --> <liferay-ui:message
							key="back" />
					</a>
				</div>
				<!--        Start Otp Popup -->
				<div id="render-approved-comments-popup" class="modal-body"></div>
				<div id="approved-comments-popup" style="display: none !important"
					class="container height-100 d-flex justify-content-center align-items-center">
					<div class="position-relative">
						<div class="p-2 text-center">
							<div class="mt-4">
								<aui:form action="${approvedDuplicateLicenseURL}"
									name="approvedRenewLicense" method="POST">
									<aui:input name="companyId" type="hidden" value="${companyId}"></aui:input>
									<aui:input name="workflowInstanceId" type="hidden"
										value="${workflowInstanceId}"></aui:input>
									<aui:input name="workflowTaskId" type="hidden"
										value="${workflowTaskId}"></aui:input>
									<aui:input name="transitionName" type="hidden"></aui:input>
									<aui:input name="transitionLabel" type="hidden"></aui:input>
									<aui:input name="comments" class="form-control" type="textarea"
										placeholder="type-here" aria-label="default input example"
										label="">
										<aui:validator name="required" />
									</aui:input>
									<button type="submit" class="btn px-4 validate green-bg ">
										<liferay-ui:message key="submit" />
									</button>
								</aui:form>
							</div>
						</div>
					</div>
				</div>
				<!--     End Otp Popup -->
			</div>
		</div>
	</div>
</body>

</html>