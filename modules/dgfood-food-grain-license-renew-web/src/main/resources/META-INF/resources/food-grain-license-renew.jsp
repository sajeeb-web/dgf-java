<%@ include file="init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String tradeLicNo = (String) renderRequest.getAttribute("tradeLic");
	String tradeLicExpDate = (String) renderRequest.getAttribute("tradeLicExpDate");
	List<DgfFglLicDtls> dgfFglLicDtlsList = (List<DgfFglLicDtls>) renderRequest.getAttribute("dgfFglLicDtlsList");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<portlet:defineObjects />
<portlet:actionURL name="addRenewLicenseApplication"
	var="addRenewLicenseActionURL" />
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">

</head>

<body>
	

		<div class="px-md-5 px-sm-3 px-1">
		<hr class="mt-3 mb-1" />
		<div class="d-flex justify-content-between">
			<span class=" fw-bold p-0 m-0"><liferay-ui:message
					key="food-grain-license-renewal" /></span> <span
				class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="last-login" /><span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> | </span>
				<span><fmt:formatDate type="time" timeStyle="short"
						value="<%=user.getLastLoginDate()%>" /></span>
			</span>
		</div>
		<hr class="mt-1 mb-3" />
		<div class="container-fluid py-3">
			<div class="card py-3 px-4">
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
					<%--  <div class="modal-body">
						<%=errorMessage%>
					</div>  --%>
					 <div class="modal-body">
						<c:if test="${showAlert == 'modalMessage'}">
							<liferay-ui:message key="currently-an-application-under-review-for-this-license-wait-till-a-decission-is-made" />
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
				<aui:form action="<%=addRenewLicenseActionURL%>"
					name="licenseRenewForm" method="POST">


					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"><liferay-ui:message
									key="license-no" /><sup class="text-danger">*</sup></span>
							<aui:select name="licenseNo" id="licenseNo"
								class="form-select" aria-label="Default select example" label="">
								
								 <aui:validator name="required" />
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
										                A.one('#<portlet:namespace />licenseExpiryDate').val(json.licExpDate)
								                        A.one('#<portlet:namespace />tradeLicenseNo').val(json.tradeLic);
								                        A.one('#<portlet:namespace />tradeLicenseExpiryDate').val(json.tradeLicExpDate);
								                    } else {
								                    	A.one('#<portlet:namespace />licenseExpiryDate').val('')
								                        A.one('#<portlet:namespace />tradeLicenseNo').val('');
								                        A.one('#<portlet:namespace />tradeLicenseExpiryDate').val('');
								                    }
									            }else {
									                isLicenseNo = false;
									                A.one('#<portlet:namespace />licenseExpiryDate').val('')
							                        A.one('#<portlet:namespace />tradeLicenseNo').val('');
							                        A.one('#<portlet:namespace />tradeLicenseExpiryDate').val('');
									            }
									        }
									    }
									    xhr.send(params);
									    return isLicenseNo;
									}
							</aui:validator>

								<aui:option value="" label="select-a-license"
									selected="true" disabled="true"></aui:option>

								<c:forEach var="dgfFglLicDtls" items="${dgfFglLicDtlsList}">
									<aui:option value="${dgfFglLicDtls.foodgrainLicenseNo}">
										${dgfFglLicDtls.foodgrainLicenseNo}
									</aui:option>
								</c:forEach>
							</aui:select>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"><liferay-ui:message
									key="license-expiry-date" /><sup class="text-danger">*</sup></span>
							<aui:input class="form-control" type="date"
								placeholder="auto-populate"  id="licenseExpiryDate" name="licenseExpiryDate"
								aria-label="default input example"
								label="" readonly="true">
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"><liferay-ui:message
									key="trade-license-number" /> </span>
							<aui:input class="form-control" type="text"
								placeholder="auto-populate" name="tradeLicenseNo"
								id="tradeLicenseNo" aria-label="default input example" label=""
								value="" readonly="true">
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"><liferay-ui:message
									key="trade-license-expiry-date" /> </span>
							<aui:input class="form-control" type="date"
								placeholder="auto-populate" name="tradeLicenseExpiryDate"
								id="tradeLicenseExpiryDate" aria-label="default input example"
								label="" value="" readonly="true">
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"><liferay-ui:message
									key="trade-license-document" /><sup class="text-danger">*</sup></span>

							<div class="form-group">

								<div class="custom-file">

									<aui:input name="tradeLicAttchDoc" class="form-control"
										type="file" placeholder="auto-populate"
										aria-label="default input example" label="">
										<aui:validator name="required"
											errorMessage="trade-license-document-is-required" />
										<aui:validator name="custom"
											errorMessage="only-pdf-doc-docx-jpg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpeg', 'image/png'];
									
									            if (allowedTypes.indexOf(fileType) === -1) {
									                return false;
									            }
									            return true;
									        }
								    </aui:validator>
										<aui:validator name="custom"
											errorMessage="max-file-size-can-be-200-kb">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            var fileSize = file ? file.size / 1024 : 0; // Convert to KB
									            var maxFileSize = 200; // Maximum file size in KB
												
									            if (fileSize > maxFileSize) {
									                return false;
									            }
									            return true;
									        }
    								</aui:validator>
									</aui:input>
									<aui:input name="tradeLicAttchType" class="form-control"
										type="hidden" value="license">

									</aui:input>


									<!-- <input id="TradeLicAttchDoc" type="file" -->
									<!-- name="TradeLicAttchDoc" label="" value="license"></input> -->

									<!-- Changing Label Text -->
									<!-- <label class="custom-file-label" for="TradeLicAttchDoc">Choose -->
									<!-- File to Upload</label> -->
								</div>
							</div>
						</div>



						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <liferay-ui:message
									key="payment-details" /><sup class="text-danger">*</sup></span>

							<div class="form-group">

								<div class="custom-file">

									<aui:input name="paymentAttchDoc" class="form-control"
										type="file" placeholder="auto-populate"
										aria-label="default input example" label="">
										<aui:validator name="required"
											errorMessage="payment-attch-doc-is-required" />
										<aui:validator name="custom"
											errorMessage="only-pdf-doc-docx-jpg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpeg', 'image/png'];
									
									            if (allowedTypes.indexOf(fileType) === -1) {
									                return false;
									            }
									              return true;
									        }
								    </aui:validator>
										<aui:validator name="custom"
											errorMessage="max-file-size-can-be-200-kb">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            var fileSize = file ? file.size / 1024 : 0; // Convert to KB
									            var maxFileSize = 200; // Maximum file size in KB
												
									            if (fileSize > maxFileSize) {
									                return false;
									            }
									
									            return true;
									        }
    								</aui:validator>
									</aui:input>
									<aui:input name="paymentAttchType" class="form-control"
										type="hidden" value="payment">
									</aui:input>

									<!-- <input id="PaymentAttchDoc" type="file" name="PaymentAttchDoc" -->
									<!-- label="" value="payment"></input> -->

									<!-- Changing Label Text -->
									<!-- <label class="custom-file-label" for="PaymentAttchDoc">Choose -->
									<!-- File to Upload</label> -->
								</div>
							</div>
						</div>
					</div>
					<div class="mt-4">
						<label for="exampleFormControlTextarea1" class="form-label m-0"><liferay-ui:message
								key="comments" /></label>
						<aui:input class="form-control card shadow-sm"
							id="exampleFormControlTextarea1" type="textarea" rows="3"
							placeholder="type-here" name="comments" label=""></aui:input>
					</div>

					<div>

						<button class="btn btn-success green-bg" type="submit">
							<liferay-ui:message key="submit" />
							<i class="icon-circle-arrow-right"></i>
						</button>
					</div>
				</aui:form>
			</div>
		</div>
		</div>
	
</body>

</html>
