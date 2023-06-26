<script type="text/javascript">
	/* toggleChanges for OMS type */
    function toggleOmsField(dealerType) {
       var div = document.getElementById('omsDealerShipSubType');
       if (dealerType === 'OMS') {
           div.style.display = 'block'; // show the div
       } else {
           div.style.display = 'none'; // hide the div
       }
   }
   document.addEventListener('DOMContentLoaded', function() {
       var dealerType = 'OMS'; // default selection
       toggleOmsField(dealerType);
   });

	/* toggleChanges for marital status */
	     function toggleMaritalField(dealerType) {
	        var div = document.getElementById('spouse_details');
	        if (dealerType === 'Married') {
	            div.style.display = 'block'; // show the div
	        } else {
	            div.style.display = 'none'; // hide the div
	        }
	    }
	    document.addEventListener('DOMContentLoaded', function() {
	        var dealerType = 'Married'; // default selection
	        toggleMaritalField(dealerType);
	    });
	    
	    //shop details page js
		 /* toggleChanges for physical challanged */
	     function togglePhysicalField(dealerType) {
	        var div = document.getElementById('physclyChlngdDocField');
	        if (dealerType === 1) {
	            div.style.display = 'block'; // show the div
	        } else {
	            div.style.display = 'none'; // hide the div
	        }
	    }
	    document.addEventListener('DOMContentLoaded', function() {
	        var dealerType = 1; // default selection
	        togglePhysicalField(dealerType);
	    });
		 
		 //dlrRunShpHimself
		 function showFamilyDetails(){
			  var dlrNotRunShpHimselfDtls = document.getElementById("dlrNotRunShpHimselfDtls");
			  dlrNotRunShpHimselfDtls.style.display="block";
		}
		 function hideFamilyDetails(){
			  var dlrNotRunShpHimselfDtls = document.getElementById("dlrNotRunShpHimselfDtls");
			  dlrNotRunShpHimselfDtls.style.display="none";
		 }
		
</script>