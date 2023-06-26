<%@ include file="init.jsp"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<%
	DgfDlrRegDtls dlrRegPriData = (DgfDlrRegDtls) renderRequest.getAttribute("dlrRegPriData");
	String foodgrainLicense = (String) renderRequest.getAttribute("foodgrainLicense");
	String foodgrainIssueDate = (String) renderRequest.getAttribute("foodgrainIssueDateStr"); 
	String userNid = (String) renderRequest.getAttribute("userNid"); 
	String userDob = (String) renderRequest.getAttribute("userDob"); 
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String licnsIssueDate = null;
	String birthDate = null;
	String spouseDob = null;
	  
	if(dlrRegPriData != null) {
		if(dlrRegPriData.getSpouseBrthDate() != null) {
			spouseDob = format.format(dlrRegPriData.getSpouseBrthDate()); 
		}
		if(dlrRegPriData.getFglLicnsIssueDate() != null) {
			licnsIssueDate = format.format(dlrRegPriData.getFglLicnsIssueDate());
		} 
		if(dlrRegPriData.getDlrBrthDate() != null) {
			birthDate = format.format(dlrRegPriData.getDlrBrthDate()); 
		} 
	} 
%>
<portlet:renderURL var="renderURL">
	<portlet:param name="mvcPath"
		value="/dealer-registration-shop-details.jsp" />
	<portlet:param name="pageId" value="1" />
</portlet:renderURL>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>
<!-- Bootstrap CSS CDN  -->


</head>

<body>

<%
			String errorMessage = (String) request.getAttribute("showAlert");
			if (errorMessage != null) {
		%>
		<h5 class="text-danger"><%=errorMessage%></h5>
		<%
			}
		%>
		
    <section id="register" class="pb-5">
        <main class="px-5">
            
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
            <div class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-2">
                <div class="prog-circle green-bg" role="progressbar" aria-valuenow="15" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-hr" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                <div class="prog-circle bg-secondary" role="progressbar" aria-valuenow="20" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-hr bg-secondary" role="progressbar" aria-valuenow="30" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-circle bg-secondary" role="progressbar" aria-valuenow="20" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-hr bg-secondary" role="progressbar" aria-valuenow="30" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-circle bg-secondary" role="progressbar" aria-valuenow="20" aria-valuemin="0"
                    aria-valuemax="100"></div>
                    <div class="prog-hr bg-secondary" role="progressbar" aria-valuenow="30" aria-valuemin="0"
                    aria-valuemax="100"></div>
                <div class="prog-circle bg-secondary" role="progressbar" aria-valuenow="20" aria-valuemin="0"
                    aria-valuemax="100"></div>
            </div>
            <div class="container-fluid m-auto">
                <div class="card py-2 px-2">
                    <aui:form name="dealerRegistrationForm" action="<%=renderURL%>" method="POST">
                        <div class="row gx-4 mt-2">
                            <div class="col-md-6 col-sm-12">
                                <span class="d-block"><liferay-ui:message key="license-number" /><sup class="text-danger">*</sup></span>
                                <aui:input class="form-control" type="text" placeholder="auto-populate"
                                    aria-label="default input example" name="licenseNo" id="licenseNo" value="<%=foodgrainLicense%>" label="" readonly="true" >
                               	<aui:validator name="required" />
							</aui:input>
						</div>

						<div class="col-md-6 col-sm-12">
							<span class="d-block"><liferay-ui:message
									key="license-date-of-issue" /><sup class="text-danger">*</sup></span>
							<aui:input class="form-control" type="date"
								aria-label="default input example" name="licnsIssueDate"
								value="<%=foodgrainIssueDate%>" id="licnsIssueDate" label="" readonly="true" >
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
					<div class="mt-2 mb-3">
						<span class="d-block"><liferay-ui:message
								key="dealership-type" /><sup class="text-danger">*</sup></span>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="dealerShipType" id="inlineRadio1" value="FFP"
								checked="${dlrRegPriData.dlrTypeId == 'FFP' }"
								onChange="toggleOmsField(this.value)" >
									<aui:validator name="required" />
								</aui:input>
							<label class="form-check-label" for="inlineRadio1"><liferay-ui:message
									key="food-friendly-program" /> </label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="dealerShipType" id="inlineRadio2" value="OMS"
								checked="${dlrRegPriData.dlrTypeId == 'OMS' }"
								onChange="toggleOmsField(this.value)" />
							<label class="form-check-label" for="inlineRadio2"><liferay-ui:message
									key="open-market-sales" /></label>
						</div>

					</div>
					<div id="omsDealerShipSubType" class="mt-2 mb-3" <c:if test="${dlrRegPriData.dlrTypeId != 'OMS'}"> style="display:none"</c:if>>
						<span class="d-block"><liferay-ui:message
								key="oms-sub-type" /><sup class="text-danger">*</sup></span>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="omsSubType" id="inlineMaritalRadio1"
								checked="${dlrRegPriData.dlrOmsSubType == 'UPAZILA' }"
								value="UPAZILA" />
							<label class="form-check-label" for="inlineMaritalRadio1"><liferay-ui:message
									key="upazila" /></label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="omsSubType" id="inlineMaritalRadio2"
								checked="${dlrRegPriData.dlrOmsSubType == 'DISTRICT' }"
								value="DISTRICT" />
							<label class="form-check-label" for="inlineMaritalRadio2"><liferay-ui:message
									key="district" /></label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="omsSubType" id="inlineMaritalRadio3"
								checked="${dlrRegPriData.dlrOmsSubType == 'DHAKA_METRO' }"
								value="DHAKA_METRO" />
							<label class="form-check-label" for="inlineMaritalRadio3"><liferay-ui:message
									key="dhaka-metro" /></label>
						</div>
						<div class="form-check form-check-inline">
							<aui:input class="form-check-input" type="radio" label=""
								name="omsSubType" id="inlineMaritalRadio4"
								checked="${dlrRegPriData.dlrOmsSubType == 'OTHER_METRO' }"
								value="OTHER_METRO" />
							<label class="form-check-label" for="inlineMaritalRadio4"><liferay-ui:message
									key="other-metro" /></label>
						</div>
					</div>

					<div class="row gx-4 mt-2">
						<div class="col-md-6 col-sm-12">
							<span class="d-block"><liferay-ui:message key="nid" /></span>
							<aui:input class="form-control" type="text"
								placeholder="auto-populate" aria-label="default input example"
								value="<%=userNid%>"
								label="" name="nid" id="nid" readonly="true" >
								<aui:validator name="required" />
								</aui:input>
						</div>

						<div class="col-md-6 col-sm-12">
							<span class="d-block"><liferay-ui:message
									key="date-of-birth" /></span>
							<aui:input class="form-control" type="date"
								placeholder="auto-populate" aria-label="default input example"
								value="<%=userDob%>" label="" name="dob" readonly="true" >
								<aui:validator name="required" />
								</aui:input>
						</div>
					</div>
					<h5 class="green-text fw-bold mb-0">
						<liferay-ui:message key="information-related-to-husband-wife" />
					</h5>
					<div class="green-bg mb-2">
						<hr class="mt-0 mb-0" />
					</div>
                          <div class=" mt-2 mb-3">
                              <span class="d-block"><liferay-ui:message 
                              		key="marital-status" /><sup class="text-danger">*</sup>
                              </span>
                              <div class="form-check form-check-inline">
                                  <aui:input class="form-check-input" type="radio" 
                                   name="maritalStatus" id="unmarried" checked="${dlrRegPriData.maritalStatus == 'Unmarried' }" value="Unmarried" onChange="toggleMaritalField(this.value)" label="">
                                      <span><aui:validator name="required"
										errorMessage="please-select-martial-status" /></span>
										</aui:input>
                                  <label class="form-check-label" 
                                  for="unmarried"><liferay-ui:message key="unmarried" /></label>                                 
                              </div>
                              <div class="form-check form-check-inline">
                                  <aui:input class="form-check-input" type="radio" label="" name="maritalStatus"
                                      id="married" checked="${dlrRegPriData.maritalStatus == 'Married' }" value="Married" onChange="toggleMaritalField(this.value)" />
                                  <label class="form-check-label display-show" for="married"><liferay-ui:message key="married" /></label>
                              </div>
                              <div class="form-check form-check-inline">
                                  <aui:input class="form-check-input" type="radio" label="" name="maritalStatus"
                                      id="divorced" checked="${dlrRegPriData.maritalStatus == 'Divorced' }" value="Divorced" onChange="toggleMaritalField(this.value)" />
                                  <label class="form-check-label display-show" for="divorced"><liferay-ui:message key="divorced" /></label>
                              </div>
                              <div class="form-check form-check-inline">
                                  <aui:input class="form-check-input" type="radio" label="" name="maritalStatus"
                                      id="widow" checked="${dlrRegPriData.maritalStatus == 'Widow' }" value="Widow" onChange="toggleMaritalField(this.value)" />
                                  <label class="form-check-label display-show" for="widow"><liferay-ui:message key="widow" /></label>
                              </div>
                              <div class="form-check form-check-inline">
                                  <aui:input class="form-check-input" type="radio" label="" name="maritalStatus"
                                      id="widower"  checked="${dlrRegPriData.maritalStatus == 'Widower' }" value="Widower" onChange="toggleMaritalField(this.value)" />
                                  <label class="form-check-label display-show" for="widower"><liferay-ui:message key="widower" /></label>
                              </div>
                          </div>
                          <div id="spouse_details" <c:if test="${dlrRegPriData.maritalStatus != 'Married'}"> style="display:none"</c:if>>
		                          	<div class="row gx-4 mt-2">
		                                      <div class="col-md-6 col-sm-12">
		                                          <span class="d-block"><liferay-ui:message key="spouse-name" /></span>
		                                          <aui:input class="form-control" type="text" placeholder="type-here"
		                                              aria-label="default input example" label="" value="<%=dlrRegPriData != null ? dlrRegPriData.getSpouseName() : null %>" name="spouseName" >
											<aui:validator
												errorMessage="only-alphabets-are-allowed-&-spouse-name-can-not-be-more-than-30-characters"
												name="custom">
								                	function(val, fieldNode, ruleValue) {
													var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,30}$/);
													return regex.test(val);
													}
						        				</aui:validator>
									</aui:input>
								</div>
		
								<div class="col-md-6 col-sm-12">
									<span class="d-block"><liferay-ui:message
											key="spouse-father-name" /></span>
									<aui:input class="form-control" type="text"
										placeholder="type-here" aria-label="default input example"
										label=""
										value="<%=dlrRegPriData != null ? dlrRegPriData.getSpouseFthrName() : null%>"
										name="spouseFatherName">
										<%-- <aui:validator name="required"
											errorMessage="spouse-father-name-is-required" /> --%>
										<aui:validator
											errorMessage="only-alphabets-are-allowed-&-spouse-father-name-can-not-be-more-than-30-characters"
											name="custom">
								                	function(val, fieldNode, ruleValue) {
													var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,30}$/);
													return regex.test(val);
													}
						        				</aui:validator>
									</aui:input>
								</div>
							</div>
							<div class="row gx-4 mt-2">
								<div class="col-md-6 col-sm-12">
									<span class="d-block"><liferay-ui:message
											key="spouse-nid-number" /><sup class="text-danger">*</sup></span>
									<aui:input class="form-control" type="text"
										placeholder="type-here" aria-label="default input example"
										label=""
										value="<%=dlrRegPriData != null ? dlrRegPriData.getSpouseNid() : null%>"
										name="spouseNid">
										<%-- <aui:validator errorMessage="the-nid-number-field-is-required" name="required" ></aui:validator> --%>
										<aui:validator name="digits" />
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
									</aui:input>
								</div>
		                                      <div class="col-md-6 col-sm-12">
		                                          <span class="d-block"><liferay-ui:message key="spouse-date-of-birth" /><sup
		                                                  class="text-danger">*</sup></span>
		                                          <aui:input class="form-control" type="date" placeholder="type-here"
		                                              aria-label="default input example" label="" value="<%= spouseDob %>" name="spouseDob" >
		                                          		<aui:validator
															errorMessage="date-of-birth-must-not-be-future-date"
															name="custom">
															function(val, fieldNode, ruleValue) {
					    										var inputDate = new Date(val);
					
					    										if (!val) {
					      											return false;
					    										}
					    										if (inputDate < new Date()) {
					      											return true;
					    										}
					    											return false;
					  											}
														</aui:validator>   
		                                          </aui:input>
		                                      </div>
		                                      
		                                      
		                                  </div>
		                          </div>  
                        <div class="mt-2">
                            <button class="btn btn-success green-bg"><liferay-ui:message key="next" />
                                 <i class="fa-solid fa-circle-arrow-right"></i>
                            </button>
                        </div>
                    </aui:form>
                </div>
            </div>
        </main>
    </section>
</body>
</html>
