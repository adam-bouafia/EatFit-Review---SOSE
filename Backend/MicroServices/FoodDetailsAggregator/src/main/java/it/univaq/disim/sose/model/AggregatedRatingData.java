package it.univaq.disim.sose.model;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;



@Data
public class AggregatedRatingData {

    // Unique identifier for the food item
    private String foodId;
    
    // Unique identifier for the user who provided the rating
    private int userId;
    
    // Ratings parameters
    private int tasteRating;
    private int nutritionalvalueRating;
    private int overallsatisfactionRating;
    private int packagingRating;
    private int priceRating;
    
    // Aggregated data
    private double globalScore;
    private int numberOfRatings;
    
    // Constructor with parameters to initialize the fields
    public AggregatedRatingData(String foodId, int userId, int tasteRating, int nutritionalvalueRating,
                                int overallsatisfactionRating, int packagingRating, int priceRating, 
                                double globalScore, int numberOfRatings) {
        super();
        this.foodId = foodId;
        this.userId = userId;
        this.tasteRating = tasteRating;
        this.nutritionalvalueRating = nutritionalvalueRating;
        this.overallsatisfactionRating = overallsatisfactionRating;
        this.packagingRating = packagingRating;
        this.priceRating = priceRating;
        this.globalScore = globalScore;
        this.numberOfRatings = numberOfRatings;
    }

    // Default constructor
    public AggregatedRatingData() {
        super();
    }

    // Getter and Setter methods for foodId
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    // Getter and Setter methods for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter methods for tasteRating
    public int getTasteRating() {
        return tasteRating;
    }

    public void setTasteRating(int tasteRating) {
        this.tasteRating = tasteRating;
    }

    // Getter and Setter methods for nutritionalvalueRating
    public int getNutritionalvalueRating() {
        return nutritionalvalueRating;
    }

    public void setNutritionalvalueRating(int nutritionalvalueRating) {
        this.nutritionalvalueRating = nutritionalvalueRating;
    }

    // Getter and Setter methods for overallsatisfactionRating
    public int getOverallsatisfactionRating() {
        return overallsatisfactionRating;
    }

    public void setOverallsatisfactionRating(int overallsatisfactionRating) {
        this.overallsatisfactionRating = overallsatisfactionRating;
    }

    // Getter and Setter methods for packagingRating
    public int getPackagingRating() {
        return packagingRating;
    }

    public void setPackagingRating(int packagingRating) {
        this.packagingRating = packagingRating;
    }

    // Getter and Setter methods for priceRating
    public int getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // Getter and Setter methods for globalScore
    public double getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(double globalScore) {
        this.globalScore = globalScore;
    }

    // Getter and Setter methods for numberOfRatings
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    // toString method to print the object as a string
    @Override
    public String toString() {
        return "AggregatedRatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating="
                + tasteRating + ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" 
                + overallsatisfactionRating + ", packagingRating=" + packagingRating + ", priceRating=" + priceRating 
                + ", globalScore=" + globalScore + ", numberOfRatings=" + numberOfRatings + "]";
    }
}
