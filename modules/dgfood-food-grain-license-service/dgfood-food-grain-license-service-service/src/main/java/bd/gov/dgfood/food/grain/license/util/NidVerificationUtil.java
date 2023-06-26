package bd.gov.dgfood.food.grain.license.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class NidVerificationUtil {
	private static Log _log = LogFactoryUtil.getLog(NidVerificationUtil.class);
	static HttpClient client = HttpClient.newHttpClient();

	 private static String getRequestId(Map<String, Object> map, String baseUrl) {
			 String url = baseUrl+"/api/v1/public/initiate-request";
			  try {
					HttpResponse<String> response = client.send(request(url,map), HttpResponse.BodyHandlers.ofString());
					if(response.statusCode() == 200) {
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.body());
						if(jsonObject != null) {
							return jsonObject.getString("requestId");
						} 
					}
		        } catch (Exception e) {
		        	_log.error("getRequestId nid error======"+e.getMessage());
				}
		return null;
	 }
	 
	
	 public static boolean checkStatus(Map<String, Object> map, String baseUrl) {

		 String requestId = getRequestId(map, baseUrl);
		 map = new HashMap<>();
		 map.put("requestId", requestId);

		 String url = baseUrl+"/api/v1/public/check-status";
		 
	        HttpRequest request = request(url,map);
	        for (int i=0; i<5; i++) {
		        try {
		        	Thread.sleep(1000);
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					if(response.statusCode() == 200) {
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.body());
						if(jsonObject != null) {
							if("READY".equals(jsonObject.getString("status"))) {
								return true;
							}
						}
					}
		        } catch (Exception e) {
		        	_log.error("checkStatus nid data error======"+e.getMessage());
				}
				}
		return false;
	 }
	 
	public static JSONArray fetchData(Map<String, Object> map, String baseUrl) {
		 String requestId = getRequestId(map, baseUrl);
		 map = new HashMap<>();
		 map.put("requestId", requestId);
		 String url = baseUrl+"/api/v1/public/fetch-data";
		 HttpRequest request = request(url,map);
		 JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			for (int i=0; i<5; i++) {
		        try {
		        	Thread.sleep(1000);
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					if(response.statusCode() == 200) {
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.body());
						if(jsonObject != null) {
							JSONObject data = jsonObject.getJSONObject("data");
							if(data != null && data.length() >0 ) {
								int statusCode =data.getJSONObject("nid").getInt("statusCode");
								if(statusCode == 200) {
									 jsonArray = data.getJSONObject("nid").getJSONArray("responseRecords");// need check
									if(jsonArray != null) {
										return jsonArray;
									}
								}
								break;
							}
						}
					}
		        } catch (Exception e) {
		        	_log.error("fetch nid data error======"+e.getMessage());
				}
			}
		return jsonArray;
	}
	
	 private static HttpRequest request(String url, Map<String, Object> map) {
		 return HttpRequest.newBuilder()
	                .POST(buildFormDataFromMap(map))
	                .header("Content-Type", "application/json")
	                .timeout(Duration.ofSeconds(10))
	                .uri(URI.create(url))
	                .build();
	}

	private static BodyPublisher buildFormDataFromMap(Map<String, Object> map) {
		 
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			String requestBody = objectMapper
			          .writerWithDefaultPrettyPrinter()
			          .writeValueAsString(map);
			return BodyPublishers.ofString(requestBody);
		} catch (JsonProcessingException e) {
			_log.error("requestBody error===="+e.getMessage());
		}
			return null;
		}
	
	//use just for test purpose
	public static JSONArray getJsonData() {
        JSONArray responseRecordsArray = JSONFactoryUtil.createJSONArray();
        
        JSONObject jsonDetails = JSONFactoryUtil.createJSONObject();
        jsonDetails.put("mouzaOrMoholla", "à¦°à¦¾à¦œà¦¨à¦—à¦°");
        jsonDetails.put("occupation", "à¦›à¦¾");
        jsonDetails.put("gender", "male");
        jsonDetails.put("father", "Md. Mimdadul Islam");
        jsonDetails.put("mother", "Mst. Nurjahan Begum");
        jsonDetails.put("dateOfBirth", "1993-11-25");
        jsonDetails.put("nameEn", "Noman Ibne Mimdad");
        jsonDetails.put("nid17Digit", "19892691649122803");
        jsonDetails.put("bloodGroup", "B+");
        jsonDetails.put("name", "noman ahmed");
        jsonDetails.put("nid10Digit", "2833318767");
        jsonDetails.put("region", "à¦°à¦¾à¦œà¦¶à¦¾à¦¹à§€");
        
        
        JSONObject jsoPresentAddress = JSONFactoryUtil.createJSONObject();

        jsoPresentAddress.put("mouzaOrMoholla", "à¦ªà¦¾à§œà¦¾");
        jsoPresentAddress.put("rmoCode", "2");
        jsoPresentAddress.put("additionalVillageOrRoad", "");
        jsoPresentAddress.put("postalCode", "à§«à§ªà§­à§¦");
        jsoPresentAddress.put("division", "à¦°à¦‚à¦ªà§�à¦°");
        jsoPresentAddress.put("district", "à¦°à¦‚à¦ªà§�à¦°");
        jsoPresentAddress.put("cityCorporationOrMunicipality", "à¦ªà§€à¦°à¦—");
        jsoPresentAddress.put("rmo", "pouroshava");
        jsoPresentAddress.put("upozila", "à¦ªà§€à¦°à¦—");
        jsoPresentAddress.put("unionOrWard", "à¦“à§Ÿà¦¾à¦¡-2");
        jsoPresentAddress.put("wardForUnionPorishod", "2");
        jsoPresentAddress.put("region", "à¦°à¦‚à¦ªà§�à¦°");
        jsoPresentAddress.put("villageOrRoad", "454");
        jsoPresentAddress.put("postOffice", "à¦ªà§€à¦°à¦—");
        jsoPresentAddress.put("homeOrHoldingNo", "-");
        jsonDetails.put("presentAddress", jsoPresentAddress);
        
        JSONObject jsonPermanenttAddress = JSONFactoryUtil.createJSONObject();
        jsonPermanenttAddress.put("mouzaOrMoholla", "à¦ªà¦¾à§œà¦¾");
        jsonPermanenttAddress.put("rmoCode", "2");
        jsonPermanenttAddress.put("additionalVillageOrRoad", "");
        jsonPermanenttAddress.put("postalCode", "à§«à§ªà§­à§¦");
        jsonPermanenttAddress.put("division", "à¦°à¦‚à¦ªà§�à¦°");
        jsonPermanenttAddress.put("district", "à¦°à¦‚à¦ªà§�à¦°");
        jsonPermanenttAddress.put("cityCorporationOrMunicipality", "à¦ªà§€à¦°à¦—");
        jsonPermanenttAddress.put("rmo", "pouroshava");
        jsonPermanenttAddress.put("upozila", "à¦ªà§€à¦°à¦—");
        jsonPermanenttAddress.put("unionOrWard", "à¦“à§Ÿà¦¾à¦¡-2");
        jsonPermanenttAddress.put("wardForUnionPorishod", "2");
        jsonPermanenttAddress.put("region", "à¦°à¦‚à¦ªà§�à¦°");
        jsonPermanenttAddress.put("villageOrRoad", "454");
        jsonPermanenttAddress.put("postOffice", "à¦ªà§€à¦°à¦—");
        jsonPermanenttAddress.put("homeOrHoldingNo", "-");

        jsonDetails.put("permanentAddress", jsonPermanenttAddress);
        responseRecordsArray.put(jsonDetails);
        return responseRecordsArray;
    }
}
