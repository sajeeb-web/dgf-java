<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.alignMe{
	padding-left:0 !important;
}
</style>
</head>
  <body>
  <div class="container pt-3">
  <hr class="mt-0 mb-1" />
			<div class="d-flex justify-content-between">
				<span class=" fw-bold p-0 m-0">  <%=user.getFirstName() %> <liferay-ui:message key="dashboard"/> <!-- Dcf Dashboard -->
			
				</span> <span
                    class=" fw-bold p-0 m-0"> <liferay-ui:message key="last-login"/><span><fmt:formatDate pattern = "dd MMM yyyy" value = "<%=user.getLastLoginDate() %>"/> | </span>
                    <span><fmt:formatDate type="time" timeStyle = "short" value = "<%=user.getLastLoginDate() %>"/></span>
                </span>
			</div>
			<hr class="mt-1 mb-3" />
    <div class="row p-2">
        <div class="col-md-9 col-sm-12">
          <h5 class="green-text fw-bold mb-1"><liferay-ui:message key="basic-info"/></h5>
          <div class="green-bg">
            <hr class="mt-0 mb-0" />
          </div>
      
          <div class="row p-2">
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="name-of-officer"/></span>---------------</li>
                
              </ul>
            </div>
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="email-address"/></span>---------------</li>
                
              </ul>
            </div>
          </div>
          <div class="row p-1">
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="mobile-number"/></span>---------------</li>
                
              </ul>
            </div>
            <div class="col-md-6 col-sm-12">
                <ul class="alignMe">
                  <li><span class="custom-colon"><liferay-ui:message key="date-of-birth"/></span>---------------</li>
                  
                </ul> 
              </div>
    
          </div>
          <div class="row p-2">
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="office-address"/></span>---------------</li>
                
              </ul>
            </div>
            <div class="col-md-6 col-sm-12">
                <ul class="alignMe">
                  <li><span class="custom-colon"><liferay-ui:message key="house-address"/></span>---------------</li>
                  
                </ul>
              </div>
    
          </div>
          <div class="row p-2">
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="nid-no"/></span>---------------</li>
                
              </ul>
            </div>
            <div class="col-md-6 col-sm-12">
                <ul class="alignMe">
                  <li><span class="custom-colon"><liferay-ui:message key="gender"/></span>---------------</li>
                  
                </ul>
              </div>
    
          </div>
          <div class="row p-2">
            <div class="col-md-6 col-sm-12">
              <ul class="alignMe">
                <li><span class="custom-colon"><liferay-ui:message key="designation"/></span>---------------</li>
                
              </ul>
            </div>
          </div>
        </div>
        <div class="col-md-3">
            <div
              class="profile-bg rounded-circle d-flex justify-content-center align-items-center"
            >
              <i class="icon-user text-light"></i>
            </div>
          </div>
        </div>
        <div class="card shadow-sm p-3">
          <p class="p-0 m-0 fw-bold text-danger">
            <small
              ><liferay-ui:message key="note"/> : <liferay-ui:message key="for-any-update-in-profile-information-please-contact-with-personnel-information-management-system"/></small
            >
          </p>
        </div>
      </div>
  </body>
</html>
