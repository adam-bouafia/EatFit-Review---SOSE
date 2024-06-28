package it.univaq.disim.sose.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class providing common helper methods.
 */
public class Utility {

    /**
     * Logs a message to the console with a timestamp.
     * 
     * @param message The message to be logged.
     */
    public static void consoleLog(String message) {
        // Get the current timestamp formatted as "yyyy-MM-dd HH:mm:ss.SSS"
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        
        // Define a string representing the source of the log message
        String whoAmI = "FoodDetailsAggregator";
        
        // Print the log message to the console
        System.out.println(whoAmI + " [" + now + "] " + message);
    }
}
