package it.univaq.disim.sose.fooddetails;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

public class FoodDetailsServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = -4978737275160241311L; // Serialization identifier

    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig); // Calls the superclass method to load the bus configuration
        
        Bus bus = getBus(); // Gets the current Bus instance
        BusFactory.setDefaultBus(bus); // Sets the default Bus instance
        Endpoint.publish("/fooddetails", new FoodDetailsImpl()); // Publishes the endpoint at /fooddetails with the implementation class
    }
    
}
