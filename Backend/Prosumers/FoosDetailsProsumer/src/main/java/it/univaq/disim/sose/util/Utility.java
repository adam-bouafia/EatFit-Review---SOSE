package it.univaq.disim.sose.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;

import it.univaq.disim.sose.model.FoodData;

// Utility class containing helper methods for various tasks
public class Utility {

    // Method to build an XML response from a FoodData object
    public static String buildXMLResponse(FoodData obj) {
        // Create an XStream instance
        XStream xstream = new XStream();
        // Convert the FoodData object to XML
        String xmlToAdd = xstream.toXML(obj);
        // Build the XML response string
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
        // Return the XML response
        return response;
    }
    
    // Method to log messages to the console with a timestamp
    public static void consoleLog(String message) {
        // Get the current date and time formatted as a string
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        // Identify the source of the log message
        String whoAmI = "FoodDetailsProsumer";
        // Print the log message to the console
        System.out.println(whoAmI + " [" + now + "] " + message);
    }
    
}
