<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />


<script>
	function showCommentsModal(transitionName, transitionLabel) {
		// Show the pop-up
		var comments ="Add Comments";
		if(transitionLabel.includes("PAYMENT")) {
			comments = "<liferay-ui:message key='payment_request' />";
		} else if(transitionLabel.includes("APPROVED")){
			comments = "<liferay-ui:message key='approved' />";
		}else if(transitionLabel.includes("REJECT")){
			comments = "<liferay-ui:message key='reject' />";
		}
		
		AUI().use(
				'aui-modal',
				function(A) {
					A.one('#<portlet:namespace/>transitionName').set('value',
							transitionName);
					A.one('#<portlet:namespace/>transitionLabel').set('value',
							transitionLabel);
					var modal = new A.Modal({
						bodyContent : A.one("#approved-comments-popup").html(),
						headerContent : comments,
						centered : true,
						modal : true,
						render : '#render-approved-comments-popup',
						tools : [ {
							handler : function() {
								this.hide();
							},
							label : 'Close'
						} ]
					}).render();
					
					modal.on('visibleChange', function(event) {
				        if (!event.newVal) {
				        	const myNode = document.getElementById("render-approved-comments-popup");
				        	  myNode.innerHTML  = '';
				        }
				    });
				});
	}
</script>
