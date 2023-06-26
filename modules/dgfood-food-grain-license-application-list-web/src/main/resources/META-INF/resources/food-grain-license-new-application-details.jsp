<%@ include file="init.jsp"%>

<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfStoreDtls"%>
<%@ page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>

<%
	Map<String, Object> detailedDataList = (Map<String, Object>) request.getAttribute("detailedDataList");
	List<String> productValList = (List<String>) renderRequest.getAttribute("productValList");
	String languageId = (String) request.getAttribute("languageId");
	boolean isAcf = Boolean.parseBoolean(renderRequest.getAttribute("isAcf").toString());
	List<DgfStoreDtls> dgfStoreDtls = (List<DgfStoreDtls>)renderRequest.getAttribute("dgfStoreDtls");
  	boolean hasDgfStoreDtls = dgfStoreDtls != null && !dgfStoreDtls.isEmpty();
  	int storeSize = hasDgfStoreDtls == true ? dgfStoreDtls.size()-1 : 0;
%>


<portlet:actionURL name="approvedLicense" var="approvedLicenseURL">
	<portlet:param name="dgfFglPreDtlsId"
		value="<%=renderRequest.getAttribute("dgfFglPreDtlsId").toString()%>" />
	<portlet:param name="id"
		value="<%=renderRequest.getAttribute("id").toString()%>" />
	<portlet:param name="resourceName"
		value="<%=renderRequest.getAttribute("resourceName").toString()%>" />
</portlet:actionURL>



<portlet:renderURL var="renderURL"></portlet:renderURL>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Grain License New Application Details</title>
<style type="text/css">
.alignMe{
	padding-left:0 !important;
} 
</style>
</head>

<body>

	<div class="container main-div">

		<hr class="mt-0 mb-1" />
		<div class="d-flex justify-content-between">

			<span class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="food-grain-license-details" />
			</span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="last-login" /> <span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> |
			</span> <span> <fmt:formatDate type="time" timeStyle="short"
						value="<%=user.getLastLoginDate()%>" /></span>
			</span>

		</div>


		<hr class="mt-1 mb-3" />
		<c:choose>
			<c:when test="${detailedDataList['status'] == 0}">
				<div class="card reviewed-card py-2 px-4 mb-4">
					<h6 class="text-success fw-bold fs-5">
						<liferay-ui:message key="reviewed" />
					</h6>
				</div>
				
				<%
				if (!isAcf) {
				%>
								
				<div class="alert alert-success alert-dismissible fade show" role="alert">
                        <div class="d-flex bd-highlight">
                            <div class=" flex-grow-1 bd-highlight"> <h6 class="mt-3"><liferay-ui:message key="view-approved-food-grain-license"/></h6></div>
                            <div class=" bd-highlight">
                                <h6 class="fw-bold"style="text-transform: uppercase;font-size: 12px;"></h6>
                               <portlet:resourceURL  var="pdfResourceUrl">
                                
    								<portlet:param name="cmd" value="fglLicpdf" />
								</portlet:resourceURL>
								<a class="btn btn-success" href="<%=pdfResourceUrl %>" target="_blank"><liferay-ui:message key="download-pdf"/></a>
                            
                            </div>
                            
                          </div>
                     
                   
                      </div>
					<%
					}
					%>
									
				
			</c:when>
			<c:when test="${detailedDataList['status'] == 4}">
				<div class="card rejected-card py-2 px-4 mb-4">
					<h6 class="text-danger fw-bold fs-5">
						<liferay-ui:message key="rejected" />
					</h6>
				</div>
			</c:when>
			<c:when test="${detailedDataList['status'] == 1}">
				<div class="card pending-card py-2 px-4 mb-4">
					<h6 class="text-warning fw-bold fs-5">
						<liferay-ui:message key="pending" />
					</h6>
				</div>
				
				
			</c:when>
			<c:when test="${detailedDataList['status'] == 6}">
				<div class="card pending-card py-2 px-4 mb-4">
					<h6 class="text-warning fw-bold fs-5">
						<liferay-ui:message key="payment-pending" />
					</h6>
				</div>
			</c:when>
		</c:choose>



	
		<div class="container">
			<div class="card py-4 px-2">
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


				<div class="row p-2">


					<div class="col-md-4 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Application Number -->

									<liferay-ui:message key="application-no" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("fglApplicationNo")%>
								</c:if></li>


						</ul>
					</div>
					<div class="col-md-4 col-sm-12">
						<!-- <ul class="alignMe">
                            <li>
                            <span class="custom-colon">
                                                    <liferay-ui:message key="license-no" /></span>
                            </li>

                        </ul> -->
					</div>
					<div class="col-md-4 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- License Application Type -->
									<liferay-ui:message key="license-application-type" />

							</span> <c:if test="${not empty detailedDataList}">
									<liferay-ui:message
										key="<%=detailedDataList.get("fglLicenseApplicationType").toString().toLowerCase()%>" />
								</c:if></li>

						</ul>
					</div>
				</div>

				<c:if test="${not empty detailedDataList.paymentChallanDocument}">
					<div class="card py-2 px-2 mb-4"
						style="background-color: cornsilk;">

						<h5 class="green-text fw-bold mb-0 mt-3">

							<liferay-ui:message key="proof-of-payment" />
						</h5>
						<div class="green-bg">
							<hr class="mt-0 mb-0" />
						</div>

						<div class="row justify-content-between px-1 div">
							<div
								class="col-md-5 col-sm-12 mt-1 d-flex justify-content-between align-items-center">

								<liferay-ui:message key="challan-details" />

								<span class="px-md-5 px-sm-1"> <c:if
										test="${not empty detailedDataList}">
										<a class="text-decoration-none font-italic"
											href="<%=detailedDataList.get("paymentChallanDocument")%>"
											target="_blank"><mark class="mark ">
												<liferay-ui:message key="view" />
												<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
											</mark></a>
									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">

							</div>
						</div>
						<p class="fw-bold mt-1 p-2" style="color: rgb(112, 156, 68);">
							<small><liferay-ui:message key="note" />:<liferay-ui:message
									key="challan-available-after-proof-of-payment-is-submitted" /></small>
						</p>
					</div>
				</c:if>

				<div class="row p-2">
					<div class="col-md-12 col-sm-12">
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
											<liferay-ui:message key="nid-number" /></span> <c:if
											test="${not empty detailedDataList}">
											<%=detailedDataList.get("nidNumber")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Email Address -->
											<liferay-ui:message key="email-address" /></span> <c:if
											test="${not empty detailedDataList}"><%=detailedDataList.get("Email")%>
										</c:if></li>

								</ul>
							</div>
						</div>


						<div class="row justify-content-between px-2">
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Mobile Number -->
											<liferay-ui:message key="mobile-number" />

									</span> <c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("mobileNumber")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Date of Birth -->
											<liferay-ui:message key="date-of-birth" /></span> <c:if
											test="${not empty detailedDataList}">
											<%=detailedDataList.get("dateOfBirth")%></c:if></li>

								</ul>
							</div>

						</div>
						<div class="row justify-content-between px-2">
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Name of the Applicant -->
											<liferay-ui:message key="name-of-the-applicant" /></span> <c:if
											test="${not empty detailedDataList}">
											<%=detailedDataList.get("nameOfTheApllicant")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Father's Name -->
											<liferay-ui:message key="fathers-name" /></span> <c:if
											test="${not empty detailedDataList}">
											<%=detailedDataList.get("fatherName")%></c:if></li>

								</ul>
							</div>

						</div>
						<div class="row justify-content-between px-2">
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Mother's Name -->
											<liferay-ui:message key="mothers-name" /></span> <c:if
											test="${not empty detailedDataList}">
											<%=detailedDataList.get("motherName")%></c:if></li>

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
						<div class="row justify-content-between px-2">
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <!-- Marital Status -->
											<liferay-ui:message key="marital-status" /></span> <c:if
											test="${not empty detailedDataList}">
											<liferay-ui:message
												key="<%=detailedDataList.get("maritalStatus").toString().toLowerCase()%>" />
										</c:if></li>
								</ul>
							</div>
						</div>
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
									<liferay-ui:message key="trade-license-number" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("tradeLicenseNumber")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!--Trade License Expiry Date-->
									<liferay-ui:message key="trade-license-expiry-date" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("tradeLicenseExpiryDate")%></c:if></li>

						</ul>
					</div>
				</div>



				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!--Tax identification No (TIN)-->
									<liferay-ui:message key="tax-identification-no-tin" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("tin")%>
								</c:if></li>

						</ul>
					</div>

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!--Business indentification No (BIN)-->
									<liferay-ui:message key="business-identification-no-bin" /></span> <c:if
									test="${not empty detailedDataList}"><%=detailedDataList.get("bin")%>
								</c:if></li>

						</ul>
					</div>

				</div>
				<div class="row justify-content-between px-2">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!--Trade License issuer Code-->
									<liferay-ui:message key="trade-license-issuer-code" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("tradeLicenseIssuerCode")%></c:if></li>

						</ul>
					</div>


					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!--Trade License issuer City-->
									<liferay-ui:message key="trade-license-issuer-city" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("tradeLicenseIssuerCity")%></c:if></li>

						</ul>
					</div>


				</div>
				<!-- nid address start  -->
				<h5 class="green-text fw-bold mb-0 mt-2 ">
					<!--permanent Address -->
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

							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidDivision")%>
								</c:if></li>
						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- District / Zilla -->
									<liferay-ui:message key="district-zilla" /></span> 
									<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidDistrict")%>
								</c:if></li>

						</ul>
					</div>
				</div>
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
										key="upazila" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidUpazila")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
										key="union" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidUnion")%>
								</c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- village--> <liferay-ui:message
										key="village" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidVillage")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
										key="ward" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidWard")%>
								</c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
										key="zip-code" /></span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("nidZipCode")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Post Office -->
									<liferay-ui:message key="post-office" />
							</span> <c:if test="${not empty detailedDataList}">
									<%=detailedDataList.get("nidPostOffice")%></c:if></li>

						</ul>
					</div>
				</div>
				<div class="row justify-content-between px-2">
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- House Address -->
									<liferay-ui:message key="house-address" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("nidHouseAddress")%></c:if></li>

						</ul>
					</div>
				</div>
				<!-- nid address end  -->

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

							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("division")%>
										</c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("divisionBn")%>
										</c:if>
									</c:when>
								</c:choose></li>
						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- District / Zilla -->
									<liferay-ui:message key="district-zilla" /></span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("district")%>
										</c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("districtBn")%>
										</c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
				</div>
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
										key="upazila" />
							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("upazila")%>
										</c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("upazilaBn")%>
										</c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
										key="union" />
							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("union")%>
										</c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("unionBn")%>
										</c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
				</div>
				
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- village--> <liferay-ui:message
										key="village" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("village")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
										key="ward" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("ward")%>
								</c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
										key="zip-code" /></span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("zipCode")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Post Office -->
									<liferay-ui:message key="post-office" />
							</span> <c:if test="${not empty detailedDataList}">
									<%=detailedDataList.get("postOffice")%></c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- House Address -->
									<liferay-ui:message key="house-address" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("houseAddress")%></c:if></li>

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
								</span><c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("businessName")%></c:if></li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Business Type --> <liferay-ui:message
											key="business-type" />
								</span><c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("businessType")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- products type --> <liferay-ui:message
											key="products-type" /></span><c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("productType")%></c:if></li>

							</ul>
						</div>
					</div>
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Region/Division -->
									<liferay-ui:message key="region-division" />
							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busDivision")%></c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busDivisionBn")%></c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- District / Zilla -->
									<liferay-ui:message key="district-zilla" /></span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busDistrict")%></c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busDistrictBn")%></c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
				</div>
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
										key="upazila" />
							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busUpazila")%></c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}">
											<%=detailedDataList.get("busUpazilaBn")%></c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
										key="union" />
							</span> <c:choose>
									<c:when
										test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("busUnion")%>
										</c:if>
									</c:when>
									<c:when test="<%=languageId.equals("bn_BD")%>">
										<c:if test="${not empty detailedDataList}"><%=detailedDataList.get("busUnionBn")%>
										</c:if>
									</c:when>
								</c:choose></li>

						</ul>
					</div>
				</div>
				
				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- village--> <liferay-ui:message
										key="village" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("busVillage")%>
								</c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
										key="ward" />
							</span> <c:if test="${not empty detailedDataList}"><%=detailedDataList.get("busWard")%>
								</c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
										key="zip-code" /></span> <c:if test="${not empty detailedDataList}">
									<%=detailedDataList.get("busZipCode")%></c:if></li>

						</ul>
					</div>
					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- Post Office -->
									<liferay-ui:message key="post-office" />
							</span> <c:if test="${not empty detailedDataList}">
									<%=detailedDataList.get("busPostOffice")%></c:if></li>

						</ul>
					</div>
				</div>

				<div class="row justify-content-between px-2">

					<div class="col-md-5 col-sm-12">
						<ul class="alignMe">
							<li><span class="custom-colon"> <!-- House Address -->
									<liferay-ui:message key="house-address" /></span> <c:if
									test="${not empty detailedDataList}">
									<%=detailedDataList.get("busHouseAddress")%></c:if></li>

						</ul>
					</div>
				</div>

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

				<h5 class="green-text fw-bold mb-0 mt-2">
					<!--Uploaded Documents-->
					<liferay-ui:message key="uploaded-documents" />
				</h5>
				<div class="green-bg">
					<hr class="mt-0 mb-0" />
				</div>
				<div class="row justify-content-between px-2 div mt-2">
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Photograph-->
						<liferay-ui:message key="photograph" />
						<span class="px-md-5 px-sm-1"> <c:if
								test="${not empty detailedDataList}">

								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("photograph")%>" target="_blank"><mark
										class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>

							</c:if>
						</span>
					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Trade License Document-->
						<liferay-ui:message key="trade-license-document" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">

								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("tradeLicenseDocument")%>"
									target="_blank"><mark class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>

							</c:if>
						</span>
					</div>
				</div>
				<div class="row justify-content-between px-2 mt-3">
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Business identification No (BIN)-->
						<liferay-ui:message key="business-identification-no-bin" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.binDocument}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("binDocument")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Tax identification NO (TIN)-->
						<liferay-ui:message key="tax-identification-no-tin" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">

								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("tinDocument")%>" target="_blank"><mark
										class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>

							</c:if>
						</span>
					</div>
				</div>
				<div class="row justify-content-between px-2 mt-3">
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Bank Statement last 3 Month-->
						<liferay-ui:message key="bank-statement-last-3-month" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">

								<a class="text-decoration-none font-italic"
									href="<%=detailedDataList.get("bankStatementDocument")%>"
									target="_blank"><mark class="mark ">
										<liferay-ui:message key="view" />
										<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
									</mark></a>

							</c:if>
						</span>
					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--BSTI Clearance Letter Memo No. & Date-->
						<liferay-ui:message key="bsti-clearance-letter-memo" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.bstiClrMemo}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("bstiClrMemo")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
				</div>
				<div class="row justify-content-between px-2 mt-3">
				<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Electricity Department Addendum/Exemption Letter Memo No. & Date-->
						<liferay-ui:message key="electricity-department-addendum-exemption-memo" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.electricExemptionMemo}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("electricExemptionMemo")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Department of Environment clearance memo number and date-->
						<liferay-ui:message key="department-of-environment-clearance-memo" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.envClrMemo}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("envClrMemo")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
				</div>
				<div class="row justify-content-between px-2 mt-3">
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Fire License Number-->
						<liferay-ui:message key="fire-license-number" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.fireLicNumDoc}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("fireLicNumDoc")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
					<div
						class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
						<!--Any other relevant Document (of any) to be attached-->
						<liferay-ui:message key="any-other-relevant-document-if-any" />
						<span class="px-md-5 px-sm-2"> <c:if
								test="${not empty detailedDataList}">
								<c:if test="${not empty detailedDataList.otherReleventDocument}">
									<a class="text-decoration-none font-italic"
										href="<%=detailedDataList.get("otherReleventDocument")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="icon-file-text ms-1 ps-1 h6 text-primary"></i>
										</mark> </a>
								</c:if>
							</c:if>
						</span>
					</div>
				</div>

				<div class="mt-3 p-2">
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
					<a href="<%=renderURL%>" class="btn btn-reset me-2"> <i
						class="me-1"></i> <!-- Back --> <liferay-ui:message
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
								<aui:form action="<%=approvedLicenseURL%>"
									name="approvedNewLicense" method="POST">
						
									<div id="productDetails">
										<c:forEach var="product" items="${productValList}">
											<div class="row text-capitalize ">
												<div
													class="col-md-4">
													<div
														style="margin-bottom: 5px;">
														<label for="productType" style="margin-right: 5px;">
															<liferay-ui:message key="product-type" /> :
														</label>
														<aui:input type="text" name="productType${product}" id="productType"
															aria-label="default input example" label="" readonly="true" value="${product}"
															cssClass="form-control" >
														</aui:input>
													</div>
												</div>
		
												<div
													class="col-md-4">
													<div
														style="margin-bottom: 5px;">
														<label for="stockDuration" style="margin-right: 5px;">
															<liferay-ui:message key="stock-duration-day" /> :
														</label>
														<aui:input type="text" name="stockDuration${product}"
															id="stockDuration" aria-label="default input example"
															label="" required="true" cssClass="form-control" >
															<aui:validator name="required" />
														</aui:input>
													</div>
												</div>
		
												<div
													class="col-md-4">
													<div
														style="margin-bottom: 5px;">
														<label for="stockAmount" style="margin-right: 5px;">
															<liferay-ui:message key="stock-amount-mt-ton" /> :
														</label>
														<aui:input type="text" name="stockAmount${product}" id="stockAmount"
															aria-label="default input example" label="" required="true"
															cssClass="form-control" >
															<aui:validator name="required" />
														</aui:input>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="row text-capitalize ">
										<div class="col-md-12 col-lg-12 col-sm-12 col-12">
											<div
												style="display: flex; align-items: center; justify-content: space-evenly; margin-bottom: 15px;">
												<label for="comments" style="margin-right: 5px;"> <liferay-ui:message
														key="comments" /> 
												</label>
												<aui:input name="companyId" type="hidden"
													value="${companyId}"></aui:input>
												<aui:input name="workflowInstanceId" type="hidden"
													value="${workflowInstanceId}"></aui:input>
												<aui:input name="workflowTaskId" type="hidden"
													value="${workflowTaskId}"></aui:input>
												<aui:input name="transitionName" type="hidden"></aui:input>
												<aui:input name="transitionLabel" type="hidden"></aui:input>


												<aui:input name="comments" class="form-control"
													type="textarea" placeholder="type-here" cols="40" rows="3"
													aria-label="default input example" label="">
													<aui:validator name="required" />
												</aui:input>
											</div>
										</div>
									</div>
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