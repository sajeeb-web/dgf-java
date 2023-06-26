<%@ include file="init.jsp" %>
<portlet:defineObjects />
 <!DOCTYPE html>
 <html lang="en">
 <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

 </head>
 <body>
    <div class="main-div pt-2">
        <hr class="mt-3 mb-1" />
        <span class="fs-5 fw-bold p-0 m-0">
 <liferay-ui:message key="food-grain-license-registration" />
        </span>
        <hr class="mt-1 mb-4" />
        <div class="container">
                 <div
            class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-4"
          >
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="15"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
              <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="15"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="20"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-hr"
              role="progressbar"
              aria-valuenow="30"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
            <div
              class="prog-circle green-bg"
              role="progressbar"
              aria-valuenow="20"
              aria-valuemin="0"
              aria-valuemax="100"
            ></div>
          </div>
          <div
            class="card w-75 m-auto mt-5 py-4 px-4 text-center d-flex justify-content-center align-items-center"
          >
            <div class="pro-circle">
              <i class="icon-check fs-1"></i>
            </div>
            <h5 class="green-text my-3">
            <liferay-ui:message key="new-food-grain-license-request-successfully-submitted" />              
            </h5>
            <h6 class="fw-normal">
            <liferay-ui:message key="your-application-no" />
               <span class="fw-bold"><%=renderRequest.getAttribute("applicationNo") %></span>
            </h6>
            <h6 class="fw-normal">
            <liferay-ui:message key="an-sms-has-also-been-sent-including-the-application-number-to-your-phone" />
               
            </h6>
            
              <a href="/status-check-screen" class="btn green-bg mt-3">
                <!-- Track Your Application Status --><liferay-ui:message key="track-your-application-status" /> <i class="icon-circle-arrow-right"></i>

              </a>
              <br>
                  <a href="/homepage" class="btn btn-reset icon-circle-arrow-left me-1">
                <liferay-ui:message key="home" />

              </a>
         
          </div>
        </div>
      </div>
    
 </body>
 </html>