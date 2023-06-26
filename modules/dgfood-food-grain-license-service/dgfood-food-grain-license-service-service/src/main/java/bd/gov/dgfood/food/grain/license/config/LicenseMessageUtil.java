package bd.gov.dgfood.food.grain.license.config;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.Dictionary;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = LicenseMessageUtil.class)
public class LicenseMessageUtil {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	public String getOtpMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String otpMessage = (String) licenseMessageConfiguration.get("otpMessage");
		return otpMessage;
	}

	public String getRenewLicenseFormSubmitMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String renewLicenseFormSubmitMessage = (String) licenseMessageConfiguration.get("renewLicenseFormSubmitMessage");
		return renewLicenseFormSubmitMessage;
	}
	
	public String getDuplicateLicenseFormSubmitMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String duplicateLicenseFormSubmitMessage = (String) licenseMessageConfiguration.get("duplicateLicenseFormSubmitMessage");
		return duplicateLicenseFormSubmitMessage;
	}
	
	public String getLicenseFormSubmitMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String licenseMessage = (String) licenseMessageConfiguration.get("formSubmitMessage");
		return licenseMessage;
	}
	
	public String getLicenseAcfApproveMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String acfApproveMessage = (String) licenseMessageConfiguration.get("acfApproveMessage");
		return acfApproveMessage;
	}
	
	public String getLicenseAcfRejectMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String acfRejectMessage = (String) licenseMessageConfiguration.get("acfRejectMessage");
		return acfRejectMessage;
	}
	
	public String getLicenseDcfApproveMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String dcfApproveMessage = (String) licenseMessageConfiguration.get("dcfApproveMessage");
		return dcfApproveMessage;
	}
	
	public String getLicenseDcfRejectMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String dcfRejectMessage = (String) licenseMessageConfiguration.get("dcfRejectMessage");
		return dcfRejectMessage;
	}
	
	public String getLicenseUcfApproveMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String ucfApproveMessage = (String) licenseMessageConfiguration.get("ucfApproveMessage");
		return ucfApproveMessage;
	}
	
	public String getLicenseUcfRejectMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String ucfRejectMessage = (String) licenseMessageConfiguration.get("ucfRejectMessage");
		return ucfRejectMessage;
	}
	
	public String getLicenseCcdrApproveMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String ccdrApproveMessage = (String) licenseMessageConfiguration.get("ccdrApproveMessage");
		return ccdrApproveMessage;
	}
	
	public String getLicenseCcdrRejectMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String ccdrRejectMessage = (String) licenseMessageConfiguration.get("ccdrRejectMessage");
		return ccdrRejectMessage;
	}
	
	public String getLicensePaymentRequestMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String paymentRequestMessage = (String) licenseMessageConfiguration.get("paymentRequestMessage");
		return paymentRequestMessage;
	}
	
	public String getLicensePaymentReceivedMessage() {
		Dictionary<String, Object> licenseMessageConfiguration = getLicenseMessageConfiguration();
		String paymentReceivedMessage = (String) licenseMessageConfiguration.get("paymentReceivedMessage");
		return paymentReceivedMessage;
	}
	
	private Dictionary<String, Object> getLicenseMessageConfiguration() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration(LicenseMessageConfiguration.class.getName());
			return configuration.getProperties();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
