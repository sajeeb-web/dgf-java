package bd.gov.dgfood.dealer.registration.config;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.Dictionary;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = DealerMessageUtil.class)
public class DealerMessageUtil {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	public String getDealerFormSubmitMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String dealerMessage = (String) dealerMessageConfiguration.get("formSubmitMessage");
		return dealerMessage;
	}
	
	public String getDealerAcfApproveMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String acfApproveMessage = (String) dealerMessageConfiguration.get("acfApproveMessage");
		return acfApproveMessage;
	}
	
	public String getDealerAcfRejectMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String acfRejectMessage = (String) dealerMessageConfiguration.get("acfRejectMessage");
		return acfRejectMessage;
	}
	
	public String getDealerDcfApproveMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String dcfApproveMessage = (String) dealerMessageConfiguration.get("dcfApproveMessage");
		return dcfApproveMessage;
	}
	
	public String getDealerDcfRejectMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String dcfRejectMessage = (String) dealerMessageConfiguration.get("dcfRejectMessage");
		return dcfRejectMessage;
	}
	
	public String getDealerUcfApproveMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String ucfApproveMessage = (String) dealerMessageConfiguration.get("ucfApproveMessage");
		return ucfApproveMessage;
	}
	
	public String getDealerUcfRejectMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String ucfRejectMessage = (String) dealerMessageConfiguration.get("ucfRejectMessage");
		return ucfRejectMessage;
	}
	
	public String getDealerRcfApproveMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String rcfApproveMessage = (String) dealerMessageConfiguration.get("rcfApproveMessage");
		return rcfApproveMessage;
	}
	
	public String getDealerRcfRejectMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String rcfRejectMessage = (String) dealerMessageConfiguration.get("rcfRejectMessage");
		return rcfRejectMessage;
	}
	
	public String getDealerCcdrApproveMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String ccdrApproveMessage = (String) dealerMessageConfiguration.get("ccdrApproveMessage");
		return ccdrApproveMessage;
	}
	
	public String getDealerCcdrRejectMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String ccdrRejectMessage = (String) dealerMessageConfiguration.get("ccdrRejectMessage");
		return ccdrRejectMessage;
	}
	
	public String getDealerPaymentRequestMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String paymentRequestMessage = (String) dealerMessageConfiguration.get("paymentRequestMessage");
		return paymentRequestMessage;
	}
	
	public String getDealerPaymentReceivedMessage() {
		Dictionary<String, Object> dealerMessageConfiguration = getDealerMessageConfiguration();
		String paymentReceivedMessage = (String) dealerMessageConfiguration.get("paymentReceivedMessage");
		return paymentReceivedMessage;
	}
	
	private Dictionary<String, Object> getDealerMessageConfiguration() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration(DealerMessageConfiguration.class.getName());
			return configuration.getProperties();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
