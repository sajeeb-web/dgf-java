<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfStoreDtls"%>
<%@ include file="init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>

<portlet:defineObjects />
<portlet:actionURL name="addUploadData" var="addUploadDataActonURL" />

<%
	licnsUserRegs userPriData = (licnsUserRegs) request.getAttribute("userPriData"); 
      Map<String, String> userRegAddrs = (Map<String, String>) request.getAttribute("userRegAddrs");
      for (Map.Entry<String, String> entry : userRegAddrs.entrySet()) {	  
      }
      
  	List<DgfStoreDtls> dgfStoreDtls = (List<DgfStoreDtls>)renderRequest.getAttribute("dgfStoreDtls");
  	boolean hasDgfStoreDtls = dgfStoreDtls != null && !dgfStoreDtls.isEmpty();
  	int storeSize = hasDgfStoreDtls == true ? dgfStoreDtls.size()-1 : 0;
  	String languageId = (String) request.getAttribute("languageId");
  	
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">

</head>
<body>
		<div class="main-div">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"> <!--Your License Application Status-->
			<liferay-ui:message key="your-license-application-status" />
		</span>
		<hr class="mt-1 mb-3" />
	
			<div class="card shadow-sm py-3 p-3">
				<aui:form action="<%= addUploadDataActonURL %>" method="post"
					name="addUploadDataActonURL" enctype="multipart/form-data">
					<aui:input type="hidden" name="pageId" value="2" />
					<div class="row">
						<div class="col-md-7 col-sm-12">
							<h5 class="fw-bold">
								<!--Your License Application Status-->
								<liferay-ui:message key="your-license-application-status" />
								:
							</h5>							
							<c:if test="${status == 'Approved'}">
								<h4 class="text-uppercase green-text fw-bold">
									<liferay-ui:message key="approved" />
								</h4>
								<h6 class="py-1 fw-bold">
								<!--Application Approval Date-->

								<liferay-ui:message key="application-status-updated-on" />
								: <span class="ps-2"><c:out
										value="<%= request.getAttribute("statusUpdatedDateStr") %>"></c:out></span>
								</h6>
								
								<a href="/status-check-screen" class="btn button-seceondary me-2">
								<i class="icon-circle-arrow-left"></i>&nbsp;<liferay-ui:message key="back" />
								</a>
							</c:if>
							<c:if test="${status == 'Pending'}">
								<h4 class="text-uppercase text-warning fw-bold">
									<liferay-ui:message key="pending" />
								</h4>
								<h6 class="py-1 fw-bold">
								<!--Application Approval Date-->

								<liferay-ui:message key="application-status-updated-on" />
								: <span class="ps-2"><c:out
										value="<%= request.getAttribute("statusUpdatedDateStr") %>"></c:out></span>
							</h6>
							
							<a href="/status-check-screen" class="btn button-seceondary me-2">
								<i class="icon-circle-arrow-left"></i><liferay-ui:message key="back" />
								</a>
								<a href="/homepage" style="" class="btn btn-success green-bg">
								<liferay-ui:message key="home" />&nbsp;<i class="icon-circle-arrow-right"></i>
								</a>
							</c:if>
							<c:if test="${status == 'Payment Pending'}">
								<h4 class="text-uppercase text-warning fw-bold">
									<liferay-ui:message key="payment-pending" />
								</h4>
								<h6 class="py-1 fw-bold">
								<!--Application Approval Date-->

								<liferay-ui:message key="application-status-updated-on" />
								: <span class="ps-2"><c:out
										value="<%= request.getAttribute("statusUpdatedDateStr") %>"></c:out></span>
							</h6>
							
							
							<h4 class="mb-2">
								
									<c:if test="${businessType == 'Importer'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 10,000.00
									</c:if>
									<c:if test="${businessType == 'WholesalersAndStockists'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 5,000.00
									</c:if>
									<c:if test="${businessType == 'Retailers'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 1,000.00
									</c:if>
									<c:if test="${businessType == 'MajorAndCompactFlourMill'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 3,000.00
									</c:if>
									<c:if test="${businessType == 'RollerFlourMill'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 1,000.00
									</c:if>
									<c:if test="${businessType == 'AttaChakki'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 600.00
									</c:if>
									<c:if test="${businessType == 'AutomaticRiceMill'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 5,000.00
									</c:if>
									<c:if test="${businessType == 'MajorRiceMill'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 4,000.00
									</c:if>
									<c:if test="${businessType == 'HuskingRiceMill'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 1,000.00
									</c:if>
									<c:if test="${businessType == 'Dealer'}">
										<i class="fa-solid fa-bangladeshi-taka-sign"></i> 1,000.00
									</c:if>

								</h4>
								<div>
									<label for="exampleFormControlInput1" class="form-label mb-0"><span
										class="d-block"> <!--Upload Bank Challan--> <liferay-ui:message
												key="upload-bank-challan" /><sup class="text-danger">*</sup>
									</span> </label>
									<!-- <input name="exampleFormControlInput1" type="file" class="form-control w-75"
								id="exampleFormControlInput1" />	 -->

									<aui:input name="PaymentAttchDoc" class="form-control"
										type="file" placeholder="" aria-label="default input example"
										label="">
										<aui:validator name="required"
                                        errorMessage="bank-challan-is-required" />
										
										<aui:validator name="custom"
                                        errorMessage="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb">
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
								</div>

								<a href="/status-check-screen" class="btn button-seceondary me-2">
								<i class="icon-circle-arrow-left"></i>&nbsp;<liferay-ui:message key="back" />
								</a>
								<button class="btn btn-success green-bg border-0" type="submit" name="submit" value="Submit" >
								<liferay-ui:message key="submit" />&nbsp;<i class="icon-circle-arrow-right"></i>
								</button>
							</c:if>
							<c:if test="${status == 'Rejected'}">
								<h4 class="text-uppercase text-danger fw-bold">
									<liferay-ui:message key="rejected" />
								</h4>
								<h6 class="py-1 fw-bold">
								<!--Application Approval Date-->

								<liferay-ui:message key="application-status-updated-on" />
								: <span class="ps-2"><c:out
										value="<%= request.getAttribute("statusUpdatedDateStr") %>"></c:out></span>
							</h6>
							<a href="/status-check-screen" class="btn button-seceondary me-2">
								<i class="icon-circle-arrow-left"></i>&nbsp;<liferay-ui:message key="back" />
								</a>
							</c:if>
							
							
							
						</div>
						<div class="col-md-5 col-sm-12">
							<%-- <aui:input type="hidden" name="bookId"
								value="<%=request.getParameter("bookId")%>" /> --%>
							<div class="mb-2">
								<label for="exampleFormControlInput1" class="form-label mb-0"><span
									class="d-block"> <!--NID NO.--> <liferay-ui:message
											key="nid-no" /><sup class="text-danger"></sup>
								</span> </label>
								<aui:input name="nidNumber" class="form-control" type="text"
									placeholder="" aria-label="default input example" label=""
									value="<%=userPriData.getNationalId()%>" readonly="true">
								</aui:input>
							</div>
							<div class="mb-2">
								<aui:input name="PaymentAttchType" class="form-control"
									type="hidden" placeholder="Auto Populate"
									aria-label="default input example" label="" value="payment">
								</aui:input>
							</div>
							<div>
								<label for="exampleFormControlInput1" class="form-label mb-0"><span
									class="d-block"> <!--Date of Birth--> <liferay-ui:message
											key="date-of-birth" /><sup class="text-danger"></sup>
								</span> </label>
								<aui:input class="w-100 px-2 py-1 px-2 py-1" type="text"
									name="attachmentCreateDate" label=""
									value="<%= request.getAttribute("dob") %>" readonly="true"></aui:input>
							</div>
						</div>
					</div>
					<c:if test="${status == 'Approved'}">
						<p style="font-size:14px" class="green-text lh-1 m-0 py-2"><liferay-ui:message	key="your-application-has-been-approved-your-login-credentials-have-been-sent-on-your-registered-email-or-phone-number-these-credentials-can-be-used-to-access-your-license-details-thank-you" /></p>
					</c:if>
					<c:if test="${status == 'Pending'}">
						<p style="color: #E18700; font-size:14px" class=" lh-1 m-0 py-2"><liferay-ui:message   key="your-application-is-currently-under-review-once-the-there-is-a-change-in-application-status-you-will-receive-notification-message-on-your-registered-email-or-phone-number" /></p>
					</c:if>
					<c:if test="${status == 'Payment Pending'}">
						<p style="color: #E18700;font-size:14px" class=" lh-1 m-0 py-2"><liferay-ui:message	key="your-application-has-been-approved-initially-and-waiting-for-payment-kindly-submit-the-proof-of-payment-by-uploading-the-appropriate-payment-document-once-the-payment-has-been-successfully-verified-you-will-receive-the-login-credentials-on-your-registered-email-or-phone-number-these-credentials-can-be-used-to-access-your-license-details-thank-you" /></p>
					</c:if>
					<c:if test="${status == 'Rejected'}">
						<p style="font-size:14px" class="text-danger lh-1 m-0 py-2"><liferay-ui:message	key="your-application-has-been-rejected-details-have-been-sent-on-your-registered-email-or-phone-number-thank-you" /></p>
					</c:if>

				</aui:form>

			</div>
			<div class="card">
				<div
					class="card-header d-flex justify-content-between align-items-center">
					<!--Application Detail-->
					<liferay-ui:message key="application-detail" />
					<i role="button" class="icon-minus pe-3"></i>
				</div>
				<div class="card_body py-4 p-3">
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

					<h5 class="green-text fw-bold mb-0">
						<!--Basic Info-->
						<liferay-ui:message key="basic-info" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>


					<div class="row justify-content-between px-2 mt-2 ">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- NID Number -->
										<liferay-ui:message key="nid-number" /></span><%=userPriData.getNationalId()%>
											<c:out value="<%= request.getAttribute("nidID") %>"></c:out></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Email Address -->
										<liferay-ui:message key="email-address" /></span> <%=userPriData.getEmail()%></li>

							</ul>
						</div>
					</div>


					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Mobile Number -->
										<liferay-ui:message key="mobile-number" /></span><%=userPriData.getMobileNo() %></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Date of Birth -->
										<liferay-ui:message key="date-of-birth" /></span> <c:out
										value="<%= request.getAttribute("dob") %>"></c:out></li>

							</ul>
						</div>

					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Name of the Applicant -->
										<liferay-ui:message key="name-of-the-applicant" /></span><%=userPriData.getApplicantName()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Father's Name -->
										<liferay-ui:message key="fathers-name" /></span><%=userPriData.getFatherName()%>
								</li>

							</ul>
						</div>

					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Mother's Name -->
										<liferay-ui:message key="mothers-name" /></span><%=userPriData.getMotherName() %></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Gender --> <liferay-ui:message
											key="gender" /></span><%=userPriData.getGender() %></li>

							</ul>
						</div>

					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Marital Status -->
										<liferay-ui:message key="marital-status" /></span><%=userPriData.getMaritalStatus() %></li>

							</ul>
						</div>
					</div>


<h5 class="green-text fw-bold mb-0 mt-2">
	<!--Trade License Info-->
	<liferay-ui:message key="trade-license-info" />
</h5>
<div class="green-bg">
	<hr class="mt-0 mb-0" />
</div>
<div class="row justify-content-between px-2 mt-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Trade License Number-->
					<liferay-ui:message key="trade-license-number" /></span><%=userPriData.getTradeLicenseNo() %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Trade License Expiry Date-->
					<liferay-ui:message key="trade-license-expiry-date" /></span><c:out
					value="<%= request.getAttribute("tradeLicenseExpiryDateString") %>"></c:out></li>

		</ul>
	</div>
</div>



<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Tax identification No (TIN)-->
					<liferay-ui:message key="tax-identification-no-tin" /></span><%=userPriData.getTaxIdentificationNo() %></li>

		</ul>
	</div>

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Business indentification No (BIN)-->
					<liferay-ui:message key="business-identification-no-bin" /></span><%=userPriData.getTaxIdentificationNo() %></li>

		</ul>
	</div>

</div>
<div class="row justify-content-between px-2">
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Trade License issuer Code-->
					<liferay-ui:message key="trade-license-issuer-code" /></span><%=userPriData.getTradeLicenseIssuerCode() %></li>

		</ul>
	</div>


	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!--Trade License issuer City-->
					<liferay-ui:message key="trade-license-issuer-city" /></span><%=userPriData.getTradeLicenseIssuerCity() %></li>

		</ul>
	</div>
</div>
<!-- permanent address start -->
<h5 class="green-text fw-bold mb-0 mt-2 ">
	<!-- Permanent Address -->
	<liferay-ui:message key="permanent-address" />
</h5>
<div class="green-bg">
	<hr class="  mt-0 mb-0" />
</div>
<div class="row justify-content-between px-2 mt-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Region/Division -->
					<liferay-ui:message key="region-division" />
			</span> <%=userRegAddrs.get("nidDivision") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- District / Zilla -->
					<liferay-ui:message key="district-zilla" /></span><%=userRegAddrs.get("nidDistrict") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
						key="upazila" />
			</span><%=userRegAddrs.get("nidUpazila") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
						key="union" />
			</span><%=userRegAddrs.get("nidUnion") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- village --> <liferay-ui:message
						key="village" />
			</span> <%=userRegAddrs.get("nidVillage") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
						key="ward" />
			</span> <%=userRegAddrs.get("nidWard") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">
<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
						key="zip-code" /></span><%=userRegAddrs.get("nidZipCode") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Post Office -->
					<liferay-ui:message key="post-office" />
			</span><%=userRegAddrs.get("nidPostOffice") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- House Address -->
					<liferay-ui:message key="house-address" /></span><%=userRegAddrs.get("nidHouseAddress") %></li>

		</ul>
	</div>
</div>
<!-- permanent address end -->
<h5 class="green-text fw-bold mb-0 mt-2 ">
	<!-- Address -->
	<liferay-ui:message key="present-address" />
</h5>
<div class="green-bg">
	<hr class="  mt-0 mb-0" />
</div>
<div class="row justify-content-between px-2 mt-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Region/Division -->
					<liferay-ui:message key="region-division" />
			</span> <%=userRegAddrs.get("division") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- District / Zilla -->
					<liferay-ui:message key="district-zilla" /></span><%=userRegAddrs.get("district") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
						key="upazila" />
			</span><%=userRegAddrs.get("subdistrict") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
						key="union" />
			</span><%=userRegAddrs.get("union") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- village --> <liferay-ui:message
						key="village" />
			</span> <%=userRegAddrs.get("village") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
						key="ward" />
			</span> <%=userRegAddrs.get("ward") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
						key="zip-code" /></span><%=userRegAddrs.get("zipcode") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Post Office -->
					<liferay-ui:message key="post-office" />
			</span><%=userRegAddrs.get("postoffice") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- House Address -->
					<liferay-ui:message key="house-address" /></span><%=userRegAddrs.get("house") %></li>

		</ul>
	</div>
</div>
<h5 class="green-text fw-bold mb-0 mt-2 ">
<!-- Registered details -->
<liferay-ui:message key="business-details" />
</h5>
<div class="green-bg">
	<hr class="  mt-0 mb-0" />
</div>
<div class="row justify-content-between px-2 mt-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Business name --> <liferay-ui:message
				key="business-name" />
	</span><%=userPriData.getBusinessName()%></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Business Type --> <liferay-ui:message
				key="business-type" />
	</span><%=userPriData.getBusinessType()%></li>

	</ul>
</div>
<div class="col-md-5 col-sm-12">
	<ul class="alignMe">
		<li><span class="custom-colon"> <!-- products type --> <liferay-ui:message
				key="products-type" /></span><%=userPriData.getProductType()%></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Region/Division -->
					<liferay-ui:message key="region-division" />
			</span><%=userRegAddrs.get("busdivision") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- District / Zilla -->
					<liferay-ui:message key="district-zilla" /></span><%=userRegAddrs.get("busdistrict") %></li>

		</ul>
	</div>
</div>
<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
						key="upazila" />
			</span><%=userRegAddrs.get("bussubdistrict") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
						key="union" />
			</span><%=userRegAddrs.get("busunion") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- village --> <liferay-ui:message
						key="village" />
			</span> <%=userRegAddrs.get("busVillage") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
						key="ward" />
			</span><%=userRegAddrs.get("busward") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
						key="zip-code" /></span><%=userRegAddrs.get("buszipcode") %></li>

		</ul>
	</div>
	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- Post Office -->
					<liferay-ui:message key="post-office" />
			</span><%=userRegAddrs.get("buspostoffice") %></li>

		</ul>
	</div>
</div>

<div class="row justify-content-between px-2">

	<div class="col-md-5 col-sm-12">
		<ul class="alignMe">
			<li><span class="custom-colon"> <!-- House Address -->
					<liferay-ui:message key="house-address" /></span><%=userRegAddrs.get("bushouse") %></li>

		</ul>
	</div>
</div>
</br>

<!-- store details preview -->
				<c:choose>
				    <c:when test="<%= hasDgfStoreDtls %>">
				        <!-- Code to display the sections dynamically -->
				       		
					        <h5 class="green-text fw-bold mb-0">
					            <liferay-ui:message key="store-details" />
					        </h5>
				       		
				            <c:forEach var="dgfStoreDtl" items="${dgfStoreDtls}" varStatus="status">  
				            <c:set var="dgfStoreDtlId" value="${dgfStoreDtl.id}"/>
				            <c:set var="storeDivision" value="${dgfStoreDtl.division}"/>
				            <c:set var="storeDistrict" value="${dgfStoreDtl.district}"/>
				            <c:set var="storeUpzilla" value="${dgfStoreDtl.upzilla}"/>
				            <%
				            long dgfStoreDtlId = (Long) pageContext.getAttribute("dgfStoreDtlId");
				            long storeDivisionId = (Long) pageContext.getAttribute("storeDivision");
				            long storeDistrictId = (Long) pageContext.getAttribute("storeDistrict");
				            List<dgfLocDistrict> storeDistricts = dgfLocDistrictLocalServiceUtil.getdivWiseDis(storeDivisionId);
				    		List<dgfLocSubdistrict> storeUpzillas = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(storeDistrictId);
				    		//List<dgfLocUnion> unions = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(userPriData.getBusinessUpzilla());
				    		
				    		pageContext.setAttribute("storeDistricts", storeDistricts);
				    		pageContext.setAttribute("storeUpzillas", storeUpzillas);
				    		Map<Long, Object> storeAddresses = (Map<Long, Object>) request.getAttribute("storeAddresses");		
				    		Map<String, Object> storeAddress = (Map<String, Object>) storeAddresses.get(dgfStoreDtlId);			
				    	    String divisionName =(String) storeAddress.get("division");
							String districtName = (String)storeAddress.get("district");
							String subdistrictName = (String)storeAddress.get("subdistrict");
							String divisionNameBn =(String) storeAddress.get("divisionBn");
							String districtNameBn = (String)storeAddress.get("districtBn");
							String subdistrictNameBn = (String)storeAddress.get("subdistrictBn");
				    		//pageContext.setAttribute("unions", unions);
				            %>      			
								
							<div class="green-bg mb-2">
							
							<hr class="mt-0 mb-0" />
							</div>	
							 <div class="my-3">	
							 <div> 
							 
							 <h6>
							    <mark><liferay-ui:message key="store-no" /><!-- Store No- --> - ${status.index + 1}</mark>
							</h6>
							 
							</br>
							 </div>
							
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="type-of-store" />
												</span>${dgfStoreDtl.type}</li>
				
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="mouza" />
												</span>${dgfStoreDtl.mouza}</li>
				
											</ul>
										</div>						
								</div>	
								
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="khotiyan" />
												</span>${dgfStoreDtl.khatiyn}</li>
				
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="dag-no" />
												</span>${dgfStoreDtl.dagNo}</li>
				
											</ul>
										</div>						
								</div>	
								
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="height" />
												</span>${dgfStoreDtl.dicsHight} <liferay-ui:message key="feet" />.</li>
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="width" />
												</span>${dgfStoreDtl.dicsWidth} <liferay-ui:message key="feet" />.</li>
				
											</ul>
										</div>						
								</div>	
								
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="length" />
												</span>${dgfStoreDtl.dicsLngth} <liferay-ui:message key="feet" />.</li>
				
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="capacity" />
												</span>${dgfStoreDtl.dicsCpacty} <liferay-ui:message key="mt" />.</li>
				
											</ul>
										</div>
										
								</div>	
											
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="division" />
												</span>								
												<c:choose>
												    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												        <%=divisionName %>
												    </c:when>
												    <c:when test="<%=languageId.equals("bn_BD")%>">
												       <%=divisionNameBn %>
												    </c:when>
												</c:choose> 								
												</li>
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="district" />
												</span>
													<c:choose>
												    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												       <%=districtName %>
												    </c:when>
												    <c:when test="<%=languageId.equals("bn_BD")%>">
												       <%=districtNameBn %>
												    </c:when>
												</c:choose>
											
												
												</li>
				
											</ul>
										</div>
										
								</div>				
								
								<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="city-corporation" />
												</span>							
													<c:choose>
												    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												       <%=subdistrictName %>
												    </c:when>
												    <c:when test="<%=languageId.equals("bn_BD")%>">
												      <%=subdistrictNameBn %>
												    </c:when>
												</c:choose>							
												</li>
											</ul>
										</div>
										
								</div> 
								  
							</div>
				          </c:forEach>   
				         <c:set var="totalCapacity" value="0" />

						<c:forEach var="dgfStoreDtl" items="${dgfStoreDtls}" varStatus="status">
							    <c:set var="totalCapacity" value="${totalCapacity + dgfStoreDtl.dicsCpacty}" />
						</c:forEach>
						
						<div class="row  mt-2 justify-content-between px-2" >				
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												
											</ul>
										</div>
										<div class="col-md-5 col-sm-12">
											<ul class="alignMe">
												<li><h6>  <mark>
												<span class="custom-colon"> <!-- Post Office -->
														<liferay-ui:message key="total-capacity" />
														
										
												</span>
													
							    ${totalCapacity} <liferay-ui:message key="mt" />. </mark>  
							</h6>
													
												</li>
				
											</ul>
										</div>
										
								</div>	
						       
								
				    </c:when>
				    <c:otherwise>
				    <span> <liferay-ui:message key="no-store-found" />.<!-- No Store found --></span>
				    </c:otherwise>
				</c:choose>



					<h5 class="green-text fw-bold mb-0 mt-2"><liferay-ui:message key="uploaded-documents" /></h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="mt-3 d-flex align-items-center">
						<c:choose>
							<c:when test="${photographFile == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="photograph" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${tradeLicDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="trade-license-document" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${binDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="business-identification-no-bin" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${tinDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="tax-identification-no-tin" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${bankStat == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="bank-statement-last-3-month" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${bstiClrDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="bsti-clearance-letter-memo" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${electricExemptionDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="electricity-department-addendum-exemption-memo" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${envClrMemoDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="department-of-environment-clearance-memo" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${fireLicNumDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="fire-license-number" />
					</div>
					<div class="mt-2 d-flex align-items-center">
						<c:choose>
							<c:when test="${otherReleventDoc == 'true'}">
								<i class="icon-check-sign fs-4 me-2"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-check-empty fs-4 me-2"></i>
							</c:otherwise>
						</c:choose>
						<liferay-ui:message key="any-other-relevant-document-to-be-attached" />
					</div>
					<div class="row p-2">
						<div class="mt-3 col-md-12">
							<!--  <button class="btn button-seceondary me-2">
              <i class="icon-circle-arrow-left"></i> Back
            </button>
            <button class="btn btn-success green-bg">
              Submit <i class="icon-circle-arrow-right"></i>
            </button> -->
						</div>
					</div>

				</div>
			</div>
	
		</div>

	<script>
      const minus_button = document.querySelector(".icon-minus");
      minus_button.addEventListener("click", () => {
        const card_body = document.querySelector(".card_body");

        if (card_body.style.display === "none") {
          card_body.style.display = "block";
        } else {
          card_body.style.display = "none";
        }
      });
    </script>
</body>




 