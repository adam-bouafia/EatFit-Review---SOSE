package it.univaq.disim.sose.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.search.model.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

// Implementing the Search interface to provide the search functionality
public class SearchImpl implements Search {

    // Constants for API credentials and endpoint
    private static final String APP_ID = "7ad71579";
    private static final String API_KEY = "98f6a6aac1d2b1559580d0057468a38a";
    private static final String EdamamFoodSearchEndpoint = "https://api.edamam.com/api/food-database/v2/parser";

    // Method to search for food items based on a query
    @Override
    public List<Result> searchFood(String query) {
        // Construct the URL for the API request
        String urlEdamam = EdamamFoodSearchEndpoint + "?app_id=" + APP_ID + "&app_key=" + API_KEY + "&ingr=" + query;
        List<Result> results = new ArrayList<>();

        // Initialize OkHttpClient to make the API request
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(urlEdamam).method("GET", null).build();
        
        try {
            // Execute the request and get the response body
            ResponseBody response = client.newCall(request).execute().body();
            // Parse the response to extract the list of results
            results = arrayFoodsGenerator(response.string());
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace in case of an error
        }
        return results; // Return the list of results
    }

    // Helper method to parse the JSON response and generate a list of Result objects
    private List<Result> arrayFoodsGenerator(String edamamResponse) {
        // Parse the response string into a JSONObject
        JSONObject jsonObject = new JSONObject(edamamResponse);
        // Get the array of food hints from the JSON object
        JSONArray hintsArray = jsonObject.getJSONArray("hints");
        List<Result> results = new ArrayList<>();

        // Iterate through each hint in the hints array
        for (int i = 0; i < hintsArray.length(); i++) {
            JSONObject hint = hintsArray.getJSONObject(i);
            JSONObject food = hint.getJSONObject("food");

            // Create a new Result object and populate it with data from the JSON object
            Result result = new Result();
            result.setId(food.getString("foodId"));
            result.setLabel(food.getString("label"));
            result.setCategory(food.getString("category"));
            result.setCategoryLabel(food.getString("categoryLabel"));
            result.setImage(food.optString("image", ""));
            result.setBrand(food.optString("brand", ""));
            result.setNutrients(food.getJSONObject("nutrients"));

            // Add the result to the list
            results.add(result);
        }
        return results; // Return the list of results
    }
}
