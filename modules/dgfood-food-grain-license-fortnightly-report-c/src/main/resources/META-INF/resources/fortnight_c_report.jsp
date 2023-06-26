<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.Map"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@ include file="init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm"%>
<%@ page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<portlet:defineObjects />

<%  List<DgfUsersFortnightReportCForm> dgfUsersFortnightReportCFormList = (List<DgfUsersFortnightReportCForm>)renderRequest.getAttribute("dgfUsersFortnightReportCFormList"); 
 List<dgfLocUnion> unionList = (List<dgfLocUnion>)renderRequest.getAttribute("unionList");
 List<dgfLocSubdistrict> subdistrictList = (List<dgfLocSubdistrict>)renderRequest.getAttribute("subdistrictList"); 
 List<Map<String, Object>> reportsList = (List<Map<String, Object>>)renderRequest.getAttribute("reportsList"); 
 PortletSession portletSession2 = renderRequest.getPortletSession();
 portletSession2.setAttribute("reportsList", reportsList, PortletSession.APPLICATION_SCOPE);
boolean isUcf = (Boolean) renderRequest.getAttribute("isUcf");
boolean isDcf = (Boolean) renderRequest.getAttribute("isDcf");

PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
%>
<body>
	
	<!-- <style>
select.form-control {
  font-weight: 400 !important;
}
	</style> -->
	
    <div class="px-3 mb-5">
        <div class="container">
        
        <div class=" my-2">
		
		<hr class="mt-0 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="fortnightly-report-form-ga"/></span> <span
					class=" fw-bold p-0m-0"> <liferay-ui:message key="last-login"/><span><fmt:formatDate
							pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> |
				</span> <span><fmt:formatDate type="time" timeStyle="short"
							value="<%=user.getLastLoginDate()%>" /></span></span>
			</div>
			<hr class="mt-1 mb-3" />
	
		</div>
          <!-- search start -->
          <h6 class="green-text fw-bold mb-2"><liferay-ui:message key="search-filter"/></h6>
				 <div class="row mt-3">    
				<portlet:renderURL var="searchActionURL"  />
							<aui:form action="<%= searchActionURL %>" name="searchForm" method="POST">
				    <div class="row p-1">
				        <div class="col-md-3 col-sm-6">
				            <label class="fw-bold text14 mb-1"><liferay-ui:message key="license-type" /> </label>
				            <aui:select id="lc_type" class=""  name="licenseType" label="">
				                <aui:option class="option-label font-weight-normal" value="" label="select-a-business" selected="true" disabled="true"></aui:option>
								<aui:option value="Importer" selected='${"Importer" == licenseType}'><liferay-ui:message key="importer" /></aui:option>
								<aui:option value="WholesalersAndStockists"  selected='${"WholesalersAndStockists" == licenseType}'><liferay-ui:message key="wholesalers-and-Stockists" /></aui:option>
								<aui:option value="Retailers"  selected='${"Retailers" == licenseType}'><liferay-ui:message key="retailers" /></aui:option>
								<aui:option value="MajorAndCompactFlourMill" selected='${"MajorAndCompactFlourMill" == licenseType}'><liferay-ui:message key="major-and-compact-flour-mill" /></aui:option>
								<aui:option value="RollerFlourMill" selected='${"RollerFlourMill" == licenseType}'><liferay-ui:message key="roller-flour-mill" /></aui:option>
								<aui:option value="AttaChakki"  selected='${"AttaChakki" == licenseType}'><liferay-ui:message key="atta-chakki" /></aui:option>
								<aui:option value="AutomaticRiceMill" selected='${"AutomaticRiceMill" == licenseType}'><liferay-ui:message key="automatic-rice-mill" /></aui:option>
								<aui:option value="MajorRiceMill" selected='${"MajorRiceMill" == licenseType}'><liferay-ui:message key="major-rice-mill" /></aui:option>
								<aui:option value="HuskingRiceMill" selected='${"HuskingRiceMill" == licenseType}'><liferay-ui:message key="husking-rice-mill" /></aui:option>
								<aui:option value="Dealer" selected='${"Dealer" == licenseType}'><liferay-ui:message key="dealer" /></aui:option>
				            </aui:select>
				        </div>
				
				        <div class="col-md-2 col-sm-6">
				            <label class="fw-bold text14 mb-1"><liferay-ui:message key="date" /></label>
				            <aui:input class="py-1 px-2 w-100" placeholder="Select" type="date" id="dateTo" name="dateTo" label="" />
				        </div>
				
						<c:if test="${isDcf == true }">
							<div class="col-md-3 col-sm-6">
					            <label class="fw-bold text14 mb-1"><liferay-ui:message key="upzilla" /></label>
					           
					            <aui:select id="upazilla" class="form-select w-100 font-weight-normal" aria-label="Default select example" name="subdistrict" label="">
					                 <aui:option class="option-label font-weight-normal" value="" label="select-a-upzilla"
													selected="true" disabled="true"></aui:option>
					                <c:forEach items="${subdistrictList}" var="subdistrict">
					                    <aui:option value="${subdistrict.id}" selected="${subdistrict.id == subdistrictId}">${subdistrict.name}</aui:option>
					                </c:forEach>
					            </aui:select>
					        </div>
				        </c:if>
				        <div class="col-md-3 col-sm-6">
				            <label class="fw-bold text14 mb-1"><liferay-ui:message key="union" /></label>
				            <aui:select id="union" class="form-select w-100 font-weight-normal" aria-label="Default select example" name="union" label="">
				               <aui:option class="option-label" value="" label="select-a-union"
													selected="true" disabled="true"></aui:option>
				                <c:forEach items="${unionList}" var="union">
				                    <aui:option value="${union.id}" selected="${union.id == unionId}">${union.name}</aui:option>
				                </c:forEach>
				            </aui:select>
				        </div>
				
				        <div class="col-md-1 col-sm-6 flex-grow-1 d-flex align-items-center move-content  pe-2">
				            <button class="btn green-bg text-light me-2"><liferay-ui:message key="search" /></button>
				            <%-- <button class="btn btn-reset" id="resetButton"
								name="resetButton"><liferay-ui:message key="reset"/>
								</button>
				       		</div> --%>
				    	</div>
				    	
				    	</div>
					</aui:form>		
					<hr/>
				</div> 
				
				<!-- search end  -->
				<liferay-ui:search-container delta="10"  deltaConfigurable="<%=true%>"
					emptyResultsMessage="no-entries-were-found"
					 total="<%=reportsList.size()%>" iteratorURL="<%=currentURLObj %>">
				    <liferay-ui:search-container-results results="<%=ListUtil.subList(reportsList, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
				
				    <liferay-ui:search-container-row
				     className="java.util.Map"
				      keyProperty="reportId" modelVar="item" escapedModel="<%=true%>">
						<liferay-ui:search-container-column-text name="license-type"
										value="<%=item.get("bussinessType").toString()%>"/>
						<liferay-ui:search-container-column-text name="endDate"
										value="<%=item.get("endDate").toString()%>"/>
						<liferay-ui:search-container-column-text name="businessUpazilla"
										value="<%=item.get("businessUpazilla").toString()%>"/>
					    <liferay-ui:search-container-column-text name="businessUnionName"
										value="<%=item.get("businessUnionName").toString()%>"/>
				       <liferay-ui:search-container-column-text name="Action">
					       	<portlet:resourceURL var="pdfResourceUrl">
					        	<portlet:param name="reportId" value="<%=item.get("reportId").toString()%>" />
					   		 </portlet:resourceURL>
							 <a href="<%=pdfResourceUrl%>">View</a>
				       </liferay-ui:search-container-column-text>
				    </liferay-ui:search-container-row>
				
				    	<liferay-ui:search-iterator/>
				
				</liferay-ui:search-container> 			
            </div>             
        </div>
    </div>
</body> 

<aui:script>
 AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
	A.one("#<portlet:namespace/>upazilla").on('change', function(){
	    var web_subDisId = this.get('value');
	    var subDisSelected = "subDisSelected";
	    var pAuth = Liferay.authToken;
		console.log("pAuth==="+pAuth);
	    A.io.request("/api/jsonws/dgf.dgflocunion/getUnionsBySubDistrict", {
	        method:'GET',
	         headers: {
						'Content-Type': 'application/json',
						'X-CSRF-Token' : pAuth
					},
	        data: { 'subDistrict': web_subDisId},
	        on:{
	            success:function(){
	                var unionList = this.get('responseData');
	                A.one('#<portlet:namespace/>union').set('disabled', false);
	                A.one('#<portlet:namespace/>union').set('value', '');
	                A.one('#<portlet:namespace/>union').empty();
	                var langValue = "<liferay-ui:message key='select-a-union' />"
	                A.one('#<portlet:namespace/>union').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
	                var jsonParse = JSON.parse(unionList);
	                for(var i =0; i < jsonParse.length; i++){
	                    A.one('#<portlet:namespace/>union').append("<option  value='"+ JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).name+"</option> ");
	                }
	            },
	            failure: function(){
	                console.log("An error has occurred while getting the districts from server");
	            }
	        }
	   	 });
	});
});
</aui:script> 

	<aui:script use="aui-base">
    AUI().use('aui-node', function(A) {
        A.one('#resetButton').on('click', function(event) {
            event.preventDefault();
            
            // Clear input fields
            A.one('#<portlet:namespace />dateFrom').set('value', '');
            A.one('#<portlet:namespace />dateTo').set('value', '');
            A.one('#<portlet:namespace />dateType').set('selectedIndex', 0);
            A.one('#<portlet:namespace />applicationNo').set('value', '');
            A.one('#<portlet:namespace />status').set('selectedIndex', 0);
            A.one('#<portlet:namespace />appLicType').set('selectedIndex', 0);
            
            // Submit form
            A.one('#<portlet:namespace />searchForm').submit();
        });
    });
</aui:script>