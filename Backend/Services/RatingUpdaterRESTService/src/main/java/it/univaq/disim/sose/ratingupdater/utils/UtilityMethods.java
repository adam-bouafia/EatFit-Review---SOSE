package it.univaq.disim.sose.ratingupdater.utils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.data.RatingUpdaterDAO;
import it.univaq.disim.sose.ratingupdater.model.RatingData;

// Utility class for rating updater service
public class UtilityMethods {

    // Method to check the integrity of the rating data to be added
    public static boolean IntegrityCheck(RatingData ratingDataToAdd) throws SQLException {
        
        // Retrieve all existing rating data
        List<RatingData> existingData = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingData();
        
        // Check if user has already inserted a rating for that food
        if (existingData != null) {
            for (RatingData record : existingData) {
                if (ratingDataToAdd.getFoodId().equals(record.getFoodId()) && ratingDataToAdd.getUserId() == record.getUserId()) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Method to build XML response
    public static String buildXMLResponse(String content, boolean inserted) {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        response += "<response><message>" + content + "</message><inserted>" + inserted + "</inserted></response>";
        return response;
    }
    
    // Method to calculate summary score based on weighted ratings
    public static double calculateSummaryScore(RatingData rates) {
        double[] weights = { 0.2, 0.2, 0.3, 0.2, 0.1 };
        double score = rates.getTasteRating() * weights[0] 
                + rates.getNutritionalvalueRating() * weights[1]
                + rates.getOverallsatisfactionRating() * weights[2]
                + rates.getPackagingRating() * weights[3]
                + rates.getPriceRating() * weights[4];
        consoleLog("calculated global score: " + score);
        return score;
    }
    
    // Method to log messages to the console
    public static void consoleLog(String message) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String whoAmI = "RatingUpdaterService";
        System.out.println(whoAmI + " [" + now + "] " + message);
    }
}
