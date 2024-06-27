package it.univaq.disim.sose.ratingupdater.service;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.data.RatingUpdaterDAO;
import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData;
import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

public class RatingUpdaterService {
	
	private static RatingUpdaterService instance;
	
	private RatingUpdaterService() {
		
	}
	
	public static synchronized RatingUpdaterService getInstance() {
		if (instance == null) {
			instance = new RatingUpdaterService();
		}
		return instance;
	}
	
	@SuppressWarnings("unused")
	private boolean checkExistingUserWithToken() {
		// Implement Async Callback to check 
		return true;
	}

	public boolean addRating(RatingData toAdd) throws Exception {
		UtilityMethods.consoleLog("Adding: " + toAdd.toString());
		
		if (!UtilityMethods.IntegrityCheck(toAdd)) return false;
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().insertRatingData(toAdd);
	}
	
	public boolean updateGlobalScore(RatingData newRatingData) {
		
		GlobalScoreData score = RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(newRatingData.getFoodId());
		UtilityMethods.consoleLog("score " + score);
		
		if (score == null) {
			// Score does not exists : INSERT
			score = new GlobalScoreData(
					newRatingData.getFoodId(),
					UtilityMethods.calculateSummaryScore(newRatingData),
					1);
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		else {
			// UPDATE
			double newGlobalScore = (score.getGlobalScore() * score.getNumberOfRatings() + UtilityMethods.calculateSummaryScore(newRatingData)) / (score.getNumberOfRatings() + 1);
			
			score.setNumberOfRatings(score.getNumberOfRatings() + 1);
			score.setGlobalScore(newGlobalScore);
			
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		
	}
	
	public RatingData getRatingAverages(String foodId) throws Exception {
		List<RatingData> foodRatings = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFoodId(foodId);
		
		RatingData average = new RatingData(foodId, -1, 0, 0, 0, 0, 0);
		average.setTasteRating(new Double(foodRatings.stream().mapToInt(p -> p.getTasteRating()).average().orElse(0)).intValue());
		average.setNutritionalvalueRating(new Double(foodRatings.stream().mapToInt(p -> p.getNutritionalvalueRating()).average().orElse(0)).intValue());
		average.setOverallsatisfactionRating(new Double(foodRatings.stream().mapToInt(p -> p.getOverallsatisfactionRating()).average().orElse(0)).intValue());
		average.setPackagingRating(new Double(foodRatings.stream().mapToInt(p -> p.getPackagingRating()).average().orElse(0)).intValue());
		average.setPriceRating(new Double(foodRatings.stream().mapToInt(p -> p.getPriceRating()).average().orElse(0)).intValue());
		return average;
		
	}
	
	public List<RatingData> getAllRatings(String foodId) throws Exception {
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFoodId(foodId);
	}
	
	public GlobalScoreData getGlobalScore(String foodId) throws Exception {
		return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(foodId);
	}
}
