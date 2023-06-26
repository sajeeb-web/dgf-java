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
    <div class="container pt-2">
        <hr class="mt-3 mb-1" />
        <span class="fs-5 fw-bold p-0 m-0">
 <liferay-ui:message key="your-license-application-status" />
        </span>
        <hr class="mt-1 mb-4" />
        <div class="container">
         
          <div
            class="card w-75 m-auto mt-5 py-4 px-4 text-center d-flex justify-content-center align-items-center"
          >
            <div class="pro-circle">
              <i class="bi icon-check fs-1"></i>
            </div>
            <h5 class="green-text my-3">
            <liferay-ui:message key="your-proof-of-payment-has-been-submitted-successfully" />
            </h5>
              <a href="/homepage" class="btn green-bg mt-3">
                <!-- Track Your Application Status --><liferay-ui:message key="home" /> <i class="icon-circle-arrow-right"></i>

              </a>
         
          </div>
        </div>
      </div>
    
 </body>
 </html>