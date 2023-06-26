<%@ include file="init.jsp"%>
<%@page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>

<%
	List<Map<String, Object>> dlrApplcList = (List<Map<String, Object>>) renderRequest.getAttribute("dlrApplcList");
	List<dgfLocUnion> unionList = (List<dgfLocUnion>) renderRequest.getAttribute("unionList");
	String languageId = (String) renderRequest.getAttribute("languageId");
%>
<!DOCTYPE html>

<portlet:renderURL var="searchDlrApplicationURL">
</portlet:renderURL>

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<%
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
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.green-text {
	color: #5bb600;
}

.green-bg {
	background-color: #61c002 !important;
	color: #ffffff !important;
}

.green-bg:hover {
	background-color: #428203 !important;
	color: #ffffff !important;
}

@media screen and (max-width: 600px) {
	.move-content {
		display: flex;
		justify-content: space-between;
	}
	* {
		font-size: 11px;
	}
}
</style>
</head>

<body>
	<div class="px-md-5 px-sm-3 px-2">
		<hr class="mt-3 mb-1" />
		<div class="d-flex justify-content-between">
			<span class=" fw-bold p-0 m-0"> 
			<liferay-ui:message key="dealer-application-list" />


			</span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
					key="last-login" /> <span><fmt:formatDate
						pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> | </span>
				<span><fmt:formatDate type="time" timeStyle="short"
						value="<%=user.getLastLoginDate()%>" /></span>
			</span>
		</div>
		<hr class="mt-1 mb-3" />





		<h6 class="green-text fw-bold mb-2"><liferay-ui:message key="search-filter" /></h6>
		<aui:form action="<%=searchDlrApplicationURL%>" name="searchForm"
			method="POST">
			<div class="row p-1">

				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="dateFrom"><liferay-ui:message
							key="date-from" /> </label>
					<aui:input class="form-control" type="date" id="dateFrom"
						name="dateFrom" label="" />

				</div>
				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="dateTo"><liferay-ui:message
							key="date-to" /> </label>
					<aui:input class="form-control" type="date" id="dateTo"
						name="dateTo" label="" />

				</div>
				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="date-type"><liferay-ui:message
							key="date-type" /></label>
					<aui:select id="dateType" class="form-select w-100"
						aria-label="Default select example" name="dateType" label="">

						<aui:option selected="true" disabled="true">
							<liferay-ui:message key="select" />
						</aui:option>
						<aui:option value="applSubmissionDate">
							<liferay-ui:message key="application-submission-date" />
						</aui:option>
						<aui:option value="applStatusUpdateDate">
							<liferay-ui:message key="application-status-update-date" />
						</aui:option>

					</aui:select>
				</div>
				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="nid"><liferay-ui:message
							key="nid" /></label>
					<aui:input class="py-1 px-2 form-control" placeholder="enter-here"
						type="text" id="nid" name="nid" label="" />
				</div>
				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="union"><liferay-ui:message
							key="union" /> </label>
					<aui:select id="union" class="form-select w-100"
						aria-label="Default select example" name="union" label="">
						<aui:option selected="true" disabled="true">
							<liferay-ui:message key="select" />
						</aui:option>
						<c:if test="${unionList != null}">
						<c:forEach var="union" items="${unionList}">
								<aui:option value="${union.id}">
									<c:choose>
										<c:when
											test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>"> 
												   	${union.name}
										</c:when>
										<c:when test="<%=languageId.equals("bn_BD")%>">
													${union.bnName}
										</c:when>
									</c:choose>
								</aui:option>
							</c:forEach>
						</c:if>
					</aui:select>
				</div>

				<div class="col-md-3 col-sm-6">
					<label class="fw-bold text14 mb-1" for="appStatus"><liferay-ui:message
							key="application-stat-us" /></label>
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
				<div class="col-md-3 col-sm-6">
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
				<div class="col-md-3 col-sm-12 ">
					<div
						class="flex-grow-1 d-flex align-items-center move-content mt-4 pe-2 ms-5">
						<button class="btn green-bg text-light">
							<liferay-ui:message key="search" />
						</button>
						<button class="btn btn-secondary ms-4" name="resetButton"
							id="resetButton">
							<liferay-ui:message key="reset" />
						</button>
					</div>
				</div>
			</div>
		</aui:form>

		<div class="mt-3 d-flex justify-content-between align-items-center">
			<h6 class="green-text"><liferay-ui:message key="dealer-list" /></h6>
			<a href="<%=resourceURL%>">
				<button name="downloadExcel" id="downloadExcel"
					class="btn btn-light">
					<i class="icon-download-alt"></i>
					<liferay-ui:message key="excel" />
				</button>
			</a>
		</div>

		<div class="search-container-wrapper">
			<liferay-ui:search-container delta="10" deltaConfigurable="<%=true%>"
				emptyResultsMessage="no-results-found"
				total="<%=dlrApplcList.size()%>" iteratorURL="<%=currentURLObj %>">


				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(dlrApplcList, searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>

				<%-- <liferay-ui:search-container-row
					className="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"
					keyProperty="fglPrePrimaryId" modelVar="item"> --%>
				<liferay-ui:search-container-row className="java.util.Map"
					keyProperty="dgfDlrRegDltsPrimaryId" modelVar="item">

					<liferay-ui:search-container-column-text
						name="food-grain-license-no"
						value="<%=item.get("fglLicenseNo").toString()%>" />

					<liferay-ui:search-container-column-text
						name="food-grain-license-issue-date"
						value="<%=item.get("fglLicIssuDate").toString()%>" />

					<liferay-ui:search-container-column-text
						name="dealer-application-no"
						value="<%=item.get("dealerApplNo").toString()%>" />

					<liferay-ui:search-container-column-text name="dealer-name"
						value="<%=item.get("dealerName").toString()%>" />

					<liferay-ui:search-container-column-text name="dealer-nid"
						value="<%=item.get("nid").toString()%>" />

					<liferay-ui:search-container-column-text name="program"
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

						<portlet:actionURL name="detailView"
							var="dlrApplicationDetailsURL">
							<portlet:param name="dgfDlrRegDltsNid"
								value="<%=item.get("nid").toString()%>" />
								<portlet:param name="dgfDlrRegDltsPrimaryId"
								value="<%=item.get("dgfDlrRegDltsPrimaryId").toString()%>" />
						</portlet:actionURL>

						<a href="${dlrApplicationDetailsURL}"><i class="icon-eye-open" /></a>
					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />

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
            A.one('#<portlet:namespace />dateType').set('selectedIndex', 0);
            A.one('#<portlet:namespace />nid').set('value', '');
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