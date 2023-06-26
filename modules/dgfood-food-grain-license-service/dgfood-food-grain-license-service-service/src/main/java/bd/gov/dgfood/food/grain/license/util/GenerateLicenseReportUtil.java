package bd.gov.dgfood.food.grain.license.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.JasperReportConfiguration;

@Component(service = GenerateLicenseReportUtil.class)
public class GenerateLicenseReportUtil {
	private static Log log = LogFactoryUtil.getLog(GenerateLicenseReportUtil.class);
	static HttpClient client = HttpClient.newHttpClient();
	
	@Reference
	private ConfigurationAdmin configurationAdmin;

	public byte[] getLicenseReport(String queryParams) {
		Map<String, Object> map = new HashMap<>();
		Dictionary<String, Object> jasperReportConfiguration = getJasperReportConfiguration();
		String baseUrl = (String) jasperReportConfiguration.get("baseUrl");
		if(Validator.isNotNull(baseUrl)) {
			String url = baseUrl + "/jasperserver/rest_v2/reports/reports/FFP/fgl_report.pdf";
			String urlWithParams = url + "?license_no=" + queryParams.toString();

			try {
				HttpResponse<InputStream> response = client.send(request(urlWithParams, map),
						HttpResponse.BodyHandlers.ofInputStream());
				if (response.statusCode() == 200) {
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

					byte[] buffer = new byte[1024];
					int length;
					while ((length = response.body().read(buffer)) != -1) {
						outputStream.write(buffer, 0, length);
					}

					byte[] byteArray = outputStream.toByteArray();
					return byteArray;
				}
			} catch (Exception e) {
				log.error("GetLicenseReport Error: " + e.getMessage());
			}
		}else {
			log.error("License Report base url not found");
		}
		return null;
	}

	private HttpRequest request(String url, Map<String, Object> map) {
		String token = preparedToken();
		return HttpRequest.newBuilder().GET().header("Content-Type", "application/pdf")
				.header("Authorization",
						"Basic " + token)
				.timeout(Duration.ofSeconds(10)).uri(URI.create(url)).build();
	}

	private String preparedToken() {
		Dictionary<String, Object> jasperReportConfiguration = getJasperReportConfiguration();
		String jasperServerUsername = (String) jasperReportConfiguration.get("userName");
		String jasperServerPassword = (String) jasperReportConfiguration.get("password");
		String token = "";
		if(Validator.isNotNull(jasperServerUsername) && Validator.isNotNull(jasperServerPassword)) {
			String tokenSecret = jasperServerUsername+":"+jasperServerPassword;
			token = Base64.getEncoder().encodeToString(tokenSecret.getBytes());
		}
		return token;
		
	}
	
	private Dictionary<String, Object> getJasperReportConfiguration() {
		try {
			Configuration configuration = configurationAdmin.getConfiguration(JasperReportConfiguration.class.getName());
			return configuration.getProperties();
		} catch (IOException e) {
			 e.getMessage();
		}
		return null;
	}

}
