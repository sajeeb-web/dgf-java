package bd.gov.dgfood.dealer.registration.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "dealer-message-configure",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)

@Meta.OCD(
		id = "bd.gov.dgfood.dealer.registration.config.DealerMessageConfiguration"
	)
public interface DealerMessageConfiguration {

	@Meta.AD(
	        description = "DLR form Submit Message",
	        name = "formSubmitMessage", required = true
	    )
	public String formSubmitMessage();

	@Meta.AD(
	        description = "DLR ACF Approved Message",
	        name = "acfApproveMessage", required = true
	    )
	public String acfApproveMessage();

	@Meta.AD(
	        description = "DLR ACF Reject Message",
	        name = "acfRejectMessage", required = true
	    )
	public String acfRejectMessage();
	
	@Meta.AD(
	        description = "DLR DCF Approve Message",
	        name = "dcfApproveMessage", required = true
	    )
	public String dcfApproveMessage();

	@Meta.AD(
	        description = "DLR DCF Reject Message",
	        name = "dcfRejectMessage", required = true
	    )
	public String dcfRejectMessage();

	@Meta.AD(
	        description = "DLR UCF Approve Message",
	        name = "ucfApproveMessage", required = true
	    )
	public String ucfApproveMessage();
	
	@Meta.AD(
	        description = "DLR UCF Reject Message",
	        name = "ucfRejectMessage", required = true
	    )
	public String ucfRejectMessage();
	
	
	@Meta.AD(
	        description = "DLR RCF Approve Message",
	        name = "rcfApproveMessage", required = true
	    )
	public String rcfApproveMessage();
	
	@Meta.AD(
	        description = "DLR RCF Reject Message",
	        name = "rcfRejectMessage", required = true
	    )
	public String rcfRejectMessage();
	
	@Meta.AD(
	        description = "DLR CCDR Approve Message",
	        name = "ccdrApproveMessage", required = true
	    )
	public String ccdrApproveMessage();
	
	@Meta.AD(
	        description = "DLR CCDR Reject Message",
	        name = "ccdrRejectMessage", required = true
	    )
	public String ccdrRejectMessage();
	
	@Meta.AD(
	        description = "DLR Payment Request Message",
	        name = "paymentRequestMessage", required = true
	    )
	public String paymentRequestMessage();
	
	@Meta.AD(
	        description = "DLR UCF Reject Message",
	        name = "paymentReceivedMessage", required = true
	    )
	public String paymentReceivedMessage();
	
	
}
