<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="init.jsp"%>

<%@page import="bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDivision"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocUnion"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDistrict"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ include file="js/dlr_shp_loc.js"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfAttachments"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil"%>
<%@page	import="bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil"%>
<%@page	import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	DgfDlrRegDtls dlrRegPriData = (DgfDlrRegDtls) renderRequest.getAttribute("dlrRegPriData");
	DgfDlrRegAddlDtls dlrRegAddlPriData = (DgfDlrRegAddlDtls) renderRequest.getAttribute("dlrRegAddlPriData");
	DgfDlrPerfDtls dlrRegPerfPriData = (DgfDlrPerfDtls) renderRequest.getAttribute("dlrRegPerfPriData");
	DgfDlrUpdtTempDtls dlrUpdTmpPriData = (DgfDlrUpdtTempDtls) renderRequest.getAttribute("dlrUpdTmpPriData");
	DgfAttachments physclyChlngdObj = null;
	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	List<dgfLocDivision> divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(0, dgfLocDivisionLocalServiceUtil.getdgfLocDivisionsCount());
	pageContext.setAttribute("divisions", divisions);
	if(dlrUpdTmpPriData != null && dlrUpdTmpPriData.getShpDivision()>0) {
		List<dgfLocDistrict> districts = dgfLocDistrictLocalServiceUtil.getdivWiseDis(dlrUpdTmpPriData.getShpDivision());
		List<dgfLocSubdistrict> subdistricts = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(dlrUpdTmpPriData.getShpDistrict());
		List<dgfLocUnion> unions = dgfLocUnionLocalServiceUtil.getsubDisWiseUn(dlrUpdTmpPriData.getShpUpzilla());
		pageContext.setAttribute("districts", districts);
		pageContext.setAttribute("subdistricts", subdistricts);
		pageContext.setAttribute("unions", unions);
	} 
	if(dlrRegAddlPriData != null){
		if(dlrRegAddlPriData.getPhsclyChlnGdAttchId() > 0){
			physclyChlngdObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dlrRegAddlPriData.getPhsclyChlnGdAttchId());
		}
	}
	
	
	String languageId = (String) renderRequest.getAttribute("languageId");
	String nid = (String)renderRequest.getAttribute("nationalId");
	DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nid);
%> 

<!DOCTYPE html>
<portlet:defineObjects />
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<portlet:actionURL name="actionForm" var="addRegShopDtlsFormActionURL" >
	<portlet:param name="mvcPath" value="/dealer-registration-attachments.jsp" />
	   <portlet:param name="pageId" value="2" />
</portlet:actionURL>
<portlet:actionURL name="back" var="backUrl" >
	<portlet:param name="mvcPath" value="/dealer-registration.jsp" />
	<portlet:param name="pageId" value="2" />
	<portlet:param name="isBack" value="true" />
	<portlet:param name="nationalId" value="<%=renderRequest.getAttribute("nationalId").toString()%>" />
</portlet:actionURL>

<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SDM FDD</title>    
</head>
<body>
        <div class="px-md-5 px-sm-3 px-1"> 
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
                <div class="prog-circle green-bg" role="progressbar" aria-valuenow="20" aria-valuemin="0"
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
                    <aui:form  action="<%=addRegShopDtlsFormActionURL%>" name="dealerUserForm" method="POST" enctype="multipart/form-data">
                        <aui:input type="hidden" name="nationalId"
								value="<%=renderRequest.getAttribute("nationalId")%>" />
				
                        <h5 class="green-text fw-bold mb-0"><liferay-ui:message key="dealer-info" /></h5>
                        <div class="green-bg mb-2">
                            <hr class="mt-0 mb-0" />
                        </div>

                                  <div class="row gx-4 mt-2">
                                      <div class="col-md-6 col-sm-12">
                                        <div class="mt-2 mb-3">
                                            <span class="d-block"><liferay-ui:message key="work-in-the-government" /> 
                                              <sup class="text-danger">*</sup></span>
                                            <div class="form-check form-check-inline">
                                                <aui:input class="form-check-input" type="radio" label="" name="workInGovt"
                                                    id="unmarried" checked="${dlrUpdTmpPriData.wrkInGovt == 1 }" value="1" > 
                                                    <aui:validator name="required" errorMessage="please-select-work-in-the-government" />
                                                    </aui:input>
                                                <label class="form-check-label" for="unmarried"><liferay-ui:message key="yes" /></label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <aui:input class="form-check-input" type="radio" label="" name="workInGovt"
                                                    id="married" checked="${dlrUpdTmpPriData.wrkInGovt == 0 }" value="0" > </aui:input>
                                                <label class="form-check-label" for="married"><liferay-ui:message key="n-o-1" /></label>
                                            </div>
                                        </div>
                                      </div>

                                      <div class="col-md-6 col-sm-12">
                                        <div class="mt-2 mb-3">
                                            <span class="d-block"><liferay-ui:message key="public-representative" />

                                              <sup class="text-danger">*</sup></span>
                                            <div class="form-check form-check-inline">
                                                <aui:input class="form-check-input" type="radio" label="" name="publcRep"
                                                    id="publicrepresntative1" checked="${dlrUpdTmpPriData.pblcRep == 1 }" value="1" > 
                                                    	<aui:validator name="required" errorMessage="please-select-public-representative" />
                                                    </aui:input>
                                                <label class="form-check-label" for="publicrepresntative1"><liferay-ui:message key="yes" /></label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <aui:input class="form-check-input" type="radio" label="" name="publcRep"
                                                    id="publicrepresntative2" checked="${dlrUpdTmpPriData.pblcRep == 0 }" value="0" > </aui:input>
                                                <label class="form-check-label" for="publicrepresntative2"><liferay-ui:message key="n-o-1" /></label>
                                            </div>                                          
                                        </div>
                                      </div>                                    
                                  </div>
                            <div class="row gx-4 mt-2">
                              <div class="col-md-6 col-sm-12">
                                <div class="mt-2 mb-3">
                                    <span class="d-block"> <liferay-ui:message key="physically-challenged" />

                                      <sup class="text-danger">*</sup></span>
                                    <div class="form-check form-check-inline">
                                        <aui:input class="form-check-input" type="radio" label="" name="physclyChlngd"
                                            id="physicallychallengedyes" checked="${dlrUpdTmpPriData.physclyChlngd == 1 }" value="1" onclick="showField()">
                                            	<aui:validator name="required" errorMessage="please-select-physically-challenged" />
                                             </aui:input>
                                        <label class="form-check-label" for="physicallychallengedyes"><liferay-ui:message key="yes" /></label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <aui:input class="form-check-input" type="radio" label="" name="physclyChlngd"
                                            id="physicallychallengedno" checked="${dlrUpdTmpPriData.physclyChlngd == 0 }" value="0" onclick="hideField()"> </aui:input>
                                        <label class="form-check-label" for="physicallychallengedno"><liferay-ui:message key="n-o-1" /></label>
                                    </div>
                                  
                                
                                </div>
                              </div>
                            <div id="physclyChlngdDocField" class="col-md-6 col-sm-12" >
                    
                                            <label for="formFile" class="form-label"><liferay-ui:message key="if-yes-proof-of-physically-challenged" />
                                            </label>
                                            <aui:input class="form-control" name="physclyChlngdDoc" id ="physclyChlngdDoc" type="file" label="" placeholder="choose-file">
                                            <%-- <aui:validator name="required" errorMessage="proof-of-physically-challenged-is-required" /> --%>
										<aui:validator name="custom"
											errorMessage="only-pdf-doc-docx-jpg-jpeg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpg', 'image/jpeg', 'image/png'];
									
									            if (allowedTypes.indexOf(fileType) === -1) {
									                return false;
									            }
									              return true;
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
                                    <aui:input name="physclyChlngdDocType" type="hidden" value="certificate"/>
                                </div>
                            </div>

                            <h5 class="green-text fw-bold mb-0"><liferay-ui:message key="shop-details" /></h5>
                            <div class="green-bg mb-2">
                              <hr class="mt-0 mb-0" />
                            </div>
                            <div class="row gx-4 mt-2">
                              <div class="col-md-6 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="region-division" /><sup class="text-danger">*</sup></span
                                >
                                <aui:select
                                  class="form-select"
                                  name="shopDiv"
                                  id="division"
                                  aria-label="Default select example">
                                  <aui:validator name="required"
										errorMessage="division-is-required" />
                                  <aui:option value="" label="select-a-division" selected="true"
										disabled="true"></aui:option>

									<c:forEach var="division" items="${divisions}">
										<aui:option value="${division.id}"
											selected="${division.id == dlrUpdTmpPriData.shpDivision}">
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
                                <span class="d-block"
                                  ><liferay-ui:message key="district-zilla" /><sup class="text-danger">*</sup></span
                                >
                                <aui:select
                                  class="form-select"
                                  name="shopDis"
                                  aria-label="Default select example"
                                  id="district"
                                >
                           		<aui:validator name="required"
										errorMessage="district-is-required" />
                                  <aui:option value="" label="select-a-district" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="district" items="${districts}">
										<aui:option value="${district.id}"
											selected="${district.id == dlrUpdTmpPriData.shpDistrict}">
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
                                <span class="d-block"
                                  ><liferay-ui:message key="upazila" /><sup class="text-danger">*</sup></span
                                >
                                <aui:select
                                  class="form-select"
                                  name="shopUpazila"
                                  aria-label="Default select example"
                                  id="upzilla"
                                >
                                <aui:validator name="required"
										errorMessage="upazila-is-required" />
                                  <aui:option value="" label="select-a-upzilla" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="subdistrict" items="${subdistricts}">
										<aui:option value="${subdistrict.id}"
											selected="${subdistrict.id == dlrUpdTmpPriData.shpUpzilla}">
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
                                <span class="d-block"
                                  ><liferay-ui:message key="union" /><sup class="text-danger">*</sup></span
                                >
                                <aui:select
                                  class="form-select"
                                  name="shopUnion"
                                  aria-label="Default select example"  
                                  id="unionName"
                                >
                                <aui:validator name="required" errorMessage="union-is-required" />
                                  <aui:option value="" label="select-a-union" selected="true"
										disabled="true"></aui:option>
									<c:forEach var="union" items="${unions}">
										<aui:option value="${union.id}"
											selected="${union.id == dlrUpdTmpPriData.shpUnion}">
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
                                <span class="d-block"
                                  ><liferay-ui:message key="ward" /><sup class="text-danger">*</sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  name="shopWard"
                                  type="text"
                                  placeholder="type-here"
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpWard() : null %>"
                                > 
                                	<aui:validator name="required" errorMessage="ward-is-required" />
									<aui:validator
										errorMessage="only-numbers-between-1-to-2-digits-are-allowed"
										name="custom">
												    function(val, fieldNode, ruleValue) {
												        var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,2}$/;
												        return regex.test(val);
												    }
												</aui:validator>
                                </aui:input>
                              </div>
                              <div class="col-md-6 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="zip-code-post-code" /><sup class="text-danger">*</sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="shopZipCode"
                                  placeholder="type-here"
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpZipCode() : null %>"
                                > 
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
                            </div>
                            <div class="row gx-4 mt-2">
                              <div class="col-md-6 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="location-of-the-shop" /><sup class="text-danger">*</sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="shopLoc"
                                  placeholder="type-here"
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpLocation() : null %>"
                                > 
                                	<aui:validator name="required"
										errorMessage="shop-location-is-required" />
									<aui:validator
										errorMessage="only-alphabets-are-allowed-&-village-name-can-not-be-more-than-300-characters"
										name="custom">
						                	function(val, fieldNode, ruleValue) {
											var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,300}$/);
											return regex.test(val);
											}
				        				</aui:validator>
                                </aui:input>
                              </div>
                              <div class="col-md-6 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="shop-height" /><sup class="text-danger">*</sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="shopHeight"
                                  placeholder="type-here"
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpHeight() : null %>"
                                > 
                                <aui:validator name="required"
										errorMessage="shop-height-is-required" />
                                	<aui:validator errorMessage="only-numbers-between-1-to-4-digits-are-allowed"
										name="custom">
									function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,4}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                </aui:input>
                              </div>
                            </div>
    
                            <div class="row gx-4 mt-2">
                                <div class="col-md-6 col-sm-12">
                                  <span class="d-block"
                                    ><liferay-ui:message key="shop-length" /><sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="shopLength"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpLength() : null %>"
                                  > 
                                  <aui:validator name="required"
										errorMessage="shop-length-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-4-digits-are-allowed"
										name="custom">
									function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,4}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                  <span class="d-block"
                                    ><liferay-ui:message key="shop-width" /><sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="shopWidth"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpWidth() : null %>"
                                  > 
                                  <aui:validator name="required"
										errorMessage="shop-width-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-4-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,4}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                              </div>
                              
                            <div class="row gx-4 mt-2">
                                <div class="col-md-6 col-sm-12">
                                  <span class="d-block"
                                    ><liferay-ui:message key="shop-storage-capacity" /> 
                                    <sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="shopStorageCap"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getShpStrgCpcty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="shop-storage-capacity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-10-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,10}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="mt-2 mb-3">
                                        <span class="d-block"><liferay-ui:message key="whether-the-floor-is-cemented" />
     
                                          <sup class="text-danger">*</sup></span>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="isCemented"
                                                id="cementedyes" checked="${dlrUpdTmpPriData.shpFlrCmntd == 1 }" value="1" > </aui:input>
                                            <label class="form-check-label" for="cementedyes"><liferay-ui:message key="yes" /></label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="isCemented"
                                                id="cementedno" checked="${dlrUpdTmpPriData.shpFlrCmntd == 0 }" value="0" > </aui:input>
                                            <label class="form-check-label" for="cementedno"><liferay-ui:message key="n-o-1" /></label>
                                        </div>
                                      
                                    
                                    </div>
                                </div>
                              </div>

                              <div class="row gx-4 mt-2">
                                <div class="col-md-6 col-sm-12">
                                    <div class="mt-2 mb-3">
                                        <span class="d-block"><liferay-ui:message key="does-the-shop-have-a-signboard" />?

     
                                          <sup class="text-danger">*</sup></span>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="signBoard"
                                                id="signboardyes" checked="${dlrUpdTmpPriData.shpSignBrd == 1 }" value="1" > </aui:input>
                                            <label class="form-check-label" for="signboardyes"><liferay-ui:message key="yes" /></label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="signBoard"
                                                id="signboardno" checked="${dlrUpdTmpPriData.shpSignBrd == 0 }" value="0" > </aui:input>
                                            <label class="form-check-label" for="signboardno"><liferay-ui:message key="n-o-1" /></label>
                                        </div>
                                      
                                    
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <span class="d-block"
                                      ><liferay-ui:message key="what-licenses-does-the-dealer-possess" />?
                                      <sup class="text-danger">*</sup></span
                                    >
                                    <div class="col-md-12 col-sm-12 mt-2 d-flex justify-content-start">
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="foodgrainLicense" label="" type="checkbox" id="inlineCheckbox1" checked="true" value="1" readonly="true" ></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox1"><liferay-ui:message key="food-grain-license" /></label>
                                      </div>
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="tradeLicense" label="" type="checkbox" id="inlineCheckbox2" checked="${dlrUpdTmpPriData.tradeLicense == 1 }" value="1"></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox2"><liferay-ui:message key="trade-license" /></label>
                                      </div>
                                     </div>
                                     <div class="col-md-12 col-sm-12 d-flex justify-content-start">
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="tcvDlrLicense" label="" type="checkbox" id="inlineCheckbox3" checked="${dlrUpdTmpPriData.tcvDlrLicense == 1 }" value="1"></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox3"><liferay-ui:message key="tcv-dealer-license" /></label>
                                      </div>
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="importLicense" label="" type="checkbox" id="inlineCheckbox4" checked="${dlrUpdTmpPriData.importLicense == 1 }" value="1"></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox4"><liferay-ui:message key="import-license" /></label>
                                      </div>
                                      </div>
                                      <div class="col-md-12 col-sm-12 d-flex justify-content-start">
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="licenseEssentialGoods" label="" type="checkbox" id="inlineCheckbox5" checked="${dlrUpdTmpPriData.licenseEssentialGoods == 1 }" value="1"></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox5"><liferay-ui:message key="license-for-essential-goods" /></label>
                                      </div>
                                      <div class="col-md-6 col-sm-12 d-flex justify-content-start form-check form-check-inline">
                                        <aui:input class="form-check-input" name="tradeLicenseAgriculture" label="" type="checkbox" id="inlineCheckbox6" checked="${dlrUpdTmpPriData.tradeLicenseAgriculture == 1 }" value="1"></aui:input>
                                        <label class="mb-4 ms-3 form-check-label" for="inlineCheckbox6"><liferay-ui:message key="trade-license-for-agriculture-commodities" /></label>
                                      </div>
                                      </div>
                                  </div>
                            
                              </div>
                              <div class="row gx-4 mt-2">
                             
                                <div class="col-md-6 col-sm-12">
                                    <div class="mt-2 mb-3">
                                        <span class="d-block"><liferay-ui:message key="does-the-dealer-run-the-shop-himself" />?

     
                                          <sup class="text-danger">*</sup></span>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="dlrRunShpHimself"
                                                id="unmarried" checked="${dlrRegAddlPriData.dlrRunShpHimself == 1 }" value="1"  onclick="hideFamilyDetails()"> 
                                                	<aui:validator name="required" errorMessage="please-select-does-dealer-run-the-shop-himself" />
                                                </aui:input>
                                            <label class="form-check-label" for="unmarried"><liferay-ui:message key="yes" /></label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <aui:input class="form-check-input" type="radio" label="" name="dlrRunShpHimself"
                                                id="married" checked="${dlrRegAddlPriData.dlrRunShpHimself == 0 }" value="0"  onclick="showFamilyDetails()"> </aui:input>
                                            <label class="form-check-label" for="married"><liferay-ui:message key="n-o-1" /></label>
                                        </div>
                                      
                                    
                                    </div>
                                </div>
                              </div>
                              <div id="dlrNotRunShpHimselfDtls" >
                              	<div class="row gx-4 mt-2">
	                              <div class="col-md-6 col-sm-12">
	                                  <span class="d-block"
	                                    > <liferay-ui:message key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-name-of-the-member" />
	
	                                    </span
	                                  >
	                                  <aui:input
	                                    class="form-control"
	                                    type="text"
	                                    name="dealershipMemName"
	                                    placeholder="type-here"
	                                    aria-label="default input example"
	                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrshpFmlyMmbrName() : null %>"
	                                  > 
	                                  <%-- <aui:validator name="required"
											errorMessage="dealership-family-member-name-is-required" /> --%>
	                                  	<aui:validator
										errorMessage="only-alphabets-are-allowed-and-length-does-not-more-than-30-characters" name="custom">
						                function(val, fieldNode, ruleValue) {
						                        var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,30}$/);
												return regex.test(val);
						                }
	        		 				</aui:validator>
	                                  </aui:input>
	                                </div>
	                            
	                                <div class="col-md-6 col-sm-12"">
	                                  <span class="d-block"
	                                    > <liferay-ui:message key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-type-of-dealership" />
	 
	
	                                    </span
	                                  >
	                                  <aui:input
	                                    class="form-control"
	                                    type="text"
	                                    name="dealershipMemType"
	                                    placeholder="type-here"
	                                    aria-label="default input example"
	                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrshpFmlyMmbrType() : null %>"
	                                  > 
	                                  	<%-- <aui:validator name="required"
											errorMessage="dealership-family-member-type-is-required" /> --%>
	                                  	<aui:validator
										errorMessage="only-alphabets-are-allowed-and-length-does-not-more-than-30-characters" name="custom">
						                function(val, fieldNode, ruleValue) {
						                        var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,30}$/);
												return regex.test(val);
						                }
	        		 				</aui:validator>
	                                  </aui:input>
	                                </div>
	                              </div>
                              </div>
								<h1 id="dealerType" class="d-none"><%= dgfDlrRegDtls.getDlrTypeId()%></h1>
						
                              <div id="omsTruckDetails" class="">
                              	<h5 class="green-text fw-bold mb-0"><liferay-ui:message key="truck-details" /></h5>
                              <div class="green-bg mb-2">
                                <hr class="mt-0 mb-0" />
                              </div>
                              <div class="row gx-4 mt-2">
                                <div class="col-md-4 col-sm-12">
                                  <div class="mt-2 mb-3">
                                      <span class="d-block"> <liferay-ui:message key="dealership-truck-type" />

   
                                        <sup class="text-danger"></sup></span>
                                      <div class="form-check form-check-inline">
                                          <aui:input class="form-check-input" type="radio" label="" name="truckType"
                                              id="tracktype1" checked="${dlrRegAddlPriData.dlrShpTrckTypFlg == 1 }" value="1" > </aui:input>
                                          <label class="form-check-label" for="tracktype1"><liferay-ui:message key="yes" /></label>
                                      </div>
                                      <div class="form-check form-check-inline">
                                          <aui:input class="form-check-input" type="radio" label="" name="truckType"
                                              id="tracktype2" checked="${dlrRegAddlPriData.dlrShpTrckTypFlg == 0 }" value="0" > </aui:input>
                                          <label class="form-check-label" for="tracktype2"><liferay-ui:message key="n-o-1" /></label>
                                      </div>
                                    
                                  
                                  </div>
                              </div>
                              <div class="col-md-4 col-sm-12">
                                <div class="mt-2 mb-3">
                                    <span class="d-block"> <liferay-ui:message key="truck-rent-own" />

 
                                      <sup class="text-danger"></sup></span>
                                    <div class="form-check form-check-inline">
                                        <aui:input class="form-check-input" type="radio" label="" name="truckRentFlag"
                                            id="owntrack" checked="${dlrRegAddlPriData.trckRentOwnFlg == 'Own' }" value="Own" > </aui:input>
                                        <label class="form-check-label" for="owntrack"><liferay-ui:message key="own" /></label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <aui:input class="form-check-input" type="radio" label="" name="truckRentFlag"
                                            id="renttrack" checked="${dlrRegAddlPriData.trckRentOwnFlg == 'Rent' }" value="Rent" > </aui:input>
                                        <label class="form-check-label" for="renttrack"><liferay-ui:message key="rent" /></label>
                                    </div>
                                  
                                
                                </div>
                            </div> 
                              <div class="col-md-4 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="truck-license-plat-no" /><sup class="text-danger"></sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="truckPlatNo"
                                  placeholder=""
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getTrckLicnsPlatNo() : null %>"
                                > 
                                	<%-- <aui:validator name="required"
										errorMessage="truck-license-plat-no-is-required" /> --%>
								<aui:validator
									errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-20-characters"
									name="custom">
									function(val, fieldNode, ruleValue) {
									var regex = new RegExp(/^(?!0+$)[A-Za-z0-9]|[0-9\u09E6-\u09EF]|[a-zA-Z\u0980-\u09FF\s]{1,20}$/);
									return regex.test(val);
									}
								</aui:validator>
                                </aui:input>
                              </div>
                              </div>
                              <div class="row gx-4 mt-2">
                                <div class="col-md-6 col-sm-12">
                                  <span class="d-block"
                                    ><liferay-ui:message key="truck-capacity" /><sup class="text-danger"></sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="truckCap"
                                    placeholder="auto-populate"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ?  (dlrUpdTmpPriData.getTrckCpcty() > 0 ? dlrUpdTmpPriData.getTrckCpcty() : "") : null %>"
                                  > 
                                  	<%-- <aui:validator name="required"
										errorMessage="truck-capacity-is-required" /> --%>
                                  	<aui:validator errorMessage="only-numbers-between-1-to-2-digits-are-allowed-"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,2}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                  <span class="d-block"
                                    ><liferay-ui:message key="truck-make" /><sup class="text-danger"></sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="truckMake"
                                    placeholder=""
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getTrckMake() : null %>"
                                  > 
                                  <%-- <aui:validator name="required"
										errorMessage="truck-make-is-required" /> --%>
                                  	<aui:validator
									errorMessage="only-alphabets-are-allowed-and-length-does-not-more-than-30-characters" name="custom">
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
                                <span class="d-block"
                                  ><liferay-ui:message key="truck-model" /><sup class="text-danger"></sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="truckModel"
                                  placeholder=""
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getTrckModel() : null %>"
                                > 
                                	<%-- <aui:validator name="required"
										errorMessage="truck-model-is-required" /> --%>
                                  	<aui:validator
									errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-30-characters" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[A-Za-z0-9]|[0-9\u09E6-\u09EF]|[a-zA-Z\u0980-\u09FF\s]{1,30}$/);
											return regex.test(val);
					                }
        		 				</aui:validator>
                                </aui:input>
                              </div>
                               
                              <div class="col-md-6 col-sm-12">
                                <span class="d-block"
                                  ><liferay-ui:message key="truck-manufacturing-year" /><sup class="text-danger"></sup></span
                                >
                                <aui:input
                                  class="form-control"
                                  type="text"
                                  name="truckManuYear"
                                  placeholder=""
                                  aria-label="default input example"
                                  value="<%=dlrUpdTmpPriData != null ? (dlrUpdTmpPriData.getTrckMfgYr() > 0 ? dlrUpdTmpPriData.getTrckMfgYr() : "") : null %>"
                                > 
                                	<%-- <aui:validator name="required"
										errorMessage="truck-manufacturing-year-is-required" /> --%>
                                  	<aui:validator errorMessage="only-4-digit-numbers-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[1-9\u09E6-\u09EF][0-9\u09E6-\u09EF]{3}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                </aui:input>
                              </div>

                              </div>
                              </div>
          
                              <h5 class="green-text fw-bold mb-0"><liferay-ui:message key="performance-of-last-three-years" /></h5>
                              <div class="green-bg mb-2">
                                <hr class="mt-0 mb-0" />
                              </div>
                              <div class="row gx-4 mt-2">
                                <div class="col-xl-1 col-md-2">
                                  <span class="d-block"
                                    ><liferay-ui:message key="sl-no" /><sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr1SN"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr1() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="sl-no-is-required" />
                                  	<aui:validator errorMessage="only-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,10}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr2SN"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr2() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="sl-no-is-required" />
                                  	<aui:validator errorMessage="only-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,10}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr3SN"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr3() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="sl-no-is-required" />
                                  	<aui:validator errorMessage="only-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,10}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                                <div class="col-xl-3 col-md-4">
                                  <span class="d-block"
                                    > <liferay-ui:message key="allocation-quantity-mt" />
                                    <sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr1AllocQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr1AllocQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="allocation-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr2AllocQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr2AllocQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="allocation-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr3AllocQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr3AllocQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="allocation-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>
                                <div class="col-xl-4 col-md-6">
                                  <span class="d-block"
                                    ><liferay-ui:message key="quantity-of-commodity-lifted-mt" />
                                    <sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr1ComdtyQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr1ComdtyQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="commodity-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr2ComdtyQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr2ComdtyQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="commodity-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr3ComdtyQty"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr3ComdtyQty() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="commodity-quantity-is-required" />
                                  	<aui:validator errorMessage="only-numbers-between-1-to-5-digits-are-allowed"
										name="custom">
										function(val, fieldNode, ruleValue) {
                        				var regex = /^(?!0+$)[0-9\u09E6-\u09EF]{1,5}$/;
										return regex.test(val);
                					}
									</aui:validator>
                                  </aui:input>
                                </div>

                                <div class="col-xl-2 col-md-6">
                                  <span class="d-block"
                                    ><liferay-ui:message key="dealer-category" />
                                    <sup class="text-danger">*</sup></span
                                  >
                                  <aui:select
                                    class="form-select"
                                    name="dlrPerfYr1DlrCtgry"
                                    aria-label="Default select example"
                                  >
                                  <aui:validator name="required" errorMessage="dealer-category-is-required" />
                                    <aui:option selected="true"><liferay-ui:message key="please-select-option" /></aui:option>
                                    <aui:option value="OMS" selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr1DlrCtgry}'><liferay-ui:message key="oms" /></aui:option>
                                    <aui:option value="FFP" selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr1DlrCtgry}'><liferay-ui:message key="ffp" /></aui:option>
                                  </aui:select>
                                  <aui:select
                                    class="form-select"
                                    name="dlrPerfYr2DlrCtgry"
                                    aria-label="Default select example"
                                  >
                                 <aui:validator name="required" errorMessage="dealer-category-is-required" />
                                    <aui:option selected="true"><liferay-ui:message key="please-select-option" /></aui:option>
                                    <aui:option value="OMS" selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr2DlrCtgry}'><liferay-ui:message key="oms" /></aui:option>
                                    <aui:option value="FFP" selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr2DlrCtgry}'><liferay-ui:message key="ffp" /></aui:option>
                                  </aui:select>
                                  <aui:select
                                    class="form-select"
                                    name="dlrPerfYr3DlrCtgry"
                                    aria-label="Default select example"
                                  >
                                  <aui:validator name="required" errorMessage="dealer-category-is-required" />
                                    <aui:option selected="true"><liferay-ui:message key="please-select-option" /></aui:option>
                                    <aui:option value="OMS" selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr3DlrCtgry}'><liferay-ui:message key="oms" /></aui:option>
                                    <aui:option value="FFP" selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr3DlrCtgry}'><liferay-ui:message key="ffp" /></aui:option>
                                  </aui:select>
                                </div>

                                <div class="col-xl-2 col-md-6">
                                  <span class="d-block"
                                    ><liferay-ui:message key="remark-of-any" />
                                    <sup class="text-danger">*</sup></span
                                  >
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr1Rmrk"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr1Rmrk() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="remark-is-required" />
									<aui:validator
										errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-300-characters"
										name="custom">
										function(val, fieldNode, ruleValue) {
										var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,300}$/);
										return regex.test(val);
										}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr2Rmrk"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr2Rmrk() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="remark-is-required" />
									<aui:validator
										errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-300-characters"
										name="custom">
										function(val, fieldNode, ruleValue) {
										var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,300}$/);
										return regex.test(val);
										}
									</aui:validator>
                                  </aui:input>
                                  <aui:input
                                    class="form-control"
                                    type="text"
                                    name="dlrPerfYr3Rmrk"
                                    placeholder="type-here"
                                    aria-label="default input example"
                                    value="<%=dlrUpdTmpPriData != null ? dlrUpdTmpPriData.getDlrPerfYr3Rmrk() : null %>"
                                  > 
                                  	<aui:validator name="required"
										errorMessage="remark-is-required" />
									<aui:validator
										errorMessage="only-alphabets-and-numbers-are-allowed-and-length-does-not-more-than-300-characters"
										name="custom">
										function(val, fieldNode, ruleValue) {
										var regex = new RegExp(/^[a-zA-Z\u0980-\u09FF\s]{1,300}$/);
										return regex.test(val);
										}
									</aui:validator>
                                  </aui:input>
                                </div>

                                
                              </div>
    
                            <div>
                                <a class="btn btn-reset me-2" href="<%=backUrl%>">
									<i class="icon-circle-arrow-left"></i>
									<!-- Back-->
									<liferay-ui:message key="back" />
								</a>
                                <button class="btn btn-success green-bg">
                                    <liferay-ui:message key="next" /> <i class="icon-circle-arrow-right"></i>
                                </button>
                            </div>


                        </div>
                     
                    </aui:form>
                </div>
            </div>
          
</body>
<script type="text/javascript">
	function showField(){
		  var physclyChlngdDocField = document.getElementById("physclyChlngdDocField");
		  physclyChlngdDocField.style.display="block";
	}
	 function hideField(){
		  var physclyChlngdDocField = document.getElementById("physclyChlngdDocField");
		  physclyChlngdDocField.style.display="none";
	 }
	 //dlrRunShpHimself
	 function showFamilyDetails(){
		  var dlrNotRunShpHimselfDtls = document.getElementById("dlrNotRunShpHimselfDtls");
		  dlrNotRunShpHimselfDtls.style.display="block";
	}
	 function hideFamilyDetails(){
		  var dlrNotRunShpHimselfDtls = document.getElementById("dlrNotRunShpHimselfDtls");
		  dlrNotRunShpHimselfDtls.style.display="none";
	 }
	var dealerType = document.getElementById("dealerType").innerHTML;
	if(dealerType == "OMS"){
		var omsTruckDetails = document.getElementById("omsTruckDetails");
		omsTruckDetails.style.display="block";
	}else{
		var omsTruckDetails = document.getElementById("omsTruckDetails");
		omsTruckDetails.style.display="none";
	}
	
	//file upload back
	var tradeLFileInputs = document.querySelectorAll('input[type="file"]');
    		var file;
 			tradeLFileInputs.forEach((tradLfile) => {
	 			var file;
	 			var fileUrl = getFileUrl(tradLfile.name);
				if(fileUrl) {
	 			fetch(fileUrl)
				.then(res => res.blob()) // Gets the response and returns it as a blob
				.then(blob => {
				  var  file = new File([blob],getFileName(tradLfile.name).split('_').slice(1).join('_'), {
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
 				if(fileInputName.includes("physclyChlngdDoc")){
	 				fileUrl = '<%= physclyChlngdObj != null ? physclyChlngdObj.getFilePath() : "" %>';	
 				}
				 return fileUrl;
 			}
 			
 			function getFileName(fileInputName) {
 				var fileName;
 				if(fileInputName.includes("physclyChlngdDoc")){
 					fileName = '<%= physclyChlngdObj != null ? physclyChlngdObj.getTitle() : "" %>';	
 				}
				 return fileName;
 			}
	</script> 

</html>
