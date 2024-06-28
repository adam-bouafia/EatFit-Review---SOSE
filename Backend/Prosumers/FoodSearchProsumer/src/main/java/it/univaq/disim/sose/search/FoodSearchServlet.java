package it.univaq.disim.sose.search;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

/**
 * This class represents a CXF servlet that handles the initialization and
 * publication of the Food Search web service endpoint.
 */
public class FoodSearchServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = -6420470370401020050L;

    /**
     * This method is called by the servlet container to initialize the servlet.
     * It loads the CXF bus and publishes the Food Search web service endpoint.
     *
     * @param servletConfig the servlet configuration passed by the servlet container
     */
    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig); // Call the superclass method to ensure proper initialization
        Bus bus = getBus(); // Get the current CXF bus
        BusFactory.setDefaultBus(bus); // Set the current bus as the default bus
        Endpoint.publish("/search", new SearchImpl()); // Publish the web service endpoint at "/search"
    }
}
