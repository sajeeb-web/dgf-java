 <%@ include file="/init.jsp"%>

<div class="navigation custom-margin" style="">
	<nav class="navbar navbar-dark container b">
		<div class="container-fluid ps-0">
			<div class="logo">
				<a class="p-0 m-0 navbar-brand d-flex align-items-center" href="/homepage">
					<img class="logo-image" style="height: 45px;"
					src="<%=themeDisplay.getPathThemeImages()%>/logo.png" alt="" /> <span

					class="logo-text fw-bold text-light" style="margin-left: 15px">
						<liferay-ui:message key="food-stock-and-market-monitoring-system" />
				</span>


				</a>
			</div>


			<c:choose>
				<c:when test="<%=themeDisplay.isSignedIn()%>">
					<div class="nav-right d-flex align-items-center">
						<div class="search-login px-3 nav-icons">
							<a href="/c/portal/logout">
								<button style="" class="btn btn-sm text-light log-button">
									<i class="bi bi-person-fill"></i>
									<liferay-ui:message key="logout" />
									<!-- <liferay-ui:message key="logout"/> -->
								</button>
							</a>
						</div>
					</div>


				</c:when>

				<c:otherwise>

					<div class="nav-right d-flex align-items-center">
						<div class="search-login px-3 nav-icons">
							<a href="/login-page?userType=GovernmentUser">
								<button style="" class="btn btn-sm log-button text-light">
									<i class="bi bi-person-fill"></i>
									<!-- login -->
									<liferay-ui:message key="login" />
								</button>
							</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
	</nav>
</div>