package it.univaq.disim.sose.ratingupdater.service;

import java.util.List;

import it.univaq.disim.sose.ratingupdater.data.RatingUpdaterDAO;
import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData;
import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

// Service class for rating update operations
public class RatingUpdaterService {
	
	// Singleton instance
	private static RatingUpdaterService instance;
	
	// Private constructor to prevent instantiation
	private RatingUpdaterService() {
		
	}
	
	// Method to get the singleton instance of the service
	public static synchronized RatingUpdaterService getInstance() {
		if (instance == null) {
			instance = new RatingUpdaterService();
		}
		return instance;
	}
	
	// Placeholder method for checking existing user with token
	@SuppressWarnings("unused")
	private boolean checkExistingUserWithToken() {
		// Implement Async Callback to check 
		return true;
	}

	// Method to add a rating
	public boolean addRating(RatingData toAdd) throws Exception {
		// Log the rating data
		UtilityMethods.consoleLog("Adding: " + toAdd.toString());
		
		// Check data integrity
		if (!UtilityMethods.IntegrityCheck(toAdd)) return false;
		
		// Insert the rating data
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().insertRatingData(toAdd);
	}
	
	// Method to update the global score
	public boolean updateGlobalScore(RatingData newRatingData) {
		
		// Read the existing global score
		GlobalScoreData score = RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(newRatingData.getFoodId());
		UtilityMethods.consoleLog("score " + score);
		
		if (score == null) {
			// Score does not exist: INSERT
			score = new GlobalScoreData(
					newRatingData.getFoodId(),
					UtilityMethods.calculateSummaryScore(newRatingData),
					1);
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		} else {
			// UPDATE existing score
			double newGlobalScore = (score.getGlobalScore() * score.getNumberOfRatings() + UtilityMethods.calculateSummaryScore(newRatingData)) / (score.getNumberOfRatings() + 1);
			
			score.setNumberOfRatings(score.getNumberOfRatings() + 1);
			score.setGlobalScore(newGlobalScore);
			
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
	}
	
	// Method to get the average ratings for a food item
	public RatingData getRatingAverages(String foodId) throws Exception {
		List<RatingData> foodRatings = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFoodId(foodId);
		
		// Calculate average ratings
		RatingData average = new RatingData(foodId, -1, 0, 0, 0, 0, 0);
		average.setTasteRating(new Double(foodRatings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
		average.setNutritionalvalueRating(new Double(foodRatings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
		average.setOverallsatisfactionRating(new Double(foodRatings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
		average.setPackagingRating(new Double(foodRatings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
		average.setPriceRating(new Double(foodRatings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());
		return average;
	}
	
	// Method to get all ratings for a food item
	public List<RatingData> getAllRatings(String foodId) throws Exception {
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFoodId(foodId);
	}
	
	// Method to get the global score for a food item
	public GlobalScoreData getGlobalScore(String foodId) throws Exception {
		return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(foodId);
	}
}
