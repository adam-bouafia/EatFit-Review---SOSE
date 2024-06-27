package it.univaq.disim.sose.model;

public class AggregatedRatingData {

	// Keys
	private String foodId;
	private int userId;
	
	// Parameters
	private int tasteRating;
	private int nutritionalvalueRating;
	private int overallsatisfactionRating;
	private int packagingRating;
	private int priceRating;
	
	private double globalScore;
	private int numberOfRatings;
	
	
	
	public AggregatedRatingData(String foodId, int userId, int tasteRating, int nutritionalvalueRating,
			int overallsatisfactionRating, int packagingRating, int priceRating, double globalScore, int numberOfRatings) {
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

	public AggregatedRatingData() {
		super();
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTasteRating() {
		return tasteRating;
	}

	public void setTasteRating(int tasteRating) {
		this.tasteRating = tasteRating;
	}

	public int getNutritionalvalueRating() {
		return nutritionalvalueRating;
	}

	public void setNutritionalvalueRating(int nutritionalvalueRating) {
		this.nutritionalvalueRating = nutritionalvalueRating;
	}

	public int getOverallsatisfactionRating() {
		return overallsatisfactionRating;
	}

	public void setOverallsatisfactionRating(int overallsatisfactionRating) {
		this.overallsatisfactionRating = overallsatisfactionRating;
	}

	public int getPackagingRating() {
		return packagingRating;
	}

	public void setPackagingRating(int packagingRating) {
		this.packagingRating = packagingRating;
	}

	public int getPriceRating() {
		return priceRating;
	}

	public void setPriceRating(int priceRating) {
		this.priceRating = priceRating;
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
		return "AggregatedRatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating="
				+ tasteRating + ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" + overallsatisfactionRating
				+ ", packagingRating=" + packagingRating + ", priceRating=" + priceRating + ", globalScore="
				+ globalScore + ", numberOfRatings=" + numberOfRatings + "]";
	}
	
}
