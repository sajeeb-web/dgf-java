
<%@ include file="init.jsp"%>
<%@ include file="js/otp-popup.js"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>


<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<portlet:resourceURL var="captchaResourceURL">
	<portlet:param name="cmd" value="captchaGenerate" />
</portlet:resourceURL>
<portlet:actionURL name="addRegistrationForm"
	var="addRegistrationFormActionURL">
	<portlet:param name="mvcPath"
		value="/food-grain-license-reg-basic-info.jsp" />
	<portlet:param name="pageId" value="1" />
</portlet:actionURL>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>


<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">

</head>
<body>
	<div class="main-div">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"> <!--Food Grain License Registration-->
			<liferay-ui:message key="food-grain-license-registration" />
		</span>
		<hr class="mt-1 mb-3" />
		<div
			class="progress d-flex align-items-center bg-body w-50 h-100 m-auto my-2">
			<div class="prog-circle green-bg" role="progressbar"
				aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-hr bg-secondary" role="progressbar"
				aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="prog-circle bg-secondary" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<aui:form name="licenseUserForm"
			action="<%=addRegistrationFormActionURL%>" method="POST">
			<div class="px-5 container mt-3">
				<div class="card px-4 py-3">
					<div class="form_header text-center">
						<h6 class="m-0 p-0 fw-bold">
							<!--Food Grain License Form-B-->
							<liferay-ui:message key="food-grain-license-form-b" />
						</h6>
						<h6 class="m-0 p-0 fw-bold">
							<!--Original Copy-->
							<liferay-ui:message key="original-copy" />
						</h6>
						<h5 class="m-0 p-0 fw-bold green-text">
							<!--Government of People's Republic of Bangladesh-->
							<liferay-ui:message
								key="government-of-peoples-republic-of-bangladesh" />
						</h5>

						<h6 class="m-0 p-0 fw-bold">
							<!--Food Division Department of Food, Dhaka-->
							<liferay-ui:message key="food-division-department-of-food-dhaka" />
						</h6>
					</div>
					<h5 class="green-text mb-0 fw-bold ">
						<!--NID Details-->
						<liferay-ui:message key="nid-details" />
					</h5>
					<div class="green-bg">
						<hr class="m-0" />
					</div>
					<div class="row g-4 mt-1">
						<div class="col-md-6">
							<span class="d-block fw-bold">
								<!--NID Number-->
								<liferay-ui:message key="nid-number" /><sup class="text-danger">*</sup>
							</span>
							<aui:input class="w-100 px-2 py-1" type="text" name="nationalId"
								placeholder="type-here" label="">
								<aui:validator errorMessage="the-nid-number-field-is-required"
									name="required"></aui:validator>
								<aui:validator errorMessage="please-enter-only-digit"
									name="digits" />
								 <aui:validator errorMessage="user-already-exists-with-this-nid"
									name="custom">
			                		function(val, fieldNode, ruleValue) {
							        var nationalId = A.one('#<portlet:namespace />nationalId').val();
							        var isUser = false;
							        var xhr = new XMLHttpRequest();
							        var url = '<%= resourceURL %>';
							        var params = '<portlet:namespace />cmd=checkUserByNid&<portlet:namespace />nationalId=' + encodeURIComponent(val);
							
							        xhr.open('POST', url, false);
							        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
							        xhr.onreadystatechange = function() {
							            if (xhr.readyState === 4 && xhr.status === 200) {
							                if (xhr.responseText) {
							                    var json = JSON.parse(xhr.responseText);
							                    isUser = !json.isUser;
							                }
							            }
							        };
							
							        xhr.send(params);
							        return isUser;
							    }	
		        			</aui:validator>
								<aui:validator errorMessage="enter-a-valid-nid-number"
									name="custom"> 
									    function(val, fieldNode, ruleValue) {
									        var length = val.length;
									        if (length === 10 || length === 13 || length === 17) {
									            var regex = new RegExp(/^(?!0+$)[0-9]+$/);
									            return regex.test(val);
									        }
									    }
									</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6">
							<span class="d-block fw-bold">
								<!--Email Address-->
								<liferay-ui:message key="email-address" /><sup
								class="text-danger"></sup>
							</span>
							<aui:input class="w-100 px-2 py-1" type="email" name="email"
								placeholder="type-here" label="">

								<aui:validator name="email" />
								<aui:validator
									errorMessage="user-already-exists-with-this-email"
									name="custom">
			                		function(val, fieldNode, ruleValue) {
							        var nationalId = A.one('#<portlet:namespace />nationalId').val();
							        var isUser = false;
							        var xhr = new XMLHttpRequest();
							        var url = '<%= resourceURL %>';
							        var params = '<portlet:namespace />cmd=checkUserByEmail&<portlet:namespace />email=' + encodeURIComponent(val);
							
							        xhr.open('POST', url, false);
							        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
							        xhr.onreadystatechange = function() {
							            if (xhr.readyState === 4 && xhr.status === 200) {
							                if (xhr.responseText) {
							                    var json = JSON.parse(xhr.responseText);
							                    isUser = !json.isUser;
							                }
							            }
							        };
							
							        xhr.send(params);
							        return isUser;
							    }	
		        			</aui:validator>
								<aui:validator errorMessage="enter-a-valid-email-address"
									name="custom">
									function(val, fieldNode, ruleValue) {
                        				var regex = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/);
										return regex.test(val);
                					}
									</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="row g-4 mt-1">
						<div class="col-md-6">
							<span class="d-block fw-bold">
								<!--Mobile Number-->
								<liferay-ui:message key="mobile-number" /><sup
								class="text-danger">*</sup>
							</span>
							<aui:input class="w-100 py-1 px-5" type="tel" name="mobileNo"
								placeholder="type-here" label="">
								<aui:validator
									errorMessage="the-mobile-number-field-is-required"
									name="required"></aui:validator>
								<aui:validator name="number" />
								<aui:validator errorMessage="enter-a-valid-mobile-number"
									name="custom">
									function(val, fieldNode, ruleValue) {
                        				var regex = new RegExp(/^(?!0+$)[0][1][1-9][0-9]{8}$/);
										return regex.test(val);
                					}
									</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6">
							<span class="d-block fw-bold">
								<!--Date of Birth-->
								<liferay-ui:message key="date-of-birth" /><sup
								class="text-danger">*</sup>
							</span>
							<aui:input class="w-100 px-2 py-1 px-2 py-1" type="date"
								name="birthDate" placeholder="type-here" label="">
								<aui:validator errorMessage="the-birth-date-field-is-required"
									name="required"></aui:validator>
								 <aui:validator errorMessage="please-give-date-of-birth-of-nid"
									name="custom">
			                		function(val, fieldNode, ruleValue) {
							        var nationalId = A.one('#<portlet:namespace />nationalId').val();
							        var isError = false;
							        var xhr = new XMLHttpRequest();
							        var url = '<%= resourceURL %>';
							        var params = '<portlet:namespace />cmd=checkNidStatus&<portlet:namespace />nationalId=' + encodeURIComponent(nationalId) + '&<portlet:namespace />birthDate=' + encodeURIComponent(val);
							        xhr.open('POST', url, false);
							        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
							        xhr.onreadystatechange = function() {
							            if (xhr.readyState === 4 && xhr.status === 200) {
							                if (xhr.responseText) {
							                    var json = JSON.parse(xhr.responseText);
							                    isError = json.isStatus;
							                }
							            }
							        };
							
							        xhr.send(params);
							        return isError;
							    }
		        			</aui:validator>
								<aui:validator
									errorMessage="minimum-age-should-be-18-years-and-enter-a-valid-birth-date"
									name="custom">
										function(val, fieldNode, ruleValue) {
    										var eighteenYearsAgo = new Date();
    										eighteenYearsAgo.setFullYear(eighteenYearsAgo.getFullYear() - 18);
    										var inputDate = new Date(val);

    										if (!val) {
      											return false;
    										}
    										if (inputDate > eighteenYearsAgo || inputDate > new Date()) {
      											return false;
    										}
    											return true;
  											}
									</aui:validator> 
							</aui:input>
						</div>
					</div>
					<h5 class="green-text mb-0 mt-3 fw-bold">
						<liferay-ui:message key="set-up-your-password-for-online-account" />
					</h5>
					<div class="green-bg">
						<hr class="m-0" />
					</div> 
					<div class="row g-4 mt-1">
						<div class="col-md-6">
							<span class="d-block fw-bold"><liferay-ui:message
									key="password" /><sup class="text-danger">*</sup></span>
							<aui:input class="w-100 px-2 py-1" type="password"
								name="password" placeholder="type-here" label="">
								<aui:validator errorMessage="the-password-field-is-required"
									name="required"></aui:validator>
								<aui:validator
									errorMessage="use-at-least-1-lower-case-1-upper-case-1-digit-one-special-character-and-is-at-least-8-to-16-characters-long"
									name="custom">
        								function(val, fieldNode, ruleValue) {
            								var regex = new RegExp(/^(?=.*[A-Z])(?=.*[\W])(?=.*[0-9])(?=.*[a-z]).{8,16}$/);
            								return regex.test(val);
        								}
    								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-6">
							<span class="d-block fw-bold"><liferay-ui:message
									key="confirm-password" /><sup class="text-danger">*</sup></span>
							<aui:input class="w-100 px-2 py-1" type="password"
								name="confirmPassword" placeholder="type-here" label="">
								<aui:validator
									errorMessage="the-confirm-password-field-is-required"
									name="required"></aui:validator>
								<aui:validator errorMessage="password-does-not-match"
									name="custom">
		                		function(val, fieldNode, ruleValue) {
		                			var password = A.one('#<portlet:namespace />password').val();
		                			return val == password;
		                		}
		                	</aui:validator>
							</aui:input>
						</div>
					</div>
					<p class="mb-1">
						<small><liferay-ui:message
								key="a-strong-password-should-be-at-least-8-characters-long-with-a-1-capital-1-number-1-special-character" /></small>
					</p>
					<!-- Captcha -->
					<div class="w-50">
						<liferay-captcha:captcha url="<%= captchaResourceURL %>" />
					</div>

					<p class="text-danger fw-bold mt-1" style="display: none"
						id="captchaError">
						<small class="text-danger"><liferay-ui:message
								key="captcha-does-not-match" /></small>
					</p>
					<div id="loaderContainer2" style="display: none">
						<div class="loader">
							<span></span> <span></span> <span></span> <span></span> <span></span>
							<span></span>
						</div>
					</div>
				</div>
				<button type="submit" id="submitButton" onclick="showLoader2()"
					class="btn btn-success mt-4 px-5 green-bg border-0">
					<!--Next-->
					<liferay-ui:message key="next" />
					<i class="fa-regular fa-circle-right"></i>
				</button>

				<!--        Start Otp Popup -->
				<div id="render-otp-popup" class="modal-body"></div>
				<div id="otp-popup" style="display: none !important"
					class="container height-100 d-flex justify-content-center align-items-center">
					<div class="position-relative">
						<div class="card p-2 text-center">
							<h6>
								<liferay-ui:message key="enter-the-otp-sent-on-your-mobile-no" />
								: <small id="otpMobileNo">*******9897</small> <br />
							</h6>
							<div id="otp"
								class="inputs d-flex flex-row justify-content-center mt-2">
								<aui:input
									cssClass="m-2 text-center form-control rounded otp-input-field"
									type="text" name="first" maxlength="1" label=""
									onkeyup="forwardNext(this)"></aui:input>
								<aui:input
									cssClass="m-2 text-center form-control rounded otp-input-field"
									type="text" name="second" maxlength="1" label=""
									onkeyup="forwardNext(this)"></aui:input>
								<aui:input
									cssClass="m-2 text-center form-control rounded otp-input-field"
									type="text" name="third" maxlength="1" label=""
									onkeyup="forwardNext(this)"></aui:input>
								<aui:input
									cssClass="m-2 text-center form-control rounded otp-input-field"
									type="text" name="fourth" maxlength="1" label=""
									onkeyup="forwardNext(this, 'END')"></aui:input>

							</div>
							<br>
							<p class="text-danger fw-bold mt-1" style="display: none"
								id="otpMatchStatus">
								<small>
									<!-- Otp dosen't match -->
									<liferay-ui:message key="otp-does-not-match" />
								</small>
							</p>


							<div class="mt-4">
								<button type="submit" id="otpSubmit"
									class="btn px-4 validate green-bg " onclick="showLoader()"
									disabled="disabled">
									<liferay-ui:message key="submit" />
								</button>

								<a id="otpResendButton" href="javascript:;"
									onclick="otpResend()"
									class="px-4 validate text-decoration-none"></a>
							</div>
							<div id="loaderContainer" style="display: none;">
								<div class="loader">
									<span></span> <span></span> <span></span> <span></span> <span></span>
									<span></span>
								</div>

							</div>




						</div>
					</div>
				</div>
				<!--     End Otp Popup -->
				<br>
				<p class="text-danger fw-bold mt-1">
					<small>
						<!--Note: By clicking on Next you are agreeing to retrieve and
		              validate your data from NID-->
						<liferay-ui:message key="note" />:<liferay-ui:message
							key="by-clicking-on-next-you-are-agreeing-to-retrieve-and-validate-your-data-from-nid" />
					</small>
				</p>
			</div>
		</aui:form>
	</div>

	<!-- Bootstrap JavaScript CDN-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

	<script>
      
    
    function otpResend() {
    	 AUI().use('aui-io-request', function(A){
 	        A.io.request('<%=resourceURL%>', {
	               method: 'POST',
	               data: {
	               	   '<portlet:namespace />cmd' : 'resendOTP',
	                   '<portlet:namespace />nationalId' : document.getElementById("<portlet:namespace />nationalId").value,
	                   '<portlet:namespace />mobileNo' : document.getElementById("<portlet:namespace />mobileNo").value,
	               },
	               dataType:'json',
	               sync: true,
	               on: {
	                       success: function() {
	                       var json = this.get('responseData');
	                       var otpId = json.otpId;
	                       var isOtpGenerate = json.isOtpGenerate;
	                       localStorage.setItem("otpId", otpId); 
	                       isOtpGenerate = true;
	                       
	                       // clear otp
	                       document.getElementById('<portlet:namespace />first').value ="";
	   					   document.getElementById('<portlet:namespace />second').value="";
	   					   document.getElementById('<portlet:namespace />third').value="";
	   					   document.getElementById('<portlet:namespace />fourth').value="";
	   					  // start the resend otp countdown
	   					  startOTPTimer(300);
	                   }
	              }
	        });
 	        
	    });
    }

    function forwardNext(el, elementValue) {
    	var inputVal = el.value;
    	if(inputVal) {
    		var otp = document.getElementById('<portlet:namespace />first').value+
    						document.getElementById('<portlet:namespace />second').value+
    						document.getElementById('<portlet:namespace />third').value+
    						document.getElementById('<portlet:namespace />fourth').value;
	    	if("END" != elementValue) {
	    		el.parentElement.nextElementSibling.getElementsByTagName("input")[0].focus();
	    		if(otp.length >= 4) {
	    			matchOtp(otp);
	    			}
	    	} else {
	    		if(otp.length >= 4) {
	    			matchOtp(otp);
	    			}
	    	}
    	}
     }
    
    function matchOtp(otp) {
    	AUI().use('aui-io-request', function(A){
		var mobileNo = A.one('#<portlet:namespace />mobileNo').val();
	 	var otpId = localStorage.getItem("otpId"); 
		var isMatch = false;
  		 AUI().use('aui-io-request', function(A){
	        A.io.request('${resourceURL}', {
	               method: 'post',
	               data: {
	               	   <portlet:namespace />cmd: 'matchOTP',
	               	   <portlet:namespace />mobileNo: mobileNo,
	                   <portlet:namespace />otpId: otpId,
	                   <portlet:namespace />otp: otp
	               },
	               sync: true,
	               on: {
	                       success: function() {
	                       var json = JSON.parse(this.get('responseData'));
	                       isMatch = json.isMatch;
	                   }
	              }
	       	 });
  		  	});
			if(isMatch) {
				document.getElementById("otpSubmit").disabled = false;
				document.getElementById("otpMatchStatus").style.display = "none";
				document.getElementById("otpResendButton").style.pointerEvents = "none";
			} else {
				document.getElementById("otpMatchStatus").style.display = "block";
				document.getElementById("otpSubmit").disabled = true;
				document.getElementById("otpResendButton").style.pointerEvents="auto";
			}
    	});
	}

    </script>
	<script>
        function showLoader() {
        // document.getElementById("myButton").style.display = "none";
        document.getElementById("loaderContainer").style.display = "block";
       // change 3000 to however long you want the loader to show for in milliseconds
        }
        
    </script>
</body>
</html>
