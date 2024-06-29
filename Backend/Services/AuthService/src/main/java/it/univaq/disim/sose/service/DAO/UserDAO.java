package it.univaq.disim.sose.service.DAO; // Defines the package for the UserDAO interface

import java.sql.SQLException; // Importing necessary classes for handling SQL exceptions

// Interface defining the data access operations for user-related data
public interface UserDAO {

	// Method to create the user table in the database
	public void createTableDB() throws SQLException;
	
	// Method to sign up a new user and return the user ID
	public int signup(String username, String password) throws SQLException;
	
	// Method to log in a user and return the user ID
	public int login(String username, String password);

	// Method to check the user token and return true if valid, false otherwise
	public boolean checkToken(int userID, String token);
	
	// Method to insert the user token and return true if successful, false otherwise
	public boolean insertToken(int userID, String token);
}
