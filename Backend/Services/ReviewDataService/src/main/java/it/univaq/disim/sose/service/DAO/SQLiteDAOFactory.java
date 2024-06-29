package it.univaq.disim.sose.service.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.utils.Utils;

// Factory class for SQLite database connection and operations
public class SQLiteDAOFactory extends DAOFactory {
    
    // SQLite driver and database URL
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DATABASE = "jdbc:sqlite::resource:review.db";
    
    // Method to create a connection to the SQLite database
    public static Connection createConnection() {
        Connection conn = null;
        
        try {
            // Load the SQLite JDBC driver
            Class.forName(DRIVER);
            // Log the database URL
            Utils.consoleLog(DATABASE);
            // Establish the connection to the database
            conn = DriverManager.getConnection(DATABASE);
            
            // Uncomment for debugging
            // System.out.println("Connected to database");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return conn;
    }
    
    // Method to close the database connection and related resources
    public static void closeDbConnection(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
    // Method to create the database and review table if they do not exist
    public static void DBCreation() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName(DRIVER);
            // Establish the connection to the database
            conn = DriverManager.getConnection(DATABASE);
            Utils.consoleLog("Connected to database ");
            // Create the review table
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT,food_id INTEGER, title TEXT, comment TEXT, user_id INTEGER)");
            Utils.consoleLog("Database created ");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Override method to get the ReviewDAO implementation for SQLite
    @Override 
    public ReviewDAO getReviewDAO() {
        return new SQLiteReviewDAOImpl();
    }
}
