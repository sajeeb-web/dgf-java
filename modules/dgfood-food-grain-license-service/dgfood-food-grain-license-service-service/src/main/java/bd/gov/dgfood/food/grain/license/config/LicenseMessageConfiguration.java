package bd.gov.dgfood.food.grain.license.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "license-message-configure",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.food.grain.license.config.LicenseMessageConfiguration"
	)
public interface LicenseMessageConfiguration {
	
	@Meta.AD(
	        description = "Common OTP Message",
	        name = "otpMessage", required = true
	    )
	public String otpMessage();
	
	@Meta.AD(
	        description = "LMS Renew License Form Submit Message",
	        name = "renewLicenseFormSubmitMessage", required = true
	    )
	public String renewLicenseFormSubmitMessage();
	
	@Meta.AD(
	        description = "LMS Duplicate License Form Submit Message",
	        name = "duplicateLicenseFormSubmitMessage", required = true
	    )
	public String duplicateLicenseFormSubmitMessage();

	@Meta.AD(
	        description = "LMS new license form Submit Message",
	        name = "formSubmitMessage", required = true
	    )
	public String formSubmitMessage();

	@Meta.AD(
	        description = "LMS ACF Approved Message",
	        name = "acfApproveMessage", required = true
	    )
	public String acfApproveMessage();

	@Meta.AD(
	        description = "LMS ACF Reject Message",
	        name = "acfRejectMessage", required = true
	    )
	public String acfRejectMessage();
	
	@Meta.AD(
	        description = "LMS DCF Approve Message",
	        name = "dcfApproveMessage", required = true
	    )
	public String dcfApproveMessage();

	@Meta.AD(
	        description = "LMS DCF Reject Message",
	        name = "dcfRejectMessage", required = true
	    )
	public String dcfRejectMessage();

	@Meta.AD(
	        description = "LMS UCF Approve Message",
	        name = "ucfApproveMessage", required = true
	    )
	public String ucfApproveMessage();
	
	@Meta.AD(
	        description = "LMS UCF Reject Message",
	        name = "ucfRejectMessage", required = true
	    )
	public String ucfRejectMessage();
	
	@Meta.AD(
	        description = "LMS CCDR Approve Message",
	        name = "ccdrApproveMessage", required = true
	    )
	public String ccdrApproveMessage();
	
	@Meta.AD(
	        description = "LMS CCDR Reject Message",
	        name = "ccdrRejectMessage", required = true
	    )
	public String ccdrRejectMessage();
	
	@Meta.AD(
	        description = "LMS Payment Request Message",
	        name = "paymentRequestMessage", required = true
	    )
	public String paymentRequestMessage();
	
	@Meta.AD(
	        description = "LMS UCF Reject Message",
	        name = "paymentReceivedMessage", required = true
	    )
	public String paymentReceivedMessage();
	
	
}
