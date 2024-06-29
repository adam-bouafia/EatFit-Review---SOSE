package it.univaq.disim.sose.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    
    // Method to get the path to the resources directory
    public static String getResourcesPath() {
        // Get the URL of the resource directory
        URL resource = Utils.class.getClassLoader().getResource("sqlite");
        consoleLog(resource.toString()); // Log the resource path
        
        String resourcesPath;
        try {
            // Convert the URL to a URI and get the absolute path
            resourcesPath = new File(resource.toURI()).getAbsolutePath();
            return resourcesPath;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    // Method to build an XML response string
    public static String buildXMLResponse(String xmlToAdd) {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
        return response;
    }
    
    // Method to log messages to the console with a timestamp
    public static void consoleLog(String message) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String whoAmI = "ReviewDataService"; // Identifier for the logging source
        System.out.println(whoAmI + " [" + now + "] " + message);
    }
}
