<%@ include file="init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>

<% List<VerifiedBeneficiaries> dealerLinkedBeneficiaryList =(List<VerifiedBeneficiaries>) renderRequest.getAttribute("dealerLinkedBeneficiaryList");
	String languageId = (String) request.getAttribute("languageId");
%>
<!DOCTYPE html>
<%
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
%>
<portlet:renderURL var="searchDlrLinkedBeneficiaryListURL">
</portlet:renderURL>

<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>FFP Dealer Beneficiary List</title>
</head>

<body>
    <div class="px-md-5 px-sm-3 px-1">

        <hr class="mt-0 mb-1" />
        <div class="d-flex justify-content-between">
            <span class=" fw-bold p-0 m-0">ffp-beneficiary-list</span>
            <span class=" fw-bold p-0 m-0">
                last-login: <span>31 Aug 2021 | 14:30</span>
            </span>
        </div>
        <hr class="mt-1 mb-3" />

        <div class="card p-2">
			<aui:form action="<%=searchDlrLinkedBeneficiaryListURL%>" name="searchForm" method="POST">
            <h6 class="green-text fw-bold mb-2">search-filter</h6>
            <div class="row">

				
                <div class="col-md-4 col-sm-6">
                    <label class="fw-bold text14 mb-1" for="nid"><liferay-ui:message
							key="nid" /></label>
                    <aui:input class="py-1 px-2 w-100" placeholder="Enter NID" type="text" id="nid"
                        name="nid" label="" />
                </div>

                <div class="col-md-4 col-sm-6">
                    <label class="fw-bold text14 mb-1" for="nid"><liferay-ui:message
							key="ffp-card-no"></liferay-ui:message></label>
                    <aui:input class="py-1 px-2 w-100" placeholder="type-here" type="text" id="ffpCardNo"
                        name="ffpCardNo" label=""/>
                </div>

                <div class="col-md-4 col-sm-2 ">
                    <div class="flex-grow-1 d-flex flex-row-reverse  move-content mt-4 pe-2">                        
                       <button class="btn btn-secondary ms-4" name="resetButton"
							id="resetButton">
							<liferay-ui:message key="Reset" />
						</button>
                       <button class="btn green-bg text-light">
							<liferay-ui:message key="Search" />
						</button>
                    </div>
                </div>
            </div>
            </aui:form>
        </div>
        <br>
        <div class="card p-2">


            <div class="row ms-1 me-1 pb-2 border-bottom">


                <div class="col-md-10 col-sm-10 mt-2">
                    <h6 class="green-text fw-bold ">beneficiary-list</h6>
                </div>
                <div class="col-md-2 col-sm-2">
                    <div class="flex-grow-1 d-flex flex-row-reverse move-content   pe-2">

                        <button class="btn btn-reset"> <i class="icon-download-alt"></i> Excel

                    </div>
                </div>
            </div>

            <div class="search-container-wrapper">
                
                <liferay-ui:search-container delta="10" deltaConfigurable="<%=true%>"
				emptyResultsMessage="no-results-found"
				total="<%=dealerLinkedBeneficiaryList.size()%>" iteratorURL="<%=currentURLObj %>">


				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(dealerLinkedBeneficiaryList, searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>

				<%-- <liferay-ui:search-container-row
					className="bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls"
					keyProperty="fglPrePrimaryId" modelVar="item"> --%>
				<liferay-ui:search-container-row className="bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries"
					keyProperty="id" modelVar="item">
					<liferay-ui:search-container-column-text
						name="ffp-card-no"
						value="<%=Long.toString(item.getCardNo())%>" />

					<liferay-ui:search-container-column-text
						name="beneficiary-name"
						value="<%=item.getEcBeneficiaryName()%>" />


					<liferay-ui:search-container-column-text name="nid"
						value="<%=item.getNationalId()%>" />
						
					<liferay-ui:search-container-column-text name="gender">
    					<liferay-ui:message key="<%= item.getEcGender() %>" />
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text name="mobile-no"
						value="<%=item.getGivenMobileNo()%>" />
					
					<%dgfLocUnion union=dgfLocUnionLocalServiceUtil.getdgfLocUnion(item.getUnionId());%>
					
					<c:choose>
						<c:when test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>"> 
								<liferay-ui:search-container-column-text name="union"
								value="<%=union.getName()%>" />
						</c:when>
						<c:when test="<%=languageId.equals("bn_BD")%>">
								<liferay-ui:search-container-column-text name="union"
								value="<%=union.getBnName()%>" />
						</c:when>
					</c:choose>

					<liferay-ui:search-container-column-text name="view-details">
					
						<%-- <portlet:actionURL name="detailView"
							var="dlrApplicationDetailsURL">
							<portlet:param name="dgfDlrRegDltsNid"
								value="<%=item.get("nid").toString()%>" />
						</portlet:actionURL> --%>

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
            A.one('#<portlet:namespace />nid').set('value', '');
            A.one('#<portlet:namespace />ffpCardNo').set('value', '');
            
            // Submit form
            A.one('#<portlet:namespace />searchForm').submit();
        });
    });
</aui:script>

</body>
</html>