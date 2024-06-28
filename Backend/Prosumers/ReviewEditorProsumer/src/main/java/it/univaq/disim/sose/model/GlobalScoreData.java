package it.univaq.disim.sose.model;

// This class represents the global score data for a food item
public class GlobalScoreData {

	// Instance variables
	private String foodId;  // The ID of the food item
	private double globalScore;  // The global score of the food item
	private int numberOfRatings;  // The number of ratings the food item has received
	
	// Constructor to initialize all fields
	public GlobalScoreData(String foodId, double globalScore, int numberOfRatings) {
		super();
		this.foodId = foodId;
		this.globalScore = globalScore;
		this.numberOfRatings = numberOfRatings;
	}

	// Getter method for foodId
	public String getFoodId() {
		return foodId;
	}

	// Setter method for foodId
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	// Getter method for globalScore
	public double getGlobalScore() {
		return globalScore;
	}

	// Setter method for globalScore
	public void setGlobalScore(double globalScore) {
		this.globalScore = globalScore;
	}

	// Getter method for numberOfRatings
	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	// Setter method for numberOfRatings
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	// Override toString() method to provide a string representation of the object
	@Override
	public String toString() {
		return "GlobalScoreData [foodId=" + foodId + ", globalScore=" + globalScore + ", numberOfRatings="
				+ numberOfRatings + "]";
	}
}
