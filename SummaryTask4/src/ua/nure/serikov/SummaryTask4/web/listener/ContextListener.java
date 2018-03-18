package ua.nure.serikov.SummaryTask4.web.listener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Context listener.
 */
public class ContextListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(ContextListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        log("Servlet context destruction starts.");
        log("Servlet context destruction finished.");
    }

    public void contextInitialized(ServletContextEvent event) {
        log("Servlet context initialization starts");
        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);
        
        String localesFileName = servletContext.getInitParameter("locales");

        // obtain real path on server
        String localesFileRealPath = servletContext.getRealPath(localesFileName);

        // local descriptions
        Properties locales = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(localesFileRealPath);
            locales.load(fis);
        } catch (IOException e) {
            LOG.error("locales IOException!");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                LOG.error("Not close FileInputStream!");
            }
        }

        // save descriptions to servlet context
        servletContext.setAttribute("locales", locales);
        locales.list(System.out);

        initCommandContainer();
        log("Servlet context initialization finished");
    }

    /**
     * Initializes CommandContainer.
     */
    private void initCommandContainer() {

        // initialize commands container
        // just load class to JVM
        try {
            Class.forName("ua.nure.serikov.SummaryTask4.web.command.CommandContainer");
        } catch (ClassNotFoundException ex) {
            LOG.error("Cannot initialize Command Container!");
            throw new IllegalStateException("Cannot initialize Command Container");
        }
    }
    
	/**
	 * Initializes log4j framework.
	 * 
	 * @param servletContext
	 */
	private void initLog4J(ServletContext servletContext) {
		log("Log4J initialization started");
		try {
			PropertyConfigurator.configure(
				servletContext.getRealPath("WEB-INF/log4j.properties"));
			LOG.debug("Log4j has been initialized");
		} catch (Exception ex) {
			log("Cannot configure Log4j");
			ex.printStackTrace();
		}		
		log("Log4J initialization finished");
	}
	
	private void log(String msg) {
		System.out.println("[ContextListener] " + msg);
	}
}