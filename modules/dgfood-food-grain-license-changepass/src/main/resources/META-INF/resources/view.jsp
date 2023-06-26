<%@ include file="/init.jsp" %>
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
  <div class="container py-3 px-5 main-body">
  <hr class="mt-0 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">  <%=user.getFirstName() %> <liferay-ui:message key="dashboard"/><!-- Dcf Dashboard -->
				<!--  <liferay-ui:message key="dcf-dashboard"/> -->
				</span> <span
                    class=" fw-bold p-0 m-0"><liferay-ui:message key="last-login"/><span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
    <div class="container px-3">

      <div class="row px-2">
        <div class="card p-5 col-md-12 m-auto">
          <form action="">
          <p class="">
            <label class="t2" for="password_current"><liferay-ui:message key="enter-old-password"/></label>
            <input  type="password" class="field-settings" name="password" id="password_current" autocomplete="off"/>

            <label for="togglePw_current" class="fa fa-eye" id="togglePw_current" onclick="showPassword('password_current')"></label>
        </p>
        
        <p class="">
            <label class="t2" for="password_1"><liferay-ui:message key="enter-new-password"/></label>
            <input type="password" class="field-settings" name="password_1" id="password_1" autocomplete="off" />
            <label for="togglePw_1" class="fa fa-eye" id="togglePw_1" onclick="showPassword('password_1')"></label>

        </p>
        <p class="">
          <label class="t2" for="password_2"><liferay-ui:message key="retype-password"/></label>
          <input type="password" class="field-settings" name="password_2" id="password_2" autocomplete="off" />
          <label for="togglePw_2" class="fa fa-eye" id="togglePw_2" onclick="showPassword('password_2')"></label>
      </p>
        <div>
        <button class="btn green-bg me-2">
            <i class="fa-solid fa-circle-arrow-left"></i> <liferay-ui:message key="submit"/>
        </button>
       
    </div>
      </form>
          </div>
       
          </div>
    </div>
    </div>
 

<script>
function showPassword(targetID) {
var x = document.getElementById(targetID);

if (x.type === "password") {
x.type = "text";
} else {
x.type = "password";
}

}
</script>
</body>
</html>