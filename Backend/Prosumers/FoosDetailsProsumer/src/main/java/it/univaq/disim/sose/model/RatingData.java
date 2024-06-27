package it.univaq.disim.sose.model;

import org.json.JSONObject;

public class RatingData {

	// Keys
	private String foodId;
	private int userId;
	
	// Parameters
	private int tasteRating;
	private int nutritionalvalueRating;
	private int overallsatisfactionRating;
	private int packagingRating;
	private int priceRating;
	
	
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
	
	public RatingData(JSONObject object) {
		super();
		this.foodId = object.getString("foodId");
		this.userId = object.getInt("userId");;
		this.tasteRating = object.getInt("tasteRating");
		this.nutritionalvalueRating = object.getInt("nutritionalvalueRating");
		this.overallsatisfactionRating = object.getInt("overallsatisfactionRating");
		this.packagingRating = object.getInt("packagingRating");
		this.priceRating = object.getInt("priceRating");
	}


	public RatingData() {
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "RatingData [foodId=" + foodId + ", userId=" + userId + ", tasteRating=" + tasteRating
				+ ", nutritionalvalueRating=" + nutritionalvalueRating + ", overallsatisfactionRating=" + overallsatisfactionRating + ", packagingRating="
				+ packagingRating + ", priceRating=" + priceRating + "]";
	}
	
	
	
}
