
<%@page import="javax.portlet.ProcessAction"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.util.jar.JarOutputStream"%>

<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDivision"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ include file="init.jsp"%>
<%@ include file="js/basic_reg_address.js"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>


<%
	//List<dgfLocDivision> division = (List<dgfLocDivision>) renderRequest.getAttribute("division");
	List<dgfLocDivision> divisions = new ArrayList<>();
	try {
		divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	} catch (Exception e) {
		System.out.print("not found division");
	}
	licnsUserRegs userPriData = (licnsUserRegs) renderRequest.getAttribute("userPriData");

	if (userPriData != null && userPriData.getDivision() > 0) {
		List<dgfLocDistrict> districts = dgfLocDistrictLocalServiceUtil
				.getdivWiseDis(userPriData.getDivision());
		List<dgfLocSubdistrict> subdistricts = dgfLocSubdistrictLocalServiceUtil
				.getdisWiseSubDis(userPriData.getDistrict());
		List<dgfLocUnion> unions = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(userPriData.getUpzilla());
		pageContext.setAttribute("districts", districts);
		pageContext.setAttribute("subdistricts", subdistricts);
		pageContext.setAttribute("unions", unions);
	}
	JSONArray nidobj = (JSONArray) renderRequest.getAttribute("nidobj");
	JSONObject nidInfo = null;
	JSONObject nidAddrs = null;
	if (nidobj != null && nidobj.length() > 0) {
		nidInfo = nidobj.getJSONObject(0);
		nidAddrs = nidobj.getJSONObject(0).getJSONObject("permanentAddress");
	}

	pageContext.setAttribute("divisions", divisions);
	String zipCode = userPriData.getZipCode();
	String ward = userPriData.getWard();
	String languageId = (String) renderRequest.getAttribute("languageId");
%>

<!DOCTYPE html>
<portlet:defineObjects />
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<portlet:actionURL name="addBasicInfoForm" var="addBasicInfoFormActionURL" >
	<portlet:param name="mvcPath" value="/food-grain-license-reg-tradeL-info.jsp" />
	   <portlet:param name="pageId" value="2" />
</portlet:actionURL>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>

<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
</head>
<body>

	<div class="main-div">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"> <!-- Food Grain License Registration -->
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
				<div class="prog-hr bg-secondary" role="progressbar"
					aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
				<div class="prog-circle bg-secondary" role="progressbar"
					aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
				<div class="prog-hr bg-secondary" role="progressbar"
					aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
				<div class="prog-circle bg-secondary" role="progressbar"
					aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			</div>

		<aui:form action="<%=addBasicInfoFormActionURL%>" name="licenseUserForm" id="licenseUserForm" method="POST">

			<aui:input type="hidden" name="nationalId"
				value="<%=renderRequest.getAttribute("nationalId")%>" />

			<div class="container m-auto">
				<div class="card py-4 px-5">
					<div class="form_header text-center">
						<span class="m-0 p-0 fw-bold"> <!--Food Grain License Form-B-->
							<liferay-ui:message key="food-grain-license-form-b" />
						</span>
						<h6 class="m-0 p-0 fw-bold">
							<!-- Original Copy -->
							<liferay-ui:message key="original-copy" />
						</h6>
						<h5 class="m-0 p-0 fw-bold green-text">
							<!-- Government of People's Republic of Bangladesh -->
							<liferay-ui:message
								key="government-of-peoples-republic-of-bangladesh" />
						</h5>
						
						<span class="m-0 p-0 fw-bold"> <!-- Food Division Department of Food, Dhaka -->
							<liferay-ui:message key="food-division-department-of-food-dhaka" />
						</span>
						<h6 class="text-uppercase fw-bold pb-3">
							<!-- License for trading and warehousing of food grain/food items -->
							<liferay-ui:message
								key="license-for-trading-and-warehousing-of-food-grain-food-items" />
						</h6>
					</div>
					<h5 class="green-text fw-bold mb-0">
						<!-- Basic Info -->
						<liferay-ui:message key="basic-info" />
					</h5>
					<div class="green-bg mb-1">
						<hr class="mt-0 mb-0" />
					</div>



					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Name of the Applicant --> <liferay-ui:message
									key="name-of-the-applicant" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="applicantName" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=nidInfo == null ? userPriData.getApplicantName()
							: (nidInfo.get("name").equals(null) ? nidInfo.get("nameEn") : nidInfo.get("name"))%>'>
								<%-- <aui:validator name="required"
									errorMessage="applicant-name-is-required" /> --%>

							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Father's Name --> <liferay-ui:message
									key="fathers-name" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="fatherName" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=nidInfo == null ? userPriData.getFatherName() : nidInfo.get("father")%>'>
								<%-- <aui:validator name="required"
									errorMessage="father-name-is-required" /> --%>
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Mother's Name --> <liferay-ui:message
									key="mothers-name" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="motherName" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=nidInfo == null ? userPriData.getMotherName() : nidInfo.get("mother")%>'>
								<%-- <aui:validator name="required"
									errorMessage="mother-name-is-required" /> --%>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Gender --> <liferay-ui:message
									key="gender" /><sup class="text-danger">*</sup>
							</span>

							<div class="form-check form-check-inline">

								<aui:input class="form-check-input" type="radio" name="gender"
									id="inlineRadio1" value="Male" label=""
									checked='<%=nidInfo == null ?  userPriData.getGender().equals("Male") : nidInfo.getString("gender").equals("male")%>'
									disabled='<%=nidInfo == null ? !userPriData.getGender().equals("Male") : !nidInfo.getString("gender").equals("male")%>'>
									<%-- <aui:validator name="required"
										errorMessage="please-select-gender" /> --%>
								</aui:input>
								<label class="form-check-label" for="inlineRadio1"> <!-- Male -->
									<liferay-ui:message key="male" />
								</label>
							</div>


							<div class="form-check form-check-inline">
								<aui:input class="form-check-input" type="radio" name="gender"
									id="inlineRadio2" value="Female" label=""
									checked='<%=nidInfo == null ? userPriData.getGender().equals("Female") : nidInfo.getString("gender").equals("female")%>'
									disabled='<%=nidInfo == null ? !userPriData.getGender().equals("Female") : !nidInfo.getString("gender").equals("female")%>'>
									<%-- <aui:validator name="required"
										errorMessage="please-select-gender" /> --%>
								</aui:input>
								<label class="form-check-label" for="inlineRadio2"> <!-- Female -->
									<liferay-ui:message key="female" />
								</label>
							</div>

							<div class="form-check form-check-inline">
								<aui:input class="form-check-input" type="radio" name="gender"
									id="inlineRadio3" value="third-gender" label=""
									checked='<%=nidInfo == null ? userPriData.getGender().equals("third-gender") : nidInfo.getString("gender").equals("third-gender")%>'
									disabled='<%=nidInfo == null ? !userPriData.getGender().equals("third-gender")  : !nidInfo.getString("gender")
									.equals("third-gender")%>'>
									<%-- 										<aui:validator name="required" --%>
									<%-- 											errorMessage="Please select a gender" /> --%>
								</aui:input>
								<label class="form-check-label" for="inlineRadio3"> <!-- Third Gender -->
									<liferay-ui:message key="third-gender" />
								</label>
							</div>


						</div>
					</div>
					<div class="form-group mt-2 mb-3">
						<span class="d-block"> <!-- Marital Status --> <liferay-ui:message
								key="marital-status" /><sup class="text-danger">*</sup>
						</span>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio"
								name="maritalStatus" id="inlineMaritalRadio1" value="Unmarried"
								checked="${userPriData.maritalStatus == 'Unmarried' }" label="">
								<span> <aui:validator name="required"
										errorMessage="please-select-martial-status" /></span>
							</aui:input>
							<label class="form-check-label"
								for="_bd_gov_dgfood_food_grain_license_portlet_actions_LicenseRegistrationPortlet_INSTANCE_ache_inlineMaritalRadio1">
								<!-- Unmarried --> <liferay-ui:message key="unmarried" />
							</label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio"
								name="maritalStatus" id="inlineMaritalRadio2" value="Married"
								checked="${userPriData.maritalStatus == 'Married' }" label="">

							</aui:input>
							<label class="form-check-label"
								for="_bd_gov_dgfood_food_grain_license_portlet_actions_LicenseRegistrationPortlet_INSTANCE_ache_inlineMaritalRadio2">
								<!-- Married --> <liferay-ui:message key="married" />
							</label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio"
								name="maritalStatus" id="inlineMaritalRadio3" value="Divorced"
								checked="${userPriData.maritalStatus == 'Divorced' }" label="">

							</aui:input>
							<label class="form-check-label"
								for="_bd_gov_dgfood_food_grain_license_portlet_actions_LicenseRegistrationPortlet_INSTANCE_ache_inlineMaritalRadio3">
								<!-- Divorced --> <liferay-ui:message key="divorced" />
							</label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio"
								name="maritalStatus" id="inlineMaritalRadio4" value="Widow"
								checked="${userPriData.maritalStatus == 'Widow' }" label="">

							</aui:input>
							<label class="form-check-label"
								for="_bd_gov_dgfood_food_grain_license_portlet_actions_LicenseRegistrationPortlet_INSTANCE_ache_inlineMaritalRadio4">
								<!-- Widow --> <liferay-ui:message key="widow" />
							</label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio"
								name="maritalStatus" id="inlineMaritalRadio5" value="Widower"
								checked="${userPriData.maritalStatus == 'Widower' }" label="">

							</aui:input>
							<label class="form-check-label"
								for="_bd_gov_dgfood_food_grain_license_portlet_actions_LicenseRegistrationPortlet_INSTANCE_ache_inlineMaritalRadio5">
								<!-- Widower --> <liferay-ui:message key="widower" />
							</label>
						</div>
					</div>
					<h5 class="green-text fw-bold mb-0">
						<!-- Permanent Address -->
						<liferay-ui:message key="permanent-address" />
					</h5>
					<div class="green-bg mb-2">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Region / Division --> <liferay-ui:message
									key="region-division" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidDivision" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("division").equals(null)) ? userPriData.getNidDivision()
							: nidAddrs.get("division")%>'>

							</aui:input>
							<%-- <aui:select class="form-select" name="nidDivision"
									aria-label="Default select example" label="">

									<option selected=true value="<%=nidAddrs.get("division") %>"><%=nidAddrs.get("division")%></option>
									<option selected>Auto Populate</option>
									<option value="1">One</option>
									<option value="2">Two</option>
									<option value="3">Three</option>
								</aui:select> --%>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- District / Zilla --> <liferay-ui:message
									key="district-zilla" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidDistrict" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("district").equals(null)) ? userPriData.getNidDistrict()
							: nidAddrs.get("district")%>'>

							</aui:input>
							<%-- <aui:select class="form-select" name="nidDistrict"
									aria-label="Default select example" label="">
																		<option selected=true value="<%=nidAddrs.get("district")%>"><%=nidAddrs.get("district")%></option>
									<option selected>Auto Populate</option>
									<option value="1">One</option>
									<option value="2">Two</option>
									<option value="3">Three</option>

								</aui:select> --%>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Upazila --> <liferay-ui:message
									key="upazila" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidUpzilla" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("upozila").equals(null)) ? userPriData.getNidUpzilla() : nidAddrs.get("upozila")%>'>

							</aui:input>
							<%-- <aui:select class="form-select" name="nidUpzilla"
									aria-label="Default select example" label="">
																		<option selected=true value="<%=nidAddrs.get("upozila")%>"><%=nidAddrs.get("upozila")%></option>
									<option selected>Auto Populate</option>
									<option value="1">One</option>
									<option value="2">Two</option>
									<option value="3">Three</option>
								</aui:select> --%>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Union --> <liferay-ui:message
									key="union" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidUnion" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("unionOrWard").equals(null)) ? userPriData.getNidUnion()
							: nidAddrs.get("unionOrWard")%>'>

							</aui:input>
							<%-- <aui:select class="form-select" name="nidUnion"
									aria-label="Default select example" label="">
																		<option selected=true value="<%=nidAddrs.get("unionOrWard")%>"><%=nidAddrs.get("unionOrWard")%></option>
									<option selected>Auto Populate</option>
									<option value="1">One</option>
									<option value="2">Two</option>
									<option value="3">Three</option>
								</aui:select> --%>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Village / Mohalla --> <liferay-ui:message
									key="village-mohalla" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidVillage" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("additionalVillageOrRoad").equals(null)) ? userPriData.getNidVillage()
							: nidAddrs.get("additionalVillageOrRoad")%>'>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Ward --> <liferay-ui:message
									key="ward" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidWard" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("wardForUnionPorishod").equals(null)) ? userPriData.getNidWard()
							: nidAddrs.get("wardForUnionPorishod")%>'>

							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Zip Code / Post Code --> <liferay-ui:message
									key="zip-code-post-code" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidZipCode" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("postalCode").equals(null)) ? userPriData.getNidZipCode()
							: nidAddrs.get("postalCode")%>'>

							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Post Office --> <liferay-ui:message
									key="post-office" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="nidPostOffice" class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("postOffice").equals(null)) ? userPriData.getNidZipCode()
							: nidAddrs.get("postOffice")%>'>
							</aui:input>

						</div>
						<div class="mt-2 mb-3">
							<span class="d-block"> <!-- House Address (House No / Flat No. / Plot No. / Landmark) -->
								<liferay-ui:message key="house-address" /><sup
								class="text-danger">*</sup>
							</span>
							<aui:input name="nidHouseAddress" class="form-control"
								type="text" placeholder="auto-populate"
								aria-label="default input example" label="" readonly="true"
								value='<%=(nidAddrs == null || nidAddrs.get("homeOrHoldingNo").equals(null)
							|| nidAddrs.get("homeOrHoldingNo").equals("-")) ? userPriData.getNidHouseAddress() : nidAddrs.get("homeOrHoldingNo")%>'>
							</aui:input>
						</div>

						<h5 class="green-text fw-bold mb-0">
							<!-- Present Address -->
							<liferay-ui:message key="present-address" />
						</h5>
						<div class="green-bg">
							<hr class="mt-0 mb-0" />
						</div>

						<!-- 							<div class="form-check mt-3 mb-2"> -->
						<!-- 								<input class="form-check-input" type="checkbox" value="" -->
						<!-- 									id="flexCheckDefault"
									label="" />
								<label-->
						<!-- 									class="form-check-label" for="flexCheckDefault"> Same as Permanent Address -->
						<%-- 									<liferay-ui:message key="same-as-permanent-address" /> --%>
						<!-- 								</label> -->
						<!-- 							</div> -->

						<div class="row gx-4 mt-2">
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Region / Division --> <liferay-ui:message
										key="region-division" /><sup class="text-danger">*</sup>
								</span>
								<aui:select class="form-select" name="division" id="division"
									aria-label="Default select example" label="">

									<aui:validator name="required"
										errorMessage="division-is-required" />
									<aui:option value="" label="select-a-division" selected="true"
										disabled="true"></aui:option>

									<c:forEach var="division" items="${divisions}">
										<aui:option value="${division.id}"
											selected="${division.id == userPriData.division}">
											<c:choose>
												<c:when
													test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												   		${division.name}
												   </c:when>
												<c:when test="<%=languageId.equals("bn_BD")%>">
														${division.bnName}
													</c:when>
											</c:choose>
										</aui:option>
									</c:forEach>

								</aui:select>
							</div>
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- District / Zilla --> <liferay-ui:message
										key="district-zilla" /><sup class="text-danger">*</sup>
								</span>
								<aui:select class="form-select" name="district" id="district"
									aria-label="Default select example" label="">
									<aui:validator name="required"
										errorMessage="district-is-required" />
									<aui:option value="" label="select-a-district" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="district" items="${districts}">
										<aui:option value="${district.id}"
											selected="${district.id == userPriData.district}">
											<c:choose>
												<c:when
													test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												   		${district.name}
												   </c:when>
												<c:when test="<%=languageId.equals("bn_BD")%>">
														${district.bnName}
													</c:when>
											</c:choose>
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="row gx-4 mt-2">
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Sub District/ Upazila --> <liferay-ui:message
										key="upazila" /><sup class="text-danger">*</sup>
								</span>
								<aui:select class="form-select" name="upzilla" id="upzilla"
									aria-label="Default select example" label="">
									<aui:validator name="required"
										errorMessage="upazila-is-required" />
									<aui:option value="" label="select-a-upzilla" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="subdistrict" items="${subdistricts}">
										<aui:option value="${subdistrict.id}"
											selected="${subdistrict.id == userPriData.upzilla}">
											<c:choose>
												<c:when
													test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												   		${subdistrict.name}
												   </c:when>
												<c:when test="<%=languageId.equals("bn_BD")%>">
														${subdistrict.bnName}
													</c:when>
											</c:choose>
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Union --> <liferay-ui:message
										key="union" /><sup class="text-danger">*</sup>
								</span>
								<aui:select class="form-select" name="unionName" id="unionName"
									aria-label="Default select example" label="">
									<aui:validator name="required" errorMessage="union-is-required" />
									<aui:option value="" label="select-a-union" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="union" items="${unions}">
										<aui:option value="${union.id}"
											selected="${union.id == userPriData.unionName}">
											<c:choose>
												<c:when
													test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
												   		${union.name}
												   </c:when>
												<c:when test="<%=languageId.equals("bn_BD")%>">
														${union.bnName}
													</c:when>
											</c:choose>
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="row gx-4 mt-2">
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Village / Mohalla --> <liferay-ui:message
										key="village-mohalla" /><sup class="text-danger">*</sup>
								</span>
								<aui:input name="village" class="form-control" type="text"
									placeholder="type-here" aria-label="default input example"
									label="" value="<%= userPriData.getVillage() %>">
									<aui:validator name="required"
										errorMessage="village-is-required" />
									<aui:validator
										errorMessage="village-name-can-not-be-more-than-300-characters"
										name="custom">
						                	function(val, fieldNode, ruleValue) {
											var regex = new RegExp(/^.{1,300}$/);
											return regex.test(val);
											}
				        				</aui:validator>
								</aui:input>
							</div>
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Ward --> <liferay-ui:message
										key="ward" /><sup class="text-danger">*</sup>
								</span>
								<aui:input name="ward" class="form-control" type="text"
									placeholder="type-here" aria-label="default input example"
									label="" value="<%=(ward != null) ? ward : ""%>">
									<aui:validator name="required" errorMessage="ward-is-required" />
									<aui:validator
										errorMessage="ward-can-not-be-more-than-10-characters"
										name="custom">
												    function(val, fieldNode, ruleValue) {
												        var regex = /^.{1,10}$/;
												        return regex.test(val);
												    }
												</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="row gx-4 mt-2">
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Zip Code / Post Code --> <liferay-ui:message
										key="zip-code-post-code" /><sup class="text-danger">*</sup>
								</span>
								<aui:input name="zipCode" class="form-control" type="text"
									placeholder="type-here" aria-label="default input example"
									label="" value="<%=(zipCode != null) ? zipCode : ""%>">
									<aui:validator name="required"
										errorMessage="zip-code-is-required" />
									<aui:validator errorMessage="only-4-digit-numbers-are-allowed"
										name="custom">
											    function(val, fieldNode, ruleValue) {
											        var regex = /^(?!0+$)[1-9\u09E6-\u09EF][0-9\u09E6-\u09EF]{3}$/;
											        return regex.test(val);
											    }
											</aui:validator>
								</aui:input>
							</div>
							<div class="col-md-6 col-sm-12">
								<span class="d-block"> <!-- Post Office --> <liferay-ui:message
										key="post-office" /><sup class="text-danger">*</sup>
								</span>
								<aui:input name="postOffice" class="form-control" type="text"
									placeholder="type-here" aria-label="default input example"
									label="" value="<%=userPriData.getPostOffice()%>">
									<aui:validator name="required"
										errorMessage="post-office-is-required" />
									<aui:validator
										errorMessage="post-office-name-can-not-be-more-than-30-characters"
										name="custom">
						                	function(val, fieldNode, ruleValue) {
											var regex = new RegExp(/^.{1,30}$/);
											return regex.test(val);
											}
				        				</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="mt-2 mb-3">
							<span class="d-block"> <!-- House Address (House No / Flat No. / Plot No. / Landmark) -->
								<liferay-ui:message key="house-address" /><sup
								class="text-danger">*</sup>
							</span>
							<aui:input name="houseAddress" class="form-control" type="text"
								placeholder="type-here" aria-label="default input example"
								label="" value="<%=userPriData.getHouseAddress()%>">
								<aui:validator name="required"
									errorMessage="house-address-is-required" />
								<aui:validator
									errorMessage="house-address-can-not-be-more-than-30-characters"
									name="custom">
					                	function(val, fieldNode, ruleValue) {
										var regex = new RegExp(/^.{1,30}$/);
										return regex.test(val);
										}
				        		</aui:validator>
								<%-- <aui:validator
									errorMessage="house-address-can-not-be-more-than-30-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
								    var regex = new RegExp(/^[\u0980-\u09FF\s&&[^-\u09E6-\u09EF]{1,30}$/);
								    return regex.test(val);
								  }
								</aui:validator> --%>
							</aui:input>
						</div>
						<div>
							<button class="btn btn-success green-bg" name="next" id="next">
								<!-- Next -->
								<liferay-ui:message key="next" />
								<i class=" icon-circle-arrow-right"></i>
							</button>
						</div>
					</div>
				</div>
		</aui:form>
	</div>

</body>
</html>