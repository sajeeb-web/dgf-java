

<%@ include file="/init.jsp"%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DG Food</title>

</head>
<body>


	<div class="main-div">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"><liferay-ui:message
				key="food-grain-license" /></span>
		<hr class="mt-1 mb-3" />
		<h5 class="text-center">
			<liferay-ui:message key="please-select-a-option"/>
		</h5>
		<div class="container container-width pt-3">
			<div class="row justify-content-center g-3">
				<div class="col-md-4 col-sm-4 col-lg-4">
					<div
						class="card-custom card d-flex text-center justify-content-center align-items-center py-5">

						<h5 class="p-3 mb-5 fw-bold">
							<liferay-ui:message key="apply-for-a-new-food-grain-license" />
						</h5>
						<a href="/food-grain-license-guideline-screen"
							class="btn green-bg mt-5 navigation border-0"> <liferay-ui:message
								key="click-here" /> <i class="fa-regular fa-circle-right"></i>
						</a>
					</div>
				</div>

				<div class="col-md-4 col-sm-4 col-lg-4">
					<div
						class="card-custom card d-flex text-center justify-content-center align-items-center py-5">
						<h5 class="p-3 mb-5 fw-bold">
							<liferay-ui:message
								key="check-your-food-grain-license-application-status" />
						</h5>
						<a href="/status-check-screen"
							class="btn green-bg mt-5 navigation border-0"> <liferay-ui:message
								key="click-here" /> <i class="fa-regular fa-circle-right"></i>
						</a>
					</div>
				</div>
				<div class="col-md-4 col-sm-4 col-lg-4">
					<div
						class="card-custom card d-flex text-center justify-content-center align-items-center py-5">

						<!--    Last Edition-2.3.22 -->
						<h5 class="p-3 mb-5 fw-bold">
							<liferay-ui:message key="login-to-access-your-account" />
						</h5>
						<a href="/login-page?userType=NormalUser"
							class="btn green-bg mt-5 navigation border-0"> <liferay-ui:message
								key="click-here" /> <i class="fa-regular fa-circle-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

