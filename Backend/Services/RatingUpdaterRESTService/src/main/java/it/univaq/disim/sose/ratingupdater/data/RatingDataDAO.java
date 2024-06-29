package it.univaq.disim.sose.ratingupdater.data;

import java.sql.SQLException;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.model.RatingData;

// Interface for Rating Data Data Access Object (DAO)
public interface RatingDataDAO {

    /**
     * Inserts a single rating data into the database.
     *
     * @param toAdd The rating data to be added.
     * @return true if the insertion was successful, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean insertRatingData(RatingData toAdd) throws SQLException;
    
    /**
     * Inserts multiple rating data into the database.
     *
     * @param toAdd The list of rating data to be added.
     * @return true if the insertion was successful, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean insertRatingDatas(List<RatingData> toAdd) throws SQLException;
    
    /**
     * Retrieves all rating data from the database.
     *
     * @return A list of all rating data.
     * @throws SQLException If a database access error occurs.
     */
    List<RatingData> getAllRatingData() throws SQLException;
    
    /**
     * Retrieves all rating data for a specific foodId from the database.
     *
     * @param foodId The ID of the food to retrieve ratings for.
     * @return A list of rating data for the specified foodId.
     * @throws SQLException If a database access error occurs.
     */
    List<RatingData> getAllRatingDataByFoodId(String foodId) throws SQLException;
}
