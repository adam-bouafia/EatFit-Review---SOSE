package it.univaq.disim.sose.prosumer;

import javax.servlet.ServletConfig; // Importing ServletConfig class for servlet configuration
import javax.xml.ws.Endpoint; // Importing Endpoint class for publishing web service endpoints

import org.apache.cxf.Bus; // Importing Bus class from Apache CXF for managing the CXF bus
import org.apache.cxf.BusFactory; // Importing BusFactory class from Apache CXF for creating and managing bus instances
import org.apache.cxf.transport.servlet.CXFNonSpringServlet; // Importing CXFNonSpringServlet class for non-Spring CXF servlet support

// Extending CXFNonSpringServlet to create a custom servlet for the CXF framework
public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {

    // Serial version UID for serialization
    private static final long serialVersionUID = -6420470370401020050L;

    // Overriding loadBus method to configure the CXF bus and publish the web service endpoint
    @Override
    public void loadBus(ServletConfig servletConfig) {
        // Calling the parent class's loadBus method
        super.loadBus(servletConfig);
        
        // Getting the CXF bus instance
        Bus bus = getBus();
        
        // Setting the default bus to the retrieved bus instance
        BusFactory.setDefaultBus(bus);
        
        // Publishing the web service endpoint at the specified URL with the implementation class
        Endpoint.publish("/ReviewEditor", new ReviewEditorProsumerImpl());
    }
}
