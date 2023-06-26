
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="init.jsp"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfStoreDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="java.util.Map"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>

<!DOCTYPE html>
<portlet:defineObjects />

<portlet:actionURL name="addPreviewInfoForm" var="addPreviewInfoFormActionURL" >
	<portlet:param name="mvcPath" value="/form-submission.jsp" />
	   <portlet:param name="pageId" value="4" />
</portlet:actionURL>

<portlet:actionURL name="back" var="backUrl" >
	<portlet:param name="mvcPath" value="/food-grain-license-reg-tradeL-info.jsp" />
	<portlet:param name="pageId" value="3" />
	<portlet:param name="isBack" value="true" />
	<portlet:param name="nationalId" value="<%=renderRequest.getAttribute("nationalId").toString()%>" />
</portlet:actionURL>

<%
	licnsUserRegs userPriData = (licnsUserRegs) renderRequest.getAttribute("userPriData");
	Map<String, String> userRegAddrs = (Map<String, String>) renderRequest.getAttribute("userRegAddrs");
	
	List<DgfStoreDtls> dgfStoreDtls = (List<DgfStoreDtls>)renderRequest.getAttribute("dgfStoreDtls");
	boolean hasDgfStoreDtls = dgfStoreDtls != null && !dgfStoreDtls.isEmpty();
	int storeSize = hasDgfStoreDtls == true ? dgfStoreDtls.size()-1 : 0;
	
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
	String languageId = (String) renderRequest.getAttribute("languageId");
%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>

</head>
<body>
	<div class="main-div">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"> <!--Food Grain License Registration-->
			<liferay-ui:message key="food-grain-license-registration" />
		</span>
		<hr class="mt-1 mb-3" />
			<div
			class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-2">
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr" role="progressbar" aria-valuenow="30"
				aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr" role="progressbar" aria-valuenow="30"
				aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
					<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
		</div>


		<aui:form action="<%=addPreviewInfoFormActionURL%>" name="licenseUserForm" method="POST">
			<aui:input type="hidden" name="nationalId"
				value="<%=renderRequest.getAttribute("nationalId")%>" />
			<div class="container p-3 m-auto">
				<h5 class="green-text text-center fw-bolder mb-3">
					<!--Form Preview-->
					<liferay-ui:message key="form-preview" />
				</h5>
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
										<liferay-ui:message key="nid-number" /></span><%=renderRequest.getAttribute("nationalId")%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Email Address -->
										<liferay-ui:message key="email-address" /></span><%=userPriData.getEmail()%></li>

							</ul>
						</div>
					</div>


					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Mobile Number -->
										<liferay-ui:message key="mobile-number" /></span><%=userPriData.getMobileNo()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Date of Birth -->
										<liferay-ui:message key="date-of-birth" /></span><%=newFormat.format(userPriData.getBirthDate())%></li>

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
										<liferay-ui:message key="mothers-name" /></span><%=userPriData.getMotherName()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Gender --> <liferay-ui:message
											key="gender" /></span><%=userPriData.getGender()%></li>

							</ul>
						</div>

					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Marital Status -->
										<liferay-ui:message key="marital-status" /></span><%=userPriData.getMaritalStatus()%></li>

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
										<liferay-ui:message key="trade-license-number" /></span><%=userPriData.getTradeLicenseNo()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License Expiry Date-->
										<liferay-ui:message key="trade-license-expiry-date" /></span><%=newFormat.format(userPriData.getTradeLicenseExpiryDate())%></li>

							</ul>
						</div>
					</div>



					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Tax identification No (TIN)-->
										<liferay-ui:message key="tax-identification-no-tin" /></span><%=userPriData.getTaxIdentificationNo()%></li>

							</ul>
						</div>

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Business indentification No (BIN)-->
										<liferay-ui:message key="business-identification-no-bin" /></span><%=userPriData.getBusinessIdentificationNo()%></li>

							</ul>
						</div>

					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License issuer Code-->
										<liferay-ui:message key="trade-license-issuer-code" /></span><%=userPriData.getTradeLicenseIssuerCode()%></li>

							</ul>
						</div>


						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!--Trade License issuer City-->
										<liferay-ui:message key="trade-license-issuer-city" /></span><%=userPriData.getTradeLicenseIssuerCity()%></li>

							</ul>
						</div>


					</div>


					<h5 class="green-text fw-bold mb-0 mt-2 ">
						<!-- permanent Address -->
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
									</span>
								<%=userPriData.getNidDivision()%>
								</li>
							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- District / Zilla -->
										<liferay-ui:message key="district-zilla" /></span>
										<%=userPriData.getNidDistrict()%>
								</li>
							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
											key="upazila" />
								</span>
								<%=userPriData.getNidUpzilla()%>
								</li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
											key="union" />
								</span>
								<%=userPriData.getNidUnion()%>
								</li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Village --> <liferay-ui:message
											key="village" />
								</span> <%=userPriData.getNidVillage()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
											key="ward" />
								</span> <%=userPriData.getNidWard()%></li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
											key="zip-code" /></span><%=userPriData.getNidZipCode()%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Post Office -->
										<liferay-ui:message key="post-office" />
								</span><%=userPriData.getNidPostOffice()%></li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2">
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- House Address -->
										<liferay-ui:message key="house-address" /></span><%=userPriData.getNidHouseAddress()%></li>

							</ul>
						</div>
					</div>
					
					
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
									</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.division}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.divisionBn}
								    </c:when>
								</c:choose>
								</li>
							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- District / Zilla -->
										<liferay-ui:message key="district-zilla" /></span>
										<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.district}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.districtBn}
								    </c:when>
								</c:choose>
										</li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
											key="upazila" />
								</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.subdistrict}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.subdistrictBn}
								    </c:when>
								</c:choose>
								</li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
											key="union" />
								</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.union}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.unionBn}
								    </c:when>
								</c:choose>
								</li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- village mohalla --> <liferay-ui:message
											key="village" />
								</span> <%=userRegAddrs.get("village")%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
											key="ward" />
								</span> <%=userRegAddrs.get("ward")%></li>

							</ul>
						</div>
					</div>
					
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
											key="zip-code" /></span><%=userRegAddrs.get("zipcode")%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Post Office -->
										<liferay-ui:message key="post-office" />
								</span><%=userRegAddrs.get("postoffice")%></li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- House Address -->
										<liferay-ui:message key="house-address" /></span><%=userRegAddrs.get("house")%></li>

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
								</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.busdivision}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.busdivisionBn}
								    </c:when>
								</c:choose>
								</li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- District / Zilla -->
										<liferay-ui:message key="district-zilla" /></span>
										<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.busdistrict}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.busdistrictBn}
								    </c:when>
								</c:choose>
										</li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Upzila --> <liferay-ui:message
											key="upazila" />
								</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.bussubdistrict}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.bussubdistrictBn}
								    </c:when>
								</c:choose>
								</li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Union --> <liferay-ui:message
											key="union" />
								</span>
								<c:choose>
								    <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
								        ${userRegAddrs.busunion}
								    </c:when>
								    <c:when test="<%=languageId.equals("bn_BD")%>">
								        ${userRegAddrs.busunionBn}
								    </c:when>
								</c:choose>
								</li>

							</ul>
						</div>
					</div>
					
					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- village mohalla --> <liferay-ui:message
											key="village" /></span><%=userRegAddrs.get("busVillage")%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Ward --> <liferay-ui:message
											key="ward" />
								</span><%=userRegAddrs.get("busward")%></li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Zip Code --> <liferay-ui:message
											key="zip-code" /></span><%=userRegAddrs.get("buszipcode")%></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- Post Office -->
										<liferay-ui:message key="post-office" />
								</span><%=userRegAddrs.get("buspostoffice")%></li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <!-- House Address -->
										<liferay-ui:message key="house-address" /></span><%=userRegAddrs.get("bushouse")%></li>

							</ul>
						</div>
					</div>
				</br>
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
							    <mark><liferay-ui:message key="store-no" />- ${status.index + 1}</mark>
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
													
							    ${totalCapacity} <liferay-ui:message key="mt" />.</mark>  
							</h6>
													
												</li>
				
											</ul>
										</div>
										
								</div>	
						       
								
				    </c:when>
				    <c:otherwise>
				    <span><!-- No Store found --> <liferay-ui:message key="no-store-found" /></span>
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
							<span class="px-md-5 px-sm-1"> 
								<a class="text-decoration-none font-italic" href="<%=userPriData.getPhotographFile()%>" target="_blank">
									<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark>  
								</a>
							</span>
						</div>
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Trade License Document-->
							<liferay-ui:message key="trade-license-document" />
							<span class="px-md-5 px-sm-2"> 
								<a class="text-decoration-none font-italic" href="<%=userPriData.getTradeLicDoc()%>" target="_blank">
									<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark>  
								</a>
							</span>
						</div>
					</div>
					<div class="row justify-content-between px-2 mt-2">
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Business identification No (BIN)-->
							<liferay-ui:message key="business-identification-no-bin" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.binDoc}">
									<a class="text-decoration-none font-italic" href="${userPriData.binDoc}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark>  
									</a>
								</c:if>
							</span>
						</div>
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Tax identification NO (TIN)-->
							<liferay-ui:message key="tax-identification-no-tin" />
							<span class="px-md-5 px-sm-2"> 
								<a class="text-decoration-none font-italic" href="<%=userPriData.getTinDoc()%>" target="_blank">
									<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark>  
								</a>
							</span>
						</div>
					</div>
					<div class="row justify-content-between px-2 mt-2">
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Bank Statement last 3 Month-->
							<liferay-ui:message key="bank-statement-last-3-month" />
							<span class="px-md-5 px-sm-2"> 
								<a class="text-decoration-none font-italic" href="<%=userPriData.getBankStat()%>" target="_blank">
									<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark> 
								</a>
							</span>
						</div>
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!-- BSTI Clearance Letter Memo No. & Date -->
							<liferay-ui:message
								key="bsti-clearance-letter-memo" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.bstiClrMemo}">
									<a class="text-decoration-none font-italic" href="${userPriData.bstiClrMemo}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark> 
									</a>
								</c:if>
							</span>
						</div>
					</div>
					<div class="row justify-content-between px-2 mt-2">
					<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Electricity Department Addendum/Exemption Letter Memo No. & Date-->
							<liferay-ui:message
								key="electricity-department-addendum-exemption-memo" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.electricExemptionMemo}">
									<a class="text-decoration-none font-italic" href="${userPriData.electricExemptionMemo}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark> 
									</a>
								</c:if>
							</span>
						</div>
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Department of Environment clearance memo number and date-->
							<liferay-ui:message
								key="department-of-environment-clearance-memo" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.envClrMemo}">
									<a class="text-decoration-none font-italic" href="${userPriData.envClrMemo}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark> 
									</a>
								</c:if>
							</span>
						</div>
					</div>
					<div class="row justify-content-between px-2 mt-2">
					<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Fire License Number-->
							<liferay-ui:message
								key="fire-license-number" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.fireLicNumDoc}">
									<a class="text-decoration-none font-italic" href="${userPriData.fireLicNumDoc}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark> 
									</a>
								</c:if>
							</span>
						</div>
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<!--Any other relevant Document (of any) to be attached-->
							<liferay-ui:message
								key="any-other-relevant-document-if-any" />
							<span class="px-md-5 px-sm-2"> 
								<c:if test="${not empty userPriData.otherReleventDoc}">
									<a class="text-decoration-none font-italic" href="${userPriData.otherReleventDoc}" target="_blank">
										<mark class="mark ">View <i class="icon-file-text ms-1 ps-1 h6 text-primary"></i></mark>  
									</a>
								</c:if>
							</span>
						</div>
					</div>
					<hr />
					<div>
						<input type="checkbox"
							aria-label="Checkbox for following text input" required /> <liferay-ui:message key="i-hereby-declare-that-all-the-information-i-have-enclosed-in-this-application-is-true-and-correct-if-the-license-is-granted-in-my-favor-i-will-be-bound-to-abide-by-all-the-terms-and-conditions-of-the-license"/>
					</div>
				</div>
				<div class="mt-3">
					<a href="<%=backUrl%>"
						class="btn btn-reset me-2"> <i
						class="fa-solid fa-circle-arrow-left"></i>
					<!-- Back-->
						<liferay-ui:message key="back" />
					</a>

					<button class="btn btn-success green-bg border-0">
						<!--Submit-->
						<liferay-ui:message key="submit" />
						<i class="fa-solid fa-circle-arrow-right"></i>
					</button>
				</div>
			</div>
		</aui:form>
	</div>
</body>
</html>


