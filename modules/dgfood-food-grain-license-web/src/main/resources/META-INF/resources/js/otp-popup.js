<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<aui:script >
document.getElementById("submitButton").addEventListener("click", function(event) {
	  event.preventDefault();
	 if (isFormHasErrors()) {
	 		document.getElementById("loaderContainer2").style.display = "none";
			return false;
		  }
	
	 AUI().use('aui-io-request', function(A){
	        A.io.request('<%=resourceURL%>', {
	               method: 'POST',
	               data: {
	               	   '<portlet:namespace />cmd' : 'matchCaptcha',
	                   '<portlet:namespace />captchaText' : document.getElementById("<portlet:namespace />captchaText").value,
	               },
	               dataType:'json',
	               sync: true,
	               on: {
	                       success: function() {
	                       var json = this.get('responseData');
	                       var isMatchCaptcha = json.isMatchCaptcha;

		               	 	if (!isMatchCaptcha) {
		               	 		document.getElementById("captchaError").style.display="block";
		               	 		document.getElementById("loaderContainer2").style.display = "none";
		               	 		return false;
		               		  } else {
		               			  document.getElementById("captchaError").style.display="none";
		               			  generateOTP();
		               		  }
	               				
	                       }
	              }
	        });
	        
	    });
	});

	function isFormHasErrors() {
		var formValidator = 
	        Liferay.Form.get('<portlet:namespace />licenseUserForm').formValidator;
	
		formValidator.validate();
		return formValidator.hasErrors();
	}
	
	function generateOTP(){
		 AUI().use('aui-io-request', function(A){
		        A.io.request('<%=resourceURL%>', {
		               method: 'POST',
		               data: {
		               	   '<portlet:namespace />cmd' : 'generateOTP',
		                   '<portlet:namespace />nationalId' : document.getElementById("<portlet:namespace />nationalId").value,
		                   '<portlet:namespace />email' : document.getElementById("<portlet:namespace />email").value,
		                   '<portlet:namespace />birthDate' : document.getElementById("<portlet:namespace />birthDate").value,
		                   '<portlet:namespace />mobileNo' : document.getElementById("<portlet:namespace />mobileNo").value,
		                   '<portlet:namespace />password' : document.getElementById("<portlet:namespace />password").value,
		                   '<portlet:namespace />confirmPassword' : document.getElementById("<portlet:namespace />confirmPassword").value,
		               },
		               dataType:'json',
		               sync: true,
		               on: {
		                       success: function() {
			                       var json = this.get('responseData');
			                       var otpId = json.otpId;
			                       var isOtpGenerate = json.isOtpGenerate;
			                       localStorage.setItem("otpId", otpId); 
			                       var otpMobileNumber = document.getElementById("<portlet:namespace />mobileNo").value;
			                       var otpFirstMobileNumber = otpMobileNumber.substring(0, 3);
			                       var otpLastMobileNumber = otpMobileNumber.substring(otpMobileNumber.length - 2);;
			                       document.getElementById("otpMobileNo").innerHTML = otpFirstMobileNumber +"******"+otpLastMobileNumber;
			                       
			                       if(isOtpGenerate) {
			                    	   openOtpPopup();
			                    	   startOTPTimer(300);
			                    	   document.getElementById("loaderContainer2").style.display = "none";
			                       }
		                       }
		              }
		        });
		        
		    });
	}
	
	function openOtpPopup() {
		 // Show the pop-up
		  AUI().use('aui-modal', function(A) {
		    var modal = new A.Modal({
		      bodyContent: A.one("#otp-popup").html(),
		      headerContent: '<liferay-ui:message key='license-registration-otp' />',
		      centered: true,
		      modal: true,
		      render: '#render-otp-popup',
		      tools: [
		        {
		          handler: function() {
		            this.hide();
		          },
		          label: 'Close'
		        }
		      ]
		    }).render();
		    
		    modal.on('visibleChange', function(event) {
		        if (!event.newVal) {
		        	const myNode = document.getElementById("render-otp-popup");
		        	  myNode.innerHTML  = '';
		        	  window.location.reload();
		        }
		    });
		  });
	}

	function startOTPTimer(duration) {
		  var timer = duration;
		  var minutes, seconds;

		  var interval = setInterval(function () {
		    minutes = parseInt(timer / 60, 10);
		    seconds = parseInt(timer % 60, 10);

		    minutes = minutes < 10 ? "0" + minutes : minutes;
		    seconds = seconds < 10 ? "0" + seconds : seconds;
		    var langValueResendIn = "<liferay-ui:message key='resend-in' />"
		    var langValueSeconds = "<liferay-ui:message key='seconds' />"
		    var element = document.getElementById('otpResendButton');
		    if (document.getElementById('otpResendButton') != null) {
		    	document.getElementById('otpResendButton').innerHTML = langValueResendIn+" " + minutes + ":" + seconds+" "+langValueSeconds;
		    	document.getElementById('otpResendButton').style.pointerEvents="none";
		    	document.getElementById('otpResendButton').style.cursor="default";
		    } else {
		    	clearInterval(interval);
		    }
		   
		    if (--timer < 0) {
		      clearInterval(interval);
		      document.getElementById('otpResendButton').style.pointerEvents="auto";
		      document.getElementById('otpResendButton').style.cursor="pointer";
			  var langValueResendOtp = "<liferay-ui:message key='resend-otp' />"
			  document.getElementById('otpResendButton').innerHTML = langValueResendOtp;
		    }
		  }, 1000);
		}
	
	 function showLoader2() {
    	 document.getElementById("loaderContainer2").style.display = "block";
       }

</aui:script>


