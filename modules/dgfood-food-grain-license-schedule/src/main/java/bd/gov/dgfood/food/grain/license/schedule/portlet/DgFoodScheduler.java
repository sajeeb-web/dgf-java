package bd.gov.dgfood.food.grain.license.schedule.portlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class DgFoodScheduler {
	
	public static void main(String[] args) {
        try {
            Random rand = new Random();
            int randomNumber = rand.nextInt(9999 - 1111 + 1) + 1111;
            long p_key = (long) (rand.nextDouble() * (9999999999999999L - 111111111111111L)) + 111111111111111L;

            // Assume the mobile number is given here
            String mobile = "1234567890";

            String requestId = randomString(10);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            Map<String, String> params = new HashMap<>();
            params.put("mobile", mobile);
            params.put("op", "SMS");
            params.put("user", "dgfood2");
            params.put("pass", "password");
            params.put("sms", "USE " + randomNumber + " AS OTP FOR COMPLETING THE FFP REGISTRATION-DGFOOD");
            params.put("charset", "UTF-8");
            params.put("a_key", String.valueOf(p_key + 32));
            params.put("p_key", String.valueOf(randomNumber));
            params.put("cid", requestId);
            params.put("smsclass","OTP");

            String directApiUrl = "http://bulksms1.teletalk.com.bd:8091/link_sms_send.php";

            StringJoiner sj = new StringJoiner("&");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sj.add(entry.getKey() + "=" + entry.getValue());
            }

            URL url = new URL(directApiUrl + "?" + sj.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            System.out.println("HTTP response code: " + status);
            System.out.println("HTTP response body: " + content.toString());
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String randomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return result.toString();
    }

}
