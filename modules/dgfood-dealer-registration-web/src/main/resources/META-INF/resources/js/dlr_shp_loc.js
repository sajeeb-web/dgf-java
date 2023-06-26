<aui:script>
    AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
        A.one("#<portlet:namespace/>division").on('change', function(){
        	var pAuth = Liferay.authToken;
            var web_divId = this.get('value');
            var divSelected = "divSelected";
            var langId = Liferay.ThemeDisplay.getLanguageId();
            A.io.request('/api/jsonws/dgf.dgflocdistrict/getDistrictsByDivision', {
                method:'GET',
                headers: {
					'Content-Type': 'application/json',
					'X-CSRF-Token' : pAuth
		   		 },
                data: { 'divisionId': web_divId},
                on:{
                    success:function(){
                        var districtList = this.get('responseData');
                        A.one('#<portlet:namespace/>district').set('disabled', false);
                        A.one('#<portlet:namespace/>district').set('value', '');
                        A.one('#<portlet:namespace/>district').empty();
                        var langValue = "<liferay-ui:message key='select-a-district' />"
                        A.one('#<portlet:namespace/>district').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        var jsonParse = JSON.parse(districtList);
                        for(var i =0; i< jsonParse.length; i++){ 
                        	if(langId == "bn_BD"){
                        		A.one('#<portlet:namespace />district').append("<option  value='" + JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).bnName+"</option> ");
                        	}else{
                        		A.one('#<portlet:namespace />district').append("<option  value='" + JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).name+"</option> ");
                        	}
                        	}
                        A.one('#<portlet:namespace/>upzilla').set('disabled', false);
                        A.one('#<portlet:namespace/>unionName').set('value', ''); 
                        A.one('#<portlet:namespace/>upzilla').empty();
                        var langValue = "<liferay-ui:message key='select-a-upzilla' />"
                        A.one('#<portlet:namespace/>upzilla').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        
                        A.one('#<portlet:namespace/>unionName').set('disabled', false);
                        A.one('#<portlet:namespace/>unionName').set('value', ''); 
                        A.one('#<portlet:namespace/>unionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>unionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });

        A.one("#<portlet:namespace/>district").on('change', function(){
        	var pAuth = Liferay.authToken;
            var web_disId = this.get('value');
            var disSelected = "disSelected";
            var langId = Liferay.ThemeDisplay.getLanguageId();
            A.io.request('/api/jsonws/dgf.dgflocsubdistrict/getSubDistrictsByDistrict', {
                method:'GET',
                headers: {
					'Content-Type': 'application/json',
					'X-CSRF-Token' : pAuth
		   		 },
                data: { 'districtId': web_disId},
                on:{
                    success:function(){
                        var upzillaList = this.get('responseData');
                        A.one('#<portlet:namespace/>upzilla').set('disabled', false);
                        A.one('#<portlet:namespace/>upzilla').set('value', ''); 
                        A.one('#<portlet:namespace/>upzilla').empty();
                        var langValue = "<liferay-ui:message key='select-a-upzilla' />"
                        A.one('#<portlet:namespace/>upzilla').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        var jsonParse = JSON.parse(upzillaList);
                        for(var i = 0; i < jsonParse.length; i++){
                        	if(langId == "bn_BD"){
                        		A.one('#<portlet:namespace/>upzilla').append("<option  value='"+ JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).bnName+"</option> ");
                        	}else{
                        		A.one('#<portlet:namespace/>upzilla').append("<option  value='"+ JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).name+"</option> ");
                        	}
                        }
                        A.one('#<portlet:namespace/>unionName').set('disabled', false);
                        A.one('#<portlet:namespace/>unionName').set('value', '');   
                        A.one('#<portlet:namespace/>unionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>unionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });
        
        A.one("#<portlet:namespace/>upzilla").on('change', function(){
        	var pAuth = Liferay.authToken;
            var web_subDisId = this.get('value');
            var subDisSelected = "subDisSelected";
            var langId = Liferay.ThemeDisplay.getLanguageId();
            A.io.request('/api/jsonws/dgf.dgflocunion/getUnionsBySubDistrict', {
                method:'GET',
                headers: {
					'Content-Type': 'application/json',
					'X-CSRF-Token' : pAuth
		   		 },
                data: { 'subDistrict': web_subDisId},
                on:{
                    success:function(){
                        var unionList = this.get('responseData');
                        A.one('#<portlet:namespace/>unionName').set('disabled', false);
                        A.one('#<portlet:namespace/>unionName').set('value', '');
                        A.one('#<portlet:namespace/>unionName').empty();
                        var langValue = "<liferay-ui:message key='select-a-union' />"
                        A.one('#<portlet:namespace/>unionName').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                        var jsonParse = JSON.parse(unionList);
                        for(var i =0; i < jsonParse.length; i++){
                        	if(langId == "bn_BD"){
                        		A.one('#<portlet:namespace/>unionName').append("<option  value='"+ JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).bnName+"</option> ");
                        	}else{
                        		A.one('#<portlet:namespace/>unionName').append("<option  value='"+ JSON.parse(jsonParse[i]).id +"' >"+JSON.parse(jsonParse[i]).name+"</option> ");
                        	}
                        }
                    },
                    failure: function(){
                        console.log("An error has occurred while getting the districts from server");
                    }
                }
            });
        });
    });
</aui:script>