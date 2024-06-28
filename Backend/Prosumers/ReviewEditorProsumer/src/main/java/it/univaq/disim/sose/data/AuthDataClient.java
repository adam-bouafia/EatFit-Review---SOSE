package it.univaq.disim.sose.data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

// AuthDataClient class for handling authentication-related HTTP requests
public class AuthDataClient {

    // URL of the authentication service
    private static final String AuthServiceUrl = "http://localhost:8080/AuthService/rest/Auth/checkToken";
    
    // Method to check the validity of a user token
    public static String checkToken(String userToken) {
        
        // Create a WebClient instance for the authentication service URL with the user token
        WebClient client = WebClient.create(AuthServiceUrl + "?token=" + userToken);
        
        // Send a GET request and accept a response of type JSON
        Response response = client.accept(MediaType.APPLICATION_JSON).get();
        
        // Read the response entity as a string and convert it to a JSONObject
        JSONObject jsonObject = new JSONObject(response.readEntity(String.class));
        
        // Return the "Response" field from the JSON object
        return jsonObject.getString("Response");
    }
}
