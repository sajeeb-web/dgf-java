<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

</head>
<body>

	<div class="main-body px-5 py-2">
			<hr class="mt-3 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0"><%=user.getFirstName() %> Dashboard 
				
				</span> <span
                    class=" fw-bold p-0 m-0"> Last Login: <span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
			<div class="container">
				<div class="row align-items-stretch  mt-2 p-2">
					<div class="c-dashboardInfo col-md-3 col-sm-6">
						<div class="wrap">
							<h4
								class="heading heading5 hind-font medium-font-weight c-dashboardInfo__title">Total
							Food Grain Licenses Pending Applications</h4>
							<span class="text text-end">300 </span>
						</div>
					</div>
					<div class="c-dashboardInfo col-md-3 col-sm-6">
						<div class="wrap">
							<h4
								class="heading heading5 hind-font medium-font-weight c-dashboardInfo__title">
								Food Grain License Verified</h4>
							<span class="text text-end">8,500 </span>
						</div>
					</div>
					<div class="c-dashboardInfo col-md-3 col-sm-6">
						<div class="wrap">
							<h4
								class="heading heading5 hind-font medium-font-weight c-dashboardInfo__title">Total
								Milling License Pending Applications</h4>
							<span class="text text-end">500 </span>
						</div>
					</div>
					<div class="c-dashboardInfo col-md-3 col-sm-6">
						<div class="wrap">
							<h4
								class="heading heading5 hind-font medium-font-weight c-dashboardInfo__title">Unresolved
							Milling Licenses Verified</h4>
							<span class="text text-end">500 </span>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>