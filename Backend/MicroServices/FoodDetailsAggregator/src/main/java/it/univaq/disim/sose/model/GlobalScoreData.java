package it.univaq.disim.sose.model;

public class GlobalScoreData {

    // Unique identifier for the food item
    private String foodId;
    
    // Combined score representing the overall rating of the food
    private double globalScore;
    
    // Total number of ratings received for the food
    private int numberOfRatings;
    
    // Constructor with parameters to initialize the fields
    public GlobalScoreData(String foodId, double globalScore, int numberOfRatings) {
        super();
        this.foodId = foodId;
        this.globalScore = globalScore;
        this.numberOfRatings = numberOfRatings;
    }
    
    // Default constructor
    public GlobalScoreData() {
        // No initialization of fields
    }

    // Getter and Setter methods for foodId
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
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
        return "GlobalScoreData [foodId=" + foodId + ", globalScore=" + globalScore + ", numberOfRatings="
                + numberOfRatings + "]";
    }
}
