<%@ include file="init.jsp" %>

  <!DOCTYPE html>
  <portlet:defineObjects />
  <portlet:renderURL var="renderURL">
</portlet:renderURL>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
 
  </style>
</head>
<body>
  <div class="main-div">
    <hr class="mt-3 mb-1" />
    <span class="fs-5 fw-bold p-0 m-0">
     <liferay-ui:message key="apply-for-a-new-food-grain-license" />
    </span>
    <hr class="mt-1 mb-3" />
    <div class="container justify-content-center align-items-center">
      <div class="row">
        <div class="col-md-6 py-2 px-5 m-auto">
            <span class="fs-6 fw-bold green-text">
              <liferay-ui:message key="food-grain-license-application-guidelines" />
            </span>
            <div class="text-success mb-2">
              <hr class="mt-0" />
            </div>
            <div class="card py-2 px-3">
              <p>
               	<%=renderRequest.getAttribute("guideLineText")%>
              </p>
              <p>
               	<%=renderRequest.getAttribute("guideLineTextDescription")%>
              </p>

                       <div>
                            <a href="food-grain-license-registration-forms"class="btn green-bg">
                              <liferay-ui:message key="apply-now" /> <i class="fa-solid fa-circle-arrow-right"></i>
                            </a>

                          
                            <span class="ps-2 me-4 float-right"><liferay-ui:message key="already-registered"/>? <a  class="green-text"href="/login-page?userType=NormalUser"><liferay-ui:message key="login-here" /></a></span>
                    
                       </div>
            </div>
          </div>
        </div>

      </div>
  </div>
</body>
</html>



  