package it.univaq.disim.sose.utils;

import java.text.SimpleDateFormat; // Importing SimpleDateFormat class for date formatting
import java.util.Date; // Importing Date class for date and time operations

// Utility class for common functions used in the ReviewEditorProsumer
public class Utility {
	
    // Method to log messages to the console with a timestamp
	public static void consoleLog(String message) {
		// Getting the current date and time formatted as a string
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		
		// Defining the component name for identification in logs
		String whoAmI = "ReviewEditorProsumer";
		
		// Printing the log message to the console
		System.out.println(whoAmI + " [" + now + "] " + message);
	}
	
}
