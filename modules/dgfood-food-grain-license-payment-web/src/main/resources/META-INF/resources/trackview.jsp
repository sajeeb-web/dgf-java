
<%@ include file="init.jsp"%>
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<portlet:defineObjects />
<portlet:actionURL name="addUploadTrackData" var="addUploadDataActonURL" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<link href="${contextPath}/custom/bootstrap.css" rel="stylesheet">
</head>>
<body>

	<div class="main-div" style="">
		<hr class="mt-3 mb-1" />
		<span class="fs-5 fw-bold p-0 m-0"> <!-- Apply For a New Food Grain License -->
			<liferay-ui:message key="track-your-application-status" />
		</span>
		<hr class="mt-1 mb-3" />
		<div style="min-height: calc(100vh - 180px)"
			class="d-flex justify-content-center align-items-center">
			<div class="row"></div>

			<div class="col-md-6 px-5 m-auto">
				<div class="card p-5 shadow-sm">
					<h5 class="pb-3 green-text">
						<!-- Track your Food Grain License -->
						<liferay-ui:message key="track-your-food-grain-license" />
					</h5>
					<c:if test="${alertMessage == 'true'}">
						<script>alert("Given data does not match any existing record . Please provide with correct information.");</script>
					</c:if>
					<aui:form action="<%=addUploadDataActonURL%>" method="post"
						name="addUploadDataActonURL" enctype="multipart/form-data">
						<aui:input type="hidden" name="pageId" value="1" />
						<div class="d-flex ">
							<div class="d-flex ">
								<aui:input inlineLabel="right" name="radioButton" type="radio"
									value="nid" checked="true" label="nidno" id="nidType" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<aui:input name="radioButton" type="radio" value="applicationno"
									label="application-no" id="applicationnoType" />
							
							</div>
						</div>
					
						<div>
							<aui:input name="trackingNum" class="form-control" type="text"
								placeholder="type-here" aria-label="default input example" label="">
							<aui:validator name="required" errorMessage="the-nid-application-no-field-is-required"/>
							<aui:validator name="digits"/>
							<aui:validator errorMessage="enter-a-valid-nid-number"
										name="custom"> 
									function(val, fieldNode, ruleValue) {
                        				var regex = new RegExp(/^[0-9]{10,17}$/);
										return regex.test(val);
                					}
								</aui:validator> 
		                	<aui:validator errorMessage="nid-number-does-not-match" name="custom">
		                		
		                		function(val, fieldNode, ruleValue) {
		                				var applicationnoType = A.one('#<portlet:namespace />applicationnoType').attr("checked");
		                		
				                		if(applicationnoType) {
				                			return true;
				                		}
		                		
									   var isUser;
									   var xhr = new XMLHttpRequest();
									   var url = '${resourceURL}';
									   var params = '<portlet:namespace />cmd=checkUserByNid&<portlet:namespace />trackingNum=' + encodeURIComponent(val);
									   xhr.open('POST', url, false);
									   xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
									   xhr.onreadystatechange = function() {
									       if (xhr.readyState === 4 && xhr.status === 200) {
									           if (xhr.responseText) {
									               var json = JSON.parse(xhr.responseText);
									                isUser = json.isUser;
									           } else {
									               isUser = false;
									           }
									       }
									   }
									   xhr.send(params);
									   return isUser;
									}
		                		
		                		</aui:validator>
		                		<aui:validator errorMessage="application-number-does-not-match" name="custom">
		                		
		                		 function(val, fieldNode, ruleValue) {
		                		 		var applicationnoType = A.one('#<portlet:namespace />applicationnoType').attr("checked");
				                		if(!applicationnoType) {
				                			return true;
				                		}
		                		 
		                		 
									   var isUser;
									   var xhr = new XMLHttpRequest();
									   var url = '${resourceURL}';
									   var params = '<portlet:namespace />cmd=checkUserByApplicationNo&<portlet:namespace />trackingNum=' + encodeURIComponent(val);
									   xhr.open('POST', url, false);
									   xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
									   xhr.onreadystatechange = function() {
									       if (xhr.readyState === 4 && xhr.status === 200) {
									           if (xhr.responseText) {
									               var json = JSON.parse(xhr.responseText);
									               isUser = json.isUser;
									           } else {
									               isUser = false;
									           }
									       }
									   }
									   xhr.send(params);
									   return isUser;
									}
		                		</aui:validator>
							</aui:input>
						</div>
						<div>
							<label for="exampleFormControlInput1" class="form-label mb-1"><span
								class="d-block"> <!-- Date of Birth --> <liferay-ui:message
										key="date-of-birth" /><sup class="text-danger">*</sup>
							</span> </label>
							
							<aui:input class="w-100 px-2 py-1 px-2 py-1" type="date"
								name="trackBirthDate" label="" required="required"> 
								<aui:validator name="required" errorMessage="the-date-of-birth-field-is-required"/> 
								<aui:validator errorMessage="date-does-not-match" name="custom">
		                	
		                		function(val, fieldNode, ruleValue) {
		                		   var applicationnoType = A.one('#<portlet:namespace />applicationnoType').attr("checked");
								   var trackingNum;
								   var isDateCorrect;
								   var trackingNum = A.one('#<portlet:namespace />trackingNum').val();
								   var trackBirthDate = A.one('#<portlet:namespace />trackBirthDate').val();
								   var xhr = new XMLHttpRequest();
								   var url = '${resourceURL}';
								   var applicationnoTypeChack=applicationnoType == true ? 'checkUserByApplicationNo': 'checkUserByNid';
								   var params = '<portlet:namespace />cmd=' + encodeURIComponent(applicationnoTypeChack) + '&<portlet:namespace />trackingNum=' + encodeURIComponent(trackingNum) + '&<portlet:namespace />trackBirthDate=' + encodeURIComponent(trackBirthDate);
								   xhr.open('POST', url, false);
								   xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
								   xhr.onreadystatechange = function() {
								       if (xhr.readyState === 4 && xhr.status === 200) {
								           if (xhr.responseText) {
								               var json = JSON.parse(xhr.responseText);
								               if (json.isDateCorrect != null) {								                  
								                   isDateCorrect = json.isDateCorrect; 
								               }
								           } else {
								               isDateCorrect = false;
								           }
								       }
								   };
								   xhr.send(params);
								   return isDateCorrect;
								}
		                		</aui:validator>
							</aui:input>
						</div>
						<div class="pt-5">
							<a href="/food-grain-license-lc" class="btn btn-secondary me-2">
								<i class="icon-circle-arrow-left"></i>&nbsp;<liferay-ui:message key="back" />
							</a>
							<button class="btn btn-success green-bg border-0" type="submit" name="submit" id="SubmitBtn" value="Submit">
							<liferay-ui:message key="submit" />&nbsp;<i class="icon-circle-arrow-right"></i>
							</button>

							

						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</body>







