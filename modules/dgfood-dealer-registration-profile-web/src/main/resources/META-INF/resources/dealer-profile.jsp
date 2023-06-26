<%@ include file="init.jsp"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>
<%
	Map<String, Object> dealerDetailData = (Map<String, Object>) renderRequest.getAttribute("dealerDetailData");
	String languageId = (String) renderRequest.getAttribute("languageId");
%>
<!DOCTYPE html>
<portlet:actionURL name="profileEdit" var="dealerProfileEditActionURL">
	<portlet:param name="mvcPath" value="/dealer-profile-edit.jsp" />
</portlet:actionURL>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>
</head>
<body>
<%
			String errorMessage = (String) request.getAttribute("showAlert");
			if (errorMessage != null) {
		%>
		<div class="modal fade" id="errorModal" tabindex="-1" role="dialog"
			aria-labelledby="errorModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-danger" id="errorModalLabel"><liferay-ui:message key="error" /></h5>
					</div>
					<%-- <div class="modal-body">
						<liferay-ui:message key="<%=errorMessage%>"></liferay-ui:message>
					</div> --%>
					<div class="modal-body">
						<c:if test="${showAlert == 'modalMessage'}">
							<liferay-ui:message key="dealer-registration-required" />
						</c:if>
					</div> 
					<div class="modal-footer">
					</div>
				</div>
			</div>
		</div>

		<aui:script use="jquery">
        $(document).ready(function() {
            $('#errorModal').modal('show');
        });
    </aui:script>
		<%
			}
		%>

    
	<aui:form name="dealerProfileForm" action="<%=dealerProfileEditActionURL%>"
					method="POST">
	<div class="px-md-5 px-sm-3 px-1 text-capitalize">
		 <hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">
				<liferay-ui:message key="dealer-profile" />
				</span> 
				<span class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/> <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />  


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
							<div class="col-md-12 col-sm-12">

								<div class="row justify-content-between px-2 ">

									<div class="col-md-5 col-sm-12">
										<ul class="alignMe">

											<li><span class="custom-colon"><liferay-ui:message
														key="license-no" /></span>
											<c:if test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("fglLicNo")%></c:if></li>


										</ul>
									</div>
									<div class="col-md-5 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"><liferay-ui:message
														key="license-date-of-issue" /></span>
											<c:if test="<%=dealerDetailData != null%>">
													<%=dealerDetailData.get("fglIssueDate")%></c:if></li>
										</ul>
									</div>
								</div>
								<div class="row justify-content-between px-2 ">
									<div class="col-md-5 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"><liferay-ui:message
														key="dealership-type" /></span>
											<c:if test="<%=dealerDetailData != null%>">
													<%=dealerDetailData.get("dlrType")%></c:if></li>
										</ul>
									</div>

								</div>
							</div>
						</div>
						<div class="mt-2 mb-3"></div>
					</div>
				</div>
			</div>
		</div>

		<br>
		<div class="accordion" id="myAccordionTwo">
			<div class="accordion-item rounded-3 border border-2">
				<h2 class="accordion-header " id="headingTwo">
					<button type="button" class="accordion-button collapsed fw-bold"
						data-bs-toggle="collapse" data-bs-target="#collapseTwo">
						<liferay-ui:message key="information-related-to-husband-wife" />
					</button>
				</h2>
				<div id="collapseTwo" class="accordion-collapse collapse"
					data-bs-parent="#myAccordionTwo">
					<div class="card-body">

						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="marital-status" /></span>
									<c:if test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("maritialStatus").toString().toLowerCase()%>" />
										</c:if></li>
								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="spouse-name" /></span>
									<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseName") != null%>">
											<%=dealerDetailData.get("spouseName")%>
										</c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-father-name" /></span> <c:if test="<%=dealerDetailData != null && dealerDetailData.get("spouseFatherName") != null%>">
											<%=dealerDetailData.get("spouseFatherName")%>
										</c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-date-of-birth" /></span>
									<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseDob") != null%>">
											<%=dealerDetailData.get("spouseDob")%>
										</c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-nid-number" /></span> <c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("spouseNid") != null%>">
											<%=dealerDetailData.get("spouseNid")%>
										</c:if></li>

								</ul>
							</div>

						</div>


					</div>
				</div>
			</div>
		</div>

		<br>

		<div class="accordion" id="myAccordionThree">
			<div class="accordion-item rounded-3 border border-2">
				<h2 class="accordion-header " id="headingThree">
					<button type="button" class="accordion-button collapsed fw-bold"
						data-bs-toggle="collapse" data-bs-target="#collapseThree">
						<liferay-ui:message key="dealer-info" />
					</button>
				</h2>
				<div id="collapseThree" class="accordion-collapse collapse"
					data-bs-parent="#myAccordionThree">
					<div class="card-body">
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="work-in-the-government" />&nbsp;?</span>
									<c:if test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("wrkGovt").toString().toLowerCase()%>" />
										</c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="public-representative" />&nbsp;?</span>
									<c:if test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("pblcRep").toString().toLowerCase()%>" />
										</c:if></li>

								</ul>
							</div>
						</div>

						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="physically-challenged" />&nbsp;?</span> <c:if
											test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("physclyChlngd").toString().toLowerCase()%>" />
										</c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-yes-proof-of-physically-challenged" /></span> <span
										class="px-md-5 px-sm-1"> <c:if
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
											</c:if>
									</span></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<br>

		<div class="accordion" id="myAccordionFour">
			<div class="accordion-item rounded-3 border border-2">
				<h2 class="accordion-header " id="headingFour">
					<button type="button" class="accordion-button collapsed fw-bold"
						data-bs-toggle="collapse" data-bs-target="#collapseFour">
						<liferay-ui:message key="shop-details" />
					</button>
				</h2>
				<div id="collapseFour" class="accordion-collapse collapse"
					data-bs-parent="#myAccordionFour">
					<div class="card-body">
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="region-division" /></span> <c:choose>
											<c:when
												test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpDiv")%>
												</c:if>
											</c:when>
											<c:when test="<%=languageId.equals("bn_BD")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpDivBn")%>
												</c:if>
											</c:when>
										</c:choose></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="district-zilla" /></span> <c:choose>
											<c:when
												test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpDis")%>
												</c:if>
											</c:when>
											<c:when test="<%=languageId.equals("bn_BD")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpDisBn")%>
												</c:if>
											</c:when>
										</c:choose></li>

								</ul>
							</div>
						</div>

						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="upazila" /></span> <c:choose>
											<c:when
												test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpSubDis")%>
												</c:if>
											</c:when>
											<c:when test="<%=languageId.equals("bn_BD")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpSubDisBn")%>
												</c:if>
											</c:when>
										</c:choose></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="union" /></span> <c:choose>
											<c:when
												test="<%=languageId.equals("en_US") || languageId.equals("en_GB")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpUn")%>
												</c:if>
											</c:when>
											<c:when test="<%=languageId.equals("bn_BD")%>">
												<c:if test="<%=dealerDetailData != null%>"><%=dealerDetailData.get("shpUnBn")%>
												</c:if>
											</c:when>
										</c:choose></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="ward" /></span>
									<c:if test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("shpWard")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="zip-code" /></span> <c:if
											test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("shpZipCode")%></c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="shop-length" /></span>
									<c:if test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("shpLength")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="shop-width" /></span> <c:if
											test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("shpWidth")%></c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="shop-storage-capacity" /></span>
									<c:if test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("shpCapacity")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="whether-the-floor-is-cemented" />&nbsp;?</span> <c:if
											test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("shpCmntd").toString().toLowerCase()%>" />
										</c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="does-the-shop-have-a-signboard" />?
									</span> <c:if test="<%=dealerDetailData != null%>">
											<liferay-ui:message key="<%=dealerDetailData.get("shpSignBrd").toString().toLowerCase()%>" />
										</c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="what-licenses-does-the-dealer-possess" />&nbsp;?</span></li>
								</ul>
								<div class="row justify-content-between px-2 ">
									<div class="col-md-4 col-sm-12">
										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossFglLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="food-grain-license" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="food-grain-license" /></label>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-4 col-sm-12">
										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossTradeLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="trade-license" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="trade-license" /></label>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-4 col-sm-12">
										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossTcvDlrLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="tcv-dealer-license" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="tcv-dealer-license" /></label>
											</c:otherwise>
										</c:choose>

									</div>
									<div class="col-md-4 col-sm-12">
										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossImportLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="import-license" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="import-license" /></label>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-md-4 col-sm-12">
										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossEsstnlGoodsLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="license-essential-goods" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="license-essential-goods" /></label>
											</c:otherwise>
										</c:choose>

									</div>
									<div class="col-md-4 col-sm-12">

										<c:choose>
											<c:when
												test="<%=Integer.parseInt(dealerDetailData.get("dlrLicPossTradeAgriLic").toString()) == 1%>">
												<i class="icon-check-sign fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="trade-license-for-agriculture-commodities" /></label>
											</c:when>
											<c:otherwise>
												<i class="icon-check-empty fs-6 me-2"></i>
												<label class="form-check-label"><liferay-ui:message
														key="trade-license-for-agriculture-commodities" /></label>
											</c:otherwise>
										</c:choose>

									</div>
								</div>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-name-of-the-member" />&nbsp;?
									</span> <c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("fmlyDlrLic") != null%>">
											<%=dealerDetailData.get("fmlyDlrLic")%></c:if></li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-type-of-dealership" /></span>
										<c:if
											test="<%=dealerDetailData != null && dealerDetailData.get("fmlyDlrLicType") != null%>">
											<%=dealerDetailData.get("fmlyDlrLicType")%></c:if></li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="dealer-category" /></span> <c:if
											test="<%=dealerDetailData != null%>">
											<%=dealerDetailData.get("dlrCategory")%></c:if></li>

								</ul>
							</div>

						</div>


					</div>
				</div>
			</div>
		</div>

		<br>

		<div class="accordion" id="myAccordionFive">
			<div class="accordion-item rounded-3 border border-2">
				<h2 class="accordion-header " id="headingFive">
					<button type="button" class="accordion-button collapsed fw-bold"
						data-bs-toggle="collapse" data-bs-target="#collapseFive">
						<liferay-ui:message key="uploaded-documents" />
					</button>
				</h2>
				<div id="collapseFive" class="accordion-collapse collapse"
					data-bs-parent="#myAccordionFive">
					<div class="card-body">

						<div class="row justify-content-between px-2">
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span> <liferay-ui:message
										key="bank-solvency-certificate" /> <sup class="text-danger">*</sup></span>

								<span class="px-md-5 px-sm-1"> <c:if
										test="<%=dealerDetailData != null%>">

										<a class="text-decoration-none font-italic"
											href="<%=dealerDetailData.get("bnkSolvCertAttch")%>"
											target="_blank"><mark class="mark ">
												<liferay-ui:message key="view" />
												<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark></a>

									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span><liferay-ui:message
										key="income-tax-return-certificate" /> <sup
									class="text-danger">*</sup> </span> <span class="px-md-5 px-sm-1">
									<c:if test="<%=dealerDetailData != null%>">

										<a class="text-decoration-none font-italic"
											href="<%=dealerDetailData.get("incmTaxAttch")%>"
											target="_blank"><mark class="mark ">
												<liferay-ui:message key="view" />
												<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark></a>

									</c:if>
								</span>
							</div>
						</div>
						<div class="row justify-content-between px-2">
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span> <liferay-ui:message
										key="ownership-document-of-the-shop" /> <sup
									class="text-danger">*</sup>
								</span> <span class="px-md-5 px-sm-1"> <c:if
										test="<%=dealerDetailData != null%>">
										<c:if
											test="<%=dealerDetailData.get("shpOwnshipDocAttch") != null%>">
											<a class="text-decoration-none font-italic"
												href="<%=dealerDetailData.get("shpOwnshipDocAttch")%>"
												target="_blank"><mark class="mark ">
													<liferay-ui:message key="view" />
													<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
												</mark> </a>
										</c:if>
									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span><liferay-ui:message key="rental-agreement" /> <sup
									class="text-danger"></sup> </span> <span class="px-md-5 px-sm-1">
									<c:if test="<%=dealerDetailData != null%>">
										<c:if
											test="<%=dealerDetailData.get("shpRentDocAttch") != null%>">
											<a class="text-decoration-none font-italic"
												href="<%=dealerDetailData.get("shpRentDocAttch")%>"
												target="_blank"><mark class="mark ">
													<liferay-ui:message key="view" />
													<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
												</mark> </a>
										</c:if>
									</c:if>
								</span>
							</div>
						</div>
						<div class="row justify-content-between px-2">
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<liferay-ui:message key="signature-thumb-impression" />
								<span class="px-md-5 px-sm-1"> <c:if
										test="<%=dealerDetailData != null%>">

										<a class="text-decoration-none font-italic"
											href="<%=dealerDetailData.get("signThumbAttch")%>"
											target="_blank"><mark class="mark ">
												<liferay-ui:message key="view" />
												<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark></a>

									</c:if>
								</span>
							</div>

						</div>
						
					</div>
				</div>
			</div>
		</div>
		<%-- <div class="row justify-content-between px-2">
			<div class="mt-3 col-md-12">

				<button class="btn btn-success green-bg">
					<liferay-ui:message key="edit-request" />
					<i class="icon-arrow-right"></i>
				</button>
			</div>

		</div> --%>
	</div>
	</aui:form>
</body>
</html>