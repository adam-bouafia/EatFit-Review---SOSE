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

    private static final String APIKey = "YOUR_APP_KEY";
    private static final String APP_ID = "YOUR_APP_ID";
    
    private static final String EdamamFoodDetailsEndpoint = "https://api.edamam.com/api/food-database/v2/nutrients";
    
    private static String buildURL() {
        return EdamamFoodDetailsEndpoint + "?app_id=" + APP_ID + "&app_key=" + APIKey;
    }
    
    public static FoodData getFoodData(String foodId) {
        WebClient client = WebClient.create(buildURL());
        
        JSONObject requestBody = new JSONObject();
        requestBody.put("ingredients", new JSONArray().put(new JSONObject()
            .put("quantity", 1)
            .put("foodId", foodId)
        ));

        Response edamamResponse = client.accept(MediaType.APPLICATION_JSON)
                                        .post(requestBody.toString());
        
        String responseString = edamamResponse.readEntity(String.class);
        JSONObject jsonObject = new JSONObject(responseString);
        
        FoodData toReturn = new FoodData();
        JSONObject parsedFood = jsonObject.getJSONArray("ingredients").getJSONObject(0);
        
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
        
        Utility.consoleLog("Returned Object from id " + foodId +  " ==> " + toReturn.toString());
        
        return toReturn;
    }
    
    public static FoodData getFoodDataSimulated(String foodId) {
        // Simulated data for testing purposes
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
