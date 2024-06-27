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

public class SearchImpl implements Search {

    private static final String APP_ID = "7ad71579";
    private static final String API_KEY = "98f6a6aac1d2b1559580d0057468a38a";
    private static final String EdamamFoodSearchEndpoint = "https://api.edamam.com/api/food-database/v2/parser";

    public List<Result> searchFood(String query) {
        String urlEdamam = EdamamFoodSearchEndpoint + "?app_id=" + APP_ID + "&app_key=" + API_KEY + "&ingr=" + query;
        List<Result> results = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(urlEdamam).method("GET", null).build();
        try {
            ResponseBody response = client.newCall(request).execute().body();
            results = arrayFoodsGenerator(response.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    private List<Result> arrayFoodsGenerator(String edamamResponse) {
        JSONObject jsonObject = new JSONObject(edamamResponse);
        JSONArray hintsArray = jsonObject.getJSONArray("hints");
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < hintsArray.length(); i++) {
            JSONObject hint = hintsArray.getJSONObject(i);
            JSONObject food = hint.getJSONObject("food");

            Result result = new Result();
            result.setId(food.getString("foodId"));
            result.setLabel(food.getString("label"));
            result.setCategory(food.getString("category"));
            result.setCategoryLabel(food.getString("categoryLabel"));
            result.setImage(food.optString("image", ""));
            result.setBrand(food.optString("brand", ""));
            result.setNutrients(food.getJSONObject("nutrients"));

            results.add(result);
        }
        return results;
    }
}
