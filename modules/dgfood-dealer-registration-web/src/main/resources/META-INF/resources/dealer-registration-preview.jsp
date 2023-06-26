<%@ include file="init.jsp"%>
<%@page
	import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls"%>
<%@page
	import="bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls"%>
<%@page import="bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls"%>
<%@page import="bd.gov.dgfood.food.grain.license.model.DgfAttachments"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
 <%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
 <%@page import="javax.portlet.PortletURL"%>
 <%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="java.text.SimpleDateFormat" %>

<%
	DgfDlrRegDtls dgfDlrRegDtlsObj = (DgfDlrRegDtls) request.getAttribute("dgfDlrRegDtlsObj");
	DgfDlrUpdtTempDtls dgfDlrUpdtTempDtlsObj = (DgfDlrUpdtTempDtls) request
			.getAttribute("dgfDlrUpdtTempDtlsObj");
	DgfDlrRegAddlDtls dgfDlrRegAddlDtlsObj = (DgfDlrRegAddlDtls) request.getAttribute("dgfDlrRegAddlDtlsObj");
	DgfAttachments bankSolvencyCertAttachment = (DgfAttachments) request
			.getAttribute("bankSolvencyCertAttachment");
	DgfAttachments incomeTaxAttachment = (DgfAttachments) request.getAttribute("incomeTaxAttachment");
	DgfAttachments shopOwnershipDocAttachment = (DgfAttachments) request
			.getAttribute("shopOwnershipDocAttachment");
	DgfAttachments signatureAttachment = (DgfAttachments) request.getAttribute("signatureAttachment");
	DgfAttachments shopRentedDocAttachment = (DgfAttachments) request.getAttribute("shopRentedDocAttachment");
	DgfAttachments psyclyChallengeAttachment = (DgfAttachments) request
			.getAttribute("psyclyChallengeAttachment");
	DgfAttachments userPhotoAttachment = (DgfAttachments) request.getAttribute("userPhotoAttachment");
	SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
%>

<!DOCTYPE html>
<portlet:actionURL name="actionForm" var="dlrPreviewFormActionURL">
	<portlet:param name="mvcPath" value="/form-submission.jsp" />
	<portlet:param name="pageId" value="4" />
</portlet:actionURL>
<portlet:actionURL name="back" var="backUrl" >
	<portlet:param name="mvcPath" value="/dealer-registration-attachments.jsp" />
	<portlet:param name="pageId" value="4" />
	<portlet:param name="isBack" value="true" />
	<portlet:param name="nationalId" value="<%=renderRequest.getAttribute("nationalId").toString()%>" />
</portlet:actionURL>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SDM FDD</title>
<!-- Bootstrap CSS CDN  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

</head>
<body>
	<div class="px-md-5 px-sm-3 px-1 text-capitalize">
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
		<div
			class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-2">
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr" role="progressbar" aria-valuenow="30"
				aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle  green-bg" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<div class="container-fluid">

			<div class="card">
				<%-- <div
					class="card-header d-flex justify-content-between align-items-center">
					<liferay-ui:message key="form-preview" />
					<i role="button" class="icon-minus"></i>
				</div> --%>
				<div class="card_body py-4 px-3">
					<aui:form action="<%=dlrPreviewFormActionURL%>" name="dlrPreviewForm" method="POST">
						<aui:input type="hidden" name="nationalId"
								value="<%=renderRequest.getAttribute("nationalId")%>" />
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
														key="license-no" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getFglLicnsNo() : "-"%>

											</li>

										</ul>
									</div>
									<div class="col-md-5 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"><liferay-ui:message
														key="license-date-of-issue" /></span> <%=(dgfDlrRegDtlsObj != null) ? newFormat.format(dgfDlrRegDtlsObj.getFglLicnsIssueDate()) : "-"%>

											</li>
										</ul>
									</div>
								</div>
								<div class="row justify-content-between px-2 ">
									<div class="col-md-5 col-sm-12">
										<ul class="alignMe">
											<li><span class="custom-colon"><liferay-ui:message
														key="dealership-type" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getDlrTypeId() : "-"%>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div
								class="col-md-3 col-sm-12 d-flex justify-content-center align-items-start">
								<c:choose>
									<c:when
										test="${userPhotoAttachment != null && userPhotoAttachment.filePath != null && !userPhotoAttachment.filePath.isEmpty()}">
										<div class="user_avatar">
											<img class="img-fluid" src="${userPhotoAttachment.filePath}" alt="User Avatar">
										</div>
									</c:when>
									<c:otherwise>
										<div class="user_avatar">
											<i class="fa-regular fa-user"></i>
										</div>
									</c:otherwise>
								</c:choose>
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
												key="marital-status" /></span> <liferay-ui:message
											key="<%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getMaritalStatus() : "-"%>" />

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="spouse-name" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getSpouseName() : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-father-name" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getSpouseFthrName() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-date-of-birth" /></span> <%=(dgfDlrRegDtlsObj != null && dgfDlrRegDtlsObj.getSpouseBrthDate()!= null) ? newFormat.format(dgfDlrRegDtlsObj.getSpouseBrthDate()) : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="spouse-nid-number" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getSpouseNid() : "-"%>

									</li>

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
												key="work-in-the-government" /></span> <liferay-ui:message
											key="<%=(dgfDlrUpdtTempDtlsObj != null)
					? ((dgfDlrUpdtTempDtlsObj.getWrkInGovt() == 1) ? "yes" : "n-o-1")
					: "n-o-1"%>" />

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="public-representative" /></span> <liferay-ui:message
											key="<%=(dgfDlrUpdtTempDtlsObj != null)
					? ((dgfDlrUpdtTempDtlsObj.getPblcRep() == 1) ? "yes" : "n-o-1")
					: "n-o-1"%>" />


									</li>

								</ul>
							</div>
						</div>

						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="physically-challenged" /></span> <liferay-ui:message
											key="<%=(dgfDlrUpdtTempDtlsObj != null)
					? ((dgfDlrUpdtTempDtlsObj.getPhysclyChlngd() == 1) ? "yes" : "n-o-1")
					: "n-o-1"%>" />

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-yes-proof-of-physically-challenged" /></span> <span
										class="px-md-5 px-sm-1"> <c:if
												test="<%=psyclyChallengeAttachment != null && psyclyChallengeAttachment.getFilePath() != null
						&& !psyclyChallengeAttachment.getFilePath().isEmpty()%>">
												<a class="text-decoration-none font-italic"
													href="<%=psyclyChallengeAttachment.getFilePath()%>"
													target="_blank"> <mark class="mark ">
														View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
													</mark>
												</a>
											</c:if>
									</span></li>

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
												key="region-division" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpDivision() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="district-zilla" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpDistrict() : "-"%>

									</li>

								</ul>
							</div>
						</div>

						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="upazila" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpUpzilla() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="union" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpUnion() : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="ward" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpWard() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="zip-code" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpZipCode() : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="shop-length" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpLength() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="shop-width" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpWidth() : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="shop-storage-capacity" /></span> <%=(dgfDlrUpdtTempDtlsObj != null) ? dgfDlrUpdtTempDtlsObj.getShpStrgCpcty() : "-"%>

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="whether-the-floor-is-cemented" /></span> <liferay-ui:message
											key="<%=(dgfDlrRegAddlDtlsObj != null)
					? ((dgfDlrRegAddlDtlsObj.getShpFlrCmntd() == 1) ? "yes" : "n-o-1")
					: "n-o-1"%>" />

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="does-the-shop-have-a-signboard" />?
									</span> <liferay-ui:message
											key="${(dgfDlrRegAddlDtlsObj != null) ? ((dgfDlrRegAddlDtlsObj.shpSignBrd == 1) ? 'yes' : 'n-o-1') : 'n-o-1'}" />

									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="what-licenses-does-the-dealer-possess" /></span> 
												
												<%=
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getFoodgrainLicense() == 1 ? "Foodgrain License , " : "") +
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getTradeLicense() == 1 ? "Trade License , " : "") +
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getTcvDlrLicense() == 1 ? "Tcv Dlr License , " : "") +
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getImportLicense() == 1 ? "Import License  ," : "") +
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getLicenseEssentialGoods() == 1 ? "License Essential Goods ," : "") +
(dgfDlrUpdtTempDtlsObj != null && dgfDlrUpdtTempDtlsObj.getTradeLicenseAgriculture() == 1 ? "Trade License Agriculture" : "")
%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-name-of-the-member" /></span>

										<liferay-ui:message
											key="${(dgfDlrRegAddlDtlsObj != null) ? ((dgfDlrRegAddlDtlsObj.dlrFmlyDlrShpFlg == 1) ? 'yes' : 'n-o-1') : 'n-o-1'}" />
									</li>

								</ul>
							</div>
							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"> <liferay-ui:message
												key="if-the-family-members-of-the-dealer-is-are-holding-any-dealership-then-the-type-of-dealership" /></span>

										<%=(dgfDlrRegAddlDtlsObj != null) ? dgfDlrRegAddlDtlsObj.getDlrshpFmlyMmbrType() : "-"%>

									</li>

								</ul>
							</div>
						</div>
						<div class="row justify-content-between px-2 ">

							<div class="col-md-5 col-sm-12">
								<ul class="alignMe">
									<li><span class="custom-colon"><liferay-ui:message
												key="dealer-category" /></span> <%=(dgfDlrRegDtlsObj != null) ? dgfDlrRegDtlsObj.getDlrTypeId() : "-"%>

									</li>

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
								<span> <liferay-ui:message
										key="bank-solvency-certificate" /> <sup class="text-danger">*</sup></span>

								<span class="px-md-5 px-sm-1"> <c:if
										test="${bankSolvencyCertAttachment != null && bankSolvencyCertAttachment.filePath != null && !bankSolvencyCertAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${bankSolvencyCertAttachment.filePath}" target="_blank">
											<mark class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span><liferay-ui:message
										key="income-tax-return-certificate" /> <sup
									class="text-danger">*</sup> </span> <span class="px-md-5 px-sm-1">
									<c:if
										test="${incomeTaxAttachment != null && incomeTaxAttachment.filePath != null && !incomeTaxAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${incomeTaxAttachment.filePath}" target="_blank"> <mark
												class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
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
										test="${shopOwnershipDocAttachment != null && shopOwnershipDocAttachment.filePath != null && !shopOwnershipDocAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${shopOwnershipDocAttachment.filePath}" target="_blank">
											<mark class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span><liferay-ui:message key="rental-agreement" /> <sup
									class="text-danger"></sup> </span> <span class="px-md-5 px-sm-1">
									<c:if
										test="${shopRentedDocAttachment != null && shopRentedDocAttachment.filePath != null && !shopRentedDocAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${shopRentedDocAttachment.filePath}" target="_blank">
											<mark class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
									</c:if>
								</span>
							</div>
						</div>
						<div class="row justify-content-between px-2">
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<liferay-ui:message key="signature-thumb-impression" />
								<span class="px-md-5 px-sm-1"> <c:if
										test="${signatureAttachment != null && signatureAttachment.filePath != null && !signatureAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${signatureAttachment.filePath}" target="_blank"> <mark
												class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
									</c:if>
								</span>
							</div>
							<div
								class="col-md-5 col-sm-12 d-flex justify-content-between align-items-center">
								<span><liferay-ui:message key="physically-challenged" /> <sup
									class="text-danger"></sup> </span> <span class="px-md-5 px-sm-1">
									<c:if
										test="${psyclyChallengeAttachment != null && psyclyChallengeAttachment.filePath != null && !psyclyChallengeAttachment.filePath.isEmpty()}">
										<a class="text-decoration-none font-italic"
											href="${psyclyChallengeAttachment.filePath}" target="_blank">
											<mark class="mark">
												View <i class="far fa-file-alt ms-1 ps-1 h6 text-primary"></i>
											</mark>
										</a>
									</c:if>
								</span>
							</div>
						</div>
						<hr />
						<div>
							<input type="checkbox"
								aria-label="Checkbox for following text input" required /> <liferay-ui:message key="i-hereby-declare-that-all-the-information-i-have-enclosed-in-this-application-is-true-and-correct-if-the-license-is-granted-in-my-favor-i-will-be-bound-to-abide-by-all-the-terms-and-conditions-of-the-license"/>
						</div>
						<div class="row justify-content-between px-2 ">
							<div class="mt-3 col-md-12">
								<%-- <button class="btn btn-secondary me-2">
									<i class="icon-arrow-left"></i>
									<liferay-ui:message key="back" />
								</button> --%>
								<a class="btn btn-reset me-2" href="<%=backUrl%>">
									<i class="icon-circle-arrow-left"></i>
									<!-- Back-->
									<liferay-ui:message key="back" />
								</a>
								<button class="btn btn-success green-bg">
									<liferay-ui:message key="submit" />
									<i class="icon-circle-arrow-right"></i>
								</button>
							</div>
						</div>

					</aui:form>


				</div>
			</div>
		</div>
	</div>



	<!-- <script>
      const minus_button = document.querySelector(".icon-minus");
      minus_button.addEventListener("click", () => {
        const card_body = document.querySelector(".card_body");

        if (card_body.style.display === "none") {
          card_body.style.display = "block";
        } else {
          card_body.style.display = "none";
        }
      });
    </script> -->
</body>
</html>
