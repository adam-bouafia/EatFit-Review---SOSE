package it.univaq.disim.sose.search;

import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.search.model.Result;

/**
 * This interface defines the Food Search web service. It contains the method
 * signatures for searching food items.
 */
@WebService
public interface Search {

    /**
     * This method is used to search for food items based on a search query.
     * 
     * @param a the search query string
     * @return a list of search results matching the query
     * @throws IOException if an I/O error occurs during the search
     */
    @WebMethod
    List<Result> searchFood(String a) throws IOException;

}
