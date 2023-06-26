package bd.gov.dgfood.food.grain.license.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FortnightReportDUtil {
	

	private static Log _log = LogFactoryUtil.getLog(GenerateLicenseReportUtil.class);
	static HttpClient client = HttpClient.newHttpClient();

	public static byte[] getLicenseReport(String queryParams) {
		Map<String, Object> map = new HashMap<>();
		ResourceBundle bundle = ResourceBundle.getBundle("jasper-config");
		String baseUrl = bundle.getString("jasper.server.host.base.url");
		String url = baseUrl + "/jasperserver/rest_v2/reports/reports/FFP/food_grain_license_form_gha.pdf";
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
			_log.error("getLicenseReport error======" + e.getMessage());
		}
		return null;
	}

	private static HttpRequest request(String url, Map<String, Object> map) {
		// .header("Authorization", "Basic " +
		// Base64.getEncoder().encodeToString("mobileapp:j@spermobile@pp".getBytes()))
		String token = preparedToken();
		return HttpRequest.newBuilder().GET().header("Content-Type", "application/pdf")
				.header("Authorization",
						"Basic " + token)
				.timeout(Duration.ofSeconds(10)).uri(URI.create(url)).build();
	}

	private static String preparedToken() {
		ResourceBundle bundle = ResourceBundle.getBundle("jasper-config");
		String jasperServerUsername = bundle.getString("jasper.server.username");
		String jasperServerPassword = bundle.getString("jasper.server.password");
		String tokenSecret = jasperServerUsername+":"+jasperServerPassword;
		String token = Base64.getEncoder().encodeToString(tokenSecret.getBytes());
		return token;
		
	}

}
