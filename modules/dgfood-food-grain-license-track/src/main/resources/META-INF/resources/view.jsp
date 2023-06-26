 <%@ include file="/init.jsp" %>

  <!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  </head>
  <body>
    <div class="" style="padding:0px 60px">
    <hr class="mt-3 mb-1" />
    <span class="fs-5 fw-bold p-0 m-0">
     Apply For a New Food Grain License
    </span>
    <hr class="mt-1 mb-3" />
    <div style="min-height: calc(100vh - 180px)" class="d-flex justify-content-center align-items-center">
      <div class="row">
        
        </div>

   <div class="col-md-6 px-5 m-auto">

          <div class="card p-5 shadow-sm">
            <h5 class="pb-3 green-text">Track your Food Grain License</h5>
            <form action="">
              <div class="d-flex mb-3">
                <div class="form-check me-3">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" />
                  <label class="form-check-label" for="flexRadioDefault1">
            <!--         NID -->
            <liferay-ui:message key="nid"/>
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" />
                  <label class="form-check-label" for="flexRadioDefault1">
                 <!--    Application No. -->
                 <liferay-ui:message key="application-no"/>.
                  </label>
                </div>
              </div>
              <div class="mb-2">
                <label for="exampleFormControlInput1" class="form-label mb-1"><span class="d-block">Enter NID<sup
                      class="text-danger">*</sup></span>
                </label>
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="512457" />
              </div>
              <div>
                <label for="exampleFormControlInput1" class="form-label mb-1"><span class="d-block">Date of Birth<sup
                      class="text-danger">*</sup></span>
                </label>
                <input type="date" class="form-control" id="exampleFormControlInput1" />
              </div>
                       <div class="pt-5">
                           <button class="btn green-bg">
                           <!--   Submit --> 
                           <liferay-ui:message key="submit"/><i class="fa-solid fa-circle-arrow-right ms-2"></i>
                           </button>
                         <a href="" class="btn btn-secondary me-2">
                           <i class="fa-solid fa-circle-arrow-left"></i> <!-- Back -->
                         <liferay-ui:message key="back"/>
                         </a>
                      
                       </div>
            </form>
          </div>
        </div> 
      </div>
  </div>
  </body>
  </html>