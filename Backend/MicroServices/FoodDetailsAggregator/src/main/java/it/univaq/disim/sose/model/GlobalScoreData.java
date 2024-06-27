package it.univaq.disim.sose.model;

public class GlobalScoreData {

	private String foodId;
	private double globalScore;
	private int numberOfRatings;
	
	public GlobalScoreData(String foodId, double globalScore, int numberOfRatings) {
		super();
		this.foodId = foodId;
		this.globalScore = globalScore;
		this.numberOfRatings = numberOfRatings;
	}
	
	public GlobalScoreData() {
		
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public double getGlobalScore() {
		return globalScore;
	}

	public void setGlobalScore(double globalScore) {
		this.globalScore = globalScore;
	}

	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	@Override
	public String toString() {
		return "GlobalScoreData [foodId=" + foodId + ", globalScore=" + globalScore + ", numberOfRatings="
				+ numberOfRatings + "]";
	}
	
	
	
}
