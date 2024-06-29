package it.univaq.disim.sose.utils; // Defines the package for the Utils class

import java.io.File; // Importing necessary classes for file handling
import java.net.URISyntaxException; // Importing necessary classes for handling URI syntax exceptions
import java.net.URL; // Importing necessary classes for handling URLs
import java.text.SimpleDateFormat; // Importing necessary classes for date formatting
import java.util.Date; // Importing necessary classes for handling dates

public class Utils {

    // Method to get the path of the resources folder
    public static String getResourcesPath() {
        // Get the URL of the "sqlite" resource
        URL resource = Utils.class.getClassLoader().getResource("sqlite");
        consoleLog(resource.toString());
        
        // Convert the URL to a file path
        String resourcesPath;
        try {
            resourcesPath = new File(resource.toURI()).getAbsolutePath();
            return resourcesPath;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }

    // Method to build an XML response
    public static String buildXMLResponse(String xmlToAdd) {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
        return response;
    }

    // Method to log messages to the console with a timestamp
    public static void consoleLog(String message) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String whoAmI = "AuthService";
        System.out.println(whoAmI + " [" + now + "] " + message);
    }
}
