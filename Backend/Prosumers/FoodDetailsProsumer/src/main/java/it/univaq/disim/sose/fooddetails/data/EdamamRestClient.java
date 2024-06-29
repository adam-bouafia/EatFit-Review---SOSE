package it.univaq.disim.sose.fooddetails.data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.FoodData;
import it.univaq.disim.sose.model.FoodData.ServingSize;
import it.univaq.disim.sose.model.FoodData.Nutrients;
import it.univaq.disim.sose.util.Utility;

public class EdamamRestClient {

    // API key and application ID for Edamam API
    private static final String APIKey = "98f6a6aac1d2b1559580d0057468a38a";
    private static final String APP_ID = "k_dm7b3skf";
    
    // Endpoint for Edamam Food Details API
    private static final String EdamamFoodDetailsEndpoint = "https://api.edamam.com/api/food-database/v2/nutrients";
    
    // Method to build the complete URL for API requests
    private static String buildURL() {
        return EdamamFoodDetailsEndpoint + "?app_id=" + APP_ID + "&app_key=" + APIKey;
    }
    
    // Method to fetch food data from Edamam API given a foodId
    public static FoodData getFoodData(String foodId) {
        WebClient client = WebClient.create(buildURL());
        
        // Constructing the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("ingredients", new JSONArray().put(new JSONObject()
            .put("quantity", 1)
            .put("foodId", foodId)
        ));

        // Sending POST request to Edamam API
        Response edamamResponse = client.accept(MediaType.APPLICATION_JSON)
                                        .post(requestBody.toString());
        
        // Reading and parsing the response
        String responseString = edamamResponse.readEntity(String.class);
        JSONObject jsonObject = new JSONObject(responseString);
        
        // Creating FoodData object from the response
        FoodData toReturn = new FoodData();
        JSONObject parsedFood = jsonObject.getJSONArray("ingredients").getJSONObject(0);
        
        // Setting various properties of FoodData from the parsed JSON response
        toReturn.setFoodId(parsedFood.getString("foodId"));
        toReturn.setLabel(parsedFood.getString("label"));
        toReturn.setKnownAs(parsedFood.optString("knownAs", ""));
        toReturn.setCategory(parsedFood.getString("category"));
        toReturn.setCategoryLabel(parsedFood.getString("categoryLabel"));
        toReturn.setBrand(parsedFood.optString("brand", ""));
        toReturn.setFoodContentsLabel(parsedFood.optString("foodContentsLabel", ""));
        toReturn.setImage(parsedFood.optString("image", ""));
        
        // Parse serving sizes if available
        if (parsedFood.has("servingSizes")) {
            JSONArray servingSizesArray = parsedFood.getJSONArray("servingSizes");
            for (int i = 0; i < servingSizesArray.length(); i++) {
                JSONObject servingSizeObject = servingSizesArray.getJSONObject(i);
                ServingSize servingSize = new ServingSize();
                servingSize.setUri(servingSizeObject.getString("uri"));
                servingSize.setLabel(servingSizeObject.getString("label"));
                servingSize.setQuantity(servingSizeObject.getDouble("quantity"));
                toReturn.getServingSizes().add(servingSize);
            }
        }

        // Parse nutrients
        if (parsedFood.has("nutrients")) {
            JSONObject nutrientsObject = parsedFood.getJSONObject("nutrients");
            Nutrients nutrients = new Nutrients();
            nutrients.setENERC_KCAL(nutrientsObject.optDouble("ENERC_KCAL", 0));
            nutrients.setPROCNT(nutrientsObject.optDouble("PROCNT", 0));
            nutrients.setFAT(nutrientsObject.optDouble("FAT", 0));
            nutrients.setCHOCDF(nutrientsObject.optDouble("CHOCDF", 0));
            nutrients.setFIBTG(nutrientsObject.optDouble("FIBTG", 0));
            toReturn.setNutrients(nutrients);
        }
        
        // Logging the returned object
        Utility.consoleLog("Returned Object from id " + foodId +  " ==> " + toReturn.toString());
        
        return toReturn;
    }
    
    // Simulated method for testing purposes to return dummy food data
    public static FoodData getFoodDataSimulated(String foodId) {
        // Simulated JSON response
        String testJSON = "{ \"ingredients\": [ { \"parsed\": { \"foodId\": \"food_a1b2c3d4\", \"label\": \"Apple\", \"category\": \"Generic foods\", \"categoryLabel\": \"fruit\", \"brand\": \"\", \"foodContentsLabel\": \"\", \"image\": \"\" } } ] }";
        
        JSONObject jsonObject = new JSONObject(testJSON);
        JSONObject parsedFood = jsonObject.getJSONArray("ingredients").getJSONObject(0).getJSONObject("parsed");

        FoodData toReturn = new FoodData();
        toReturn.setFoodId(parsedFood.getString("foodId"));
        toReturn.setLabel(parsedFood.getString("label"));
        toReturn.setKnownAs(parsedFood.optString("knownAs", ""));
        toReturn.setCategory(parsedFood.getString("category"));
        toReturn.setCategoryLabel(parsedFood.getString("categoryLabel"));
        toReturn.setBrand(parsedFood.optString("brand", ""));
        toReturn.setFoodContentsLabel(parsedFood.optString("foodContentsLabel", ""));
        toReturn.setImage(parsedFood.optString("image", ""));
        
        Utility.consoleLog(toReturn.toString());
        
        return toReturn;
    }
}
