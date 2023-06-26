  <%@ include file="/init.jsp"%>
 <%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="navigation pt-1">
	<nav class="navbar navbar-dark container">
		<div class="container-fluid ps-0">
			<div class="logo">
				<a class="p-0 m-0 navbar-brand d-flex align-items-center" href="/homepage">
				
					<img class=logo-image
					src="<%=themeDisplay.getPathThemeImages()%>/logo.png" alt="" /> 

			
						<span class="name">
						<liferay-ui:message key="food-stock-and-market-monitoring-system"/>
						</span>

				</a>
			</div>

			<div class="right nav-right d-flex align-items-center">
				<div class="d-flex">
				

						<div
							class=" d-flex justify-content-center align-items-center position-relative 					text-light">
							
						<%-- 	<i class="bi bi-bell fs-5"> <span
								class="position-absolute start-100 translate-middle badge rounded-circle text-dark bg-light">
									<%=UserNotificationEventLocalServiceUtil
					.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false, false)%>
									<!-- <span class="visually-hidden">unread messages</span> -->
							</span>
							</i> --%>
											<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<span class="user-avatar-link">
			<liferay-product-navigation:personal-menu
				size="md"
				user="<%= user %>"
			/>

			<%
			int notificationsCount =UserNotificationEventLocalServiceUtil
					.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false, false);
			%>

			<c:if test="<%= notificationsCount > 0 %>">

				<%
				String notificaitonsPortletId = PortletProviderUtil.getPortletId(UserNotificationEvent.class.getName(), PortletProvider.Action.VIEW);
				String notificationsURL = PersonalApplicationURLUtil.getPersonalApplicationURL(request, notificaitonsPortletId);
				%>

				<aui:a href="<%= (notificationsURL != null) ? notificationsURL : null %>">
					<clay:badge
						cssClass="panel-notifications-count"
						displayType="primary"size="sm"
						label="<%= String.valueOf(notificationsCount) %>"
					/>
				</aui:a>
			</c:if>
		</span>
	</c:when>
	<c:when test="<%= themeDisplay.isShowSignInIcon() %>">
		<span class="sign-in text-default" role="presentation">
			<aui:icon
				cssClass="sign-in text-default"
				data='<%=
					HashMapBuilder.<String, Object>put(
						"redirect", String.valueOf(PortalUtil.isLoginRedirectRequired(request))
					).build()
				%>'
				image="user"
				label="sign-in"
				markupView="lexicon"
				url="<%= themeDisplay.getURLSignIn() %>"
			/>
		</span>

		<aui:script sandbox="<%= true %>">
			var signInLink = document.querySelector('.sign-in > a');

			if (signInLink && signInLink.dataset.redirect === 'false') {
				var signInURL = '<%= themeDisplay.getURLSignIn() %>';

				var modalSignInURL = Liferay.Util.addParams(
					'windowState=exclusive',
					signInURL
				);

				var setModalContent = function (html) {
					var modalBody = document.querySelector('.liferay-modal-body');

					if (modalBody) {
						var fragment = document
							.createRange()
							.createContextualFragment(html);

						modalBody.innerHTML = '';

						modalBody.appendChild(fragment);
					}
				};

				var loading = false;
				var redirect = false;
				var html = '';
				var modalOpen = false;

				var fetchModalSignIn = function () {
					if (loading || html) {
						return;
					}

					loading = true;

					Liferay.Util.fetch(modalSignInURL)
						.then((response) => {
							return response.text();
						})
						.then((response) => {
							if (!loading) {
								return;
							}

							loading = false;

							if (!response) {
								redirect = true;

								return;
							}

							html = response;

							if (modalOpen) {
								setModalContent(response);
							}
						})
						.catch(() => {
							redirect = true;
						});
				};

				signInLink.addEventListener('mouseover', fetchModalSignIn);
				signInLink.addEventListener('focus', fetchModalSignIn);

				signInLink.addEventListener('click', (event) => {
					event.preventDefault();

					if (redirect) {
						Liferay.Util.navigate(signInURL);

						return;
					}

					Liferay.Util.openModal({
						bodyHTML: html ? html : '<span class="loading-animation">',
						containerProps: {
							className: '',
						},
						height: '400px',
						onClose: function () {
							loading = false;
							redirect = false;
							html = '';
							modalOpen = false;
						},
						onOpen: function () {
							modalOpen = true;

							if (html && document.querySelector('.loading-animation')) {
								setModalContent(html);
							}
						},
						size: 'md',
						title: '<liferay-ui:message key="sign-in" />',
					});
				});
			}
		</aui:script>
	</c:when>
</c:choose>
		
						</div>
				
					<!--    <div class="h-icon-circle d-flex justify-content-center align-items-center text-light rounded-circle">
                  <i class="bi bi-person fs-5"></i>
                </div> -->
					<div class="dropdown">
						<button class="btn border-0 text-light text14 mt-1" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							<%=user.getFirstName()%>

						</button>
						<!--    <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">DCF</a></li>
                    <li>
                      <a class="dropdown-item" href="#">ACF</a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">Portal User</a>
                    </li>
                  </ul> -->
					</div>
				</div>

<!-- 				<button class="navbar-toggler px-1" type="button"
					data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
					aria-controls="offcanvasDarkNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>

			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">
						Mobile Menu</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link text-dark active"
							aria-current="page" href="#"> Home <liferay-ui:message
									key="home" />
						</a></li>
						<li class="nav-item"><a class="nav-link text-dark" href="#">Link</a>
						</li>


						<li class="nav-item dropdown"><a>
								Dropdown </a>
							<ul class="dropdown-menu dropdown-menu-dark">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li>
									<hr class="dropdown-divider" />
								</li>
								<li><a class="dropdown-item" href="#">Something
										else here</a></li>
							</ul></li>
					</ul>
					<form class="d-flex mt-3" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" />
						<button class="btn btn-success" type="submit">Search</button>
						<button class="btn btn-success" type="submit">
							<liferay-ui:message key="search" />
						</button>
					</form>
				</div> -->
			</div>
		</div>

	</nav>
</div>
</body>
</html>

 