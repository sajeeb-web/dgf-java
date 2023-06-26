<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@ include file="init.jsp"%>
<%@ page import="java.util.Map"%>

<%
	Map<String, Object> dealerDetailData = (Map<String, Object>) request.getAttribute("dealerData");
	String languageId = (String) request.getAttribute("languageId");
%>

<portlet:actionURL name="approvedDealerLicense" var="approvedDealerLicenseURL">
	<portlet:param name="dgfDlrRegDltsPrimaryId"
		value="<%=renderRequest.getAttribute("dgfDlrRegDltsPrimaryId").toString()%>" />
</portlet:actionURL>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dealer Application Preview</title>
<!-- Bootstrap CSS CDN  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.main-div {
	padding: 3rem;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

.green-text {
	color: #5bb600;
}

.green-bg {
	background-color: #5bb600 !important;
	color: #fff !important;
}

.green-bg:hover {
	background-color: #4a8a09 !important;
	color: #fff !important;
}

.user_avatar {
	background-color: #d6d4d4;
	width: 100%;
	height: 120px;
	margin-top: 25px;
	display: flex;
	justify-content: center;
	align-items: center;
	color: #fff;
}

.user_avatar i {
	font-size: 50px;
}

.prog-circle {
	width: 20px;
	height: 20px;
	border-radius: 50%;
	z-index: 2;
}

.prog-hr {
	height: 3px;
	width: 30%;
	margin-left: -3px;
	background-color: #3b3535;
}

li {
	list-style: none;
}

ol, ul {
	padding-left: 0 !important;
}

.alignMe .custom-colon {
	display: inline-block;
	width: 50%;
	position: relative;
	padding-right: 5px; /* Ensures colon does not overlay the text */
}

.alignMe .custom-colon::after {
	content: ":";
	position: absolute;
	right: 5px;
}

.captcha {
	width: 150px;
	color: #fff;
	padding: 10px;
}

@media screen and (max-width: 600px) {
	.main-div {
		padding: 1rem;
	}
}
</style>
</head>
<body>
	<div class="main-div text-capitalize">
		<hr class="my-1" />

		<div class="container-fluid">

			<div class="d-flex justify-content-between">

				<span class=" fw-bold p-0 m-0"> <!-- Dealer details --> <liferay-ui:message
						key="dealer-details" />
				</span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
						key="last-login" /><span><fmt:formatDate
							pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> |
				</span> <span><fmt:formatDate type="time" timeStyle="short"
							value="<%=user.getLastLoginDate()%>" /></span>
				</span>
			</div>

		</div>
		 
		<div class="container-fluid my-3">
			<c:choose>
				<c:when
					test="<%=Integer.parseInt(dealerDetailData.get("status").toString()) == 0%>">
					<div class="card reviewed-card py-2 px-4 mb-4">
						<h6 class="text-success fw-bold fs-5">
							<liferay-ui:message key="reviewed" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerDetailData.get("status").toString()) == 4%>">
					<div class="card rejected-card py-2 px-4 mb-4">
						<h6 class="text-danger fw-bold fs-5">
							<liferay-ui:message key="rejected" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerDetailData.get("status").toString()) == 1%>">
					<div class="card pending-card py-2 px-4 mb-4">
						<h6 class="text-warning fw-bold fs-5">
							<liferay-ui:message key="pending" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerDetailData.get("status").toString()) == 6%>">
					<div class="card pending-card py-2 px-4 mb-4">
						<h6 class="text-warning fw-bold fs-5">
							<liferay-ui:message key="payment-pending" />
						</h6>
					</div>
				</c:when>
			</c:choose>

		</div>


		<div class="card">
			<div
				class="card-header d-flex justify-content-between align-items-center">
				<span class="fs-5 fw-bold p-0 my-2"> <liferay-ui:message
						key="dealer-application-no" /> <c:if
						test="<%=dealerDetailData != null%>">
						<%=dealerDetailData.get("applicationNo")%></c:if>
				</span>
			</div>
			<div class="card_body py-4 px-3">


					<div class="row">
						<div class="col-md-9 col-sm-12">
							<h5 class="green-text fw-bold mb-0">
								<liferay-ui:message key="basic-info" />
							</h5>
							<div class="green-bg">
								<hr class="mt-0 mb-0" />
							</div>

							<div class="row justify-content-between px-2 ">

								<div class="col-md-5 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"><liferay-ui:message
													key="license-no" /></span> <c:if
												test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("fglLicNo")%></c:if></li>

									</ul>
								</div>
								<div class="col-md-5 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"><liferay-ui:message
													key="license-date-of-issue" /></span> <c:if
												test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("fglIssueDate")%></c:if></li>

									</ul>
								</div>
							</div>


							<div class="row justify-content-between px-2 ">
								<div class="col-md-5 col-sm-12">
									<ul class="alignMe">
										<li><span class="custom-colon"><liferay-ui:message
													key="dealership-type" /></span> <c:if
												test="<%=dealerDetailData != null%>">
												<%=dealerDetailData.get("dlrType")%></c:if></li>

									</ul>
								</div>

							</div>


						</div>

					</div>

					<h5 class="green-text fw-bold mb-0 mt-2">
						<liferay-ui:message key="information-related-to-husband-wife" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>

					<div class="row justify-content-between px-2 ">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="marital-status" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("maritialStatus")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <liferay-ui:message
											key="spouse-name" />
								</span> <c:if
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
											key="spouse-fathers-name" /></span> <c:if
										test="<%=dealerDetailData != null && dealerDetailData.get("spouseFatherName") != null%>">
										<%=dealerDetailData.get("spouseFatherName")%>
									</c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="spouse-date-of-birth" /></span> <c:if
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



					<h5 class="green-text fw-bold mb-0 mt-2">
						<liferay-ui:message key="dealer-info" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
					<div class="row justify-content-between px-2 ">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="work-in-the-government" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("wrkGovt")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="public-represntative" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("pblcRep")%></c:if></li>

							</ul>
						</div>
					</div>

					<div class="row justify-content-between px-2 ">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="phisically-challenged" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("physclyChlngd")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <liferay-ui:message
											key="if-yes-proof-of-phisically-challenged" /></span> <span
									class="px-md-5 px-sm-1"> <span><c:if
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
											</c:if> </span></li>

							</ul>
						</div>
					</div>

					<h5 class="green-text fw-bold mb-0 mt-2">
						<liferay-ui:message key="shop-details" />
					</h5>
					<div class="green-bg">
						<hr class="mt-0 mb-0" />
					</div>
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
											key="ward" /></span> <c:if test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpWard")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="zip-code" /></span> <c:if test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpZipCode")%></c:if></li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2 ">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <liferay-ui:message
											key="shop-length" /></span> <c:if
										test="<%=dealerDetailData != null%>">
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
											key="shop-storage-capacity" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpCapacity")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="whether-the-floor-is-cemented" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpCmntd")%></c:if></li>

							</ul>
						</div>
					</div>
					<div class="row justify-content-between px-2 ">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="does-the-shop-has-signboard" /></span> <c:if
										test="<%=dealerDetailData != null%>">
										<%=dealerDetailData.get("shpSignBrd")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"><liferay-ui:message
											key="what-licenses-doese-dealer-possess" /></span></li>
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
													key="trade-agriculture-license" /></label>
										</c:when>
										<c:otherwise>
											<i class="icon-check-empty fs-6 me-2"></i>
											<label class="form-check-label"><liferay-ui:message
													key="trade-agriculture-license" /></label>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
					</div>
					<div class="row justify-content-between px-2  pt-3">

						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <liferay-ui:message
											key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-name-of-member" /></span>
									<c:if
										test="<%=dealerDetailData != null && dealerDetailData.get("fmlyDlrLic") != null%>">
										<%=dealerDetailData.get("fmlyDlrLic")%></c:if></li>

							</ul>
						</div>
						<div class="col-md-5 col-sm-12">
							<ul class="alignMe">
								<li><span class="custom-colon"> <liferay-ui:message
											key="if-the-family-rembers-of-the-dealer-is-are-holding-any-dealership-then-the-type-of-the-dealership" /></span>
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


					<h5 class="green-text fw-bold mb-0 mt-2">
						<liferay-ui:message key="uploaded-documents" />
					</h5>
					<div class="green-bg">
						<hr class="  mt-0 mb-2" />
					</div>

					<div class="row justify-content-between px-2">
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<span> <liferay-ui:message key="bank-solvency-certificate" />
								<sup class="text-danger">*</sup></span> <span class="px-md-5 px-sm-1">
								<c:if test="<%=dealerDetailData != null%>">

									<a class="text-decoration-none font-italic"
										href="<%=dealerDetailData.get("bnkSolvCertAttch")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
										</mark></a>

								</c:if>
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
						</div>
					</div>
					<div class="row justify-content-between px-2">
						<div
							class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
							<liferay-ui:message key=" signature-thumb-impression" />
							<span class="px-md-5 px-sm-1"> <c:if
									test="<%=dealerDetailData != null%>">

									<a class="text-decoration-none font-italic"
										href="<%=dealerDetailData.get("signThumbAttch")%>"
										target="_blank"><mark class="mark ">
											<liferay-ui:message key="view" />
											<i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
										</mark></a>

								</c:if>
						</div>

					</div>
					<hr />

					<div class="row justify-content-between px-2 ">
						<div class="mt-3 col-md-12">
								<%
										List<WorkflowTransition> list = (List<WorkflowTransition>) renderRequest.getAttribute("tasks");
										for (WorkflowTransition transition : list) {
											String transitionLabel = transition.getLabel(Locale.ENGLISH).trim();
											boolean isReject = transitionLabel.toUpperCase().contains("REJECT");
											String transitionName = transition.getName();
											System.out.println("transitionName====="+transitionName);
								%>
		
		
								<a
									class="btn <%=isReject ? "btn-danger" : "btn-success"%> border-0"
									href="javascript:;"
									onclick="showCommentsModal('<%=transitionName%>', '<%=transitionLabel%>')">
									<liferay-ui:message key="<%=transitionLabel.toLowerCase()%>" />
									<i class="fa-solid fa-circle-arrow-right"></i>
								</a>
		
								<%
									}
								%>
							
							<button class="btn btn-secondary me-2">
								<i class="icon-arrow-left"></i>
								<liferay-ui:message key="back" />
							</button>
						</div>
					</div>
					<!-- Start Confirm Popup -->
				<div id="render-approved-comments-popup" class="modal-body"></div>
				<div id="approved-comments-popup" style="display: none !important"
					class="container height-100 d-flex justify-content-center align-items-center">
					<div class="position-relative">
						<div class="p-2 text-center">
							<div class="mt-4">
								<aui:form action="${approvedDealerLicenseURL}" name="approvedDealerLicense" method="POST">
									<aui:input name="companyId" type="hidden" value="${companyId}"></aui:input>
									<aui:input name="workflowInstanceId" type="hidden"
										value="${workflowInstanceId}"></aui:input>
									<aui:input name="workflowTaskId" type="hidden"
										value="${workflowTaskId}"></aui:input>
									<aui:input name="transitionName" type="hidden"></aui:input>
									<aui:input name="transitionLabel" type="hidden"></aui:input>
									<aui:input name="comments" class="form-control" type="textarea"
										placeholder="type-here" aria-label="default input example"
										label="">
										<aui:validator name="required" />
									</aui:input>
									<button type="submit" class="btn px-4 validate green-bg ">
										<liferay-ui:message key="submit" />
									</button>
								</aui:form>
							</div>
						</div>
					</div>
				</div>
				<!--     End Confirm Popup -->


			</div>
		</div>
	</div>
</body>
</html>
