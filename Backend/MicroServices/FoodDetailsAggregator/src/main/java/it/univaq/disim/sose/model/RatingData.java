package it.univaq.disim.sose.model;

// This class represents the rating data for a specific food item provided by a user
public class RatingData {

    // Keys
    // Unique identifier for the food item
    private String foodId;
    // Unique identifier for the user who provided the rating
    private int userId;

    // Parameters
    // Rating for the taste of the food
    private int tasteRating;
    // Rating for the nutritional value of the food
    private int nutritionalvalueRating;
    // Rating for overall satisfaction with the food
    private int overallsatisfactionRating;
    // Rating for the packaging of the food
    private int packagingRating;
    // Rating for the price of the food
    private int priceRating;

    // Constructor to initialize all the fields
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

    // Getter for foodId
    public String getFoodId() {
        return foodId;
    }

    // Setter for foodId
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter for tasteRating
    public int getTasteRating() {
        return tasteRating;
    }

    // Setter for tasteRating
    public void setTasteRating(int tasteRating) {
        this.tasteRating = tasteRating;
    }

    // Getter for nutritionalvalueRating
    public int getNutritionalvalueRating() {
        return nutritionalvalueRating;
    }

    // Setter for nutritionalvalueRating
    public void setNutritionalvalueRating(int nutritionalvalueRating) {
        this.nutritionalvalueRating = nutritionalvalueRating;
    }

    // Getter for overallsatisfactionRating
    public int getOverallsatisfactionRating() {
        return overallsatisfactionRating;
    }

    // Setter for overallsatisfactionRating
    public void setOverallsatisfactionRating(int overallsatisfactionRating) {
        this.overallsatisfactionRating = overallsatisfactionRating;
    }

    // Getter for packagingRating
    public int getPackagingRating() {
        return packagingRating;
    }

    // Setter for packagingRating
    public void setPackagingRating(int packagingRating) {
        this.packagingRating = packagingRating;
    }

    // Getter for priceRating
    public int getPriceRating() {
        return priceRating;
    }

    // Setter for priceRating
    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    // Overriding the toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "RatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating=" + tasteRating
                + ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" + overallsatisfactionRating + ", packagingRating="
                + packagingRating + ", priceRating=" + priceRating + "]";
    }
}
