<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<aui:script>
    AUI().use('aui-base','aui-io-request', 'aui-node', function(A) {
    	  A.one("#<portlet:namespace/>division").on('change', function(){
              var web_divId = this.get('value');
              var divSelected = "divSelected";
              A.io.request('<%=resourceURL%>', {
                  method:'POST',
                  data: { '<portlet:namespace/>web_divId': web_divId, '<portlet:namespace/>divSelected': divSelected },
                  dataType:'json',
                  cache: false,
                  on:{
                      success:function(){
                          var districtList = this.get('responseData');
                          A.one('#<portlet:namespace/>district').set('disabled', false);
                          A.one('#<portlet:namespace/>district').set('value', '');
                          A.one('#<portlet:namespace/>district').empty();
                          var langValue = "<liferay-ui:message key='select-a-district' />"
                          A.one('#<portlet:namespace/>district').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                          for(var i =0; i< districtList.length; i++){
                              A.one('#<portlet:namespace />district').append("<option  value='" + districtList[i].disId +"' >"+districtList[i].districtName+"</option> ");
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
              var web_disId = this.get('value');
              console.log(web_disId);
              var disSelected = "disSelected";
              A.io.request('<%=resourceURL%>', {
                  method:'POST',
                  data: { '<portlet:namespace/>web_disId': web_disId, '<portlet:namespace/>disSelected': disSelected },
                  dataType:'json',
                  cache: false,
                  on:{
                      success:function(){
                          var upzillaList = this.get('responseData');
                          A.one('#<portlet:namespace/>upzilla').set('disabled', false);
                          A.one('#<portlet:namespace/>upzilla').set('value', ''); 
                          A.one('#<portlet:namespace/>upzilla').empty();
                          var langValue = "<liferay-ui:message key='select-a-upzilla' />"
                          A.one('#<portlet:namespace/>upzilla').prepend("<option value='' selected='true' disabled='true'>"+langValue+"</option>");
                          for(var i = 0; i < upzillaList.length; i++){
                              A.one('#<portlet:namespace/>upzilla').append("<option  value='"+ upzillaList[i].subDisId +"' >"+upzillaList[i].subDistrictName+"</option> ");
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
            var web_subDisId = this.get('value');
            var subDisSelected = "subDisSelected";
            A.io.request('<%=resourceURL%>', {
                method:'POST',
                data: { '<portlet:namespace/>web_subDisId': web_subDisId, '<portlet:namespace/>subDisSelected': subDisSelected },
                dataType:'json',
                on:{
                    success:function(){
                        var unionList = this.get('responseData');
                        A.one('#<portlet:namespace/>unionName').empty();
                        A.one('#<portlet:namespace/>unionName').prepend("<option selected='true' disabled='true'>Please Select an Option</option>");
                        for(var i =0; i < unionList.length; i++){
                            A.one('#<portlet:namespace/>unionName').append("<option  value='"+ unionList[i].unId +"' >"+unionList[i].unionName+"</option> ");
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