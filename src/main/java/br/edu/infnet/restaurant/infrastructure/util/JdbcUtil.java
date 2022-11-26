package br.edu.infnet.restaurant.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

    public static Connection getConnection() {
        logger.info("Trying connection with database");
        String password = "root";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/infnetRestaurantJDBC?createDatabaseIfNotExist=true";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error("Error to connect in database", e);
            throw new RuntimeException(e);
        }
    }
}
