<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ page
	import="bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal"%>
<%@page
	import="bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalServiceUtil"%>


<liferay-ui:success key="userAlreadyChangedProgram"
	message="User Already Submit Withdrawal Form " />
	
	<liferay-ui:success key="formSubmittedSuccessfully"
	message="Withdrawal Form submitted successfully." />
<liferay-ui:error key="errorMessage"
	message="An error occurred while submitting the Withdrawal Form." />

<%
	licnsUserRegs userRegsObj = (licnsUserRegs) request.getAttribute("userRegsObj");
	DgfFglPreDtls dgfFglPreDtls = (DgfFglPreDtls) request.getAttribute("dgfFglPreDtlsObj");
	DgfFglLicDtls licDtlsObj = (DgfFglLicDtls) request.getAttribute("dgfFglLicDtlsObj");
	DgfFglLicDtls dgfFglLicDtlsObjNid = (DgfFglLicDtls) request.getAttribute("dgfFglLicDtlsObjNid");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
	User currentUser = (User) request.getAttribute("currentUser");
	String tradeLicNo = (String) renderRequest.getAttribute("tradeLic");
	String dlrProgrameType = (String) renderRequest.getAttribute("dlrProgrameType");
	String tradeLicExpDate = (String) renderRequest.getAttribute("tradeLicExpDate");
	String dlrFglLicense = (String) renderRequest.getAttribute("dlrFglLicense");
	String dlrNationId = (String) renderRequest.getAttribute("dlrNationId");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DG Food Withdrawal</title>
<!-- Bootstrap CSS CDN  -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" />



</head>
<body>
	<div class="main-div text-capitalize">
		<hr class="mt-0 mb-1" />
		<div class="d-flex justify-content-between">
			<span class="fs-6 fw-bold p-0 m-0"> withdrawal-form </span> <span
				class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="last-login" /> <span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=currentUser.getLastLoginDate()%>" />
					| </span> <span><fmt:formatDate type="time" timeStyle="short"
						value="<%=currentUser.getLastLoginDate()%>" /></span>
			</span>
		</div>
		<hr class="mt-1 mb-3" />

		<div class="card px-4 py-2">

			<portlet:defineObjects />
			<portlet:actionURL name="submitWithdrawalForm"
				var="submitWithdrawalForm" />
			<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
			

	<%
			String errorMessage = (String) request.getAttribute("showAlert");
			if (errorMessage != null) {
		%>
		<div class="modal fade" id="errorModal" tabindex="-1" role="dialog"
			aria-labelledby="errorModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-danger" id="errorModalLabel">Error</h5>
						<button type="button" class="close text-danger p-2"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true"> X </span>
						</button>
					</div>
					<div class="modal-body">
						<%=errorMessage%>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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

			<aui:form name="submitWithdrawalForm" action="<%=submitWithdrawalForm%>" method="post"
				class="mt-4">

				<div class="row gx-4 mt-2">
					<div class="col-md-6 col-sm-12">
						<span class="d-block fw-bold mb-1">food-grain-license-number
						</span>


						<aui:input class="form-control" type="text"
							placeholder="type-here" name="licenseNo"
							aria-label="default input example" label="" value="<%=dlrFglLicense %>" readonly="true" >
							<aui:validator name="required" />
							<%-- <aui:validator
								errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-20-characters"
								name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[A-Za-z0-9/]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
							<aui:validator errorMessage="enter-a-valid-license-number"
								name="custom">
									function(val, fieldNode, ruleValue) {
									   var isLicenseNo;
									    var xhr = new XMLHttpRequest();
									    var url = '${resourceURL}';
									    var params = '<portlet:namespace />cmd=checkLicenseNo&<portlet:namespace />LicenseNo=' + encodeURIComponent(val);
									    xhr.open('POST', url, false);
									    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
									    xhr.onreadystatechange = function() {
									        if (xhr.readyState === 4 && xhr.status === 200) {
									            if (xhr.responseText) {
									                var json = JSON.parse(xhr.responseText);
									                isLicenseNo = json.isLicenseNo;
										              if (isLicenseNo == true) {
										                
								                        A.one('#<portlet:namespace />tradeLicenseNo').val(json.tradeLic);
								                       
								                    } else {
								                    	
								                        A.one('#<portlet:namespace />tradeLicenseNo').val('');
								                        
								                    }
									            }else {
									                isLicenseNo = false;
									               
							                        A.one('#<portlet:namespace />tradeLicenseNo').val('');
							                       
									            }
									        }
									    }
									    xhr.send(params);
									    return isLicenseNo;
									}
							</aui:validator> --%>
						</aui:input>


					</div>
					<%-- <h1><%=userRegsObj.get %></h1> --%>
					<div class="col-md-6 col-sm-12">
						<span class="d-block fw-bold mb-1">name-of-dealer</span>


						<aui:input type="text" name="dealerName" required="true"
							readonly="true" cssClass="form-control" label=""
							value="<%=userRegsObj != null ? userRegsObj.getApplicantName() : ""%>" />
					</div>
				</div>
				<div class="row gx-4 mt-2">
					<div class="col-md-6 col-sm-12">
						<span class="d-block fw-bold mb-1">nid-number <sup
							class="text-danger"></sup></span>
						<aui:input type="text" name="nationalId" required="true"
							readonly="true"
							value="<%=dlrNationId %>"
							cssClass="form-control" label="" />
					</div>
					<div class="col-md-6 col-sm-12">
						<span class="d-block fw-bold mb-1">mobile-number</span>
						<aui:input type="text" name="mobileNo" required="true"
							readonly="true"
							value="<%=userRegsObj != null ? userRegsObj.getMobileNo() : ""%>"
							cssClass="form-control" label="" />
					</div>
				</div>
				<div class="row gx-4 mt-2">
					<div class="col-sm-12">
						<span class="d-block fw-bold mb-2">withdrawing-from-current-programe
							<sup class="text-danger"></sup>
						</span>
						<aui:input type="text" name="programType"
							value="<%=dlrProgrameType%>" readonly="true"
							cssClass="form-control" label="" />
					</div>
				</div>

				<div style="margin-top: 1rem" class="">
					<label for="exampleFormControlTextarea1"
						class="form-label fw-bold mb-1 m-0">reason</label>
					<aui:input type="text" name="reason" placeholder="Type Here .... "
						required="true" cssClass="form-control py-5" label="" />

				</div>
				<aui:button name="submitButton" type="submit" id="submitButton"
					value="Submit"></aui:button>

			</aui:form>
		</div>

	</div>

</body>
</html>