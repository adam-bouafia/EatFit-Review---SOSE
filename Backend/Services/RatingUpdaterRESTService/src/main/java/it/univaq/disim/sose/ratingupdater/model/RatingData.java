package it.univaq.disim.sose.ratingupdater.model;

import javax.xml.bind.annotation.XmlRootElement;

// Annotation to define the root element for XML representation
@XmlRootElement(name = "RatingData")
public class RatingData {

    // Fields to store rating details
    private String foodId; // Food ID
    private int userId; // User ID

    // Rating parameters
    private int tasteRating; // Taste rating
    private int nutritionalvalueRating; // Nutritional value rating
    private int overallsatisfactionRating; // Overall satisfaction rating
    private int packagingRating; // Packaging rating
    private int priceRating; // Price rating

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

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "RatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating=" + tasteRating
                + ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" + overallsatisfactionRating
                + ", packagingRating=" + packagingRating + ", priceRating=" + priceRating + "]";
    }
}
