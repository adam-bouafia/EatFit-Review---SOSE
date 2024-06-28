package it.univaq.disim.sose.model;

// This class represents the rating data for a food item
public class RatingData {

    // Keys
    private String foodId; // The ID of the food item
    private int userId; // The ID of the user who provided the rating
    
    // Parameters
    private int tasteRating; // The rating for taste
    private int nutritionalvalueRating; // The rating for nutritional value
    private int overallsatisfactionRating; // The rating for overall satisfaction
    private int packagingRating; // The rating for packaging
    private int priceRating; // The rating for price
    
    // Default constructor
    public RatingData() {
        
    }
    
    // Constructor to initialize all fields
    public RatingData(String foodId, int userId, int tasteRating, int nutritionalvalueRating, int overallsatisfactionRating,
            int packagingRating, int priceRating) {
        super();
        this.foodId = foodId;
        this.userId = userId;
        this.tasteRating = tasteRating;
        this.nutritionalvalueRating = nutritionalvalueRating;
        this.overallsatisfactionRating = overallsatisfactionRating;
        this.packagingRating = packagingRating;
        this.priceRating = priceRating;
    }

    // Getter method for foodId
    public String getFoodId() {
        return foodId;
    }

    // Setter method for foodId
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    // Getter method for userId
    public int getUserId() {
        return userId;
    }

    // Setter method for userId
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter method for tasteRating
    public int getTasteRating() {
        return tasteRating;
    }

    // Setter method for tasteRating
    public void setTasteRating(int tasteRating) {
        this.tasteRating = tasteRating;
    }

    // Getter method for nutritionalvalueRating
    public int getNutritionalvalueRating() {
        return nutritionalvalueRating;
    }

    // Setter method for nutritionalvalueRating
    public void setNutritionalvalueRating(int nutritionalvalueRating) {
        this.nutritionalvalueRating = nutritionalvalueRating;
    }

    // Getter method for overallsatisfactionRating
    public int getOverallsatisfactionRating() {
        return overallsatisfactionRating;
    }

    // Setter method for overallsatisfactionRating
    public void setOverallsatisfactionRating(int overallsatisfactionRating) {
        this.overallsatisfactionRating = overallsatisfactionRating;
    }

    // Getter method for packagingRating
    public int getPackagingRating() {
        return packagingRating;
    }

    // Setter method for packagingRating
    public void setPackagingRating(int packagingRating) {
        this.packagingRating = packagingRating;
    }

    // Getter method for priceRating
    public int getPriceRating() {
        return priceRating;
    }

    // Setter method for priceRating
    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // Override toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "RatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating=" + tasteRating
                + ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" + overallsatisfactionRating + ", packagingRating="
                + packagingRating + ", priceRating=" + priceRating + "]";
    }
}
