package it.univaq.disim.sose.service.Authentic; // Defines the package for the AuthServiceImpl class

import java.sql.SQLException; // Importing SQLException for handling SQL exceptions

import org.apache.commons.lang3.RandomStringUtils; // Importing RandomStringUtils for generating random strings

import it.univaq.disim.sose.service.DAO.DAOFactory; // Importing DAOFactory for getting DAO instances
import it.univaq.disim.sose.service.DAO.UserDAO; // Importing UserDAO for user-related data operations
import it.univaq.disim.sose.utils.Utils; // Importing Utils for utility functions

public class AuthServiceImpl implements AuthService {
	
	{
		// Initializing UserDAO and creating the database table
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		try {
			userDAO.createTableDB();
			Utils.consoleLog("database created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String login(String username, String password) {
		// Logging the username and password (not recommended for production)
		System.out.println(username);
		System.out.println(password);
		
		// Getting UserDAO instance
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		
		// Attempting to login the user
		int userID = userDAO.login(username, password);
		System.out.println("userID: " + userID);
		
		// Checking if the user exists
		if (userID == 0) return "The user does not exist";
		
		// Generating a random token
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		
		// Inserting the token into the database
		boolean res = userDAO.insertToken(userID, generatedString);
		if (res) return generatedString + "§" + userID;
		return null;
	}

	@Override
	public String signup(String username, String password) throws SQLException {
		// Getting UserDAO instance
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		
		// Signing up the user and returning the user ID
		return String.valueOf(userDAO.signup(username, password));
	}

	@Override
	public String checkUser(int userID, String userToken) throws SQLException {
		// Getting UserDAO instance
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		
		// Checking if the token is valid for the user
		if (userDAO.checkToken(userID, userToken)) return "User is logged";
		return "User not logged";
	}
}
