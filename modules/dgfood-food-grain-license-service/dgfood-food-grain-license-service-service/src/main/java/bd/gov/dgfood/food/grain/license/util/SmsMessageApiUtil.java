package bd.gov.dgfood.food.grain.license.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.SmsApiConfiguration;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;

@Component(service = SmsMessageApiUtil.class)
public class SmsMessageApiUtil {
	private static Log log = LogFactoryUtil.getLog(SmsMessageApiUtil.class);
	static HttpClient client = HttpClient.newHttpClient();
	
	@Reference
	private ConfigurationAdmin configurationAdmin;
	
	public boolean callSmsMessageApiByOtpId(long otpId) {
		boolean isSuccess = false;
		DgfUsersOtpDetails dgfUsersOtpDetails = null;
		try {
			dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.getDgfUsersOtpDetails(otpId);
		} catch (PortalException e1) {
			log.error("ERROR: "+e1.getMessage());
		}
		if(Validator.isNotNull(dgfUsersOtpDetails) && Validator.isNotNull(dgfUsersOtpDetails.getMessage()) && Validator.isNotNull(dgfUsersOtpDetails.getMobileNo())) {
			String message = dgfUsersOtpDetails.getMessage();
			String mobileNo = dgfUsersOtpDetails.getMobileNo();
			String urlWithParams = "";
			urlWithParams = getUrlWithParam(message, mobileNo, urlWithParams);	
				try {
					// set api request
					dgfUsersOtpDetails.setRequestUrl(urlWithParams);
					HttpResponse<String> response = getHttpResponse(urlWithParams);
					dgfUsersOtpDetails.setResponseStatusCode(response.statusCode());
					if (response.statusCode() == 200) {
						String responseData = response.body();
						// set response data
						dgfUsersOtpDetails.setResponseData(responseData);
						// get api response Result
						String responseResult = parseResponseData(responseData);
						dgfUsersOtpDetails.setResponseResult(responseResult);
						dgfUsersOtpDetails.setIsSent(true);
						dgfUsersOtpDetails.setOtpRequestTime(new Date());
						if(LicenseCommonConstant.SUCCESS.equals(responseResult.trim())) {
							isSuccess = true;
						}else {
							log.error("User SMS Sent failed");
						}
					}
					DgfUsersOtpDetailsLocalServiceUtil.updateDgfUsersOtpDetails(dgfUsersOtpDetails);
				} catch (Exception e) {
					log.error("Error: " + e.getMessage());
				}
			
		}
		return isSuccess;
	}

	private HttpResponse<String> getHttpResponse(String urlWithParams) throws IOException, InterruptedException {
		HttpResponse<String> response = client.send(request(urlWithParams),
				HttpResponse.BodyHandlers.ofString());
		return response;
	}

	private String getUrlWithParam(String message, String mobileNo, String urlWithParams) {
		Map<String, Object> map = new HashMap<>();
		Dictionary<String, Object> smsApiConfiguration = getSmsAPIConfiguration();
		String baseUrl = (String) smsApiConfiguration.get("baseUrl");
		String actionUrl = (String) smsApiConfiguration.get("actionUrl");
		if(Validator.isNotNull(baseUrl) && Validator.isNotNull(message) && Validator.isNotNull(mobileNo)) {
			String url = baseUrl + "/" + actionUrl;
			map = preparedRequestParam(smsApiConfiguration, message, mobileNo);
			urlWithParams = preparedRequestUrl(url, map);
		}else {
			log.error("SMS API base url not found");
		}
		return urlWithParams;
	}

	private String parseResponseData(String responseData) {
		String responseDataWithoutXml = responseData.substring(responseData.indexOf(">") + 1, responseData.lastIndexOf("<"));
		String[] values = responseDataWithoutXml.split(",");
		String responseResult = values[0];
		return responseResult;
	}

	public boolean callSmsMessageApi(String message, String mobileNo) {
		boolean isSuccess = false;
		String urlWithParams = "";
		urlWithParams = getUrlWithParam(message, mobileNo, urlWithParams);
			try {
				HttpResponse<String> response = client.send(request(urlWithParams),
						HttpResponse.BodyHandlers.ofString());
				if (response.statusCode() == 200) {
					isSuccess = true;
				}
			} catch (Exception e) {
				log.error("Error: " + e.getMessage());
			}
		
		return isSuccess;
	}

	private Map<String, Object> preparedRequestParam(Dictionary<String, Object> configData, String message, String mobileNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("mobile", mobileNo);
		map.put("op", configData.get("op"));
		map.put("user", configData.get("user"));
		map.put("pass", configData.get("pass"));
		map.put("sms", message);
		map.put("charset", configData.get("charset"));
		map.put("a_key", configData.get("apiKey"));
		map.put("p_key", configData.get("passKey"));
		map.put("cid", configData.get("cid"));
		return map;
	}

	private String preparedRequestUrl(String url, Map<String, Object> map) {
		StringBuilder urlBuilder = new StringBuilder(url);
		try {
			if (!map.isEmpty()) {
	            urlBuilder.append("?");
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	                String key = entry.getKey();
	                String value = (String) entry.getValue();
	                String encodedKey = URLEncoder.encode(key, "UTF-8");
	                String encodedValue = URLEncoder.encode(value, "UTF-8");
	                urlBuilder.append(encodedKey)
	                          .append("=")
	                          .append(encodedValue)
	                          .append("&");
	            }
	            // Remove the trailing "&"
	            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
	        }
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
        String finalUrl = urlBuilder.toString();
        return finalUrl;
	}
	private HttpRequest request(String url) {
		return HttpRequest.newBuilder().GET().header("Content-Type", "application/json")
				.timeout(Duration.ofSeconds(10)).uri(URI.create(url)).build();
	}
	
	private Dictionary<String, Object> getSmsAPIConfiguration() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration(SmsApiConfiguration.class.getName());
			return configuration.getProperties();
		} catch (IOException e) {
			 e.getMessage();
		}
		return null;
	}

}
