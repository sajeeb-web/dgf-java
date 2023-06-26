	<aui:script use="aui-base">
    AUI().use('aui-node', function(A) {
        A.one('#resetButton').on('click', function(event) {
            event.preventDefault();
            
            // Clear input fields
            A.one('#<portlet:namespace />dateFrom').set('value', '');
            A.one('#<portlet:namespace />dateTo').set('value', '');
            A.one('#<portlet:namespace />dateType').set('selectedIndex', 0);
            A.one('#<portlet:namespace />applicationNo').set('value', '');
            A.one('#<portlet:namespace />businessType').set('value', '');
            A.one('#<portlet:namespace />status').set('selectedIndex', 0);
            A.one('#<portlet:namespace />appLicType').set('selectedIndex', 0);
            
            // Submit form
            A.one('#<portlet:namespace />searchForm').submit();
        });
    });
    
    AUI().use('aui-node', function(A) {
	A.ready(function() {
		function validate() {
			var fromDate = A.one('#<portlet:namespace />dateFrom').val();
			var toDate = A.one('#<portlet:namespace />dateTo').val();
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			today = yyyy + '-' + mm + '-' + dd;

			if (new Date(fromDate) > new Date(today) || new Date(toDate) > new Date(today)) {
				A.one('#errorContainer').html('<liferay-ui:message key='future-dates-are-not-allowed' />').addClass('aui-message error');
				return false;
			}else{
				A.one('#errorContainer').html('').addClass('aui-message error');
			}

			if (new Date(fromDate) > new Date(toDate)) {
				A.one('#errorContainer').html('<liferay-ui:message key='from-date-cannot-be-later-than-to-date' />').addClass('aui-message error');
				return false;
			}else{
				A.one('#errorContainer').html('').addClass('aui-message error');
			}

			return true;
		}

		
		A.one('#<portlet:namespace />dateTo').on('change', function(e) {
			if (!validate()) {
				A.one('#<portlet:namespace />dateTo').val("");
			}
		});
		A.one('#<portlet:namespace />dateFrom').on('change', function(e) {
			if (!validate()) {
				A.one('#<portlet:namespace />dateFrom').val("");
			}
		});
	});
});
</aui:script>