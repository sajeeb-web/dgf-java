 <%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.licnsUserRegs"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page
	import="bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm"%>
<%@ page
	import="bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportCFormLocalServiceUtil"%>


<liferay-ui:success key="successMessage"
	message="Fortnightly Report Form C submitted successfully." />
<liferay-ui:error key="errorMessage"
	message="An error occurred while submitting the Fortnightly Report." />
<!DOCTYPE html>

<%
DgfFglPreDtls dgfFglPreDtls = (DgfFglPreDtls) request.getAttribute("dgfFglPreDtlsObj");
	DgfFglLicDtls licDtlsObj = (DgfFglLicDtls) request.getAttribute("dgfFglLicDtlsObj");
	licnsUserRegs userRegsObj = (licnsUserRegs) request.getAttribute("userRegsObj");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
	User currentUser = (User) request.getAttribute("currentUser");
	
%>


<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
<title>DG Food</title>
</head>

<body>
	<div class="px-md-5 px-sm-3 px-1 text-capitalize">
			<section class=" border-2 borderall">
			
			<hr class="mt-3 mb-1" />
		<div class="d-flex justify-content-between">
			<span class="fw-bold p-0 m-0"><liferay-ui:message key="fortnightly-report-form-ga" /></span>
			<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>

                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
		</div>
		<hr class="mt-1 mb-3" />

			<section class="borderall">
				<div class="lists py-2 ">
					<article class="py-2">
						<span></span> <span class="listNo"><liferay-ui:message
								key="name-of-licensee" /> : <span class="mx-1"> 
								
							 <%
								if (userRegsObj != null) {
								 %> <%=userRegsObj.getApplicantName() %> <%
								} else {
							 %> No data found. <%
										 	}
							 %>
								
								
					</span>
					</article>
					<article class="py-1">
						<span></span> <span class="listNo"><liferay-ui:message
								key="address" />: <span class="mx-1">
								
							 <%
							 	if (userRegsObj != null) {
							 %><%=request.getAttribute("unionName") %>,  <%=request.getAttribute("subDistrictName") %> , <%=request.getAttribute("districtName") %>  <%
							 	} else {
							 %> No data found. <%
							 	}
							 %>

						</span>
					</article>
					<article class="py-1">
						<span></span> <span class="listNo"> <liferay-ui:message
								key="license-number" />: <span class="mx-1">
								
							 <%
							 	if (userRegsObj != null) {
							 %> <%=request.getAttribute("licenseNo") %>  <%
							 	} else {
							 %> No data found. <%
							 	}
							 %>


						</span>
					</article>
					<article class="py-2">
						<p>
							<liferay-ui:message key="type" />
							:
							
							 <%
							 	if (userRegsObj != null) {
							 %> <%=userRegsObj.getBusinessType() %> <%
							 	} else {
							 %> No data found. <%
							 	}
							 %>
							
						</p>
					</article>

				</div>
			</section>
		</section>

		<portlet:defineObjects />
	
		<portlet:actionURL name="submitFormURL" var="submitFormURL" />

		<aui:form id="reportForm" class="fortnight-report-form mb-5"
			action="<%=submitFormURL%>" method="post">

			<div class="container border-2 borderall">

				<h6 class="mb-2">
					<liferay-ui:message key="fortnightly-report-form" />
				</h6>

				<div class="row">
					<div class="col-md-3 ">
						<h5 class="ui-message">
							<liferay-ui:message key="from" />
						</h5>
						<aui:input type="date" id="startDate" name="startDate"
							required="true" label="from" />
					</div>
					<div class="col-md-3 ">
						<h5 class="ui-message">
							<liferay-ui:message key="to" />
						</h5>
						<aui:input type="date" id="endDate" name="endDate" required="true"
							label="to" />
					</div>
					<div class="col-md-3 "></div>
					<div class="col-md-3 "></div>
				</div>
				<div id="<portlet:namespace />errorMessage" style="color: red;"></div>

				</article>

			</div>

			<section
				class="container data-th-container table-responsive mt-lg-2 my-4">

				<div class="border-1   text-capitalize">
					<div class="row">
						<div class="col-md-3 col-lg-3 col-sm-4 col-12">
							<h5 class="ui-message">
								<liferay-ui:message key="unsold-product" />
							</h5>
							<aui:input type="text" name="UnsoldProduct" required="true"
								cssClass="form-control" />

						</div>

						<div class="col-md-9 col-lg-9 col-sm-8 col-12">
							<h5 class="ui-message">
								<liferay-ui:message key="reason-for-being-unsold" />
							</h5>
							<aui:input type="text" name="reasonForBeingUnsold"
								required="true" cssClass="form-control" />


						</div>
					</div>

					<div class="row">

						<div class="col-md-5 col-lg-5 col-sm-12 col-12">
							<h5 class="ui-message">
								<liferay-ui:message key="date-of-receipt" />
							</h5>

							<aui:input type="date" name="DateReceipt" required="true"
								placeholder="<liferay-ui:message key='31/12/2023' />"
								cssClass="form-control" />


						</div>
						<div class="col-md-7 col-lg-7 col-sm-12 col-12">
							<div class="row">
								<div class="col-md-6">
									<h5 class="ui-message">
										<liferay-ui:message key="receive-quantity" />
									</h5>
									<aui:input type="number" required="true" name="receiveQuantity" />
								</div>
								<div class="col-md-6">
									<h5 class="ui-message">
										<liferay-ui:message key="receive-unit" />
									</h5>
									<aui:select name="receivedUnit">
										<option disabled>Unit</option>
										<option value="MT">MT</option>
										<option selected value="KG">KG</option>
									</aui:select>
								</div>
							</div>

						</div>

					</div>

					<div class="row">

						<div class="col-md-5 col-lg-5 col-sm-12 col-12">
							<h5 class="ui-message">
								<liferay-ui:message key="last-date-approve" />
							</h5>
							<aui:input type="date" name="lastDateApprove" required="true"
								placeholder="<liferay-ui:message key='l5/02/2022' />"
								cssClass="form-control" />


						</div>
						<div class="col-md-7 col-lg-7 col-sm-12 col-12">
							<div class="row">
								<div class="col-md-6">
									<h5 class="ui-message">
										<liferay-ui:message key="unsold-quantity" />
									</h5>
									<aui:input type="number" name="unsoldQuantity" required="true"
										cssClass="form-control" />
								</div>
								<div class="col-md-6">
									<h5 class="ui-message">
										<liferay-ui:message key="unsold-unit" />
									</h5>
									<aui:select name="unsoldUnit">
										<option disabled>Unit</option>
										<option value="MT">MT</option>
										<option selected value="KG">KG</option>
									</aui:select>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="row ">
					<div class="col-md-12 d-flex ">
					 <aui:input type="hidden" name="redirect" value="/main.jsp" />
					
					<button  class="btn btn-secondary me-2" onclick="javascript:window.history.go(-1);" title="Go Back">
   														 <i class="icon-circle-arrow-left"></i>&nbsp;<liferay-ui:message key="back" />  
													</button>
						

						<button class="btn btn-success green-bg border-0 me-2" name="submitButton" type="submit" id="<portlet:namespace />submitButton"

							value="Submit"><liferay-ui:message key="submit" />&nbsp;<i class="icon-circle-arrow-right"></i></button>
							

													
					</div>
				</div>
			</section>

		</aui:form>

	</div>

			<aui:script use="aui-node,aui-modal">
				    AUI().use('aui-node','aui-modal', function(A) {
				        const startDateInput = A.one('#<portlet:namespace />startDate');
				        const endDateInput = A.one('#<portlet:namespace />endDate');
				        const errorMessage = A.one('#<portlet:namespace />errorMessage');
				        const submitButton = A.one('#<portlet:namespace />submitButton');
				        
				        function validateDateRange() {
				            const startDate = new Date(startDateInput.get('value'));
				            const endDate = new Date(endDateInput.get('value'));
				            
				            const oneDay = 24 * 60 * 60 * 1000; // hours*minutes*seconds*milliseconds
				            const daysDifference = Math.round(Math.abs((endDate - startDate) / oneDay));
				
				            if (startDate > endDate) {
				                errorMessage.set('text', "<liferay-ui:message key='start-date-can-not-be-greater-than-end-date'/>");
				                // Disable submit button
				                
				                submitButton.setAttribute('disabled', 'disabled');
				            } else if (daysDifference > 14) {
				                errorMessage.set('text', "<liferay-ui:message key='the-date-range-cannot-exceed-15-days'/>");
				                // Disable submit button
				                submitButton.setAttribute('disabled', 'disabled');
				            } else {
				                errorMessage.set('text', '');
				                // Enable submit button
				                submitButton.removeAttribute('disabled');
				            }
				        }
						// Show popup if userRegsObj is null
					     <% if (userRegsObj == null) { %>
					            const popup = new A.Modal({
					                bodyContent: 'Error: Please Login Frist For fill up the form .',
					                centered: true,
					                headerContent: '<h4>No User Found </h4>',
					                render: true,
					                zIndex: 9999,
					                toolbars: {
					                    footer: [
					                        {
					                            label: 'Close',
					                            cssClass: 'btn btn-primary',
					                            on: {
					                                click: function() {
					                                    popup.hide();
					                                }
					                            }
					                        }
					                    ]
					                }
					            });
					            popup.show();
					            // Disable submit button
					            submitButton.setAttribute('disabled', 'disabled');
					     <% } %>
					     
				        startDateInput.on('input', validateDateRange);
				        endDateInput.on('input', validateDateRange);
				    });
				</aui:script>
				
				<script type="text/javascript">
				
				function applyCustomStylesToBackButtons() {
			        var backBtns = document.querySelectorAll('.back-btn');

			        backBtns.forEach(function (btn3) {
			            btn3.style.backgroundColor = '#C4C4C4';
			            btn3.style.color = '#000000';
			            btn3.style.display = 'inline-block'; 
			            btn3.style.borderRadius = '4px';
			            btn3.style.borderWidth = '0px';
			            btn3.style.clear = 'both';
			            btn3.style.cursor = 'pointer';
			            btn3.style.display = 'flex';
			            btn3.style.fontWeight = '400';
			            btn3.style.overflow = 'hidden';
			            btn3.style.padding = '4px 10px';
			            btn3.style.position = 'relative';
			            btn3.style.textAlign = 'inherit';
			            btn3.style.transition = 'none';
			            btn3.style.overflowWrap = 'break-word';
			            btn3.style.wordWrap = 'break-word';
			            btn3.style.fontSize = 'inherit';
			            btn3.style.alignContent = 'space-between';
			            btn3.style.justifyContent = 'flex-end';
			            btn3.style.alignItems = 'center';
			            
			  
			        });
			    }
				document.addEventListener('DOMContentLoaded', applyCustomStylesToBackButtons);
				</script>
</body>
</html>