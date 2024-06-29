package it.univaq.disim.sose.model;

import java.util.List;

public class FoodData {

    // Edamam Data
    private String foodId;                // Unique identifier for the food item
    private String label;                 // Name of the food item
    private String knownAs;               // Alternate names for the food item
    private String category;              // Category of the food item
    private String categoryLabel;         // Label for the category
    private String brand;                 // Brand name, if any
    private String foodContentsLabel;     // Label describing the food contents
    private String image;                 // URL to the image of the food item
    private List<ServingSize> servingSizes; // List of serving sizes
    private Integer servingsPerContainer; // Number of servings per container
    private Nutrients nutrients;          // Nutritional information

    // Reviews
    private List<Review> reviews;         // List of reviews for the food item

    // Rankings
    private AggregatedRatingData ratings; // Aggregated ratings data

    // Default constructor
    public FoodData() {
        super();
    }

    // Getter and Setter methods
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ServingSize> getServingSizes() {
        return servingSizes;
    }

    public void setServingSizes(List<ServingSize> servingSizes) {
        this.servingSizes = servingSizes;
    }

    public Integer getServingsPerContainer() {
        return servingsPerContainer;
    }

    public void setServingsPerContainer(Integer servingsPerContainer) {
        this.servingsPerContainer = servingsPerContainer;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public AggregatedRatingData getRatings() {
        return ratings;
    }

    public void setRatings(AggregatedRatingData ratings) {
        this.ratings = ratings;
    }

    // Override the toString method for easy printing
    @Override
    public String toString() {
        return "FoodData [foodId=" + foodId + ", label=" + label + ", knownAs=" + knownAs + ", category=" + category
                + ", categoryLabel=" + categoryLabel + ", brand=" + brand + ", foodContentsLabel=" + foodContentsLabel
                + ", image=" + image + ", servingSizes=" + servingSizes + ", servingsPerContainer=" + servingsPerContainer
                + ", nutrients=" + nutrients + ", reviews=" + reviews + ", ratings=" + ratings + "]";
    }

    // Nested ServingSize class
    public static class ServingSize {
        private String uri;       // URI of the serving size
        private String label;     // Label of the serving size
        private Double quantity;  // Quantity of the serving size

        // Getter and Setter methods
        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Double getQuantity() {
            return quantity;
        }

        public void setQuantity(Double quantity) {
            this.quantity = quantity;
        }

        // Override the toString method for easy printing
        @Override
        public String toString() {
            return "ServingSize [uri=" + uri + ", label=" + label + ", quantity=" + quantity + "]";
        }
    }

    // Nested Nutrients class
    public static class Nutrients {
        private Double ENERC_KCAL; // Energy in kcal
        private Double PROCNT;     // Protein in g
        private Double FAT;        // Total lipid (fat) in g
        private Double CHOCDF;     // Carbohydrate, by difference in g
        private Double FIBTG;      // Fiber, total dietary in g

        // Getter and Setter methods
        public Double getENERC_KCAL() {
            return ENERC_KCAL;
        }

        public void setENERC_KCAL(Double ENERC_KCAL) {
            this.ENERC_KCAL = ENERC_KCAL;
        }

        public Double getPROCNT() {
            return PROCNT;
        }

        public void setPROCNT(Double PROCNT) {
            this.PROCNT = PROCNT;
        }

        public Double getFAT() {
            return FAT;
        }

        public void setFAT(Double FAT) {
            this.FAT = FAT;
        }

        public Double getCHOCDF() {
            return CHOCDF;
        }

        public void setCHOCDF(Double CHOCDF) {
            this.CHOCDF = CHOCDF;
        }

        public Double getFIBTG() {
            return FIBTG;
        }

        public void setFIBTG(Double FIBTG) {
            this.FIBTG = FIBTG;
        }

        // Override the toString method for easy printing
        @Override
        public String toString() {
            return "Nutrients [ENERC_KCAL=" + ENERC_KCAL + ", PROCNT=" + PROCNT + ", FAT=" + FAT + ", CHOCDF=" + CHOCDF
                    + ", FIBTG=" + FIBTG + "]";
        }
    }
}
