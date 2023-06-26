<%@ include file="init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfRenewLicense"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason"%>

<!DOCTYPE html>
<%
	
	
	DgfRenewLicense RenewLicenseObj= (DgfRenewLicense) request.getAttribute("RenewLicenseObj");
	DgfDuplctLicnsReason DuplctLicnsReasonObj= (DgfDuplctLicnsReason) request.getAttribute("DuplctLicnsReasonObj");
	
%>

<portlet:actionURL var="viewLicenseURL" name="viewLicense">
	<portlet:param name="mvcPath" value="/user_license_view.jsp" />
</portlet:actionURL>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>
<body>
		<div class="px-md-5 px-sm-3 px-1">
			<hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">

				<span class=" fw-bold p-0 m-0">  <%=user.getFirstName() %> <liferay-ui:message key="dashboard"/>
				</span> <span
                    class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
			
			
			<!-- no need -->
			
			<%--  <div class="container">
                      <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <div class="d-flex bd-highlight">
                            <div class=" flex-grow-1 bd-highlight"> <h6 class="mt-3"><liferay-ui:message key="your-dealer-registration-application-has-been-approved"/></h6></div>
                            <div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-success" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="approved" />
								</h4>
							</div>     
                          </div>
                      </div>
                </div>  --%>
                <!-- new Application -->
                
                <c:if test="${newApplicationStatus == 'Approved'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="your-new-food-grain-license-registration-application-no" />									
									:&nbsp;<%=request.getAttribute("newApplicationNo")  %></h6>
								</h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-success" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="approved" />
								</h4>
								
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
                <!-- renew -->

			<c:if test="${status == 'Approved'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="license-renew-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationNo")  %></h6>
								</h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-success" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="approved" />
								</h4>
								
							</div>
						</div>
					</div>
				</div>
			</c:if>			
			<c:if test="${status == 'Pending'}">
				<div class="container">
					<div class="alert  alert-dismissible fade show" style="background-color:#FFF3E1"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="license-renew-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-warning" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="pending" />
								</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${status == 'Rejected'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show" style="background-color:"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="license-renew-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-danger" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="rejected" />
								</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>			
			<c:if test="${statusDuplicat == 'Approved'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<h6 class="mt-3">
									<liferay-ui:message key="license-duplicat-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDuplicatNo")  %></h6>
								</h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-success" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="approved" />
								</h4>						
								
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${statusDuplicat == 'Pending'}">
				<div class="container">
					<div class="alert  alert-dismissible fade show" style="background-color:#FFF3E1"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="license-duplicat-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDuplicatNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-warning" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="pending" />
								</h4>
							</div>
						</div>						
					</div>
				</div>
			</c:if>
			<c:if test="${statusDuplicat == 'Rejected'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="license-duplicat-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDuplicatNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-danger" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="rejected" />
								</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>	
			
			
			<!-- dealer Application -->
			
			<c:if test="${statusDealer == 'Approved'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="your-dealer-registration-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDealerNo")  %></h6>
								</h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-success" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="approved" />
								</h4>
								
							</div>
						</div>
					</div>
				</div>
			</c:if>			
			<c:if test="${statusDealer == 'Pending'}">
				<div class="container">
					<div class="alert  alert-dismissible fade show" style="background-color:#FFF3E1"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="your-dealer-registration-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDealerNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-warning" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="pending" />
								</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${statusDealer == 'Rejected'}">
				<div class="container">
					<div class="alert alert-success alert-dismissible fade show" style="background-color:"
						role="alert">
						<div class="d-flex bd-highlight">
							<div class=" flex-grow-1 bd-highlight">
								<h6 class="mt-3">
									<liferay-ui:message key="your-dealer-registration-application-no" />									
									:&nbsp;<%=request.getAttribute("applicationDealerNo")  %></h6>
							</div>
							<div class=" bd-highlight">
								<h6 class="fw-bold"
									style="text-transform: uppercase; font-size: 12px;">
									<liferay-ui:message key="application-status" />
								</h6>
								<h4 class="fw-bold text-danger" style="text-transform: uppercase; font-size: 24px; text-color:black">
								<liferay-ui:message key="rejected" />
								</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>					
		</div>
</body>
</html>