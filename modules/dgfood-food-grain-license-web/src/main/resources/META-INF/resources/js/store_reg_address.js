<portlet:resourceURL id="tradLicense" var="resourceURL"></portlet:resourceURL>

	
<aui:script>
function changeDistrict(element) {
	 var lastChar = element.name.substr(element.name.length - 1);
	 var web_divId = element.value;
	 var divSelected = "divSelected";
	 AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
	 A.io.request(getResourceURL(), {
       method:'POST',
       data: { '<portlet:namespace/>web_divId': web_divId, '<portlet:namespace/>divSelected': divSelected },
       dataType:'json',
       cache: false,
       on:{
           success:function(){
               var districtList = this.get('responseData');
               var inputName = '#<portlet:namespace/>storeDistrict'+lastChar;
               console.log("inputName==="+inputName);
               A.one(inputName).set('disabled', false);
               A.one(inputName).set('value', '');
               A.one(inputName).empty();
               var langValue = "<liferay-ui:message key='select-a-district' />"
               A.one(inputName).prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
               for(var i =0; i< districtList.length; i++){
                   A.one(inputName).append("<option  value='" + districtList[i].disId +"' >"+districtList[i].districtName+"</option> ");
               }
               
               A.one('#<portlet:namespace/>storeUpzilla'+lastChar).set('disabled', false);
               A.one('#<portlet:namespace/>storeUpzilla'+lastChar).set('value', ''); 
               A.one('#<portlet:namespace/>storeUpzilla'+lastChar).empty();
               var langValue = "<liferay-ui:message key='select-a-upzilla' />"
               A.one('#<portlet:namespace/>storeUpzilla'+lastChar).prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
           },
           failure: function(){
               console.log("An error has occurred while getting the districts from server");
           }
       }
   });
	 });
}

function changeUpazilla(element) {
	 var lastChar = element.name.substr(element.name.length - 1);
	 var web_disId = element.value;
	 var disSelected = "disSelected";
	 AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
	 A.io.request(getResourceURL(), {
      method:'POST',
      data: { '<portlet:namespace/>web_disId': web_disId, '<portlet:namespace/>disSelected': disSelected },
      dataType:'json',
      cache: false,
      on:{
          success:function(){
              var upzillaList = this.get('responseData');
              var inputName = '#<portlet:namespace/>storeUpzilla'+lastChar;
              A.one(inputName).set('disabled', false);
              A.one(inputName).set('value', '');
              A.one(inputName).empty();
              var langValue = "<liferay-ui:message key='select-a-district' />"
              A.one(inputName).prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
              for(var i =0; i< upzillaList.length; i++){
                  A.one(inputName).append("<option  value='"+ upzillaList[i].subDisId +"' >"+upzillaList[i].subDistrictName+"</option> ");

              }
     },
          failure: function(){
              console.log("An error has occurred while getting the districts from server");
          }
      }
  });
	 });
	 
}

function removeStore(containerId, storeId) {
	 var storeLength = document.querySelectorAll(".storeSection").length
	 if(storeLength<= 1) {
		 document.getElementById("singleStore").style.display="block";
		 return false;
	 }
	if(storeId<=0) {
		 document.getElementById("section-to-clone"+containerId).remove();
 		return false;
	}
	 AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
	 A.io.request(getResourceURL(), {
      method:'POST',
      data: { '<portlet:namespace/>storeId': storeId, '<portlet:namespace/>cmd': 'deleteStore' },
      dataType:'json',
      cache: false,
      on:{
          success:function(){
              var json = this.get('responseData');
              var isDeleted = json.isDeleted;
              if(isDeleted) {
            		var element = document.getElementById("section-to-clone"+containerId);
            		element.parentNode.removeChild(element);
              }
              },
          failure: function(){
              console.log("An error has occurred while deleted store from server");
          }
      }
  });
	 });
}

function getResourceURL() {
	 var url = new URL('<%=resourceURL%>');
     const searchParams = new URLSearchParams(url.search);
     for (const key of searchParams.keys()) {
     	  if(key != 'p_p_id' && key != 'p_p_lifecycle' && key != 'p_p_state' && key != 'p_p_mode' ) {
     		  url.searchParams.delete(key);
     	  }
     	}
     return url.toString();
}
</aui:script>