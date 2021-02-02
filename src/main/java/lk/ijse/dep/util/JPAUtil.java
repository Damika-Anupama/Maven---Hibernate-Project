package lk.ijse.dep.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.Basic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class JPAUtil {
    private static Logger logger = LoggerFactory.getLogger(JPAUtil.class);
    private static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        Properties properties = new Properties();
        try {
            properties.load(JPAUtil.class.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            logger.error("failed to load database properties",e);
            e.printStackTrace();
        }
        properties.put(Environment.DATASOURCE,getDataSource());
        return Persistence.createEntityManagerFactory("learning-platform",properties);
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    private static DataSource getDataSource() {
        Properties properties = new Properties();
        BasicDataSource bds = new BasicDataSource();
        try {
            properties.load(JPAUtil.class.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            logger.error("failed to load database properties");
            throw new RuntimeException("failed to load database properties",e);
        }
        bds.setInitialSize(Integer.parseInt(properties.getProperty("dbcp.initial_size")));
        bds.setMaxTotal(Integer.parseInt(properties.getProperty("dbcp.max_total")));
        bds.setUsername(properties.getProperty("dbcp.jdbc.user"));
        bds.setPassword(properties.getProperty("dbcp.jdbc.password"));
        bds.setDriverClassName(properties.getProperty("dbcp.jdbc.driver"));
        bds.setUrl(properties.getProperty("dbcp.jdbc.url"));
        return bds;
    }
}
