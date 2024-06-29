package it.univaq.disim.sose.ratingupdater.model;

import javax.xml.bind.annotation.XmlRootElement;

// Annotation to define the root element for XML representation
@XmlRootElement(name = "GlobalScoreData")
public class GlobalScoreData {

    // Fields to store food ID, global score, and number of ratings
    private String foodId;
    private double globalScore;
    private int numberOfRatings;

    // Constructor to initialize all fields
    public GlobalScoreData(String foodId, double globalScore, int numberOfRatings) {
        super();
        this.foodId = foodId;
        this.globalScore = globalScore;
        this.numberOfRatings = numberOfRatings;
    }

    // Getter for foodId
    public String getFoodId() {
        return foodId;
    }

    // Setter for foodId
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    // Getter for globalScore
    public double getGlobalScore() {
        return globalScore;
    }

    // Setter for globalScore
    public void setGlobalScore(double globalScore) {
        this.globalScore = globalScore;
    }

    // Getter for numberOfRatings
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    // Setter for numberOfRatings
    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "GlobalScoreData [foodId=" + foodId + ", globalScore=" + globalScore + ", numberOfRatings="
                + numberOfRatings + "]";
    }
}
