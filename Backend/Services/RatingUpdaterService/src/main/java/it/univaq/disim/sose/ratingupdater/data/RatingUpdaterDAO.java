package it.univaq.disim.sose.ratingupdater.data;

// Singleton class for managing DAO instances for rating updates
public class RatingUpdaterDAO {

    // Singleton instance
    private static RatingUpdaterDAO instance;
    
    // DAOs for rating data and global score
    private RatingDataDAO ratingDataDAO;
    private GlobalScoreDAO globalScoreDAO;
    
    // Private constructor to prevent instantiation
    private RatingUpdaterDAO() {
        // Initialize the DAOs with their respective implementations
        this.ratingDataDAO = new RatingDataDAO_SQLLite();
        this.globalScoreDAO = new GlobalScoreDAO_SQLLite();
    }
    
    // Public method to get the singleton instance
    public static RatingUpdaterDAO getInstance() {
        // Create the instance if it doesn't exist
        if (instance == null) instance = new RatingUpdaterDAO();
        return instance;
    }
    
    // Method to get the RatingDataDAO instance
    public RatingDataDAO getRatingDataDAO() {
        return this.ratingDataDAO;
    }
    
    // Method to get the GlobalScoreDAO instance
    public GlobalScoreDAO getGlobalScoreDAO() {
        return this.globalScoreDAO;
    }
    
}
