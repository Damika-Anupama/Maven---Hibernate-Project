package lk.ijse.dep.listner; /**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/

import lk.ijse.dep.util.JPAUtil;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties prop = new Properties();
        try {
            logger.info("Session factory is being initialized");
            sce.getServletContext().setAttribute("emf", JPAUtil.getEntityManagerFactory());
            String logFilePath;
            if (prop.getProperty("app.log_dir") != null) {
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            } else {
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.getEntityManagerFactory().close();
        logger.info("Entity manager factory is being closed..");
    }
}
