package it.univaq.disim.sose.ratingupdater.data; // Defines the package for the GlobalScoreDAO interface

import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData; // Importing the GlobalScoreData model class

public interface GlobalScoreDAO {
    
    // Method to read the global score for a specific food ID
    GlobalScoreData readGlobalScore(String foodId);
    
    // Method to update the global score for a specific food ID
    boolean updateGlobalScore(GlobalScoreData newValue);
    
}
