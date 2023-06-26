<portlet:resourceURL id="tradLicense" var="resourceURL"></portlet:resourceURL>

<aui:script>
    AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
        A.one("#<portlet:namespace/>businessDivision").on('change', function(){
            var web_divId = this.get('value');
            var divSelected = "divSelected";
            A.io.request(getResourceURL(), {
                method:'POST',
                data: { '<portlet:namespace/>web_divId': web_divId, '<portlet:namespace/>divSelected': divSelected },
                dataType:'json',
                cache: false,
                on:{
                    success:function(){
                        var districtList = this.get('responseData');
                        A.one('#<portlet:namespace/>businessDistrict').set('disabled', false);
                        A.one('#<portlet:namespace/>businessDistrict').set('value', '');
                        A.one('#<portlet:namespace/>businessDistrict').empty();
                        var langValue = "<liferay-ui:message key='select-a-district' />"
                        A.one('#<portlet:namespace/>businessDistrict').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        for(var i =0; i< districtList.length; i++){
                            A.one('#<portlet:namespace />businessDistrict').append("<option  value='" + districtList[i].disId +"' >"+districtList[i].districtName+"</option> ");
                        }
                        
                        A.one('#<portlet:namespace/>businessUpzilla').set('disabled', false);
                        A.one('#<portlet:namespace/>businessUpzilla').set('value', ''); 
                        A.one('#<portlet:namespace/>businessUpzilla').empty();
                        var langValue = "<liferay-ui:message key='select-a-upzilla' />"
                        A.one('#<portlet:namespace/>businessUpzilla').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        
                        A.one('#<portlet:namespace/>businessUnionName').set('disabled', false);
                        A.one('#<portlet:namespace/>businessUnionName').set('value', ''); 
                        A.one('#<portlet:namespace/>businessUnionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>businessUnionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });

        A.one("#<portlet:namespace/>businessDistrict").on('change', function(){
            var web_disId = this.get('value');
            console.log(web_disId);
            var disSelected = "disSelected";
            A.io.request(getResourceURL(), {
                method:'POST',
                data: { '<portlet:namespace/>web_disId': web_disId, '<portlet:namespace/>disSelected': disSelected },
                dataType:'json',
                on:{
                    success:function(){
                        var upzillaList = this.get('responseData');
                        A.one('#<portlet:namespace/>businessUpzilla').set('disabled', false);
                        A.one('#<portlet:namespace/>businessUpzilla').set('value', ''); 
                        A.one('#<portlet:namespace/>businessUpzilla').empty();
                        var langValue = "<liferay-ui:message key='select-a-upzilla' />"
                        A.one('#<portlet:namespace/>businessUpzilla').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        for(var i = 0; i < upzillaList.length; i++){
                            A.one('#<portlet:namespace/>businessUpzilla').append("<option  value='"+ upzillaList[i].subDisId +"' >"+upzillaList[i].subDistrictName+"</option> ");
                        }
                        
                        A.one('#<portlet:namespace/>businessUnionName').set('disabled', false);
                        A.one('#<portlet:namespace/>businessUnionName').set('value', ''); 
                        A.one('#<portlet:namespace/>businessUnionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>businessUnionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });
        
        A.one("#<portlet:namespace/>businessUpzilla").on('change', function(){
            var web_subDisId = this.get('value');
            var subDisSelected = "subDisSelected";
            A.io.request(getResourceURL(), {
                method:'POST',
                data: { '<portlet:namespace/>web_subDisId': web_subDisId, '<portlet:namespace/>subDisSelected': subDisSelected },
                dataType:'json',
                on:{
                    success:function(){
                        var unionList = this.get('responseData');
                        A.one('#<portlet:namespace/>businessUnionName').set('disabled', false);
                        A.one('#<portlet:namespace/>businessUnionName').set('value', ''); 
                        A.one('#<portlet:namespace/>businessUnionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>businessUnionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        for(var i =0; i < unionList.length; i++){
                            A.one('#<portlet:namespace/>businessUnionName').append("<option  value='"+ unionList[i].unId +"' >"+unionList[i].unionName+"</option> ");
                        }
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });
    });
    
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