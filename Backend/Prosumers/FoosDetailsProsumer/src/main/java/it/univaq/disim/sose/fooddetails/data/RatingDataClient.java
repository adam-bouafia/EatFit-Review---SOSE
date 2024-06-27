package it.univaq.disim.sose.fooddetails.data;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.service.FoodDetailsAggregator;
import it.univaq.disim.sose.service.FoodDetailsAggregatorImplService;

public class RatingDataClient {

	// private static final String ReviewDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getRatingAvgs";
	
	public static AggregatedRatingData getRatingData(String foodId) {
		
		FoodDetailsAggregatorImplService service = new FoodDetailsAggregatorImplService();
		FoodDetailsAggregator port = service.getFoodDetailsAggregatorImplPort();
		
		it.univaq.disim.sose.service.AggregatedRatingData ratingAvg = port.aggregateRatings(foodId);
		
		AggregatedRatingData objToReturn = new AggregatedRatingData();
		objToReturn.setFoodId(ratingAvg.getFoodId());
		objToReturn.setUserId(ratingAvg.getUserId());
		objToReturn.setNutritionalvalueRating(ratingAvg.getNutritionalvalueRating());
		objToReturn.setPriceRating(ratingAvg.getPriceRating());
		objToReturn.setTasteRating(ratingAvg.getTasteRating());
		objToReturn.setOverallsatisfactionRating(ratingAvg.getOverallsatisfactionRating());
		objToReturn.setPackagingRating(ratingAvg.getPackagingRating());
		objToReturn.setGlobalScore(ratingAvg.getGlobalScore());
		objToReturn.setNumberOfRatings(ratingAvg.getNumberOfRatings());
		
		return objToReturn;
		
	}
	
}
