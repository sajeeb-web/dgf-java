<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@ include file="init.jsp"%>
<%@page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>

<%
	List<Map<String, Object>> dlrWithdrawalApplcList = (List<Map<String, Object>>) renderRequest.getAttribute("dlrWithdrawalApplcList");
%>
<!DOCTYPE html>

<portlet:renderURL var="searchDlrApplicationURL">
<portlet:param name="cmd" value="list" />
</portlet:renderURL>

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%
List<dgfLocUnion> unionList = (List<dgfLocUnion>)renderRequest.getAttribute("unionList");
boolean isUcf = (Boolean) renderRequest.getAttribute("isUcf");

PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
%>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DG Food</title>
<!-- Bootstrap CSS CDN  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

</head>

<body>
	<div class="px-md-5 px-sm-3 px-2 text-capitalize">
		<hr class="mt-3 mb-1" />
		<div class="d-flex justify-content-between">
			<span class=" fw-bold p-0 m-0"> <%=user.getFirstName()%>  | <liferay-ui:message
					key="dashboard" />


			</span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="last-login" /><span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> | </span>
				<span><fmt:formatDate type="time" timeStyle="short"
						value="<%=user.getLastLoginDate()%>" /></span>
			</span>
		</div>
		<hr class="mt-1 mb-3" />

		<h6 class="green-text fw-bold mb-2">Search Filter</h6>
		<aui:form action="<%=searchDlrApplicationURL%>" name="searchForm"
			method="POST">
			<div class="row p-1">

				<div class="col-md-2 col-sm-6">
					<label class="fw-bold text14 mb-1" for="dateFrom"><liferay-ui:message
							key="date-from" /> </label>
					<aui:input class="form-control" type="date" id="dateFrom"
						name="dateFrom" label="" value="${dateFrom}"/>

				</div>
				<div class="col-md-2 col-sm-6">
					<label class="fw-bold text14 mb-1" for="dateTo"><liferay-ui:message
							key="date-to" /> </label>
					<aui:input class="form-control" type="date" id="dateTo"
						name="dateTo" label="" value="${dateTo}"/>

				</div>
				
				<c:if test="${isUcf == true}">
					 <div class="col-md-2 col-sm-6">
						<label class="fw-bold text14 mb-1" for="union"><liferay-ui:message
								key="union" /> </label>
						<aui:select id="union" class="form-select w-100"
							aria-label="Default select example" name="union" label="">
							<aui:option selected="true" disabled="true">
								<liferay-ui:message key="select" />
							</aui:option>
							<c:forEach items="${unionList}" var="union">
					                    <aui:option value="${union.id}" selected="${union.id == subdistrictId}">${union.name}</aui:option>
					                </c:forEach>
						</aui:select>
					</div> 
				</c:if>
				<div class="col-md-2 col-sm-6">
					<label class="fw-bold text14 mb-1" for="appStatus"><liferay-ui:message
							key="application-status" /></label>
					<aui:select id="appStatus" class="form-select w-100"
						aria-label="Default select example" name="appStatus" label="">

						<aui:option value="1" selected="true">
							<liferay-ui:message key="pending" />
						</aui:option>
						<aui:option value="0">
							<liferay-ui:message key="reviewed" />
						</aui:option>
						<aui:option value="4">
							<liferay-ui:message key="rejected" />
						</aui:option>
						<aui:option value="6">
							<liferay-ui:message key="incomplete" />
						</aui:option>
						<aui:option value="-2">
							<liferay-ui:message key="all" />
						</aui:option>

					</aui:select>
				</div>
				<div class="col-md-2 col-sm-6">
					<label class="fw-bold text14 mb-1" for="dealerType"><liferay-ui:message
							key="dealer-type" /></label>
					<aui:select id="dealerType" class="form-select w-100"
						aria-label="Default select example" name="dealerType" label="">

						<aui:option selected="true" disabled="true">
							<liferay-ui:message key="select" />
						</aui:option>
						<aui:option value="OMS">
							<liferay-ui:message key="oms" />
						</aui:option>
						<aui:option value="FFP">
							<liferay-ui:message key="ffp" />
						</aui:option>

					</aui:select>
				</div>
				<div class="col-md-2 col-sm-12 ">
					<div
						class="flex-grow-1 d-flex align-items-center move-content mt-4 pe-2 ms-5">
						<button class="btn green-bg text-light">
							<liferay-ui:message key="Search" />
						</button>
						<button class="btn btn-secondary ms-4" name="resetButton" id="resetButton">
							<liferay-ui:message key="Reset" />
						</button>
					</div>
				</div>
			</div>
		</aui:form>

		<div class="mt-3 d-flex justify-content-between align-items-center">
			<h6 class="green-text">Dealer List</h6>
			<a href="<%=resourceURL%>"> <button name="downloadExcel" id="downloadExcel"
					class="btn btn-light">
					<i class="icon-download-alt"></i> <liferay-ui:message key="excel"/>
				</button> </a>
		</div>


<div class="search-container-wrapper">
			<liferay-ui:search-container  delta="10" deltaConfigurable="<%=true%>"
				
				emptyResultsMessage="no-results-found"
				total="<%=dlrWithdrawalApplcList.size()%>" iteratorURL="<%=currentURLObj %>">


				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(dlrWithdrawalApplcList, searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
				
				<%-- <liferay-ui:search-container-row
					className="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"
					keyProperty="fglPrePrimaryId" modelVar="item"> --%>
				<liferay-ui:search-container-row className="java.util.Map"
					keyProperty="dgfDlrRegDltsPrimaryId" modelVar="item">

					<liferay-ui:search-container-column-text
						name="dealer-name"
						value="<%=item.get("dealerName").toString()%>" />
						
							<liferay-ui:search-container-column-text
						name="dealer-mobile-no"
						value="<%=item.get("mobileNo").toString()%>" />
					
					<liferay-ui:search-container-column-text name="license-no"
						value="<%=item.get("licenseNo").toString()%>"/>
					
						<liferay-ui:search-container-column-text
						name="dealer-nid"
						value="<%=item.get("nid").toString()%>" />
						
					<liferay-ui:search-container-column-text
								name="create-date"
								value="<%=item.get("createdDate").toString()%>" />
					
				
					
					<liferay-ui:search-container-column-text
						name="program"
						value="<%=item.get("program").toString()%>" />
						
						<%
						int statusitem =(Integer) item.get("status");
						String statusStr = "";
						if(statusitem == 0){
							statusStr = "Reviewed";
						}else if(statusitem ==1){
							statusStr = "Pending";
						}else if(statusitem ==4){
							statusStr = "Rejected";
						}else if(statusitem ==6){
							statusStr = "Incomplete";
						}
						%>
					<liferay-ui:search-container-column-text name="dealer-status"
						value="<%= statusStr %>"
						cssClass="<%=(((Integer) item.get("status")).intValue() == 0)
							? "fw-bold text14 text-success"
							: (((Integer) item.get("status")).intValue() == 1)
									? "fw-bold text14 text-warning"
									: "fw-bold text14 text-danger"%>" />

					 <liferay-ui:search-container-column-text name="view-details">

								
								<portlet:actionURL name="detailView" var="dlrApplicationDetailsURL" >    
									<portlet:param name="nationalId" value="<%=item.get("nid").toString()%>" />
									<portlet:param name="dlrWithdrawalId" value="<%=item.get("dlrWithdrawalId").toString()%>" />
								</portlet:actionURL>
								

								<a href="${dlrApplicationDetailsURL}"><i
									class="icon-eye-open" /></a>
					</liferay-ui:search-container-column-text> 
					
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator/>
				
			</liferay-ui:search-container>
			
			</div>


		</div>

<aui:script use="aui-base">
    AUI().use('aui-node', function(A) {
        A.one('#resetButton').on('click', function(event) {
            event.preventDefault();
            
            // Clear input fields
            A.one('#<portlet:namespace />dateFrom').set('value', '');
            A.one('#<portlet:namespace />dateTo').set('value', '');
            A.one('#<portlet:namespace />union').set('selectedIndex', 0);
            A.one('#<portlet:namespace />appStatus').set('selectedIndex', 0);
            A.one('#<portlet:namespace />dealerType').set('selectedIndex', 0);
            
            // Submit form
            A.one('#<portlet:namespace />searchForm').submit();
        });
    });
</aui:script>


</body>
</html>