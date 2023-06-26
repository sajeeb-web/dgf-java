
<%@ include file="init.jsp" %>
<%@page import="javax.portlet.ProcessAction"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.util.jar.JarOutputStream"%>

<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDivision"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ include file="js/user_creation.js"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>



<%
List<dgfLocDivision> divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
pageContext.setAttribute("divisions", divisions);
%> 

 <!DOCTYPE html>
 <portlet:defineObjects />
<%--   <portlet:renderURL var="renderURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value="/add-successfully.jsp" />
</portlet:renderURL> --%>
 <portlet:resourceURL var="resourceURL"></portlet:resourceURL>
 
 <portlet:actionURL name="addNewUserAction"
	var="addNewUserActionURL" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DG Food</title>
    <link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">


  </head>
  <body>
   
      <div class="container ">
        <hr class="mt-3 mb-1" />
        <span class="fs-5 fw-bold p-0 m-0">
        Create User Form
        </span>
        <hr class="mt-1 mb-3" />
          <div class="card card-width px-4 py-3">
            <!-- <div class="form_header text-center">
              <h6 class="m-0 p-0 fw-bold">Food Grain License Form</h6>
              <h6 class="m-0 p-0 fw-bold">Original Copy</h6>
              <h5 class="m-0 p-0 fw-bold green-text">
                Government of People's Republic of Bangladesh
              </h5>
              <h6 class="m-0 p-0 fw-bold">
                Ministry of Food And Disaster Management
              </h6>
              <h6 class="m-0 p-0 fw-bold">
                Food Division Department of Food, Dhaka
              </h6>
            </div> -->

            <h5 class="green-text mb-0">Personal Info</h5>
            <div class="green-bg">
              <hr class="m-0" />
            </div>
            <aui:form action="<%=addNewUserActionURL%>">
              <div class="row g-4 mt-1">
                <div class="col-md-6">
                  <span class="d-block fw-bold"
                    ><!-- First Name --><liferay-ui:message key="first-name"/><sup class="text-danger">*</sup></span
                  >
                  <aui:input name="firstName" class="w-100 px-2 py-1" type="text" label="">
                  	<aui:validator name="required" errorMessage="first-name-is-required" />
                  </aui:input>
                </div>
                <div class="col-md-6">
                  <span class="d-block fw-bold"><!-- Last Name --><liferay-ui:message key="last-name"/></span>
                  <aui:input name="lastName" class="w-100 px-2 py-1" type="text" label="">
                  	<aui:validator name="required" errorMessage="last-name-is-required" />
                  </aui:input>
                </div>
              </div>
              <div class="row g-4 mt-1">
                <div class="col-md-6">
                  <span class="d-block fw-bold"
                    ><liferay-ui:message key="nid-number"/><sup class="text-danger">*</sup></span
                  >
                  <aui:input name="nationalId" class="w-100 px-2 py-1" type="text" label="" >
                  	<aui:validator name="required" />
                  	<aui:validator errorMessage="enter-a-valid-nid-number"
									    name="custom"> 
					    function(val, fieldNode, ruleValue) {
					        var length = val.length;
					        if (length === 10 || length === 13 || length === 17) {
					            var regex = new RegExp(/^(?!0+$)[0-9]+$/);
					            return regex.test(val);
					        }
					    }
					</aui:validator>
					<aui:validator errorMessage="user-already-exists-with-this-nid" name="custom">
		                		function(val, fieldNode, ruleValue) {
		                		var nationalId = A.one('#<portlet:namespace />nationalId').val();
		                		var isUser = false;
								   AUI().use('aui-io-request', function(A){
								        A.io.request('${resourceURL}', {
								               method: 'post',
								               data: {
								               	   <portlet:namespace />cmd: 'checkUserByNid',
								                   <portlet:namespace />nationalId: val,
								               },
								               sync: true,
								               on: {
								                       success: function() {
								                        var json = JSON.parse(this.get('responseData'))
								                       isUser = !json.isUser;
								                   }
								              }
								        });
								        
								    });
							     return isUser;
		                		}
		        			</aui:validator>
                  </aui:input>
                </div>
              
                  <div class="col-md-6">
                    <span class="d-block fw-bold"><!-- Email Address --><liferay-ui:message key="email-address"/></span>
                    <aui:input name="email" class="w-100 px-2 py-1" type="email" label="" >
                    	<aui:validator name="required" />
                    	<aui:validator errorMessage="enter-a-valid-email-address"
										name="custom">
							function(val, fieldNode, ruleValue) {
	                     				var regex = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/);
								return regex.test(val);
	             					}
						</aui:validator>
						<aui:validator errorMessage="user-already-exists-with-this-email" name="custom">
		                		function(val, fieldNode, ruleValue) {
		                		var nationalId = A.one('#<portlet:namespace />nationalId').val();
		                		var isUser = false;
								   AUI().use('aui-io-request', function(A){
								        A.io.request('${resourceURL}', {
								               method: 'post',
								               data: {
								               	   <portlet:namespace />cmd: 'checkUserByEmail',
								                   <portlet:namespace />email: val,
								               },
								               sync: true,
								               on: {
								                       success: function() {
								                        var json = JSON.parse(this.get('responseData'))
								                       isUser = !json.isUser;
								                   }
								              }
								        });
								        
								    });
							     return isUser;
		                		}
		        			</aui:validator>
                    </aui:input>
                  </div>
                </div>
                
                <div class="row g-4 mt-0">
                  <div class="col-md-6">
                    <span class="d-block fw-bold"
                    ><!--Mobile Number--><liferay-ui:message key="mobile-number"/><sup class="text-danger">*</sup></span
                  >
                    <aui:input class="w-100 px-2 py-1 px-2 py-1" type="text" placeholder="" name="mobileNo" label="">
                    	<%-- <aui:validator name="required"/> --%>
                    	<aui:validator errorMessage="enter-a-valid-mobile-number"
										name="custom">
							function(val, fieldNode, ruleValue) {
                      				var regex = new RegExp(/^(?!0+$)[0][1][1-9][0-9]{8}$/);
								return regex.test(val);
              					}
						</aui:validator>
                    </aui:input>
                  </div>
                  <div class="col-md-6">
                    <span class="d-block fw-bold"><!-- Password --><liferay-ui:message key="password"/><sup class="text-danger">*</sup></span>
                    <aui:input name="password" class="w-100 px-2 py-1" type="password" label="" >
                    	<aui:validator name="required"/>
                    	<aui:validator
										errorMessage="use-at-least-1-lower-case-1-upper-case-1-digit-one-special-character-and-is-at-least-8-to-16-characters-long"
										name="custom">
							function(val, fieldNode, ruleValue) {
   								var regex = new RegExp(/^(?=.*[A-Z])(?=.*[\W])(?=.*[0-9])(?=.*[a-z]).{8,16}$/);
   								return regex.test(val);
							}
						</aui:validator>
                    </aui:input>
                  </div>
                </div>
           
              <h5 class="green-text mb-0"><!-- Worked Area Info --><liferay-ui:message key="worked-area-info"/></h5>
              <div class="green-bg">
                <hr class="m-0" />
              </div>
              <div class="row g-4 mt-1">
                <div class="col-md-6 col-sm-12">
                  <span class="d-block  fw-bold"
                    ><!-- User Role --><liferay-ui:message key="user-role"/><sup class="text-danger">*</sup></span
                  >
                  <aui:select class="form-select" name="userRole" id="userRole"
											aria-label="Default select example" label="">

						<aui:validator name="required"
							errorMessage="user-role-is-required" />
						<aui:option value="" label="please-select-an-option"
							selected="true" disabled="true"></aui:option>
							<aui:option value="DCF">DCF</aui:option>
							<aui:option value="ACF">ACF</aui:option>
							<aui:option value="UCF">UCF</aui:option>
							<aui:option value="RCF">RCF</aui:option>
							<aui:option value="CCDR">CCDR</aui:option>
					</aui:select>
                </div>
                <div class="col-md-6 col-sm-12">
                  <span class="d-block  fw-bold"
                    ><!-- Region/Division --><liferay-ui:message key="region-division" /><sup class="text-danger">*</sup></span
                  >
                  <aui:select class="form-select" name="division" id="division"
											aria-label="Default select example" label="">

						<aui:validator name="required"
							errorMessage="division-is-required" />
						<aui:option value="" label="please-select-an-option"
							 disabled="true"></aui:option>
							 <c:forEach var="division" items="${divisions}">
								<aui:option value="${division.id}">${division.name}</aui:option>
						</c:forEach>
					</aui:select>
                </div>
              </div>
               <div class="row g-4 mt-1">
                <div class="col-md-6 col-sm-12">
                  <span class="d-block  fw-bold"
                    ><!-- District / Zilla --> <liferay-ui:message key="district-zilla" /><sup class="text-danger">*</sup></span
                  >
                  <aui:select class="form-select" name="district" id="district"
											aria-label="Default select example" label="">
						<aui:validator name="required"
							errorMessage="district-is-required" />
						<aui:option value="" label="please-select-an-option"
							 disabled="true"></aui:option>
							<c:forEach var="district" items="${districts}">
								<aui:option value="${district.id}">${district.name}</aui:option>
						</c:forEach>
					</aui:select>
                </div>
                <div class="col-md-6 col-sm-12">
                  <span class="d-block  fw-bold"
                    ><!-- Sub District/ Upazila --> <liferay-ui:message key="upazila" /><sup class="text-danger">*</sup></span
                  >
                  <aui:select class="form-select" name="upzilla" id="upzilla"
											aria-label="Default select example" label="">
						<aui:validator name="required"
							errorMessage="upazila-is-required" />
						<aui:option value="" label="please-select-an-option"
							selected="true" disabled="true"></aui:option>
							<c:forEach var="subdistrict" items="${subdistricts}">
								<aui:option value="${subdistrict.id}">${subdistrict.name}</aui:option>
						</c:forEach>
					</aui:select>
                </div>
              </div>
              <div class="row g-4 mt-1">
                <div class="col-md-6 col-sm-12">
                  <span class="d-block  fw-bold"
                    ><!-- Union --> <liferay-ui:message key="union" /><sup class="text-danger">*</sup></span
                  >
                  <aui:select class="form-select" name="unionName"
											id="unionName" aria-label="Default select example" label="">
						<aui:validator name="required"
							errorMessage="union-is-required" />
						<aui:option value="" label="please-select-an-option"
							selected="true" disabled="true"></aui:option>
							<c:forEach var="union" items="${unions}">
								<aui:option value="${union.id}">${union.name}</aui:option>
						</c:forEach>
					</aui:select>
                </div>
               
               
              </div>
          
              <button class="btn btn-success mt-4 px-5 green-bg border-0" id="add_user_btn">
                <!-- Submit --><liferay-ui:message key="submit" /><i class="fa-regular fa-circle-right ms-1"></i>
                 </button>
          </div>
        </aui:form>
      </div>

 
  </body>
</html>
