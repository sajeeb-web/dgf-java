<%@ include file="init.jsp"%>
<%@ page import="java.util.Map"%>

<%
	Map<String, Object> dealerWithdrawalData = (Map<String, Object>) request.getAttribute("dealerWithdrawalData");
	String languageId = (String) request.getAttribute("languageId");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dealer Withdrawal Application Preview</title>
<!-- Bootstrap CSS CDN  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

</head>
  <body>
   
    <div class="px-md-5 px-sm-3 px-2 pt-2 text-capitalize">
       
        <hr class="mt-3 mb-1" />
        	<div class="container-fluid">

			<div class="d-flex justify-content-between">

				<span class=" fw-bold p-0 m-0"> <!-- Dealer details --> <liferay-ui:message
						key="dealer-details" />
				</span> <span class=" fw-bold p-0 m-0"> <liferay-ui:message
						key="last-login" /><span><fmt:formatDate
							pattern="dd MMM yyyy" value="<%=user.getLastLoginDate()%>" /> |
				</span> <span><fmt:formatDate type="time" timeStyle="short"
							value="<%=user.getLastLoginDate()%>" /></span>
				</span>
			</div>

		</div>
        <hr class="mt-1 mb-3" />
       
        
      <div class=" my-3">
		 <c:choose>
				<c:when
					test="<%=Integer.parseInt(dealerWithdrawalData.get("status").toString()) == 0%>">
					<div class="card reviewed-card py-2 px-4 mb-4">
						<h6 class="text-success fw-bold fs-5">
							<liferay-ui:message key="reviewed" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerWithdrawalData.get("status").toString()) == 4%>">
					<div class="card rejected-card py-2 px-4 mb-4">
						<h6 class="text-danger fw-bold fs-5">
							<liferay-ui:message key="rejected" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerWithdrawalData.get("status").toString()) == 1%>">
					<div class="card pending-card py-2 px-4 mb-4">
						<h6 class="text-warning fw-bold fs-5">
							<liferay-ui:message key="pending" />
						</h6>
					</div>
				</c:when>
				<c:when
					test="<%=Integer.parseInt(dealerWithdrawalData.get("status").toString()) == 6%>">
					<div class="card pending-card py-2 px-4 mb-4">
						<h6 class="text-warning fw-bold fs-5">
							<liferay-ui:message key="payment-pending" />
						</h6>
					</div>
				</c:when>
			</c:choose> 

		</div>
      
      
          <div class="card p-3">
          
          
              <form action="
              ">
    
              <h5 class="green-text fw-bold mb-0 py-3">dealer-withdrawal-details</h5>
              <div class="green-bg">
                <hr class="mt-0 mb-0" />
              </div>
              
              <div class="row justify-content-between px-2 mt-3 ">

                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon">dealer-name</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("dealerName")%></c:if>
                    
                   </li>
                    
                  </ul>
                </div>
                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon"> dealer-license-no</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("licenseNo")%></c:if>
                    
                    </li>
                    
                  </ul>
                </div>
              </div>
              
              
              <div class="row justify-content-between px-2 mt-3 ">

                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon">dealer-business-code</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("dealerBussinessCode")%></c:if>
                    
                   </li>
                    
                  </ul>
                </div>
                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon"> dealer-type</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("program")%></c:if>
                    
                    </li>
                    
                  </ul>
                </div>
              </div>
              <div class="row justify-content-between px-2 ">

                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon">dealer-approval-date</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("createdDate")%></c:if>
                    
                    </li>
                    
                  </ul>
                </div>
                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon">dealer-union</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("unionName")%></c:if>
                    
                    </li>
                    
                  </ul>
                </div>
              </div>
              <div class="row justify-content-between px-2 ">

                <div class="col-md-5 col-sm-12">
                  <ul class="alignMe">
                    <li><span class="custom-colon">dealer-withdrawal-application-date</span>
                    
                    <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("createdDate")%></c:if>
                    
					</li>
                    
                  </ul>
                </div>
                <div class="col-md-5 col-sm-12">
                    <ul class="alignMe">
                      <li><span class="custom-colon">withdrawal-reason</span>
                      
                      <c:if
						test="<%=dealerWithdrawalData != null%>">
						<%=dealerWithdrawalData.get("withdrawReason")%></c:if>
                      
                      </li>
                      
                    </ul>
                  </div>
              </div>
             
              <div class="row justify-content-between px-2 ">
						<div class="mt-3 col-md-12">

							<button class="btn btn-success green-bg">
								<liferay-ui:message key="approved" />
							</button>
							<button class="btn btn-danger ">
								<liferay-ui:message key="rejected" />
							</button>

							<button class="btn btn-secondary me-2" onclick="javascript:window.history.go(-1);" title="Go Back">
								<i class="icon-arrow-left"></i>
								<liferay-ui:message key="back" />
							</button>
						</div>
					</div>
              
            </form>
            </div>
          </div>
  </body>
</html>
