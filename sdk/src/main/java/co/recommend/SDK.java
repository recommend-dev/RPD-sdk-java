package co.recommend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

/* 
 * Recommend API SDK
 */
public class SDK {
    private String APIKEY = "";
    private String APIURL = "https://api.recommend.co/apikeys";

    /*
     * Initialize SDK with your API key and optional custom url (used for testing)
     * @param   apiKey  Your Recommend API key
     * @param   customUrl   Leave empty for default API endpoint or specify custom for testing
     */
    public SDK(String apiKey, String customUrl) throws Exception {
        if (apiKey.isEmpty()) {
            throw new IllegalArgumentException("ApiKey cannot be empty");
        }

        APIKEY = apiKey;

        if (!customUrl.isEmpty()) {
            APIURL = customUrl;
            System.out.println("Using custom URL: " + customUrl);
        }
    }

    /*
     * Test connection to Recommend API
     * @return  Returns true if API key and connection parameters are ok, false if there is a problem with connection or API key
     */
    public Boolean TestConnection() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ApiKeyRequest req = new ApiKeyRequest();
            req.setApiToken(APIKEY);
            req.setCode("test-connection");

            String json = objectMapper.writeValueAsString(req);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(APIURL))
                    .header("cache-control", "no-cache")
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, BodyHandlers.ofString());

            if (response == null || response.statusCode() != 200)
                return false;

            ApiKeyResponse resp = objectMapper.readValue(response.body(), ApiKeyResponse.class);

            if (resp != null && resp.getStatus() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error testing connection");
            ex.printStackTrace();
            return false;
        }
    }

    /*
     * Send information about conversion to API
     * @param   code    Recommend referral code from URL
     * @param   email   Optional buyer email
     * @param   phone   Optional buyer phone
     * @param   orderNumber Optional order number
     * @param   cartTotal   Optional cart total
     * @return True if referral code is correct and conversion was recored on API, otherwise false
     */
    public Boolean ReferralCheck(String code, String email, String phone, String orderNumber, String cartTotal) throws Exception {
        if (code.isEmpty()) {
            throw new IllegalArgumentException("Referral code cannot be empty");
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ApiKeyRequest req = new ApiKeyRequest();
            req.setApiToken(APIKEY);
            req.setCode(code);

            if (!email.isEmpty()) {
                req.setEmail(email);
            }

            if (!phone.isEmpty()) {
                req.setPhone(phone);
            }

            if (!orderNumber.isEmpty()) {
                req.setOrderNumber(orderNumber);
            }

            if (!cartTotal.isEmpty()) {
                req.setOrderNumber(cartTotal);
            }

            String json = objectMapper.writeValueAsString(req);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(APIURL))
                    .header("cache-control", "no-cache")
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, BodyHandlers.ofString());

            if (response == null || response.statusCode() != 200)
                return false;

            ApiKeyResponse resp = objectMapper.readValue(response.body(), ApiKeyResponse.class);
            
            if (resp != null && resp.getStatus() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error checking referral");
            ex.printStackTrace();
            return false;
        }
    }
}