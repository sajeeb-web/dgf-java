<%@ include file="init.jsp"%>
<%@ include file="js/dlr_shp_loc.js"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.dgfLocDivision"%>
<%@page
	import="bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil"%>

<%
	List<dgfLocDivision> divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(0,
			dgfLocDivisionLocalServiceUtil.getdgfLocDivisionsCount());
	Map<String, Object> dealerDetailData = (Map<String, Object>) request.getAttribute("dealerDetailData");
	String languageId = (String) request.getAttribute("languageId");
%>
<!DOCTYPE html>



<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dealer Profile Details</title>


</head>

<body>

	<div class="px-md-5 px-sm-3 px-2">


		<div class="container-fluid p-2">

			<div class="m-4">
				<hr class="mt-3 mb-1" />
				<div class="d-flex justify-content-between">
					<span class=" fw-bold p-0 m-0"><liferay-ui:message
							key="my-profile" /></span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
							key="last-login" /> <span>31 Aug 2021 | 14:30</span>
					</span>
				</div>

				<hr class="mt-1 mb-3" />
				<form action=" ">
					<div class="accordion" id="myAccordionOne">
						<div class="accordion-item rounded-3 border border-2">
							<h2 class="accordion-header " id="headingOne">
								<button type="button" class="accordion-button collapsed fw-bold"
									data-bs-toggle="collapse" data-bs-target="#collapseOne">
									<liferay-ui:message key="basic-info" />
								</button>
							</h2>
							<div id="collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#myAccordionOne">
								<div class="card-body">
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="license-number" /><sup class="text-danger">*</sup></span> <input
												class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("fglLicNo")%></c:if>" />
										</div>

										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="license-date-of-issue" /><sup class="text-danger">*</sup></span>
											<input class="form-control" type="date"
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
													<%=dealerDetailData.get("fglIssueDate")%></c:if>" />
										</div>
									</div>
									<div class="mt-2 mb-3">
										<span class="d-block"><liferay-ui:message
												key="dealership-type" /><sup class="text-danger">*</sup></span>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOption" id="inlineRadio1" value="FFP"
												<c:if test="<%=dealerDetailData != null%>">
													<%=(dealerDetailData.get("dlrType").equals("FFP")) ? "checked" : ""%></c:if> />
											<label class="form-check-label" for="inlineRadio1">food-friendly-programme
											</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOption" id="inlineRadio2" value="OMS"
												<c:if test="<%=dealerDetailData != null%>">
													<%=(dealerDetailData.get("dlrType").equals("OMS")) ? "checked" : ""%></c:if> /><label
												class="form-check-label" for="inlineRadio2">open-market-sales</label>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

					<br>
					<div class="accordion" id="myAccordionTwo">
						<div class="accordion-item rounded-3 border border-2">
							<h2 class="accordion-header" id="headingTwo">
								<button type="button" class="accordion-button collapsed fw-bold"
									data-bs-toggle="collapse" data-bs-target="#collapseTwo">
									<liferay-ui:message key="information-related-to-husband-wife" />
								</button>
							</h2>
							<div id="collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#myAccordionTwo">
								<div class="card-body">
									<div class="mt-2 mb-3">
										<span class="d-block"><liferay-ui:message
												key="marital-status" /><sup class="text-danger">*</sup></span>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="unmarried" value="unmarried"
												<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("maritialStatus").equals("unmarried")) ? "checked" : ""%>
										</c:if> />
											<label class="form-check-label" for="unmarried"> <liferay-ui:message
													key="unmarried" />
											</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="married" value="married"
												<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("maritialStatus").equals("married")) ? "checked" : ""%>
										</c:if> />
											<label class="form-check-label" for="married"> <liferay-ui:message
													key="married" /></label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="divorced" value="divorced"
												<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("maritialStatus").equals("divorced")) ? "checked" : ""%>
										</c:if> />
											<label class="form-check-label" for="divorced"> <liferay-ui:message
													key="divorced" /></label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="widow" value="widow"
												<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("maritialStatus").equals("widow")) ? "checked" : ""%>
										</c:if> />
											<label class="form-check-label" for="widow"> <liferay-ui:message
													key="widow" /></label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="widower" value="widower"
												<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("maritialStatus").equals("widower")) ? "checked" : ""%>
										</c:if> />
											<label class="form-check-label" for="widower"> <liferay-ui:message
													key="widower" /></label>
										</div>
									</div>
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"> <liferay-ui:message
													key="spouse-name" /></span> <input class="form-control"
												type="text" placeholder=""
												aria-label="default input example"
												value="<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseName") != null%>">
											<%=dealerDetailData.get("spouseName")%>
										</c:if>" />
										</div>

										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="spouse-father-name" /></span> <input class="form-control"
												type="text" placeholder="Type Here"
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("spouseFatherName") != null%>">
											<%=dealerDetailData.get("spouseFatherName")%>
										</c:if>" />
										</div>
									</div>
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="spouse-nid-number" /><sup class="text-danger">*</sup></span>
											<input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseNid") != null%>">
											<%=dealerDetailData.get("spouseNid")%>
										</c:if>" />
										</div>

										<div class="col-md-6 col-sm-12">
											<span class="d-block"> <liferay-ui:message
													key="spouse-date-of-birth" /><sup class="text-danger">*</sup></span>
											<input class="form-control" type="date" placeholder=""
												aria-label="default input example"
												value="<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseDob") != null%>">
											<%=dealerDetailData.get("spouseDob")%>
										</c:if>" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="accordion" id="myAccordionThree">
						<div class="accordion-item rounded-3 border border-2">
							<h2 class="accordion-header" id="headingThree">
								<button type="button" class="accordion-button collapsed fw-bold"
									data-bs-toggle="collapse" data-bs-target="#collapseThree">
									<liferay-ui:message key="dealer-info" />
								</button>
							</h2>
							<div id="collapseThree" class="accordion-collapse collapse"
								data-bs-parent="#myAccordionThree">
								<div class="card-body">
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"><liferay-ui:message
														key="work-in-the-government" /> <sup class="text-danger">*</sup></span>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="unmarried" value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("wrkGovt").equals("Yes")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="unmarried"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="married" value="0"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("wrkGovt").equals("n-o-1")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="married"><liferay-ui:message
															key="n-o-1" /></label>
												</div>


											</div>
										</div>

										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"><liferay-ui:message
														key="public-representative" /> <sup class="text-danger">*</sup></span>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions1" id="publicrepresntative1"
														value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("pblcRep").equals("Yes")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="publicrepresntative1"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions1" id="publicrepresntative2"
														value="0"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("pblcRep").equals("n-o-1")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="publicrepresntative2"><liferay-ui:message
															key="n-o-1" /></label>
												</div>


											</div>
										</div>

									</div>

									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"><liferay-ui:message
														key="physically-challenged" /> <sup class="text-danger">*</sup></span>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions3" id="physicallychallengedyes"
														value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("physclyChlngd").equals("Yes")) ? "checked" : ""%>
										</c:if> /><label
														class="form-check-label" for="physicallychallengedyes"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions3" id="physicallychallengedno"
														value="0"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("physclyChlngd").equals("n-o-1")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label"
														for="physicallychallengedno"><liferay-ui:message
															key="n-o-1" /></label>
												</div>


											</div>
										</div>
										<div class="col-md-6 col-sm-12">

											<label for="formFile" class="form-label"><liferay-ui:message
													key="if-yes-proof-of-physically-challenged" /> </label> <span><c:if
													test="<%=dealerDetailData != null%>">
													<c:if
														test="<%=dealerDetailData.get("physclyChlngAttchmnt") != null%>">
														<a class="text-decoration-none font-italic"
															href="<%=dealerDetailData.get("physclyChlngAttchmnt")%>"
															target="_blank"><mark class="mark ">
																<liferay-ui:message key="view" />
																<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
															</mark> </a>
													</c:if>
												</c:if></span>
											<aui:input class="form-control" name="physclyChlngdDoc"
												id="physclyChlngdDoc" type="file" label=""
												placeholder="choose-file">
												<%-- <aui:validator name="required" errorMessage="proof-of-physically-challenged-is-required" /> --%>
												<aui:validator name="custom"
													errorMessage="only-pdf-doc-docx-jpg-png-formats-are-allowed">
									        function(val, fieldNode, ruleValue) {
									            var file = fieldNode.getDOM().files[0];
									            // Check for file type
									            var fileType = file ? file.type : '';
									            var allowedTypes = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', 'image/jpeg', 'image/png'];
									
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
											<aui:input name="physclyChlngdDocType" type="hidden"
												value="certificate" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="accordion" id="myAccordionFour">
						<div class="accordion-item rounded-3 border border-2">
							<h2 class="accordion-header" id="headingFour">
								<button type="button" class="accordion-button collapsed fw-bold"
									data-bs-toggle="collapse" data-bs-target="#collapseFour">
									<liferay-ui:message key="shop-details" />
								</button>
							</h2>
							<div id="collapseFour" class="accordion-collapse collapse"
								data-bs-parent="#myAccordionFour">
								<div class="card-body">
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="region-division" /><sup class="text-danger">*</sup></span>

											<aui:select class="form-select" name="shopDiv" id="division"
												aria-label="Default select example">

												<aui:option value="" label="" selected="true"
													disabled="true">
													<c:choose>
														<c:when
															test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												   		${dealerDetailData.shpDiv}
												   </c:when>
														<c:when test="<%=languageId.equals("bn_BD")%>">
														${dealerDetailData.shpDivBn}
													</c:when>
													</c:choose>
												</aui:option>

												<c:forEach var="division" items="${divisions}">
													<aui:option value="${division.id}" selected="">
														<c:choose>
															<c:when
																test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
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
											<span class="d-block"><liferay-ui:message
													key="district-zilla" /><sup class="text-danger">*</sup></span>
											<aui:select class="form-select" name="shopDis"
												aria-label="Default select example" id="district">

												<aui:option value="" label="" selected="true"
													disabled="true">
													<c:choose>
														<c:when
															test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												   		${dealerDetailData.shpDis}
												   </c:when>
														<c:when test="<%=languageId.equals("bn_BD")%>">
														${dealerDetailData.shpDisBn}
													</c:when>
													</c:choose>
												</aui:option>

												<c:forEach var="district" items="${districts}">
													<aui:option value="${district.id}"
														selected="${district.id == dlrUpdTmpPriData.shpDistrict}">
														<c:choose>
															<c:when
																test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
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
											<span class="d-block"><liferay-ui:message
													key="upazila" /><sup class="text-danger">*</sup></span>
											<aui:select class="form-select" name="shopUpazila"
												aria-label="Default select example" id="upzilla">
												<aui:option value="" label="" selected="true"
													disabled="true">
													<c:choose>
														<c:when
															test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												   		${dealerDetailData.shpSubDis}
												   </c:when>
														<c:when test="<%=languageId.equals("bn_BD")%>">
														${dealerDetailData.shpSubDisBn}
													</c:when>
													</c:choose>
												</aui:option>

												<c:forEach var="subdistrict" items="${subdistricts}">
													<aui:option value="${subdistrict.id}"
														selected="${subdistrict.id == dlrUpdTmpPriData.shpUpzilla}">
														<c:choose>
															<c:when
																test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
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
											<span class="d-block"><liferay-ui:message key="union" /><sup
												class="text-danger">*</sup></span>
											<aui:select class="form-select" name="shopUnion"
												aria-label="Default select example" id="unionName">
												<aui:option value="" label="" selected="true"
													disabled="true">
													<c:choose>
														<c:when
															test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												   		${dealerDetailData.shpUn}
												   </c:when>
														<c:when test="<%=languageId.equals("bn_BD")%>">
														${dealerDetailData.shpUnBn}
													</c:when>
													</c:choose>
												</aui:option>
												<c:forEach var="union" items="${unions}">
													<aui:option value="${union.id}"
														selected="${union.id == dlrUpdTmpPriData.shpUnion}">
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
											</aui:select>
										</div>
									</div>
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message key="ward" /><sup
												class="text-danger">*</sup></span> <input class="form-control"
												type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("shpWard")%></c:if>" />
										</div>
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="zip-code-post-code" /><sup class="text-danger">*</sup></span>
											<input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("shpZipCode")%></c:if>" />
										</div>
									</div>
									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="location-of-the-shop" /><sup class="text-danger">*</sup></span>
											<input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("shpLoc")%></c:if>" />
										</div>
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="shop-height" /><sup class="text-danger">*</sup></span> <input
												class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("shpHeight")%></c:if>" />
										</div>
									</div>

									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="shop-length" /><sup class="text-danger">*</sup></span> <input
												class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("shpLength")%></c:if>" />
										</div>
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="shop-width" /><sup class="text-danger">*</sup></span> <input
												class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpWidth")%></c:if>" />
										</div>
									</div>

									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="shop-storage-capacity" /> <sup class="text-danger">*</sup></span>
											<input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpCapacity")%></c:if>" />
										</div>
										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"><liferay-ui:message
														key="Whether-the-floor-is-cemented" />? <sup
													class="text-danger">*</sup></span>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="iscemented" id="cementedyes" value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("shpCmntd").equals("Yes")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="cementedyes"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="iscemented" id="cementedno" value="0"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("shpCmntd").equals("n-o-1")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="cementedno"><liferay-ui:message
															key="n-o-1" /></label>
												</div>


											</div>
										</div>
									</div>

									<div class="row gx-4 mt-2">
										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"> <liferay-ui:message
														key="does-the-shop-have-a-signboard" />? <sup
													class="text-danger">*</sup></span>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="signboard" id="signboardyes" value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("shpSignBrd").equals("Yes")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="signboardyes"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="signboard" id="signboardno" value="0"
														<c:if><%=(dealerDetailData.get("shpSignBrd").equals("n-o-1")) ? "checked" : ""%>
													</c:if> />
													<label class="form-check-label" for="signboardno"><liferay-ui:message
															key="n-o-1" /></label>
												</div>


											</div>
										</div>
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="what-licenses-does-the-dealer-possess" />? <sup
												class="text-danger">*</sup></span>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input" name="foodgrainLicense" label="" type="checkbox" id="inlineCheckbox1" value="1" <c:if test="<%= dealerDetailData != null && Integer.parseInt(dealerDetailData.get("dlrLicPossFglLic").toString()) == 1 %>">checked</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox1"><liferay-ui:message
														key="food-grain-license" /></label>
											</div>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input" name="tradeLicense"
													label="" type="checkbox" id="inlineCheckbox2" value="1"
													<c:if test="<%=dealerDetailData != null%>">
											<%=(Integer.parseInt(dealerDetailData.get("dlrLicPossTradeLic").toString()) == 1) ? "checked"
							: ""%>
										</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox2"><liferay-ui:message
														key="trade-license" /></label>
											</div>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input" name="tcvDlrLicense"
													label="" type="checkbox" id="inlineCheckbox3" value="1"
													<c:if test="<%=dealerDetailData != null%>">
											<%=(Integer.parseInt(dealerDetailData.get("dlrLicPossTcvDlrLic").toString()) == 1) ? "checked"
									: ""%>
										</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox3"><liferay-ui:message
														key="tcv-dealer-license" /></label>
											</div>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input" name="importLicense"
													label="" type="checkbox" id="inlineCheckbox4" value="1"
													<c:if test="<%=dealerDetailData != null%>">
											<%=(Integer.parseInt(dealerDetailData.get("dlrLicPossImportLic").toString()) == 1) ? "checked"
									: ""%>
										</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox4"><liferay-ui:message
														key="import-license" /></label>
											</div>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input"
													name="licenseEssentialGoods" label="" type="checkbox"
													id="inlineCheckbox5" value="1"
													<c:if test="<%=dealerDetailData != null%>">
											<%=(Integer.parseInt(dealerDetailData.get("dlrLicPossEsstnlGoodsLic").toString()) == 1)
							? "checked"
							: ""%>
										</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox5"><liferay-ui:message
														key="license-for-essential-goods" /></label>
											</div>
											<div class="form-check form-check-inline">
												<aui:input class="form-check-input"
													name="tradeLicenseAgriculture" label="" type="checkbox"
													id="inlineCheckbox6" value="1"
													<c:if test="<%=dealerDetailData != null%>">
											<%=(Integer.parseInt(dealerDetailData.get("dlrLicPossTradeAgriLic").toString()) == 1)
							? "checked"
							: ""%>
										</c:if>></aui:input>
												<label class="form-check-label" for="inlineCheckbox6"><liferay-ui:message
														key="trade-license-for-agriculture-commodities" /></label>
											</div>
										</div>

									</div>
									<div class="row gx-4 mt-2">

										<div class="col-md-6 col-sm-12">
											<div class="mt-2 mb-3">
												<span class="d-block"><liferay-ui:message
														key="does-the-dealer-run-the-shop-himself" />? <sup
													class="text-danger">*</sup></span>

												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="unmarried" value="1"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("dlrRunsShopHimself").equals("Yes")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="unmarried"><liferay-ui:message
															key="yes" /></label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="married" value="0"
														<c:if test="<%=dealerDetailData != null%>">
											<%=(dealerDetailData.get("dlrRunsShopHimself").equals("n-o-1")) ? "checked" : ""%>
										</c:if> />
													<label class="form-check-label" for="married"><liferay-ui:message
															key="n-o-1" /></label>
												</div>
											</div>
										</div>
										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-name-of-the-member" />

											</span> <input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("fmlyDlrLic") != null%>">
											<%=dealerDetailData.get("fmlyDlrLic")%></c:if>" />
										</div>
									</div>
									<div class="row gx-4 mt-2">

										<div class="col-md-6 col-sm-12">
											<span class="d-block"><liferay-ui:message
													key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-type-of-dealership" />


											</span> <input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("fmlyDlrLicType") != null%>">
											<%=dealerDetailData.get("fmlyDlrLicType")%></c:if>" />
										</div>
									</div>
									<h5 class="green-text fw-bold mb-0">
										<liferay-ui:message key="performance-of-last-three-years" />
									</h5>
									<div class="green-bg mb-2">
										<hr class="mt-0 mb-0" />
									</div>
									<div class="row gx-4 mt-2">
										<div class="col-xl-1 col-md-2">
											<span class="d-block"><liferay-ui:message key="sl-no" /><sup
												class="text-danger">*</sup></span> <input class="form-control"
												type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr1") != null%>">
											<%=dealerDetailData.get("dlrPerfYr1")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr2") != null%>">
											<%=dealerDetailData.get("dlrPerfYr2")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr3") != null%>">
											<%=dealerDetailData.get("dlrPerfYr3")%></c:if>" />
										</div>
										<div class="col-xl-3 col-md-4">
											<span class="d-block"><liferay-ui:message
													key="allocation-quantity-mt" /> <sup class="text-danger">*</sup></span>
											<input class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr1AllocQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr1AllocQty")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr2AllocQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr2AllocQty")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr3AllocQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr3AllocQty")%></c:if>" />
										</div>
										<div class="col-xl-4 col-md-6">
											<span class="d-block"><liferay-ui:message
													key="quantity-of-commodity-lifted-mt" /> <sup
												class="text-danger">*</sup></span> <input class="form-control"
												type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr1ComdtyQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr1ComdtyQty")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr2ComdtyQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr2ComdtyQty")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr3ComdtyQty") != null%>">
											<%=dealerDetailData.get("dlrPerfYr3ComdtyQty")%></c:if>" />
										</div>

										<div class="col-xl-2 col-md-6">
											<span class="d-block"><liferay-ui:message
													key="dealer-category" /> <sup class="text-danger"></sup></span>

											<aui:select class="form-select" name="dlrPerfYr1DlrCtgry"
												aria-label="Default select example">
												<aui:option selected="true">
													<c:if
														test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr1DlrCtgry") != null%>">
														<%=dealerDetailData.get("dlrPerfYr1DlrCtgry")%></c:if>
												</aui:option>
												<aui:option value="OMS"
													selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr1DlrCtgry}'>OMS</aui:option>
												<aui:option value="FFP"
													selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr1DlrCtgry}'>FFP</aui:option>
											</aui:select>
											<aui:select class="form-select" name="dlrPerfYr2DlrCtgry"
												aria-label="Default select example">
												<aui:validator name="required"
													errorMessage="dealer-category-is-required" />
												<aui:option selected="true">
													<c:if
														test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr2DlrCtgry") != null%>">
														<%=dealerDetailData.get("dlrPerfYr2DlrCtgry")%></c:if>
												</aui:option>
												<aui:option value="OMS"
													selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr2DlrCtgry}'>OMS</aui:option>
												<aui:option value="FFP"
													selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr2DlrCtgry}'>FFP</aui:option>
											</aui:select>
											<aui:select class="form-select" name="dlrPerfYr3DlrCtgry"
												aria-label="Default select example">
												<aui:validator name="required"
													errorMessage="dealer-category-is-required" />
												<aui:option selected="true">
													<c:if
														test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr3DlrCtgry") != null%>">
														<%=dealerDetailData.get("dlrPerfYr3DlrCtgry")%></c:if>
												</aui:option>
												<aui:option value="OMS"
													selected='${"OMS" == dlrUpdTmpPriData.dlrPerfYr3DlrCtgry}'>OMS</aui:option>
												<aui:option value="FFP"
													selected='${"FFP" == dlrUpdTmpPriData.dlrPerfYr3DlrCtgry}'>FFP</aui:option>
											</aui:select>
										</div>

										<div class="col-xl-2 col-md-6">
											<span class="d-block"><liferay-ui:message
													key="remark-of-any" /> <sup class="text-danger">*</sup></span> <input
												class="form-control" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr1Rmrk") != null%>">
											<%=dealerDetailData.get("dlrPerfYr1Rmrk")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr2Rmrk") != null%>">
											<%=dealerDetailData.get("dlrPerfYr2Rmrk")%></c:if>" />
											<input class="form-control mt-2" type="text" placeholder=""
												aria-label="default input example"
												value="<c:if test="<%=dealerDetailData != null && dealerDetailData.get("dlrPerfYr3Rmrk") != null%>">
											<%=dealerDetailData.get("dlrPerfYr3Rmrk")%></c:if>" />
										</div>


									</div>
								</div>
							</div>
						</div>
						<br>
					</div>
					<div class="accordion" id="myAccordionFive">
						<div class="accordion-item rounded-3 border border-2">
							<h2 class="accordion-header" id="headingFive">
								<button type="button" class="accordion-button collapsed fw-bold"
									data-bs-toggle="collapse" data-bs-target="#collapseFive">
									<liferay-ui:message key="uploaded-document" />
								</button>
							</h2>
							<div id="collapseFive" class="accordion-collapse collapse"
								data-bs-parent="#myAccordionFive">
								<div class="card-body">
									<table class="table">
										<thead>
											<tr>

												<th scope="col"><liferay-ui:message key="name" /></th>
												<th scope="col"><liferay-ui:message key="uploaded" /></th>
												<th scope="col"><liferay-ui:message key="new-upload" /></th>
											</tr>
										</thead>
										<tbody>
											<tr>

												<td><liferay-ui:message key="dealer-photograph" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message key="photocopy-of-food-grain" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message key="photocopy-of-nid" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="ownership-document-of-the-shop" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="signature-thumb-impression" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="photocopy-of-trade-license" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="photocopy-of-bank-solvency-certificate" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="income-tax-return-certificate" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="if-the-shop-is-rented-then-photocopy-of-the-rental-agreement" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>
											<tr>

												<td><liferay-ui:message
														key="additional-documentation-where-appcable" /></td>
												<td>
													<div class="row justify-content-between">
														<div class="card col bg-secondary " style="height: 4rem;">
															<img src="" class="card-img-top" alt="">
														</div>
														<span class="px-md-5 col px-sm-2 "> photo.jpg </span>
													</div>
												</td>
												<td><input class="form-control" type="file"
													id="formFileMultiple" multiple> <span
													class="text-document d-block"><liferay-ui:message
															key="only-pdf-doc-docx-jpg-png-formats-are-allowed-max-file-size-can-be-200-kb" /></span>
												</td>
											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>


					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<button class="btn green-bg text-light me-2">
								<liferay-ui:message key="submit" />
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>