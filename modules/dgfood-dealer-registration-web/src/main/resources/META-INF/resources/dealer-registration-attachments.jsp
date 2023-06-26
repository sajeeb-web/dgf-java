<%@ include file="init.jsp"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfAttachments"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalServiceUtil"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>

<%
	DgfDlrRegDtls dlrRegPriData = (DgfDlrRegDtls) renderRequest.getAttribute("dlrRegPriData");
	DgfAttachments dlrBnkSolvncyObj = null;
	DgfAttachments dlrIncTaxAtchObj = null;
	DgfAttachments dlrShpOwnshipObj =  null;
	DgfAttachments dlrShpRentedObj = null;
	DgfAttachments dlrSignatureObj = null;

if(dlrRegPriData.getBnkSolvncyCertId() > 0 && dlrRegPriData.getIncmTaxAttchID() > 0 && dlrRegPriData.getShpOwnshipDocuId() > 0 && dlrRegPriData.getShpRentedDocuId() > 0 && dlrRegPriData.getSignatureId() > 0){
		 dlrBnkSolvncyObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegPriData.getBnkSolvncyCertId());	
		 dlrIncTaxAtchObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegPriData.getIncmTaxAttchID());
		 dlrShpOwnshipObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegPriData.getShpOwnshipDocuId());
		 dlrShpRentedObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegPriData.getShpRentedDocuId());
		 dlrSignatureObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegPriData.getSignatureId());
	}

%> 

<!DOCTYPE html>

<portlet:actionURL name="actionForm" var="addDlrAttachmentFormActionURL">
	<portlet:param name="mvcPath" value="/dealer-registration-preview.jsp" />
	<portlet:param name="pageId" value="3" />
</portlet:actionURL>
<portlet:actionURL name="back" var="backUrl" >
	<portlet:param name="mvcPath" value="/dealer-registration-shop-details.jsp" />
	<portlet:param name="pageId" value="3" />
	<portlet:param name="isBack" value="true" />
	<portlet:param name="nationalId" value="<%=renderRequest.getAttribute("nationalId").toString()%>" />
</portlet:actionURL>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>
<!-- Bootstrap CSS CDN  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

</head>

<body>

	<div class="px-md-5 px-sm-3 px-1">		
		<hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">
				<liferay-ui:message key="dealer-registration-form" />
				</span> 
				<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />		
		<div
			class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-2">
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr" role="progressbar" aria-valuenow="30"
				aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<div class="container-fluid py-3">
			<div class="card py-3 px-4">

				<aui:form name="dealerRegistrationForm"
					action="<%=addDlrAttachmentFormActionURL%>" method="POST">
					
					<aui:input type="hidden" name="nationalId"
						value="<%=request.getAttribute("nationalId")%>" />
					
					<h5 class="green-text fw-bold mb-0">
						<liferay-ui:message key="upload-documents" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>

					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<div class="mb-3">
								<label for="formFileMultiple" class="form-label"><liferay-ui:message
										key="photocopy-of-bank-solvency-certificate" />&nbsp;<sup class="text-danger">*</sup></label>
								<aui:input class="form-control" type="file" id="bankSolvCert"
									name="bankSolvCert" label="" placeholder="choose-file">
									<aui:validator name="required"
										errorMessage="photocopy-of-bank-solvency-certificate-is-required" />
									 <aui:validator name="custom"
										errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpg', 'image/jpeg', 'image/png'];
									
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
								<aui:input name="bankSolvCertType" type="hidden"
									value="certificate" />
							</div>
							<span class="text-document d-block"><liferay-ui:message
									key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
						</div>
						<div class="col-md-6 col-sm-12">


							<div class="mb-3">
								<label for="formFileMultiple" class="form-label"><liferay-ui:message
										key="income-tax-return-certificate" />&nbsp;<sup class="text-danger">*</sup></label>
								<aui:input class="form-control" type="file" id="taxRtrnCert"
									name="taxRtrnCert" label="" placeholder="choose-file">
									<aui:validator name="required"
										errorMessage="income-tax-return-certificate-is-required" />
									 <aui:validator name="custom"
										errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpg', 'image/jpeg', 'image/png'];
									
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
								<aui:input name="taxRtrnCertType" type="hidden"
									value="certificate" />
							</div>
							<span class="text-document d-block"><liferay-ui:message
									key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
						</div>
					</div>

					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">


							<div class="mb-3">
								<label for="formFileMultiple" class="form-label"><liferay-ui:message
										key="ownership-document-of-the-shop" />&nbsp;<sup class="text-danger">*</sup></label>
								<aui:input class="form-control" type="file" id="shopOwnrshpDoc"
									name="shopOwnrshpDoc" label="" placeholder="choose-file">
									<aui:validator name="required"
										errorMessage="ownership-document-of-the-shop-is-required" />
									 <aui:validator name="custom"
										errorMessage="only-pdf-doc-docx-jpg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpg', 'image/jpeg', 'image/png'];
									
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
								<aui:input name="shopOwnrshpDocType" type="hidden" value="other" />
							</div>
							<span class="text-document d-block"><liferay-ui:message
									key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
						</div>



						<div class="col-md-6 col-sm-12">


							<div class="mb-3">
								<label for="formFileMultiple" class="form-label"><liferay-ui:message
										key="if-rented-shop-then-photocopy-of-rental-agreement" />&nbsp;<sup class="text-danger">*</sup></label>
								<aui:input class="form-control" type="file" id="shopRentalDoc"
									name="shopRentalDoc" label="" placeholder="choose-file">
									<aui:validator name="required"
										errorMessage="photocopy-of-rental-agreement-is-required" />
									 <aui:validator name="custom"
										errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpg', 'image/jpeg', 'image/png'];
									
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
								<aui:input name="shopRentalDocType" type="hidden" value="other" />
							</div>
							<span class="text-document d-block"><liferay-ui:message
									key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
						</div>
					</div>

					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">


							<div class="mb-3">
								<label for="formFileMultiple" class="form-label"><liferay-ui:message
										key="signature-thumb-impression" />&nbsp;<sup class="text-danger">*</sup></label>
								<aui:input class="form-control" type="file" id="signOrThumbPic"
									name="signOrThumbPic" label="" placeholder="choose-file">
									<aui:validator name="required"
										errorMessage="signature-thumb-impression-is-required" />
									 <aui:validator name="custom"
										errorMessage="only-jpg-jpeg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['image/jpg', 'image/jpeg', 'image/png'];
									
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
								<aui:input name="signOrThumbPicType" type="hidden" value="other" />
							</div>
							<span class="text-document d-block"><liferay-ui:message
									key="only-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
						</div>

					</div>
					<div class="mt-3">
						<%-- <button class="btn btn-secondary me-2">
							<i class="icon-arrow-left"></i>
							<liferay-ui:message key="back" />
						</button> --%>
						<a class="btn btn-reset me-2" href="<%=backUrl%>">
									<i class="icon-circle-arrow-left"></i>
									<!-- Back-->
									<liferay-ui:message key="back" />
							</a>
						<button class="btn btn-success green-bg">
							<liferay-ui:message key="next" />
							<i class="icon-circle-arrow-right"></i>
						</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>

	<script>
 		var tradeLFileInputs = document.querySelectorAll('input[type="file"]');
    		var file;
 			tradeLFileInputs.forEach((tradLfile) => {
	 			var file;
	 			var fileUrl = getFileUrl(tradLfile.name);
				if(fileUrl) {
	 			fetch(fileUrl)
				.then(res => res.blob()) // Gets the response and returns it as a blob
				.then(blob => {
				  var  file = new File([blob],getFileName(tradLfile.name).split('_').slice(1).join('_'), {
 		              type: blob.type || 'text/plain',
 		              lastModified: new Date(),
				});
				 var dataTransfer = new DataTransfer();
	 	         dataTransfer.items.add(file);
	 	         tradLfile.files = dataTransfer.files;
				});
				}
  			});
		
 			function getFileUrl(fileInputName) {
 				var fileUrl;
 				if(fileInputName.includes("bankSolvCert")){
	 				fileUrl = '<%= dlrBnkSolvncyObj != null ? dlrBnkSolvncyObj.getFilePath() : "" %>';	
 				}else if(fileInputName.includes("taxRtrnCert")){
	 				fileUrl = '<%= dlrIncTaxAtchObj != null ? dlrIncTaxAtchObj.getFilePath() : "" %>';		
	 			 }else if(fileInputName.includes("shopOwnrshpDoc")){
	 				fileUrl = '<%= dlrShpOwnshipObj != null ? dlrShpOwnshipObj.getFilePath() : "" %>';
	 			 }else if(fileInputName.includes("shopRentalDoc")){
	 				fileUrl = '<%= dlrShpRentedObj != null ? dlrShpRentedObj.getFilePath() : "" %>';
	 			 }else if(fileInputName.includes("signOrThumbPic")){
	 				fileUrl = '<%= dlrSignatureObj != null ? dlrSignatureObj.getFilePath() : "" %>';
	 			 }
				 return fileUrl;
 			}
 			
 			function getFileName(fileInputName) {
 				var fileName;
 				if(fileInputName.includes("bankSolvCert")){
 					fileName = '<%= dlrBnkSolvncyObj != null ? dlrBnkSolvncyObj.getTitle() : "" %>';	
 				}else if(fileInputName.includes("taxRtrnCert")){
 					fileName = '<%= dlrIncTaxAtchObj != null ? dlrIncTaxAtchObj.getTitle() : "" %>';		
	 			 }else if(fileInputName.includes("shopOwnrshpDoc")){
	 				fileName = '<%= dlrShpOwnshipObj != null ? dlrShpOwnshipObj.getTitle() : "" %>';
	 			 }else if(fileInputName.includes("shopRentalDoc")){
	 				fileName = '<%= dlrShpRentedObj != null ? dlrShpRentedObj.getTitle() : "" %>';
	 			 }else if(fileInputName.includes("signOrThumbPic")){
	 				fileName = '<%= dlrSignatureObj != null ? dlrSignatureObj.getTitle() : "" %>';
	 			 }
				 return fileName;
 			}
    </script> 
</body>

</html>