package it.univaq.disim.sose.service.DAO; // Defines the package for the SQLiteUserDAOImpl class

import java.sql.Connection; // Importing necessary classes for database connection and operations
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.utils.Utils; // Importing the Utils class for utility functions

// Concrete implementation of the UserDAO interface for SQLite
public class SQLiteUserDAOImpl implements UserDAO {

	// Member variables for database connection and statements
	private Connection conn = null;
	private PreparedStatement prep = null;
	private ResultSet res = null;
	
	// SQL queries for various operations
	private final String CREATE_DATABASE_TABLE = "CREATE TABLE IF NOT EXISTS user (user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, token TEXT);";
	private final String LOGIN = "SELECT user_id FROM user WHERE username = ? AND password = ?";
	private final String SIGNUP = "INSERT INTO user(username, password) VALUES (?, ?)";
	private final String INSERT_TOKEN = "UPDATE user SET token = ? where user_id = ?";
	private final String CHECK_TOKEN = "SELECT token FROM user WHERE user_id = ? AND token = ? ";
	
	// Method to create the user table if it doesn't exist
	@Override
	public void createTableDB() {
		try {
			// Establishing the database connection
			conn = SQLiteDAOFactory.createConnection();
			// Creating a statement object to execute SQL queries
			Statement statement = conn.createStatement();
			// Executing the SQL query to create the user table
			statement.executeUpdate(CREATE_DATABASE_TABLE);
			Utils.consoleLog("database created");
		} catch (SQLException e) {
			e.printStackTrace(); // Print any SQL exceptions
		} finally {
			// Closing the database connection and related resources
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

	// Method to sign up a new user
	@Override
	public int signup(String username, String password) throws SQLException {
		try {
			// Establishing the database connection
			conn = SQLiteDAOFactory.createConnection();
			// Preparing the SQL query for user signup
			prep = conn.prepareStatement(SIGNUP);
			prep.setString(1, username);
			prep.setString(2, password);
			prep.executeUpdate();
			// Retrieving the generated user ID
			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	return generatedKeys.getInt(1); // Return the generated user ID
	            } else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
		} catch(SQLException e ) {
			e.printStackTrace();
			return 0; // Return 0 if signup fails
		} finally {
			// Closing the database connection and related resources
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

	// Method to log in a user
	@Override
	public int login(String username, String password) {
		try {
			// Establishing the database connection
			conn = SQLiteDAOFactory.createConnection();
			// Preparing the SQL query for user login
			prep = conn.prepareStatement(LOGIN);
			prep.setString(1, username);
			prep.setString(2, password);
			// Executing the query and retrieving the result
			res = prep.executeQuery();
			if (res.next()) {
				return res.getInt(1); // Return the user ID if login is successful
			}
			return 0; // Return 0 if login fails
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; // Return 0 if an exception occurs
		} finally {
			// Closing the database connection and related resources
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

	// Method to check the user token
	@Override
	public boolean checkToken(int userID, String token) {
		try {
			// Establishing the database connection
			conn = SQLiteDAOFactory.createConnection();
			// Preparing the SQL query to check the user token
			prep = conn.prepareStatement(CHECK_TOKEN);
			prep.setInt(1, userID);
			prep.setString(2, token);
			// Executing the query and retrieving the result
			res = prep.executeQuery();
			if (res.next()) {
				return true; // Return true if the token is valid
			}
			return false; // Return false if the token is invalid
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false if an exception occurs
		} finally {
			// Closing the database connection and related resources
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

	// Method to insert the user token
	@Override
	public boolean insertToken(int userID, String token) {
		try {
			// Establishing the database connection
			conn = SQLiteDAOFactory.createConnection();
			// Preparing the SQL query to insert the user token
			prep = conn.prepareStatement(INSERT_TOKEN);
			prep.setString(1, token);
			prep.setInt(2, userID);
			// Executing the update query
			prep.executeUpdate();
			return true; // Return true if the token is inserted successfully
		} catch(SQLException e ) {
			e.printStackTrace();
			return false; // Return false if an exception occurs
		} finally {
			// Closing the database connection and related resources
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}
}
