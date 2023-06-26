<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ include file="init.jsp"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDivision"%>
<%@ include file="js/tradeL_reg_address.js"%>
<%@ include file="js/store_reg_address.js"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfStoreDtls"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	List<dgfLocDivision> divisions = new ArrayList<>();
	try {
		divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	} catch (Exception e) {
		System.out.print("not found divisions");
	}
	String[] essentialProductArr = (String[]) renderRequest.getAttribute("essentialProductArr");
	// Construct the product output string with comma-separated values
    StringBuilder productOutput = new StringBuilder();
    for (String productVal : essentialProductArr) {
        if(!productVal.isEmpty()) {
        	productOutput.append(productVal).append(",");
        }
    }

    // Remove the trailing comma if any
    if (productOutput.length() > 0) {
    	productOutput.deleteCharAt(productOutput.length() - 1);
    }
    String essentialProductStr = productOutput.toString();
	licnsUserRegs userPriData = (licnsUserRegs) renderRequest.getAttribute("userPriData");
	
	List<DgfStoreDtls> dgfStoreDtls = (List<DgfStoreDtls>)renderRequest.getAttribute("dgfStoreDtls");
	boolean hasDgfStoreDtls = dgfStoreDtls != null && !dgfStoreDtls.isEmpty();
	int storeSize = hasDgfStoreDtls == true ? dgfStoreDtls.size()-1 : 0;
	
	if(userPriData != null && userPriData.getBusinessDivision()>0) {
		List<dgfLocDistrict> districts = dgfLocDistrictLocalServiceUtil.getdivWiseDis(userPriData.getBusinessDivision());
		List<dgfLocSubdistrict> subdistricts = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(userPriData.getBusinessDistrict());
		List<dgfLocUnion> unions = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(userPriData.getBusinessUpzilla());
		pageContext.setAttribute("districts", districts);
		pageContext.setAttribute("subdistricts", subdistricts);
		pageContext.setAttribute("unions", unions);
	}
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String tradeLicenseExpiryDate = null;
	if(userPriData.getTradeLicenseExpiryDate() !=null) {
		 tradeLicenseExpiryDate = format.format(userPriData.getTradeLicenseExpiryDate());
	}
	pageContext.setAttribute("divisions", divisions);
	String bussZipCode = userPriData.getBusinessZipCode();
	String languageId = (String) renderRequest.getAttribute("languageId");
%>


<portlet:defineObjects />
<portlet:resourceURL var="resourceURL2"></portlet:resourceURL>

<portlet:actionURL name="addTradeLForm" var="addTradeLFormActionURL" >
	<portlet:param name="mvcPath" value="/food-grain-license-preview.jsp" />
	   <portlet:param name="pageId" value="3" />
</portlet:actionURL>

<portlet:actionURL name="back" var="backUrl" >
	<portlet:param name="mvcPath" value="/food-grain-license-reg-basic-info.jsp" />
	<portlet:param name="pageId" value="3" />
	<portlet:param name="isBack" value="true" />
	<portlet:param name="nationalId" value="<%=renderRequest.getAttribute("nationalId").toString()%>" />
</portlet:actionURL>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>


<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
<style type="text/css">
.text-document {
    font-size: 10px;
    margin-top: -20px;
}
</style>

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
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
				
		
		</div>
		<div class="container">
			<div class="card py-4 px-2">
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
					<!-- Trade License Info -->
					<liferay-ui:message key="trade-license-info" />
				</h5>
				<div class="green-bg mb-1">
					<hr class="mt-0 mb-0" />
				</div>

				<aui:form action="<%=addTradeLFormActionURL%>"
					name="licenseUserForm" method="POST" enctype="multipart/form-data">
					<aui:input type="hidden" name="nationalId"
						value="<%=renderRequest.getAttribute("nationalId")%>" />
					<aui:input type="hidden" name="essentialProductStr"
						value="<%=essentialProductStr%>" />
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!-- Trade License Number --> <liferay-ui:message
									key="trade-license-number" /> <sup class="text-danger">*</sup>
							</span>
							<aui:input name="tradeLicenseNo" class="form-control" type="text"
								placeholder="type-here" aria-label="default input example"
								label="" value="<%=userPriData.getTradeLicenseNo() %>">
								<aui:validator name="required"
										errorMessage="trade-license-is-required" />
								<aui:validator
									errorMessage="only-numbers-are-allowed-and-length-does-not-more-than-20-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[0-9]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Trade License Expire Date--> <liferay-ui:message
									key="trade-license-expiry-date" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="tradeLicenseExpiryDate" class="form-control"
								type="date" placeholder="type-here"
								aria-label="default input example" label="" value="<%=tradeLicenseExpiryDate %>">
								<aui:validator name="required"
										errorMessage="trade-license-expiry-date-is-required" />
								<aui:validator
										errorMessage="please-select-future-date"
										name="custom">
										function(val, fieldNode, ruleValue) {
    										var inputDate = new Date(val);

    										if (!val) {
      											return false;
    										}
    										if (inputDate > new Date()) {
      											return true;
    										}
    											return false;
  											}
									</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Tax Identification Number(TIN)-->
								<liferay-ui:message key="tax-identification-no-tin" /><sup
								class="text-danger">*</sup>
							</span>
							<aui:input name="taxIdentificationNo" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getTaxIdentificationNo()%>">
								<aui:validator name="required"
										errorMessage="tax-identification-number-tin-is-required" />
								<aui:validator
									errorMessage="only-numbers-are-allowed-and-length-does-not-more-than-20-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[0-9]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Business Identification Number(BIN)-->
								<liferay-ui:message key="business-identification-no-bin" />
							</span>
							<aui:input name="businessIdentificationNo" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getBusinessIdentificationNo() %>">
								<aui:validator errorMessage="only-numbers-are-allowed-and-length-must-be-9-11-13-characters"
									    name="custom"> 
									    function(val, fieldNode, ruleValue) {
									        var length = val.length;
									        if (length === 9 || length === 11 || length === 13) {
									            var regex = new RegExp(/^(?!0+$)[0-9]+$/);
									            return regex.test(val);
									        }
									    }
								</aui:validator>
							</aui:input>
						</div>

					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Trade License Issuer Code--> <liferay-ui:message
									key="trade-license-issuer-code" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="tradeLicenseIssuerCode" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getTradeLicenseIssuerCode() %>">
								<aui:validator name="required"
										errorMessage="trade-license-issuer-code-is-required" />
								<aui:validator
									errorMessage="only-numbers-are-allowed-and-length-does-not-more-than-20-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[0-9]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Trade License Issure City--> <liferay-ui:message
									key="trade-license-issuer-city" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="tradeLicenseIssuerCity" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getTradeLicenseIssuerCity() %>">
								<aui:validator name="required"
										errorMessage="trade-license-issuer-city-is-required" />
								<aui:validator
									errorMessage="only-alphabets-are-allowed-and-length-does-not-more-than-20-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[A-Za-z\u0980-\u09FF\0-9]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
							</aui:input>
						</div>

					</div>
					<h5 class="green-text fw-bold mb-0">
						<!--Business Details( As per Your Trade License) & registered Address-->
						<liferay-ui:message
							key="business-details-as-per-your-trade-license-&-registered-address" />
					</h5>
					<div class="green-bg mb-2">
						<hr class="mt-0 mb-0" />
					</div>

					<div class="row gx-4 mt-2">

						<div class="col-md-12">
							<span class="d-block"> <!--Business Name--> <liferay-ui:message
									key="business-name" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="businessName" class="form-control" type="text"
								placeholder="type-here" aria-label="default input example"
								label="" value="<%=userPriData.getBusinessName() %>">
								<aui:validator name="required"
										errorMessage="business-name-is-required" />
								<aui:validator
									errorMessage="only-alphabets-are-allowed-and-length-does-not-more-than-20-characters" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[A-Z,a-z, ,\u0980-\u09FF]{1,30}$/);
											return regex.test(val);
					                }
        		 				</aui:validator>
										
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">

						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Type of Business--> <liferay-ui:message
									key="type-of-business" />&nbsp;<liferay-ui:message key="retailer-dealer-miller-wholesaler-impoter-expoter" /><sup class="text-danger">*</sup>
							</span>
							<aui:select name="businessType" class="form-select"
								aria-label="Default select example" label="">
								<aui:validator name="required"
										errorMessage="business-type-is-required" />
								<aui:option value="" label="select-a-business"selected="true" disabled="true"></aui:option>
								<aui:option value="Importer" selected='${"Importer" == userPriData.businessType}'><liferay-ui:message key="importer" /></aui:option>
								<aui:option value="WholesalersAndStockists"  selected='${"WholesalersAndStockists" == userPriData.businessType}'><liferay-ui:message key="wholesalers-and-Stockists" /></aui:option>
								<aui:option value="Retailers"  selected='${"Retailers" == userPriData.businessType}'><liferay-ui:message key="retailers" /></aui:option>
								<aui:option value="MajorFlourMill" selected='${"MajorFlourMill" == userPriData.businessType}'><liferay-ui:message key="major-flour-mill" /></aui:option>
								<aui:option value="CompactFlourMill" selected='${"CompactFlourMill" == userPriData.businessType}'><liferay-ui:message key="compact-flour-mill" /></aui:option>
								<aui:option value="RollerFlourMill" selected='${"RollerFlourMill" == userPriData.businessType}'><liferay-ui:message key="roller-flour-mill" /></aui:option>
								<aui:option value="AttaChakki"  selected='${"AttaChakki" == userPriData.businessType}'><liferay-ui:message key="atta-chakki" /></aui:option>
								<aui:option value="AutomaticRiceMill" selected='${"AutomaticRiceMill" == userPriData.businessType}'><liferay-ui:message key="automatic-rice-mill" /></aui:option>
								<aui:option value="MajorRiceMill" selected='${"MajorRiceMill" == userPriData.businessType}'><liferay-ui:message key="major-rice-mill" /></aui:option>
								<aui:option value="HuskingRiceMill" selected='${"HuskingRiceMill" == userPriData.businessType}'><liferay-ui:message key="husking-rice-mill" /></aui:option>
								<aui:option value="Dealer" selected='${"Dealer" == userPriData.businessType}'><liferay-ui:message key="dealer" /></aui:option>
								<aui:option value="SemiAutomatic" selected='${"SemiAutomatic" == userPriData.businessType}'><liferay-ui:message key="semi-automatic" /></aui:option>
							
							</aui:select>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Type of products--> <liferay-ui:message
									key="type-of-products" />&nbsp;<liferay-ui:message key="paddy-rice-wheat-flour-etc" /><sup class="text-danger">*</sup>
							</span>
							<div class="row" id="checkboxes">
					            <c:forEach var="product" items="${essentialProductArr}">
					             	<div class="col-md-6 col-sm-12">
					             		<div class="d-flex justify-content-start form-check form-check-inline">
				                			<aui:input class="form-check-input" name="productType${product.toLowerCase()}" label="" type="checkbox" id="${product}" checked="${userPriData.productType.contains(product.toUpperCase())}" value="${product.toUpperCase()}">
				                			</aui:input>
				                			<label class="mb-4 ms-3 fw-normal form-check-label" for="${product}">
				                			<liferay-ui:message key="${product.toLowerCase()}" /></label>
					           			</div>
					             	</div>
					            </c:forEach>  
					        </div>
						</div>

					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Region / Division--> <liferay-ui:message
									key="region-division" /><sup class="text-danger">*</sup>
							</span>
							<aui:select name="businessDivision" id="businessDivision"
								class="form-select" aria-label="Default select example" label="">
								
								 <aui:validator name="required" errorMessage="division-is-required" /> 

								<aui:option value="" label="select-a-division"
									selected="true" disabled="true"></aui:option>

								<c:forEach var="division" items="${divisions}">
									<aui:option value="${division.id}" selected="${division.id == userPriData.businessDivision}">
										<c:choose>
										   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
							<span class="d-block"> <!--District / Zilla--> <liferay-ui:message
									key="district-zilla" /><sup class="text-danger">*</sup>
							</span>
							<aui:select name="businessDistrict" id="businessDistrict"
								class="form-select" aria-label="Default select example" label="">
								 <aui:validator name="required" errorMessage="district-is-required" /> 

								<aui:option value="" label="select-a-district"
									selected="true" disabled="true"></aui:option>
								<c:forEach var="district" items="${districts}">
									<aui:option value="${district.id}" selected="${district.id == userPriData.businessDistrict}">
									<c:choose>
									   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
							<span class="d-block"> <!--Upazila--> <liferay-ui:message
									key="upazila" /><sup class="text-danger">*</sup>
							</span>
							<aui:select class="form-select" name="businessUpzilla"
								id="businessUpzilla" aria-label="Default select example" label="">
								 <aui:validator name="required" errorMessage="upazila-is-required" /> 

								<aui:option value="" label="select-a-upzilla"
									selected="true" disabled="true"></aui:option>
								<c:forEach var="subdistrict" items="${subdistricts}">
									<aui:option value="${subdistrict.id}" selected="${subdistrict.id == userPriData.businessUpzilla}">
										<c:choose>
										   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
							<span class="d-block"> <!--Union--> <liferay-ui:message
									key="union" /><sup class="text-danger">*</sup>
							</span>
							<aui:select name="businessUnionName" id="businessUnionName"
								class="form-select" aria-label="Default select example" label="">
								 <aui:validator name="required" errorMessage="union-is-required" /> 

								<aui:option value="" label="select-a-union"
									selected="true" disabled="true"></aui:option>
								<c:forEach var="union" items="${unions}">
									<aui:option value="${union.id}" selected="${union.id == userPriData.businessUnionName}">
										<c:choose>
											   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
							<span class="d-block"> <!--Village / Mohalla--> <liferay-ui:message
									key="village-mohalla" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="businessVillage" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getBusinessVillage() %>">
								<aui:validator name="required" errorMessage="village-is-required" />
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
							<span class="d-block"> <!--Ward--> <liferay-ui:message
									key="ward" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="businessWard" class="form-control" type="text"
								placeholder="type-here" aria-label="default input example"
								label="" value="<%=userPriData.getBusinessWard() %>">
								<aui:validator name="required" errorMessage="ward-is-required" />
								<aui:validator errorMessage="ward-can-not-be-more-than-10-characters"
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
							<span class="d-block"> <!--Zip Code / Post Code--> <liferay-ui:message
									key="zip-code-post-code" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="businessZipCode" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%= (bussZipCode != null)?bussZipCode:"" %>">
								<aui:validator name="required" errorMessage="zip-code-is-required" />
										<aui:validator errorMessage="only-4-digit-numbers-are-allowed" name="custom">
											    function(val, fieldNode, ruleValue) {
											        var regex = /^(?!0+$)[1-9\u09E6-\u09EF][0-9\u09E6-\u09EF]{3}$/;
											        return regex.test(val);
											    }
											</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block"> <!--Post Office--> <liferay-ui:message
									key="post-office" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="businessPostOffice" class="form-control"
								type="text" placeholder="type-here"
								aria-label="default input example" label="" value="<%=userPriData.getBusinessPostOffice() %>">
								<aui:validator name="required" errorMessage="post-office-is-required" />
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
						<span class="d-block"> <!--House Address (House No / Flat No. / Plot No. / Landmark)-->
							<liferay-ui:message key="house-address" /><sup
							class="text-danger">*</sup>
						</span>
						<aui:input name="businessHouseAddress" class="form-control"
							type="text" placeholder="type-here"
							aria-label="default input example" label="" value="<%=userPriData.getBusinessHouseAddress() %>">
							<aui:validator name="required" errorMessage="house-address-is-required" />
									<aui:validator
										errorMessage="house-address-can-not-be-more-than-30-characters"
										name="custom">
					                	function(val, fieldNode, ruleValue) {
										var regex = new RegExp(/^.{1,30}$/);
										return regex.test(val);
										}
				        		</aui:validator>
						</aui:input>
					</div>
					
					
			<!-- ===================== -->
			
<c:choose>
    <c:when test="<%= hasDgfStoreDtls %>">
        <!-- Code to display the sections dynamically -->
        <h5 class="green-text fw-bold mb-0">
            <liferay-ui:message key="store-details" />
        </h5>
        <div class="green-bg mb-2">
			<hr class="mt-0 mb-0" />
		</div>	
				
       		
            <c:forEach var="dgfStoreDtl" items="${dgfStoreDtls}" varStatus="status">  
            <c:set var="dgfStoreDtlId" value="${dgfStoreDtl.id}"/>
            <c:set var="storeDivision" value="${dgfStoreDtl.division}"/>
            <c:set var="storeDistrict" value="${dgfStoreDtl.district}"/>
            <c:set var="storeUpzilla" value="${dgfStoreDtl.upzilla}"/>
            <%
            
            long storeDivisionId = (Long) pageContext.getAttribute("storeDivision");
            long storeDistrictId = (Long) pageContext.getAttribute("storeDistrict");
            List<dgfLocDistrict> storeDistricts = dgfLocDistrictLocalServiceUtil.getdivWiseDis(storeDivisionId);
    		List<dgfLocSubdistrict> storeUpzillas = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(storeDistrictId);
    		//List<dgfLocUnion> unions = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(userPriData.getBusinessUpzilla());
    		pageContext.setAttribute("storeDistricts", storeDistricts);
    		pageContext.setAttribute("storeUpzillas", storeUpzillas);
    		//pageContext.setAttribute("unions", unions);
            %>      			
				
					
				<div class="row gx-4 mt-2 storeSection" id="section-to-clone${status.index}">
						<h5 class="fw-bold mb-0" style="display:none" id="singleStore">
							<liferay-ui:message key="must-contain-atleast-one-store" />
						</h5>
					<div class="d-flex justify-content-end"> 
				  
					<input id="remove0" name="remove0" type="button"   class="btn btn-outline-danger fw-bold me-2" value=" X " onclick="removeStore(${status.index}, ${dgfStoreDtl.id})"/> 
				 		   				    
				    </div>
				        <div class="col-md-6 col-sm-12 col-lg-6 col-12">
				            
				        <aui:input type="hidden"  name="storeId${status.index}" value="${dgfStoreDtl.id}" required="true"/>
                        <aui:select name="storeType${status.index}" >
                        	<option value="" selected="true"  disabled="true"><liferay-ui:message	key="select" /> </option>
                            <option value="kacha" <c:if test="${dgfStoreDtl.type=='kacha'}">selected="true"</c:if>><liferay-ui:message	key="kacha" /></option>
                            <option value="adha-paka" <c:if test="${dgfStoreDtl.type=='adha-paka'}">selected="true"</c:if>><liferay-ui:message	key="adha-paka" /></option>
                            <option value="paka" <c:if test="${dgfStoreDtl.type=='paka'}">selected="true"</c:if>><liferay-ui:message	key="paka" /></option>
                        </aui:select>
                  
				        </div>
				        <div class="col-md-6 col-sm-12 col-lg-6 col-12">
				            <div class="row">
				               <div class="col-md-4 col-sm-12">
                                <aui:input type="text" label="mouza" name="mouza${status.index}" value="${dgfStoreDtl.mouza}" required="true">
                                    <aui:validator name="required" errorMessage="muza-number-is-required"></aui:validator>
                                </aui:input>
                            </div>
                            <div class="col-md-4 col-sm-12">
                                <aui:input type="text" label="khotiyan" name="khotiyan${status.index}" value="${dgfStoreDtl.khatiyn}" required="true">
                                    <aui:validator name="required" errorMessage="khotiyan-number-is-required"></aui:validator>
                                </aui:input>
                            </div>
                            <div class="col-md-4 col-sm-12">
                                <aui:input type="text" label="dag" name="dag${status.index}" value="${dgfStoreDtl.dagNo}" required="true">
                                    <aui:validator name="required" errorMessage="dag-number-is-required"></aui:validator>
                                </aui:input>
                            </div>
				            </div>
				        </div>
				           <div class="row gx-4 mt-2">
				           
				           <div class="col-md-6 col-12">
				            <div class="row">
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text"  label="height<small class='text-muted'>  (in Feet .) </small>" name="height${status.index}" value="${dgfStoreDtl.dicsHight}"  required="true">
				                        <aui:validator name="required" errorMessage="height-is-required"></aui:validator>
				                        
				                         
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text" label="width<small class='text-muted'> (in Feet. )  </small>" name="width${status.index}" value="${dgfStoreDtl.dicsWidth}"  placeholder="auto-populate" required="true">
				                        <aui:validator name="required" errorMessage="width-is-required" ></aui:validator>
				                       <%--  <aui:validator  errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-20-characters">
				                         function(val, fieldNode, ruleValue) {
				                                var regex = new RegExp(/^[A-Z,a-z, ,\u0980-\u09FF]{1,30}$/);
				                                return regex.test(val);
				                            }
				                        </aui:validator> --%>
				                       
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text" label="length<small class='text-muted'>  (in Feet.)  </small>" name="length${status.index}" value="${dgfStoreDtl.dicsLngth}" placeholder="auto-populate" required="true">
				                        <aui:validator name="required" errorMessage="length-is-required"></aui:validator>
				                        
				                         
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="number" label="capacity<small class='text-muted'>  (in MT.)</small>" name="capacity${status.index}" value="${dgfStoreDtl.dicsCpacty}" placeholder="auto-populate" required="true">
				                        <aui:validator name="required" errorMessage="capacity-is-required"></aui:validator>
				                       		                       
				                    </aui:input>
				                </div>
				            </div>
				        </div>
				           
				        <div class="col-md-6 col-12">
				            <div class="row">
				                <div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--Region / Division--> <liferay-ui:message
													key="region-division" /><sup class="text-danger">*</sup>
											</span>
											<aui:select name="storeDivision${status.index}"
												class="form-select" aria-label="Default select example" label="" onChange="changeDistrict(this)">
												
												 <%-- <aui:validator name="required" errorMessage="division-is-required" />  --%>
				
												<aui:option value="" label="select-a-division"
													selected="true" disabled="true"></aui:option>
				
												<c:forEach var="division" items="${divisions}">
													<aui:option value="${division.id}" selected="${division.id == dgfStoreDtl.division}">
														<c:choose>
														   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
										<div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--District / Zilla--> <liferay-ui:message
													key="district-zilla" /><sup class="text-danger">*</sup>
											</span>
											<aui:select name="storeDistrict${status.index}"
											  class="form-select" aria-label="Default select example" label="" onChange="changeUpazilla(this)">
				
												<aui:option value="" label="select-a-district"
													selected="true" disabled="true"></aui:option>
												<c:forEach var="district" items="${storeDistricts}">
													<aui:option value="${district.id}" selected="${district.id == dgfStoreDtl.district}">
													<c:choose>
													   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
										<div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--Upazila--> <liferay-ui:message
													key="upazila" /><sup class="text-danger">*</sup>
											</span>
											<aui:select class="form-select" name="storeUpzilla${status.index}" aria-label="Default select example" label="">
												 <%-- <aui:validator name="required" errorMessage="upazila-is-required" />  --%>
				
												<aui:option value="" label="select-a-upzilla"
													selected="true" disabled="true"></aui:option>
												<c:forEach var="subdistrict" items="${storeUpzillas}">
													<aui:option value="${subdistrict.id}" selected="${subdistrict.id == dgfStoreDtl.upzilla}">
														<c:choose>
														   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
										
				                <%-- <div class="col-md-3 col-sm-12">
				                    <aui:input type="number" name="cityCorporation0" label="city-Corporation" placeholder="auto-populate" required="true">
				                        <aui:validator name="required" errorMessage="This feild is required"></aui:validator>
				                        
				                    </aui:input>
				                </div> --%>
				            </div>
				        </div>
				        
				    </div>
				    
				     
				    
					
				     <div class="green-bg my-4">	    
						<hr class="mt-0 mb-0" />
					</div>
				    </div>
            </c:forEach>
           	<div id="sections-container" ></div>
     		 <div class="d-flex justify-content-end">
		 		<input id="plus" name="plus" type="button" class="btn green-bg fw-bold me-2" value=" + "/> 
					
		    	<br>		   				    
		    </div>  
        
				
    </c:when>
    <c:otherwise>
					<h5 class="green-text fw-bold mb-0">
						<liferay-ui:message key="store-details" />
					</h5>
					<div class="green-bg mb-2">
						<hr class="mt-0 mb-0" />
					</div>
								
				
				<div class="row gx-4 mt-2 storeSection" id="section-to-clone0">
						<h5 class="fw-bold mb-0" style="display:none" id="singleStore">
							<liferay-ui:message key="must-contain-atleast-one-store" />
						</h5>
				        <div class="col-md-6 col-sm-12 col-lg-6 col-12">
				            
				            <aui:select name="storeType0" required="true">
				                <option value="" selected="true" disabled="true">Select </option>
				                <option  value="kacha">kacha</option>
				                <option value="adha-paka">adha-paka</option>
				                <option value="paka">paka </option>
				            </aui:select>
				        </div>
				        <div class="col-md-6 col-sm-12 col-lg-6 col-12">
				            <div class="row">
				                <div class="col-md-4 col-sm-12">
				                    <aui:input type="text" label="mouza" name="mouza0" value="" required="true">
				                        <aui:validator name="required"  errorMessage="mouza-number-is-required"></aui:validator>
				                        
				                    </aui:input>
				                </div>
				                <div class="col-md-4 col-sm-12">
				                    <aui:input type="text" label="khotiyan" name="khotiyan0" value="" required="true">
				                        <aui:validator name="required"  errorMessage="khotiyan-number-is-required"></aui:validator>
				                        
				                    </aui:input>
				                </div>
				                <div class="col-md-4 col-sm-12">
				                    <aui:input type="text" label="dag" name="dag0" required="true">
				                        <aui:validator name="required" errorMessage="dag-number-is-required"></aui:validator>
				                       
				                    </aui:input>
				                </div>
				            </div>
				        </div>
				           <div class="row gx-4 mt-2">
				           
				           <div class="col-md-6 col-12">
				            <div class="row">
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text"  label="height<small class='text-muted'> (in Feet. )  </small>" name="height0" placeholder="type-here" required="true">
				                        <aui:validator name="required" errorMessage="height-is-required"></aui:validator>
				                        
				                         
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text" label="width<small class='text-muted'> (in Feet. )  </small>" name="width0" placeholder="type-here" required="true">
				                        <aui:validator name="required" errorMessage="width-is-required" ></aui:validator>
				                       <%--  <aui:validator  errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-20-characters">
				                         function(val, fieldNode, ruleValue) {
				                                var regex = new RegExp(/^[A-Z,a-z, ,\u0980-\u09FF]{1,30}$/);
				                                return regex.test(val);
				                            }
				                        </aui:validator> --%>
				                       
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="text" label="length<small class='text-muted'> (in Feet. )  </small>" name="length0" placeholder="type-here" required="true">
				                        <aui:validator name="required" errorMessage="length-is-required"></aui:validator>
				                        
				                         
				                    </aui:input>
				                </div>
				                <div class="col-md-3 col-sm-12">
				                    <aui:input type="number" label="capacity<small class='text-muted'> (in MT. )  </small>" name="capacity0" placeholder="type-here" required="true">
				                        <aui:validator name="required" errorMessage="capacity-is-required"></aui:validator>
				                    </aui:input>
				                </div>
				            </div>
				        </div>
				           
				        <div class="col-md-6 col-12">
				            <div class="row">
				                <div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--Region / Division--> <liferay-ui:message
													key="region-division" /><sup class="text-danger">*</sup>
											</span>
											<aui:select name="storeDivision0"
												class="form-select division-select" aria-label="Default select example" label="" onChange="changeDistrict(this)">
												
												 <%-- <aui:validator name="required" errorMessage="division-is-required" />  --%>
				
												<aui:option value="" label="select-a-division"
													selected="true" disabled="true"></aui:option>
				
												<c:forEach var="division" items="${divisions}">
													<aui:option value="${division.id}">
														<c:choose>
														   <c:when test="<%=languageId.equals("en_US")||languageId.equals("en_GB")%>">
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
										<div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--District / Zilla--> <liferay-ui:message
													key="district-zilla" /><sup class="text-danger">*</sup>
											</span>
											<aui:select name="storeDistrict0" 
												class="form-select district-select" aria-label="Default select example" label="" onChange="changeUpazilla(this)">
				
												<aui:option value="" label="select-a-district"
													selected="true" disabled="true"></aui:option>
											</aui:select>
										</div>
										<div class="col-md-4 col-sm-12">
											<span class="d-block"> <!--Upazila--> <liferay-ui:message
													key="upazilla" /><sup class="text-danger">*</sup>
											</span>
											<aui:select class="form-select upzilla-select" name="storeUpzilla0" aria-label="Default select example" label="">
				
												<aui:option value="" label="select-a-upzilla"
													selected="true" disabled="true"></aui:option>
											</aui:select>
										</div>
				            </div>
				        </div>
				    </div>
				    
				    <div class="d-flex justify-content-end">
				  
						 <input id="remove0" name="remove0" type="button" class="btn green-bg fw-bold me-2" value=" X " onclick="removeStore(0,0)"/> 
				 		   				    
				    </div>  
				       <br>
				    
				   
				   	 <div class="green-bg my-4">	    
							<hr class="mt-0 mb-0" />
						</div>
				    </div>
				     <div id="sections-container" ></div>
				  <div class="d-flex justify-content-end">
				  
				 <input id="plus" name="plus" type="button" class="btn green-bg fw-bold me-2" value=" + "/> 
				 <br>		   				    
			 </div>  
	</c:otherwise>
</c:choose>
				<!-- ========================= -->
	<aui:input type="hidden" id="counterInput" name="counterInput" value="<%= storeSize %>" readOnly="true" /> 
					

					<h5 class="green-text fw-bold mb-0">
						<!--Upload Documents-->
						<liferay-ui:message key="upload-documents" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>

					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Photograph --> <liferay-ui:message
									key="photograph" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="photographFile" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
									<aui:validator name="required"
										errorMessage="photograph-is-required" />
									<aui:validator errorMessage="only-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|jpeg|png)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="photographAttchType" class="form-control"
										type="hidden" value="other">
							</aui:input>
							
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Trade License Document -->
								<liferay-ui:message key="trade-license-document" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="tradeLicDoc" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
								<aui:validator name="required"
										errorMessage="trade-license-document-is-required" />
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="tradeLicAttchType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Business Identification Document(BIN) -->
								<liferay-ui:message key="business-identification-no-bin" /><sup
								class="text-danger"></sup>
							</span>
							<aui:input name="binDoc" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="binAttchType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Tax Identification Document(TIN) -->
								<liferay-ui:message key="tax-identification-no-tin" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="tinDoc" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
								<aui:validator name="required"
										errorMessage="tax-identification-number-tin-is-required" />
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="tinAttchType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Bank Statement 3 Month -->
								<liferay-ui:message key="bank-statement-last-3-month" /><sup class="text-danger">*</sup>
							</span>
							<aui:input name="bankStat" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
								<aui:validator name="required"
										errorMessage="bank-statement-is-required" />
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="bankStatAttchType" class="form-control"
										type="hidden" value="payment">
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- BSTI Clearance Letter Memo No. & Date -->
								<liferay-ui:message key="bsti-clearance-letter-memo" />
							</span>
							<aui:input name="bstiClrMemo" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="bstiClrMemoType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
					</div>
					<!-- New attachment added  -->
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Electricity Department Addendum/Exemption Letter Memo No. & Date -->
								<liferay-ui:message key="electricity-department-addendum-exemption-memo" />
							</span>
							<aui:input name="electricExemptionMemo" class="form-control" type="file"
								placeholder="choose-file" aria-label="default input example"
								label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="electricExemptionMemoType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Department of Environment clearance memo number and date -->
								<liferay-ui:message
									key="department-of-environment-clearance-memo" />
							</span>
							<aui:input name="envClrMemo" class="form-control"
								type="file" placeholder="choose-file"
								aria-label="default input example" label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="envClrMemoType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
					</div>
					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Fire License Number -->
								<liferay-ui:message
									key="fire-license-number" />
							</span>
							<aui:input name="fireLicNumDoc" class="form-control"
								type="file" placeholder="choose-file"
								aria-label="default input example" label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="fireLicNumDocType" class="form-control"
										type="hidden" value="license">
							</aui:input>
						</div>
						<div class="col-md-6 col-sm-12">
							<span class="d-block fw-bold"> <!-- Any othe Relevent Document(If Any) For the Attachement -->
								<liferay-ui:message
									key="any-other-relevant-document-if-any-to-be-attached" />
							</span>
							<aui:input name="otherReleventDoc" class="form-control"
								type="file" placeholder="choose-file"
								aria-label="default input example" label="">
									<aui:validator errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed"
										    name="custom">
									    function formatValidation(val) {
										    var regex = /\.(jpg|png|jpeg|pdf|doc|docx)$/i;
										    return regex.test(val);
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
							<span class="text-document d-block"><liferay-ui:message key="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed-max-file-size-can-be-200-kb"/></span>
							<aui:input name="otherReleventAttchType" class="form-control"
										type="hidden" value="other">
							</aui:input>
						</div>
					</div>
					<div class="mt-2">
						<a class="btn btn-reset me-2" href="<%=backUrl%>">
							<i class="icon-circle-arrow-left"></i>
							<!-- Back-->
							<liferay-ui:message key="back" />
						</a>
						<button class="btn btn-success green-bg">
							<!--Next-->
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
				  var  file = new File([blob], fileUrl.split('_').slice(1).join('_'), {
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
	 			 if(fileInputName.includes("photographFile")) {
	 				fileUrl = '<%=userPriData.getPhotographFile() %>';
	 			 } else if(fileInputName.includes("tradeLicDoc")){
	 				fileUrl = '<%=userPriData.getTradeLicDoc() %>';	
	 			 }else if(fileInputName.includes("binDoc")){
	 				fileUrl = '<%=userPriData.getBinDoc() %>';		
	 			 }else if(fileInputName.includes("tinDoc")){
	 				fileUrl = '<%=userPriData.getTinDoc() %>';
	 			 }else if(fileInputName.includes("bankStat")){
	 				fileUrl = '<%=userPriData.getBankStat() %>';
	 			 }else if(fileInputName.includes("electricExemptionMemo")){
	 				fileUrl = '<%=userPriData.getElectricExemptionMemo() %>';
	 			 }else if(fileInputName.includes("envClrMemo")){
	 				fileUrl = '<%=userPriData.getEnvClrMemo() %>';
	 			 }else if(fileInputName.includes("bstiClrMemo")){
	 				fileUrl = '<%=userPriData.getBstiClrMemo() %>';
	 			 }else if(fileInputName.includes("fireLicNumDoc")){
	 				fileUrl = '<%=userPriData.getFireLicNumDoc() %>';
	 			 }else if(fileInputName.includes("otherReleventDoc")){
	 				fileUrl = '<%=userPriData.getOtherReleventDoc() %>';
	 			 }
				 return fileUrl;
 			}
    </script>
    
   <aui:script>
    AUI().use('node', function(A) {
        var addButton = A.one('#plus');
        var counterInput = A.one('#<portlet:namespace />counterInput');
		var counter = counterInput.get('value');
		var newRemoveId;
        addButton.on('click', function(e) {
        	document.getElementById("singleStore").style.display="none";
        	var originalSection = A.one('#'+document.querySelectorAll(".storeSection")[0].id).cloneNode(true);;
            counter++;
			counterInput.set('value', counter);
            // Always clone the original node, not the potentially modified section node
            var sectionElement = originalSection.cloneNode(true);
            sectionElement.set('id',  'section-to-clone'+counter);
            
            var inputs = sectionElement.all('input, select, textarea');

            inputs.each(function(input, index) {
               var name = input.get('name');
               var id = input.get('id');
               input.set('value', "");
    			// Remove the last character from the name attribute
    			name = name.substring(0, name.length - 1) + counter;
    			id = id.substring(0, id.length - 1) + counter;
                input.set('name', name);
                input.set('id', id);
                  
                input.set('required', 'true');
                input.set('aria-required', true);
                
                 if(id.substring(0, id.length - 1) == 'remove') {
               		input.set('value', " - ");
               		newRemoveId = id;
               		}
               		
            });
			
            A.one('#sections-container').append(sectionElement);
            document.getElementById(newRemoveId).setAttribute( "onClick", "removeStore("+ counter+ ",0);" );
        	
        });
    });
</aui:script>
    
</body>
</html>